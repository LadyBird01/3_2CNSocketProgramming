import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
        
        Socket socket = new Socket("localhost", 1423);
        System.out.println("Connected!");
        
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        
        
        List<Message> messages = new ArrayList<>();       
        messages.add(new Message("What's your name?", 10, 100));
       
        
        
        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(messages);
        

        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
}