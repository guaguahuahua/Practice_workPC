package com.xjtu.algorithm;

/**
 * 判断输入的字符串表示的是否为浮点数
 * @author Administrator
 *
 */
public class JudgeIsFloat {

	public static boolean judgeIsFloat(String s) {
		int dian=0;
		int e=0;
		int E=0;
		int positive=0;
		int negative=0;
		//第一次过滤不合理的字符，并统计一些关键的字符出现次数
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//如果是数字和浮点的基本的符号
			if(!(c=='+' || c=='-' || c=='E' || c=='e' || c=='.' || c>='0' && c<='9')) {
				return false;
			}else if(c=='.'){
				dian++;
			}else if(c=='e') {
				e++;
			}else if(c=='E') {
				E++;
			}else if(c=='+') {
				positive++;
			}else if(c=='-') {
				negative++;
			}
			if(dian>1 || e>1 || E>1 || positive>2 || negative>2) {
				return false;
			}
		}
		//如果满足浮点数的符号条件，现在判断格式是否正确
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//如果是正负号
			if(c=='+' || c=='-') {
				//如果+-有出现了两次
				if(positive==2 || negative==2) {
					if(c=='+') {
						int i1=s.lastIndexOf('+');
						boolean t1=checkValidation(s, i1);
						if(checkValidation(s, i)==false || t1==false) {
							return false;
						}
					}else if(c=='-') {
						int i2=s.lastIndexOf('-');
						boolean t2=checkValidation(s, i2);
						if(checkValidation(s, i)==false || t2==false) {
							return false;
						}
					}
				//只出现一次	
				}else {
					if(checkValidation(s, i)==false) {
						return false;
					}
				}
			//如果是小数点	
			}else if(c=='.') {
				//小数点出现在数字 开始或者 结束 的位置
				if(i==0 || i==s.length()-1) {
					return false;
				}
			}else if(c=='E' || c=='e') {
				//如果出现位置是第一个或最后一个位置
				if(i==0 || i==s.length()-1) {
					return false;
				//向后搜索，如果存在小数点，则错	
				}else {
					int index=s.lastIndexOf('.');
					if(index>i) {
						return false;
					}
				}
			}
			
			
		}
		
		return true;
	}
	
	/**
	 * 检查合法性
	 * @return
	 */
	public static boolean checkValidation(String s, int pos) {
		
		//如果符号位就在第一个位置
		if(pos==0) {
			return true;
		//如果不在第一个位置	
		}else {
			//获得正负号前面的那个字符
			char c=s.charAt(pos-1);
			if(c=='e' || c=='E') {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="";
		String s1="+100";
		String s2="5e2";
		String s3="-123";
		String s4="3.1416";
		String s5="-1E-16"; //true
		
		String s6="12e";
		String s7="1a3.14";
		String s8="-+5";
		String s9="12e+4.3";
		boolean res=judgeIsFloat(s9);
		System.out.println(res);
	}

}
