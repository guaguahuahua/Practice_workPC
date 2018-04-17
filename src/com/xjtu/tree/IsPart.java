package com.xjtu.tree;

import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * �ж�һ���������Ƿ�Ϊ��һ�����������ӽṹ
 * @author Administrator
 *
 */
public class IsPart {
	
	private static Node res=null;
	/**
	 * ����ȥ����û�к�r2���ڵ���ͬ�Ľڵ㣬�������ô����r2Ҳ����r1���Ǹ��ڵ㣬�ж����ǵ������Ƿ���ͬ
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart(Node r1, Node r2) {
		find(r1, r2);
		//����ҵ���r2�еĸ��ڵ�
		if(res!=null) {
			List<Integer> l1=new ArrayList<Integer>();
			List<Integer> l2=new ArrayList<Integer>();
			preOrder(res, l1);
			preOrder(r2, l2);
			//�ж������е�Ԫ���Ƿ�����ͬ��
			for(int i=0; i<l2.size(); i++) {
				if(l1.get(i)!=l2.get(i)) {
					return false;
				}
			}
		//���û����r2�ĸ��ڵ�	
		}else {
			return false;	
		}
		return true;
	}
	
	/**
	 * ʹ����������ķ�ʽ�õ��������У����������ȫһ�£���ô˵��r2����r1���ӽṹ
	 * @param root
	 * @param list
	 */
	public static void preOrder(Node root, List<Integer> list) {
		if(root!=null) {
			list.add(root.data);
			preOrder(root.left, list);
			preOrder(root.right, list);
		}
	} 
	
	
	
	
	/**
	 * ʹ����������ķ�ʽѰ���ӽṹr2����������ҵ�����ô�����ҵ��Ŀ�ʼ�ڵ�
	 */
	public static void find(Node r1, Node r2) {
		//���ڣ��ҵ����˳�������ݹ�
		if(r1!=null) {
			if(r1.data==r2.data) {
				res=r1;
				return ;
			}else {
				find(r1.left, r2);
				find(r1.right, r2);
			}	
		}
	}
	
	/**
	 * ʹ����������ķ�ʽ������еĽڵ�
	 * @param root
	 */
	public static void show(Node root) {
		if(root!=null) {
			System.out.print(root.data+"\t");
			show(root.left);
			show(root.right);
		}
	}
	
	/**
	 * ����ڱ����Ĺ������ҵ���ֵ��ͬ�Ľڵ㣬��ô��ֱ�ӽ�����ֵ�ıȶ�
	 * ���ʹ���˵ݹ��Ƕ�ף��Ƚ������
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart_1(Node r1, Node r2) {
		//���ĸ��Ϊ�գ��Ǿ���û���ҵ���Ӧ�Ľڵ�
		if(r1==null) {
			return false;
		}
		//�������Ϊ�գ���ô��Ϊ�ҵ���
		if(r2==null) {
			return true;
		}
		boolean res1=false,res2=false;
		//�����ǰ�ڵ��ֵ��ȣ���ô�ӵ�ǰ�ڵ㿪ʼ����
		if(r1.data==r2.data) {
			res1=compare(r1, r2);
			return res1;
		}else {
			res1=isPart_1(r1.left, r2);
			res2=isPart_1(r1.right, r2);
			return res1 || res2;
		}
		
//		return res1;
	}
	
	/**
	 * �ݹ�ıȽ�����Ԫ���Ƿ���ȫһ��
	 * @param r1
	 * @param r2
	 */
	public static boolean compare(Node r1, Node r2) {
		boolean res1 = false,res2 = false;
		if(r1==null && r2!=null) {
			return false;
		}else if(r1==null && r2==null) {
			return true;
		}else if(r1!=null && r2==null) {
			return true;
		}else {
			if(r1.data==r2.data) {
				res1=compare(r1.left, r2.left);
				res2=compare(r1.right, r2.right);
			}
		}
		return res1 && res2;
	}
	
	/**
	 * ʹ�ò�������ķ�ʽѰ�Ҹ��ڵ㣬�ҵ���ֵͬ�ڵ�֮���ٽ��еݹ��Ѱ��
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart_2(Node r1, Node r2) {
		
		LinkedList<Node> stack=new LinkedList<Node>();
		stack.push(r1);
		boolean res=false;
		//���ջ��Ϊ��
		while(!stack.isEmpty()) {
			Node t=stack.pop();
			//�����ǰ�ڵ��ֵ��r2��ֵ��һ��
			if(t.data!=r2.data) {
				stack.push(t.left);
				stack.push(t.right);
			}else {
				//�ݹ�ķ�ʽ�Ƚ����ǵ�ֵ�Ƿ���ȫһ��
				res=compare(t, r2);
				break;
			}
		}
		return res;
	}
	
	/**
	 * isPart_2�Ǵ���ģ���Ȼ�����ȷ�����ǲ��ǰ����ҵ�˼·���ģ��������ʹ�õ����ݽṹ�Ƕ��У�
	 * �����Ƕ�ջ
	 * @param r1
	 * @param r2
	 * @return
	 */
	public static boolean isPart_3(Node r1, Node r2) {
		
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(r1);
		boolean res=false;
		//���ջ��Ϊ��
		while(!queue.isEmpty()) {
			Node t=queue.poll();
			//�����ǰ�ڵ��ֵ��r2��ֵ��һ��
			if(t.data!=r2.data) {
				queue.add(t.left);
				queue.add(t.right);
			}else {
				//�ݹ�ķ�ʽ�Ƚ����ǵ�ֵ�Ƿ���ȫһ��
				res=compare(t, r2);
				break;
			}
		}
		return res;
	}
	
	public static void main(String []args) {
		Node r1=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		Node n5=new Node(6);
		r1.left=n1;
		r1.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		
		Node r2=new Node(3);
		Node n21=new Node(9);
		r2.left=n21;
//		show(r2);
		Boolean res=isPart_3(r1, r2);
		System.out.print(res);
	}

}
