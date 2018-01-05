package com.xjtu.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestIOSystem {
	
	/**
	 * ²âÊÔJavaµÄIOÏµÍ³
	 * @throws IOException 
	 */
	private static void testIOSystem(){
		String fileName="E:\\fileName.txt";
		FileInputStream in = null;
		try {
			in=new FileInputStream(fileName);
			String s=in.toString();
			System.out.println(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void testFileClass() {
		String filePath="E:\\";
		File file=new File(filePath);
		String path="E:/fileName";
		File text=new File(path);
		System.out.println(text.delete());
//		System.out.println(text.mkdir());
//		System.out.println(text.isFile());
		System.out.println(text.isDirectory());
		System.out.println(text.exists());;
//		if(file.isDirectory()) {
//			File []fileArray=file.listFiles();
//			for(int i=0; i<fileArray.length; i++) {
//				System.out.println(fileArray[i].getName());
//			}
//		}
	}
	public static void main(String []args) {
//		TestIOSystem.testIOSystem();		
		TestIOSystem.testFileClass();
	}
}
