package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
	
	
	private static ArrayList<String> permu=new ArrayList<String>();
	/**
	 * ԭʼ˼·��ֱ���������ַ������У�Ȼ����s�н�������������TLE
	 * @param s
	 * @param words
	 * @return
	 */
    public static List<Integer> findSubstring_1(String s, String[] words) {
    	//���λ��
    	List<Integer> res=new ArrayList<Integer>();
    	//���ȸ���words�����е�Ԫ�ػ���������е�ȫ����
    	permutation(words, 0, words.length-1);
    	for(int i=0; i<permu.size(); i++) {
    		//���һ���ַ���������
    		String temp=permu.get(i);
    		int index=0;
    		//���ַ���s��Ѱ���Ƿ�����ͬ��
    		int tIndex=0;
    		for(int j=0; j<=s.length()-temp.length(); j++) {
    			int k, jj=j;
    			for(k=0; k<temp.length(); k++) {
    				if(s.charAt(jj)!=temp.charAt(k)) {
    					break;
    				}
    				jj++;
    			}
    			if(k==temp.length() && !res.contains(j)) {
    				res.add(j);
    			}
    		}    		    		
    	}
        return res;
    }
    
	public static void permutation(String []words, int start, int end) {
		
		if(start==end) {
			StringBuilder sb=new StringBuilder();
			//���������еĽ���������
			for(int i=0; i<words.length; i++) {
				sb.append(words[i]);
			}
			//��һ�������������������
			permu.add(sb.toString());
		}else {
			for(int i=start; i<=end; i++) {
				swap(words, i, start);
				permutation(words, start+1, end);
				swap(words, start, i);
			}
		}	
	}
	
    public static void swap(String []words, int i, int j) {
    	String temp=words[i];
    	words[i]=words[j];
    	words[j]=temp;
    }
    
    
    /**
     * ˼·������leetcode�����Ĵ���
     * ʹ������Map��ʵ��
     * �ո�֪������Ŀ�����и����ص��������������е��ַ������Ⱥ͵�һ��������һ����
     * @param s	String	
     * @param words	String []
     * @return	List<Integer>
     */
    public static List<Integer> findSubstring(String s, String[] words) {
    	
    	//����ӳ��
    	Map <String, Integer>map=new HashMap<String, Integer>();
    	for(String str : words) {
    		map.put(str, map.getOrDefault(str,0)+1);
    	}
    	//���ƥ��Ŀ�ʼ����
    	List<Integer> res=new ArrayList<Integer>();
    	//��һ�����ʵĳ���
    	int len=words[0].length();
    	
    	//��s�н��в�ѯ
    	for(int i=0; i<=s.length()-words.length*len; i++) {
    		//��ʼ��һ���ڲ���map
    		Map <String, Integer>inner=new HashMap<String, Integer>(map);
    		//������¼�Ƿ���������е�����
			int count=words.length;
			int index=i;
    		//���εĴ�s��ȡ�����ʺ�������Ԫ�ؽ��бȽ�,ÿ������ƶ�1������
    		for( ;count>0; ) {
    			//���һ���ַ���
    			String temp=s.substring(index, index+len);
    			//���ƥ��
    			if(inner.containsKey(temp) && inner.get(temp)>0) {
    				inner.put(temp, inner.get(temp)-1);
    				count--;
    				index+=len;
    			}else {
    				break;
    			}    			
    		}
    		if(count==0) {
    			res.add(i);
    		}    		
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s="barfoothefoobarman";
//		String s="barfoofoobarthefoobarman";
//		String []words= {"bar", "foo", "the"};
		String s="wordgoodgoodgoodbestword";
		String []words= {"word", "good", "best", "good"};
				
		List<Integer> res=findSubstring(s, words);
		System.out.println(res);
//		for(int K:res) {
//			System.out.println(K);
//		}

		
	}

}
