import java.net.*;
import java.io.*;
import java.util.*;

// Class
public class TarotCardServer {

    //initialise sockets
    private Socket s = null;
    private ServerSocket ss = null;

    //initialise output stream
    private ObjectOutputStream out = null;

    //card deck
    private String[] cards = {"The Fool", "The Magician", "The High Priestess", "The Empress", "The Emperor", "The Hierophant", 
    "The Lovers", "The Chariot", "Strength", "The Hermit", "Wheel of Fortune", "Justice", "The Hanged Man", "Death", 
    "Temperance", "The Devil", "The Tower", "The Star", "The Moon", "The Sun", "Judgement", "The World"};

    // Main driver method
    public static void main(String[] args) throws Exception
    {

        // Try block to check for exceptions
        try {
            // Creating an object of ServerSocket class
            // with the custom port number - 80
            ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));

            // Display commands for better readability
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            // Here it will wait for any client which wants
            // to get connected to this server

            // Establishing a connection
            // using accept() method()
            Socket s = ss.accept();

            // Display message
            System.out.println(
                "Client accepted through the port number: "
                + ss.getLocalPort());

            // getLocalPort() function returning the port
            // number which is being used

            ArrayList<String> reading = new ArrayList<>();
            Random random = new Random();

            while(reading.size() <= 3) {
                Integer next = random.nextInt(cards.length);

                if(!reading.contains(cards[next])){
                    reading.add(cards[next]);
                }
            }

            out = new DataOutputStream(s.getOutputStream());

            out.writeObject(reading)
        }

        // Catch block to handle for exceptions
        catch (Exception e) {

            // Simply return/exit
            return;
        }
    }
}