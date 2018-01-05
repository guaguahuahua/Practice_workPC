package com.xjtu.LinkedList;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * 
 * ����ǵ������࣬������Ҫʵ��һЩ�������õķ���
 * @author Administrator
 */
public class SingleLinkedList {
	public Node head; //ͷ���
	private int length; //����ĳ���
	
	/**
	 * ������ĳ�ʼ�����̣�������Ϊ����ʽ��������Ҫ�õ���ͷ���������������޸���ԭ�������ݽṹ
	 */
	public SingleLinkedList() {
		head=new Node(0);
		length=0;
	}
	
	/**
	 * ����µĽڵ㣬ʹ��β�巨
	 * @param node
	 */
	public void addNodeToEnd(Node node) {
		//���ͷ���Ϊ�գ���ô����ӵĽڵ����ͷ���
		if(head==null) {
			head=node;
			head.next=null;
		}
		//���ͷ��㲻Ϊ����ô������β������
		Node cursor=head;
		while(cursor.next!=null) {
			cursor=cursor.next;
		}
		//����
		cursor.next=node;
//		node.next=null;
	}
	
	/**
	 * �½ڵ�ͷ�巨ʵ��
	 * @param node
	 */
	public void addNodeToHead(Node node) {
		//�ж�ͷ���
		if(head==null) {
			head=node;
			head.next=null;
		}
		//ͷ��㲻Ϊ�գ�ֱ�Ӳ����¸�λ��
		node.next=head.next;
		head.next=node;
	}
	
	/**
	 * ���ص�����ĳ���
	 * @param head
	 * @return int
	 */
	public int getLength(Node head) {
		int count=0;
		if(head==null) {
			return 0;
		}
		//���ͷ��㲻Ϊ��
		Node cursor=head;
		while(cursor!=null) {
			cursor=cursor.next;
			count++;
		}
		return count;
	}
	
	/**
	 * ɾ����indexλ�õĽڵ㣬ɾ���ɹ�����true�����򷵻�false��
	 * @param index ɾ��λ�õ������� λ��������1��ʼ
	 * @return
	 */
	public boolean deleteNode(int index) {
		if(index<1 || index>length) {
			return false;			
		}
		//�����ͷ���
		if(index==1) {
			Node cursor=head.next; //ָ��ͷ����¸�λ��
			head.next=null;
			head=cursor;
		}
		//����ͷ���
		int nowIndex=2;
		Node preNode=head;
		Node curNode=head.next;
		while(curNode!=null) {
			//����ɾ��λ��
			if(nowIndex==index) {
				//ɾ������
				preNode.next=curNode.next;
				return true;
			}
			//û�е���ɾ��λ��
			preNode=curNode;
			curNode=curNode.next;
			nowIndex++;
		}
		//ǰ�涼û����������ô˵��ɾ��ʧ��
		return false;
	}
	
	/**
	 * �Ե���������нڵ�������չʾ
	 * @param head
	 */
	public void showNodes(Node head) {
		if(head==null) {
			System.out.println("����Ϊ�գ�");
			return ;
		}
		//�����нڵ�������
		while(head!=null) {
			System.out.print(head.data+"\t");
			head=head.next;
		}
		System.out.println();
	}
	
	/**
	 * �Ե�����������򣨲������򷨣����������˼·��û�������Ƶ�һ�£�
	 * @param head ���뵥�����ͷ���
	 * @return
	 */
	public Node orderList(Node head) {
		//���ͷ���Ϊ�գ�������ֻ��һ��ͷ���
		if(head==null || head.next==null) {
			return head;
		}
		//��������һ��ָ��ǰͷ��㣬��һ���αָ꣬������ĳ�ڵ�
		Node curNode=head;
		Node nextNode=null;
		//double circle 
		while(curNode.next!=null) {
			nextNode=curNode.next;
			//���εı�����������нڵ㣬�ж����Ǻ͵�ǰ�ڵ�ֵ�Ĵ�С��ϵ������С��ֵ���������
			//Ҳ������һ�������У���ǰ�ڵ��ֵ��õ����˱����е���Сֵ
			while(nextNode!=null) {
				if(nextNode.data<curNode.data) {
					int temp=curNode.data;
					curNode.data=nextNode.data;
					nextNode.data=temp;
				}
				nextNode=nextNode.next;
			}
			curNode=curNode.next;
		}
		return head;
	} 
	
