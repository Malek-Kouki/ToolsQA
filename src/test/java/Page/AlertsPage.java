package Page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public AlertsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By clickMe = By.xpath("(//button[@class='btn btn-primary'])[1]");
	
	public void clickToBoutton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickMe)).click();
	}
	
	public Alert checkAlert() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
