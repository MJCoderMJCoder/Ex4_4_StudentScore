package com.stuentscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class StuentScore {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int classCount = 3;	//�ݶ�3����
		int [] studentCount = {2, 3, 5};//�ݶ�ÿ�����ѧ���ֱ�Ϊ2��3��5��ѧ��(���������ͬʱ��ʼ�����飩
		double score[][] = new double [3][];
		for (int i=0; i < score.length; i++)	//��ʼ��score��score.length��������������
			score[i] = new double [studentCount[i]];
		
		//����ÿ����ÿ��ͬѧ�ĳɼ�
		String str;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < classCount; i++) {
			for(int k = 0; k < studentCount[i]; k++) {
				while(true) {
					System.out.print("�������" + (i + 1) + "�����" + (k + 1) + "��ѧ���ĳɼ���");
					
					/*��ȡһ���ı��У��������С��س���ֱ�Ӹ��Ż�����Ϊĳ������ֹ������ѵ�����ĩβ���򷵻�null*/
					str = buf.readLine();
					try {	//�����������ֵ���ݻ����������0
						score [i][k] = Double.parseDouble(str);
						if(0 > score[i][k] || 100 < score[i][k]) {
							JOptionPane.showMessageDialog(null, "����������ɼ�", "���棺�ɼ��������", 
									JOptionPane.QUESTION_MESSAGE);
						} else 
							break;	//break�������ǿ����ֹѭ������ִ�У�����ѭ����breakֻ���������ڲ�
					} catch (Exception ne) {
						JOptionPane.showMessageDialog(null, "����������ɼ�", "��ʾ��Ϣ", 
								JOptionPane.QUESTION_MESSAGE);
					}
				}
			}
			
		}
		//����ÿ����ľ���
		double sumScore = 0, avgScore = 0;
		for (int i = 0; i < score.length; i++) {
			sumScore = 0;
			for (int k = 0; k<studentCount[i]; k++)
				sumScore = sumScore + score[i][k];
			avgScore = sumScore / studentCount[i];
			System.out.println("��"+(i+1)+ "���ƽ���ɼ�Ϊ��" + avgScore);
		}

	}

}
