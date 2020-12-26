import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
	       
	        ServerSocket ss = new ServerSocket(1423);
	        System.out.println("ServerSocket awaiting connections...");
	        Socket socket = ss.accept(); 
	        System.out.println("Connection from " + socket + "!");

	        InputStream inputStream = socket.getInputStream();
	        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
	        
	        List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
	        System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);
	        
	        
	        System.out.println("All messages:");
			listOfMessages.forEach((msg)-> 
			{
				if(msg.ChkParity()==msg.getParity())
			{
				System.out.println(msg.getText());
				System.out.println(msg.getheader());
				System.out.println(msg.getprotocol());
				System.out.println("Correct Message!!!");
			}
		else
			{
				System.out.println("Error!!!");
			}
		});

	        
	        
	        System.out.println("Closing sockets.");
	        ss.close();
	        socket.close();
	    }
	}