/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Serve.UserServer_Request;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class UserLogin_Register {

    /**
     * Creates a new instance of UserLogin_Register
     */
    
    Country  coutry=new Country();
     Sing   e=new Sing();
    UserServer_Request  request= new UserServer_Request();
     String user="",password="",confirm_pass,phone="",
    		     string, strs,st1,names,working="",accounts="",
    		       bankname="",acount_holder_name="",string1,strin1="",strin2;


     

    
    public void spill1() {
    	
    	if(validate(user)==1) {
    		   message("Pls enter a valid email ");
    	}
    	System.out.println(user );	
    	}
    
    
    public void spill2() {
    	System.out.println(phone);
  	}
    
    public void wrk2() {
		System.out.println(working);
		}
	
	public void spill3() {
	//System.out.println(password);
		if(password.trim().length()>0 && password.trim().length()<8) {
			message(" Password is weak  minimum is 8  Character's");
			e.setEd(1);
		}else
			e.setEd(0);
		
		}
	
	public void spill4() {
		if(!password.equals(confirm_pass)) {
			message(" Password Doesn't match");
			e.setEd(2);	
		}else
			e.setEd(0);
		
		}
	
	public void wrk3() {
	    System.out.println(bankname);
	    	
	  	}
	
	public void wrk4() {
	   System.out.println(accounts);
	    	
	  	}
	
	public void wrk5() {
		   System.out.println(acount_holder_name);  	
		  	}
    
	    
	public String getStrin1() {
		return strin1;
	}


	public void setStrin1(String strin1) {
		this.strin1 = strin1;
	}


	public String getStrin2() {
		return strin2;
	}


	public void setStrin2(String strin2) {
		this.strin2 = strin2;
	}


	
	
	
	
	
	
		public  String   add_new(){
			  if(user.trim().length()>0  &&  working.trim().length()>0   &&  password.trim().length()>0  &&  bankname.trim().length()>0    &&    accounts.trim().length()>0   && acount_holder_name.trim().length()>0  && !(coutry.getRegoin().trim().equals(coutry.a0))   && e.getEd()==0  && validate(user)!=1) {				
				  
				  	int c= request.register_user(user,working,password,bankname,accounts,acount_holder_name, coutry.getRegoin());
	
	 if(c==404) {
		 message("Email Already  exists ");   	
		}else
		   if(c==1) {
			   message("Successfully Registered ");
				   user="";  working="";  password="";   bankname=""; accounts=""; acount_holder_name="";confirm_pass=""; e.setEd(0);  coutry.setRegoin("");
	          	return "/Sign_in.xhtml";
		   }		   
		   else
			   message("Registration Failed ! ");
		  }
		   else
			   if(user.trim().length()==0 || working.trim().length()==0 || password.trim().length()==0 ||  bankname.trim().length()==0  || accounts.trim().length()==0 ||   acount_holder_name.trim().length()==0)
				   message("Pls fill Out all fields ! ");
			   else
				   if(e.getEd()==1) {
				   message("Pls Enter a Strong Password");
				   e.setEd(0);
				   }
			   else 
				   if(e.getEd()==2) {
					   message(" Password Doesn't match");
					   e.setEd(0);   
				   }
			   else
				   if(coutry.getRegoin().trim().equals(coutry.a0))
					   message("Pls Select your Region  ");
				   else 
					   if(validate(user)==1)
						   message("Pls enter a valid email ");
			  
		return null;
		}
		
		
		
		public String register() {
			
		return "/Register.xhtml?faces-redirect=true";}
		
		
		
		public String bastard() {   
			
			System.out.println(string1+"  XX");
			if(string1.trim().length()>0 ) {
			request.forgot_pass_email(string1);
			string1="";
			return "/email_sent.xhtml?faces-redirect=true";  
			}
			else {
				message("Pls Enter a valid Emial");
		return null;  
			}
	}  
			
		
		
		public String request_pass() {   
		
		
		
		return "/forgot.xhtml?faces-redirect=true";  }  
		
		
		public String go_back() {
			
			return "/index.xhtml?faces-redirect=true";	}
		 
		
		public String  sign_up_ad() {
		int cv=0;
		
		if(cv==1) 
			return "/C_panel.xhtml?faces-redirect=true";
		else
			if(cv==2)
		message("Pls fill out the field");
		else 
			message("Sign in failed");
		return null;
		}
		
		
		public void name() {
		System.out.println(string1);
		}
		
		public String name1() {
		
		return null;}
		
		
		
	    public void spi1() {
	    	System.out.println(user);
	    }
	    
	    public void spi2() {
	    	//System.out.println(password);
	    }
		public String  sign_up() {
			int cv=request.authenticate_User(user.toLowerCase(),password);	
			
		//	System.out.println(cv);
			
					if(cv==1) {
						user=""; password="";
					    return "/index.xhtml?faces-redirect=true";
					}
					else 
						if(cv==3){
						message("Wrong Password ! ");
					     	return "/Sign_in.xhtml";
					}else {
						message("Sign in failed !");
						user=""; password="";
					     		return "/Sign_in.xhtml";
					     		
					     	}
			
		
		}





		public void message( String h) {
//		RequestContext  requestContext=RequestContext.getCurrentInstance();
//		requestContext.execute("swal('"+h+"')");
			
			FacesContext context=FacesContext.getCurrentInstance();
			FacesMessage  message =new FacesMessage(FacesMessage.SEVERITY_INFO,"",h);
		context.addMessage(null, message);
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



		public String  question() {
			if(names.trim().length()>0 && working.trim().length()>0 && user.trim().length()>0) {
			   int  c =request.review_question(names,working,user);
			if(c==1) {
				message("Thanks  an Email would be sent"); names=""; working=""; user="";
			}
			}else
				message("Error Occured pls try again");
		
		
		return null;}


		
		
		public void nam1() {
			System.out.println(strin1);
			}
		
	public void nam2() {
			System.out.println(strin2);
			}
	
			public String hack() {
				
			System.out.println(strin1+"     "+strin2);
			
			
			return  null;}
			
			
		
		
		
		
			
			
			public String getNames() {
			return names;
		}


		public void setNames(String names) {
			this.names = names;
		}


			public String getString1() {
			return string1;
			}
			
			public void setString1(String string1) {
			this.string1 = string1;
			}
			
			public String getAcount_holder_name() {
			return acount_holder_name;
			}
			
			public void setAcount_holder_name(String acount_holder_name) {
			this.acount_holder_name = acount_holder_name;
			}
			
			public String getBankname() {
			return bankname;
			}
			
			public void setBankname(String bankname) {
			this.bankname = bankname;
			}
			
			public String getAccounts() {
			return accounts;
			}
			
			public void setAccounts(String accounts) {
			this.accounts = accounts;
			}
			
			public String getWorking() {
			return working;
			}
			
			public void setWorking(String working) {
			this.working = working;
			}

			  public String getString() {
					return string;
				}
			
				public void setString(String string) {
					this.string = string;
				}
		
					public UserLogin_Register() {
						  st1=" ";
					  	}

				public String getSt1() {
					return st1;
				}
			
			
				public void setSt1(String st1) {
					this.st1 = st1;
				}    
			    
				public String getStrs() {
					return strs;
				}
			
				public void setStrs(String strs) {
					this.strs = strs;
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
			
			    public String getPhone() {
			        return phone;
			    }
			
			    public void setPhone(String phone) {
			        this.phone = phone;
			    }
				public String getConfirm_pass() {
					return confirm_pass;
				}


				public void setConfirm_pass(String confirm_pass) {
					this.confirm_pass = confirm_pass;
				}


			




			

			    
			  
			    

}
