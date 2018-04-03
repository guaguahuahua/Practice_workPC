package com.xjtu.algorithm;

public class DjkstraProblem {

	//���������·������ô��������֮��ľ���Ϊ���ֵ
	public static final int inf=Integer.MAX_VALUE;
	
	
	/**
	 * �����߼�����ӵ�һ�����㵽�����������̾���
	 * @param e
	 */
	public static void dijkstraProblem(int [][]e) {
		
		//��ŵ�һ���ڵ㵽�����ڵ�ľ���ֵ
		int []dis=e[0];
		//�ж�ĳ�������Ƿ񱻷��ʹ�
		boolean []book=new boolean[dis.length];
		//��һ�������Ѿ�������
		book[0]=true;
			
		int index=-1;
		for(int i=0; i<dis.length; i++) {
			
			int min=inf;	
			//Ѱ�ҵ�һ������ԭ������Ľڵ�
			for(int j=0; j<dis.length; j++) {
				//�����������֮����ڱߣ�ͬʱû�б����ʹ���������Сֵ����������λ��
				if(dis[j]!=inf && !book[j]) {
					if(min>dis[j]) {
						min=dis[j];
						index=j	;
					}
				}
			}
			book[index]=true;
			//�Ӹö������������dis
			for(int k=0; k<e[index].length; k++) {
				//�жϸýڵ�û�б���ӵ������
				if(e[index][k]<inf) {
					if(dis[k]>dis[index]+e[index][k]) {
						dis[k]=dis[index]+e[index][k];
					}
				}
			}
			
		}
		
		//������ľ���
		for(int i=0; i<dis.length; i++) {
			System.out.print(dis[i]+"\t");
		}
		
	}
	
	/**
	 * ���ݸ��˶�̰���㷨��������ʵ��
	 * ��ʵ������������ԭ�ڵ�Ļ���֮��ÿ��Ѱ��һ�����뵱ǰ�ڵ�����Ľڵ㣬֮��
	 * �Ըýڵ�ΪΪ�µĽڵ㣬��������Ѱ�ң�ÿ�ζ���һ��̰�ĵĹ��̣��Ҿ��뵱ǰ�ڵ���С���¸��ڵ�
	 * @param e
	 */
	public static void dijkstraProblem_1(int [][]e) {
		
		//��ڼ������㣬���øö�����г�ʼ��
		int[] dis=e[0];
		//���ڱ��һ�������Ƿ񱻷��ʹ�
		boolean []visited=new boolean[dis.length];
		//���Ǳ�ǵ�һ������δ���ʹ���
		visited[0]=true;
		//��������Ķ��㣬ֱ�����Ƕ������ʹ�Ϊֹ
		for(int i=0; i<dis.length-1; i++) {
			
			int min=inf;
			int index=-1;
			//ѡ��dis��δ�����ʹ���Դ�㵽�ö���������
			for(int j=0; j<dis.length; j++) {
				if(!visited[j] && min>dis[j]) {
					min=dis[j];
					index=j;
				}
			}
			//���ҵ�����Ϊ�ѷ��ʹ�
			visited[index]=true;
			
			//����ԭ�㵽������ľ���ֵ
			for(int k=0; k<e[index].length; k++) {
				if(!visited[k] && e[index][k]<inf) {
					if(dis[k]>dis[index]+e[index][k]) {
						dis[k]=dis[index]+e[index][k];
					}	
				}
				
			}			
		}
		
		//�������disֵ
		for(int i=0; i<dis.length; i++) {
			System.out.print(dis[i]+"\t");
		}
		
 	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�߼���ʼ��
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
