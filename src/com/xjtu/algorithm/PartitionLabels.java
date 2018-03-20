package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	/**
	 * ʹ���ַ�����lastIndexOf������ʵ�� 
	 * @param S
	 * @return	List<Integer>	����ÿ���ַ����ĳ�������
	 */
    public static List<Integer> partitionLabels(String S) {
    	int max=0;
    	int preIndex=0;
    	List<Integer> list=new ArrayList<Integer>();
    	
    	for(int i=0; i<S.length(); ) {
    		char c0=S.charAt(i);
    		max=S.lastIndexOf(c0);
    		
    		while(i<=max) {
    			char c=S.charAt(i);
    			//����ַ���һ�γ���λ�ú����һ�γ���λ�ò�һ��
    			if(i!=S.lastIndexOf(c)) {
    				if(S.lastIndexOf(c)>max) {
    					max=S.lastIndexOf(c);
    				}
    				i++;    				
    			//�����ǰλ�ú����һ�γ��ֵ�λ�����	
    			}else {
    				//�����ж��������������ֵ
    				if(i<max) {
    					i++;
    				//��������Ԫ�����ڵ����λ��	
    				}else if(i==max){
    					int len=i-preIndex+1;
    					list.add(len);
    					i++;
    					preIndex=i;
    				}
    			}
    		}
    	}
        return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="ababcbacadefegdehijhklij";
//		String s="basebajijikjillllpplplplp";
		String s="a";
		List res=partitionLabels(s);
		System.out.println(res);
		
	}

}
