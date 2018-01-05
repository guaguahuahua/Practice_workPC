package com.xjtu.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindTheSecondMaxValue {

	/**
	 * �ҵ������еڶ����Ԫ�أ�ʱ�临�Ӷ�Ҫ��Ϊo(n)
	 * �㷨˼�룺��������������һ���������ֵ����һ����������ֵ��
	 * �����������飬�����ǰԪ�ر����ֵ����ô���ֵ�ɴ����ֵ���棬
	 * ��ǰֵ��Ϊ���ֵ������ǰֵС�����ֵ����ô������ֵ�Ƚϣ��ж��Ƿ�Ҫ���´����ֵ
	 * @param nums ��������
	 */
	public static void findTheSecondMaxValue(int []nums) {
		if(nums.length==0) {
			return ;
		}
		//�������ֵ�������ֵ����
		int max=nums[0];
		int smax=Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]>max) {
				smax=max;
				max=nums[i];
			}else if(nums[i]>smax){
				smax=nums[i];
			}
		}
		//���
		System.out.println("max: "+max+", "+"smax: "+smax);
		
	}
	
	/**
	 * �ҵ�������Ψһ�ظ����Ǹ���,һ����n��������Χ��1-N-1������ĳ�������������Σ��ҵ��������ε��Ǹ���
	 * ʹ����ѧԭ��ķ�ʽ���ȼ����1--n-1�ĺ��Ƕ��٣�Ȼ����㵱ǰ�����еĺͣ��õ�ǰ�����еĺͼ�ȥ��ѧ�ͼ��ɵõ��Ǹ��ظ�����
	 * @param nums
	 * @return int
	 */
	public static int findTheRepeatedNum(int []nums) {
		//��ѧ��
		int sum=(nums.length-1)*(1+nums.length-1)/2;
		int s=0;
		for(int i=0; i<nums.length; i++) {
			s+=nums[i];
		}
		return s-sum;
	}
	
	/**
	 * ʹ�����ķ�ʽ�õ����
	 * �����ǽ�ԭ�����е�ÿ��������������������0--N-1֮������һ����������������ͬ�����������������Ϊ0
	 * @param nums
	 * @return
	 */
	public static int findTheRepeatedNum_1(int []nums) {
		int a=0;
		for(int i=0; i<nums.length; i++) {
			a=a^nums[i];
		}
		for(int j=1; j<nums.length; j++) {
			a=a^j;
		}
		return a;
	}
	
	/**
	 * ʹ��ȡ���ķ�ʽ�õ��ظ�Ԫ��
	 * ��ʹ�ö���ռ䣬���ǻ�ı�ԭ�����ֵ
	 * @param nums
	 * @return int
	 */
	public static int findTheRepeatedNum_2(int []nums) {
		
		for(int i=0; i<nums.length; i++) {
			int t=nums[i]; //t�ķ�Χ��1--N-1
			if(t>0) {
				nums[t]=-nums[t]; //����Ӧ������Ԫ����Ϊ��ֵ
			}
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i]>0) {
				return nums[i];
			}
		}
		return -1;
	}
	
	/**
	 * ����ʹ��һ��Math���Դ��ķ���
	 */
	public static void mathMethods() {
		float a1=1.4F;
		float a2=1.5F;
		float a3=1.6F;
		float a4=-1.4F;
		float a5=-1.5F;
		float a6=-1.6F;
		
		System.out.println(Math.round(a1));
		System.out.println(Math.floor(a1));
		System.out.println(Math.ceil(a1));
		
		System.out.println(Math.round(a2));
		System.out.println(Math.floor(a2));
		System.out.println(Math.ceil(a2));
		
		System.out.println(Math.round(a4));
		System.out.println(Math.floor(a4));
		System.out.println(Math.ceil(a4));
		
		System.out.println(Math.round(a5));
		System.out.println(Math.floor(a5));
		System.out.println(Math.ceil(a5));
		
		System.out.println(Math.round(a6));
		System.out.println(Math.floor(a6));
		System.out.println(Math.ceil(a6));
	}
	
	/**
	 * �ж�java�е�char�ı���
	 */
	public static void chineseCode() {
		String s1="hello";
		String s2="���";
		judgeChineseCharacter(s1);
		judgeChineseCharacter(s2);
//		charsDetails(s1);
//		charsDetails(s2);		
	}
	
	/**
	 * ����ַ����ĳ��Ⱥ͵�ǰ�ַ�ռ�õ��ֽڵĳ���
	 * @param str
	 */
	private static void charsDetails(String str) {
		System.out.println("�ַ������ȣ�"+str.length()+","+"�ֽڳ��ȣ�"+str.getBytes().length);
	}
	
	/**
	 * �жϵ�ǰ���ַ������Ƿ���������ַ�
	 * @param str
	 */
	private static void judgeChineseCharacter(String str) {
		String regEx="[\u4e00-\u9fa5]";
		if(str.getBytes().length == str.length()) {
			System.out.println("�޺��֣�");
		}else {
			Pattern p=Pattern.compile(regEx);
			Matcher m=p.matcher(str);
			while(m.find()) {
				System.out.print(m.group(0));
			}
		}
	}
	
	/**
	 * ʹ�õݹ�ķ�ʽ�ҵ������е����ֵ
	 * @param nums
	 * @return int
	 */
	private static int findTheMaxElement(int []nums) {
		int res=findMax(nums, 0, nums.length-1);
		return res;
	}
	/**
	 * ʹ�õݹ�ķ�ʽѰ�����ֵ
	 * ˼·���������������ֵ���ǳ���n-1���������ֵ�͵�ǰԪ���нϴ���Ǹ������εĵ�����ȥ
	 * @param nums ��������
	 * @param start ��ʼλ������
	 * @param end ����λ������
	 * @return int ���ֵ
	 */
	private static int findMax(int []nums, int start, int end) {
		
		//ֻ��������
		if(start==end-1) {
			return Math.max(nums[start], nums[end]);
		}
		int index=end;
		int m=findMax(nums, 0, --end);
		int m1=Math.max(m, nums[index]);
		return m1;
	}

	/**
	 * �������е�ǰԪ�غ��ұߵ����������Ĳ�ֵ
	 * @param nums ��������
	 * @return int
	 */
	private static int maxDiff(int []nums) {
		int max=Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				int diff=nums[i]-nums[j];
				if(diff>max) {
					max=diff;
				}
			}
		}
		return max;
	}
	
	/**
	 * ʹ�ö�̬�滮�ķ�����Ѱ���������Ĳ�ֵ
	 * ˼·��ʹ������������һ����¼��ǰԪ��Ϊ����ʱ���Ĳ�ֵ����һ����¼��ǰԪ��֮ǰ�����ֵ
	 * @param nums
	 * @return int
	 */
	private static int maxDiff_1(int []nums) {		
		int max=nums[0];
		int diff=Integer.MIN_VALUE;
		for(int i=1; i<nums.length; i++) {
			diff=Math.max(diff, max-nums[i]);
			max=Math.max(max, nums[i]);
		}
		return diff;
	}
	
	/**
	 * �������������ҵ�����ֵ��С���Ǹ�Ԫ��
	 * @param nums 
	 * @return int
	 */
	private static int findminAbsValue(int []nums) {
		//��������������Ԫ���ǷǸ�������ô��Сֵ����������Ԫ��
		if(nums[0]>=0) {
			return nums[0];
		}
		//�����������һ��Ԫ�ط���������ô
		if(nums[nums.length-1]<=0) {
			return nums[nums.length-1];
		}
		//����Ǽ����������и����ģ���ô��Ҫ��������в��ң�Ѱ���м�Ԫ�أ�����Ԫ�صĽ��ӵ㣩
		int min=Integer.MAX_VALUE;
		int minAbs=Integer.MAX_VALUE;
		int left=0;
		int right=nums.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			//�������������ôright����,�ȽϾ���ֵ��������¼
			if(nums[mid]>0) {
				right=mid-1;
				if(Math.abs(nums[mid])<minAbs) {
					minAbs=Math.abs(nums[mid]);
					min=nums[mid];
				}
			//�������ߵ�Ԫ��
			}else if(nums[mid]<0) {
				left=mid+1;
				if(Math.abs(nums[mid])<minAbs) {
					minAbs=Math.abs(nums[mid]);
					min=nums[mid];
				}
			//�м�ֵ����0	
			}else {
				return 0;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {-10, -5, -2, 7, 15, 50};
		int []nums= {-34, -3, -1, 5, 8, 88};
//		int []nums= {7, 3, 19, 40, 4, 7, 1};
//		int []nums= {1,2,1,3,4};
//		findTheSecondMaxValue(nums);
//		int res=findTheRepeatedNum_2(nums);
//		System.out.println("repeatedNum: "+res);
//		mathMethods();
//		chineseCode();
//		int res=findTheMaxElement(nums);
//		System.out.println(res);
//		int res=maxDiff_1(nums);
//		System.out.println(res);
		int res=findminAbsValue(nums);
		System.out.println(res);
	}
}
