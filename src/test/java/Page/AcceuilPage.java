package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcceuilPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public AcceuilPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By menuAlerte = By.cssSelector("a[href='/alertsWindows']");
	private final By menuInterraction = By.cssSelector("a[href='/interaction']");

	
	public boolean isMenuAlerteFrameWindowDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(menuAlerte)).isDisplayed();
	}
	
	public void clickToAlertFrameWindow() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuAlerte)).click();
	}
		
	public void clickToInterraction() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuInterraction)).click();
	}
}
