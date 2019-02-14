package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.Wait;

public class SelectedDress_Page {
	private WebDriver driver;
	private Wait wait;
	public SelectedDress_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		wait = new Wait(driver);
	}  
	
	@FindBy(how=How.XPATH, using="//*[@id='center_column']//h1")
	public static WebElement selectedProductname;
	
	@FindBy(how=How.ID, using="our_price_display")
	public static WebElement selectedProductprice;
	
	@FindBy(how=How.ID, using="quantity_wanted")
	public static WebElement selectedProductqtywanted;
	
	@FindBy(how=How.XPATH, using="//*[@id='color_to_pick_list']//li[@class='selected']/a")
	public static WebElement defaultselectedcolor;
	
	@FindBy(how=How.NAME, using="Submit")
	public static WebElement addtocart;
	
	public String  getselectedProductname() {
		return selectedProductname.getText();
		
	}
	public String  getselectedProductqtywanted() {
		return selectedProductqtywanted.getAttribute("value");
		
	}
	public String  getdefaultselectedcolor() {		
		return defaultselectedcolor.getAttribute("title");		
	}
	
	public void  click_add_to_cart() {		
		addtocart.click();
	}
	
}
