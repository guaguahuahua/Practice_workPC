package com.xjtu.algorithm;

public class DjkstraProblem {

	//如果不存在路径，那么两个顶点之间的距离为最大值
	public static final int inf=Integer.MAX_VALUE;
	
	
	/**
	 * 给定边集合求从第一个顶点到其他顶点的最短距离
	 * @param e
	 */
	public static void dijkstraProblem(int [][]e) {
		
		//存放第一个节点到其他节点的距离值
		int []dis=e[0];
		//判断某个顶点是否被访问过
		boolean []book=new boolean[dis.length];
		//第一个顶点已经被访问
		book[0]=true;
			
		int index=-1;
		for(int i=0; i<dis.length; i++) {
			
			int min=inf;	
			//寻找第一个距离原点最近的节点
			for(int j=0; j<dis.length; j++) {
				//如果两个顶点之间存在边，同时没有被访问过，保存最小值，及其索引位置
				if(dis[j]!=inf && !book[j]) {
					if(min>dis[j]) {
						min=dis[j];
						index=j	;
					}
				}
			}
			book[index]=true;
			//从该顶点出发，更新dis
			for(int k=0; k<e[index].length; k++) {
				//判断该节点没有被添加到结果集
				if(e[index][k]<inf) {
					if(dis[k]>dis[index]+e[index][k]) {
						dis[k]=dis[index]+e[index][k];
					}
				}
			}
			
		}
		
		//输出最后的距离
		for(int i=0; i<dis.length; i++) {
			System.out.print(dis[i]+"\t");
		}
		
	}
	
	/**
	 * 根据个人对贪心算法的理解进行实现
	 * 其实整个过程是在原节点的基础之上每次寻找一个距离当前节点最近的节点，之后
	 * 以该节点为为新的节点，继续乡下寻找，每次都是一个贪心的过程，找距离当前节点最小的下个节点
	 * @param e
	 */
	public static void dijkstraProblem_1(int [][]e) {
		
		//求第几个顶点，就用该顶点进行初始化
		int[] dis=e[0];
		//用于标记一个顶点是否被访问过
		boolean []visited=new boolean[dis.length];
		//我们标记第一个顶点未访问过的
		visited[0]=true;
		//遍历其余的顶点，直到它们都被访问过为止
		for(int i=0; i<dis.length-1; i++) {
			
			int min=inf;
			int index=-1;
			//选择dis中未被访问过且源点到该顶点距离最短
			for(int j=0; j<dis.length; j++) {
				if(!visited[j] && min>dis[j]) {
					min=dis[j];
					index=j;
				}
			}
			//将找到点标记为已访问过
			visited[index]=true;
			
			//更新原点到其他点的距离值
			for(int k=0; k<e[index].length; k++) {
				if(!visited[k] && e[index][k]<inf) {
					if(dis[k]>dis[index]+e[index][k]) {
						dis[k]=dis[index]+e[index][k];
					}	
				}
				
			}			
		}
		
		//输出最后的dis值
		for(int i=0; i<dis.length; i++) {
			System.out.print(dis[i]+"\t");
		}
		
 	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//边集初始化
		int [][]e= {
				{ 0, 1, 12, inf, inf, inf }, 
				{ inf, 0, 9, 3, inf, inf }, 
				{ inf, inf, 0, inf, 5, inf },
				{ inf, inf, 4, 0, 13, 15 }, 
				{ inf, inf, inf, inf, 0, 4 }, 
				{ inf, inf, inf, inf, inf, 0 }
		};
		dijkstraProblem_1(e);
	}

}
