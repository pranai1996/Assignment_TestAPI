package com.test.base;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.util.APIHelpers;
import com.test.util.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This page class is intended to have the base setup for UI automation framework 
 * consists of browser launch and capabilities setup for UI
 * base Selenium driver initializations
 * 
 * @return null
 */

public class BaseSetup {
	public static WebDriver driver;
	public static Properties prop = null;
	public static String TestRunURL="";
    public static String BearerToken = "";
   
    public static String ExecutionType;
    public static String executionMode;
    public static String seleniumGridHub;
	
    public static Utilities utilities = new Utilities();
    
    public static APIHelpers apiHelpers = new APIHelpers();
    
	public static void baseConfigurationSetup() throws IOException
	{		prop= utilities.readPropertiesFile("TestData.properties");
	}

}
