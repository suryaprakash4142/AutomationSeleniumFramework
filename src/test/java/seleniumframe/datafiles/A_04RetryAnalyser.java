package seleniumframe.datafiles;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class A_04RetryAnalyser implements IRetryAnalyzer {

	int count = 0;
	int maxtry = 1;

	@Override
	public boolean retry(ITestResult result) {
//and this method is calling in th eA_03Errorvalidation
		if (count < maxtry) {
			// if we have to make the test run to execute one more time then we have to came
			// here and make the count how many times it required and then we have to return
			// true then i t will execute one more time if the count value is equak to
			// maxtry the the return will false and stop the execute
			return true;
		}
		return false;
	}

}
