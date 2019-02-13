package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Home_Page;
import pageObjects.SelectedDress_Page;
import pageObjects.Summarycart_Page;
import pageObjects.SummerDresses_Page;
import runtimeData.ScenarioContext;
import runtimeData.ScenarioContext.runtime_testdata_key;

public class Summarycart {
	public WebDriver driver;
	Home_Page homepage;
	SummerDresses_Page SummerDressespage;
	SelectedDress_Page SelectedDresspage;
	Summarycart_Page SummarycartPage;
	ScenarioContext scenarioContext;

	String winHandleBefore;

	public Summarycart() {
		driver = Hooks.driver;
		homepage = new Home_Page(driver);
		SummerDressespage = new SummerDresses_Page(driver);
		SelectedDresspage = new SelectedDress_Page(driver);
		SummarycartPage=new Summarycart_Page(driver);
		scenarioContext = new ScenarioContext();
	}

	@Then("Select the \"(.*)\" color")
	public void select_the_color(String string) {
		SummerDressespage.click_on_blue_color();
	}

	@Then("Store the productname color and quantity")
	public void store_the_productname_color_and_quantity() {
		scenarioContext.setContext(runtime_testdata_key.PRODUCT_NAME, SelectedDresspage.getselectedProductname());
		scenarioContext.setContext(runtime_testdata_key.PRODUCT_COLOR, SelectedDresspage.getdefaultselectedcolor());
		scenarioContext.setContext(runtime_testdata_key.PRODUCT_QTY,SelectedDresspage.getselectedProductqtywanted());

		System.out.println("PRODUCT_NAME -"+scenarioContext.getContext(runtime_testdata_key.PRODUCT_NAME));
		System.out.println("PRODUCT_COLOR -"+scenarioContext.getContext(runtime_testdata_key.PRODUCT_COLOR));
		System.out.println("PRODUCT_QTY -"+scenarioContext.getContext(runtime_testdata_key.PRODUCT_QTY));
	}

	@When("I click on Add to cart")
	public void i_click_on_Add_to_cart() {
		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		SelectedDresspage.click_add_to_cart();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I verify same productname color and quantity displayed in Cart Summary page")
	public void i_verify_same_productname_color_and_quantity_displayed_in_Cart_Summary_page() {

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			System.out.println("winHandle "+winHandle);
			driver.switchTo().window(winHandle);
		}

		// Perform the actions on new window
		assertEquals(SummarycartPage.getcartproducttitle(),scenarioContext.getContext(runtime_testdata_key.PRODUCT_NAME));
		assertEquals(SummarycartPage.getcartproductattributes(),scenarioContext.getContext(runtime_testdata_key.PRODUCT_COLOR));
		assertEquals(SummarycartPage.getcartproductquantity(),scenarioContext.getContext(runtime_testdata_key.PRODUCT_QTY));
		// Close the new window, if that window no more required
		SummarycartPage.close_summarycart();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);


	}

}
