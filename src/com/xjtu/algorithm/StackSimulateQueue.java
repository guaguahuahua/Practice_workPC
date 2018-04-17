package com.xjtu.algorithm;

import java.util.LinkedList;

/**
 * ʹ������ջģ�����
 * @author Administrator
 *
 */
public class StackSimulateQueue {

	//����1������ӣ�����2��������
	public static LinkedList<Integer> stack1=new LinkedList<Integer>();
	public static LinkedList<Integer> stack2=new LinkedList<Integer>();
	
	/**
	 * ��ӣ�����ά��s1Ϊ��ӵ�ջ��s2Ϊ���ӵ�ջ
	 * @param data
	 */
	public static void append(int data) {
		stack1.push(data);
	}
	
	/**
	 * ����������������ķ�����ʱ���ϵ�Ч������ͬ�ģ���Ӻͳ��ӵ���������ʱ�򣩣�
	 * ���ǲ����ڳ���֮������Ѹ��ѹ�뵽���ջ�У����Ǳ��֣��ں�������������ӵ�ʱ���ٽ�
	 * Ԫ��ѹ�뵽���ջ��ȥ
	 * @param data
	 */
	public static void append_1(int data) {
		//���stack2��Ϊ�գ���ô�Ƚ����ݷ��뵽stack1�У��ٽ�����Ӳ���
		if(!stack2.isEmpty()) {
			while(!stack2.isEmpty()) {
				int temp=stack2.pop();
				stack1.push(temp);
			}
		}
		stack1.push(data);
	}
	
	/**
	 * ���ӣ����Ƚ�s1��Ԫ�س�ջ�� �����ճ�ջ˳��ѹ�뵽s2��ȥ������s2ջ��Ԫ�س�ջ���֮���ٽ�����
	 * ���ճ�ս��˳��ѹ�뵽s1��ȥ��
	 * �������������ݳ�ջ֮���Ȳ����ص�����������������¸���������ӵ�ʱ���ٽ�Ԫ�ػ��s1��ȥ
	 * @return
	 */
	public static int poll() {
		if(stack1.isEmpty()) {
			System.out.println("�����ѿգ�");
			return -1;
		}		
		//��ջ1�����ݷ���ջ2�У�����ջ
		while(!stack1.isEmpty()) {
			int temp=stack1.pop();
			stack2.push(temp);
		}
		//��ջ�����󣬽�ջ2�����ݻ��ջ1��ȥ
		int res=stack2.pop();
		while(!stack2.isEmpty()) {
			int temp=stack2.pop();
			stack1.push(temp);
		}
		//������ӵ�Ԫ��
		return res;
	}
	
	public static int poll_1() {
		
		int res=Integer.MAX_VALUE;
		//�������ջ��Ϊ�գ���ô����ҲΪ�գ����ظ�ֵ
		if(stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("����Ϊ��");
			return -1;
		//������ݸպ��ڳ��ӵ�ջ��	
		}else if(!stack2.isEmpty()) {
			res=stack2.pop();
		//�����������ӵ�ջ��	
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
	 * �ж������Ƿ�Ϊ��
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
