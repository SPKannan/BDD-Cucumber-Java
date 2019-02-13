package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;


public class Registration_Page {
	private WebDriver driver;
	public Registration_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(how = How.ID, using = "email_create")
	public WebElement email_address;
	
	@FindBy(how = How.ID, using = "SubmitCreate")
	public WebElement SubmitCreate;
	
	@FindBy(how = How.XPATH, using = "//*[@id='create_account_error']/ol/li")
	public WebElement create_account_error;
	
	@FindBy(how = How.ID, using = "customer_firstname")
	public WebElement txt_customer_firstname;
	
	@FindBy(how = How.ID, using = "customer_lastname")
	public WebElement txt_customer_lastname;
	
	@FindBy(how = How.ID, using = "email")
	public WebElement txt_email;
	
	@FindBy(how = How.ID, using = "passwd")
	public WebElement txt_password;
	
	
	@FindBy(how = How.ID, using = "firstname")
	public WebElement txt_firstname;
	
	@FindBy(how = How.ID, using = "lastname")
	public WebElement txt_lastname;
	
	@FindBy(how = How.ID, using = "address1")
	public WebElement txt_address1;
	
	@FindBy(how = How.ID, using = "city")
	public WebElement txt_city;
	
	@FindBy(how = How.ID, using = "postcode")
	public WebElement txt_postcode;
	
	@FindBy(how = How.ID, using = "phone_mobile")
	public WebElement txt_phone_mobile;
	
	@FindBy(how = How.ID, using = "submitAccount")
	public WebElement btn_Register;
	
	@FindBy(how = How.ID, using = "id_state")
	public WebElement drpdwn_state;
	
	@FindBy(how = How.ID, using = "id_country")
	public WebElement drpdwn_country;
	
	@FindBy(how = How.XPATH, using = "//*[@class='header_user_info']/a/span")
	public WebElement customeraccount;
	
	public void enter_email_address(String emailaddress) {
		email_address.sendKeys(emailaddress);
	}
	
	public void Click_Create_an_account() {
		SubmitCreate.click();
	}
	
	public void Register() {
		btn_Register.click();
	}
	
	
	public String get_create_account_err_message() {
		String text=create_account_error.getText();
		System.out.println("Error Message Displayd as :"+ text);
		return text;
	}
	
	public void select_state(String string) {
		Select drpdwn= new Select(drpdwn_state);
		drpdwn.selectByVisibleText((string));
	}
}