package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InterractionPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public InterractionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	private final By menuSortable = By.xpath("//a[normalize-space()='Sortable']");
	
	public void clickToMenuSortable() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuSortable)).click();
	}
}
