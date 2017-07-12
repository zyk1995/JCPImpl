package com.zyk.daemon;

import com.zyk.threadState.SleepUtils;

public class Daemon {
	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
		thread.setDaemon(true);
		thread.start();
		new Thread().start();
	}
	
	static class DaemonRunner implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				SleepUtils.second(10);
			} catch (Exception e) {
				// TODO: handle exception
			} finally{
				System.out.println("DaemonThread finally run.");
			}
			
		}
	}
	 
}	
