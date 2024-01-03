package generaltests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
	public class Retry implements IRetryAnalyzer 
	{


	   private static final int    maxTry = 2;
	   private              int    count  = 0;

	   @Override
	   public boolean retry (final ITestResult iTestResultobj) {
	       if (!iTestResultobj.isSuccess ()) {
	           if (this.count < maxTry) {
	     
	               this.count++;
	               return true;
	           }
	       }
	       return false;
	   }
	}