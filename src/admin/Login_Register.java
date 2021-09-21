/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class Login_Register {

    /**
     * Creates a new instance of UserLogin_Register
     */
    
    
    Server_Request  request= new Server_Request();
    String user="",password="";
	    
			    public void spill1() {
			        	
			    	if(validate(user)==1) {
			    		
			    	}
			    	System.out.println(user );
			    		
			    	}
			  

			    public  int validate(String f){
			         int g=0;
			         Pattern mask=null;

			         mask=Pattern.compile(".+@.+\\.[a-z]+");
			         Matcher matcher=mask.matcher(f);
			         if(matcher.matches())
			            g=2;
			         else
			           g=1;
			        return  g;
			     }
		public String getUser() {
	        return user;
	    }
	
	    public void setUser(String user) {
	        this.user = user;
	    }
	
	    public String getPassword() {
	        return password;
	    }
	
	    public void setPassword(String password) {
	        this.password = password;
	    }
	
}
