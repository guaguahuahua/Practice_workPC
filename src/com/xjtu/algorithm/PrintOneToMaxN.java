package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ӡ��1�����nλ��
 * ��һ�ַ�ʽ���������nȻ��ֱ�ӱ������������ǻᷢ����������n�ܴ��ڻ������͵ı�ʾ��Χ�ڣ��ͻᵼ�����������
 * �ڶ��ַ�ʽ��ʹ������ķ�ʽʵ�֣�����ĳ���Ϊn+1����ʼ������Ϊ0��֮�󲻶ϵĸ���������λ+1��ֱ��0λ���������ֹͣ������Ϊ��õķ�ʽ�����ᷢ������������Ͽ���ʵ�����е�Ҫ��
 * �����ַ�ʽ���������һ��ȫ���У���ȫ�����ǿ���ͨ��������������ʽ��ʵ�ֵģ�����n��Ӧ�����������ܻ����
 * @author Administrator
 *
 */
public class PrintOneToMaxN {

	/**
	 * n��[1,5]�����ڵ�������
	 * ���ݸ�����n��������nλ����Ȼ��ͨ�������ķ�ʽʵ��
	 * ���ֱ��ʵ�֣���ô���������ܾͻᳬ���������͵ķ�Χ
	 * @param n
	 */
	public static void printOneToMaxN(int n) {
		
		if(n<1 || n>5) {
			
			System.out.println("����nԽ�磡");
			return;
		}
		int max=0;
		//��������nλ��
		while(n>=1) {
			max=max+9*(int)Math.pow(10,n-1);
			n--;
		}
		
		//�����1������nλ��֮���������
		for(int i=1; i<=max; i++) {
//			System.out.println(i);
		}
		System.out.println("end");
	}
	
	/**
	 * ͨ��ʹ������ķ�ʽ��ʵ�ֱ���
	 * ���볤��Ϊn+1���������飬ÿ�θ����λ��1�����ϱ���
	 * ��ֹ����Ϊ������ĵ�0λΪ1��Ҳ���Ƿ��������
	 * @param n
	 */
	public static void printOneToMaxN_1(int n) {
		
		int[] max=new int[n+1];
		int low=max.length-1;
		
		//���û�з��������Ҳ����û�дﵽ���ֵ
		while(max[0]!=1){
			//���Ǹ����λ+1
			addOne(max, low);
			
			//����������ж������Ϊ�˱������ֵ���������Ϊ���ֵʱwhileѭ�������������+1����֮���������������ʱ��ѭ���ڲ���Ȼ���Լ��������
			//�Ӷ��������ֵ�������������Ӹ����֮�󣬵���Ч���½���ÿ�ζ����ж�����Ƿ����
			if(max[0]!=1) {
				//�����ǰ����
				print(max);	
			}
		}
	}
	
	/**
	 * �������Ӧ��posλ��+1
	 * @param nums
	 * @param pos
	 */
	public static void addOne(int []nums, int pos) {

		//�ݹ�ĳ���
		if(pos<0) {
			return;
		}		
		//�����ǰλ������λ����ô�͵ݹ���жϸ�λ�Ƿ�Ҳ�����˽�λ
		if(nums[pos]+1>9) {
			nums[pos]=0;
			addOne(nums, pos-1);
		}else {
			nums[pos]=nums[pos]+1;
			return ;
		}
	}
	
	
	/**
	 * ���һ�������е����з���Ԫ��
	 * @param nums
	 */
	public static void print(int []nums) {
		
		boolean flag=false;
		
		for(int i=0; i<nums.length; i++) {
			//Ѱ�ҵ�һ����Ϊ0��Ԫ��
			if(nums[i]!=0 && flag==false) {
				flag=true;
			}
			if(flag) {
				System.out.print(nums[i]);	
			}
			
		}
		System.out.println();
	}
	
	/**
	 * ʹ��ȫ����ʵ�ֱ�����Ч��
	 * ���ǵݹ鵼��Ч��ʮ�ֵ��£�һ��ĵݹ�Ĵ�������5��ʱ�򻹿��� >=5��ʱ���ʱ�ͷǳ��Ĵ���
	 * @param n
	 */
	public static void printOneToMaxN_2(int n) {
		
		int []nums=new int[n];
		int low=nums.length-1;
		List<String> list=new ArrayList<String>();
		backtrack(nums, low, list);
		show(list);
	}
	
	/**
	 * �������е�Ԫ��ȫ�����
	 * @param list
	 */
	public static void show(List<String> list) {
		for(String K:list) {
			System.out.println(K);
		}
	}
	
	
	/**
	 * �ݹ�õ����ֵ�ȫ����
	 * @param nums
	 * @param pos
	 */
	public static void backtrack(int []nums, int pos) {
		
		if(pos<0) {
			return ;
		}
		
		for(int i=0; i<=9; i++) {
			nums[pos]=i;
			print_2(nums);
			backtrack(nums, pos-1);			
		}
	}
	
	
	/**
	 * ���õ����������ַ�������ʽ����ڼ����У�ÿ�����ʱ��Ҫ���������
	 * @param nums
	 * @param pos
	 * @param list
	 */
	public static void backtrack(int []nums, int pos, List<String> list) {
		
		if(pos<0) {
			return; 
		}
		for(int i=0; i<=9; i++) {
			nums[pos]=i;
			String temp=myToString(nums);
			//�жϼ������Ƿ��Ѿ����ڸ����֣�ֻ��ǿյĴ�
			if(!list.contains(temp) && !temp.equals("")) {
				list.add(temp);	
			}			
			backtrack(nums, pos-1, list);
		}
	}
	
	/**
	 * �������е�Ԫ��ת��Ϊ�ַ���
	 * @param nums
	 * @return
	 */
	public static String myToString(int []nums) {
		
		String res="";
		boolean start=false;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=0 && !start) {
				start=true;
			}
			if(start) {
				res=res+nums[i];
			}
		}
		return res;
	}
	
	
	public static void clear(int []nums, int pos) {
		while(pos<nums.length) {
			nums[pos++]=0;
		}
	}
	
	
	/**
	 * �����ǰ�����Ӧ����
	 * @param nums
	 */
	public static void print_2(int []nums) {
		
		boolean isZero=true;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]!=0 && isZero) {
				isZero=false;
			}
			if(!isZero) {
				System.out.print(nums[i]);
			}
		}
		//Ϊ�˷�ֹ������ڵĿ�������ж�
		if(!isZero) {
			System.out.println();	
		}
		
	}
	
	
	public static void main(String []args) {
		int []nums= {0,0,0,1,0,2,3};
//		print_2(nums);
		printOneToMaxN_2(5);
	}
}
