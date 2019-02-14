package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import selenium.Wait;

public class Summarycart_Page {

	private WebDriver driver;

	private Wait wait;
	public Summarycart_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		wait = new Wait(driver);
	} 

	@FindBy(how=How.ID, using="layer_cart")
	public static WebElement summarycart;
	
	@FindBy(how=How.ID, using="layer_cart_product_title")
	public static WebElement producttitle;

	@FindBy(how=How.ID, using="layer_cart_product_attributes")
	public static WebElement productattributes;
	
	@FindBy(how=How.ID, using="layer_cart_product_quantity")
	public static WebElement productquantity;
	
	@FindBy(how=How.XPATH, using="//*[@id='layer_cart']//span")
	public static WebElement close;
	
	public String  getcartproducttitle() {
		wait.waitForElementVisible(summarycart);
		return producttitle.getText();
		
	}
	public String  getcartproductattributes() {
		String[] color = productattributes.getText().split(",");
		return color[0].toString().trim();
	}
	public String  getcartproductquantity() {		
		return productquantity.getText();		
	}
	
	public void close_summarycart() {
		close.click();
		
	}

}
