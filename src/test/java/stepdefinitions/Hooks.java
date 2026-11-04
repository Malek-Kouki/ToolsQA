package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static WebDriver driver;

    private static ExtentReports extent;
    public static ExtentTest test;

    //Url de l'application
    private static final String baseUrl = "https://demoqa.com/";
    // Chemin du rapport
    private static final String reportDir =
            System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "custom-report";

    //Parmetre du rapport
    private static void initReportOnce() {
        if (extent != null) return;

        new File(reportDir).mkdirs();

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
                reportDir + File.separator + "Execution Results - " + timestamp + ".html"
        );
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

     
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (extent != null) extent.flush();
        }));
    }

    // Pour lancer le driver
    @Before
    public void beforeScenario(Scenario scenario) {
        initReportOnce();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get(baseUrl);

        test = extent.createTest(scenario.getName());
    }

    // Screenshot si cas de test Failed / Ou Passed dans le rapport + état d'exécution
    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            test.fail("FAILED: " + scenario.getName());
            String path = takeScreenshot(scenario.getName());
            test.addScreenCaptureFromPath(path);
        } else {
            test.pass("PASSED: " + scenario.getName());
        }

        if (driver != null) driver.quit();
    }

    private static String takeScreenshot(String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destination = reportDir + File.separator + screenshotName + "_" + dateName + ".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;
    }
}
