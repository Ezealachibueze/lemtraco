package admin;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Admin_login {

	
	
			String user_admin,passwords_admin,passwords_admin_c;

	
			
			
			public String getPasswords_admin_c() {
				return passwords_admin_c;
			}

			public void setPasswords_admin_c(String passwords_admin_c) {
				this.passwords_admin_c = passwords_admin_c;
			}

			public String getUser_admin() {
				return user_admin;
			}

			public void setUser_admin(String user_admin) {
				this.user_admin = user_admin;
			}

			public String getPasswords_admin() {
				return passwords_admin;
			}

			public void setPasswords_admin(String passwords_admin) {
				this.passwords_admin = passwords_admin;
			}
			
			
			
			
	public String sign_up_admin() {
				
	System.out.println(user_admin+" "+passwords_admin+" "+ passwords_admin_c);
		if(user_admin.trim().length()>0 && passwords_admin.trim().length()>0) 
			return  error_class(new Server_Request().authenticate(user_admin,passwords_admin)); 	
		else
			if(user_admin.trim().length()>0 && passwords_admin.trim().length()>0 && passwords_admin_c.trim().length()>0)
				new DownloadSsec().message("Invalid Input");
			else
				if(user_admin.trim().length()>0 && passwords_admin_c.trim().length()>0)
					return  error_class(new Server_Request().update_admin_credentails(user_admin,passwords_admin_c));
				else
					new 	DownloadSsec().message("Pls Fill Out all Fields ! ");
		
	return null;
			}
			
			
	
	public Map<String, Object> name() {
		FacesContext context=FacesContext.getCurrentInstance();
		Map<String, Object> obj=context.getExternalContext().getSessionMap();
		return obj;
	}
	
	
	
	
	private String  error_class(int x) {
	
		
	switch (x) {   
		case 0:
			new DownloadSsec().message("Dead Request !  ");
			break;
			
	
			
		case  202:
			new DownloadSsec().message("Successfully Sign in");
			return "/cp1.xhtml";
			
		case  205:
			new DownloadSsec().message("Successfully Updated ");
			return "/Sign_in_admin.xhtml";
		
		case 401:
			new DownloadSsec().message("Unauthorized  Access !" );
			break;
			
		case  402:
			new DownloadSsec().message("Error Occured Pls try again");
			break;
			
		case 403:
			new DownloadSsec().message("Password doesn't  match ! ");
			break;
		
		case 404:
			new DownloadSsec().message("Connection refused !" );
			break;
			
		case 405:
			new DownloadSsec().message("email doesn't  match !" );
			break;
			
		default:
			new DownloadSsec().message("Failed Contact Support ! ");
			break;
	}
	return null;
	
	}
			
			
}
