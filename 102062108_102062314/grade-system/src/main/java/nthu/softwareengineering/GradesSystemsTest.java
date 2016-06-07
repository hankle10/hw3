///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             GradeSystemsTest.java
// Semester:         Spring 2016
// Course:			 Software Engineering
//
// Author:           ���ĵ�
// Email:            ambitious_816@hotmail.com
//
// Pair Partner:     �}���
// Email:            oranse0720@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

package nthu.softwareengineering;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * GradeSystems object testing.
 * Test all the methods of GradeSystems object.
 * 
 * Bugs: none known
 * 
 * @author       ���ĵ�
 * @version      1.0
 */
public class GradesSystemsTest {
	static GradeSystems aGradeSystem;
	private static  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpBeforeClass() throws Exception {
		aGradeSystem = new GradeSystems();
	}

	@After
	public void tearDownAfterClass() throws Exception {
		aGradeSystem = null;
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowGrade_1()
	 * �� test �ΥH���� GradeSystems class �� method showGrade
	 * 
	 * input - 
	 * 	(parameter)			String object "985002509"
	 * 
	 * expected -
	 * 	(screen display)	��ܦ�ID�ϥΪ̪��Ҧ����Z(lab1, lab2, lab3, midTerm, finalExam, totalGrade)	   
	 */
	public void testShowGrade_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aGradeSystem.showGrade("985002509");		
		String expected = "���v�æ��Z:\n\tlab1:\t\t84 \n\tlab2:\t\t92 \n\tlab3:\t\t98 \n\tmid-term:\t94 \n\tfinal exam:\t99 \n\ttotal grade:\t95 \n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
	

	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowGrade_2()
	 * �� test �ΥH���� GradeSystems class �� method showGrade
	 * 
	 * input - 
	 * 	(parameter)			String object "955002056"
	 * 
	 * expected -
	 * 	(screen display)	��ܦ�ID�ϥΪ̪��Ҧ����Z(lab1, lab2, lab3, midTerm, finalExam, totalGrade)	   
	 */
	public void testShowGrade_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aGradeSystem.showGrade("955002056");		
		String expected = "�\���ɦ��Z:\n\tlab1:\t\t88 \n\tlab2:\t\t92 \n\tlab3:\t\t88 \n\tmid-term:\t98 \n\tfinal exam:\t91 \n\ttotal grade:\t93 \n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowRank_1()
	 * �� test �ΥH���� GradeSystems class �� method showRank
	 * 
	 * input - 
	 * 	(parameter)			String object "985002509"
	 * 
	 * expected -
	 *	(screen display)	��ܥX��ID�ϥΪ̪��ƦW   
	 */
	public void testShowRank_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aGradeSystem.showRank("985002509");
		String expected = "���v�ñƦW��1\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowRank_2()
	 * �� test �ΥH���� GradeSystems class �� method showRank
	 * 
	 * input - 
	 * 	(parameter)			String object "955002056"
	 * 
	 * expected -
	 *	(screen display)	��ܥX��ID�ϥΪ̪��ƦW   
	 */
	public void testShowRank_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		aGradeSystem.showRank("955002056");
		String expected = "�\���ɱƦW��14\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowName_1()
	 * �� test �ΥH���� GradeSystems class �� method showName
	 * 
	 * input - 
	 * 	(parameter)			String object "985002509"
	 * 
	 * expected -
	 *	(screen display)	��ܥX��ID�ϥΪ̪��m�W   
	 */
	public void testShowName_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		aGradeSystem.showName("985002509");
		
		String expected = "���v��";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}	

	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowName_2()
	 * �� test �ΥH���� GradeSystems class �� method showName
	 * 
	 * input - 
	 * 	(parameter)			String object "955002056"
	 * 
	 * expected -
	 *	(screen display)	��ܥX��ID�ϥΪ̪��m�W   
	 */
	public void testShowName_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		aGradeSystem.showName("955002056");
		
