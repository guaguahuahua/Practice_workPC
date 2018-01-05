package com.xjtu.myqueue;

import java.util.Arrays;

/**
 * �����������ʵ��˳��ѭ������
 * @author Administrator
 *
 */
public class MyQueue {
	private Object []data; //�������Ԫ��
	private int head; //��¼����ͷ��λ��
	private int tail; //��¼����β��λ�� 
	private int length; //��ǰ���еĳ���
	
	//��ʼ������
	public MyQueue() {
		data=new Object[10];
		head=0;
		tail=0;
		length=0;
	}
	
	/**
	 * �жϵ�ǰ�����Ƿ�Ϊ��
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		
		if(length==0 && head==tail) {
			return true;
		}
		return false;
	}
	/**
	 * ��ȡ��ǰ���еĳ���
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * ˳��������
	 * @param num ���Ԫ��
	 * @return boolean
	 */
	public synchronized boolean append(Object num) {
		
		//�����ǰ���е�Ԫ������
		if(tail==head && length==data.length) {
//			System.out.println("�����������޷����룡");
			ensureCapacity(); //��������
//			return false;
		}
		//�������
		data[tail]=num;
		tail=(tail+1) % data.length;		
		length++;
		return true;
	}
	
	/**
	 * ������������ʱ����취��������
	 */
	private synchronized void ensureCapacity() {
		int length=getLength();
		int newLen=10;
		data=Arrays.copyOf(data, length+newLen);
	}
	
	/**
	 * ������
	 * @return Object
	 */
	public synchronized Object delete() {

		//��ų����е�Ԫ��
		Object obj=null;
		//����Ϊ��
		if(length==0 && head==tail) {
			return null;
		}
		obj=data[head];
		data[head]=null;
		head=(head+1) % data.length;
		length--;
		return obj;
	}
	
	/**
	 * �жϵ�ǰ�Ķ����Ƿ�Ϊ��
	 * @return Object
	 */
	public synchronized Object peek() {
		if(isEmpty()) {
			return null;
		}
		return data[head];
	}
	
	
	/**
	 * ��������ķ���
	 * @param args
	 */
	public static void main(String []args) {
		
		MyQueue queue=new MyQueue();
		
		queue.append(1);
		queue.append(2);
		queue.append(3);
		queue.append(4);
		queue.append(5);
		queue.append(6);
		queue.append(7);
		queue.append(8);
		queue.append(9);
		queue.append(10);
		
		System.out.println("��ǰ�����Ƿ�Ϊ�գ�"+queue.isEmpty());
		System.out.println("��ǰ���г��ȣ�"+queue.getLength());
		System.out.println("��ͷԪ��Ϊ:"+queue.peek());
		queue.append(11);
//		queue.delete();
		boolean res=queue.append(11);
		System.out.println("��ӳɹ���"+res);
		System.out.println("��ǰ���г��ȣ�"+queue.getLength());
	}
}
