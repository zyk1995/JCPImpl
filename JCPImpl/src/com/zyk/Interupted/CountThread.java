package com.zyk.Interupted;

import java.util.concurrent.TimeUnit;

public class CountThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		//睡眠１s，main线程对CountThread进行中断，使CountThread能够感知on为false而结束
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		
		///睡眠１s，main线程对Runner two 进行取消，使CountThread能够感知on为false而结束
		TimeUnit.SECONDS.sleep(1);
		two.cancle();
	}
	
	private static class Runner implements Runnable {
		private long i;
		private volatile boolean on = true;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(on && !Thread.currentThread().isInterrupted()) {
				i++;
			}
			
			System.out.println("Count i =" + i);
		}
		
		public void cancle() {
			on = false;
		}
	}
}
