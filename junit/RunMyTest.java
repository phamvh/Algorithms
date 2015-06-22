package junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunMyTest {

	public static void main(String[] args) {
		//run all the methods with annotation @Test
		Result result = JUnitCore.runClasses(TestMyMerge.class);
		for(Failure f : result.getFailures()){
			System.out.println(f.toString());
		}
		System.out.println("Success? "+result.wasSuccessful());

	}

}
