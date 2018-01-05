package com.xjtu.mystack;

import com.xjtu.myqueue.MyQueue;

/**
 * 使用2个队列模拟栈
 * @author Administrator
 *
 */
public class QueueSimulateStack {
	private MyQueue head; //存放栈顶元素的队列
	private MyQueue data; //存放其他元素的队列
	private int length; //当前栈的高度 
	
	/**
	 * 初始化当前的栈
	 */
	public QueueSimulateStack() {
		head=new MyQueue();
		data=new MyQueue();
		length=0;
	}
	
	/**
	 * 判断当前的栈是否为空
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		
		//如果栈顶队列为空，数据队列为空，则当前栈为空
		if(head.isEmpty() && data.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 返回当前栈的长度
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * 入栈操作
	 * @param obj 入栈对象
	 * @return boolean
	 */
	public synchronized boolean push(Object obj) {
		Object tmp=null;
		//入栈之前判断头结点队列是否为空，为空那么新元素直接添加到头结点队列中；如果头结点队列不为空，先将队列清空到数据队列，再将新节点添加到head队列
		if(! head.isEmpty()) {
			//清空队列
			while(! head.isEmpty()) {
				tmp=head.delete(); //出队列，按顺序清空队列
				data.append(tmp);
			}
		}
		//清空之后再将新元素添加进来
		head.append(obj);
		length++;
		return true;
	} 
	
	/**
	 * 出栈
	 * @return Object
	 */
	public synchronized Object pop() {
		Object obj=null;
		//如果整个栈是空的，那么直接退出
		if(isEmpty()) {
			return null;
		}
		//如果栈顶元素队列不为空,且只有一个元素
		if(! head.isEmpty() && head.getLength()==1) {
			length--;
			return head.delete();
		}else if(head.isEmpty()){ //如果是第一次出栈， 那么栈顶队列就为空，需要将数据队列先清空到栈顶队列
			while(data.getLength()!=1) {				
				obj=data.delete();
				head.append(obj);
			}
			length--;
			return data.delete();
		}else if(data.isEmpty()){ //这是第二次出队列之后将数据队列中的元素全部清空了，现在栈顶元素在head队列的末尾
			while(head.getLength()!=1) {
				obj=head.delete();
				data.append(obj);
			}
			length--;
			return head.delete();
		}
		//以上就是三种情况，一般的出栈的情形就在后两者之间徘徊
		return null;
	}
	
	/**
	 * 获得栈顶元素
	 * @return Object
	 */
	public synchronized Object peek() {
		Object obj=null;
		if(isEmpty()) { //如果当前栈为空
			return null;
		}
		if(head.getLength()==1) { //这块是第一次出栈之前的情形或者是最后只剩下两个元素的时候
			return head.peek();
		}
		if(head.isEmpty()) { //这是第一次出栈之后的情形
			while(data.getLength()!=1) { //清空data队列，保留最后一个元素，返回
				obj=data.delete();
				head.append(obj);
			}
//			return data.peek();
			//删除最后一个元素同时将它添加进队列
			obj=data.delete();
			head.append(obj);
			return obj;
		}
		if(data.isEmpty()) {
			while(head.getLength()!=1) {
				obj=head.delete();
				data.append(obj);
			}
//			return head.peek();
			obj=head.delete();
			data.append(obj);
			return obj;
		}
		//总之，在两个队列中间来回的变换，使得某一个队列中只剩下一个元素的时候就是栈顶的元素，返回即可
		return null;
	}
	
	/**
	 * 测试上面的方法
	 * @param args
	 */
	public static void main(String []args) {
		QueueSimulateStack stack=new QueueSimulateStack();
		System.out.println("队列是否为空："+stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println("栈顶元素："+stack.peek()); //peek引起了后续的很多问题，看一下方法的书写是不是有问题
		System.out.println("出栈元素："+stack.pop());
		System.out.println("队列是否为空："+stack.isEmpty());
		System.out.println("当前栈的长度："+stack.getLength());
		System.out.println("栈顶元素："+stack.peek());
		
		System.out.println("出栈元素："+stack.pop());
		System.out.println("当前栈的长度："+stack.getLength());
		System.out.println("栈顶元素："+stack.peek());
	}	
}
