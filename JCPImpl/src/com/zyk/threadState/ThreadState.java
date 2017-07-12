package com.zyk.threadState;

public class ThreadState {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new TimeWaiting(),"TimeWaitingThread").start();
		new Thread(new Waiting(),"WaitingThread").start();
		//ʹ������Blocked�̣߳�һ����ȡ���ɹ�����һ��������
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
	}
	
	//���̲߳��ϵؽ���˯��
	static class TimeWaiting implements Runnable {
		@Override
		public void run(){
			while(true){
				SleepUtils.second(1000);
			}
		}
	}
	
	//���߳���Waiting.class ʵ���ϵȴ�
	static class Waiting implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}	
	}
	//���߳���Blocked.classʵ���ϼ����󣬲����ͷŸ���
	static class Blocked implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Blocked.class) {
				while(true){
					SleepUtils.second(100);
				}
			}
		}
	}
}
