package com.xjtu;

public class SortList {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */

    public static ListNode sortList_1(ListNode head) {
    	//����Ϊ�ջ�����ֻ��һ��ͷ���
    	if(head==null || head.next==null) {
    		return head;
    	}
    	ListNode curNode=head;
    	ListNode nextNode=null;
    	//�������еĽڵ�
    	while(curNode.next!=null) {
    		nextNode=curNode.next;
    		while(nextNode!=null) {
    			if(curNode.val>nextNode.val) {
    				int temp=curNode.val;
    				curNode.val=nextNode.val;
    				nextNode.val=temp;
    			}
    			nextNode=nextNode.next;
    		}
    		curNode=curNode.next;
    	}
        return head;
    }

    public static void show(ListNode head) {
    	while(head!=null) {
    		System.out.print(head.val+"\t");
    		head=head.next;
    	}
    	System.out.println();
    }
    
    /**
     * ʹ�ÿ�������ķ�ʽ�Ե������������
     * @param head 	
     * @parem end
     * @return
     */
    public static ListNode getMid(ListNode head, ListNode end) {
    	ListNode start=head;
    	int key=head.val;
    	ListNode p=head;
    	ListNode q=p.next;
    	while(q!=end) {
    		if(q.val<key) {
    			p=p.next;
    			int temp=p.val;
    			p.val=q.val;
    			q.val=temp;
    			q=q.next;
    		}else {
    			q=q.next;
    		}
    	}
    	int temp=p.val;
    	p.val=start.val;
    	start.val=temp; 
    	return p;
    }
    
    public static ListNode sortList(ListNode head) {
    	//�ж�ͷ���
    	if(head==null || head.next==null) {
    		return head;
    	}
    	ListNode h=quickSort(head, null);

    	return h;
    }
    public static ListNode quickSort(ListNode head, ListNode end) {
    	//�ݹ����
    	if(head==end) {
    		return head;
    	}
    	ListNode mid=getMid(head, end);
    	//���м�Ľڵ�Ϊ����еݹ�
    	quickSort(head, mid);
    	quickSort(mid.next, end);
    	return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListNode head=null;
		ListNode head=new ListNode(2);
		ListNode n1=new ListNode(5);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(7);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		//����֮ǰ
		System.out.println("����֮ǰ");
		show(head);
		//����֮��
		System.out.println("����֮��");
		ListNode start=sortList(head);
		show(start);
	}

}
