package com.xjtu.interview;

public class CountHowManyWords {
	
	/**
	 * ͳ��һ�е��ʵĸ���
	 * ���ַ�����ȱ�����ڽ����׵Ŀո����
	 * @param s
	 * @return int 
	 */
	private static int countHowManyWords(String s) {
		//�������Ϊ0ֱ���˳�
		if(s.length()==0) {
			return -1;
		}
		String []words=s.split("\\s+");
		return words.length;
	}
	
	/**
	 * ת��Ϊ�ַ�����ķ�ʽʵ�ֵ��ʸ���ͳ��
	 * @param s
	 * @return int
	 */
	private static int countHowManyWords_1(String s) {
		if(s.length()==0) {
			return -1;
		}
		char []chars=s.toCharArray();
		boolean space=true;
		int count=0;
		for(int i=0; i<chars.length; i++) {
			//�����ǰ�ַ���Ϊ�ո񣬲���ǰ���ǿո�
			if(chars[i]!=' ' && space) {
				space=false;
				count++;
			}else if(chars[i]==' '){
				space=true;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="    I am      zhou   ";
		int nums=countHowManyWords_1(s);
		System.out.println(nums);
	}

}
