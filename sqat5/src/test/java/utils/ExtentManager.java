package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Assignment 5 Report");
            spark.config().setReportName("Automation Results");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
    public static void flush() {
        extent.flush();
    }
}