	/**
	 * ɾ���ڵ����ظ���Ԫ��
	 * @param head
	 * return ȥ���ظ�Ԫ��֮��ĵ�����
	 * ���㷨����Ҫ����ʱ��Ч�ʸߣ�ֻ��ҪO(n) ���ǿռ�ռ���ʱȽϸߣ���Ҫռ��O(n)����λ
	 */
	public Node deleteDuplicates(Node head) {
		//��������ͽڵ���Ϊ1���������
		if(head==null || head.next==null) {
			return head;
		}
		//ʹ��hashtableʵ���ж��ظ��Ĺ���
//		Hashtable<Integer, Integer> table=new Hashtable<Integer, Integer>();
		HashMap<Integer, Integer> table=new HashMap<Integer, Integer>();
		Node cur=head;
		Node pre=null;
		//�������е�Ԫ��
		while(cur!=null) {
			//��������˵�ǰ��Ԫ����ô����ɾ������
			if(table.containsKey(cur.data)) {
				pre.next=cur.next;
			}else {
				table.put(cur.data, 1); //�����1������ռλ���Ĵ���
				pre=cur;
			}
			cur=cur.next;
		}
		return head;
	}
	
	/**
	 * ɾ�������е��ظ�Ԫ�أ�����ķ�ʽʹ����hashmap������hashtable���ռ�Ч�ʵͣ����ʺ϶Կռ�������Ҫ��Ƚϸߵ�����
	 * @param head
	 * @return
	 * ˫��forѭ������Ѱ�Ҳ��޳��������ظ���Ԫ��
	 */
	public Node deleteDuplicates_1(Node head) {
		//ͷ���Ϊ�ջ��߽�����һ���ڵ�
		if(head==null || head.next==null) {
			return head;
		}
		Node cur=head;
		while(cur!=null) {
			Node pre=cur;
			Node inner=cur.next;
			
			while(inner!=null) {
				//��������ظ�����ô��ɾ����ǰ�ڵ�
				if(inner.data==cur.data) {
					pre.next=inner.next;
				}
				pre=inner;
				inner=inner.next;
			}
			cur=cur.next;
		}
		return head;
	}
	
	/**
	 * �ҵ��������е�����k��Ԫ�أ�����֤ʱ�临�Ӷ�ΪO(n)
	 * @param head
	 * @param index �����ڼ���
	 * @return ���յĲ��ҽ��
	 */
	public Node findSpecificIndexNode(Node head, int index) {
		
		if(head==null) {
			return null;
		}
		Node fast=head;
		Node slow=head;
		while(index>0) {
			fast=fast.next;
			index--;
		}
		//��ֹ����
		if(index!=0) {
			System.out.println("index ����Խ�磡");
			return null;
		}
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;		
	}
	
	/**
	 * �Ե�����������ã�ԭ��ʵ�� 
	 * @param head ͷ���
	 * @return
	 */
	public Node reverseTheList(Node head) {
		//����һ��ͷ���Ϊ�պ͵����ڵ�����
		if(head==null || head.next==null) {
			return head;
		}
		//�������ڵ������
		if(head.next.next==null) {
			Node start=head.next;
			start.next=head;
			head.next=null;
			return start;
		}
		//����ڵ������
		Node p=head.next;
		Node q=p.next;
		head.next=null;
		while(q!=null) {
			p.next=head;
			head=p;
			p=q;
			q=q.next;			
		}
		p.next=head;
		return p;
	}
	
