package edu.nyu.cs9053.homework9.jellybean;
import java.util.concurrent.*;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:14 PM
 */
public class ProducerConsumerFactory {
	
	private static final Semaphore binarySemaphore = new Semaphore(1);

    public static Producer createProducer() {
        return new ProducerImplementation(binarySemaphore);
    }

    public static Consumer createConsumer() {
        return new ConsumerImplementation(binarySemaphore);
    }

}
