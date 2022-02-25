package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver driver;
		public static Select s;
		public static WebElement e;
		public static Actions a;
		public static JavascriptExecutor js;
			public static void launchBroswer() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
}
			public static void firefoxBrowser() {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
			}
			public static void interExplorer() {
					WebDriverManager.iedriver().setup();
					driver=new InternetExplorerDriver();
			}
public static void launchUrl(String url) {
			driver.get(url);
}
public static void maxWindow() {
			driver.manage().window().maximize();
}
public static String fillTxtBox(WebElement ele,String val) {
				ele.sendKeys(val);
				return val;
}
public static void numTxtBox(WebElement e,int val) {
				e.sendKeys(String.valueOf(val));

}
public static void btnClk(WebElement e) {
				e.click();
}
public static void clr(WebElement e) {
				e.clear();
}
public static String getTxt(WebElement e) {
				String text = e.getText();
				System.out.println(text);
				return text;
}
public static  void closeWin() {
				driver.quit();

}
public static String toGetValue(WebElement e) {
				String value = e.getAttribute("value");
				System.out.println(value);
				return value;
}
public static String exceSheet(int row,int cell) throws IOException {
			File f=new File("C:\\Users\\SANTHOSH\\eclipse-workspace\\BaseClass\\Excel1\\JU Booking.xlsx");
			FileInputStream fin=new FileInputStream(f);
			Workbook book=new XSSFWorkbook(fin);
			Sheet sh=book.getSheet("Sheet1");
			Row r = sh.getRow(row);
			Cell c = r.getCell(cell);
			int type = c.getCellType();
			String data="";
			if(type==1)
			{
				 data= c.getStringCellValue();
			}
			else if(DateUtil.isCellDateFormatted(c))
			{
				Date d = c.getDateCellValue();
				SimpleDateFormat fi=new SimpleDateFormat("dd/MM/yyyy");
				data =fi.format(d);
			}
			else 
			{
				double d=c.getNumericCellValue();
				long l=(long)d;
				data = String.valueOf(l);
			}
			return data;
			
}
public static void select(WebElement e,int a) {
					s=new Select(e);
					s.selectByIndex(a);
}
public static void excelsheet(int row,int col,WebElement e) throws IOException {
					File f=new File("C:\\Users\\SANTHOSH\\eclipse-workspace\\BaseClass\\Excel1\\JU Booking.xlsx");
					FileInputStream fin=new FileInputStream(f);
					Workbook book=new XSSFWorkbook(fin);;
					Sheet sh = book.getSheet("Sheet1");
					Row r = sh.getRow(row);
					//Cell c = r.getCell(col);
					Cell c1 = r.createCell(col);
					c1.setCellValue(e.getAttribute("value"));
					FileOutputStream fout=new FileOutputStream(f);
					book.write(fout);
						
					
					
}
public static String excel1sheet(int row,int col,String text) throws IOException {
	File f=new File("C:\\Users\\SANTHOSH\\eclipse-workspace\\BaseClass\\Excel\\Booking.xlsx");
	FileInputStream fin=new FileInputStream(f);
	Workbook book=new XSSFWorkbook(fin);;
	Sheet sh = book.getSheet("Sheet1");
	Row r = sh.getRow(row);
	//Cell c = r.getCell(col);
	Cell c1 = r.createCell(col);
	c1.setCellValue(text);
	FileOutputStream fout=new FileOutputStream(f);
	book.write(fout);
	return text;
}	
public static void pgDown(WebElement e) {
					js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true)", e);
}
public static void pgUp(WebElement e) {
					js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(false)", e);
}
public static void moveTo(WebElement e) {
					a=new Actions(driver);
					a.moveToElement(e).perform();
}
public static String createExcelsheet(int row,int col,String txt) throws IOException {
				File f=new File("C:\\Users\\SANTHOSH\\eclipse-workspace\\BaseClass\\Excel\\B.xlsx");
				FileInputStream fin=new FileInputStream(f);
				Workbook book=new XSSFWorkbook(fin);
				Sheet sh = book.getSheet("Sheet0");
				Row r = sh.getRow(row);
				//Cell c = r.getCell(col);
				Cell c1 = r.createCell(col);
				c1.setCellValue(txt);
				FileOutputStream fout=new FileOutputStream(f);
				book.write(fout);
				return txt;
				
}
public static void dateTime() {
	Date d=new Date();
	System.out.println(d);

}
public static void windowSwitch() {
	String parWinId = driver.getWindowHandle();
	Set<String> allWinId = driver.getWindowHandles();
	for (String eachWinId : allWinId) {
		if (!eachWinId.equals(parWinId)) {
			driver.switchTo().window(eachWinId);
		}
	}
}
public static String getSheet(int row ,int cell) throws IOException {
	File f=new File("C:\\Users\\SANTHOSH\\eclipse-workspace\\Sample\\Excel\\phptravel.xlsx");
	FileInputStream fin=new FileInputStream(f);
	XSSFWorkbook book=new XSSFWorkbook(fin);
	XSSFSheet sh = book.getSheetAt(0);
	XSSFRow r = sh.getRow(row);
	XSSFCell c = r.getCell(cell);
	String data="";
	data = c.getStringCellValue();
	return data;
}
}

