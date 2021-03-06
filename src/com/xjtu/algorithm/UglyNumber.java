package com.xjtu.algorithm;
/**
 * 只包含因子2，3，5数称为丑数，6，8是丑数，而14不是，因为包含了7
 * 一般的认为1是第一个丑数，返回第n个丑数
 * @author Administrator
 *
 */
public class UglyNumber {

	/**
	 * 暴力法，每个数轮流的整除2，3，5，直到商为1，如果2，3，5都无法整除，那么认为不是丑数
	 * @param n
	 * @return
	 */
	public static int uglyNumber(int n) {
	
		//首先认为1是一个丑数
		int res=Integer.MIN_VALUE;
		int start=1;
		n=n-1;
		start=start+1;
		while(n>0) {
			
			int s=start;
			boolean isUgly=false;
			while(s!=1) {
				boolean f1=false;
				boolean f2=false;
				boolean f3=false;
				
				if(s%2==0) {
					f1=true;
					s=s/2;
				}
				if(s%3==0) {
					f2=true;
					s=s/3;
				}
				if(s%5==0) {
					f3=true;
					s=s/5;
				}
				//只要含有一个因子即继续进行
				if(f1==true || f2==true || f3==true) {
					//如果除尽，那么就是丑数
					if(s==1) {
						isUgly=true;
						break;
					//没除尽继续	
					}else {
						continue;
					}
				//如果无法整除任何一个因子，那就不是丑数，退出	
				}else {
					break;
				}
			}
			//如果当前的数是丑数，那么标记该元素，并将寻找个数-1
			if(isUgly==true) {
				res=start;
				n=n-1;
			}
			start++;			
		}
		
		return res;
	}
	
	/**
	 * 剑指offer提供了一个更好的暴力破解方法
	 * @param n
	 * @return
	 */
	public static int uglyNumber_1(int n) {
	
		int start=1;
		while(n>0) {
			boolean flag=isUgly(start);
			if(flag==true) {
				n--;
			}
			start++;
		}		
		return start-1;
	}
	
	/**
	 * 判断一个输入的数是否为丑数
	 * @param num
	 * @return
	 */
	public static boolean isUgly(int num) {

		while(num%2==0) {
			num=num/2;
		}
		
		while(num%3==0) {
			num=num/3;
		}
		
		while(num%5==0) {
			num=num/5;
		}
		
		return num==1;
	}
	
	
	/**
	 * 使用前面的丑数，生成后面的丑数，速度加快，但是需要消耗n个存储空间
	 * @param n
	 * @return
	 */
	public static int uglyNumber_2(int n) {
		
		//生成长度为n的数组、
		int[] uglyNum=new int[n];
		uglyNum[0]=1;
		//生成索引
		int index2=0;
		int index3=0;
		int index5=0;
		//生成的新的丑数的索引
		int index=1;
		while(index<n) {
			//获得大于当前值最小的那个丑数
			int val=min(uglyNum[index2]*2, uglyNum[index3]*3, uglyNum[index5]*5);
			//这块保证前面已经计算过的值不再进行运算，只向后运算
			if(val==uglyNum[index2]*2) {
				index2++;
			}
			if(val==uglyNum[index3]*3) {
				index3++;
			}
			if(val==uglyNum[index5]*5) {
				index5++;
			}
			uglyNum[index]=val;
			index++;
		}
		
		return uglyNum[uglyNum.length-1];
	}
	
	
	/**
	 * 求三个数中的最小值
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int min(int a, int b, int c) {
		int temp=a<b ? a : b;
		return temp<c ? temp : c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=12;
		int res=uglyNumber_2(n);
		System.out.println(res);
	}

}
