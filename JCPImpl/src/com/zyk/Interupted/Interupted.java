package com.zyk.Interupted;

import java.util.concurrent.TimeUnit;

import com.zyk.threadState.SleepUtils;

public class Interupted {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//sleepThread 不停的尝试睡眠
		Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
		sleepThread.setDaemon(true);
		//busyThread 不停的运行
		Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
		busyThread.setDaemon(true);
		
		sleepThread.start();
		busyThread.start();
		
		//休眠5s，让sleepThread 和 busyThread充分运行
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();
		busyThread.interrupt();
		
		System.out.println("SleepThread interupted is " + sleepThread.isInterrupted());
		System.out.println("BusyThread interupted is " + busyThread.isInterrupted());
		
		//防止sleepThread和busyThread立刻退出
		SleepUtils.second(2);
	}
	
	static class SleepRunner implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			SleepUtils.second(10);
		}
	}
	
	static class BusyRunner implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				
			}
		}
	}

}
