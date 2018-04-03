package com.xjtu.algorithm;

public class JudegeRepeated {

	/**
	 * 判断矩形和圆是否相交
	 * 使用方法：判断圆心和矩形中心距离是否大于半径和宽的一半
	 * 矩形的坐标给定是从左上角开始依次的顺时针转一圈
	 * @param o
	 * @param radius
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return boolean 相交返回true， 否则返回false
	 */
	public static boolean isRepeated(int [] o, int radius, int []a, int []b, int []c, int []d) {
		//首先判断圆心的位置
		//首先判断圆心的x左边的位置
		//圆在矩形的左边，圆在矩形的右边
		boolean left=false;
		boolean up=false;
		boolean right=false;
		boolean down=false;
		//如果圆在矩形的左边
		if(o[0]<=a[0]) {
			left=true;
		}else {
			right=true;
		}
		//判断圆在矩形的上下位置
		if(o[1]>=a[1]) {
			up=true;
		}else {
			down=true;
		}
		int height=0;
		int width=0;
		//确定长和宽
		width=b[0]-a[0];
		height=a[1]-d[1];
		//求矩形的中心坐标
		int []center= {(b[0]-a[0])/2, (a[1]-d[1])/2};		
		double distance=0;
		
		//如果在上下位置
		if(up || down) {
			distance=Math.sqrt( Math.pow(Math.abs(center[0]-o[0]), 2) + Math.pow(center[1]-o[1], 2) );
			double r=height/2 + radius;
			if(r>distance) {
				return true;
			}
		}
		//左右位置
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
