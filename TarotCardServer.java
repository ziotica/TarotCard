import java.net.*;
import java.io.*;
import java.util.*;

public class TarotCardServer {    
    //card deck
    private static String[] cards = {"The Fool", "The Magician", "The High Priestess", "The Empress", "The Emperor", "The Hierophant", 
    "The Lovers", "The Chariot", "Strength", "The Hermit", "Wheel of Fortune", "Justice", "The Hanged Man", "Death", 
    "Temperance", "The Devil", "The Tower", "The Star", "The Moon", "The Sun", "Judgement", "The World"};

    public static void main(String[] args) throws Exception
    {
        try {
            // create server socket with given port number
            ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));

            while(true){
                // wait until client connects
                Socket s = ss.accept();

                // randomly select the past, present, and future cards
                // without replacement, fixed size of 3
                ArrayList<String> reading = new ArrayList<>();
                Random random = new Random();
                
                while(reading.size() < 3) {
                    Integer next = random.nextInt(cards.length);
                    if(!reading.contains(cards[next])){
                        reading.add(cards[next]);
                    }
                }
                
                // sent client the reading
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                out.writeObject(reading);
                
                s.close();
                out.close();
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
