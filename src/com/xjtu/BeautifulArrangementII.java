package com.xjtu;

public class BeautifulArrangementII {
	
	/**
	 * hash表的方式来完成，从大到小的进行排序
	 * n个数，最多可以生成n-1个不相同整数
	 * @param n
	 * @param k
	 * @return
	 */
/*    public static int[] constructArray(int n, int k) {
        
    	int []table=new int[n+1]; //生成一个hash表，用来标记使用和未使用的元素
    	int []res=new int[n];
    	if(k>=n) {
    		return res;
    	}
    	int i=0;
    	int factor=-1,end=k;
    	res[0]=n;
    	table[n]=1;
    	for(i=1;i<=end;i++) { //首先生成k个不同的整数，并标记使用过的整数///i在这块的变为1导致下面索引过界，修改方式，将1转为0，并修改整个循环体
    		res[i]=res[i-1]+factor*k;
    		factor*=-1;
    		table[res[i]]=1;
    		k-=1;
    	}
    	if(end!=n-1) { //如果还有剩余的整数，将他们添到返回值的最后面
    		for(int j=table.length-1;j>0;j--) { //将剩余的数字填入到数组中去
        		if(table[j]!=1) {
        			res[i++]=j;
        		}
        	}
    	}
    	
    	return res;
    }*/
    /**
     * 10	1	9	2	8	3	7	4	6	5
     * 从结果中可以看出，还有更简单的方式实现，主要是得到前k个不同的数，然后后面的数按照自然序列添加即可
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
