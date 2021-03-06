package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * 使用两个栈模拟队列
 * @author Administrator
 *
 */
public class StackSimulateQueue {

	//队列1用来入队，队列2用来出队
	public static LinkedList<Integer> stack1=new LinkedList<Integer>();
	public static LinkedList<Integer> stack2=new LinkedList<Integer>();
	
	/**
	 * 入队，这里维护s1为入队的栈，s2为出队的栈
	 * @param data
	 */
	public static void append(int data) {
		stack1.push(data);
	}
	
	/**
	 * 这个方法相对于上面的方法在时间上的效果是相同的（入队和出队的情况随机的时候），
	 * 就是不用在出队之后将数据迅速压入到入队栈中，而是保持，在后面进行如果是入队的时候再将
	 * 元素压入到入队栈中去
	 * @param data
	 */
	public static void append_1(int data) {
		//如果stack2不为空，那么先将数据放入到stack1中，再进行入队操作
		if(!stack2.isEmpty()) {
			while(!stack2.isEmpty()) {
				int temp=stack2.pop();
				stack1.push(temp);
			}
		}
		stack1.push(data);
	}
	
	/**
	 * 出队，首先将s1中元素出栈， 并按照出栈顺序压入到s2中去，但是s2栈顶元素出栈完毕之后再将数据
	 * 按照出战的顺序压入到s1中去，
	 * 方案二：将数据出栈之后先不往回倒，继续保留，如果下个操作是入队的时候再将元素回填到s1中去
	 * @return
	 */
	public static int poll() {
		if(stack1.isEmpty()) {
			System.out.println("队列已空！");
			return -1;
		}		
		//将栈1的数据放在栈2中，并退栈
		while(!stack1.isEmpty()) {
			int temp=stack1.pop();
			stack2.push(temp);
		}
		//退栈结束后，将栈2的数据回填到栈1中去
		int res=stack2.pop();
		while(!stack2.isEmpty()) {
			int temp=stack2.pop();
			stack1.push(temp);
		}
		//输出出队的元素
		return res;
	}
	
	public static int poll_1() {
		
		int res=Integer.MAX_VALUE;
		//如果两个栈都为空，那么队列也为空，返回负值
		if(stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("队列为空");
			return -1;
		//如果数据刚好在出队的栈中	
		}else if(!stack2.isEmpty()) {
			res=stack2.pop();
		//如果数据在入队的栈中	
		}else if(!stack1.isEmpty()){
			while(!stack1.isEmpty()) {
				int temp=stack1.pop();
				stack2.push(temp);
			}
			res=stack2.pop();
		}
		return res;
	}
	
	/**
	 * 判读队列是否为空
	 * @return
	 */
	public static boolean isEmpty() {
		if(stack1.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void show() {
		while(!stack1.isEmpty()) {
			int temp=stack1.pop();
			stack2.push(temp);
		}
		while(!stack2.isEmpty()) {
			int temp=stack2.pop();
			System.out.print(temp+"\t");
			stack1.push(temp);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackSimulateQueue queue=new StackSimulateQueue();
		queue.append_1(1);
		queue.append_1(2);
		queue.append_1(3);
		queue.append_1(4);
		queue.append_1(5);
		
		queue.show();
		queue.poll_1();
//		queue.poll_1();
//		queue.poll_1();
		queue.show();
//		queue.append(1);
		queue.show();
	}

}
