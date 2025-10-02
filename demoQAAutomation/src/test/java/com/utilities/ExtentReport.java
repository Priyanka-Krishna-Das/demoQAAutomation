package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.baseClass.BaseClass;

public class ExtentReport extends BaseClass implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    private WebDriver driver;

    public synchronized void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport/ExtentReport.html");
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Real Life Sciences - smoke suite tests execution report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Environment", "QA-Environment");
        extent.setSystemInfo("Tester", "Vipin Borole");

    }

    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        // Get driver instance from test class
        Object testClass = result.getInstance();
        driver = ((BaseClass) testClass).driver;
    }

    public synchronized void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
    }



    public synchronized void onTestFailure(ITestResult result) {
        // Get the driver from the test class
        Object testClass = result.getInstance();
        driver = ((BaseClass) testClass).driver;

        try {
            // Capture screenshot as base64
            String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            // Add screenshot directly to the failure log
            test.get().fail("Test Failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());

            test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));

        } catch (Exception e) {
            // Fallback if screenshot fails
            test.get().fail("Test Failed: " + result.getThrowable());
            test.get().warning("Failed to capture screenshot: " + e.getMessage());
        }
    }


    private String takeScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            // Create screenshots directory if it doesn't exist
            File directory = new File("target/screenshots/");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String destinationPath = "target/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            File destination = new File(destinationPath);
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved at: " + destinationPath);

            return destinationPath;
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));
        test.get().skip(result.getThrowable());
    }

    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }
}


