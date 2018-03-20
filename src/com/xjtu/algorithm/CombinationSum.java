package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	/**
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum_1(int[] candidates, int target) {
		// 首先对所有的候选字进行排序
		Arrays.sort(candidates);
		// 存放最后的结果
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		int ii = candidates.length - 1;
		// 从前向后寻找，<=target的第一个元素
		while (ii>=0 && candidates[ii] > target) {
			ii--;
		}
		// 找到第一个位置
		int k = ii;
		while (k >=0) {
			List<Integer> inner = new ArrayList<Integer>();
			int tar = target;
			boolean flag = false;
			int i=k;
			while (tar != 0) {
				// 从初始位置向前寻找
//				i = k;
				while (i >= 0 && candidates[i] > tar) {
					i--;
				}
				if (i < 0) {
					flag = true;
					break;
				}
				// 找到了<=target的元素
				if (candidates[i] == tar) {
					inner.add(candidates[i]);
					break;

					// 如果candidates[i]<target,并且能整除
				} else if (tar % candidates[i] == 0) {
					int times = tar / candidates[i];
					for (int j = 0; j < times; j++) {
						inner.add(candidates[i]);
					}
					break;
					// 如果candidates[i]<target 并且不能整除
				} else if (tar % candidates[i] != 0) {
					// 将这个候选数添加到序列中，并且从target中删除该元素
					inner.add(candidates[i]);
					tar = tar - candidates[i];
					i--;
				}
			}
			if (!flag) {
				outer.add(inner);
			}
			k--;
		}
		return outer;
	}

	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		//存放最终的结果
		List<List<Integer>> list=new ArrayList <List<Integer>>();
		//递归调用
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}
	
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates,  int remain, int start) {
		if(remain<0) {
			return ;
		}else if(remain==0){
			//因为传递的是引用，所以这块得使用一个新的对象否则后面进行修改的时候，对导致list里面的内容发生变化
//			list.add(new ArrayList(tempList));
			boolean flag=false;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).equals(tempList)) {
					flag=true;
				}
			}
			if(!flag) {
				list.add(new ArrayList(tempList));
			}
			
		}else {
			for(int i=start; i<candidates.length; i++) {
				tempList.add(candidates[i]);
				backtrack(list, tempList, candidates, remain-candidates[i], i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] candidates = { 2, 3, 6, 7 };
//		int target = 7;
//		int []candidates= {2};
//		int []candidates= {1};
//		int target=1;
//		int[] candidates= {1,1,2,2};
//		int[] candidates= {1,2};
//		int target=4;
		int []candidates= {10, 1, 2, 7, 6, 1, 5};
		int target=8;
		List res = combinationSum(candidates, target);
		System.out.println(res);
	}

}
