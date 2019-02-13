package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Home_Page;
import pageObjects.SummerDresses_Page;
import runtimeData.ScenarioContext;
import runtimeData.ScenarioContext.runtime_testdata_key;

public class sorting {
	public WebDriver driver;
	Home_Page homepage;
	SummerDresses_Page SummerDressespage;
	ScenarioContext scenarioContext;

	public sorting() {
		driver = Hooks.driver;
		homepage = new Home_Page(driver);
		SummerDressespage = new SummerDresses_Page(driver);
		scenarioContext = new ScenarioContext();

	}

	@Given("^I am on the \"(.*)\" page$")
	public void i_am_on_the_page(String string) {
		Assert.assertEquals(string,homepage.getbrowserTitle());
	}

	@When("^I click on \"(.*)\" menu$")
	public void i_click_on_the_page(String string) {
		homepage.Click_summerdresses_Link();
	}

	@Then("^I should see \"(.*)\" page$")
	public void i_should_see_page(String string) {
		String CategoryName = SummerDressespage.getDressCategoryName();
		assertEquals(string.trim(), CategoryName.trim());
	}

	@When("^I select sort by \"(.*)\" and store the product price$")
	public void i_select_sort_by(String string) {
		scenarioContext.setContext(runtime_testdata_key.PRODUCT_PRICE, SummerDressespage.getProductPrice());
		SummerDressespage.sort_by_value(string);
		
	}

	@Then("^Verify grid is in selected \"(.*)\" order$")
	public void verify_grid_is_in_selected_order(String string) {		
		ArrayList<String> PP = (ArrayList<String>) scenarioContext.getContext(runtime_testdata_key.PRODUCT_PRICE);
		Assert.assertEquals(SummerDressespage.getProductPriceAfterSorting(PP), SummerDressespage.getProductPrice());
	}

}
