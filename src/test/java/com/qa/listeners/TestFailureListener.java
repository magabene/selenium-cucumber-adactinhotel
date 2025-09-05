package com.qa.listeners;

import com.qa.utils.ScreenshotUtility;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFailureListener extends TestListenerAdapter implements TestLifecycleListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getDriverFromResult(result); // Implement to get driver from test context
        if (driver != null) {
            ScreenshotUtility.attachScreenshot(driver, "Failure Screenshot: " + result.getName());
        }
    }

    @Override
    public void beforeTestStop(TestResult result) {
        // Optional: Allure lifecycle hook for additional logic
    }

    private WebDriver getDriverFromResult(ITestResult result) {
        // Extract driver from test context; e.g., if stored in test parameters or a thread-local
        // Example: return (WebDriver) result.getTestContext().getAttribute("driver");
        return null; // Replace with actual logic
    }
}