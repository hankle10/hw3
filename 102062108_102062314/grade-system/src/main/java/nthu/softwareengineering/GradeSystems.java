///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             GradeSystems.java
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
 * @author       ���ĵ�
 * @version      1.0
 * @see also     Grades
 */
public class GradeSystems {
	/**�� Grade System �����Z�v��**/
	public static float[] weights = new float[5];
	
	/**�� Grade System �����Z�M��**/
	static public Grades[] aList;	

	/**�� Grade System ��ID���ު�**/
	static public String[] IDList;
	
	/**
	 * �� Grade System �����Z�ƶq
	 * @uml.property  name="gradeCount"
	 */
	public int gradeCount;
		
	/**--------------------------------------------------------
	 *constructor GradeSystems
	 *��l�� weights �ܼơA��Ū���ɮץH�غc�@��GradeSystems object
	 *
	 *Example: aGradeSystem = GradeSystems() ; ���ͤ@�� GradeSystems object
	 --------------------------------------------------------*/
	public GradeSystems(){	
		/* 1. �Nweights�}�C��l�ơA���O���w�U�ƭ� */		 
		weights[0] = (float)0.1;//lab1
		weights[1] = (float)0.1;//lab2
		weights[2] = (float)0.1;//lab3
		weights[3] = (float)0.3;//midterm
		weights[4] = (float)0.4;//finalExam
		
		/* 2. Ū�����Z�M���ɮ� */
		if(readFile("C:\\Users\\user\\Documents\\NTHU\\Software_Engineering\\HW1_grp\\input.txt")==false) System.out.printf("���Z�M���ɮ�Ū�����ѡC\n");
				
		/* 3. �ƧǦ����Z�M�椤�Ҧ� Grades object �� rank �A�إ߯��ު�A�ñN���Ƨǵ��G���O�s�J�Ҧ� Grades object*/	
		else calculateRanks();	
	}
	
