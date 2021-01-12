import static org.junit.Assert.*;

import org.junit.Test;

public class TestAddition {

	@Test
	public void test() {
		assertEquals(15,Operation.addition(5, 15));
	}
	
	@Test
	public void test2() {
		assertEquals(15,Operation.addition(5, 10));
	}

}