	/**
	 * ��ͷ��β�������������
	 * ���ַ�ʽ��һ����ά��ջ�ṹ����һ���ǵݹ����ʽ
	 * @param head
	 * @return
	 */
	public void reverseAndOutput(Node head) {
		//ջ�����������
//		LinkedList<Integer> stack=new LinkedList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		while(head!=null) {
//			stack.add(head.data);
			stack.push(head.data);
			head=head.next;
		}
		System.out.println("ջ�ĸ߶�:"+stack.size());
		//����ڵ���Ϣ
		while(! stack.isEmpty()) {
//			System.out.print(stack.removeLast()+"\t");
			System.out.print(stack.pop()+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ʹ�õݹ����ʽʵ�ִ�β��ͷ�����������
	 * @param head
	 */
	public void reverseAndOutput_1(Node head) {
		if(head!=null) {
			reverseAndOutput_1(head.next);
			System.out.print(head.data+"\t");
		}
	}
	
	/**
	 * Ѱ�ҵ�������е㣬ʹ�ÿ���ָ��
	 * @param head
	 * @return
	 */
	public Node findTheMid(Node head) {
		//����һ�¿��������ڵ㣬˫�ڵ������
		if(head==null || head.next==null || head.next.next==null) {
			return head;
		}
		//ʹ�ÿ���ָ�����ʽ�ҵ��е�
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	/**
	 * �ж�����������û�л�
	 * @param head
	 * @return
	 */
	public boolean hasCircle(Node head) {
		//����Ϊ��
		if(head==null) {
			return false;
		}
		//������޻����ڵ������˫�ڵ�
		if(head.next==null || head.next.next==null) {
			return false; 
		}
		//����ڵ�������л�
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) {
				break;
			}
		}
		System.out.println(fast.data);
		return !(fast==null);
	}
	
	/**
	 * �ҵ������ĵ�����Ļ��Ŀ�ʼ�ڵ�
	 * @param head
	 * @return
	 */
	public Node findTheEntrance(Node head) {
		if(head==null) {
			return head;
		}
		//�л�����ô���ҵ�������
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast) {
				break;
			}
		}		
		//Ѱ�һ���ڵ�
		slow=head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	/**
	 * ����һ���ڵ�ɾ���ýڵ�
	 * β�ڵ��޷�ɾ������β�ڵ����ɾ��
	 * @param node 
	 * @return
	 */
	public boolean deleteNode(Node node) {
		//�սڵ������β�ڵ�
		if(node==null || node.next==null) {
			return false;
		}
		int temp=node.data;
		node.data=node.next.data;
		node.next.data=temp;
		node.next=node.next.next;
		return true;
	}
	
