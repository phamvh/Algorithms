package junit;

import org.junit.Assert;
import org.junit.Test;

public class TestMyMerge {
	@Test
	public void testMyFunction1(){
		MergeSort m = new MergeSort();
		Assert.assertEquals(m.getString(), "Hello World1");
	}
	@Test
	public void testMyFunction2(){
		MergeSort m = new MergeSort();
		Assert.assertEquals(m.getString(), "Hello World");
	}
	
	

}
