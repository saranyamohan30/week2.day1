//For Edit Lead

package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DuplicatesAuto {

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("sarancompany");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("saran");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("mohan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("saranlocalname");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("deptautomationTesting");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("automation Testing Description");
		WebElement primEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
		primEmail.sendKeys("testemail@test.com");
		WebElement stateDropDown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateObject=new Select(stateDropDown);
		stateObject.selectByVisibleText("Indiana");
		driver.findElement(By.name("submitButton")).click();
		//Thread.sleep(5000);
		String currentPage = driver.getTitle();
		System.out.println("Current page is : "+currentPage);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NewCOmpanyName");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("NewFirstName");
		driver.findElement(By.name("submitButton")).click();
		
		String currentPage1 = driver.getTitle();
		System.out.println("Current page is : "+currentPage1);
	}

}





	