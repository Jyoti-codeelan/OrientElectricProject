package com.qa.orient.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.orient.page.LoginPage;
import com.qa.orient.utils.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static Logger log= Logger.getLogger(BasePage.class.getName());
	public WebDriver driver;
	public Properties prop;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
public WebDriver initialize_driver(Properties prop) {
		
		
		log.info("driver intialize..........");
		String browserName = prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();

			log.info("Lunch Chrome Browser...........");
			//driver = new ChromeDriver();
			tldriver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			log.info("Lunch Firefox Browser...........");
			//driver=new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
			
		}
		else {
			System.out.println("Browser"+browserName+"is not defined in properites file,please give "
					+ "the correct browse nane");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("orient.url"));
		//TimeUtil.mediumWait();
		return getDriver();
	}




	public Properties  initializes_Properties() {
		log.info("properties intilizes.......");
		prop=new Properties();
		
			try {
	log.info("read prop file");			
	FileInputStream fip = new FileInputStream("src/main/java/com/qa/orient/properties/configurations.properties");
				
	prop.load(fip);
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
		
				e.printStackTrace();
			}
			return prop;
       }
	
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		}
		catch(IOException e) {
			
			System.out.println("Capture Failed"+e.getMessage());
		}
		
		return path;
	}
}
