package listenerandbase;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver=new ChromeDriver();



    public WebDriver getDriver() {

        return driver;
    }
}

