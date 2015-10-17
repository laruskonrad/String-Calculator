package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.calculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() throws Exception {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() throws Exception {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbersWithComma() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers() throws Exception {
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testLotsOfNumber() throws Exception {
    	assertEquals(15, Calculator.add("0,1,2,3,4,5"));
    }

    @Test
    public void testNewLineWithComma() throws Exception {
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testOnlyNewline() throws Exception {
    	assertEquals(2, Calculator.add("1\n1"));
    }

    @Test
    public void testMultipleOnlyNewline() throws Exception {
    	assertEquals(15, Calculator.add("1\n2\n3\n4\n5"));
    }

    @Test
    public void testNewDelimiter() throws Exception {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumber() throws Exception {
    	assertEquals(1, Calculator.add("-1,2"));
    }

    @Test
    public void testMultipleNegativeNumbers() throws Exception {
    	assertEquals(1, Calculator.add("2,-4,3,-5"));
    }
}