	/**
	 * �ж������������Ƿ��н���
	 * @param head1  ������1ͷ���
	 * @param head2 ������2ͷ���
	 * @return 
	 */
	public boolean isIntersect(Node head1, Node head2) {
		//ֻҪ��һ��������Ϊ�գ�����Ϊû�н���
		if(head1==null || head2==null) {
			return false;
		}
		//������ָ���ƶ������������β�ڵ㣬
		while(head1.next!=null || head2.next!=null) {
			
			if(head1.next!=null) {
				head1=head1.next;
			}
			if(head2.next!=null) {
				head2=head2.next;
			}
		}
		//�ж�����β�ڵ��Ƿ���ͬ����ͬ˵�����н���ģ�����ͬ��û�н���
		if(head1==head2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param head1
	 * @param length1
	 * @param head2
	 * @param length2
	 * @return
	 */
	public Node firstIntersectNode(Node head1, int length1, Node head2, int length2) {
		//�������������û�н���
		if(! isIntersect(head1, head2)) {
			return null;
		}
		//����н��㣬��ô�ҵ���һ������
		//�ƶ�ͷ��㱣֤�����뽻��ľ�����ͬ
		Node h1=null; //Ĭ�ϵ�h1���ĸ����Ƚϳ�������
		Node h2=null;
		//����
		int distance=Math.abs(length1-length2);
		if(length1>length2) {
			h1=head1;
			h2=head2;
		}else {
			h1=head2;
			h2=head1;
		}
		//�ƶ��ϳ����Ǹ������ͷ
		while(distance>0) {
			h1=h1.next;
			distance--;
		}
		//����ͬʱ�ƶ�����ͷ��㣬������������ǽ����Ŀ�ʼ��
		while(h1!=h2) {
			h1=h1.next;
			h2=h2.next;
		}
		return h1;
	}
	
	/**
	 * ��Ҫ�Ƕ����漸����Ա�������в���
	 * ���Ҫ���е��ԣ���ô�뱣��ֻ��һ�ι����ǿ����õģ���Ҫȥ�����е�ע��
	 * @param args
	 */
	public static void main(String []args) {
		SingleLinkedList list=new SingleLinkedList();
		list.head=new Node(2);
		Node n4=new Node(6);
		Node n5=new Node(7);
		Node n1=new Node(3);
		Node n2=new Node(4);
		Node n3=new Node(5);
		Node n6=new Node(3);
		Node n7=new Node(9);
		//��ӽڵ�
		list.addNodeToEnd(n4);
		list.addNodeToEnd(n5);
		list.addNodeToEnd(n1);
		list.addNodeToEnd(n2);
		list.addNodeToEnd(n3);
		list.addNodeToEnd(n6);
		list.addNodeToEnd(n7);
		
		//�����ڶ�����������Ҫ��Ϊ��֤����Ľ��㷽����׼��
		SingleLinkedList list1=new SingleLinkedList();
		list1.head=new Node(12);
		Node n8=new Node(23);
		Node n9=new Node(33);
		list1.addNodeToEnd(n8);
		list1.addNodeToEnd(n9);
//		list1.addNodeToEnd(n4);
		n9.next=n4;
		//ɾ���ڵ�
//		list.length=list.getLength(list.head); //����length��ֵ����Ϊ�ڱ����Ĺ�����ʹ�õ�������ĳ����������
//		boolean res=list.deleteNode(3);		
//		System.out.println("ɾ������� "+res);
//		list.showNodes(list.head);
		
		//�� ������в������򣬲���������֮���ͷ����
//		Node start=list.orderList(list.head);
//		list.showNodes(start);
//		System.out.println("���ȣ� "+list.getLength(list.head));

		//ɾ���������ظ���Ԫ��,ʹ��ʱ�������ʸ߷���
//		list.showNodes(list.head);
//		Node newStart=list.deleteDuplicates(list.head);
//		list.showNodes(newStart);
		
		//ɾ���������ظ�Ԫ�أ�ʹ�ÿռ������ʸ߷���
//		list.showNodes(list.head);
//		Node start=list.deleteDuplicates_1(list.head);
//		list.showNodes(start);
		
		//�ҵ�������3��Ԫ��
//		list.showNodes(list.head);
//		Node specificNode=list.findSpecificIndexNode(list.head, 5);
//		System.out.println(specificNode.data);
		
		//�Ե������������
//		System.out.println("����֮ǰ");
//		list.showNodes(list.head);
//		Node begin=list.reverseTheList(list.head);
//		System.out.println("����֮��");
//		list.showNodes(begin);
		
		//��ͷ��β������������
//		System.out.println("�������");
//		list.showNodes(list.head);
//		System.out.println("�������");
//		list.reverseAndOutput_1(list.head);
		
		//Ѱ�ҵ�������е�
//		list.showNodes(list.head);
//		Node mid=list.findTheMid(list.head);
//		System.out.println(mid.data);
		
		//�ж����������Ƿ��л�		
//		boolean has=list.hasCircle(list.head);
//		System.out.println("has circle:"+has);
		
		//�ҵ��л������еĻ����
//		Node entrance=list.findTheEntrance(list.head);
//		System.out.println(entrance.data);
		
		//ɾ�������Ľڵ�
//		System.out.println("ɾ��֮ǰ������");
//		list.showNodes(list.head);
//		boolean res=list.deleteNode(n5);
//		System.out.println("�Ƿ����ɾ����"+res);
//		list.showNodes(list.head);
		
		//���������������Ƿ��н���
		System.out.println("������1");
		list.showNodes(list.head);
		System.out.println("������2");
		list1.showNodes(list1.head);		
//		boolean isIntersect=list1.isIntersect(list.head, list1.head);
//		System.out.println("�Ƿ��ཻ��"+isIntersect);
		//Ѱ�����������Ŀ�ʼ��
		int length1=list.getLength(list.head);
		int length2=list1.getLength(list1.head);
		Node firstNode=list.firstIntersectNode(list.head, length1, list1.head, length2);
		System.out.println("��һ�����㣺 "+firstNode.data);
		
	}
}
