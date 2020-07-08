package com.qa.orient.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsonBase {
	
	public  WebDriver driver;
	public  JSONParser jsonParser ;
	public  JSONObject jsonObj;
	
	
	
	public JSONObject readDataFromJSON(){
		
		 jsonParser = new JSONParser();
		FileReader reader;
		try {
			reader = new FileReader("./src/main/java/com/qa/orient/testData/TestData.json");
			System.out.println(reader);
			//Read JSON file
			Object obj = jsonParser.parse(reader);
			
			 //jsonObj = new JSONObject();
			 jsonObj = (JSONObject)obj ;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
	
			e.printStackTrace();
		}
		//System.out.println(jsonObj);
		System.out.println(jsonObj.get("HeadLessMood"));
		
		return jsonObj;
	}
	
	
	
	
	public  WebDriver initializedriver(JSONObject jsonObject) {
		//String browserName = prop.getProperty("webdriver.browser");
		String browserName =  (String) jsonObject.get("BrowserName");
		//System.out.println("Browser: "+jsonObj.get("HeadLessMood"));
		
		System.out.println(browserName);
			
		if(browserName.equalsIgnoreCase("chrome")) {
		//System.setProperty("webdriver.gecko.driver", "D:\\webDriver\\geckodriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
				
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		//System.setProperty("webdriver.gecko.driver", "D:\\webDriver\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
		//System.setProperty("webdriver.edge.driver", "D:\\webDriver\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.Time_Load_TimeOut, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_wait, TimeUnit.SECONDS);
			
		//driver.get(prop.getProperty("orient.url"));
		driver.get((String) jsonObj.get("URL"));
		
		return driver;
		
		}

}
