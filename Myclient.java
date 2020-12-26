import java.io.*;  
import java.net.*;
import java.util.Scanner;
//package clientserver;

/**
 *
 * @author student
 */
public class Myclient {
    
    public static void main(String[] args) {  
        
    Scanner ss = new Scanner(System.in);
//    ss.nextLine();
    String str = ss.nextLine();
//    System.out.println(str);
    ss.close();
    try
    {      
        Socket s=new Socket("localhost",1778);  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        dout.writeUTF(str);  
        dout.flush();  
        dout.close();  
        s.close();  
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
}  
    
}
