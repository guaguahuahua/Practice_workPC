package com.xjtu.algorithm;

/**
 * 判断输入数组是否为二叉搜索树的后序遍历序列
 * @author Administrator
 *
 */
public class BinSearchTree {

	/**
	 * 首先是因为序列是后序遍历的结果，我们可以对后序遍历的结果和二叉搜索树的特点结合起来
	 * 因为二叉搜索树的左子树都是小于右子树的，所以一旦某个元素大于根节点，那么该元素向后就是
	 * 二叉搜索树的右子树
	 * @param nums
	 * @return
	 */
	public static boolean binSearchTree(int []nums) {
		
		boolean res=judge(nums, 0, nums.length-1);
		return res;
	}
	
	/**
	 * 判定是否所有的左子树都小于根节点的值，右子树大于根节点的值
	 * @param nums
	 * @param startIndex
	 * @param rootIndex
	 */
	public static boolean judge(int []nums, int startIndex, int rootIndex) {
		
		boolean res1=false, res2=false;
		//递归继续的条件
		if(startIndex<rootIndex) {
			int left=startIndex;
			int right=-1;
			boolean flag=false;
			//找到右子树的开始索引
			for(int i=startIndex; i<rootIndex; i++) {
				if(nums[i]>nums[rootIndex]) {
					right=i;
					break;
				}
			}
			//判断右子树是否为全部大于根节点
			for(int i=right; i<rootIndex; i++) {
				if(nums[i]<nums[rootIndex]) {
					flag=true;
					break;
				}
			}
			//如果右子树不满足二叉搜索树的特点
			if(flag) {
				return false;
			//如果满足二叉搜索树的特点，那么递归的判断	
			}else {
				res1=judge(nums, startIndex, right-1);
				res2=judge(nums, right, rootIndex-1);
				return res1 && res2;
			}
		//递归的出口	
		//既然能搜索到边界上，说明前面的所有情况已经被遍历， 已经是满足了条件
		}else {
			return true;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums= {9, 40, 12, 394, 540, 410, 381};
		int []nums= {9, 40, 12, 394, 540, 310, 381};
		boolean res=binSearchTree(nums);
		System.out.println(res);
	}

}
