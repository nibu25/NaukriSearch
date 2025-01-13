package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	
	WebDriver driver;
	WebDriverWait wait;

	public GooglePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(xpath="//textarea[@title=\"Search\"]")
	WebElement searchtext;
	
	@FindBy(xpath="(//span/b)[1]")
	WebElement suggesition;
	
	public void enter_text_to_Search(String text)
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchtext)).sendKeys(text);
		wait.until(ExpectedConditions.elementToBeClickable(suggesition)).click();
	}
	

}

