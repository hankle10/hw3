///////////////////////////////////////////////////////////////////////////////
//
// Title:            grade-system
//		
//		��Grade system ���ϥΪ�(�ǥ�)���o�L���`���Z(total grade)�αƦW(rank).
//		�`���Z���t��(weights)�p��A�Ӱt���i�H��s. 
//		�ƦW��ܦ��`���Z�b���Z�ǥͤ������ƱƧ�
//		Input file �����Z�ǥͪ����ơA�p�U:
//			962001044 ��v�� 87 86 98 88 87
//			962001051 ���§� 81 32 50 90 93
//		�`�N data field names�A�p�U: 
//			ID name lab1 lab2 lab3 midTerm finalExam
//
// Files:            Main.java, UI.java, GradeSystems.java, Grades.java, CloseUIExceptions.java
//					 MainTest.java, GradeSystemsTest.java, GradesTest.java
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
/**
 * Main Class.
 * Represents the calling for a grade system interface and 
 * the handling of its closing.
 * 
 * Bugs: none known
 * 
 * @author       �}���
 * @version      1.0
 * @see also     UI, CloseUIExceptions
 */
public class Main extends Object{
	/**�����Z�t�Ϊ��ϥΪ̤���**/
	public static UI aUI;
	
	/**--------------------------------------------------------
	 *method main
	 *�����Z�t�Ϊ��D�禡�A�Y�{���}�l���a��
	 *
	 *@param	args	�R�O�C�޼�
	--------------------------------------------------------*/
	public static void main(String[] args) {
		try {
			/*1. call UI() �غc aUI*/
			aUI = new UI();
		}catch (CloseUIExceptions e1) {
			/*2. �Y catch a CloseUIExceptions, �R��UI object*/
			aUI = null;
		}
	}
}
