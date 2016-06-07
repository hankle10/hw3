///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             UI.java
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
import java.util.Scanner;

/**
 * UI object.
 * Represents a user interface for a grade system.
 *
 * Bugs: none known
 *
 * @author       徐芷翎
 * @version      1.0
 * @see also     GradeSystems
 */
public class UI {
	
	/**
	 * 此 user interface 所操作的成績系統內容
	 * @uml.property  name="aGradeSystem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public GradeSystems aGradeSystem;
	
	/**此 UI 用來讀取輸入的變數**/
	public static Scanner scanner; 
	
	/** ------------------------------------------------------------------------------
	* constructor UI
	* 用於建構一個 UI object
	* 
	* @throws	CloseUIExceptions
	* 			if 使用者結束使用此系統
	* 
	* Example: aUI = new UI(); 	產生一個 UI object
	------------------------------------------------------------------------------*/
	public UI()throws CloseUIExceptions{
		/*1. 初始化 UI 用來讀取輸入的變數*/
		scanner = new Scanner(System.in);
		try {
			/*2.call GradeSystems() 建構 aGradeSystem*/
			aGradeSystem = new GradeSystems();
						
			/*3. loop1 until Q (Quit)
			 *  	1. 要求使用者輸入ID或 Q (結束使用)
			 *   	2. 若輸入的是ID，則檢查 ID 是否在 aGradeSystem內
			 *   	3. 若是，顯示歡迎訊息; 若否，印出錯誤訊息
			 *   	4. loop2 until E (Exit)
			 *   			1. 執行使用者輸入的指令或離開選單(E) 
			 *   	   end loop2
			 *   end loop1*/
			String ID="";
			while(true){				
				ID=promptID();			
				if(ID.equals("Q")) break;
				else if(checkID(ID)==false) System.out.print("此ID不存在!\n");
				else{
					showWelcomeMsg(ID);
					while(promptCommand(ID)){}
				}
			}			
						
			/*4. 顯示終止訊息*/
			showFinishMsg();	
			throw new CloseUIExceptions();
		}finally {}
	}
	
	/** ------------------------------------------------------------------------------
	 * method promptID
	 * 要求使用者輸入 ID 或 Q，並回傳此 ID 或字串"Q"
	 * 
	 * @return	ID	使用者輸入的 ID 或字串 "Q"
	 * 
	 * Time estimate: O(1)
	 * Example: ID = promptID (); 傳回結果為使用者ID
	 ------------------------------------------------------------------------------*/
	private String promptID(){
		/*1. 要求使用者輸入 ID 或 Q*/
		System.out.print("輸入ID或 Q (結束使用)?");
		String ID = scanner.next();	

		/*2. 回傳 ID 或 "Q"*/
		return ID;
	}
	
	/** ------------------------------------------------------------------------------
	* method checkID 
	* 呼叫此 method ，傳回一個 boolean 值代表 aGradeSystem 中是否存在具有 ID 的 grade object
	* 
	* @param	ID	一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	* 
	* @return	boolean true:	若aGradeSystem 中存在具有 ID 的 grades object
	* 			boolean false:	otherwise
	*  
	* Time estimate: O(n)	n 是 aGradeSystem 內全班人數
	* Example: checkID(ID); 假設ID 不存在於 aGradeSystem，則傳回結果為 false
	------------------------------------------------------------------------------*/
	private boolean checkID(String ID){
		/*1. 讓 aGradeSystem 檢查 ID 是否在成績清單內，若是, 回傳true */
		if(aGradeSystem.containsID(ID)) return true;
		
		/*2. 若否, 回傳 false*/
		else return false;		
	}
	
	/** ------------------------------------------------------------------------------
	* method promptCommand 
	* 要求使用者輸入 inputCommand，並將此 inputCommand 傳給 method executeCommand去執行
	* 
	* @param	ID	一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	* 
	* @return	boolean true:	if executeCommand(inputCommand) returns true
	* 			boolean false:	otherwise
	* 
	* Time estimate: O(n)			n 是 aGradeSystem 內全班人數
	* Example: promptCommand("123456789"); 	假設使用者輸入"E"，則回傳 false
	------------------------------------------------------------------------------*/
	private boolean promptCommand(String ID){
		/*1. 要求使用者輸入 inputCommand */
		System.out.print("輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n");
		String inputCommand;
		inputCommand = scanner.next();		
		
		/*2. 將使用者輸入的命令傳給 executeCommand 去執行*/
		if(executeCommand(ID, inputCommand)) return true;
		else return false;
	}
	
