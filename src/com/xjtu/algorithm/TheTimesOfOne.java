package com.xjtu.algorithm;
/**
 * 统计从1到n中十进制数1出现的次数
 * @author Administrator
 *
 */
public class TheTimesOfOne {

	/**
	 * 分别统计从各个位上面1出现的次数
	 * @param n
	 * @return
	 */
	public static int theTimesOfOne(int n) {
		
		int count=0;
		String num=n+"";
		int left;
		int right;
		String l, r;
		for(int i=num.length()-1; i>=0; i--) {
			//获得当前位的数
			int c=num.charAt(i)-'0';
			if(c==0) {
				l=num.substring(0, i);
				if(!l.equals("")) {
					left=Integer.parseInt(l);					
				}else {
					left=0;
				}
				count=count+left*(int) Math.pow(10, num.length()-1-i);
			}else if(c==1) {
				l=num.substring(0, i);
				r=num.substring(i+1, num.length());
				if(!l.equals("")) {
					left=Integer.parseInt(l);
				}else {
					left=0;
				}
				if(!r.equals("")) {
					right=Integer.parseInt(r);	
				}else {
					right=0;
				}
				count=count+left*(int) Math.pow(10, num.length()-1-i)+right+1;
			}else {
				//如果当前位不为0和1，
				l=num.substring(0, i);
				if(!l.equals("")) {
					left=Integer.parseInt(l);
				}else {
					left=0;
				}
				count=count+(left+1)*(int) Math.pow(10, num.length()-i-1);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=21;
		int res=theTimesOfOne(n);
		System.out.println(res);
	}

}
