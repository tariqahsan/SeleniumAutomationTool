package mil.dtic.selenium;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeywordFunctions {

	final static Logger logger = Logger.getLogger(KeywordFunctions.class);
	private Result result;
	private WebDriver driver;

	public KeywordFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public Result runTest(TestStepInputs testStepInputs)
			throws NumberFormatException, InterruptedException {
		String keyword = testStepInputs.getTestStepsKeyword();
		String inputValue = testStepInputs.getInputValue();
		String webElement = testStepInputs.getWebElement();
		String webElementValue = testStepInputs.getWebElementValue();
		
		logger.info("keyword: " +  keyword + " inputValue: " + inputValue + " webElementValue:  " + webElementValue);
		result = new Result();
		if (keyword.equalsIgnoreCase("Click")) {
			
			try {
				
				logger.info("In keyword: " +  keyword + " inputValue: " + inputValue + " webElementValue:  " + webElementValue);
				runDriver(webElement, webElementValue).click();
				logger.info("Click is performed sucessfully");
				result.setMessage("Click is performed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Click operation was not done successfully : " + e.getMessage());
				result.setMessage("Click operation was not done successfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("DoubleClick")) {
			
			try {
				
				logger.info("In keyword: " +  keyword + " inputValue: " + inputValue + " webElementValue:  " + webElementValue);		
				Actions actions = new Actions(driver);
				WebElement elementLocator = runDriver( webElement,webElementValue);
				actions.doubleClick(elementLocator).perform();
				logger.info("Double Click is performed sucessfully");
				result.setMessage("Double Click is performed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Double Click operation was not done successfully : " + e.getMessage());
				result.setMessage("Double Click operation was not done successfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("RightClick")) {
			
			try {
				
				logger.info("In keyword: " +  keyword + " inputValue: " + inputValue + " webElementValue:  " + webElementValue);		
				Actions actions = new Actions(driver);
				WebElement elementLocator = runDriver( webElement,webElementValue);
				actions.contextClick(elementLocator).perform();
				logger.info("Double Click is performed sucessfully");
				result.setMessage("Double Click is performed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Double Click operation was not done successfully : " + e.getMessage());
				result.setMessage("Double Click operation was not done successfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("Input")) {
			try {
				logger.info("In keyword: " +  keyword + " inputValue: " + inputValue + " webElementValue:  " + webElementValue);
				runDriver(webElement, webElementValue).clear();
				runDriver(webElement, webElementValue).sendKeys(inputValue);
				logger.info("Input is performed sucessfully");
				result.setMessage("Input is performed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Not able to enter input : " + e.getMessage());
				result.setMessage("Not able to enter input");
				result.setResult(false);
			}
			return result;
			
		} else if (keyword.equalsIgnoreCase("dropdown")) {
			try {
				Select dropDown = new Select(runDriver(webElement, webElementValue));
				logger.info(webElement + " " + webElementValue);
				logger.info(inputValue);
				//dropDown.selectByVisibleText(inputValue);
				System.out.println("Input Value --> <" + inputValue + ">");
				dropDown.selectByValue(inputValue);
				result.setMessage("dropdown selection was done successfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("dropdown selection was not done successfully : " + e.getMessage());
				result.setMessage("dropdown selection was not done successfully");
				result.setResult(false);
			}
			return result;

		} else if (keyword.equalsIgnoreCase("dropdownValueNotVisible")) {
			try {
				Select dropDown = new Select(runDriver(webElement, webElementValue));
				logger.info(webElement + " " + webElementValue);
				logger.info(inputValue);
				dropDown.selectByVisibleText(inputValue);
				result.setMessage("dropdown selection was done successfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("dropdown selection was not done successfully : " + e.getMessage());
				result.setMessage("dropdown selection was not done successfully");
				result.setResult(false);
			}
			return result;

		} else if (keyword.equalsIgnoreCase("partialLink")) {		
			try {
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Actions actions = new Actions(driver);
	
				WebElement expRadioBtn = runDriver(webElement, webElementValue);
				actions.moveToElement(expRadioBtn).click().build().perform();
				logger.info("The URL is ... " + driver.getCurrentUrl());
				
				result.setMessage("partial link selection was done successfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("partial link selection was not done successfully : " + e.getMessage());
				result.setMessage("partial link selection was not done successfully");
				result.setResult(false);
			}
			return result;
			
		} else if (keyword.equalsIgnoreCase("partialLinkCompare")) {		
			try {
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Actions actions = new Actions(driver);
	
				WebElement expRadioBtn = runDriver(webElement, webElementValue);
				actions.moveToElement(expRadioBtn).click().build().perform();
				logger.info("The URL is ... <" + inputValue + ">");
				logger.info("The URL is ... <" + driver.getCurrentUrl()+ ">");		
				
				if (driver.getCurrentUrl().equalsIgnoreCase(inputValue)) {
					
					result.setMessage("partial link selection was done successfully and the url links matches");
					result.setResult(true);	
					
				} else {
					
					result.setMessage("URL link compare with input value does not match");
					result.setResult(false);
				}
				
			} catch (Exception e) {
				logger.error("partial link selection and compare was not done successfully : " + e.getMessage());
				result.setMessage("partial link selection and compare was not done successfully");
				result.setResult(false);
			}
			return result;
			
		} else if (keyword.equalsIgnoreCase("radio")) {		
			try {
				// To prevent the error occuring during execution - 
				// unknown error: Element <input id="exp-1" name="exp" type="radio" inputValue="2"> is not clickable at point (277, 660)...
				// The remedy to the above problem found in the YouTube video - https://www.youtube.com/watch?v=XNwcGNLk3cE
				// titled - How to Handle Element is Not Clickable at Point Exception in Selenium Webdriver.
				// According to the video it's been suggested to use - org.openqa.selenium.interactions.Actions class methods
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Actions actions = new Actions(driver);
	
				//WebElement expRadioBtn = driver.findElement(By.id(webElementValue));
				WebElement expRadioBtn = runDriver(webElement, webElementValue);
				// Checking if the Male Radio button is displayed on the Webpage and printing the status
				boolean radioBtnIsDisplayed = expRadioBtn.isDisplayed();
				logger.info("Is Exp radio button displayed: " + radioBtnIsDisplayed);
	
				// Checking if the Male Radio button is enabled on the webpage and printing the status
				boolean radioBtnIsEnabled = expRadioBtn.isEnabled();
				logger.info("Is Exp radio button enabled: " + radioBtnIsEnabled);
	
				// Checking the default radio button selection status
				boolean radioBtnIsSelected = expRadioBtn.isSelected();
	
				logger.info("Default Radio button selection Status: " + radioBtnIsSelected);
				
				// Selecting Exp (Experience) radio button
	
				// expRadioBtn.click(); // Commented out to execute the click function in the way below
				// Using expRadioBtn wrapped around Actions.moveToElement to prevent the error mentioned above
				actions.moveToElement(expRadioBtn).click().build().perform();
				
				// Re-checking the male radio button selection status and printing it..
				boolean radioBtnNewSelectionStatus = expRadioBtn.isSelected();
				logger.info("Experience radio Selection status after perform click() event: " + radioBtnNewSelectionStatus);
				
				result.setMessage("radio button selection was done successfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("radio button selection was not done successfully : " + e.getMessage());
				result.setMessage("radio button selection was not done successfully");
				result.setResult(false);
			}
			return result;
			
		} else if (keyword.equalsIgnoreCase("upload")) {
			try {
				logger.info("in upload file ...");
				runDriver(webElement, webElementValue).sendKeys(System.getProperty("user.dir") + inputValue);
				//driver.findElement(By.id(webElementValue)).sendKeys(System.getProperty("user.dir") + inputValue);
				logger.info("upload is performed sucessfully ...");
				logger.info("upload is performed sucessfully");
				result.setMessage("upload is performed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Not able to upload file : " + e.getMessage());
				result.setMessage("Not able to upload file");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("gettext")) {
			try {
				
				//driver.findElement(By.xpath(webElementValue)).getText();
				runDriver(webElement, webElementValue).getText();
				logger.info("getText is performed sucessfully");
				result.setMessage("getText is performed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("getText is not performed sucessfully : " + e.getMessage());
				result.setMessage("getText is not performed sucessfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("url")) {
			try {
				driver.get(inputValue);  // 
				logger.info("Url is opened sucessfully");
				result.setMessage("Url is opened sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Url could not opened sucessfully : " + e.getMessage());
				result.setMessage("Url could not opened sucessfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("CloseBrowser")) {
			try {
				driver.quit();
				logger.info("Browser is closed sucessfully");
				result.setMessage("Browser is closed sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Browser is not been closed sucessfully : " + e.getMessage());
				result.setMessage("Browser is not been closed sucessfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("sleep")) {
			try {
				if (inputValue.equalsIgnoreCase("level1")) {
					Thread.sleep(3000);
				} else if (inputValue.equalsIgnoreCase("level2")) {
					Thread.sleep(7000);
				} else if (inputValue.equalsIgnoreCase("level3")) {
					Thread.sleep(15000);
				} else if (inputValue.equalsIgnoreCase("level4")) {
					Thread.sleep(20000);
				} else if (inputValue.equalsIgnoreCase("level4")) {
					Thread.sleep(25000);
				} else {
					Thread.sleep(5000);
				}
				
				logger.info("sleep is done sucessfully");
				result.setMessage("sleep is done sucessfully");
				result.setResult(true);
			} catch (Exception e) {
				logger.error("Not able to do sleep successfully : " + e.getMessage());
				result.setMessage("Not able to do sleep successfully");
				result.setResult(false);
			}
			return result;
		} else if (keyword.equalsIgnoreCase("VerifyText")) {

			if (inputValue.equalsIgnoreCase(runDriver(webElement, webElementValue).getText())) {
				logger.info("Verify text successful");
				result.setMessage("Verify text successful");
				result.setResult(true);
			} else {
				logger.info("Verify text failed");
				result.setMessage("Verify text failed");
				result.setResult(false);
			}
			return result;

		} else if (keyword.equalsIgnoreCase("Pop")) {
			// Do nothing
			driver.switchTo().alert().accept();
		}
		
		result.setMessage("Done");
		result.setResult(false);
		return result;
	}
	
	public WebElement runDriver(String webElement, String webElementValue) {
		
		long waitTime = 30;
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		
		switch(webElement) {
        case "id" :
           logger.info("Web Element is an - > id");
           logger.info("Now waiting for 30 ..."); 
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.id(webElementValue)));
		   logger.info("Found the element, moving on ..."); 
           return driver.findElement(By.id(webElementValue));      
        case "css":
			logger.info("Web Element is an - > css"); 
			// Wait 	
			logger.info("Now waiting for 30 ..."); 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(webElementValue)));
			logger.info("Found the element, moving on ..."); 
			return driver.findElement(By.cssSelector(webElementValue));		
        case "xpath":
        	logger.info("Web Element is an - > xpath");
        	logger.info("Now waiting for 30 ..."); 
  		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElementValue)));
  		    logger.info("Found the element, moving on ..."); 
        	return driver.findElement(By.xpath(webElementValue));
        case "name" :
       	 	logger.info("Web Element is an - > name");
        	logger.info("Now waiting for 30 ..."); 
  		    wait.until(ExpectedConditions.presenceOfElementLocated(By.name(webElementValue)));
  		    logger.info("Found the element, moving on ..."); 
       	 	return driver.findElement(By.name(webElementValue));
        case "class" :
       	 	logger.info("Web Element is an - > className");
        	logger.info("Now waiting for 30 ..."); 
  		    wait.until(ExpectedConditions.presenceOfElementLocated(By.className(webElementValue)));
  		    logger.info("Found the element, moving on ..."); 
       	 	return driver.findElement(By.className(webElementValue));
        case "link" :
       	 	logger.info("Web Element is an - > partialLink and the webElementValue is -> " + webElementValue);
        	logger.info("Now waiting for 30 ..."); 
  		    wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(webElementValue)));
  		    logger.info("Found the element, moving on ..."); 
       	 	return driver.findElement(By.partialLinkText(webElementValue));
        default :
           logger.info("Invalid web element");
     }
		return null;
	}

}
