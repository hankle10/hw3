///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             GradeSystems.java
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

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * GradeSystems Object.
 * Represents a grade system object, which has 
 * methods of all the operations doing directly to its content.
 * 
 * Bugs: none known
 * 
 * @author       朱凰華
 * @version      1.0
 * @see also     Grades
 */
public class GradeSystems {
	/**此 Grade System 的成績權重**/
	public static float[] weights = new float[5];
	
	/**此 Grade System 的成績清單**/
	static public Grades[] aList;	

	/**此 Grade System 的ID索引表**/
	static public String[] IDList;
	
	/**
	 * 此 Grade System 的成績數量
	 * @uml.property  name="gradeCount"
	 */
	public int gradeCount;
		
	/**--------------------------------------------------------
	 *constructor GradeSystems
	 *初始化 weights 變數，並讀取檔案以建構一個GradeSystems object
	 *
	 *Example: aGradeSystem = GradeSystems() ; 產生一個 GradeSystems object
	 --------------------------------------------------------*/
	public GradeSystems(){	
		/* 1. 將weights陣列初始化，分別指定各數值 */		 
		weights[0] = (float)0.1;//lab1
		weights[1] = (float)0.1;//lab2
		weights[2] = (float)0.1;//lab3
		weights[3] = (float)0.3;//midterm
		weights[4] = (float)0.4;//finalExam
		
		/* 2. 讀取成績清單檔案 */
		if(readFile("C:\\Users\\user\\Documents\\NTHU\\Software_Engineering\\HW1_grp\\input.txt")==false) System.out.printf("成績清單檔案讀取失敗。\n");
				
		/* 3. 排序此成績清單中所有 Grades object 的 rank ，建立索引表，並將此排序結果分別存入所有 Grades object*/	
		else calculateRanks();	
	}
	
	/**--------------------------------------------------------
	 *method readFile
	 *讀取成績清單檔案
	 *
	 *@param	fileName	要讀入的檔案名稱
	 *
	 *@return 	boolean false:	if catches an IOException
	 *			boolean true: otherwise
	 *
	 *Time estimate:O(n)				n 是 此檔案的內容大小
	 *Example: readFile("input.txt");	假設此檔案有一百行，則回傳結果為100
	 **------------------------------------------------------*/
	private boolean readFile(String fileName){
		BufferedReader fileContent = null;
		try {
			/*1.算出此檔案有幾行 */
			gradeCount = countLines(fileName);
			
			/*2. 建構an empty list of grades叫  aList(成績清單)*/
			aList = new Grades[gradeCount];
			
			/*3. 一行行的讀檔，並將內容存進 aList(成績清單)中*/
			fileContent = new BufferedReader(new FileReader(fileName));
			int nowCount;
			String sCurrentLine;
			for (nowCount = 0;(sCurrentLine = fileContent.readLine()) != null; nowCount++) processLine(sCurrentLine,nowCount);
			fileContent.close();
		} catch (IOException e) {	
			return false;
		} finally {}
		return true;
	}
	
	/**--------------------------------------------------------
	 *method countLines
	 *算出此檔案有幾行
	 *
	 *@param	fileName	讀進來的檔案名稱
	 *
	 *@return 	lineCount		此檔案的行數
	 *
	 *Time estimate:O(n)
	 *Example: lines = countLines(filename); 假設此檔案有一百行，則回傳結果為100
	 **------------------------------------------------------*/	
	private int countLines(String fileName) throws IOException {
		/*1. 一行行的讀檔，算出檔案的行數*/
		BufferedReader fileContent = new BufferedReader(new FileReader(fileName));
		int lineCount = 0;
		while (fileContent.readLine() != null) lineCount++;
		fileContent.close();
		return lineCount;
	}
	
	/**--------------------------------------------------------
	 * method processLine
	 * 用java scanner 處理檔案裡的一行文字，將ID, 姓名, 成績等資訊分別取出來並存進成績清單中
	 *
	 * @param	line		檔案裡的一行行文字
	 * @param	listIndex	表示現在要存的是第幾個 grades object
	 *
	 * Time estimate:O(1)
	 * Example: processLine(fileLine, listIndex); 無傳回結果
	 **------------------------------------------------------*/
	private void processLine(String line,int listIndex) {
		Scanner scanner= new Scanner(line);
		String ID,name;
		int lab1,lab2,lab3,midTerm,finalExam;	
		
		/*1.用 Java Scanner 逐行讀入各欄位*/
		ID = scanner.next();
		name = scanner.next();		
		while(!scanner.hasNextInt())
			name += scanner.next();		
		lab1 = scanner.nextInt();
		lab2 = scanner.nextInt();
		lab3 = scanner.nextInt();
		midTerm = scanner.nextInt();
		finalExam = scanner.nextInt();
		scanner.close();		
		
		/*2. 建構一個 Grades object 並將其存入 aList(成績清單) */
		addGradesObject(listIndex, ID, name,lab1,lab2,lab3,midTerm,finalExam);
	}
	
