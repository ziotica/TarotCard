import java.net.*;
import java.io.*;
import java.util.*;

public class TarotCardClient {
    public static void main(String[] args) throws Exception
    {
        try {
            // create client socket at given address and port
            Socket s = new Socket(args[0], Integer.parseInt(args[1]));
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            ArrayList<String> reading = in.readObject();

            for(String card : reading){
                System.out.println(card);
            }
        }
        catch (Exception e) {
            return;
        }
    }
}

/* Sources used:
Socket Programming in Java 
(https://www.geeksforgeeks.org/java/socket-programming-in-java/)
How to Create a Socket at a Specific Port in Java?
(https://www.geeksforgeeks.org/java/how-to-create-a-socket-at-a-specific-port-in-java/) */

