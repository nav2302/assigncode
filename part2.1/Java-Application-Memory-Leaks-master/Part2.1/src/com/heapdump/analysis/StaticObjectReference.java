package com.heapdump.analysis;

import java.util.ArrayList;
import java.util.Random;

public class StaticObjectReference {


	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		StaticObjectReference stobjref = new StaticObjectReference();
		stobjref.addElementsToTheList(random);
		System.gc();
		Thread.sleep(100000); // to allow GC do its job
	}
	
	private void addElementsToTheList(Random random){
	    ArrayList<Double> list = new ArrayList<Double>(1000000);
	    for (int i = 0; i < 1000000; i++) {
			list.add(random.nextDouble());
		}
	}

}
