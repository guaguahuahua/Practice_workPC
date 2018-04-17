package com.xjtu.algorithm;

public class MinValueOfRotatedArray {
	
	/**
	 * ��ת�����е���СԪ��
	 * @param array
	 * @return
	 */
	public static int minValueOfRotatedArray(int []array) {
		
		for(int i=1; i<array.length; i++) {
			if(array[i]<array[i-1]) {
				return array[i];
			}
		}
		return -1;
	}
	
	/**
	 * ʹ�ö��ֲ��ҷ�ʵ����ת�������Сֵ
	 * ��Ϊ�����д�����������������飬Ȼ����Էֱ��������������в���
	 * ����м�Ԫ�ص������Ԫ�أ���˵���ڵ�һ�����������棬��ָ����Ҫ�����ƶ�
	 * ����м�Ԫ��С�ڵ����ұ�Ԫ�أ���ô˵���ڵڶ������������棬��ָ����Ҫ�����ƶ�
	 * @param array
	 * @return
	 */
	public static int minValueOfRotatedArray_1(int []array) {
		
		int left=0, right=array.length-1;
		while(right-left!=1) {
			int mid=left+(right-left)/2;
			//���ﲻʹ��left=mid+1����right=mid-1��Ҫ�ǲ��Ҷ����ǲ�ȷ����
			//���ܱȽ�֮��ͰѸ�Ԫ�ض�������һ��Ķ��ֲ��ҵĹ����в���Ԫ������ȷ�ģ�����ģ����
			//�����������ǲ��ҵ�Ԫ�ؿ��ܾ��ǵ�ǰ��midԪ��
			if(array[mid]>=array[left]) {
				left=mid;
			}else if(array[mid]<=array[right]){
				right=mid;
			}
		}
		return array[right];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []array= {3,4,5,1,2};
//		int []array= {1,1,1,0,1};
//		int []array= {1,1,0,1,1};
		int []array= {1,1,1,1,0,1,1};
		int res=minValueOfRotatedArray_1(array);
		System.out.println("minValue:"+res);
	}

}
