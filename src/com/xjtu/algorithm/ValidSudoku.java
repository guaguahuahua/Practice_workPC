package com.xjtu.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

	/**
	 * �ж������ĸ����Ƿ��������
	 * ʹ��˫Map���
	 * @param board	char[][]
	 * @return	boolean 
	 */
    public static boolean isValidSudoku(char[][] board) {
    	//������ʼ��map
    	Map <Character, Integer>map=new HashMap<Character, Integer>();
    	for(char i='1'; i<='9'; i++) {
    		map.put(i, 1);
    	}
    	//���м���������
    	for(int row=0; row<board.length; row++) {
    		//ÿһ�ж���ʼ��һ��map�������ÿһ�������Ƿ�����
    		Map <Character, Integer>inner=new HashMap<Character, Integer>(map);
    		for(int col=0; col<board[0].length; col++) {
    			char temp=board[row][col];
    			if(temp!='.') {
    				if(inner.get(temp)>0) {
    					inner.put(temp, inner.get(temp)-1);
    				}else {
    					return false;
    				}
    				
    			}
    		}
    	}
    	//���м��
    	for(int col=0; col<board.length; col++) {
    		Map<Character, Integer> inner=new HashMap<Character, Integer>(map);
    		for(int row=0; row<board[0].length; row++) {
    			char temp=board[row][col];
    			if(temp!='.') {
    				if(inner.get(temp)>0) {
    					inner.put(temp, inner.get(temp)-1);
    				}else {
    					return false;
    				}
    			}
    		}
    	}
    	
    	//����ÿ��cell
    	for(int row=0; row<3; row++) {
    		for(int col=0; col<3; col++) {
    			Map <Character, Integer>inner=new HashMap<Character, Integer>(map);
    			for(int r=3*row; r<3*row+3; r++) {
    				for(int c=3*col; c<3*col+3; c++) {
    					char temp=board[r][c];
    					if(temp!='.') {
    						if(inner.get(temp)>0) {
    							inner.put(temp, inner.get(temp)-1);
    						}else {
    							return false;
    						}
    					}
    				}
    			}
    		}
    	}   	
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][]c= {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'},				
		};
		boolean res=isValidSudoku(c);
		System.out.println(res);
	}

}
