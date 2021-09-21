package logic;


import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import Serve.UserServer_Request;




@ManagedBean
@SessionScoped
public class Nav   {

	
	  
	 private	UserServer_Request  request =new UserServer_Request();
	int px=1,number,price1=2000,price2=1000;
	 String price3="200",price4="1000";
	 
	 
		public Nav() {
			
	    	
         
		}
		
		

		
	







		public String getPrice4() {
			return price4;
		}




		public void setPrice4(String price4) {
			this.price4 = price4;
		}




		public String getPrice3() {
			return price3;
		}

		public void setPrice3(String price3) {
			this.price3 = price3;
		}




		public int getPrice1() {
			return price1;
		}

		public void setPrice1(int price1) {
			this.price1 = price1;
		}




		public int getPrice2() {
			return price2;
		}




		public void setPrice2(int price2) {
			this.price2 = price2;
		}


		public int getNumber() {
			return number;
		}




		public void setNumber(int number) {
			this.number = number;
		}




		public String nv1() {  return  "/business_model.xhtml?faces-redirect=true";}
	
		public String nv2() { 	   return  "/board.xhtml?faces-redirect=true";}
		
		public String nv3() { 	 return  "/Contact.xhtml?faces-redirect=true";}
		
	     public String nv4() { /**new UserServer_Request().notification("Withdrawal Order", "aa", "aa", "tobeokoko18@gmail.com"); **/	   return  "/Investment.xhtml?faces-redirect=true";	}
			
	     public String nv6() {  String e=GETID();  request.payment_type("Orders",e);	  return  "/Ship.xhtml"; }
	      
	     public String nv7() { new Sub_total_caculate().sums(); return  "/Cart.xhtml?faces-redirect=true";	}
	     
	     public String nv5() {return  "/Register.xhtml?faces-redirect=true";}

	     public String nv8() { return  "/Sign_in.xhtml?faces-redirect=true";}
	     
	     
	     int h;
	         public String nv10() { 
	        	 
	        	 String e=GETID();
	        	 FacesContext  context=FacesContext.getCurrentInstance();
		    	 String c=(context.getExternalContext().getRequestParameterMap().get("f1"));
		    	 System.out.println(c);
		    	 
		    	 switch (c) {
				case "1000":
					 request.add_in(price4,e);  
					 Session_tabs();
					 return  "/Cash_deposit2.jsp";

				case "200":
					  request.add_in(price3,e);
					  Session_tabs();
					  return  "/Cash_deposit2.jsp";
				}
  		    	
	    	 return  null; 
	    	 }
	     
	       public String nv11a() { 
		    	  String e=GETID();
		 		 request.add_in("0",e);   
		 		 Session_tabs();
		 		 return  "/Cash_deposit2.jsp";
		    
	  	}
	         
	         
    
 
	     
	     
	     public String nav_invest() {
	    	
	    	 String ed="";
	    
	    		 
		FacesContext  contex=FacesContext.getCurrentInstance();
	   ed=contex.getExternalContext().getRequestParameterMap().get("eds");
			
	   
				
				
		if(ed.trim().length()==0)
			new UserLogin_Register().message("Pls Sign in");
		else  {
	    	 FacesContext  context=FacesContext.getCurrentInstance();
	    	 int c=Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("package"));
	    	 
	    	 switch(c) {
	    	 case 1:
	    		 		request.add_user_investment_selection(price1, GETID() ,ed,"Paypal");
//	    		 		System.out.println(GETID());
	    		 		 Session_tabs();
	    		 		 return  "/cash_deposit.jsp";
	    		 
	    	case 2:
	    	     	request.add_user_investment_selection(price2,GETID() ,ed,"Paypal");
//	    	     		System.out.println(GETID());
	    	     	 Session_tabs();
	    	     	 return  "/cash_deposit.jsp";
	    	 
	       case 3: 
	    	   if(number==0)
					 message("You have not made any Selection");
	    	   else {
	    	   request.add_user_investment_selection(number,GETID() ,ed,"Paypal");
//	    		System.out.println(GETID());
	    	   Session_tabs();
	    	   }
  	     	 return  "/cash_deposit.jsp";
	    	 }	 
		}
				 
