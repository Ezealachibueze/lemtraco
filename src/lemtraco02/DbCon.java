package lemtraco02;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbCon {

//	 public static void main(String[] args) {
//		
//		 
//		 
//    	System.out.println(getConnection());
//		}
	    
	   public      Connection getConnection() {
	        
		   Connection connection = null; 
		   try{
	            	      Class.forName(Creden.driver);
	                     connection=DriverManager.getConnection(Creden.URL, Creden.USER, Creden.Pass);
	                    // System.out.println("Connected");
	              } catch (Exception e) { 
	            	  System.out.println("Error  with  Creden ! "+e); } 
		   return connection;
	
	   }
	
}
