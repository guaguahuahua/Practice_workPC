package com.xjtu;

public class BeautifulArrangementII {
	
	/**
	 * hash��ķ�ʽ����ɣ��Ӵ�С�Ľ�������
	 * n����������������n-1������ͬ����
	 * @param n
	 * @param k
	 * @return
	 */
/*    public static int[] constructArray(int n, int k) {
        
    	int []table=new int[n+1]; //����һ��hash���������ʹ�ú�δʹ�õ�Ԫ��
    	int []res=new int[n];
    	if(k>=n) {
    		return res;
    	}
    	int i=0;
    	int factor=-1,end=k;
    	res[0]=n;
    	table[n]=1;
    	for(i=1;i<=end;i++) { //��������k����ͬ�������������ʹ�ù�������///i�����ı�Ϊ1���������������磬�޸ķ�ʽ����1תΪ0�����޸�����ѭ����
    		res[i]=res[i-1]+factor*k;
    		factor*=-1;
    		table[res[i]]=1;
    		k-=1;
    	}
    	if(end!=n-1) { //�������ʣ���������������������ֵ�������
    		for(int j=table.length-1;j>0;j--) { //��ʣ����������뵽������ȥ
        		if(table[j]!=1) {
        			res[i++]=j;
        		}
        	}
    	}
    	
    	return res;
    }*/
    /**
     * 10	1	9	2	8	3	7	4	6	5
     * �ӽ���п��Կ��������и��򵥵ķ�ʽʵ�֣���Ҫ�ǵõ�ǰk����ͬ������Ȼ��������������Ȼ������Ӽ���
     * @param args
     */
	public static int[] constructArray(int n,int k) {
		
		int []res=new int[n];
		if(k>=n) {
			return res;
		}
		int start=1,end=n,times=0;
		for(int i=0;i<n;i++) {
			if(i<k) {
				res[i]=i % 2==0 ? end-- : start++;
			}else {
				res[i]=start++;
			}
			
		}
		return res;
	}
	public static void main(String []args) {
		int n=10;
		int k=5;
		int []result=constructArray(n,k);
		for(int K:result) {
			System.out.print(K+"\t");
		}
	}

}
