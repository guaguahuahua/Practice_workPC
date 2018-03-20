package com.xjtu.algorithm;

import java.io.File;

public class FileRetrieve {
	public static int count=0;
	public static void findFile(String filePath, File file) {
		//�����ǰ���ļ���Ŀ¼
		if(file.isDirectory()) {
			//��õ�ǰĿ¼�µ������ļ�
			File []subFile=file.listFiles();
			//��Ŀ¼�µ������ļ����б�����
			for(int i=0; i<subFile.length; i++) {
				//������ļ�����ô����������Ŀ¼����ô�������б���
				if(subFile[i].isDirectory()) {
					findFile(subFile[i].getAbsolutePath(), subFile[i]);
				}else {
					count++;
					System.out.println(subFile[i].getAbsolutePath());	
				}
			}
		//�����ǰ���ļ�����Ŀ¼��ôֱ�����	
		}else {
			count++;
			System.out.println(file.getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="F:\\";
		findFile(filePath, new File(filePath));
		System.out.println("�ļ�������ĿΪ��"+count);
	}

}
