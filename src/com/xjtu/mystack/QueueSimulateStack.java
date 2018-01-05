package com.xjtu.mystack;

import com.xjtu.myqueue.MyQueue;

/**
 * ʹ��2������ģ��ջ
 * @author Administrator
 *
 */
public class QueueSimulateStack {
	private MyQueue head; //���ջ��Ԫ�صĶ���
	private MyQueue data; //�������Ԫ�صĶ���
	private int length; //��ǰջ�ĸ߶� 
	
	/**
	 * ��ʼ����ǰ��ջ
	 */
	public QueueSimulateStack() {
		head=new MyQueue();
		data=new MyQueue();
		length=0;
	}
	
	/**
	 * �жϵ�ǰ��ջ�Ƿ�Ϊ��
	 * @return boolean
	 */
	public synchronized boolean isEmpty() {
		
		//���ջ������Ϊ�գ����ݶ���Ϊ�գ���ǰջΪ��
		if(head.isEmpty() && data.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * ���ص�ǰջ�ĳ���
	 * @return int
	 */
	public synchronized int getLength() {
		return length;
	}
	
	/**
	 * ��ջ����
	 * @param obj ��ջ����
	 * @return boolean
	 */
	public synchronized boolean push(Object obj) {
		Object tmp=null;
		//��ջ֮ǰ�ж�ͷ�������Ƿ�Ϊ�գ�Ϊ����ô��Ԫ��ֱ����ӵ�ͷ�������У����ͷ�����в�Ϊ�գ��Ƚ�������յ����ݶ��У��ٽ��½ڵ���ӵ�head����
		if(! head.isEmpty()) {
			//��ն���
			while(! head.isEmpty()) {
				tmp=head.delete(); //�����У���˳����ն���
				data.append(tmp);
			}
		}
		//���֮���ٽ���Ԫ����ӽ���
		head.append(obj);
		length++;
		return true;
	} 
	
	/**
	 * ��ջ
	 * @return Object
	 */
	public synchronized Object pop() {
		Object obj=null;
		//�������ջ�ǿյģ���ôֱ���˳�
		if(isEmpty()) {
			return null;
		}
		//���ջ��Ԫ�ض��в�Ϊ��,��ֻ��һ��Ԫ��
		if(! head.isEmpty() && head.getLength()==1) {
			length--;
			return head.delete();
		}else if(head.isEmpty()){ //����ǵ�һ�γ�ջ�� ��ôջ�����о�Ϊ�գ���Ҫ�����ݶ�������յ�ջ������
			while(data.getLength()!=1) {				
				obj=data.delete();
				head.append(obj);
			}
			length--;
			return data.delete();
		}else if(data.isEmpty()){ //���ǵڶ��γ�����֮�����ݶ����е�Ԫ��ȫ������ˣ�����ջ��Ԫ����head���е�ĩβ
			while(head.getLength()!=1) {
				obj=head.delete();
				data.append(obj);
			}
			length--;
			return head.delete();
		}
		//���Ͼ������������һ��ĳ�ջ�����ξ��ں�����֮���ǻ�
		return null;
	}
	
	/**
	 * ���ջ��Ԫ��
	 * @return Object
	 */
	public synchronized Object peek() {
		Object obj=null;
		if(isEmpty()) { //�����ǰջΪ��
			return null;
		}
		if(head.getLength()==1) { //����ǵ�һ�γ�ջ֮ǰ�����λ��������ֻʣ������Ԫ�ص�ʱ��
			return head.peek();
		}
		if(head.isEmpty()) { //���ǵ�һ�γ�ջ֮�������
			while(data.getLength()!=1) { //���data���У��������һ��Ԫ�أ�����
				obj=data.delete();
				head.append(obj);
			}
//			return data.peek();
			//ɾ�����һ��Ԫ��ͬʱ������ӽ�����
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
		//��֮�������������м����صı任��ʹ��ĳһ��������ֻʣ��һ��Ԫ�ص�ʱ�����ջ����Ԫ�أ����ؼ���
		return null;
	}
	
	/**
	 * ��������ķ���
	 * @param args
	 */
	public static void main(String []args) {
		QueueSimulateStack stack=new QueueSimulateStack();
		System.out.println("�����Ƿ�Ϊ�գ�"+stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println("ջ��Ԫ�أ�"+stack.peek()); //peek�����˺����ĺܶ����⣬��һ�·�������д�ǲ���������
		System.out.println("��ջԪ�أ�"+stack.pop());
		System.out.println("�����Ƿ�Ϊ�գ�"+stack.isEmpty());
		System.out.println("��ǰջ�ĳ��ȣ�"+stack.getLength());
		System.out.println("ջ��Ԫ�أ�"+stack.peek());
		
		System.out.println("��ջԪ�أ�"+stack.pop());
		System.out.println("��ǰջ�ĳ��ȣ�"+stack.getLength());
		System.out.println("ջ��Ԫ�أ�"+stack.peek());
	}	
}
