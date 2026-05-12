package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentReportManager  {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
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

        try {
            Files.createDirectories(Paths.get(reportFolder));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("API Automation Report");
        spark.config().setReportName("Restful Booker Test Execution");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Arti");
        extent.setSystemInfo("Framework", "API Automation");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
