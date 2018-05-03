package com.xjtu.algorithm;
/**
 * ֻ��������2��3��5����Ϊ������6��8�ǳ�������14���ǣ���Ϊ������7
 * һ�����Ϊ1�ǵ�һ�����������ص�n������
 * @author Administrator
 *
 */
public class UglyNumber {

	/**
	 * ��������ÿ��������������2��3��5��ֱ����Ϊ1�����2��3��5���޷���������ô��Ϊ���ǳ���
	 * @param n
	 * @return
	 */
	public static int uglyNumber(int n) {
	
		//������Ϊ1��һ������
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
				//ֻҪ����һ�����Ӽ���������
				if(f1==true || f2==true || f3==true) {
					//�����������ô���ǳ���
					if(s==1) {
						isUgly=true;
						break;
					//û��������	
					}else {
						continue;
					}
				//����޷������κ�һ�����ӣ��ǾͲ��ǳ������˳�	
				}else {
					break;
				}
			}
			//�����ǰ�����ǳ�������ô��Ǹ�Ԫ�أ�����Ѱ�Ҹ���-1
			if(isUgly==true) {
				res=start;
				n=n-1;
			}
			start++;			
		}
		
		return res;
	}
	
	/**
	 * ��ָoffer�ṩ��һ�����õı����ƽⷽ��
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
	 * �ж�һ����������Ƿ�Ϊ����
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
	 * ʹ��ǰ��ĳ��������ɺ���ĳ������ٶȼӿ죬������Ҫ����n���洢�ռ�
	 * @param n
	 * @return
	 */
	public static int uglyNumber_2(int n) {
		
		//���ɳ���Ϊn�����顢
		int[] uglyNum=new int[n];
		uglyNum[0]=1;
		//��������
		int index2=0;
		int index3=0;
		int index5=0;
		//���ɵ��µĳ���������
		int index=1;
		while(index<n) {
			//��ô��ڵ�ǰֵ��С���Ǹ�����
			int val=min(uglyNum[index2]*2, uglyNum[index3]*3, uglyNum[index5]*5);
			//��鱣֤ǰ���Ѿ��������ֵ���ٽ������㣬ֻ�������
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
	 * ���������е���Сֵ
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
