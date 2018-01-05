package com.xjtu.interview;

/**
 * 使用位操作来实现各种运算操作
 * @author Administrator
 */
public class BitOperation {

	/**
	 * 使用移位的操作实现乘2的幂
	 */
	public static void multiple() {
		System.out.println("3*8="+(3<<3));
	}
	
	/**
	 * 判断一个数是否为2的幂
	 * 使用位操作，因为2的幂num总是只含有1个1，而num-1只含有一个0
	 * 两个进行位运算结果是否为0就能确定是否为2的幂
	 * @param num
	 * @return boolean
	 */
	public static boolean isPower(int num) {
		//负数直接返回false
		if(num<0) {
			return false;
		}
		//如果不为负数，那么进行位与运算
		if((num & (num-1))==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 统计一个数在二进制形式下有几个1
	 * 这是在使用了系统的Integer的包装类
	 * @param num 输入数字
	 * @return int
	 */
	public static int countOnes(int num) {
		Integer a = 0;
		String res=a.toBinaryString(num);
		int count=0;
		for(int i=0; i<res.length(); i++) {
			if(res.charAt(i)=='1') {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 使用基本的方法实现统计一个数的二进制形式有多少个1
	 * @param num 输入整数
	 * @return int 
	 */
	public static int countOnes_1(int num) {
		int count=0;
		while(num!=0) {
			int t=(num & 1);
			if(t==1) {
				count++;
			}
			num=num>>1;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用位操作完成乘2
//		multiple();
		//判断一个数是否为2的幂
		boolean res=isPower(9);
		System.out.println(res);
		int num=-8;
		System.out.println(countOnes_1(num));
		
	}

}
