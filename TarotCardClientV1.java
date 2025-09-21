//opens TCP socket and connects to server
// using arbitrary ports and our own protocol
// server name/IP and port arguments given by user as cmd line args

// Open connection to server on the port and IP supplies

/* When client gets a response from the server:
- make it pretty
- print it out
- close the socket */

// optionally, you can also include the card images, as well as the text

import java.io.*;
import java.net.*;

public class TarotCardClient {
  
    // Initialize socket and input/output streams
    private Socket s = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // Constructor to put IP address and port
    public Client(String addr, int port)
    {
        // Establish a connection
        try {
            s = new Socket(addr, port);
            System.out.println("Connected"); // remove after testing

            input = new ObjectInputStream(socket.getInputStream());

            String reading = (String) input.readObject();

            for (String card : reading) {
                System.out.println(card);
            }
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }
    }

    public static void main(String[] args) {
        Client c = new TarotCardClient(args[0], args[1]); // change to cmd line input
    }
}




/* sources used:

Socket Programming in Java (https://www.geeksforgeeks.org/java/socket-programming-in-java/) */

