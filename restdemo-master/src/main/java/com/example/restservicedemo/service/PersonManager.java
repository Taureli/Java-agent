package com.example.restservicedemo.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.restservicedemo.domain.RandomSleep;

@Path("/")
public class PersonManager {
	
	@GET
	@Path("/sleep")
	@Produces("text/html")
	public String outp() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		//Invoke sleep
		RandomSleep rs = new RandomSleep();
		rs.goToSleep();
		
		//Show time on page if agent was used
		try {
			return "I slept for " + rs.getClass().getDeclaredField("time").getLong(rs) + " milliseconds!";
		} catch (NoSuchFieldException e){
			return "I just slept! Did you notice?";
		}

	}

}
