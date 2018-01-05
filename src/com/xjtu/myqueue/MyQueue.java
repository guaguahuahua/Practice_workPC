package com.xjtu.myqueue;

import java.util.Arrays;

/**
 * 在这块用数组实现顺序循环队列
 * @author Administrator
 *
 */
public class MyQueue {
	private Object []data; //存放数据元素
	private int head; //记录队列头的位置
	private int tail; //记录队列尾的位置 
	private int length; //当前队列的长度
	
	//初始化队列
	public MyQueue() {
		data=new Object[10];
		head=0;
		tail=0;
		length=0;
	}
	
	/**
	 * 判断当前队列是否为空
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		
		if(length==0 && head==tail) {
			return true;
		}
		return false;
	}
	/**
	 * 获取当前队列的长度
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * 顺序队列入队
	 * @param num 入队元素
	 * @return boolean
	 */
	public synchronized boolean append(Object num) {
		
		//如果当前队列的元素已满
		if(tail==head && length==data.length) {
//			System.out.println("队列已满，无法加入！");
			ensureCapacity(); //扩充容量
//			return false;
		}
		//数据入队
		data[tail]=num;
		tail=(tail+1) % data.length;		
		length++;
		return true;
	}
	
	/**
	 * 当队列已满的时候相办法扩充容量
	 */
	private synchronized void ensureCapacity() {
		int length=getLength();
		int newLen=10;
		data=Arrays.copyOf(data, length+newLen);
	}
	
	/**
	 * 出队列
	 * @return Object
	 */
	public synchronized Object delete() {

		//存放出队列的元素
		Object obj=null;
		//队列为空
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
	 * 判断当前的队列是否为空
	 * @return Object
	 */
	public synchronized Object peek() {
		if(isEmpty()) {
			return null;
		}
		return data[head];
	}
	
	
	/**
	 * 测试上面的方法
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
		
		System.out.println("当前队列是否为空："+queue.isEmpty());
		System.out.println("当前队列长度："+queue.getLength());
		System.out.println("队头元素为:"+queue.peek());
		queue.append(11);
//		queue.delete();
		boolean res=queue.append(11);
		System.out.println("添加成功："+res);
		System.out.println("当前队列长度："+queue.getLength());
	}
}