		String expected = "�\����";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowAverage_1()
	 * �� test �ΥH���� GradeSystems class �� method showAverage
	 * 
	 * input - 
	 * 	(parameter)			String object "985002509"
	 * 
	 * expected -
	 *	(screen display)	��ܥX��ID�ϥΪ̪����Z����   
	 */
	public void testShowAverage_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		aGradeSystem.showAverage("985002509");
		
		String expected = "���v�å���93.40\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
	}
	

	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowAverage_2()
	 * �� test �ΥH���� GradeSystems class �� method showAverage
	 * 
	 * input - 
	 * 	(parameter)			String object "955002056"
	 * 
	 * expected -
	 *	(screen display)	��ܥX��ID�ϥΪ̪����Z����   
	 */
	public void testShowAverage_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		aGradeSystem.showAverage("955002056");
		
		String expected = "�\���ɥ���91.40\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testContainsID_1()
	 * �� test �ΥH���� GradeSystems class �� method containsID
	 * 
	 * input - 
	 * 	(parameter)		String object "985002509"
	 * 					
	 * 
	 * 
	 * expected -
	 *	(return value)	boolean true
	 */
	public void testContainsID_1() {
		boolean expected = true;
		boolean actuals = aGradeSystem.containsID("985002509");
		
		assertEquals(expected, actuals);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testContainsID_2()
	 * �� test �ΥH���� GradeSystems class �� method containsID
	 * 
	 * input - 
	 * 	(parameter)		String object "-1"
	 * 
	 * expected -
	 *	(return value)	boolean false
	 */
	public void testContainsID_2() {
		boolean expected = false;
		boolean actuals = aGradeSystem.containsID("-1");
		
		assertEquals(expected, actuals);
	}



	@Test
	/** ------------------------------------------------------------------------------
	 * test testSetNewWeights_1()
	 * �� test �ΥH���� GradeSystems class �� method setNewWeights 
	 * 
	 * input - 
	 * 	(parameter)		String object "Y"
	 * 	(parameter)		int array 	weights		{20,20,20,20,20}
	 * 
	 * expected -
	 *	(field value:weights)	{0.2,0.2,0.2,0.2,0.2}
	 */
	public void testSetNewWeights_1() {
		int[] weights = new int [5];
		weights[0] = 20;
		weights[1] = 20;
		weights[2] = 20;
		weights[3] = 20;
		weights[4] = 20;
		aGradeSystem.setNewWeights("Y",weights);
		float[] expected = {(float) 0.2,(float) 0.2,(float) 0.2,(float) 0.2,(float) 0.2};
		float[] actuals =  GradeSystems.weights;
		int i;
		for(i=0;i<5;i++){
			assertEquals(expected[i], actuals[i],0.01);			
		}
	}



	@Test
	/** ------------------------------------------------------------------------------
	 * test testSetNewWeights_2()
	 * �� test �ΥH���� GradeSystems class �� method setNewWeights 
	 * 
	 * input - 
	 * 	(parameter)		String object "N"
	 * 	(parameter)		int array 	weights		{20,20,20,20,20}
	 * 
	 * expected -
	 *	(field value:weights)	{0.1,0.1,0.1,0.3,0.4}
	 */
	public void testSetNewWeights_2() {
		int[] weights = new int [5];
		weights[0] = 20;
		weights[1] = 20;
		weights[2] = 20;
		weights[3] = 20;
		weights[4] = 20;
		aGradeSystem.setNewWeights("N",weights);		
		float[] expected = {(float) 0.1,(float) 0.1,(float) 0.1,(float) 0.3,(float) 0.4};
		float[] actuals =  GradeSystems.weights;
		int i;
		for(i=0;i<5;i++){
			assertEquals(expected[i], actuals[i],0.01);			
		}
	}



	@Test
	/** ------------------------------------------------------------------------------
	 * test testShowOldWeights()
	 * �� test �ΥH���� GradeSystems class �� method setNewWeights 
	 * 
	 * input - 
	 * 	null
	 * 
	 * expected -
	 *	(screen display)		����ª��v�� 
	 */
	public void testShowOldWeights() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		aGradeSystem.showOldWeights();
		
		String expected = "�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n";
		String actuals =  outContent.toString();
		assertEquals(expected, actuals);
	}
}