	    	 return  null;	
	     }
	     

	        
	     public String nv9() {
	    	 FacesContext  context=FacesContext.getCurrentInstance();
	    	 String c=(context.getExternalContext().getRequestParameterMap().get("pat"));
	    	 	if(c.equals("Sign in"))
	    	 		return  "/Sign_in.xhtml?faces-redirect=true";
					else {
						teste();
	    	 	      return  "/index.xhtml?faces-redirect=true";
					}
		}
	     
	     
	     
	     
	 	public String inner_jobs() {
			message("A notification has be Sent too yr email");
			 
	  return "/Sign_in.xhtml?face-redirect=true";	}
	
	 	
	 	
	 
		
	     
	   
	     





		public int getPx() {
			return px;
		}



		public void setPx(int px) {
			this.px = px;
		}




		public String plus() {
			px++;
	  return  null;	}
	     
	     public String minus() {
	    	 if(px<=0)  
	    		 px=1;
				px--;
			return  null;}
	     
	     
	    
	     
	     public void caculates() {
					System.out.println("ok"+px);
		}
	
		
		public  String  send_in_items() {
		
			FacesContext  context  =  FacesContext.getCurrentInstance();
			String id = context.getExternalContext().getRequestParameterMap().get("wq");
			long in =Long.valueOf(context.getExternalContext().getRequestParameterMap().get("ing"));
	        	long d =new 	Caculate().name(in, px);
				request.item_drop_in(px,in,d,id,GETID());
				message("Copy to Cart");
				px=1;
		
		return null;}
		
		
		
	 
	


		public void message(String k) {
	 	 RequestContext context =RequestContext.getCurrentInstance();
	 	 	context.execute("swal('"+k+"')");
	 	 	
	 	     
		}
	     
		 
		 
		 
			public void teste() {
				
				FacesContext   context = FacesContext.getCurrentInstance();
		        HttpSession  session1= (HttpSession) context.getExternalContext() .getSession(false);
		       String c=  (String)session1.getAttribute("keys");
				new   UserServer_Request().logout(c);
			 	System.out.println("Ended ! app"+c);
		 }

		 
		 
		    public String time_save(){
		           String o=null;
		        ZonedDateTime z= ZonedDateTime.now();
		        LocalTime time= LocalTime.now();
		        int g=z.toString().indexOf("[");
		        int c=z.toString().indexOf("]");
		        int d=z.toString().indexOf("T");
		        String q=z.toString().substring(g+1, c);
		        for(String h : ZoneId.getAvailableZoneIds()){ 
		          if(h.equals(q)){        
		               o=h.concat("       ").concat(z.toString().substring(0,d).concat("     "+time.toString().substring(0, 5)));
		                break; 
		          }  }
		    return  o;}
		    
		    
		    

		     
	
		     
		     private void Session_tabs() {
		    	 FacesContext   con = FacesContext.getCurrentInstance();
			        HttpSession  session1= (HttpSession) con.getExternalContext() .getSession(false);
			       	session1.setAttribute("sess", GETID());
			}


			public String  GETID() {
				FacesContext   context = 
		       		 FacesContext.getCurrentInstance();
		        HttpSession  session=
		       		 (HttpSession) context.getExternalContext()
		       		 .getSession(false);
		        				String c =session.getId();
				return c;	
				}
		     
		     
		     public void request_new_id() {
					FacesContext   context = 
				       		 FacesContext.getCurrentInstance();
				        HttpSession  session=
				       		 (HttpSession) context.getExternalContext()
				       		 .getSession(false);
				        session.invalidate(); 
				       // System.out.println("Cleaner");
					
				}
		     
		     
	
		     
		
}


