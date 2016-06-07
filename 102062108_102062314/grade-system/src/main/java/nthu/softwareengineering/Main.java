///////////////////////////////////////////////////////////////////////////////
//
// Title:            grade-system
//		
//		本Grade system 讓使用者(學生)取得他的總成績(total grade)及排名(rank).
//		總成績基於配分(weights)計算，而配分可以更新. 
//		排名表示此總成績在全班學生中的分數排序
//		Input file 為全班學生的分數，如下:
//			962001044 凌宗廷 87 86 98 88 87
//			962001051 李威廷 81 32 50 90 93
//		注意 data field names，如下: 
//			ID name lab1 lab2 lab3 midTerm finalExam
//
// Files:            Main.java, UI.java, GradeSystems.java, Grades.java, CloseUIExceptions.java
//					 MainTest.java, GradeSystemsTest.java, GradesTest.java
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
/**
 * Main Class.
 * Represents the calling for a grade system interface and 
 * the handling of its closing.
 * 
 * Bugs: none known
 * 
 * @author       徐芷翎
 * @version      1.0
 * @see also     UI, CloseUIExceptions
 */
public class Main extends Object{
	/**此成績系統的使用者介面**/
	public static UI aUI;
	
	/**--------------------------------------------------------
	 *method main
	 *此成績系統的主函式，即程式開始的地方
	 *
	 *@param	args	命令列引數
	--------------------------------------------------------*/
	public static void main(String[] args) {
		try {
			/*1. call UI() 建構 aUI*/
			aUI = new UI();
		}catch (CloseUIExceptions e1) {
			/*2. 若 catch a CloseUIExceptions, 刪除UI object*/
			aUI = null;
		}
	}
}
