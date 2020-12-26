import java.net.*;
import java.io.*;
 
public class chatserver
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(1321);
		Socket soc=ss.accept();
		BufferedReader cin = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		PrintStream cout=new PrintStream(soc.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ( true )
		{
			s=cin.readLine();
			System. out.print("Client : "+s+"\n");
			System.out.print("Server : ");
			if (s.equalsIgnoreCase("BYE"))
  			{
				cout.println("BYE");
    				break;
  			  }
			s=stdin.readLine();
			cout.println(s);
		}
		ss.close();
 		soc.close();
 		cin.close();
		cout.close();
 		stdin.close();
	}

	
}