package com.xjtu.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestSubArray {

	/**
	 * �����������������ĺͣ������Ҹ��˵�һ���뷨
	 * ���Ȼ�õڳ���Ϊ1�����������飬Ȼ���ó���Ϊ2�����������飬�Դ����ƣ�ֱ��������г��ȵ�������
	 * ��ÿ����õ���������ͣ��������ֵ���бȽϣ��ж�ʱ��Ҫ�������ֵ
	 * @param nums
	 */
	public static void largestSubArray(int []nums) {
		if(nums.length==0) {
			return ;
		}
		//���������ֵ
		int max=Integer.MIN_VALUE;
		//�Ӷ̵������εı������е�������
		for(int len=1; len<=nums.length; len++) {
			for(int index=0; index<=nums.length-len; index++) {
				int temp=0;
				//��ȡһ��������ĺ�
				for(int pos=index; pos<len; pos++) {
					temp += nums[pos];
				}
				//�ж��Ƿ�Ҫ�������ֵ
				if(temp>max) {
					max=temp;
				}
			}
		}
		System.out.println("�����������ǣ� "+max);
	}
	
	/**
	 * �������ϣ�������˼·�У���Ϊ����������������֣�
	 * �͵�һ��Ԫ���йص����������飬�͵ڶ���Ԫ���йص������飬�ȵȣ�����������Ԫ�ذ���һ��
	 * ֻҪ���ÿ��Ԫ�ص�������ĺͣ���������������ĺ͸��¼��ɣ�
	 * ����Ļ���Ҫ���ظ�ʹ����ǰn��Ԫ�صĺͣ�����ǵ�һ��Ԫ�ص������飬��ô���Թ���һ�£���
	 * ����һ��Ԫ�أ�����Ԫ�أ�����Ԫ�أ��ȵȣ��������ƣ���ô����������ĺ�ʵ�����ǽ���һ��Ԫ���ۼӵ����һ��Ԫ��Ϊֹ.
	 * ʱ�临�Ӷ�Ϊo(n*n)
	 * @param nums
	 */
	public static void largestSubArray_1(int []nums) {
		//������¼���������ĺ�
		int max=Integer.MIN_VALUE;
		//����
		for(int index=0; index<nums.length; index++) {
			int temp=0;
			//���㵱ǰԪ�ص�����������
			for(int pos=index; pos<nums.length; pos++) {
				temp += nums[pos];
				//�ж��Ƿ�Ҫ�������ֵ
				if(max < temp) {
					max=temp;
				}
			}
		}
		System.out.println("���������ĺ�: "+max);
	}
	
	/**
	 * ʹ�ö�̬�滮�������
	 * @param nums
	 */
	public static int largestSubArray_2(int []nums) {

		//�����ű���������
		int []end=new int[nums.length];
		int []all=new int[nums.length];
		end[0]=all[0]=nums[0];
		//��ʼ����������
		for(int i=1; i<nums.length; i++) {
			end[i]=Math.max(end[i-1]+nums[i], nums[i]); //����ǵõ������һ��Ԫ����ص����������
			all[i]=Math.max(end[i], all[i-1]); //��Ϊ����ÿ��ȡ���ֵ����������һ��Ԫ�ؾ������ֵ
		}
		//������������
		System.out.println(all[nums.length-1]);
		return all[nums.length-1];
	}
	
	/**
	 * ʹ�ö�̬�滮���
	 * @param nums 
	 * @return int
	 */
	public static int largestSubArray_3(int []nums) {
		
		int endi=nums[0];
		int all=nums[0];
		for(int i=1; i<nums.length; i++) {
			endi=Math.max(endi+nums[i], nums[i]);
			all=Math.max(endi, all);
		}
		System.out.println(all);
		return all;
	}
	
	/**
	 * �ҵ����ִ�������Ԫ��
	 * �����򣬺�ͳ��ÿ��Ԫ�س��ִ���
	 * @return int 
	 */
	public static int findTheAppearMost(int []nums) {
		//����
		Arrays.sort(nums);
		//��¼��ͬԪ�ص�������������
		int left=0, right=0;
		//���ֵ
		int max=0;
		int elem=0;
		//ĳԪ�س��ֵĴ���
		int times=0;
		for(right=1; right<nums.length; right++) {
			if(nums[right]==nums[left]) {
				times++;
			}else {
				//�Ƚ��Ƿ�Ҫ���¼�¼ֵ
				if(max<times) {
					elem=nums[left];
					max=times;
				}
				//�ƶ���ָ�뵽�ұ�
				left=right;
				//����Ŵ�����������
				times=0;
			}
		}
		
		System.out.println(elem);
		return elem;
	}
	
	/**
	 * �ҵ������г���Ƶ����ߵ�Ԫ��
	 * ʹ��mapӳ��ķ�ʽ
	 * @param ��������
	 * @return int
	 */
	public static int findTheAppearMost_1(int []nums) {
		
		Map <Integer, Integer>map=new HashMap<Integer, Integer>();
		//��һ�α������õ�ÿ��Ԫ�غͶ�Ӧ������ӳ���ϵ
		for(int i=0; i<nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		} 
		//�������ֵ���Լ���Ӧ��Ԫ��
		int max=Integer.MIN_VALUE;
		int elem=0;
		//���map�����м�ֵ
		Set keySet=map.keySet();
		Iterator it=keySet.iterator();
		while(it.hasNext()) {
			int temp=(Integer)it.next();
			int times=(Integer) map.get(temp);
			if(times>max) {
				max=times;
				elem=temp;
			}
		}
		System.out.println(elem);
		return elem;
	}
	
	/**
	 * instanceof��ʹ��
	 */
	private static void testInstanceOf() {
		String s="kfc";
		
		if(s instanceof String) {
			System.out.println(true);
		}
		if(s instanceof Object) {
			System.out.println(true);
		}		
	}
	
	/**
	 * Ѱ�������к�Ϊ20������
	 * @param nums ��������
	 * @return List
	 */
	private static List<ArrayList> sumEquals20(int []nums) {
		if(nums.length==0) {
			return null;
		}
		List<ArrayList> out=new ArrayList<ArrayList>();
		Arrays.sort(nums);
		int left=0;
		int right=nums.length-1;
		while(left<right) {
			if(nums[left]+nums[right]<20) {
				left++;
			}else if(nums[left]+nums[right]==20) {
				ArrayList <Integer>in=new ArrayList<Integer>();
				in.add(nums[left]);
				in.add(nums[right]);
				out.add(in);
				left++;
				right--;
			}else if(nums[left]+nums[right]>20) {
				right--;
			}
		}
		return out;
	}
	
	/**
	 * ������numsѭ������kλ
	 * ʹ��3�����ò���
	 * @param nums ����
	 * @param k ��λ����
	 * @return int []
	 */
	private static int [] circleReverse(int []nums, int k) {
		
		k=k%nums.length;
		show(nums);
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		show(nums);
		return nums;
	}
	/**
	 * �������������
	 * @param nums ��������
	 * @param start ���ÿ�ʼλ�ã�������ǰλ��
	 * @param end ���ý���λ�ã� ������ǰλ��
	 */
	private static void reverse(int []nums, int start, int end) {
		if(start<0 || end>nums.length) {
			return ;
		}
		while(start<end) {
			int t=nums[start];
			nums[start]=nums[end];
			nums[end]=t;
			start++;
			end--;
		}
	} 
	
	/**
	 * ��������е�ÿ��Ԫ��
	 * @param nums
	 */
	private static void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	
	/**
	 *	�����ж���յ�������ŵ�
	 */
	private static void howManyLightsUp() {
		boolean []lights=new boolean[2018];
		//�������е���ţ���1--2017
		for(int i=1; i<lights.length; i++) {
			//�ӵ�ǰλ�ÿ�ʼ,1--2017
			int bei=i;
			int start=i;
			while(start<lights.length) {
				lights[start]=!lights[start];
				start+=bei;
			}
		}
		int count=0;
		//�鿴�ж���ջ������
		for(int i=1; i<lights.length; i++) {
			if(lights[i]) {
				count++;
				System.out.print(i+"\t");
			}
		}
		System.out.println();
		System.out.println(count);
	}
	
	/**
	 * �ҵ������е�k����С��Ԫ��
	 * �����ʹ������ķ�ʽ
	 * @param nums
	 * @param k
	 * @return int
	 */
	private static int findTheKthMinValue(int []nums, int k) {
		//��֤���鲻��Խ��
		if(k>nums.length) {
			System.out.println("parameter k out of boundary!");
			return -1;
		}
		Arrays.sort(nums);
		return nums[k-1];
	}
	
	/**
	 * �ҵ������г���һ�ε�Ԫ�أ������Ԫ�س���������
	 * @param nums ��������
	 * @return int
	 */
	private static int findTheOnceNum(int []nums) {
		int n=nums[0];
		for(int i=1; i<nums.length; i++) {
			n=n^nums[i];
		}
		return n;
	}
	
	/**
	 * Ѱ�������г���һ�ε�Ԫ�أ�����Ԫ�س�����3��
	 * ������ͳ���������Ķ�������ʽ����λ�����1�ĸ���������3ȡ���֪������һ�ε�Ԫ��
	 * @param nums
	 * @return int
	 */
	private static int findTheAppearOnceNum(int []nums) {
		//ͳ��������32λ�����1�ĸ���
		int []bitCount=new int[32];
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<32; j++) {
				bitCount[j] += nums[i]&1;
				nums[i]=nums[i]>>1;
			}
		}
		int once=0;
		for(int i=0; i<bitCount.length; i++) {
			 if(bitCount[i]%3!=0) {
				 once+=(1<<i);
			 }
		}
		return once;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {1, -2, 4, 8, -4, 7, -1, -5};
//		int []nums= {1, 1, 2, 2, 4, 4, 4, 4, 5, 5, 6, 6, 6};
//		int []nums= {1,2,3,4,5,6,7,8};
//		int []nums= {1, 7, 17, 2, 6, 3, 14};
//		int []nums= {1,2,3,2,4,3,5,4,1};
		int []nums= {1,1,1,2,2,2,4};
//		largestSubArray_2(nums);
//		findTheAppearMost_1(nums);
//		testInstanceOf();
//		List list=sumEquals20(nums);
//		System.out.println(list);
//		circleReverse(nums, 1113);
//		howManyLightsUp();
//		int res=findTheOnceNum(nums);
//		int res=findTheAppearOnceNum(nums);
//		System.out.println(res);
		
	}

}
