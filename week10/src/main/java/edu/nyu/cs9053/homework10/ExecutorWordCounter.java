package edu.nyu.cs9053.homework10;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:33 PM
 */
public class ExecutorWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {

    private final ExecutorService executorServiceObject;

    public ExecutorWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        executorServiceObject = Executors.newFixedThreadPool(concurrencyFactor);
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        String[] lineByLineSplit = fileContents.split("\n");
        CountDownLatch latch = new CountDownLatch(lineByLineSplit.length);
        AtomicInteger counter=new AtomicInteger(0);
        int i=0;
        while(i<lineByLineSplit.length){
            i++;
            String[] wordsInEachLine = fileContents.split("[,\\s.;!?:]");
            executorServiceObject.execute(new Runnable() {
                @Override public void run() {
                    for(String words: wordsInEachLine){
                        if (words.equals(word)) {
                            counter.incrementAndGet();
                        }
                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        } finally {
            callback.counted(counter.get());
            stop();
        }
    }

    @Override public void stop() {
        executorServiceObject.shutdown();
    }

    private Object nullObjectCheck(Object obj) {
        if (obj == null){
            throw new IllegalArgumentException();
        }
        return obj;
    }
}


