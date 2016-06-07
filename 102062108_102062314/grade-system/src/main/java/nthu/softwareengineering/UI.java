///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             UI.java
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
import java.util.Scanner;

/**
 * UI object.
 * Represents a user interface for a grade system.
 *
 * Bugs: none known
 *
 * @author       �}���
 * @version      1.0
 * @see also     GradeSystems
 */
public class UI {
	
	/**
	 * �� user interface �Ҿާ@�����Z�t�Τ��e
	 * @uml.property  name="aGradeSystem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public GradeSystems aGradeSystem;
	
	/**�� UI �Ψ�Ū����J���ܼ�**/
	public static Scanner scanner; 
	
	/** ------------------------------------------------------------------------------
	* constructor UI
	* �Ω�غc�@�� UI object
	* 
	* @throws	CloseUIExceptions
	* 			if �ϥΪ̵����ϥΦ��t��
	* 
	* Example: aUI = new UI(); 	���ͤ@�� UI object
	------------------------------------------------------------------------------*/
	public UI()throws CloseUIExceptions{
		/*1. ��l�� UI �Ψ�Ū����J���ܼ�*/
		scanner = new Scanner(System.in);
		try {
			/*2.call GradeSystems() �غc aGradeSystem*/
			aGradeSystem = new GradeSystems();
						
			/*3. loop1 until Q (Quit)
			 *  	1. �n�D�ϥΪ̿�JID�� Q (�����ϥ�)
			 *   	2. �Y��J���OID�A�h�ˬd ID �O�_�b aGradeSystem��
			 *   	3. �Y�O�A����w��T��; �Y�_�A�L�X���~�T��
			 *   	4. loop2 until E (Exit)
			 *   			1. ����ϥΪ̿�J�����O�����}���(E) 
			 *   	   end loop2
			 *   end loop1*/
			String ID="";
			while(true){				
				ID=promptID();			
				if(ID.equals("Q")) break;
				else if(checkID(ID)==false) System.out.print("��ID���s�b!\n");
				else{
					showWelcomeMsg(ID);
					while(promptCommand(ID)){}
				}
			}			
						
			/*4. ��ܲפ�T��*/
			showFinishMsg();	
			throw new CloseUIExceptions();
		}finally {}
	}
	
	/** ------------------------------------------------------------------------------
	 * method promptID
	 * �n�D�ϥΪ̿�J ID �� Q�A�æ^�Ǧ� ID �Φr��"Q"
	 * 
	 * @return	ID	�ϥΪ̿�J�� ID �Φr�� "Q"
	 * 
	 * Time estimate: O(1)
	 * Example: ID = promptID (); �Ǧ^���G���ϥΪ�ID
	 ------------------------------------------------------------------------------*/
	private String promptID(){
		/*1. �n�D�ϥΪ̿�J ID �� Q*/
		System.out.print("��JID�� Q (�����ϥ�)?");
		String ID = scanner.next();	

		/*2. �^�� ID �� "Q"*/
		return ID;
	}
	
	/** ------------------------------------------------------------------------------
	* method checkID 
	* �I�s�� method �A�Ǧ^�@�� boolean �ȥN�� aGradeSystem ���O�_�s�b�㦳 ID �� grade object
	* 
	* @param	ID	�@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	* 
	* @return	boolean true:	�YaGradeSystem ���s�b�㦳 ID �� grades object
	* 			boolean false:	otherwise
	*  
	* Time estimate: O(n)	n �O aGradeSystem �����Z�H��
	* Example: checkID(ID); ���]ID ���s�b�� aGradeSystem�A�h�Ǧ^���G�� false
	------------------------------------------------------------------------------*/
	private boolean checkID(String ID){
		/*1. �� aGradeSystem �ˬd ID �O�_�b���Z�M�椺�A�Y�O, �^��true */
		if(aGradeSystem.containsID(ID)) return true;
		
		/*2. �Y�_, �^�� false*/
		else return false;		
	}
	
	/** ------------------------------------------------------------------------------
	* method promptCommand 
	* �n�D�ϥΪ̿�J inputCommand�A�ñN�� inputCommand �ǵ� method executeCommand�h����
	* 
	* @param	ID	�@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	* 
	* @return	boolean true:	if executeCommand(inputCommand) returns true
	* 			boolean false:	otherwise
	* 
	* Time estimate: O(n)			n �O aGradeSystem �����Z�H��
	* Example: promptCommand("123456789"); 	���]�ϥΪ̿�J"E"�A�h�^�� false
	------------------------------------------------------------------------------*/
	private boolean promptCommand(String ID){
		/*1. �n�D�ϥΪ̿�J inputCommand */
		System.out.print("��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n");
		String inputCommand;
		inputCommand = scanner.next();		
		
		/*2. �N�ϥΪ̿�J���R�O�ǵ� executeCommand �h����*/
		if(executeCommand(ID, inputCommand)) return true;
		else return false;
	}
	
