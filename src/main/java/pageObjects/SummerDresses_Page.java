package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class SummerDresses_Page {
	
	private WebDriver driver;
	public SummerDresses_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}  
	
	@FindBy(how=How.CLASS_NAME, using="cat-name")
	public static WebElement category_name;
	
	@FindBy(how=How.ID, using="selectProductSort")
	public static WebElement drpdwn_sort_by;
	
	@FindBy(how=How.ID, using="color_20")
	public static WebElement color_blue;
	
	@FindBy(how=How.XPATH, using="//*[@id='center_column']/ul/li/div/div[2]/div[1]/span[1]")
	public static List<WebElement> product_price;
	
	public static class selecteddress 
	{
		@FindBy(how=How.XPATH, using="//*[@id='center_column']//h1")
		public static WebElement selectedProductname;
		
		@FindBy(how=How.ID, using="our_price_display")
		public static WebElement selectedProductprice;
		
		@FindBy(how=How.ID, using="quantity_wanted")
		public static WebElement selectedProductqtywanted;
	}
	
	
	public String getDressCategoryName() {
		String text=category_name.getText();
		return text;
	}
	
	public void sort_by_value(String str_drpdwn_value) {
		Select drpdwn= new Select(drpdwn_sort_by);
		drpdwn.selectByVisibleText((str_drpdwn_value));
	}
	
	public void click_on_blue_color() {
		Actions actions = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", color_blue);
		actions.moveToElement(color_blue).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", color_blue);
//		actions.moveToElement(color_blue).click().perform();
		color_blue.click();
	}
	
	public ArrayList<String> getProductPrice() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> obtainedList = new ArrayList<>(); 
		for(WebElement we:product_price){//PrintedSummerDress1.product_price
		   obtainedList.add(we.getText());
		}
		
		 return obtainedList;
	}
	
	public ArrayList<String> getProductPriceAfterSorting(ArrayList<String> pP) {
		
		ArrayList<String> sortedList = new ArrayList<>();   
		for(String s:pP){
		sortedList.add(s);
		}
//		Collections.reverse(sortedList);
		Collections.sort(sortedList);
		return sortedList;
	}
	
	
}
