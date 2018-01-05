package com.xjtu;

public class CanPlaceFlowers {
	
	/**
	 * �ж��Ƿ��ܹ��ֻ�,�뷨���̶���ʼ�ͽ���λ�ã�Ȼ��ͨ��λ�õĲ���ϵ������Ե�ռ�������3����λ��
	 * @param flowerbed
	 * @param n
	 * @return
	 */
/*    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int start=0,end=flowerbed.length-1; //��ǿ�ʼ�ͽ���λ��
    	int left=-1,right=-1; //������¼����������λ�õ�����
    	int index=0;
    	int remains=0;
    	if(flowerbed.length==1 && (n==0 || n==1)) { //���ǽ���ֻ��һ����
    		return true;
    	}
    	
    	while(index<flowerbed.length && flowerbed[index]!=1) { //���ȼ����һ������֮ǰ���ּ����� 
    		index++;
    	}
    	remains=n-(index-start)/3; //���㿪ʼ�ĵط����ж��ٿû����������ʣ�໨��
    	//�����м��ⲿ�ֿ����ж��ٵĻ�
    	for(int i=index;i<flowerbed.length;i++) {
    		if(flowerbed[i]!=0 && left==-1) {//�ҵ���һ���Ѿ��ֻ���λ�ã�����û�б�ǹ�
    			left=i;
    			continue;
    		}
    		if(flowerbed[i]!=0 && right==-1) {
    			right=i;
    		}
    		//��������λ�ÿ����ֻ�������,
    		if(left!=0 && right!=0) {
    			remains-=(right-left-1)/3;
    			left=right=-1;
    		}
    	}
    	//�������λ�����м���
    	remains-=(end-left)/3;
    	if(remains<=0) {
    		return true;
    	}else {
    		return false;
    	}
    }*/
	/**
	 * ǰһ���㷨©���ܴ󣬵�����Ϊ�գ�������������ֻ����һ�������õ��Ľ���Ǵ����
	 * �����㷨�Ĺ��죬����������ģ������Եĵ�һ��λ�õ����һ��λ�ã����ϵļ��
	 * @param flowerbed
	 * @param n
	 * @return
	 */
/*	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int remains=n;
		int index=0;
		if(flowerbed.length==1 && flowerbed[0]==0 && (n==1 || n==0)) {
			return true;
		}
		
		//�����ҵ���һ��û���ֻ���λ��
		while(index<flowerbed.length && flowerbed[index]==1) { //���Ĵ���û�п��ǵ�flowerbed�Ƚ϶̵����ο��ԸĽ���������Ҫ����������
			index+=2;
		}
		
		for(index=index;index<flowerbed.length;index+=2) {
			if((flowerbed[index]!=1 && index+1<flowerbed.length && flowerbed[index+1]==0) || (flowerbed[index]==0 && index==flowerbed.length-1 && flowerbed[index-1]==0)) { //�ڶ����������������һ��λ�õ�����
				if(index==0) {
					remains-=1;
				}
				if(index!=0 && flowerbed[index-1]==0) {
					remains-=1;
				}
			}
			if(remains<=0) {// ���ð����еĻ����ֽ�ȥ
				break;
			}
		}
		System.out.println("remains:"+remains);
		if(remains<=0) {
			return true;
		}
		return false;
	}*/
	/**
	 * �ڶ��ַ���ʧ���ˣ�ԭ����̫���壬��һЩ���������в�ͨ�ģ��ڿ����ֻ��ĵط�����õ��޷��ֻ�
	 * ���·�����˼·��������һ��һ�εĽ����ۼӣ����鿴����Ƿ�
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count=1;
		int result=0;
		for(int i=0;i<flowerbed.length;i++) {
			if(flowerbed[i]==0) {
				count++;
			}else {
				result+=(count-1)/2;
				count=0;
			}
		}
		if(count!=0) {
			result+=count/2;
		}
		return result>=n;
	}
	public static void main(String []args) {
//		int []flowerbed= {0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0};
//		int n=17;
//		int []flowerbed = {1,0,0,0,1};
//		int n=2;
//		int []flowerbed= {0};
//		int n=1;
//		int []flowerbed = {0,0,1,0,0};
//		int n=2;
//		int []flowerbed = {0};
//		int n=0;
		int []flowerbed = {1};
		int n=0;
		boolean res=canPlaceFlowers(flowerbed,n);
		System.out.print(res);
	}

}
