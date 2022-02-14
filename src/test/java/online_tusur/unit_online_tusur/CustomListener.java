package online_tusur.unit_online_tusur;



import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;  
public class CustomListener implements ITestListener  
{  
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
    Date date = new Date();
    String dateTxt = dateFormat.format(date) + ".txt";
    PrintWriter writer;
		
			
@Override  
public void onTestStart(ITestResult result)   {  
// TODO Auto-generated method stub  

}  
  
@Override  
public void onTestSuccess(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Success of test cases and its details are : "+result.getName());  
writer.println("Success of test cases and its details are : "+result.getName());
}  
  
@Override  
public void onTestFailure(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Failure of test cases and its details are : "+result.getName());  
writer.println("Failure of test cases and its details are : "+result.getName());

}  
  
@Override  
public void onTestSkipped(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Skip of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Failure of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onStart(ITestContext context) {  
// TODO Auto-generated method stub
	try {
		writer = new PrintWriter(dateTxt, "UTF-8");
		writer.println("Отчет");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}  
  
@Override  
public void onFinish(ITestContext context) {  
// TODO Auto-generated method stub  
	System.out.println("This is onFinish method" +context.getPassedTests().getAllResults().size());
	 System.out.println("This is onFinish method" +context.getFailedTests().getAllResults().size());
	 
	 			
			writer.println("This is onFinish Passed method" +context.getPassedTests().getAllResults().size());
			writer.println("This is onFinish Failed method" +context.getFailedTests().getAllResults().size());
			
			 
			writer.close();
			System.out.println("Отчет записан в файл ");
		
}  
} 