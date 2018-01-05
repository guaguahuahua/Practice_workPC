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
	 * 求数组中最大子数组的和，这是我个人的一种想法
	 * 首先获得第长度为1的所有子数组，然后获得长度为2的所有子数组，以此类推，直到获得所有长度的子数组
	 * 对每次求得的子数组求和，并与最大值进行比较，判断时候要更新最大值
	 * @param nums
	 */
	public static void largestSubArray(int []nums) {
		if(nums.length==0) {
			return ;
		}
		//定义存放最大值
		int max=Integer.MIN_VALUE;
		//从短到长依次的遍历所有的子数组
		for(int len=1; len<=nums.length; len++) {
			for(int index=0; index<=nums.length-len; index++) {
				int temp=0;
				//获取一个子数组的和
				for(int pos=index; pos<len; pos++) {
					temp += nums[pos];
				}
				//判断是否要更新最大值
				if(temp>max) {
					max=temp;
				}
			}
		}
		System.out.println("子数组最大和是： "+max);
	}
	
	/**
	 * 来自书上，在这种思路中，认为子数组可以这样划分：
	 * 和第一个元素有关的所有子数组，和第二个元素有关的子数组，等等，将子数组与元素绑定在一起
	 * 只要求出每个元素的子数组的和，并将最大的子数组的和更新即可，
	 * 这里的话主要的重复使用了前n个元素的和，如果是第一个元素的子数组，那么可以构想一下，即
	 * 含有一个元素，两个元素，三个元素，等等，依次类推，那么他的子数组的和实质上是将第一个元素累加到最后一个元素为止.
	 * 时间复杂度为o(n*n)
	 * @param nums
	 */
	public static void largestSubArray_1(int []nums) {
		//用来记录最大子数组的和
		int max=Integer.MIN_VALUE;
		//遍历
		for(int index=0; index<nums.length; index++) {
			int temp=0;
			//计算当前元素的所有子数组
			for(int pos=index; pos<nums.length; pos++) {
				temp += nums[pos];
				//判断是否要更新最大值
				if(max < temp) {
					max=temp;
				}
			}
		}
		System.out.println("最大子数组的和: "+max);
	}
	
	/**
	 * 使用动态规划解决问题
	 * @param nums
	 */
	public static int largestSubArray_2(int []nums) {

		//定义存放变量的数组
		int []end=new int[nums.length];
		int []all=new int[nums.length];
		end[0]=all[0]=nums[0];
		//初始化两个数组
		for(int i=1; i<nums.length; i++) {
			end[i]=Math.max(end[i-1]+nums[i], nums[i]); //这块是得到和最后一个元素相关的最大子数组
			all[i]=Math.max(end[i], all[i-1]); //因为这里每次取最大值，所以最后的一个元素就是最大值
		}
		//输出最大子数组
		System.out.println(all[nums.length-1]);
		return all[nums.length-1];
	}
	
	/**
	 * 使用动态规划解决
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
	 * 找到出现次数最多的元素
	 * 先排序，后统计每个元素出现次数
	 * @return int 
	 */
	public static int findTheAppearMost(int []nums) {
		//排序
		Arrays.sort(nums);
		//记录相同元素的左右索引坐标
		int left=0, right=0;
		//最大值
		int max=0;
		int elem=0;
		//某元素出现的次数
		int times=0;
		for(right=1; right<nums.length; right++) {
			if(nums[right]==nums[left]) {
				times++;
			}else {
				//比较是否要更新记录值
				if(max<times) {
					elem=nums[left];
					max=times;
				}
				//移动左指针到右边
				left=right;
				//将存放次数变量清零
				times=0;
			}
		}
		
		System.out.println(elem);
		return elem;
	}
	
	/**
	 * 找到数组中出现频率最高的元素
	 * 使用map映射的方式
	 * @param 输入数组
	 * @return int
	 */
	public static int findTheAppearMost_1(int []nums) {
		
		Map <Integer, Integer>map=new HashMap<Integer, Integer>();
		//第一次遍历，得到每个元素和对应次数的映射关系
		for(int i=0; i<nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		} 
		//次数最大值，以及对应的元素
		int max=Integer.MIN_VALUE;
		int elem=0;
		//获得map的所有键值
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
	 * instanceof的使用
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
	 * 寻找数组中和为20的数对
	 * @param nums 整型数组
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
	 * 将数组nums循环右移k位
	 * 使用3步逆置策略
	 * @param nums 数组
	 * @param k 移位的数
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
	 * 将数组进行逆置
	 * @param nums 给定数组
	 * @param start 逆置开始位置，包括当前位置
	 * @param end 逆置结束位置， 包括当前位置
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
	 * 输出数组中的每个元素
	 * @param nums
	 */
	private static void show(int []nums) {
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	}
	
	/**
	 *	计算有多少盏灯是亮着的
	 */
	private static void howManyLightsUp() {
		boolean []lights=new boolean[2018];
		//遍历所有的序号，从1--2017
		for(int i=1; i<lights.length; i++) {
			//从当前位置开始,1--2017
			int bei=i;
			int start=i;
			while(start<lights.length) {
				lights[start]=!lights[start];
				start+=bei;
			}
		}
		int count=0;
		//查看有多少栈灯亮着
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
	 * 找到数组中第k个最小的元素
	 * 这块是使用排序的方式
	 * @param nums
	 * @param k
	 * @return int
	 */
	private static int findTheKthMinValue(int []nums, int k) {
		//保证数组不会越界
		if(k>nums.length) {
			System.out.println("parameter k out of boundary!");
			return -1;
		}
		Arrays.sort(nums);
		return nums[k-1];
	}
	
	/**
	 * 找到数组中出现一次的元素，其余的元素出现了两次
	 * @param nums 输入数组
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
	 * 寻找数组中出现一次的元素，其余元素出现了3次
	 * 方法：统计所有数的二进制形式各个位上面的1的个数，最后对3取余就知道出现一次的元素
	 * @param nums
	 * @return int
	 */
	private static int findTheAppearOnceNum(int []nums) {
		//统计整数的32位上面的1的个数
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
