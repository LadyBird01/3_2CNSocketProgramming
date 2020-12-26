import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1234564L;
	private String text;
	private int header;
	private int protocol;
	private  boolean Parity;

    public Message(String text, int header, int protocol) {
        this.text = text;
        this.header = header;
        this.protocol = protocol;
        setParity();
    }

    public String getText() {
        return this.text;
    }
    
    public int getheader() {
        return this.header;
    }

    public int getprotocol() {
        return this.protocol;
    }
   public void setParity(){
		this.Parity = false;

		if(CalParity(this.header))	
			this.Parity = !this.Parity;
		if(CalParity(this.text))		
			this.Parity = !this.Parity;
		if(CalParity(this.protocol))	
			this.Parity = !this.Parity;
	}
    
    public boolean 	getParity()	{
    	return this.Parity;
    }
    public boolean ChkParity(){
		boolean parity = false;

		if(CalParity(this.header))	
		       parity = !parity;
		if(CalParity(this.text))		
		        parity = !parity;
		if(CalParity(this.protocol))	
		       parity = !parity;

		return parity;
	}
    
    public boolean CalParity(int n){
		boolean parity = false;
		while(n != 0){ 
        	parity = !parity;
        	n = n & (n-1);
		} 
		return parity;
	}
    
    public boolean CalParity(String str){
		boolean parity = false;
		byte[] byteArray = str.getBytes();
		int i;

		for(i=0; i<byteArray.length; i++){
			if(byteArray[i] == 1)	
				parity = !parity;
		}

		return parity;
	} 
}