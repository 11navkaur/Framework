package com.walmart.ExtentListenerReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners  implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.createInstance("extent.html");
	private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();
	

	public void onTestStart(ITestResult result) {
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getMethodName());
        test.set(child);
	}

	public void onTestSuccess(ITestResult result) {
		((ExtentTest) test.get()).pass("Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		((ExtentTest) test.get()).fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		((ExtentTest) test.get()).skip(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
}

 class ExtentManager {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {
    	if (extent == null)
    		createInstance("test-output/extent.html");
    	
        return extent;
    }

public static ExtentReports createInstance(String fileName) {
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);
    
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    
    return extent;
}
}
    
