package com.xjtu.interview;

public class CountHowManyWords {
	
	/**
	 * 统计一行单词的个数
	 * 该种方法的缺陷在于将行首的空格计入
	 * @param s
	 * @return int 
	 */
	private static int countHowManyWords(String s) {
		//如果长度为0直接退出
		if(s.length()==0) {
			return -1;
		}
		String []words=s.split("\\s+");
		return words.length;
	}
	
	/**
	 * 转化为字符数组的方式实现单词个数统计
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
			//如果当前字符不为空格，并且前面是空格
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
