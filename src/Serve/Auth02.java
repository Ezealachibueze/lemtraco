package Serve;


import org.springframework.security.crypto.bcrypt.*;

public class Auth02 {


	
	public  String encryt(String pass) {
		return(BCrypt.hashpw(pass, BCrypt.gensalt(12)));
		
	}
		 
	public  boolean decryt(String orignial, String pass) {	
		return  (BCrypt.checkpw(orignial, pass));
		
	}
		    
	
		

	
}
