///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             MainTest.java
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
 * @author       徐芷翎
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
	 * 此 test 用以測試 Main class 的 CloseUIExceptions handling
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	Q						[離開系統]
	 * (螢幕)		結束使用，系統關閉。
	 * 
	 * input - 
	 *  (user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testException(){
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_1()
	 * 此 test 用以測試 Unexpected Scenario 1 : 輸入不存在的ID
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	000000000				[不存在的ID]
	 * (螢幕)		此ID不存在!				[錯誤訊息]
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	Q						[離開系統]
	 * (螢幕)		結束使用，系統關閉。
	 * 
	 * 
	 * input - 
	 *  (user input) "000000000\nQ\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?此ID不存在!\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testUnexpectedScenario_1(){
		ByteArrayInputStream in = new ByteArrayInputStream("000000000\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Main.main(new String[] {});
				
		assertEquals("輸入ID或 Q (結束使用)?此ID不存在!\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_2()
	 * 此 test 用以測試 Unexpected Scenario 2 : 輸入不存在的指令
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056				[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	X						[不存在的指令]
	 * (螢幕)		此指令不存在!			[錯誤訊息]
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E						[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	Q						[離開系統]
	 * (螢幕)		結束使用，系統關閉。
	 * 
	 * input - 
	 *  (user input) "955002056\nX\nE\nQ\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n此指令不存在!\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testUnexpectedScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nX\nE\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n此指令不存在!\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_1
	 * 此 test 用以測試 Normal Scenario 1，如下
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056				[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E						[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?		
	 * (使用者輸入)	Q						[離開系統]
	 * (螢幕)		結束使用，系統關閉。		[離開訊息]
	 *  
	 * input - 
	 *  (user input) "955002056\nX\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_1(){
		String userInput = "955002056\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_2()
	 * 此 test 用以測試 Normal Scenario 2，如下
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056			[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	G					[顯示成績]
	 * (螢幕)		許文馨成績:
	 * 					lab1:		88　
	 * 					lab2:		92　
	 * 					lab3:		88　
	 * 					mid-term:	98　
	 * 					final exam:	91 
	 * 					total grade:	93
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E					[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?		
	 * (使用者輸入)	Q					[離開系統]
	 * (螢幕)		結束使用，系統關閉。	[離開訊息]
	  * 
	 * input - 
	 *  (user input) "955002056\nX\n"
	 *	(user input) "G\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨成績:\n\tlab1:\t\t88\nlab2:\t\t92\nlab3:\t\t88\nmid-term:\t98\nfinal exam:\t91\ntotal grade:\t92\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n此指令不存在!\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_2(){
		String userInput = "955002056\nG\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨成績:\n\tlab1:\t\t88 \n\tlab2:\t\t92 \n\tlab3:\t\t88 \n\tmid-term:\t98 \n\tfinal exam:\t91 \n\ttotal grade:\t93 \n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());

		System.setIn(System.in);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_3()
	 * 此 test 用以測試 Normal Scenario 3，如下
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056			[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	A					[顯示平均]
	 * (螢幕)		許文馨平均91.40
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E					[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?		
	 * (使用者輸入)	Q					[離開系統]
	 * (螢幕)		結束使用，系統關閉。	[離開訊息]
	 *  
	 * input - 
	 *  (user input) "955002056\nX\n"
	 *	(user input) "A\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨平均91.40\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_3(){
		String userInput = "955002056\nA\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨平均91.40\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());

		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_4()
	 * 此 test 用以測試 Normal Scenario 4 ，如下
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056			[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	R					[顯示排名]
	 * (螢幕)		許文馨排名第14			
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E					[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?		
	 * (使用者輸入)	Q					[離開系統]
	 * (螢幕)		結束使用，系統關閉。	[離開訊息]
	 *  
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "R\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨排名第14\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_4(){
		String userInput = "955002056\nR\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨排名第14\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_5()
	 * 此 test 用以測試 Normal Scenario 5 ，如下
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056			[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	W					[顯示舊配分 ]
	 * (螢幕)		舊配分 
	 * 		   			lab1           10%
     *            		lab2           10%
     *            		lab3           10%
     *            		mid-term       30%
     *            		final exam      40%
	 * 				輸入新配分
	 * 					lab1
	 * (使用者輸入)	20
	 * (螢幕)			lab2
	 * (使用者輸入)	20
	 * (螢幕)			lab3
	 * (使用者輸入)	20
	 * (螢幕)			mid-term
	 * (使用者輸入)	20
	 * (螢幕)			final exam
	 * (使用者輸入)	20
	 * (螢幕)		請確認新配分
	 * 		   			lab1           20%
     *            		lab2           20%
     *            		lab3           20%
     *            		mid-term       20%
     *            		final exam      20%
	 * 		   		以上正確嗎? Y (Yes) 或 N (No)
	 * (使用者輸入)	Y					[確認]
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E					[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?		
	 * (使用者輸入)	Q					[離開系統]
	 * (螢幕)		結束使用，系統關閉。	[離開訊息]
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
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n舊配分\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n輸入新配分(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t請確認新配分\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n以上正確嗎? Y (Yes) 或 N (No):輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_5(){
		String userInput = "955002056\nW\n20\n20\n20\n20\n20\nY\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n舊配分\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n輸入新配分(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t請確認新配分\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n以上正確嗎? Y (Yes) 或 N (No):輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_6()
	 * 此 test 用以測試 Normal Scenario
	 * 
	 * (螢幕)		輸入ID或 Q (結束使用)?
	 * (使用者輸入)	955002056			[存在的ID]
	 * (螢幕)		Welcome 許文馨
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	W					[顯示舊配分 ]
	 * (螢幕)		舊配分 
	 * 		   			lab1           10%
     *            		lab2           10%
     *            		lab3           10%
     *            		mid-term       30%
     *            		final exam      40%
	 * 				輸入新配分
	 * 					lab1
	 * (使用者輸入)	20
	 * (螢幕)			lab2
	 * (使用者輸入)	20
	 * (螢幕)			lab3
	 * (使用者輸入)	20
	 * (螢幕)			mid-term
	 * (使用者輸入)	20
	 * (螢幕)			final exam
	 * (使用者輸入)	20
	 * (螢幕)		請確認新配分
	 * 		   			lab1           20%
     *            		lab2           20%
     *            		lab3           20%
     *            		mid-term       20%
     *            		final exam      20%
	 * 		   		以上正確嗎? Y (Yes) 或 N (No)
	 * (使用者輸入)	N					[確認]
	 * (螢幕)		輸入指令
	 * 					1) G 顯示成績 (Grade)
	 * 					2) R 顯示排名 (Rank)
	 * 					3) A 顯示平均 (Average)
	 * 					4) W 更新配分 (Weight)
	 * 					5) E 離開選單 (Exit)
	 * (使用者輸入)	E					[離開選單]
	 * (螢幕)		輸入ID或 Q (結束使用)?		
	 * (使用者輸入)	Q					[離開系統]
	 * (螢幕)		結束使用，系統關閉。	[離開訊息]
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
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n舊配分\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n輸入新配分(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t請確認新配分\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n以上正確嗎? Y (Yes) 或 N (No):輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_6(){
		String userInput = "955002056\nW\n20\n20\n20\n20\n20\nN\n\nE\nQ\n";
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		Main.main(new String[] {});
		
		assertEquals("輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n舊配分\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n輸入新配分(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t請確認新配分\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n以上正確嗎? Y (Yes) 或 N (No):輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n", outContent.toString());
		
		System.setIn(System.in);
	}
}
