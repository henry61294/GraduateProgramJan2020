package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

	@Test
	void testGetMaxNumberValid() {
		//assert<Condition> (<Expected-Result>,<call the function for actual result>,
		//					 <message to display if the expected result does not match the actual result>);
		assertEquals(10, SolutionProvider.getMaxNumber(10,2), "Invalid Max Number Returned");
	}
	
	@Test
	void testGetMaxNumberEqual() {
		assertEquals(9, SolutionProvider.getMaxNumber(9,9),"Invalid Max Number Returned");
		}
	
	@Test
	void testGetMaxNumberNegativeValue() {
		assertEquals(-2, SolutionProvider.getMaxNumber(-110,-2),"Invalid Max Number Returned");
	}
	
	@Test
	void testGetMaxNumberMaxLimitForIntParams() {
		assertEquals(100129372, SolutionProvider.getMaxNumber(100129372,2),"Invalid Max Number Returned");
	}
	@Test
	void testGetQuotient() {
		assertEquals("2,2", SolutionProvider.getQuotientRemainder(12,5),"Invalid quotientRemainder Number Returned");
	}
	
	@Test
	void testGetKmMile() {
		assertEquals(6.25, SolutionProvider.getKmMile(10),"Invalid Mile Number Returned");
	}
	
	@Test
	void testGetRectangleShapeArea() {
		assertEquals("rectangle area is 60", SolutionProvider.getShapeArea(12,5),"Invalid rectangle area Number Returned");
	}
	void testGetSquareShapeArea() {
		assertEquals("square area is 25", SolutionProvider.getShapeArea(5,5),"Invalid square area Number Returned");
	}
	
	@Test
	void testGetJourneyTime() {
		assertEquals(3, SolutionProvider.getJourneyTime(15,5),"Invalid time Number Returned");
	}

	@Test
	void testGetCircleArea() {
		assertEquals(78.53981633974483, SolutionProvider.getCircleArea(5),"Invalid Circle Area Number Returned");
	}
	
	@Test
	void testGetLowestNumber() {
		assertEquals(2, SolutionProvider.getLowestNumber(2,16,24),"Invalid Number Returned");
	}
	
	@Test
	void testGetPassMark() {
		assertEquals("170, PASS", SolutionProvider.getPassMark(10256, "greg", 18, 70, 60, 40),"Invalid Number Returned");
	}
	
	
}
