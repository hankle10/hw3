///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             Grades.java
// Semester:         Spring 2016
// Course:			 Software Engineering
//
// Author:           朱凰華
// Email:            ambitious_816@hotmail.com
//
// Pair Partner:     徐芷翎
// Email:            oranse0720@gmail.com
//
///////////////////////////////////////////////////////////////////////////////

package nthu.softwareengineering;

/**
 * Grades Object.
 * Represents the information of a student's grade.
 * 
 * Bugs: none known
 * 
 * @author       朱凰華
 * @version      1.0
 * @see also     GradeSystems
 */
public class Grades implements Comparable<Grades>{
	/**
	 * 此成績持有者的學號及姓名
	 * @uml.property  name="name"
	 */
	String name;

	/**
	 * 此成績持有者的學號及姓名
	 * @uml.property  name="iD"
	 */
	String ID; 
	
	/**
	 * 此成績持有者的lab1, lab2, lab3, midTerm和finalExam的成績
	 * @uml.property  name="lab1"
	 */
	int lab1;

	/**
	 * 此成績持有者的lab1, lab2, lab3, midTerm和finalExam的成績
	 * @uml.property  name="lab2"
	 */
	int lab2;

	/**
	 * 此成績持有者的lab1, lab2, lab3, midTerm和finalExam的成績
	 * @uml.property  name="lab3"
	 */
	int lab3;

	/**
	 * 此成績持有者的lab1, lab2, lab3, midTerm和finalExam的成績
	 * @uml.property  name="midTerm"
	 */
	int midTerm;

	/**
	 * 此成績持有者的lab1, lab2, lab3, midTerm和finalExam的成績
	 * @uml.property  name="finalExam"
	 */
	int finalExam;
	
	/**
	 * 此成績持有者的加權總成績總和*100(為避免精確度的遺失)
	 * @uml.property  name="totalGrade"
	 */
	int totalGrade;
	
	/**
	 * 此成績持有者的排名
	 * @uml.property  name="rank"
	 */
	int rank;
	
	/**
	 * 此成績持有者的成績平均
	 * @uml.property  name="average"
	 */
	double average;
	
	/**--------------------------------------------------------
	 * constructor Grades
	 * 用於建構一個 Grades object
	 *
	 * @param	使用者lab1, lab2, lab3, midTerm, finalExam 的成績
	 *
	 * Example: aGrade = Grades("123456789","李曉明",90,90,80,80,85); 產生一個 Grades object
	 --------------------------------------------------------*/
	public Grades(String ID, String name ,int lab1,int lab2,int lab3,int midTerm,int finalExam) { 
		/* 初始化各變數並計算成績平均 */
		this.ID = ID;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
		this.totalGrade = 0;
		this.rank = 0;
		this.average = calculateAverage();
	} 		
	
	/**--------------------------------------------------------
	 * method calculateAverage
	 * 計算使用者lab1, lab2, lab3, midTerm, finalExam 的成績平均
	 * 並將結果回傳
	 *
	 * @return	成績平均
	 *
	 * Time estimate : O(1)
	 * Example: this.average = calculateAverage(); 傳回結果為此Grades object 的 average
	 --------------------------------------------------------*/
	private double calculateAverage() {
		/*計算出成績平均並回傳*/
		return (double)(lab1+lab2+lab3+midTerm+finalExam)/5;		
	}	
	
	/**--------------------------------------------------------
	 * method getTotalGrade
	 * 將 toatalGrade 轉為 object type 並回傳
	 *
	 * @return	totalGrade	 加權成績總和(object type)
	 *
	 * Time estimate : O(1)
	 * Example: o = aGrade.getTotalGrade(); 傳回結果為 toatalGrade 的 object type
	 --------------------------------------------------------*/
	public Integer getTotalGrade(){
		/*1. 將 toatalGrade 轉為 object type*/		
		Integer totalGrade = new Integer(this.totalGrade);
		
		/*2. 回傳 toatalGrade 的 object type*/
		return totalGrade;
	}
	
	
	/**
	 * -------------------------------------------------------- method setRank 更改此Grade object的變數rank(排名)
	 * @param rank  此成績的排名  Time estimate : O(1)  Example: aGrade.setRank(1); 無傳回結果  --------------------------------------------------------
	 * @uml.property  name="rank"
	 */
	public void setRank(int rank){
		/*1. 更改此Grade object的變數rank(排名)*/
		this.rank = rank;
	}
	
	/**--------------------------------------------------------
	 * method calculateTotalGrade
	 * 計算使用者lab1, lab2, lab3, midTerm, finalExam 的加權成績總和
	 * 並將結果存入變數 totalGrade
	 *
	 * @param	weights	一個float陣列，包含lab1, lab2, lab3, midTerm, finalExam 的權重 (ex. [0.1,0.1,0.1,0.3,0.4])
	 *
	 * Time estimate : O(1)
	 * Example: calculateTotalGrade(weights); 無傳回結果
	 --------------------------------------------------------*/
	public void calculateTotalGrade(float[] weights) {
		/*1. 將成績系統給的權重一一乘上100，並存成整數陣列*/
		int[] weights_multiply_100 = new int[5];
		int i;
		for(i=0;i<5;i++){
			weights_multiply_100[i] = (int)(weights[i]*100);
		}
		
		/*2. 計算使用者lab1, lab2, lab3, midTerm, finalExam 的加權成績總和並將結果存入變數 totalGrade*/
		totalGrade = weights_multiply_100[0]*lab1+ weights_multiply_100[1]*lab2+ weights_multiply_100[2]*lab3+ weights_multiply_100[3]*midTerm+weights_multiply_100[4]*finalExam;
	}
	
	/**--------------------------------------------------------
	 * method compareTo
	 * 用以比較Grade objects之間的大小，以方便進行排序
	 * 
	 * @param	o	一個Grades object
	 * 
	 * @return	一個代表兩個物件大小比較的正數
	 *
	 * Time estimate : O(1)
	 * Example: aGrade.compareTo(otherGrade); 若aGrade比較大，則傳回-1
	 --------------------------------------------------------*/
	public int compareTo(Grades o) {
		/*1. 取得此Grade object的加權總成績總和*/
		Integer totalGrade = new Integer(this.totalGrade);
		
		/*2. 比較兩個Grade objects之間加權總成績總和的大小並將比較結果回傳*/
		return (-1)*(totalGrade.compareTo(o.getTotalGrade()));
	}
}