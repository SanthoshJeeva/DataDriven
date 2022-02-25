package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {
	@BeforeMethod
	private void luan() {
		launchBroswer();
		launchUrl("https://phptravels.com/demo/");
		maxWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Ignore
	@Parameters({ "email", "pass" })
	@Test()
	private void tc(String email, String pass) throws InterruptedException {
		driver.findElement(By.xpath("(//small[text()='http://www.phptravels.net/login'])[1]")).click();
		windowSwitch();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(5000);
	}

	@Test
	private void tc1() throws IOException, InterruptedException {
		driver.findElement(By.xpath("(//small[text()='http://www.phptravels.net/login'])[1]")).click();
		windowSwitch();
		String username = null;
		String password = null;
		FileInputStream f = new FileInputStream(".\\Excel\\phptravel.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(f);
		XSSFSheet sh = book.getSheetAt(0);
		int row = sh.getLastRowNum();
		short cell = sh.getRow(0).getLastCellNum();
		for (int r = 0; r <= row; r++) {
			XSSFRow ro = sh.getRow(r);
			for (int c = 0; c <= cell; c++) {
				XSSFCell ce = ro.getCell(c);
				if (c == 0) {
					username = ce.getStringCellValue();
				}
				if (c == 1) {
					password = ce.getStringCellValue();
				}

			}
			driver.findElement(By.name("email")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			Thread.sleep(5000);
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			driver.findElement(By.xpath("(//a[text()=' My Profile'])[2]")).click();
			WebElement last = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
			String name = last.getAttribute("value");
			System.out.println(a);
			File dest = new File(".\\Screnshot\\" + name + ".pnj");
			FileUtils.copyFile(src, dest);
			driver.findElement(By.xpath("(//a[text()=' Logout'])[2]")).click();

		}
	}

	@Ignore
	@AfterMethod
	private void clse() {
		driver.quit();
	}
}
