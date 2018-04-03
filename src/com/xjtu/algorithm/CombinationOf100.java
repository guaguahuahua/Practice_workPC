package com.xjtu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationOf100 {

	public static List<List<String>> combination(){
		List<List<String>> list=new ArrayList<List<String>>();
		
		int []nums= {1, 2, 5};
		for(int i=0; i<100; i++) {
			for(int j=0; j<50; j++) {
				for(int k=0; k<20; k++) {
					if(i*nums[0]+j*nums[1]+k*nums[2]==100) {
						List<String> temp=new ArrayList<String>();
						temp.add(i+":"+nums[0]+", "+j+":"+nums[1]+", "+k+":"+nums[2]);
						list.add(temp);
						break;
					}
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List res=combination();
		System.out.println(res);
		System.out.println(res.size());
	}

}
