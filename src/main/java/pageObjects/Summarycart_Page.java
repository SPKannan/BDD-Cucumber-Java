package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Summarycart_Page {


	public Summarycart_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	} 

	@FindBy(how=How.ID, using="layer_cart_product_title")
	public static WebElement producttitle;

	@FindBy(how=How.ID, using="layer_cart_product_attributes")
	public static WebElement productattributes;
	
	@FindBy(how=How.ID, using="layer_cart_product_quantity")
	public static WebElement productquantity;
	
	@FindBy(how=How.XPATH, using="//*[@id='layer_cart']//span")
	public static WebElement close;
	
	public String  getcartproducttitle() {
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
