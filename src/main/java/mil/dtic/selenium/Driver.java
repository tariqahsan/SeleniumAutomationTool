package mil.dtic.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	final static Logger logger = Logger.getLogger(Driver.class);
	WebDriver driver;
	ConfigFileReader configFileReader;

	public WebDriver InitateDriver() throws InterruptedException
	{

		logger.info("Now opening Browser");

		configFileReader = new ConfigFileReader();
		logger.info("Configuration File Reader : Browser -> " + configFileReader.getBrowser());
		logger.info("Configuration File Reader : Driver Path -> " + configFileReader.getDriverPath());
		logger.info("Configuration File Reader : Driver Path -> " + configFileReader.getDriverPath());

		if(configFileReader.getBrowser().equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath());
			driver = new FirefoxDriver();
			logger.info("Mozilla browser started");				
		}
		else if(configFileReader.getBrowser().equalsIgnoreCase("IE")) {
			logger.info("In IE ...");
			System.setProperty("webdriver.ie.driver", configFileReader.getDriverPath());
			driver = new InternetExplorerDriver();
			logger.info("IE browser started");
		}
		else if(configFileReader.getBrowser().equalsIgnoreCase("Chrome")) {
			logger.info("In Chrome ...");
			// Setup the chromedriver using WebDriverManager instead of using System.setProperty
			//WebDriverManager.chromedriver().setup();

			//WebDriverManager.chromedriver().version("76.0.3809.126").setup();
			// Create driver object for Chrome
			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());

			ChromeOptions options = new ChromeOptions();
			logger.info("Setting Chrome driver ...");
			// When run script from Linux terminal tunnel, like run by Jenkins. In general, Linux terminal tunnel not have display screen, 
			// but run script with headful model require a physical or virtual display. Run with headless model when not setup virtual 
			// display by xWindow/xvbf
			//options.addArguments("headless"); // Set headless to run from Jenkins
			options.addArguments("start-maximized"); // Don't maximize Chrome, because has no display if running from Jenkins
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			logger.info("Chrome browser started");

		}

		int implicitWaitTime=(configFileReader.getDriverImplicitWaitTime());
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		logger.info("Wait time is -> " + implicitWaitTime);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}


}
