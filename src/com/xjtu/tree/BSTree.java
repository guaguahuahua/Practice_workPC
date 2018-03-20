package com.xjtu.tree;

public class BSTree {

	public static void traverseBSTree(BSTreeNode root) {
		if(root!=null) {
			traverseBSTree(root.left);
			System.out.print(root.data+"\t");
			traverseBSTree(root.right);
		}
	}

	public static void show(BSTreeNode root) {
		
		while(root!=null) {
			System.out.print(root.data+"\t");
			root=root.right;
		}
	}
	
/*	public static void convertNode(BSTreeNode root, BSTreeNode lastNode) {
		if(root==null) {
			return ;
		}
		if(root.left!=null) {
			convertNode(root.left, lastNode);
		}
		root.left=lastNode;
		if(lastNode!=null) {
			lastNode.right=root;
		}
		lastNode=root;
		if(root.right!=null) {
			convertNode(root.right, lastNode);
		}		
	}*/
	
	public static BSTreeNode BSTreeToList(BSTreeNode root) {
		
		if(root==null) {
			return null;
		}
		BSTreeNode head=findLeftMostNode(root);
		BSTreeNode lastNode=null;
		convertNode(root, lastNode);
		return head;
	}
	
	public static BSTreeNode findLeftMostNode(BSTreeNode root) {
		if(root==null) {
			return null;
		}		
		BSTreeNode r=root;
		while(r.left!=null) {
			r=r.left;
		}
		return r;
	}
	
	static BSTreeNode convertNode(BSTreeNode pNode, BSTreeNode pLastNodeInList)
    {
        if(pNode == null)
            return null;
        BSTreeNode pCurrent = pNode;

        //�ݹ鴦��������
        if(pCurrent.left != null)
            pLastNodeInList = convertNode(pNode.left, pLastNodeInList);

        //����ǰ�ڵ�
        //����ǰ�ڵ����ָ��ָ���Ѿ�ת���õ���������һ��λ��
        pCurrent.left = pLastNodeInList;
        //���Ѿ�ת���õ���������һ���ڵ����ָ��ָ��ǰ�ڵ�
        if(pLastNodeInList != null)
            pLastNodeInList.right = pCurrent;
        //�����Ѿ�ת���õ���������һ���ڵ�
        pLastNodeInList = pCurrent;

        //�ݹ鴦��������
        if(pCurrent.right != null)
            pLastNodeInList = convertNode(pNode.right, pLastNodeInList);
        return pLastNodeInList;
    }

    static BSTreeNode convert(BSTreeNode pRoot)
    {
        if(pRoot == null)
            return null;

        //�������������
        BSTreeNode pLastNodeInList = null;
        pLastNodeInList = convertNode(pRoot, pLastNodeInList);

        //�ҵ�ת����������ͷ�ڵ�
        BSTreeNode pHead = pLastNodeInList ;
        while(pLastNodeInList != null && pLastNodeInList.left != null)
            pHead = pHead.left;

        //����ͷ�ڵ�
        return pHead;
    }
    
    public static BSTreeNode treeToLinkedList(BSTreeNode root) {
    	BSTreeNode head=null;
    	BSTreeNode tail=null;
//    	helper(head, tail, root);
    	return head;
    }
    
    public static void helper(BSTreeNode root, BSTreeNode pre) {
 
    	if(root.left==null) {
    		return ;
    	}else if(root.left!=null) {
    		helper(root.left, pre);
    	}
    	//�ҵ���ͷ���
    	BSTreeNode last=null;
    	BSTreeNode head=root.left;
    	head.right=root;
    	head.left=last;
    	//Ѱ��β�ڵ�
    	root=pre;
    	helper(root.right, pre);
    	
//    	System.out.println("pre.data:"+pre.data);
    	System.out.println("root.data:"+root.data);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BSTreeNode n1=new BSTreeNode(4);
		BSTreeNode n2=new BSTreeNode(8);
		BSTreeNode n3=new BSTreeNode(6, n1, n2);
		BSTreeNode n4=new BSTreeNode(12);
		BSTreeNode n5=new BSTreeNode(16);
		BSTreeNode n6=new BSTreeNode(14, n4, n5);
		BSTreeNode root=new BSTreeNode(10,n3, n6);
//		traverseBSTree(root);
//		BSTreeNode head=treeToLinkedList(root);
//		BSTreeNode head=BSTreeToList(root);
//		BSTreeNode head=convert(root);
		helper(root, root);
//		show(head);
	}

}
