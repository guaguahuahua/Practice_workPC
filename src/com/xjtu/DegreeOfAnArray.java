package com.xjtu;

import java.util.ArrayList;

public class DegreeOfAnArray {

	int num;
	int firstIndex;
	int lastIndex;
	boolean flag=false;
	/**
	 * 寻找和数组的度相同的，且长度最短的一个连续子数组
	 * @param nums
	 * @return
	 */
    public static int findShortestSubArray(int[] nums) {
    	//定义hash表，将元素映射到hash表中统计个数，题目中最大的数字是49999
    	int[]times=new int[50000];
    	//首先得到数组每个元素出现的次数
    	for(int i=0; i<nums.length; i++) {
    		times[nums[i]]++;
    	}
    	int max=0;
    	//找到数组中次数出现最多的元素
    	for(int i=0; i<times.length; i++) {
    		if(times[i]>max) {
    			max=times[i];    			
    		}
    	}
    	//存放频率等于最大次数的元素
    	ArrayList<Integer> numbers=new ArrayList<Integer>();
    	//找到等于最大次数的元素
    	for(int i=0; i<times.length; i++) {
    		if(times[i]==max) {
    			numbers.add(i);
    		}    		
    	}
    	//存放度元素第一次和最后一次出现的位置
    	DegreeOfAnArray []de=new DegreeOfAnArray[numbers.size()];
    	//对数组进行初始化
    	for(int i=0; i<de.length; i++) {
    		de[i]=new DegreeOfAnArray();
    	}
    	//寻找这些元素出现第一次和最后一次的位置
    	for(int i=0; i<nums.length; i++) {
    		for(int j=0; j<numbers.size(); j++){
    			//如果数组当前元素是度元素，那么记录它出现的位置    			
    			if(numbers.get(j)==nums[i]) {    				
    				de[j].num=numbers.get(j);
    				if(!de[j].flag) { //第一次出现，记录第一次位置
    					de[j].firstIndex=i;
    					de[j].flag=true;
    				}else { //如果第一次记录过，那么记录第二次位置，这样也能保证最后一次被记录过
    					de[j].lastIndex=i;
    				}
    			}
    		}
    	}
    	//将最小长度的子数组的长度返回
    	int min=Integer.MAX_VALUE;
    	int gap=0;
    	for(int i=0; i<de.length; i++) {
    		gap=de[i].lastIndex-de[i].firstIndex;
    		//元素只出现了一次
    		if(gap<0) {
    			return 1;
    		}
    		gap+=1;
    		if(gap<min) {
    			min=gap;
    		}
    	}
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1, 2, 2, 3, 1};
//		int []nums= {1,2,2,3,1,4,2};
//		int []nums= {1,3,2,2,3,1};
//		int []nums= {2,1};
		int res=findShortestSubArray(nums);
		System.out.print(res);
	}


}
