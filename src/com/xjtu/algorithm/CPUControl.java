package com.xjtu.algorithm;

public class CPUControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		controlCPU_1();
	}
	/**
	 * 方法1：让CPU忙一秒闲一秒
	 * 忙一秒是通过让cpu1秒内多次执行一个空循环来完成
	 * 闲一秒通过让线程挂起实现
	 */
	public static void controlCPU() {
		while(true) {
			//cpu busy
			for(int i=0;i<3.4*Math.pow(10,9)*2/4;i++) {	
				
			}
			//cpu free
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	/**
	 * 方法2：给一个时间间隔，在这个时间内cpu忙，否则cpu闲着
	 */
	public static void controlCPU_1() {
		int idle=100;
		int gap=100;
		
		while(true) {
			//cpu busy
			long startTime=System.currentTimeMillis();
			while((System.currentTimeMillis())-startTime<=gap) {
			}
			//cpu free
			try {
				Thread.sleep(idle);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
