package com.jakub.agent;

import java.lang.instrument.Instrumentation;

public class MyTimeAgent {

	public static void premain(String args, Instrumentation inst){
		System.out.println("SETTING UP AGENT");
		inst.addTransformer(new TimeAgentTransformer());
	}
	
}
