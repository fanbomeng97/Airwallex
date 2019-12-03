package Operators;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class OperatorTest {

	@Test
	public void testAddOperator() {
		Operator add = OperatorFactory.getOperator("+");
		assertEquals(new BigDecimal("7"), add.getResult("3", "4"));
		assertEquals(new BigDecimal("1.2"), add.getResult("1", "0.2"));
		assertEquals(new BigDecimal("0"), add.getResult("-1", "1"));
		assertEquals(new BigDecimal("-10"), add.getResult("-5", "-5"));
	}

	@Test
	public void testSubOperator() {
		Operator sub = OperatorFactory.getOperator("-");
		assertEquals(new BigDecimal("1"), sub.getResult("2", "1"));
		assertEquals(new BigDecimal("-3"), sub.getResult("-2", "1"));
		assertEquals(new BigDecimal("3"), sub.getResult("2", "-1"));
		assertEquals(new BigDecimal("-1"), sub.getResult("-2", "-1"));
	}

	@Test
	public void testMulOperator() {
		Operator mul = OperatorFactory.getOperator("*");
		assertEquals(new BigDecimal("2"), mul.getResult("1", "2"));
		assertEquals(new BigDecimal("0"), mul.getResult("0", "2"));
		assertEquals(new BigDecimal("4"), mul.getResult("2", "2"));
		assertEquals(new BigDecimal("-6"), mul.getResult("-3", "2"));
		assertEquals(new BigDecimal("6"), mul.getResult("-3", "-2"));
	}

	@Test
	public void testDivOperator() {
		Operator div = OperatorFactory.getOperator("/");
		assertEquals(new BigDecimal("0.333333333333333"), div.getResult("1", "3"));
		assertEquals(new BigDecimal("4.000000000000000"), div.getResult("8", "2"));
		assertEquals(new BigDecimal("-4.000000000000000"), div.getResult("-8", "2"));
		assertEquals(new BigDecimal("4.000000000000000"), div.getResult("-8", "-2"));
		assertEquals(new BigDecimal("0.250000000000000"), div.getResult("2", "8"));
		assertEquals(null, div.getResult("2", "0"));
	}

	@Test
	public void testSqrtOperator() {
		Operator sqrt = OperatorFactory.getOperator("sqrt");
		assertEquals(new BigDecimal("3.000000000000000"), sqrt.getResult("9"));
		assertEquals(new BigDecimal("1.414213562373095"), sqrt.getResult("2"));

	}
}
