package com.xjtu;

import java.util.ArrayList;

public class DegreeOfAnArray {

	int num;
	int firstIndex;
	int lastIndex;
	boolean flag=false;
	/**
	 * Ѱ�Һ�����Ķ���ͬ�ģ��ҳ�����̵�һ������������
	 * @param nums
	 * @return
	 */
    public static int findShortestSubArray(int[] nums) {
    	//����hash����Ԫ��ӳ�䵽hash����ͳ�Ƹ�������Ŀ������������49999
    	int[]times=new int[50000];
    	//���ȵõ�����ÿ��Ԫ�س��ֵĴ���
    	for(int i=0; i<nums.length; i++) {
    		times[nums[i]]++;
    	}
    	int max=0;
    	//�ҵ������д�����������Ԫ��
    	for(int i=0; i<times.length; i++) {
    		if(times[i]>max) {
    			max=times[i];    			
    		}
    	}
    	//���Ƶ�ʵ�����������Ԫ��
    	ArrayList<Integer> numbers=new ArrayList<Integer>();
    	//�ҵ�������������Ԫ��
    	for(int i=0; i<times.length; i++) {
    		if(times[i]==max) {
    			numbers.add(i);
    		}    		
    	}
    	//��Ŷ�Ԫ�ص�һ�κ����һ�γ��ֵ�λ��
    	DegreeOfAnArray []de=new DegreeOfAnArray[numbers.size()];
    	//��������г�ʼ��
    	for(int i=0; i<de.length; i++) {
    		de[i]=new DegreeOfAnArray();
    	}
    	//Ѱ����ЩԪ�س��ֵ�һ�κ����һ�ε�λ��
    	for(int i=0; i<nums.length; i++) {
    		for(int j=0; j<numbers.size(); j++){
    			//������鵱ǰԪ���Ƕ�Ԫ�أ���ô��¼�����ֵ�λ��    			
    			if(numbers.get(j)==nums[i]) {    				
    				de[j].num=numbers.get(j);
    				if(!de[j].flag) { //��һ�γ��֣���¼��һ��λ��
    					de[j].firstIndex=i;
    					de[j].flag=true;
    				}else { //�����һ�μ�¼������ô��¼�ڶ���λ�ã�����Ҳ�ܱ�֤���һ�α���¼��
    					de[j].lastIndex=i;
    				}
    			}
    		}
    	}
    	//����С���ȵ�������ĳ��ȷ���
    	int min=Integer.MAX_VALUE;
    	int gap=0;
    	for(int i=0; i<de.length; i++) {
    		gap=de[i].lastIndex-de[i].firstIndex;
    		//Ԫ��ֻ������һ��
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
