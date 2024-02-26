package dd;

import static org.junit.Assert.*;

import org.junit.Test;

import training.exceptions.CustomException;
import training.task3.helper.StringHelper;

public class JUnitTest {

	StringHelper stringHelper = new StringHelper();
//	
	@Test
	public void fff() {
		try {
            stringHelper.addSubstringFront(null, null);
            
            fail("Expected CustomException, but no exception was thrown");
        } catch (CustomException e) {
            assertEquals("Input is null !", e.getMessage());
        }
	}
	
	
//	@Test(expected = Exception.class)
//	public void nullCheck() {
//		
//
//System.out.println(1/0);
//
////			assertEquals(4, stringHelper.countChar("dcba", 'a'));
//
//		
//	}
	


}
