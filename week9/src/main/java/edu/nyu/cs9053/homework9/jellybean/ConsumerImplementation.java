package edu.nyu.cs9053.homework9.jellybean;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ConsumerImplementation implements Consumer {

	private static final Flavor[] flavor= Flavor.values();
	private final Semaphore semaphoreObj;

	private static JellyBeanContainer argumentCheckerOfJBContainer(JellyBeanContainer jbContainer){
		if(jbContainer==null){
			throw new IllegalArgumentException("JellyBeanContainer Found Null");
		}
		return jbContainer;
	}
	
	public ConsumerImplementation(Semaphore semaphoreObj){
		this.semaphoreObj=semaphoreObj;
	}
	
	@Override
	public JellyBean consume(JellyBeanContainer from) {
		try{
			semaphoreObj.acquire();
			if(argumentCheckerOfJBContainer(from).isEmpty()){
				return null;
			}
		from.remove();
		return new JellyBean(flavor[new Random().nextInt(flavor.length)]);
	}
	catch(InterruptedException ie){
		Thread.currentThread().interrupt(); 
        throw new RuntimeException(ie);
	}
	finally {
        semaphoreObj.release();
    }
}
}

