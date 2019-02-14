package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.Wait;

public class Home_Page {

	private WebDriver driver;

	private Wait wait;
	
	public Home_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		wait = new Wait(driver);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "login")
	public WebElement lnk_SignIn;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	public  WebElement menu_dresses;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
	public  WebElement summer_dresses;
	
	public void Click_SignIn_Link() {
		lnk_SignIn.click();
	}
	
	public String getbrowserTitle() {
		return driver.getTitle();
		
	}
	
	public void Click_summerdresses_Link() {
		Actions action = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", menu_dresses);
		action.moveToElement(menu_dresses).perform();
		wait.waitForElementVisible(summer_dresses);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", summer_dresses);
		action.moveToElement(summer_dresses).click().perform();
	}

}
