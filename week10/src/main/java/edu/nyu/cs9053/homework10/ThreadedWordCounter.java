package edu.nyu.cs9053.homework10;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:16 PM
 */
public class ThreadedWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {

    public ThreadedWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        long worcCounter=0;
        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher(fileContents);
        //boolean b = m.matches();
        while(m.find()){
            worcCounter++;
        }
        callback.counted(worcCounter);
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
