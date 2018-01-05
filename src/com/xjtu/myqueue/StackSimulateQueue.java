package com.xjtu.myqueue;

import com.xjtu.mystack.MyStack;

/**
 * 使用栈模拟队列
 * @author Administrator
 *
 */
public class StackSimulateQueue {
	
	private MyStack appendStack; //入队列栈
	private MyStack deleteStack; //出队列栈
	private int length; //队列的长度
	
	/**
	 * 初始化队列
	 */
	public StackSimulateQueue() {
		appendStack=new MyStack();
		deleteStack=new MyStack();
		length=0;
	}
	
	/**
	 * 入队列
	 * @param data 入队的数据
	 * @return boolean 
	 */
	public synchronized boolean append(Object data) {
		
		//如果出队列为空，说明数据都在入队列栈中，直接添加进去即可
		if(deleteStack.isEmpty()) {
			appendStack.push(data);
		//如果删除栈不为空，那么先将数据回填到入队列栈中
		}else {
			//将删除队列中的栈清掉
			while(! deleteStack.isEmpty()) {
				Object obj=deleteStack.pop();
				//数据回填到入队列栈中
				appendStack.push(obj);
			}
			//将数据添加到最后的尾巴
			appendStack.push(data);
		}		
		length++;
		return true;
	}
	
	/**
	 * 出队列
	 * @return Object
	 */
	public synchronized Object delete() {
		Object obj=null;
		//如果数据栈为空，出队列栈不为空那么就可以删除
		if(appendStack.isEmpty() && !deleteStack.isEmpty()) {
			
			obj=deleteStack.pop();
			length--;
			return obj;			
		//如果数据栈不为空	
		}else if(! appendStack.isEmpty()) {
			//清空数据栈，将数据转到删除栈中去
			while(! appendStack.isEmpty()) {
				obj=appendStack.pop();
				deleteStack.push(obj);
			}
			obj=deleteStack.pop();
			length--;
		}
		return obj;
	}
	
	/**
	 * 判断当前队列是否为空头
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		if(appendStack.isEmpty() && deleteStack.isEmpty()) {
			return true;
		}
		return false;
	} 
	
	/**
	 * 查看队头元素
	 * @return Object
	 */
	public synchronized Object peek() {
		Object obj=null;
		if(isEmpty()) {
			return null;
		}else if(appendStack.isEmpty()) {
			return deleteStack.peek();
		}else {
			//如果删除栈为空，那么先将入队列的栈清空，在去头元素
			while(! appendStack.isEmpty()) {
				obj=appendStack.pop();
				deleteStack.push(obj);
			}
			return deleteStack.peek();
		}
	}
	
	/**
	 * 获取队列长度
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	
	/**
	 * 测试栈模拟队列的效果
	 * @param args
	 */
	public static void main(String []args) {
		StackSimulateQueue queue=new StackSimulateQueue();
		queue.append(1);
		queue.append(2);
		queue.append(3);
		queue.append(4);
		System.out.println("队列是否为空："+queue.isEmpty());
		System.out.println("队列头元素为："+queue.peek());
		queue.append(5);
		queue.append(6);
		System.out.println("队列的长度为："+queue.getLength());
//		queue.delete();
		queue.append(1);
		queue.append(2);
		queue.append(3);
		queue.append(4);
		System.out.println("队列的长度为："+queue.getLength());
		System.out.println("队列头元素为："+queue.peek());
		
	}
}
