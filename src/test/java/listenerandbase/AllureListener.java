package listenerandbase;

import io.qameta.allure.Allure;


import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		// Take and attach screenshot on test failure
		System.out.println("Test failed! Taking screenshot...");
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver(); // Assuming BaseTest has getDriver() method
		if (driver != null) {
			Allure.getLifecycle().addAttachment("Failure Screenshot", "image/png", "png", takeScreenshot(driver));
		}
	}

	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Other overridden methods of ITestListener can remain empty or customized as
	// per need
	@Override
	public void onTestSuccess(ITestResult result) {
		// Take and attach screenshot on test failure
		System.out.println("Test failed! Taking screenshot...");
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver(); // Assuming BaseTest has getDriver() method
		if (driver != null) {
			Allure.getLifecycle().addAttachment("Passed Screenshot", "image/png", "png", takeScreenshots(driver));
		}
	}

	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] takeScreenshots(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
}
