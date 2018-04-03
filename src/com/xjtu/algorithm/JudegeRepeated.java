package com.xjtu.algorithm;

public class JudegeRepeated {

	/**
	 * �жϾ��κ�Բ�Ƿ��ཻ
	 * ʹ�÷������ж�Բ�ĺ;������ľ����Ƿ���ڰ뾶�Ϳ��һ��
	 * ���ε���������Ǵ����Ͻǿ�ʼ���ε�˳ʱ��תһȦ
	 * @param o
	 * @param radius
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return boolean �ཻ����true�� ���򷵻�false
	 */
	public static boolean isRepeated(int [] o, int radius, int []a, int []b, int []c, int []d) {
		//�����ж�Բ�ĵ�λ��
		//�����ж�Բ�ĵ�x��ߵ�λ��
		//Բ�ھ��ε���ߣ�Բ�ھ��ε��ұ�
		boolean left=false;
		boolean up=false;
		boolean right=false;
		boolean down=false;
		//���Բ�ھ��ε����
		if(o[0]<=a[0]) {
			left=true;
		}else {
			right=true;
		}
		//�ж�Բ�ھ��ε�����λ��
		if(o[1]>=a[1]) {
			up=true;
		}else {
			down=true;
		}
		int height=0;
		int width=0;
		//ȷ�����Ϳ�
		width=b[0]-a[0];
		height=a[1]-d[1];
		//����ε���������
		int []center= {(b[0]-a[0])/2, (a[1]-d[1])/2};		
		double distance=0;
		
		//���������λ��
		if(up || down) {
			distance=Math.sqrt( Math.pow(Math.abs(center[0]-o[0]), 2) + Math.pow(center[1]-o[1], 2) );
			double r=height/2 + radius;
			if(r>distance) {
				return true;
			}
		}
		//����λ��
		if(left || right) {
			distance=Math.sqrt(Math.pow(Math.abs(center[0]-o[0]), 2) + Math.pow(center[1]-o[1], 2));
			double r=width/2+radius;
			if(r>distance) {
				return true;
			}
		}		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   int []o= {1, 2};
	   int radius=3;
	   int []a= {0,1};
	   int []b= {1,1};
	   int []c= {1,0};
	   int []d= {0,0};
	   boolean res=isRepeated(o, radius, a, b, c, d);
	   System.out.println(res);
	}

}
