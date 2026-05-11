package listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentReportManager;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite run Started!!!");
        extent = ExtentReportManager.getInstance();

    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed!!!");
        extent.flush();
        String reportDir = System.getProperty("user.dir") + "/reports";
        logger.info("Extent Report directory: {}", reportDir);

    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Started!!!! " + result.getMethod().getMethodName());
        logger.info("Description!! " + result.getMethod().getDescription());

        test = extent.createTest(result.getMethod().getMethodName())
                .assignCategory(result.getTestClass().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Passed!!!! " + result.getMethod().getMethodName());
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Failed!!!! " + result.getMethod().getMethodName());
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Skipped!!!! " + result.getMethod().getMethodName());
        test.skip("Test Skipped");
    }
}
