package com.xjtu;

public class IsOneBitCharacter {

	
    public static boolean isOneBitCharacter(int[] bits) {
        //����ǰ�������,�ж����һ���Ǽ�1���Ǽ�2
    	boolean flag=false;
    	for(int i=0; i<bits.length; ) {
        	if(bits[i]==0) {
        		i++;
        		flag=true;
        	}else {
        		flag=false;
        		i+=2;
        	}
        	
        }
    	return flag;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []bits= {1,1,1,0};
//		int []bits= {1,0,0};
//		int []bits= {1,1};
		boolean res=isOneBitCharacter(bits);
		System.out.println(res);
	}

}
