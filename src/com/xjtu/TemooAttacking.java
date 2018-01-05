package com.xjtu;

public class TemooAttacking {
	
	/**
	 *����temoo��Ashe�Ĺ���ʱ�䳤��,ÿ�μ�2����
	 * @param timeSeries temoo�Ĺ���ʱ������
	 * @param duration temooÿ�ι�����ʱ�䳤��
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
     * �����Լ���˼·���,������ǰ���������˼·ִ�еĽ��
     * �뷨��������ι���û�н�������ôֱ��ʹ�ñ�׼��ʱ�䳤�ȣ�����ʹ�����ι�����ʱ�� ��
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int []timeSeries,int duration) {
    	int total=0;
    	for(int i=0;i<timeSeries.length-1;i++) {
    		if(timeSeries[i]+duration<=timeSeries[i+1]) { //��鲻�ܱ������һ��Ԫ�أ��������������
    			total+=duration;
    		}else {
    			total+=(timeSeries[i+1]-timeSeries[i]);
    		}
    	}
    	return total+=timeSeries.length==0 ? 0 :duration; //�����һ��©����Ԫ�ز���
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
