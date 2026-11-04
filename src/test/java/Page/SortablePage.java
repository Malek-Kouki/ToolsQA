package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortablePage {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public SortablePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.action = new Actions(driver);
	}

	private final By menuList = By.cssSelector("#demo-tab-list");
	
	private final By menuGrid = By.cssSelector("#demo-tab-grid");
	
	public boolean isListDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(menuList)).isDisplayed();
	}

	public boolean isGridDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(menuGrid)).isDisplayed();
	}
	
	public boolean isOngletListActive() {
		// Lire la valeur de class
		String classValue = driver.findElement(menuList).getAttribute("class");
		// Vérifier si la class contient "active"
		return classValue.contains("active");
	}
	
	private final By elementOne = By.xpath("(//div[normalize-space()='One'])[1]");
	
	private final By elementTwo = By.xpath("(//div[normalize-space()='Two'])[1]");
	
	private final By elementThree = By.xpath("(//div[normalize-space()='Three'])[1]");
	
	private final By elementFour = By.xpath("(//div[normalize-space()='Four'])[1]");
	
	private final By elementFive = By.xpath("(//div[normalize-space()='Five'])[1]");
	
	private final By elementSix = By.xpath("(//div[normalize-space()='Six'])[1]");
	
	public boolean isOneDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementOne)).isDisplayed();
	}
	
	public boolean isTwoDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementTwo)).isDisplayed();
	}
	
	public boolean isThreeDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementThree)).isDisplayed();
	}
	
	public boolean isFourDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementFour)).isDisplayed();
	}
	
	public boolean isFiveDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementFive)).isDisplayed();
	}
	
	public boolean isSixDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementSix)).isDisplayed();
	}
	
	public void clickToElement() {
		WebElement webElementThree = driver.findElement(By.xpath("(//div[normalize-space()='Three'])[1]"));
		// clickAndHold c'est une fonction qui prend en parametre une variable de type webElement
		// clickAndHold prépare l'action (je click et je maintien sur l'élément Three)
		//perform pour exécuter l'action de clickAndHold
		action.clickAndHold(webElementThree).perform();
	}
	
	public void elementThreeEnSurbreillance() {
		WebElement webElementThree = driver.findElement(By.xpath("(//div[normalize-space()='Three'])[1]"));
		String couleurElementSelectionne = webElementThree.getCssValue("Background-color");
		System.out.print("la couleur de l'élément sélectionné est" + couleurElementSelectionne);
		String couleurAttendu = "rgba(233.236.239.1)";
		couleurElementSelectionne.equals(couleurAttendu);
	}
	
	public void dragAndDropElement() {
		WebElement webElementOne = driver.findElement(By.xpath("(//div[normalize-space()='One'])[1]"));
		WebElement webElementThree = driver.findElement(By.xpath("(//div[normalize-space()='Three'])[1]"));
		action.dragAndDrop(webElementThree, webElementOne).perform();
	}
	
	public void dragAndDropSeconMethod() {
		WebElement webElementOne = driver.findElement(By.xpath("(//div[normalize-space()='One'])[1]"));
		WebElement webElementThree = driver.findElement(By.xpath("(//div[normalize-space()='Three'])[1]"));
		action.clickAndHold(webElementThree).pause(Duration.ofSeconds(6)).moveToElement(webElementOne).pause(Duration.ofSeconds(6)).release().pause(Duration.ofSeconds(6)).perform();
	}
	
	public void relacherElement() {
		action.release().perform();
	}
	
	public String verifierTextPositonOne() {
		WebElement firstPosition = driver.findElement(By.xpath("(//div[contains(@class,'list-group')]//div[contains(@class,'list-group-item list-group-item-action')])[1]"));
		String firstPositionValue = firstPosition.getText();
		return firstPositionValue;
	}
	
}
