package com.example.restservicedemo.domain;

import java.util.Random;

public class RandomSleep {

	public void goToSleep(){
		Random rand = new Random();
		
		System.out.println("Going to sleep..");
		
		try{
			Thread.sleep(rand.nextInt(10000));
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Time to wake up!");
	}
	
}