	/**--------------------------------------------------------
	 * method addGradesObject
	 * 建構一個 Grades object 並將其存入 aList(成績清單)
	 *
	 * @param	listIndex	表示現在要存的是第幾個 grades object
	 * @param	ID			此成績擁有者的學號
	 * @param	name		此成績擁有者的姓名
	 * @param	lab1		lab1成績
	 * @param	lab2		lab2成績
	 * @param	lab3		lab3成績
	 * @param	midTerm		midTerm成績
	 * @param	finalExam	finalExam成績
	 *
	 * Time estimate:O(1)
	 * Example: addGradesObject(listIndex, ID, name,lab1,lab2,lab3,midTerm,finalExam); 無傳回結果
	 **------------------------------------------------------*/
	private void addGradesObject(int listIndex, String ID,String name,int lab1,int lab2,int lab3,int midTerm,int finalExam){
		/*1. 建構一個 Grades object 並將其存入 aList(成績清單) */
		aList[listIndex] = new Grades(ID, name,lab1,lab2,lab3,midTerm,finalExam);
		
		/*2. 根據此成績系統的權重計算此 Grades object 的 totalGrade */
		aList[listIndex].calculateTotalGrade(weights);
	}
	
	/**--------------------------------------------------------
	 * method calculateRanks
	 * 排序所有成績清單中的成績，建立索引表，並將排序結果一一存入成績清單中
	 *
	 * Time estimate: O(nlgn)	n 是成績清單內的成績數量
	 * Example: calculateRanks(); 無傳回結果
	 **------------------------------------------------------*/	
	private void calculateRanks(){
		/*1. 建立一個空的ID索引表*/
		IDList = new String[gradeCount];
		int currentTotalGrade=-1, currentRank=1;
		
		/*2. 排序成績清單(aList)*/
		Arrays.sort(aList);
		int i;
		for(i=0;i<gradeCount;i++){
			
			/*3. 將算出的排名結果，加上同分表示同名次的考慮，一一存入grades object*/
			if(aList[i].totalGrade == currentTotalGrade) aList[i].setRank(currentRank);
			else{
				currentRank = i+1;
				currentTotalGrade = aList[i].totalGrade;
				aList[i].setRank(currentRank);
			}
			
			/*4. 同時也將ID一一存入索引表中*/
			IDList[i] = aList[i].ID;
		}
	}	
	
	/**--------------------------------------------------------
	 *method showGrade
	 *顯示此ID使用者的所有成績(lab1, lab2, lab3, midTerm, finalExam, totalGrade)
	 *
	 *@param ID 一個用於辨別 Grades object 的字串(a user ID, ex: 123456789)
	 *
	 *Time estimate:O(lgn)	n 是成績清單內的成績數量
	 *Example: aGradeSystem.showGrade(123456789);	於屏幕產生此ID使用者的所有成績(lab1, lab2, lab3, midTerm, finalExam, totalGrade)
	 **------------------------------------------------------*/
	public void showGrade(String ID) {
		/*1. 使用索引表，從成績清單中找出擁有此ID的Grades object*/
		int i = Arrays.asList(IDList).indexOf(ID);
		
		/*2. 把此ID 所在的Grades object的所有成績(lab1, lab2, lab3, midTerm, finalExam, totalGrade)顯示出來*/
		char fail='*',pass=' ';
		int totalGrade = Math.round((float)aList[i].totalGrade/100);
		System.out.printf("%s成績:\n\tlab1:\t\t%d%c\n\tlab2:\t\t%d%c\n\tlab3:\t\t%d%c\n\tmid-term:\t%d%c\n\tfinal exam:\t%d%c\n\ttotal grade:\t%d%c\n",aList[i].name,aList[i].lab1,(aList[i].lab1<60)?fail:pass,aList[i].lab2,(aList[i].lab2<60)?fail:pass,aList[i].lab3,(aList[i].lab3<60)?fail:pass,aList[i].midTerm,(aList[i].midTerm<60)?fail:pass,aList[i].finalExam,(aList[i].finalExam<60)?fail:pass,totalGrade,(totalGrade<60)?fail:pass);
	}
	   
