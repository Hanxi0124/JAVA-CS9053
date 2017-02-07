package edu.nyu.cs9053.homework11;

import java.io.*;

/**
 * User: blangel
 * Date: 11/23/14
 * Time: 4:31 PM
 */
public class BlockingChatter implements Chatter {

    private final PrintWriter out;
    private final BufferedReader in;
    private final BufferedReader stdIn;

    public BlockingChatter(InputStream chatServerInput, OutputStream chatServerOutput, InputStream userInput) {
        out=new PrintWriter(chatServerOutput,true);
        in=new BufferedReader(new InputStreamReader(chatServerInput));
        stdIn= new BufferedReader(new InputStreamReader(userInput));
    }

    @Override public void run() {
        String userInput;
        try {
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
