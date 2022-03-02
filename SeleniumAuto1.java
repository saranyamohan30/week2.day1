/*Create Lead
		  1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  2. Enter UserName and Password Using Id Locator
		  3. Click on Login Button using Class Locator
		  4. Click on CRM/SFA Link
		  5. Click on Leads Button
		  6. Click on Create Lead 
		  7. Enter CompanyName Field Using id Locator
		  8. Enter FirstName Field Using id Locator
		  9. Enter LastName Field Using id Locator
		  10. Enter FirstName(Local) Field Using id Locator
		  11. Enter Department Field Using any Locator of Your Choice
		  12. Enter Description Field Using any Locator of your choice 
		  13. Enter your email in the E-mail address Field using the locator of your choice
		  14. Select State/Province as NewYork Using Visible Text
		  15. Click on Create Button
                  16. Get the Title of Resulting Page. refer the video  using driver.getTitle()
*/

package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAuto1 {


	public static void main(String[] args) {
		//To open Browser - invoke ChromeDriver class
		//System.setProperty("webdriver.chrome.driver", "location of driver path");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximise the browser window
		driver.manage().window().maximize();
		//to open a url in browser
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
		stateObject.selectByIndex(3);
		
		/* To display the options in drop down
		 * 
		 * int size = stateProvinceDropDown.size();
		 * System.out.println("Size of dropdown :"+size); 
		 * for(int i=0;i<size;i++) {
		 * String stateProvinceDropDownOptions = stateProvinceDropDown.get(i).getText();
		 * System.out.println(stateProvinceDropDownOptions);
		 *  }
		 */
		driver.findElement(By.name("submitButton")).click();
		//driver.findElement(By.className("smallSubmit")).click();
		String title=driver.getTitle();
		System.out.println(title);

	}

}
