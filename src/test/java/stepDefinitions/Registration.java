package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Home_Page;
import pageObjects.Registration_Page;

public class Registration {
	public WebDriver driver;
	Home_Page homepage;
	Registration_Page registrationpage;
	
	public Registration()
	{
		driver = Hooks.driver;
		homepage = new Home_Page(driver) ;
		registrationpage = new Registration_Page(driver) ;
	}

	@Given("^I am on the register an account page$")
	public void i_am_on_the_register_an_account_page() {
		homepage.Click_SignIn_Link();
	}

	@Given("^I click the link create an account with email address \"(.*)\"$")
	public void i_click_the_link_create_an_account_with_email_address(String string) throws InterruptedException {
		System.out.println("Email Address from Parameter :"+string);
		registrationpage.enter_email_address(string);
		registrationpage.Click_Create_an_account();
		
	}

	@Then("^An error message \"(.*)\" will appear on the page$")
	public void an_error_message_Invalid_email_address_will_appear_on_the_page(String string) {
		System.out.println("error message from Parameter :"+string);
		 assertEquals(string,registrationpage.get_create_account_err_message());
	}
	
	@Then("^I enter personal information \"(.*)\" \"(.*)\" \"(.*)\"$")
	public void i_enter_personal_information(String string, String string2, String string3)	{ 
		registrationpage.txt_customer_firstname.sendKeys(string);
		registrationpage.txt_customer_lastname.sendKeys(string2);
		registrationpage.txt_password.sendKeys(string3);
	}
	
	@Then("^I enter address contact information \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
	public void i_enter_address_contact_information(String string, String string2, String string3, String string4, String string5, String string6, String string7) {                                                                                    
		/*registrationpage.txt_firstname.sendKeys(string);
		registrationpage.txt_lastname.sendKeys(string2);*/
		registrationpage.txt_address1.sendKeys(string3);
		registrationpage.txt_city.sendKeys(string4);
		registrationpage.select_state(string5);
		registrationpage.txt_postcode.sendKeys(string6);
		registrationpage.txt_phone_mobile.sendKeys(string7);
	} 
	
	@When("^I click on \"(.*)\"$")                                             
	public void i_click_on(String string) {
		registrationpage.Register();
	}  
	
	@Then("^Validate \"(.*)\" \"(.*)\"$")                                      
	public void validate(String string, String string2) {
		assertEquals(string+" "+ string2,registrationpage.customeraccount.getText());
	}    
}
