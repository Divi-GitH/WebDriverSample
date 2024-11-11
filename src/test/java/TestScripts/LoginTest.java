package TestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginTest {
	WebDriver driver;
	Properties prop;

	@BeforeTest
	
	public void readProperty() throws IOException {
		String path = System.getProperty("user.dir") +
				"\\src\\test\\resources\\configFiles\\config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop = new Properties();
		prop.load(fin);
	}
	
	@Test
	    public void setup() {
	  
	  String StrBrowser = prop.getProperty("browser");
	  	  if(StrBrowser.equalsIgnoreCase("chrome")) {
	  		  driver = new ChromeDriver();
	  	  }else if (StrBrowser.equalsIgnoreCase("edge")) {
	  		  driver = new EdgeDriver();
	  	  }
	  	  driver.manage().window().maximize();
	  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	  	@Test (dataProvider = "LoginData")
//	  	public void validloginTest() {
//	  		CSV file reader method
	  		public void validloginTest(String strUser, String strPwd) {
	  		driver.get(prop.getProperty("url"));
	  		driver.findElement(By.id("username")).sendKeys(strUser);
	  		driver.findElement(By.name("password")).sendKeys(strPwd);
//	  		driver.findElement(By.id(readFromExcel("username"))).sendKeys("tomsmith");
//	  		driver.findElement(By.name(readFromExcel("password"))).sendKeys("SuperSecretPassword!");
	  		driver.findElement(By.cssSelector(readFromExcel("button.radius"))).click();
	  		boolean isvalidUSer = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
	  		Assert.assertTrue(isvalidUSer);

	  }
	  	@DataProvider(name="LoginData")
	  	public Object[][] getData()throws CsvValidationException, IOException{
	  		
	  		String path = System.getProperty("user.dir")+
	  				"//src//test//resources//TestData//LoginData.csv";
	  		CSVReader reader = null;
			  try {
				  reader = new CSVReader(new FileReader(path));
			  }catch (FileNotFoundException e ) {
				  e.printStackTrace();
			  }
	  		
	  //		CSVReader reader = new CSVReader(new FileReader(path));
			  
			String cols[];
	  		ArrayList<Object> dataList = new ArrayList<Object>();
	  		while((cols =reader.readNext()) !=null) {
	  			System.out.println("text" + cols.length);
	  			Object[] record = {cols[0], cols[1]};	  			
	  			dataList.add(record);	
	  		}
	  		return dataList.toArray(new Object[dataList.size()][]);
	  	}

	  			public String readFromExcel(String ObjName) {
		  String objPath="";
		  String path = System.getProperty("");
	      //HSSF...> .xls
		  //XSSF...-> .xlsx
		  FileInputStream fin;
		  XSSFWorkbook workbook = null;
		  try {
			  fin = new FileInputStream(path);
			  workbook = new XSSFWorkbook(fin);
		  }catch (FileNotFoundException e ) {
			  e.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  XSSFSheet loginSheet = workbook.getSheet("loginPage");
		  int numRows = loginSheet.getLastRowNum();
		  System.out.println("Num of rows.." + numRows);
		  for (int i =1; i<=numRows; i++) {
			  XSSFRow row = loginSheet.getRow(i);
			  if (row.getCell(0).getStringCellValue().equalsIgnoreCase(ObjName)) {
				  objPath = row.getCell(1).getStringCellValue();

			  }
		  }	  
		  return objPath;
	  }

  }

////loginData.csv
// tomsmith.SuperSecretPassword
//testuser1,welcome123
//testuser2,welcome123 