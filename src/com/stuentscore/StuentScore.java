package com.stuentscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class StuentScore {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int classCount = 3;	//暂定3个班
		int [] studentCount = {2, 3, 5};//暂定每个班的学生分别为2、3、5个学生(声明数组的同时初始化数组）
		double score[][] = new double [3][];
		for (int i=0; i < score.length; i++)	//初始化score，score.length：获得数组的行数
			score[i] = new double [studentCount[i]];
		
		//输入每个班每名同学的成绩
		String str;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < classCount; i++) {
			for(int k = 0; k < studentCount[i]; k++) {
				while(true) {
					System.out.print("请输入第" + (i + 1) + "个班第" + (k + 1) + "个学生的成绩：");
					
					/*读取一个文本行，遇到换行、回车后直接跟着换行认为某行已终止。如果已到达流末尾，则返回null*/
					str = buf.readLine();
					try {	//处理输入非数值数据或输入的数是0
						score [i][k] = Double.parseDouble(str);
						if(0 > score[i][k] || 100 < score[i][k]) {
							JOptionPane.showMessageDialog(null, "请重新输入成绩", "警告：成绩输入错误", 
									JOptionPane.QUESTION_MESSAGE);
						} else 
							break;	//break语句用来强行终止循环语句的执行，结束循环。break只是跳出所在层
					} catch (Exception ne) {
						JOptionPane.showMessageDialog(null, "请重新输入成绩", "提示信息", 
								JOptionPane.QUESTION_MESSAGE);
					}
				}
			}
			
		}
		//计算每个班的均分
		double sumScore = 0, avgScore = 0;
		for (int i = 0; i < score.length; i++) {
			sumScore = 0;
			for (int k = 0; k<studentCount[i]; k++)
				sumScore = sumScore + score[i][k];
			avgScore = sumScore / studentCount[i];
			System.out.println("第"+(i+1)+ "班的平均成绩为：" + avgScore);
		}

	}

}