	/**--------------------------------------------------------
	 *method showRank
	 *顯示出此ID使用者的排名
	 *
	 *@param ID 一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	 *
	 *Time estimate:O(lgn)	n 是成績清單內的成績數量
	 *Example: aGradeSystem.showRank(123456789);	結果於屏幕產生此ID使用者的排名
	 **-------------------------------------------------------*/
	public void showRank(String ID){
		/*1. 使用索引表，從成績清單中找出擁有此ID的Grades object*/
		int i = Arrays.asList(IDList).indexOf(ID);
		
		/*2. 把此ID 所在的Grades object的 rank並顯示於屏幕*/
		System.out.printf("%s排名第%d\n",aList[i].name, aList[i].rank);
	} 
	
	/**--------------------------------------------------------
	 *method showName
	 * 顯示出此 ID 使用者的姓名
	 *
	 *@param ID 一個用於辨別 grades object 的字串(a user ID, ex: 955002056)
	 *
	 *Time estimate:O(n)	n 是成績清單內的成績數量
	 *Example: name = aGradeSystem.showName(955002056); 結果於屏幕產生此ID使用者的姓名
	 **-------------------------------------------------------*/
	public void showName(String ID){
		/*1. 使用索引表，從成績清單中找出擁有此ID的Grades object*/
		int i = Arrays.asList(IDList).indexOf(ID);
		
		/*2. 把此ID 使用者的姓名顯示於屏幕*/
		System.out.printf("%s",aList[i].name);		   
	}

	/**--------------------------------------------------------
	 *method showAverage
	 * 顯示出此 ID 使用者的成績平均
	 *
	 *@param ID 一個用於辨別 grades object 的字串(a user ID, ex: 955002056)
	 *
	 *Time estimate:O(n)	n 是成績清單內的成績數量
	 *Example: name = aGradeSystem.showName(955002056); 結果於屏幕顯示出此ID使用者的成績平均
	 **-------------------------------------------------------*/
	public void showAverage(String ID){	
		/*1. 取得這 ID 的成績平均後顯示於屏幕*/
		int i = Arrays.asList(IDList).indexOf(ID);
		System.out.printf("%s平均%.2f\n",aList[i].name,aList[i].average);

	}
	

	/**--------------------------------------------------------
	 *method showOldWeights
	 *於屏幕顯示出舊的的權重
	 *
	 *Time estimate:O(1)
	 *Example: aGradeSystem.showOldWeights(); 結果於屏幕顯示出此成績系統的權重
	 --------------------------------------------------------*/
	public void  showOldWeights() {
		/*1. 顯示此成績系統的的權重 */
		System.out.printf("舊配分\n\tlab1\t%d%%\n\tlab2\t%d%%\n\tlab3\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n",(int)(weights[0]*100),(int)(weights[1]*100),(int)(weights[2]*100),(int)(weights[3]*100),(int)(weights[4]*100));
	}
	
	
	/**--------------------------------------------------------
	 *method setNewWeights
	 *若使用者確認更改，則更改權重
	 *
	 *@param	update			使用者輸入的確認字串("Y"或"N"，表示是否確認修改)
	 *@param	newWeights		使用者輸入的新權重
	 *
	 *Time estimate:	O(nlgn)
	 *Example: aGradeSystem.setWeights(update, newWeights); 無傳回結果
	 --------------------------------------------------------*/
	public void setNewWeights(String update, int[] newWeights) {
		if(update.equals("Y")){
			/*1. 若使用者確認更改，將此成績系統的的權重改為使用者輸入的值 */	
			int i;
			for(i=0;i<5;i++) weights[i]=(float)newWeights[i]/100;

			/*2. 並且重新計算成績清單中所有成績總和及排名*/	
			for(i=0; i<gradeCount; i++){
				aList[i].calculateTotalGrade(weights);
			}			
			calculateRanks();
		}
	}
 
	
	
	
	/**--------------------------------------------------------
	 *method containsID
	 *看 ID 是否含在 aGradeSystem的成績清單內
	 *
	 *@param	ID 一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	 *
	 *@return	boolean true: 	若此 GradeSystems object 的成績清單中存在擁有此 ID 的 grades object
	 *			boolean false:	otherwise
	 *
	 *Time estimate:O(lgn)
	 *Example: containsID(123456789); 假設ID 不存在於 aGradeSystem，則傳回結果為 false
	 --------------------------------------------------------*/
	public boolean containsID(String ID){ 
		/*1. 檢查ID索引表，看此 ID 是否含在成績清單內*/
		int i = Arrays.asList(IDList).indexOf(ID);
		if (i >=0)
			return true;
		else 
			return false;
	}		

}




