///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             GradesTest.java
// Semester:         Spring 2016
// Course:			 Software Engineering
//
// Author:           徐芷翎
// Email:            oranse0720@gmail.com
//
// Pair Partner:     朱凰華
// Email:            ambitious_816@hotmail.com
//
///////////////////////////////////////////////////////////////////////////////

package nthu.softwareengineering;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Grades object testing.
 * Test all the methods of Grades object.
 * 
 * Bugs: none known
 * 
 * @author       徐芷翎
 * @version      1.0
 */
public class GradesTest {
	
	static Grades aGrade;
	
	@Before
	public void setUp() {
		aGrade = new Grades("955002056","許文馨",88,92,88,98,91);
		aGrade.totalGrade=90*100;
		aGrade.rank=3;
	}

	@After
	public void tearDown() {
		aGrade = null;
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testGetTotalGrade()
	 * 此 test 用以測試 Grades class 的 method getTotalGrade
	 * 
	 * input - 
	 * 	None.
	 * 
	 * expected -
	 * 	(return value)	9000 
	 */
	public void testGetTotalGrade() {
		Integer expected=new Integer(9000);
		Integer actuals = aGrade.getTotalGrade();
		
		assertEquals(expected, actuals);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testSetRank_1()
	 * 此 test 用以測試 Grades class 的 method setRank
	 * 
	 * input - 
	 * 	(parameter)				1
	 * 
	 * expected -
	 * 	(field variable: rank)	1 
	 */
	public void testSetRank_1() {
		aGrade.setRank(1);
		int expected = 1;
		int actuals = aGrade.rank;
		
		assertEquals(expected, actuals);
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testSetRank_2()
	 * 此 test 用以測試 Grades class 的 method setRank
	 * 
	 * input - 
	 * 	(parameter)				2
	 * 
	 * expected -
	 * 	(field variable: rank)	2 
	 */
	public void testSetRank_2() {
		aGrade.setRank(2);
		int expected = 2;
		int actuals = aGrade.rank;
		
		assertEquals(expected, actuals);
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testCalculateTotalGrade_1()
	 * 此 test 用以測試 Grades class 的 method calculateTotalGrade
	 * 
	 * input - 
	 * 	(parameter)						weights  {0.1,0.1,0.1,0.3,0.4}
	 * 
	 * expected -
	 * 	(field variable: totalGrade)	9260 
	 */
	public void testCalculateTotalGrade_1() {
		float[] input = {(float)0.1,(float)0.1,(float)0.1,(float)0.3,(float)0.4};
		aGrade.calculateTotalGrade(input);
		int expected = 9260;
		int actuals = aGrade.totalGrade;
		
		assertEquals(expected, actuals);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testCalculateTotalGrade_2()
	 * 此 test 用以測試 Grades class 的 method calculateTotalGrade
	 *  
	 * input - 
	 * 	(parameter)						weights  {0.2,0.2,0.2,0.2,0.2}
	 * 
	 * expected -
	 * 	(field variable: totalGrade)	9140 
	 */
	public void testCalculateTotalGrade_2() {
		float[] input = {(float)0.2,(float)0.2,(float)0.2,(float)0.2,(float)0.2};
		aGrade.calculateTotalGrade(input);
		int expected = 9140;
		int actuals = aGrade.totalGrade;
		
		assertEquals(expected, actuals);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testCompareTo_1()
	 * 此 test 用以測試 Grades class 的 method compareTo
	 * 
	 * input - 
	 * 	(parameter)		Grades object	otherGrade = new Grades("0","A",80,80,80,80,80);
	 * 									otherGrade.totalGrade=80*100;
	 * 									otherGrade.rank=10;
	 * 
	 * expected -
	 * 	(return value)	-1 
	 */
	public void testCompareTo_1() {		
		Grades otherGrade = new Grades("0","A",80,80,80,80,80);
		otherGrade.totalGrade=80*100;
		otherGrade.rank=10;
		int expected = -1;
		int actuals = aGrade.compareTo(otherGrade);
		
		assertEquals(expected, actuals);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testCompareTo_2()
	 * 此 test 用以測試 Grades class 的 method compareTo
	 * 
	 * input - 
	 * 	(parameter)		Grades object	otherGrade = new Grades("1","B",100,100,100,100,100);
	 * 									otherGrade.totalGrade=100*100;
	 * 									otherGrade.rank=1;
	 * 
	 * expected -
	 * 	(return value)	1 
	 */
	public void testCompareTo_2() {		
		Grades otherGrade = new Grades("1","B",100,100,100,100,100);
		otherGrade.totalGrade=100*100;
		otherGrade.rank=1;
		int expected = 1;
		int actuals = aGrade.compareTo(otherGrade);
		
		assertEquals(expected, actuals);
	}

}
