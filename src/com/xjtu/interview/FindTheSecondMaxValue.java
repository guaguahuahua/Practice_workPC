package com.xjtu.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindTheSecondMaxValue {

	/**
	 * 找到数组中第二大的元素，时间复杂度要求为o(n)
	 * 算法思想：设置两个变量，一个保存最大值，另一个保存次最大值，
	 * 遍历整个数组，如果当前元素比最大值大，那么最大值由次最大值保存，
	 * 当前值置为最大值，若当前值小于最大值，那么与次最大值比较，判断是否要更新次最大值
	 * @param nums 整型数组
	 */
	public static void findTheSecondMaxValue(int []nums) {
		if(nums.length==0) {
			return ;
		}
		//设置最大值，次最大值变量
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
		//输出
		System.out.println("max: "+max+", "+"smax: "+smax);
		
	}
	
	/**
	 * 找到数组中唯一重复的那个数,一共是n个数，范围是1-N-1，其中某个数出现了两次，找到出现两次的那个数
	 * 使用数学原理的方式，先计算从1--n-1的和是多少，然后计算当前数组中的和，用当前数组中的和减去数学和即可得到那个重复数字
	 * @param nums
	 * @return int
	 */
	public static int findTheRepeatedNum(int []nums) {
		//数学和
		int sum=(nums.length-1)*(1+nums.length-1)/2;
		int s=0;
		for(int i=0; i<nums.length; i++) {
			s+=nums[i];
		}
		return s-sum;
	}
	
	/**
	 * 使用异或的方式得到结果
	 * 首先是将原数组中的每个数进行异或操作，再与0--N-1之间再做一个异或操作，两个相同的数进行异或操作结果为0
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
	 * 使用取反的方式得到重复元素
	 * 不使用多余空间，但是会改变原数组的值
	 * @param nums
	 * @return int
	 */
	public static int findTheRepeatedNum_2(int []nums) {
		
		for(int i=0; i<nums.length; i++) {
			int t=nums[i]; //t的范围是1--N-1
			if(t>0) {
				nums[t]=-nums[t]; //将对应的数组元素置为负值
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
	 * 尝试使用一下Math中自带的方法
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
	 * 判断java中的char的编码
	 */
	public static void chineseCode() {
		String s1="hello";
		String s2="你好";
		judgeChineseCharacter(s1);
		judgeChineseCharacter(s2);
//		charsDetails(s1);
//		charsDetails(s2);		
	}
	
	/**
	 * 输出字符串的长度和当前字符占用的字节的长度
	 * @param str
	 */
	private static void charsDetails(String str) {
		System.out.println("字符串长度："+str.length()+","+"字节长度："+str.getBytes().length);
	}
	
	/**
	 * 判断当前的字符串中是否存在中文字符
	 * @param str
	 */
	private static void judgeChineseCharacter(String str) {
		String regEx="[\u4e00-\u9fa5]";
		if(str.getBytes().length == str.length()) {
			System.out.println("无汉字！");
		}else {
			Pattern p=Pattern.compile(regEx);
			Matcher m=p.matcher(str);
			while(m.find()) {
				System.out.print(m.group(0));
			}
		}
	}
	
	/**
	 * 使用递归的方式找到数组中的最大值
	 * @param nums
	 * @return int
	 */
	private static int findTheMaxElement(int []nums) {
		int res=findMax(nums, 0, nums.length-1);
		return res;
	}
	/**
	 * 使用递归的方式寻找最大值
	 * 思路：整体的数组的最大值，是长度n-1的数组最大值和当前元素中较大的那个，依次的递推下去
	 * @param nums 输入数组
	 * @param start 开始位置索引
	 * @param end 结束位置索引
	 * @return int 最大值
	 */
	private static int findMax(int []nums, int start, int end) {
		
		//只有两个数
		if(start==end-1) {
			return Math.max(nums[start], nums[end]);
		}
		int index=end;
		int m=findMax(nums, 0, --end);
		int m1=Math.max(m, nums[index]);
		return m1;
	}

	/**
	 * 求数组中当前元素和右边的子数组最大的差值
	 * @param nums 输入数组
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
	 * 使用动态规划的方法找寻数组中最大的差值
	 * 思路：使用两个变量，一个记录当前元素为减数时最大的差值，另一个记录当前元素之前的最大值
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
	 * 在有序数组中找到绝对值最小的那个元素
	 * @param nums 
	 * @return int
	 */
	private static int findminAbsValue(int []nums) {
		//如果数组的最左侧的元素是非负数，那么最小值是数组的左侧元素
		if(nums[0]>=0) {
			return nums[0];
		}
		//如果数组的最后一个元素非正数，那么
		if(nums[nums.length-1]<=0) {
			return nums[nums.length-1];
		}
		//如果是即有正数又有负数的，那么需要对数组进行查找，寻找中间元素（正负元素的交接点）
		int min=Integer.MAX_VALUE;
		int minAbs=Integer.MAX_VALUE;
		int left=0;
		int right=nums.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			//如果是正数，那么right右移,比较绝对值，并做记录
			if(nums[mid]>0) {
				right=mid-1;
				if(Math.abs(nums[mid])<minAbs) {
					minAbs=Math.abs(nums[mid]);
					min=nums[mid];
				}
			//如果是左边的元素
			}else if(nums[mid]<0) {
				left=mid+1;
				if(Math.abs(nums[mid])<minAbs) {
					minAbs=Math.abs(nums[mid]);
					min=nums[mid];
				}
			//中间值就是0	
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
