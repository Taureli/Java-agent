package com.jakub.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import com.jakub.agent.RandomSleep;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.LoaderClassPath;


public class TimeAgentTransformer implements ClassFileTransformer {

	public byte[] transform(ClassLoader cl, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] bytes)
			throws IllegalClassFormatException {

		byte[] result = bytes;
		
		if(className.contains("RandomSleep")){
			
			try {
				//Converting class name
				String classNameConv = className.replace('/', '.');
				
				System.out.println(className);

				ClassPool cp = ClassPool.getDefault();
				
				cp.insertClassPath(new LoaderClassPath(cl));
				//cp.insertClassPath(new ClassClassPath(RandomSleep.class));
				//System.out.println("CLASS POOL " + cp.toString());
				CtClass ctClazz = cp.get(classNameConv);
				
				//Creating variable for time measurement
				CtField field = new CtField(CtClass.longType, "time", ctClazz);
				field.setModifiers(1);
				ctClazz.addField(field);
				
				//Measuring time of sleep
				CtMethod method = ctClazz.getDeclaredMethod("goToSleep");
				method.insertBefore("this.time = System.currentTimeMillis();");
				method.insertAfter("{ this.time = System.currentTimeMillis() - time;"
						+ "System.out.println(\"Slept for \" + time);}");
				
				result = ctClazz.toBytecode();
			} catch(Throwable e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

}
