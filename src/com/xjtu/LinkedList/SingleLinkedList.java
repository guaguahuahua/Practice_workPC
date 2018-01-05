package com.xjtu.LinkedList;

import java.util.HashMap;
import java.util.Stack;

/**
 * 
 * 
 * 这块是单链表类，下面主要实现一些单链表常用的方法
 * @author Administrator
 */
public class SingleLinkedList {
	public Node head; //头结点
	private int length; //链表的长度
	
	/**
	 * 单链表的初始化过程，这是因为在链式队列中需要用到带头结点的链表，不得已修改了原来的数据结构
	 */
	public SingleLinkedList() {
		head=new Node(0);
		length=0;
	}
	
	/**
	 * 添加新的节点，使用尾插法
	 * @param node
	 */
	public void addNodeToEnd(Node node) {
		//如果头结点为空，那么新添加的节点就是头结点
		if(head==null) {
			head=node;
			head.next=null;
		}
		//如果头结点不为空那么遍历到尾部插入
		Node cursor=head;
		while(cursor.next!=null) {
			cursor=cursor.next;
		}
		//插入
		cursor.next=node;
//		node.next=null;
	}
	
	/**
	 * 新节点头插法实现
	 * @param node
	 */
	public void addNodeToHead(Node node) {
		//判断头结点
		if(head==null) {
			head=node;
			head.next=null;
		}
		//头结点不为空，直接插入下个位置
		node.next=head.next;
		head.next=node;
	}
	
	/**
	 * 返回单链表的长度
	 * @param head
	 * @return int
	 */
	public int getLength(Node head) {
		int count=0;
		if(head==null) {
			return 0;
		}
		//如果头结点不为空
		Node cursor=head;
		while(cursor!=null) {
			cursor=cursor.next;
			count++;
		}
		return count;
	}
	
	/**
	 * 删除第index位置的节点，删除成功返回true，否则返回false；
	 * @param index 删除位置的索引， 位置索引从1开始
	 * @return
	 */
	public boolean deleteNode(int index) {
		if(index<1 || index>length) {
			return false;			
		}
		//如果是头结点
		if(index==1) {
			Node cursor=head.next; //指向头结点下个位置
			head.next=null;
			head=cursor;
		}
		//不是头结点
		int nowIndex=2;
		Node preNode=head;
		Node curNode=head.next;
		while(curNode!=null) {
			//到达删除位置
			if(nowIndex==index) {
				//删除操作
				preNode.next=curNode.next;
				return true;
			}
			//没有到达删除位置
			preNode=curNode;
			curNode=curNode.next;
			nowIndex++;
		}
		//前面都没有跳出，那么说明删除失败
		return false;
	}
	
	/**
	 * 对单链表的所有节点进行输出展示
	 * @param head
	 */
	public void showNodes(Node head) {
		if(head==null) {
			System.out.println("链表为空！");
			return ;
		}
		//对所有节点进行输出
		while(head!=null) {
			System.out.print(head.data+"\t");
			head=head.next;
		}
		System.out.println();
	}
	
