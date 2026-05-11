package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager  {

    private static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        String timestamp = java.time.LocalDateTime.now()
                .toString()
                .replace(":", "-")
                .replace(".", "-");
        String reportFolder = System.getProperty("user.dir") + "/reports/" + timestamp;
        String reportPath = reportFolder + "/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("API Automation Report");
        spark.config().setReportName("Restful Booker Test Execution");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Arti");
        extent.setSystemInfo("Framework", "API Automation");
        extent.setSystemInfo("Environment", "QA");
        return extent;

    }
    private static String getTimestamp() {
        return java.time.LocalDateTime.now()
                .toString()
                .replace(":", "-")
                .replace(".", "-");
    }

}
