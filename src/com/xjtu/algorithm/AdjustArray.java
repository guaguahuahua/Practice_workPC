package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * ����������������ż��λ�ã�ʹ�������������ǰ�벿�֣�ż���ں�벿��
 * ����������ż�������λ�ò��ᷢ���仯
 * @author Administrator
 *
 */
public class AdjustArray {

	/**
	 * ֱ��ʹ���������Ϸֱ���������ż����֮�������εĽ�������Ԫ�طŻص�������
	 * @param nums
	 */
	public static void adjustArray(int []nums) {
		List<Integer> odd=new ArrayList<Integer>();
		List<Integer> even=new ArrayList<Integer>();
		//�ּ����
		for(int i=0; i<nums.length; i++) {
			//�����ż��
			if((nums[i]>>1<<1)==nums[i]) {
				even.add(nums[i]);
			}else {
				odd.add(nums[i]);
			}
		}
		//�������е�Ԫ�ػ���
		int index=0;
		for(int i=0; i<odd.size(); i++) {
			nums[index]=odd.get(i);
			index++;
		}
		for(int i=0; i<even.size(); i++) {
			nums[index]=even.get(i);
			index++;
		}
	}
	
	/**
	 * ʹ����������ķ�ʽ�����
	 * @param nums
	 */
	public static void adjustArray_1(int []nums) {
		int len=nums.length;
		//�ֱ���������ż��Ԫ�� ������
		int []odd=new int[len];
		int []even=new int[len];
		int oLen=0;
		int eLen=0;

		//����������зּ�
		for(int i=0; i<nums.length; i++) {
			//ż��
			if(( (nums[i]>>1) <<1)==nums[i]) {
				even[eLen]=nums[i];
				eLen++;
			}else {
				odd[oLen]=nums[i];
				oLen++;
			}
		}
		//���ݻ���
		int index=0;
		for(int i=0; i<oLen; i++) {
			nums[index]=odd[i];
			index++;
		}
		
		for(int i=0; i<eLen; i++) {
			nums[index]=even[i];
			index++;
		}
		
	}
	
	/**
	 * ʹ��һ��ż��������ʵ�֣�����������ǰ���ż��
	 * @param nums
	 */
	public static void adjustArray_2(int []nums) {
		int []even=new int[nums.length];
		int eLen=0;
		int left, right;
		for(left=0, right=0 ; right<nums.length; ) {
			//�����ǰԪ���Ǹ�ż��
			if((nums[left]>>1)<<1==nums[left]) {
				
				right=left;
				while(right<nums.length) {
					//����ұߵ��Ǹ���������ô����ǰ���ż��
					if(nums[right]>>1<<1!=nums[right]) {
						//����֮ǰ�Ƚ�ż�����Ƶ���ʱ������
						even[eLen]=nums[left];
						eLen++;
						nums[left]=nums[right];
						left++;

					}
					right++;
				}
				break;
			//��ǰԪ��������	
			}else {
				left++;
			}
		}
		//���ս�ż�����������ȥ
		for(int i=left+1, j=0; i<nums.length; i++,j++) {
			nums[i]=even[j];
		}
	}
	
	/**
	 * ͨ�����������������е�Ԫ�أ�ͨ�����ϵı���������ÿ��ֻ����������ż��������ǰ���Ԫ��
	 * @param nums
	 */
	public static void adjustArray_3(int []nums) {
		
		
		//һ�ν��������е�Ԫ��
		while(true){
			boolean swap=false;
			for(int i=0; i<nums.length-1; i++) {
				//���ż����ǰ�������ں���ô����
				if(nums[i]>>1<<1==nums[i] && nums[i+1]>>1<<1!=nums[i+1]) {
					int temp=nums[i];
					nums[i]=nums[i+1];
					nums[i+1]=temp;
					swap=true;
				}
			}	
			//Ҳ����˵��һ�εĳ�ʼ����û�иı�boolean�ı���ֵ����ô�������н�����Ԫ���Ѿ� �������
			if(swap==false) {
				break;
			}
		}
				
	}
	
	
	
	/**
	 * ���������Ԫ��
	 * @param nums
	 */
	public static void show(int []nums) {
		for(int K: nums) {
			System.out.print(K+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1,2,3,4,5};
		show(nums);
		adjustArray_3(nums);
		show(nums);
	}

}
