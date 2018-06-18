import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StunumInTest {
	StunumIn stu;
	@Before
	public void setUp() throws Exception {
		stu=new StunumIn("","",new String[]{""},"","",3,"","","");
	}

	@Test
	public void testIsValidlist() {
		assertEquals(true, stu.isValidlist("11111;22222;33333"));
	}

	@Test
	public void testIsValidString() {
	    assertEquals(true, stu.isValidString("11111"));
	}

}
