///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// File:             Grades.java
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

/**
 * Grades Object.
 * Represents the information of a student's grade.
 * 
 * Bugs: none known
 * 
 * @author       ���ĵ�
 * @version      1.0
 * @see also     GradeSystems
 */
public class Grades implements Comparable<Grades>{
	/**
	 * �����Z�����̪��Ǹ��Ωm�W
	 * @uml.property  name="name"
	 */
	String name;

	/**
	 * �����Z�����̪��Ǹ��Ωm�W
	 * @uml.property  name="iD"
	 */
	String ID; 
	
	/**
	 * �����Z�����̪�lab1, lab2, lab3, midTerm�MfinalExam�����Z
	 * @uml.property  name="lab1"
	 */
	int lab1;

	/**
	 * �����Z�����̪�lab1, lab2, lab3, midTerm�MfinalExam�����Z
	 * @uml.property  name="lab2"
	 */
	int lab2;

	/**
	 * �����Z�����̪�lab1, lab2, lab3, midTerm�MfinalExam�����Z
	 * @uml.property  name="lab3"
	 */
	int lab3;

	/**
	 * �����Z�����̪�lab1, lab2, lab3, midTerm�MfinalExam�����Z
	 * @uml.property  name="midTerm"
	 */
	int midTerm;

	/**
	 * �����Z�����̪�lab1, lab2, lab3, midTerm�MfinalExam�����Z
	 * @uml.property  name="finalExam"
	 */
	int finalExam;
	
	/**
	 * �����Z�����̪��[�v�`���Z�`�M*100(���קK��T�ת���)
	 * @uml.property  name="totalGrade"
	 */
	int totalGrade;
	
	/**
	 * �����Z�����̪��ƦW
	 * @uml.property  name="rank"
	 */
	int rank;
	
	/**
	 * �����Z�����̪����Z����
	 * @uml.property  name="average"
	 */
	double average;
	
	/**--------------------------------------------------------
	 * constructor Grades
	 * �Ω�غc�@�� Grades object
	 *
	 * @param	�ϥΪ�lab1, lab2, lab3, midTerm, finalExam �����Z
	 *
	 * Example: aGrade = Grades("123456789","�����",90,90,80,80,85); ���ͤ@�� Grades object
	 --------------------------------------------------------*/
	public Grades(String ID, String name ,int lab1,int lab2,int lab3,int midTerm,int finalExam) { 
		/* ��l�ƦU�ܼƨíp�⦨�Z���� */
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
	 * �p��ϥΪ�lab1, lab2, lab3, midTerm, finalExam �����Z����
	 * �ñN���G�^��
	 *
	 * @return	���Z����
	 *
	 * Time estimate : O(1)
	 * Example: this.average = calculateAverage(); �Ǧ^���G����Grades object �� average
	 --------------------------------------------------------*/
	private double calculateAverage() {
		/*�p��X���Z�����æ^��*/
		return (double)(lab1+lab2+lab3+midTerm+finalExam)/5;		
	}	
	
	/**--------------------------------------------------------
	 * method getTotalGrade
	 * �N toatalGrade �ର object type �æ^��
	 *
	 * @return	totalGrade	 �[�v���Z�`�M(object type)
	 *
	 * Time estimate : O(1)
	 * Example: o = aGrade.getTotalGrade(); �Ǧ^���G�� toatalGrade �� object type
	 --------------------------------------------------------*/
	public Integer getTotalGrade(){
		/*1. �N toatalGrade �ର object type*/		
		Integer totalGrade = new Integer(this.totalGrade);
		
		/*2. �^�� toatalGrade �� object type*/
		return totalGrade;
	}
	
	
	/**
	 * -------------------------------------------------------- method setRank ��惡Grade object���ܼ�rank(�ƦW)
	 * @param rank  �����Z���ƦW  Time estimate : O(1)  Example: aGrade.setRank(1); �L�Ǧ^���G  --------------------------------------------------------
	 * @uml.property  name="rank"
	 */
	public void setRank(int rank){
		/*1. ��惡Grade object���ܼ�rank(�ƦW)*/
		this.rank = rank;
	}
	
	/**--------------------------------------------------------
	 * method calculateTotalGrade
	 * �p��ϥΪ�lab1, lab2, lab3, midTerm, finalExam ���[�v���Z�`�M
	 * �ñN���G�s�J�ܼ� totalGrade
	 *
	 * @param	weights	�@��float�}�C�A�]�tlab1, lab2, lab3, midTerm, finalExam ���v�� (ex. [0.1,0.1,0.1,0.3,0.4])
	 *
	 * Time estimate : O(1)
	 * Example: calculateTotalGrade(weights); �L�Ǧ^���G
	 --------------------------------------------------------*/
	public void calculateTotalGrade(float[] weights) {
		/*1. �N���Z�t�ε����v���@�@���W100�A�æs����ư}�C*/
		int[] weights_multiply_100 = new int[5];
		int i;
		for(i=0;i<5;i++){
			weights_multiply_100[i] = (int)(weights[i]*100);
		}
		
		/*2. �p��ϥΪ�lab1, lab2, lab3, midTerm, finalExam ���[�v���Z�`�M�ñN���G�s�J�ܼ� totalGrade*/
		totalGrade = weights_multiply_100[0]*lab1+ weights_multiply_100[1]*lab2+ weights_multiply_100[2]*lab3+ weights_multiply_100[3]*midTerm+weights_multiply_100[4]*finalExam;
	}
	
	/**--------------------------------------------------------
	 * method compareTo
	 * �ΥH���Grade objects�������j�p�A�H��K�i��Ƨ�
	 * 
	 * @param	o	�@��Grades object
	 * 
	 * @return	�@�ӥN���Ӫ���j�p���������
	 *
	 * Time estimate : O(1)
	 * Example: aGrade.compareTo(otherGrade); �YaGrade����j�A�h�Ǧ^-1
	 --------------------------------------------------------*/
	public int compareTo(Grades o) {
		/*1. ���o��Grade object���[�v�`���Z�`�M*/
		Integer totalGrade = new Integer(this.totalGrade);
		
		/*2. ������Grade objects�����[�v�`���Z�`�M���j�p�ñN������G�^��*/
		return (-1)*(totalGrade.compareTo(o.getTotalGrade()));
	}
}