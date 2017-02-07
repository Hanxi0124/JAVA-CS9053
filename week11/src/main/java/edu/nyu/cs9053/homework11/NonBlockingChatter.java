package edu.nyu.cs9053.homework11;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
/**
 * User: blangel
 * Date: 11/23/14
 * Time: 4:32 PM
 */
public class NonBlockingChatter implements Chatter {

    private final Pipe.SourceChannel userInput;
    private final SocketChannel chatServerChannel;
    private final ByteBuffer writeBuffer;
    private final ByteBuffer readBuffer;

    public NonBlockingChatter(SocketChannel chatServerChannel,
                              Pipe.SourceChannel userInput) throws IOException {
        this.userInput = userInput;
        this.chatServerChannel = chatServerChannel;
        readBuffer = ByteBuffer.allocate(1024);
        writeBuffer = ByteBuffer.allocate(1024);
    }

    @Override public void run() {
        try {
            boolean endChat=false;
            while (!endChat){
                writeBuffer.clear();
                readBuffer.clear();
                while (userInput.read(writeBuffer) != 0) {
                }
                if (new String(writeBuffer.array(),"UTF-8").trim().compareTo("..q..")==0) {
                    System.out.println("Read QUIT!!!");
                    endChat=true;
                }
                writeBuffer.flip();
                while(writeBuffer.hasRemaining()) {
                    chatServerChannel.write(writeBuffer);
                }
                while (chatServerChannel.read(readBuffer) != 0) {
                }
                while (readBuffer.hasRemaining() && readBuffer.position()>0) {
                    readBuffer.flip();
                    String reply = new String(readBuffer.array(),"UTF-8");
                    System.out.printf("%s", reply);
                    if (reply.trim().compareTo("java")==0){
                        System.out.println("Random Line From MobyDick: ");
                    }
                }
            }
        }catch(IOException ie){
            System.out.println(ie.getMessage());
        }
    }
}