	/**--------------------------------------------------------
	 *method readFile
	 *Ū�����Z�M���ɮ�
	 *
	 *@param	fileName	�nŪ�J���ɮצW��
	 *
	 *@return 	boolean false:	if catches an IOException
	 *			boolean true: otherwise
	 *
	 *Time estimate:O(n)				n �O ���ɮת����e�j�p
	 *Example: readFile("input.txt");	���]���ɮצ��@�ʦ�A�h�^�ǵ��G��100
	 **------------------------------------------------------*/
	private boolean readFile(String fileName){
		BufferedReader fileContent = null;
		try {
			/*1.��X���ɮצ��X�� */
			gradeCount = countLines(fileName);
			
			/*2. �غcan empty list of grades�s  aList(���Z�M��)*/
			aList = new Grades[gradeCount];
			
			/*3. �@��檺Ū�ɡA�ñN���e�s�i aList(���Z�M��)��*/
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
	 *��X���ɮצ��X��
	 *
	 *@param	fileName	Ū�i�Ӫ��ɮצW��
	 *
	 *@return 	lineCount		���ɮת����
	 *
	 *Time estimate:O(n)
	 *Example: lines = countLines(filename); ���]���ɮצ��@�ʦ�A�h�^�ǵ��G��100
	 **------------------------------------------------------*/	
	private int countLines(String fileName) throws IOException {
		/*1. �@��檺Ū�ɡA��X�ɮת����*/
		BufferedReader fileContent = new BufferedReader(new FileReader(fileName));
		int lineCount = 0;
		while (fileContent.readLine() != null) lineCount++;
		fileContent.close();
		return lineCount;
	}
	
	/**--------------------------------------------------------
	 * method processLine
	 * ��java scanner �B�z�ɮ׸̪��@���r�A�NID, �m�W, ���Z����T���O���X�Өæs�i���Z�M�椤
	 *
	 * @param	line		�ɮ׸̪��@����r
	 * @param	listIndex	��ܲ{�b�n�s���O�ĴX�� grades object
	 *
	 * Time estimate:O(1)
	 * Example: processLine(fileLine, listIndex); �L�Ǧ^���G
	 **------------------------------------------------------*/
	private void processLine(String line,int listIndex) {
		Scanner scanner= new Scanner(line);
		String ID,name;
		int lab1,lab2,lab3,midTerm,finalExam;	
		
		/*1.�� Java Scanner �v��Ū�J�U���*/
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
		
		/*2. �غc�@�� Grades object �ñN��s�J aList(���Z�M��) */
		addGradesObject(listIndex, ID, name,lab1,lab2,lab3,midTerm,finalExam);
	}
	
	/**--------------------------------------------------------
	 * method addGradesObject
	 * �غc�@�� Grades object �ñN��s�J aList(���Z�M��)
	 *
	 * @param	listIndex	��ܲ{�b�n�s���O�ĴX�� grades object
	 * @param	ID			�����Z�֦��̪��Ǹ�
	 * @param	name		�����Z�֦��̪��m�W
	 * @param	lab1		lab1���Z
	 * @param	lab2		lab2���Z
	 * @param	lab3		lab3���Z
	 * @param	midTerm		midTerm���Z
	 * @param	finalExam	finalExam���Z
	 *
	 * Time estimate:O(1)
	 * Example: addGradesObject(listIndex, ID, name,lab1,lab2,lab3,midTerm,finalExam); �L�Ǧ^���G
	 **------------------------------------------------------*/
	private void addGradesObject(int listIndex, String ID,String name,int lab1,int lab2,int lab3,int midTerm,int finalExam){
		/*1. �غc�@�� Grades object �ñN��s�J aList(���Z�M��) */
		aList[listIndex] = new Grades(ID, name,lab1,lab2,lab3,midTerm,finalExam);
		
		/*2. �ھڦ����Z�t�Ϊ��v���p�⦹ Grades object �� totalGrade */
		aList[listIndex].calculateTotalGrade(weights);
	}
	
	/**--------------------------------------------------------
	 * method calculateRanks
	 * �ƧǩҦ����Z�M�椤�����Z�A�إ߯��ު�A�ñN�Ƨǵ��G�@�@�s�J���Z�M�椤
	 *
	 * Time estimate: O(nlgn)	n �O���Z�M�椺�����Z�ƶq
	 * Example: calculateRanks(); �L�Ǧ^���G
	 **------------------------------------------------------*/	
	private void calculateRanks(){
		/*1. �إߤ@�ӪŪ�ID���ު�*/
		IDList = new String[gradeCount];
		int currentTotalGrade=-1, currentRank=1;
		
		/*2. �ƧǦ��Z�M��(aList)*/
		Arrays.sort(aList);
		int i;
		for(i=0;i<gradeCount;i++){
			
			/*3. �N��X���ƦW���G�A�[�W�P����ܦP�W�����Ҽ{�A�@�@�s�Jgrades object*/
			if(aList[i].totalGrade == currentTotalGrade) aList[i].setRank(currentRank);
			else{
				currentRank = i+1;
				currentTotalGrade = aList[i].totalGrade;
				aList[i].setRank(currentRank);
			}
			
			/*4. �P�ɤ]�NID�@�@�s�J���ު�*/
			IDList[i] = aList[i].ID;
		}
	}	
	
	/**--------------------------------------------------------
	 *method showGrade
	 *��ܦ�ID�ϥΪ̪��Ҧ����Z(lab1, lab2, lab3, midTerm, finalExam, totalGrade)
	 *
	 *@param ID �@�ӥΩ��O Grades object ���r��(a user ID, ex: 123456789)
	 *
	 *Time estimate:O(lgn)	n �O���Z�M�椺�����Z�ƶq
	 *Example: aGradeSystem.showGrade(123456789);	��̹����ͦ�ID�ϥΪ̪��Ҧ����Z(lab1, lab2, lab3, midTerm, finalExam, totalGrade)
	 **------------------------------------------------------*/
	public void showGrade(String ID) {
		/*1. �ϥί��ު�A�q���Z�M�椤��X�֦���ID��Grades object*/
		int i = Arrays.asList(IDList).indexOf(ID);
		
		/*2. �⦹ID �Ҧb��Grades object���Ҧ����Z(lab1, lab2, lab3, midTerm, finalExam, totalGrade)��ܥX��*/
		char fail='*',pass=' ';
		int totalGrade = Math.round((float)aList[i].totalGrade/100);
		System.out.printf("%s���Z:\n\tlab1:\t\t%d%c\n\tlab2:\t\t%d%c\n\tlab3:\t\t%d%c\n\tmid-term:\t%d%c\n\tfinal exam:\t%d%c\n\ttotal grade:\t%d%c\n",aList[i].name,aList[i].lab1,(aList[i].lab1<60)?fail:pass,aList[i].lab2,(aList[i].lab2<60)?fail:pass,aList[i].lab3,(aList[i].lab3<60)?fail:pass,aList[i].midTerm,(aList[i].midTerm<60)?fail:pass,aList[i].finalExam,(aList[i].finalExam<60)?fail:pass,totalGrade,(totalGrade<60)?fail:pass);
	}
	   
	/**--------------------------------------------------------
	 *method showRank
	 *��ܥX��ID�ϥΪ̪��ƦW
	 *
	 *@param ID �@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	 *
	 *Time estimate:O(lgn)	n �O���Z�M�椺�����Z�ƶq
	 *Example: aGradeSystem.showRank(123456789);	���G��̹����ͦ�ID�ϥΪ̪��ƦW
	 **-------------------------------------------------------*/
	public void showRank(String ID){
		/*1. �ϥί��ު�A�q���Z�M�椤��X�֦���ID��Grades object*/
		int i = Arrays.asList(IDList).indexOf(ID);
		
		/*2. �⦹ID �Ҧb��Grades object�� rank����ܩ�̹�*/
		System.out.printf("%s�ƦW��%d\n",aList[i].name, aList[i].rank);
	} 
	
	/**--------------------------------------------------------
	 *method showName
	 * ��ܥX�� ID �ϥΪ̪��m�W
	 *
	 *@param ID �@�ӥΩ��O grades object ���r��(a user ID, ex: 955002056)
	 *
	 *Time estimate:O(n)	n �O���Z�M�椺�����Z�ƶq
	 *Example: name = aGradeSystem.showName(955002056); ���G��̹����ͦ�ID�ϥΪ̪��m�W
	 **-------------------------------------------------------*/
	public void showName(String ID){
		/*1. �ϥί��ު�A�q���Z�M�椤��X�֦���ID��Grades object*/
		int i = Arrays.asList(IDList).indexOf(ID);
		
		/*2. �⦹ID �ϥΪ̪��m�W��ܩ�̹�*/
		System.out.printf("%s",aList[i].name);		   
	}

	/**--------------------------------------------------------
	 *method showAverage
	 * ��ܥX�� ID �ϥΪ̪����Z����
	 *
	 *@param ID �@�ӥΩ��O grades object ���r��(a user ID, ex: 955002056)
	 *
	 *Time estimate:O(n)	n �O���Z�M�椺�����Z�ƶq
	 *Example: name = aGradeSystem.showName(955002056); ���G��̹���ܥX��ID�ϥΪ̪����Z����
	 **-------------------------------------------------------*/
	public void showAverage(String ID){	
		/*1. ���o�o ID �����Z��������ܩ�̹�*/
		int i = Arrays.asList(IDList).indexOf(ID);
		System.out.printf("%s����%.2f\n",aList[i].name,aList[i].average);

	}
	

	/**--------------------------------------------------------
	 *method showOldWeights
	 *��̹���ܥX�ª����v��
	 *
	 *Time estimate:O(1)
	 *Example: aGradeSystem.showOldWeights(); ���G��̹���ܥX�����Z�t�Ϊ��v��
	 --------------------------------------------------------*/
	public void  showOldWeights() {
		/*1. ��ܦ����Z�t�Ϊ����v�� */
		System.out.printf("�°t��\n\tlab1\t%d%%\n\tlab2\t%d%%\n\tlab3\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n",(int)(weights[0]*100),(int)(weights[1]*100),(int)(weights[2]*100),(int)(weights[3]*100),(int)(weights[4]*100));
	}
	
	
	/**--------------------------------------------------------
	 *method setNewWeights
	 *�Y�ϥΪ̽T�{���A�h����v��
	 *
	 *@param	update			�ϥΪ̿�J���T�{�r��("Y"��"N"�A��ܬO�_�T�{�ק�)
	 *@param	newWeights		�ϥΪ̿�J���s�v��
	 *
	 *Time estimate:	O(nlgn)
	 *Example: aGradeSystem.setWeights(update, newWeights); �L�Ǧ^���G
	 --------------------------------------------------------*/
	public void setNewWeights(String update, int[] newWeights) {
		if(update.equals("Y")){
			/*1. �Y�ϥΪ̽T�{���A�N�����Z�t�Ϊ����v���אּ�ϥΪ̿�J���� */	
			int i;
			for(i=0;i<5;i++) weights[i]=(float)newWeights[i]/100;

			/*2. �åB���s�p�⦨�Z�M�椤�Ҧ����Z�`�M�αƦW*/	
			for(i=0; i<gradeCount; i++){
				aList[i].calculateTotalGrade(weights);
			}			
			calculateRanks();
		}
	}
 
	
	
	
	/**--------------------------------------------------------
	 *method containsID
	 *�� ID �O�_�t�b aGradeSystem�����Z�M�椺
	 *
	 *@param	ID �@�ӥΩ��O grades object ���r��(a user ID, ex: 123456789)
	 *
	 *@return	boolean true: 	�Y�� GradeSystems object �����Z�M�椤�s�b�֦��� ID �� grades object
	 *			boolean false:	otherwise
	 *
	 *Time estimate:O(lgn)
	 *Example: containsID(123456789); ���]ID ���s�b�� aGradeSystem�A�h�Ǧ^���G�� false
	 --------------------------------------------------------*/
	public boolean containsID(String ID){ 
		/*1. �ˬdID���ު�A�ݦ� ID �O�_�t�b���Z�M�椺*/
		int i = Arrays.asList(IDList).indexOf(ID);
		if (i >=0)
			return true;
		else 
			return false;
	}		

}