	/**
	 * 对单链表进行排序（插入排序法，如果忘记了思路最好还是逐个推导一下）
	 * @param head 传入单链表的头结点
	 * @return
	 */
	public Node orderList(Node head) {
		//如果头结点为空，或者是只有一个头结点
		if(head==null || head.next==null) {
			return head;
		}
		//两个变量一个指向当前头结点，另一个游标，指向后面的某节点
		Node curNode=head;
		Node nextNode=null;
		//double circle 
		while(curNode.next!=null) {
			nextNode=curNode.next;
			//依次的遍历后面的所有节点，判断他们和当前节点值的大小关系，将较小的值交换到左边
			//也就是在一趟排序中，当前节点的值会得到整趟遍历中的最小值
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
	 * 删除节点中重复的元素
	 * @param head
	 * return 去除重复元素之后的单链表
	 * 该算法的主要的是时间效率高，只需要O(n) 但是空间占用率比较高，需要占用O(n)个单位
	 */
	public Node deleteDuplicates(Node head) {
		//将空链表和节点数为1的情况处理
		if(head==null || head.next==null) {
			return head;
		}
		//使用hashtable实现判定重复的功能
//		Hashtable<Integer, Integer> table=new Hashtable<Integer, Integer>();
		HashMap<Integer, Integer> table=new HashMap<Integer, Integer>();
		Node cur=head;
		Node pre=null;
		//遍历所有的元素
		while(cur!=null) {
			//如果包含了当前的元素那么进行删除操作
			if(table.containsKey(cur.data)) {
				pre.next=cur.next;
			}else {
				table.put(cur.data, 1); //这里的1类似于占位符的存在
				pre=cur;
			}
			cur=cur.next;
		}
		return head;
	}
	
	/**
	 * 删除链表中的重复元素，上面的方式使用了hashmap或者是hashtable，空间效率低，不适合对空间利用率要求比较高的情形
	 * @param head
	 * @return
	 * 双层for循环，来寻找并剔除链表中重复的元素
	 */
	public Node deleteDuplicates_1(Node head) {
		//头结点为空或者仅仅有一个节点
		if(head==null || head.next==null) {
			return head;
		}
		Node cur=head;
		while(cur!=null) {
			Node pre=cur;
			Node inner=cur.next;
			
			while(inner!=null) {
				//如果存在重复，那么就删除当前节点
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
	 * 找到单链表中倒数第k个元素，并保证时间复杂度为O(n)
	 * @param head
	 * @param index 倒数第几个
	 * @return 最终的查找结果
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
		//防止索引
		if(index!=0) {
			System.out.println("index 参数越界！");
			return null;
		}
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;		
	}
	
	/**
	 * 对单链表进行逆置，原地实现 
	 * @param head 头结点
	 * @return
	 */
	public Node reverseTheList(Node head) {
		//处理一下头结点为空和单个节点情形
		if(head==null || head.next==null) {
			return head;
		}
		//有两个节点的情形
		if(head.next.next==null) {
			Node start=head.next;
			start.next=head;
			head.next=null;
			return start;
		}
		//多个节点的情形
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
	 * 从头到尾输出整个单链表
	 * 两种方式，一种是维护栈结构，另一种是递归的形式
	 * @param head
	 * @return
	 */
	public void reverseAndOutput(Node head) {
		//栈存放链表数据
//		LinkedList<Integer> stack=new LinkedList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		while(head!=null) {
//			stack.add(head.data);
			stack.push(head.data);
			head=head.next;
		}
		System.out.println("栈的高度:"+stack.size());
		//输出节点信息
		while(! stack.isEmpty()) {
//			System.out.print(stack.removeLast()+"\t");
			System.out.print(stack.pop()+"\t");
		}
		System.out.println();
	}
	
	/**
	 * 使用递归的形式实现从尾到头的输出单链表
	 * @param head
	 */
	public void reverseAndOutput_1(Node head) {
		if(head!=null) {
			reverseAndOutput_1(head.next);
			System.out.print(head.data+"\t");
		}
	}
	
	/**
	 * 寻找单链表的中点，使用快慢指针
	 * @param head
	 * @return
	 */
	public Node findTheMid(Node head) {
		//处理一下空链表，单节点，双节点的情形
		if(head==null || head.next==null || head.next.next==null) {
			return head;
		}
		//使用快慢指针的形式找到中点
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	/**
	 * 判定单链表中有没有环
	 * @param head
	 * @return
	 */
	public boolean hasCircle(Node head) {
		//链表为空
		if(head==null) {
			return false;
		}
		//如果是无环单节点或者是双节点
		if(head.next==null || head.next.next==null) {
			return false; 
		}
		//多个节点或者是有环
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
	 * 找到带环的单链表的环的开始节点
	 * @param head
	 * @return
	 */
	public Node findTheEntrance(Node head) {
		if(head==null) {
			return head;
		}
		//有环，那么先找到相遇点
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast) {
				break;
			}
		}		
		//寻找环入口点
		slow=head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	/**
	 * 给定一个节点删除该节点
	 * 尾节点无法删除，非尾节点可以删除
	 * @param node 
	 * @return
	 */
	public boolean deleteNode(Node node) {
		//空节点或者是尾节点
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
	 * 判断两个单链表是否有交点
	 * @param head1  单链表1头结点
	 * @param head2 单链表2头结点
	 * @return 
	 */
	public boolean isIntersect(Node head1, Node head2) {
		//只要有一个单链表为空，则认为没有交点
		if(head1==null || head2==null) {
			return false;
		}
		//遍历将指针移动到两个链表的尾节点，
		while(head1.next!=null || head2.next!=null) {
			
			if(head1.next!=null) {
				head1=head1.next;
			}
			if(head2.next!=null) {
				head2=head2.next;
			}
		}
		//判定最后的尾节点是否相同，相同说明是有交点的，不相同是没有交点
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
		//如果两个单链表没有交点
		if(! isIntersect(head1, head2)) {
			return null;
		}
		//如果有交点，那么找到第一个交点
		//移动头结点保证他们与交点的距离相同
		Node h1=null; //默认的h1是哪个长度较长的链表
		Node h2=null;
		//遍历
		int distance=Math.abs(length1-length2);
		if(length1>length2) {
			h1=head1;
			h2=head2;
		}else {
			h1=head2;
			h2=head1;
		}
		//移动较长的那个链表的头
		while(distance>0) {
			h1=h1.next;
			distance--;
		}
		//现在同时移动两个头结点，最终相遇点就是交集的开始点
		while(h1!=h2) {
			h1=h1.next;
			h2=h2.next;
		}
		return h1;
	}
	
	/**
	 * 主要是对上面几个成员方法进行测试
	 * 如果要进行调试，那么请保持只有一段功能是可以用的，不要去掉所有的注释
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
		//添加节点
		list.addNodeToEnd(n4);
		list.addNodeToEnd(n5);
		list.addNodeToEnd(n1);
		list.addNodeToEnd(n2);
		list.addNodeToEnd(n3);
		list.addNodeToEnd(n6);
		list.addNodeToEnd(n7);
		
		//创建第二个单链表，主要是为验证链表的交点方法做准备
		SingleLinkedList list1=new SingleLinkedList();
		list1.head=new Node(12);
		Node n8=new Node(23);
		Node n9=new Node(33);
		list1.addNodeToEnd(n8);
		list1.addNodeToEnd(n9);
//		list1.addNodeToEnd(n4);
		n9.next=n4;
		//删除节点
//		list.length=list.getLength(list.head); //这块给length赋值是因为在便利的过程中使用到了链表的长度这个参数
//		boolean res=list.deleteNode(3);		
//		System.out.println("删除结果： "+res);
//		list.showNodes(list.head);
		
		//对 链表进行插入排序，并返回排序之后的头结点的
//		Node start=list.orderList(list.head);
//		list.showNodes(start);
//		System.out.println("长度： "+list.getLength(list.head));

		//删除链表中重复的元素,使用时间利用率高方案
//		list.showNodes(list.head);
//		Node newStart=list.deleteDuplicates(list.head);
//		list.showNodes(newStart);
		
		//删除链表中重复元素，使用空间利用率高方案
//		list.showNodes(list.head);
//		Node start=list.deleteDuplicates_1(list.head);
//		list.showNodes(start);
		
		//找到倒数第3个元素
//		list.showNodes(list.head);
//		Node specificNode=list.findSpecificIndexNode(list.head, 5);
//		System.out.println(specificNode.data);
		
		//对单链表进行逆置
//		System.out.println("逆置之前");
//		list.showNodes(list.head);
//		Node begin=list.reverseTheList(list.head);
//		System.out.println("逆置之后");
//		list.showNodes(begin);
		
		//从头到尾输出链表的数据
//		System.out.println("正向输出");
//		list.showNodes(list.head);
//		System.out.println("反向输出");
//		list.reverseAndOutput_1(list.head);
		
		//寻找单链表的中点
//		list.showNodes(list.head);
//		Node mid=list.findTheMid(list.head);
//		System.out.println(mid.data);
		
		//判断是链表中是否有环		
//		boolean has=list.hasCircle(list.head);
//		System.out.println("has circle:"+has);
		
		//找到有环链表中的环入口
//		Node entrance=list.findTheEntrance(list.head);
//		System.out.println(entrance.data);
		
		//删除给定的节点
//		System.out.println("删除之前的链表");
//		list.showNodes(list.head);
//		boolean res=list.deleteNode(n5);
//		System.out.println("是否可以删除："+res);
//		list.showNodes(list.head);
		
		//测试两个单链表是否有交集
		System.out.println("单链表1");
		list.showNodes(list.head);
		System.out.println("单链表2");
		list1.showNodes(list1.head);		
//		boolean isIntersect=list1.isIntersect(list.head, list1.head);
//		System.out.println("是否相交："+isIntersect);
		//寻找两个交集的开始点
		int length1=list.getLength(list.head);
		int length2=list1.getLength(list1.head);
		Node firstNode=list.firstIntersectNode(list.head, length1, list1.head, length2);
		System.out.println("第一个交点： "+firstNode.data);
		
	}
}
