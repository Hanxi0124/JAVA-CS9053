package edu.nyu.cs9053.homework10;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ExecutorFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {

    private final ExecutorService executorServiceObject;
    private CountDownLatch countDownLatch;
    ExecutorWordCounter executorWordCounter =new ExecutorWordCounter(getConcurrencyFactor());


    public ExecutorFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        this.executorServiceObject=Executors.newFixedThreadPool(getConcurrencyFactor());
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
        countDownLatch = new CountDownLatch(files.size());
        for (String key: files.keySet()) {
            executorServiceObject.execute(new Runnable() {
                @Override public void run() {
                    executorWordCounter.count(files.get(key), word, new ExecutorWordCounter.Callback() {
                        @Override public void counted(long count) {
                            callback.counted(key,count);

                        }
                    });
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        } finally {
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
