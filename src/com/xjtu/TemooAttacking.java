package com.xjtu;

public class TemooAttacking {
	
	/**
	 *计算temoo对Ashe的攻击时间长度,每次加2，当
	 * @param timeSeries temoo的攻击时间序列
	 * @param duration temoo每次攻击的时间长度
	 * @return
	 */
    public static int findPoisonedDuration_1(int[] timeSeries, int duration) {
       
    	int total=duration*timeSeries.length;
    	for(int i=0;i<timeSeries.length-1;i++) {
    		if(timeSeries[i]+duration>timeSeries[i+1]) {
    			total-=(timeSeries[i]+duration-timeSeries[i+1]);
    		}
    	}
    	return total;
    }
	
    /**
     * 按照自己的思路完成,上面的是按照王军的思路执行的结果
     * 想法，如果两次攻击没有交集，那么直接使用标准的时间长度，否则，使用两次攻击的时间 差
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int []timeSeries,int duration) {
    	int total=0;
    	for(int i=0;i<timeSeries.length-1;i++) {
    		if(timeSeries[i]+duration<=timeSeries[i+1]) { //这块不能遍历最后一个元素，否则索引会出界
    			total+=duration;
    		}else {
    			total+=(timeSeries[i+1]-timeSeries[i]);
    		}
    	}
    	return total+=timeSeries.length==0 ? 0 :duration; //将最后一个漏掉的元素补上
    }
	public static void main(String []agrs) {
//		int  []timeSeries= {1,4};
//		int  []timeSeries= {1,2};
//		int  []timeSeries= {1,2,5,8};
//		int  []timeSeries= {1,2,3,4,5,6,7,8,9};
//		int  []timeSeries= {2};
//		int  []timeSeries= {1,2,3,4,5};
		int  []timeSeries= {};
		int duration=2;
		int res=findPoisonedDuration(timeSeries,duration);
		System.out.print(res+"\t");
	}
}
