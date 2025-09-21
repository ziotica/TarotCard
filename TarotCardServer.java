// create TCP server socket (choose a port number)

/* server loops forever around an accept method call
which sleeps server until connection request from client */

/* once connection request accepted - 
host OS creates a worker socket (to deal with the client and thread)
randomly select 3 tarot cards without replacement
write the response back to client via outstream of worker socket */

// close client connection, and loop back to waiting for accept request

// new client connections on different worker sockets

// Demonstrating Server-side Programming
import java.net.*; // for socket functions
import java.io.*; // for worker outstream
import java.util.*; // for my return reading. i could do it cleaner but i like array lists

public class TarotCardServer {

    // Initialize socket and input stream
    private Socket s = null;
    private ServerSocket ss = null;
    private DataOutputStream output = null;

    private String[] cards = {"The Fool", "The Magician", "The High Priestess", "The Empress", "The Emperor", "The Hierophant", 
    "The Lovers", "The Chariot", "Strength", "The Hermit", "Wheel of Fortune", "Justice", "The Hanged Man", "Death", 
    "Temperance", "The Devil", "The Tower", "The Star", "The Moon", "The Sun", "Judgement", "The World"};

    // Constructor with port
    public Server(int port) {

        // Starts server and waits for a connection
        try
        {
            ss = new ServerSocket(port); // worker socket
            System.out.println("Server started"); //keep for debugging

            System.out.println("Waiting for a client ..."); // keep for debugging

            s = ss.accept();
            System.out.println("Client accepted"); // keep for debugging

            // Server returns three randomly selected cards         
			
			Random random = new Random();
    		ArrayList<String> reading = new ArrayList<>();

		   	while (reading.size() <= 3) { // selection repeats size = 3
				Integer next = random.nextInt(cards.length);
				
				if(!reading.contains(cards[next])){
					reading.add(cards[next]);
				}
			}

	        // send client the arraylist
            output = new DataOutputStream(socket.getOutputStream(), true);
           
            output.writeOutput(reading);        

            System.out.println("Closing connection"); // keep for debugging

            // Close connection
            s.close();
            output.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

public static void main(String args[])
{
        Server s = new Server(Integer.parseInt(args[0])); //initialises server on chosen port
    }
}

/* sources used:
Socket Programming in Java (https://www.geeksforgeeks.org/java/socket-programming-in-java/) 

Creating Random Numbers With No Duplicates in Java (https://www.baeldung.com/java-unique-random-numbers) */