	/** ------------------------------------------------------------------------------
	* method executeCommand
	* �ھ� inputCommand ����R�O
	* 
	* @param	ID				�@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	* @param	inputCommand	�@�ӥΩ��O�ϥΪ̩R�O���r��(ex. "G" �����ܦ��Z)
	* 
	* @return	boolean false:	�Y inputCommand �O E (Exit)
	* 			boolean true:	otherwise
	* 
	* Time estimate: O(n)			n �O aGradeSystem �����Z�H��
	* Example: executeCommand("G");	�Ǧ^���G��true
	------------------------------------------------------------------------------*/
	private boolean executeCommand(String ID, String inputCommand){
		/*1. if inputCommand is:
		 *  	case E: ���}���, return false 
		 * 		case G: ��ܦ��Z (Grade)
		 * 		case R: ��ܱƦW (Rank)
		 * 		case A: ��ܥ��� (Average)
		 * 		case W: ��s�t�� (Weight)
		 */
		if(inputCommand.equals("E")) return false;
		else if(inputCommand.equals("G")) aGradeSystem.showGrade(ID);
		else if(inputCommand.equals("R")) aGradeSystem.showRank(ID);
		else if(inputCommand.equals("A")) aGradeSystem.showAverage(ID);
		else if(inputCommand.equals("W")) updateWeights(ID);
		
		/*2. else : �ëD G (Grade),R (Rank), W (Weights), �� E (Exit)�A�]���L�X���~�T�� */
		else System.out.printf("�����O���s�b!\n");
		return true;
	}

	/**--------------------------------------------------------
	 *method updateWeights
	 *��s���Z�t�Ϊ��v��
	 *
	 *@param ID �@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	 *
	 *Time estimate:O(nlgn)	n �O���Z�M�椺�����Z�ƶq
	 *Example: updateWeights() ;��������ª��v���A�M��n�D�ϥΪ̿�J�s���v���A�̫�n�D�ϥΪ̽T�{�O�_���A�Y�O�A�h����v��
	 --------------------------------------------------------*/
	private void  updateWeights (String ID) {
		/*1. ����ª��v�� */
		aGradeSystem.showOldWeights();
		
		/*2. �n�D�ϥΪ̿�J�s���v�� */
		int[] newWeights = new int[5];
		newWeights = getNewWeights();
		if(newWeights[0]+newWeights[1]+newWeights[2]+newWeights[3]+newWeights[4]!=100){
			System.out.printf("�t���`�M����100!\n");
		}
		else{		
			/*3. �n�D�ϥΪ̽T�{�O�_���A�Y�O�A�h����v��*/
			System.out.print("�нT�{�s�t��\n");
			System.out.printf("\tlab1\t%d%%\n\tlab2\t%d%%\n\tlab3\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n",newWeights[0],newWeights[1],newWeights[2],newWeights[3],newWeights[4]);
			System.out.print("�H�W���T��? Y (Yes) �� N (No):");
			String update = scanner.next();
			aGradeSystem.setNewWeights(update,newWeights);
		}
	}
	
	/**--------------------------------------------------------
	 *method getNewWeights
	 *���o�ϥΪ̿�J���s�v��
	 *
	 *@return	newWeights	�@��int�}�C�A�N��ϥΪ̿�J���s�v��
	 *
	 *Time estimate:O(1)
	 *Example: newWeights = getNewWeights(); �N�ϥΪ̿�J���s�v���^��
	 --------------------------------------------------------*/
	private int[] getNewWeights () {
		int [] newWeights = new int[5];
		/*1. Ū���ϥΪ̿�J���v��*/
		System.out.printf("��J�s�t��(%%)\n");
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
		/*2. �N�ϥΪ̿�J���v���^��*/
		return newWeights;
	}
	
	/** ------------------------------------------------------------------------------
	 * method showFinishMsg
	 * �L�X�פ�T��
	 * 
	 * Time estimate: O(1)
	 * Example: showFinishMsg(); �L�Ǧ^���G
	 ------------------------------------------------------------------------------*/
	private void showFinishMsg(){
		/*1. �L�X�����T��*/
		System.out.print("�����ϥΡA�t�������C\n");
	}

	/** ------------------------------------------------------------------------------
	 * method showWelcomeMsg
	 * �L�X�w��T��
	 * 
	 * @param	ID �@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	 * 
	 * Time estimate: O(n)
	 * Example: showWelcomeMsg("123456789"); �L�Ǧ^���G
	------------------------------------------------------------------------------ */
	private void showWelcomeMsg(String ID){
		/*1. �L�X�w��T��*/
		System.out.print("Welcome ");
		
		/*2. �L�X��ID�ϥΪ̪��m�W*/
		aGradeSystem.showName(ID);
		System.out.print("\n");
	}	
}
