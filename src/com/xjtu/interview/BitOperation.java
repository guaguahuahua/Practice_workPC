package com.xjtu.interview;

/**
 * ʹ��λ������ʵ�ָ����������
 * @author Administrator
 */
public class BitOperation {

	/**
	 * ʹ����λ�Ĳ���ʵ�ֳ�2����
	 */
	public static void multiple() {
		System.out.println("3*8="+(3<<3));
	}
	
	/**
	 * �ж�һ�����Ƿ�Ϊ2����
	 * ʹ��λ��������Ϊ2����num����ֻ����1��1����num-1ֻ����һ��0
	 * ��������λ�������Ƿ�Ϊ0����ȷ���Ƿ�Ϊ2����
	 * @param num
	 * @return boolean
	 */
	public static boolean isPower(int num) {
		//����ֱ�ӷ���false
		if(num<0) {
			return false;
		}
		//�����Ϊ��������ô����λ������
		if((num & (num-1))==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * ͳ��һ�����ڶ�������ʽ���м���1
	 * ������ʹ����ϵͳ��Integer�İ�װ��
	 * @param num ��������
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
	 * ʹ�û����ķ���ʵ��ͳ��һ�����Ķ�������ʽ�ж��ٸ�1
	 * @param num ��������
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
		//ʹ��λ������ɳ�2
//		multiple();
		//�ж�һ�����Ƿ�Ϊ2����
		boolean res=isPower(9);
		System.out.println(res);
		int num=-8;
		System.out.println(countOnes_1(num));
		
	}

}
