package tests;

import org.openqa.selenium.By;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test; 
import io.qameta.allure.AllureId;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listenerandbase.AllureListener;
import listenerandbase.BaseTest;
import pages.GooglePage;

@Listeners(AllureListener.class)
public class NaukriSearch extends BaseTest{
	WebDriver driver;
	GooglePage gp;

	@BeforeTest
	public void start() {
		driver = getDriver();
		gp = new GooglePage(driver);
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
	}

	@Test
	@Description("Searching KGF")
	@Epic("Search Feature")
	@Feature("Search")
	@Severity(SeverityLevel.CRITICAL)
	@AllureId("TC001")
	public void verify_User_search1() {
		gp.enter_text_to_Search("kgf 2");
//		Assert.assertTrue(driver.findElement(By.xpath("//td[text()=\"₹250 crore (US$36.56 million)\"]")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("(//td)[1]")).getText(), "KGF: ");
	}
	
//	@AfterClass
//    public void tearDown(ITestResult result){
//		
//		driver.close();
//	}
}
//        if (ITestResult.FAILURE == result.getStatus()) {
//            saveScreenshotPNG(driver);
//        }
//    }
//
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] saveScreenshotPNG(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
