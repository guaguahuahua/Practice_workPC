package com.xjtu.algorithm;

public class Summation {

	
    
	/**
	 * ��·��
	 * @param n
	 * @return
	 */
	  public static int sum(int n){  
	      int re=0;  
	      boolean whatever=false;  
	      int a=-1;
	      //�ݹ�ĳ���
	      whatever= ((n!=0) && (a==(re=sum(n-1))));
	      return re+n;  
	  } 
	 
	  /**
	   * ��·��
	   * @param n
	   * @return
	   */
	 public static int sum_1(int n) {
		 int ret=0;
		 boolean res=false;
		 int a=-1;
		 //�ݹ�ĳ���
		 res=( (n==0) || a==(ret=sum_1(n-1)) );
		 
		 return ret+n; 
	 } 
	
	public static void main(String args[] ) {
		// TODO Auto-generated method stub
		int res=sum_1(5);
		System.out.println(res);
	}

}
