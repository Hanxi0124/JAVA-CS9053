package edu.nyu.cs9053.homework10;

import java.util.Map;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ThreadedFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {

    public ThreadedFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
        Runnable myRunnable = new Runnable(){
            public void run(){
                for (Map.Entry<String, String> entry : files.entrySet()) {
                    synchronized(this){
                        String fileContents = entry.getValue();
                        WordCounter threadedWordCounter =new ThreadedWordCounter(getConcurrencyFactor());
                        threadedWordCounter.count(fileContents, word, new ThreadedWordCounter.Callback() {
                            @Override
                            public void counted(long count) {
                                callback.counted(entry.getKey(),count);
                            }
                        });
                    }
                }
            }
        };
        for (int x=0; x<getConcurrencyFactor(); x++)
        {
            Thread temp= new Thread(myRunnable, "Thread #" + x);
            temp.start();
        }

    }

    @Override public void stop() {
        Thread.currentThread().interrupt();
    }
    private Object nullObjectCheck(Object obj) {
        if (obj == null){
            throw new IllegalArgumentException();
        }
        return obj;
    }
}
