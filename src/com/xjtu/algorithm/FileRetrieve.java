package com.xjtu.algorithm;

import java.io.File;

public class FileRetrieve {
	public static int count=0;
	public static void findFile(String filePath, File file) {
		//如果当前的文件是目录
		if(file.isDirectory()) {
			//获得当前目录下的所有文件
			File []subFile=file.listFiles();
			//对目录下的所有文件进行遍历，
			for(int i=0; i<subFile.length; i++) {
				//如果是文件，那么输出，如果是目录，那么继续进行遍历
				if(subFile[i].isDirectory()) {
					findFile(subFile[i].getAbsolutePath(), subFile[i]);
				}else {
					count++;
					System.out.println(subFile[i].getAbsolutePath());	
				}
			}
		//如果当前的文件不是目录那么直接输出	
		}else {
			count++;
			System.out.println(file.getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath="F:\\";
		findFile(filePath, new File(filePath));
		System.out.println("文件的总数目为："+count);
	}

}
