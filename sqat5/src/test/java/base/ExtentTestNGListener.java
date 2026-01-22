package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import utils.ScreenshotUtil;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/TestReport.html");
        reporter.config().setReportName("Assignment 5 – Selenium TestNG");
        reporter.config().setDocumentTitle("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        BaseTest base = (BaseTest) result.getInstance();
        String path = ScreenshotUtil.takeScreenshot(
                base.driver,
                result.getMethod().getMethodName() + "_success"
        );
        test.get().pass("Test PASSED");
        if (path != null) {
            test.get().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest base = (BaseTest) result.getInstance();
        String path = ScreenshotUtil.takeScreenshot(
                base.driver,
                result.getMethod().getMethodName() + "_failure"
        );
        test.get().fail(result.getThrowable());
        if (path != null) {
            test.get().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