	/** ------------------------------------------------------------------------------
	* method executeCommand
	* 根據 inputCommand 執行命令
	* 
	* @param	ID				一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	* @param	inputCommand	一個用於辨別使用者命令的字串(ex. "G" 表示顯示成績)
	* 
	* @return	boolean false:	若 inputCommand 是 E (Exit)
	* 			boolean true:	otherwise
	* 
	* Time estimate: O(n)			n 是 aGradeSystem 內全班人數
	* Example: executeCommand("G");	傳回結果為true
	------------------------------------------------------------------------------*/
	private boolean executeCommand(String ID, String inputCommand){
		/*1. if inputCommand is:
		 *  	case E: 離開選單, return false 
		 * 		case G: 顯示成績 (Grade)
		 * 		case R: 顯示排名 (Rank)
		 * 		case A: 顯示平均 (Average)
		 * 		case W: 更新配分 (Weight)
		 */
		if(inputCommand.equals("E")) return false;
		else if(inputCommand.equals("G")) aGradeSystem.showGrade(ID);
		else if(inputCommand.equals("R")) aGradeSystem.showRank(ID);
		else if(inputCommand.equals("A")) aGradeSystem.showAverage(ID);
		else if(inputCommand.equals("W")) updateWeights(ID);
		
		/*2. else : 並非 G (Grade),R (Rank), W (Weights), 或 E (Exit)，因此印出錯誤訊息 */
		else System.out.printf("此指令不存在!\n");
		return true;
	}

	/**--------------------------------------------------------
	 *method updateWeights
	 *更新成績系統的權重
	 *
	 *@param ID 一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	 *
	 *Time estimate:O(nlgn)	n 是成績清單內的成績數量
	 *Example: updateWeights() ;首先顯示舊的權重，然後要求使用者輸入新的權重，最後要求使用者確認是否更改，若是，則更改權重
	 --------------------------------------------------------*/
	private void  updateWeights (String ID) {
		/*1. 顯示舊的權重 */
		aGradeSystem.showOldWeights();
		
		/*2. 要求使用者輸入新的權重 */
		int[] newWeights = new int[5];
		newWeights = getNewWeights();
		if(newWeights[0]+newWeights[1]+newWeights[2]+newWeights[3]+newWeights[4]!=100){
			System.out.printf("配分總和須為100!\n");
		}
		else{		
			/*3. 要求使用者確認是否更改，若是，則更改權重*/
			System.out.print("請確認新配分\n");
			System.out.printf("\tlab1\t%d%%\n\tlab2\t%d%%\n\tlab3\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n",newWeights[0],newWeights[1],newWeights[2],newWeights[3],newWeights[4]);
			System.out.print("以上正確嗎? Y (Yes) 或 N (No):");
			String update = scanner.next();
			aGradeSystem.setNewWeights(update,newWeights);
		}
	}
	
	/**--------------------------------------------------------
	 *method getNewWeights
	 *取得使用者輸入的新權重
	 *
	 *@return	newWeights	一個int陣列，代表使用者輸入的新權重
	 *
	 *Time estimate:O(1)
	 *Example: newWeights = getNewWeights(); 將使用者輸入的新權重回傳
	 --------------------------------------------------------*/
	private int[] getNewWeights () {
		int [] newWeights = new int[5];
		/*1. 讀取使用者輸入的權重*/
		System.out.printf("輸入新配分(%%)\n");
		System.out.printf("\tlab1\t");
		newWeights[0]=scanner.nextInt();
		System.out.printf("\tlab2\t");
		newWeights[1]=scanner.nextInt();
		System.out.printf("\tlab3\t");
		newWeights[2]=scanner.nextInt();
		System.out.printf("\tmid-term\t");
		newWeights[3]=scanner.nextInt();
		System.out.printf("\tfinal exam\t");
		newWeights[4]=scanner.nextInt();	
		/*2. 將使用者輸入的權重回傳*/
		return newWeights;
	}
	
	/** ------------------------------------------------------------------------------
	 * method showFinishMsg
	 * 印出終止訊息
	 * 
	 * Time estimate: O(1)
	 * Example: showFinishMsg(); 無傳回結果
	 ------------------------------------------------------------------------------*/
	private void showFinishMsg(){
		/*1. 印出結束訊息*/
		System.out.print("結束使用，系統關閉。\n");
	}

	/** ------------------------------------------------------------------------------
	 * method showWelcomeMsg
	 * 印出歡迎訊息
	 * 
	 * @param	ID 一個用於辨別 grades object 的字串(a user ID, ex: 123456789)
	 * 
	 * Time estimate: O(n)
	 * Example: showWelcomeMsg("123456789"); 無傳回結果
	------------------------------------------------------------------------------ */
	private void showWelcomeMsg(String ID){
		/*1. 印出歡迎訊息*/
		System.out.print("Welcome ");
		
		/*2. 印出此ID使用者的姓名*/
		aGradeSystem.showName(ID);
		System.out.print("\n");
	}	
}
