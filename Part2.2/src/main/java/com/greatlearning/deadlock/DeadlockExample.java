package com.greatlearning.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
	public static void main(String[] args) {

		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();

		RunnableSync1 runnable1 = new RunnableSync1(lock1, lock2);
		RunnableSync2 runnable2 = new RunnableSync2(lock1, lock2);

		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);

		thread1.start();
		thread2.start();

	}
}
