package com.xjtu.myqueue;

import com.xjtu.mystack.MyStack;

/**
 * ʹ��ջģ�����
 * @author Administrator
 *
 */
public class StackSimulateQueue {
	
	private MyStack appendStack; //�����ջ
	private MyStack deleteStack; //������ջ
	private int length; //���еĳ���
	
	/**
	 * ��ʼ������
	 */
	public StackSimulateQueue() {
		appendStack=new MyStack();
		deleteStack=new MyStack();
		length=0;
	}
	
	/**
	 * �����
	 * @param data ��ӵ�����
	 * @return boolean 
	 */
	public synchronized boolean append(Object data) {
		
		//���������Ϊ�գ�˵�����ݶ��������ջ�У�ֱ����ӽ�ȥ����
		if(deleteStack.isEmpty()) {
			appendStack.push(data);
		//���ɾ��ջ��Ϊ�գ���ô�Ƚ����ݻ�������ջ��
		}else {
			//��ɾ�������е�ջ���
			while(! deleteStack.isEmpty()) {
				Object obj=deleteStack.pop();
				//���ݻ�������ջ��
				appendStack.push(obj);
			}
			//��������ӵ�����β��
			appendStack.push(data);
		}		
		length++;
		return true;
	}
	
	/**
	 * ������
	 * @return Object
	 */
	public synchronized Object delete() {
		Object obj=null;
		//�������ջΪ�գ�������ջ��Ϊ����ô�Ϳ���ɾ��
		if(appendStack.isEmpty() && !deleteStack.isEmpty()) {
			
			obj=deleteStack.pop();
			length--;
			return obj;			
		//�������ջ��Ϊ��	
		}else if(! appendStack.isEmpty()) {
			//�������ջ��������ת��ɾ��ջ��ȥ
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
	 * �жϵ�ǰ�����Ƿ�Ϊ��ͷ
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		if(appendStack.isEmpty() && deleteStack.isEmpty()) {
			return true;
		}
		return false;
	} 
	
	/**
	 * �鿴��ͷԪ��
	 * @return Object
	 */
	public synchronized Object peek() {
		Object obj=null;
		if(isEmpty()) {
			return null;
		}else if(appendStack.isEmpty()) {
			return deleteStack.peek();
		}else {
			//���ɾ��ջΪ�գ���ô�Ƚ�����е�ջ��գ���ȥͷԪ��
			while(! appendStack.isEmpty()) {
				obj=appendStack.pop();
				deleteStack.push(obj);
			}
			return deleteStack.peek();
		}
	}
	
	/**
	 * ��ȡ���г���
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	
	/**
	 * ����ջģ����е�Ч��
	 * @param args
	 */
	public static void main(String []args) {
		StackSimulateQueue queue=new StackSimulateQueue();
		queue.append(1);
		queue.append(2);
		queue.append(3);
		queue.append(4);
		System.out.println("�����Ƿ�Ϊ�գ�"+queue.isEmpty());
		System.out.println("����ͷԪ��Ϊ��"+queue.peek());
		queue.append(5);
		queue.append(6);
		System.out.println("���еĳ���Ϊ��"+queue.getLength());
//		queue.delete();
		queue.append(1);
		queue.append(2);
		queue.append(3);
		queue.append(4);
		System.out.println("���еĳ���Ϊ��"+queue.getLength());
		System.out.println("����ͷԪ��Ϊ��"+queue.peek());
		
	}
}
