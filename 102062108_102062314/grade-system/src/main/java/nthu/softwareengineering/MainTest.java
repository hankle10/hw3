///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             MainTest.java
// Semester:         Spring 2016
// Course:			 Software Engineering
//
// Author:           �}���
// Email:            oranse0720@gmail.com
//
// Pair Partner:     ���ĵ�
// Email:            ambitious_816@hotmail.com
//
///////////////////////////////////////////////////////////////////////////////

package nthu.softwareengineering;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Integration testing.
 * Test the whole project.
 * 
 * Bugs: none known
 * 
 * @author       �}���
 * @version      1.0
 * @see also     Main, UI, CloseUIExceptions
 */
public class MainTest {
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testException()
	 * �� test �ΥH���� Main class �� CloseUIExceptions handling
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	Q						[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C
	 * 
	 * input - 
	 *  (user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testException(){
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_1()
	 * �� test �ΥH���� Unexpected Scenario 1 : ��J���s�b��ID
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	000000000				[���s�b��ID]
	 * (�ù�)		��ID���s�b!				[���~�T��]
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	Q						[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C
	 * 
	 * 
	 * input - 
	 *  (user input) "000000000\nQ\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?��ID���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testUnexpectedScenario_1(){
		ByteArrayInputStream in = new ByteArrayInputStream("000000000\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Main.main(new String[] {});
				
		assertEquals("��JID�� Q (�����ϥ�)?��ID���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_2()
	 * �� test �ΥH���� Unexpected Scenario 2 : ��J���s�b�����O
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056				[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	X						[���s�b�����O]
	 * (�ù�)		�����O���s�b!			[���~�T��]
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E						[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	Q						[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C
	 * 
	 * input - 
	 *  (user input) "955002056\nX\nE\nQ\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testUnexpectedScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nX\nE\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_1
	 * �� test �ΥH���� Normal Scenario 1�A�p�U
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056				[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E						[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?		
	 * (�ϥΪ̿�J)	Q						[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C		[���}�T��]
	 *  
	 * input - 
	 *  (user input) "955002056\nX\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_1(){
		String userInput = "955002056\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_2()
	 * �� test �ΥH���� Normal Scenario 2�A�p�U
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056			[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	G					[��ܦ��Z]
	 * (�ù�)		�\���ɦ��Z:
	 * 					lab1:		88�@
	 * 					lab2:		92�@
	 * 					lab3:		88�@
	 * 					mid-term:	98�@
	 * 					final exam:	91 
	 * 					total grade:	93
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E					[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?		
	 * (�ϥΪ̿�J)	Q					[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C	[���}�T��]
	  * 
	 * input - 
	 *  (user input) "955002056\nX\n"
	 *	(user input) "G\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɦ��Z:\n\tlab1:\t\t88\nlab2:\t\t92\nlab3:\t\t88\nmid-term:\t98\nfinal exam:\t91\ntotal grade:\t92\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_2(){
		String userInput = "955002056\nG\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɦ��Z:\n\tlab1:\t\t88 \n\tlab2:\t\t92 \n\tlab3:\t\t88 \n\tmid-term:\t98 \n\tfinal exam:\t91 \n\ttotal grade:\t93 \n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());

		System.setIn(System.in);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_3()
	 * �� test �ΥH���� Normal Scenario 3�A�p�U
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056			[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	A					[��ܥ���]
	 * (�ù�)		�\���ɥ���91.40
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E					[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?		
	 * (�ϥΪ̿�J)	Q					[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C	[���}�T��]
	 *  
	 * input - 
	 *  (user input) "955002056\nX\n"
	 *	(user input) "A\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɥ���91.40\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_3(){
		String userInput = "955002056\nA\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɥ���91.40\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());

		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_4()
	 * �� test �ΥH���� Normal Scenario 4 �A�p�U
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056			[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	R					[��ܱƦW]
	 * (�ù�)		�\���ɱƦW��14			
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E					[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?		
	 * (�ϥΪ̿�J)	Q					[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C	[���}�T��]
	 *  
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "R\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɱƦW��14\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_4(){
		String userInput = "955002056\nR\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɱƦW��14\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_5()
	 * �� test �ΥH���� Normal Scenario 5 �A�p�U
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056			[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	W					[����°t�� ]
	 * (�ù�)		�°t�� 
	 * 		   			lab1           10%
     *            		lab2           10%
     *            		lab3           10%
     *            		mid-term       30%
     *            		final exam      40%
	 * 				��J�s�t��
	 * 					lab1
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			lab2
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			lab3
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			mid-term
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			final exam
	 * (�ϥΪ̿�J)	20
	 * (�ù�)		�нT�{�s�t��
	 * 		   			lab1           20%
     *            		lab2           20%
     *            		lab3           20%
     *            		mid-term       20%
     *            		final exam      20%
	 * 		   		�H�W���T��? Y (Yes) �� N (No)
	 * (�ϥΪ̿�J)	Y					[�T�{]
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E					[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?		
	 * (�ϥΪ̿�J)	Q					[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C	[���}�T��]
	 *
	 *
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "W\n"
	 *	(user input) "20\n20\n20\n20\n20\n"
	 * 	(user input) "Y"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_5(){
		String userInput = "955002056\nW\n20\n20\n20\n20\n20\nY\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_6()
	 * �� test �ΥH���� Normal Scenario
	 * 
	 * (�ù�)		��JID�� Q (�����ϥ�)?
	 * (�ϥΪ̿�J)	955002056			[�s�b��ID]
	 * (�ù�)		Welcome �\����
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	W					[����°t�� ]
	 * (�ù�)		�°t�� 
	 * 		   			lab1           10%
     *            		lab2           10%
     *            		lab3           10%
     *            		mid-term       30%
     *            		final exam      40%
	 * 				��J�s�t��
	 * 					lab1
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			lab2
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			lab3
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			mid-term
	 * (�ϥΪ̿�J)	20
	 * (�ù�)			final exam
	 * (�ϥΪ̿�J)	20
	 * (�ù�)		�нT�{�s�t��
	 * 		   			lab1           20%
     *            		lab2           20%
     *            		lab3           20%
     *            		mid-term       20%
     *            		final exam      20%
	 * 		   		�H�W���T��? Y (Yes) �� N (No)
	 * (�ϥΪ̿�J)	N					[�T�{]
	 * (�ù�)		��J���O
	 * 					1) G ��ܦ��Z (Grade)
	 * 					2) R ��ܱƦW (Rank)
	 * 					3) A ��ܥ��� (Average)
	 * 					4) W ��s�t�� (Weight)
	 * 					5) E ���}��� (Exit)
	 * (�ϥΪ̿�J)	E					[���}���]
	 * (�ù�)		��JID�� Q (�����ϥ�)?		
	 * (�ϥΪ̿�J)	Q					[���}�t��]
	 * (�ù�)		�����ϥΡA�t�������C	[���}�T��]
	 *
	 *
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "W\n"
	 *	(user input) "20\n20\n20\n20\n20\n"
	 * 	(user input) "N"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_6(){
		String userInput = "955002056\nW\n20\n20\n20\n20\n20\nN\n\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
	}
}
