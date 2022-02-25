package org.base1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public static WebDriver driver;
public static void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
}
public static  void firefox() {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();

}
public static void url(String Url) {
	driver.get(Url);

}
}
