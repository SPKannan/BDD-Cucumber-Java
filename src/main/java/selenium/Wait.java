package selenium;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigFileReader;


public class Wait {
	private static long implicittime;

	private WebDriver driver;

	private long pollingEveryInMilliSec;
	public Wait(WebDriver driver) {
		this.driver=driver;
		ConfigFileReader configFileReader=new ConfigFileReader();
		implicittime=configFileReader.getImplicitlyWait();
		pollingEveryInMilliSec=configFileReader.getPollingMilliSec();
	}
	
	
	private WebDriverWait getWait(long implicittime2,long pollingEveryInMilliSec2) {
		WebDriverWait wait = new WebDriverWait(driver, implicittime2);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void waitForElementVisible(WebElement element) {
		WebDriverWait wait = getWait(implicittime, pollingEveryInMilliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		setImplicitWait(implicittime, TimeUnit.SECONDS);
	}
	
	public void waitForElementInVisible(WebElement element) {
		WebDriverWait wait = getWait(implicittime, pollingEveryInMilliSec);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.invisibilityOf(element));
		setImplicitWait(implicittime, TimeUnit.SECONDS);
	}
	
	public void setImplicitWait(long timeout,TimeUnit unit) {
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
}