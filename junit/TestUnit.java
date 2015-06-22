package junit;

import org.junit.Test;
import org.junit.Assert;

public class TestUnit { 
	
	
	
	
	
	@Test
	public void testAdd(){
		String str = "Hello there";
		Assert.assertEquals("Hello there", str);
		Assert.assertEquals("Hello there1", str);
	}

}
