package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {

    public static void nextPermutation_1(int[] nums) {
    	boolean flag=false;   	
    	
    	//��δ���ֻ�����鳤�ȴ���2����Ч
        for(int i=nums.length-1; i>0; i--) {
        	//��ԭ������
        	if(nums[i-1]<nums[i]) {
        		//�����ԶԽ���֮������Ԫ�ؽ���һ�����򣬻�����ǵ�ȫ���У���ȡ�ô�Сֵ��Ϊ���յĽ�� 
        		int temp=nums[i-1];
        		nums[i-1]=nums[i];
        		nums[i]=temp;
        		flag=true;
        		break;
        	}
        }
        
        //Ҳ�����������鶼�ǽ������еģ��ǽ�������
        if(!flag) {
        	int left=0;
        	int right=nums.length-1;
        	while(left<right) {
        		int temp=nums[left];
        		nums[left]=nums[right];
        		nums[right]=temp;
        		left++;
        		right--;
        	}
        }
    }
    
    private static ArrayList<Integer> list=new ArrayList<Integer>();
    public static void nextPermutation_2(int []nums) {
    	//���Ȼ������Ԫ�ص��ַ���һ������
    	StringBuilder sb=new StringBuilder();
    	for(int i=0; i<nums.length; i++) {
    		sb.append(nums[i]);
    	}
    	//����ַ���
    	String s=sb.toString();
    	//�Ը��ַ�������ȫ����
    	permutation(s.toCharArray(), 0, s.length()-1);
    	//�����н�������
    	Collections.sort(list);
    	int orig=Integer.parseInt(s);
    	int index=0;
    	//���±��������̬���鶨λ��ԭ����λ��
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i)==orig) {
    			index=i;
    			break;
    		}
    	}
    	String res="";
    	if(index<list.size()-1) {
    		res=list.get(index+1)+"";
    	}else {
    		res=list.get(0)+"";
    	}
    	//����������Ϊ0��ԭ���³��Ȳ�������ô��0
    	while(res.length()<nums.length) {
    		res="0"+res;
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		nums[i]=res.charAt(i)-'0';
    	}
    }
	
    public static void permutation(char []c, int start, int end) {
    	//���ź�����ַ�������ڶ�̬������
    	if(start==end) {
    		StringBuilder sb=new StringBuilder();
    		for(int i=0; i<c.length; i++) {
    			sb.append(c[i]);
    		}
    		int temp=Integer.parseInt(sb.toString());
    		if(!list.contains(temp)) {
    			list.add(temp);
    		}
    		
    	}else {
    		for(int i=start; i<=end; i++) {
    			swap(c, i, start);
    			permutation(c, start+1, end);
    			swap(c, start, i);
    		}
    	}
    }
    
    public static void swap(char []c, int s, int e) {
    	char temp=c[s];
    	c[s]=c[e];
    	c[e]=temp;
    }
    
    
    public static void nextPermutation(int []nums) {
    	
    	//��¼��Ҫ��������ʼλ��
    	int left=-1;
    	//��������ı������ҵ���a[i]>a[i-1]
    	for(int i=nums.length-1; i>=1; i--) {
    		if(nums[i]>nums[i-1]) {
    			left=i-1;
    			break;
    		}
    	}
    	//Ҳ����˵���е�Ԫ�������Ѿ��������ˣ�ֱ�ӽ������򣬻����С������
    	if(left==-1) {
    		int l=0;
    		int r=nums.length-1;
    		while(l<r) {
    			swap(nums, l, r);
    			l++;
    			r--;
    		}
    		return ;
    	}
    	
		//��¼�ұ߽���������
    	int right=-1;
    	//��¼��ֵ
    	int delta=Integer.MAX_VALUE;
    	//���Ҷ�Ѱ�Ҵ��ڵ�ǰֵ������
    	for(int i=left+1; i<nums.length; i++) {
    		//���
    		int temp=nums[i]-nums[left];
    		//����С��ֵ
    		if(temp>0) {
    			delta=temp<delta ? temp : delta;
    			right=i;
    		}
    	}
    	swap(nums, right, left);
    	//�Խ���λ�õ��Ҳ������������
    	int l=left+1;
    	int r=nums.length-1;
    	while(l<r) {        		
    		swap(nums, l, r);
    		l++;
    		r--;
    	}

    }
    
    public static void swap(int []nums, int i, int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {1, 2, 3};
//		int []nums= {3,2,1};
//		int []nums= {1,3,2};
//		int []nums= {1};
		int []nums= {0,0,4,2,1,0};
		nextPermutation(nums);
		for(int K:nums) {
			System.out.print(K);
		}
//		char []c= {'1','2','3'};
		System.out.println();
	}

}
