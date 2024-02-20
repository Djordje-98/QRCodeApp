package rs.ac.singidunum.qrcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testexampleTest {

	@Test
	public void test() {
		testexample t = new testexample();
		int actual = t.saberi(10, 20);
		int expected = 30;
		assertEquals(expected, actual);
	}
	@Test
	public void test2() {
		testexample t = new testexample();
		int actual = t.saberi(10, 30);
		int expected = 40;
		assertEquals(expected, actual);
	}
	@Test
	public void test3() {
		testexample t = new testexample();
		int actual = t.saberi(10, 10);
		int expected = 20;
		assertEquals(expected, actual);
	}

}
