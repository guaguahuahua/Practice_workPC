package com.xjtu.algorithm;

public class CPUControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		controlCPU_1();
	}
	/**
	 * ����1����CPUæһ����һ��
	 * æһ����ͨ����cpu1���ڶ��ִ��һ����ѭ�������
	 * ��һ��ͨ�����̹߳���ʵ��
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
	 * ����2����һ��ʱ�����������ʱ����cpuæ������cpu����
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
