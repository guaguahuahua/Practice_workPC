package com.xjtu.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThread_2 implements Callable<String>{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService threadPool= Executors.newSingleThreadExecutor();
		//Æô¶¯Ïß³Ì
		Future<String> future=threadPool.submit(new MultiThread_2());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "hi dante!";
	}

}
