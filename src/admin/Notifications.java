package admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Notifications {

	
	
	
	
	 String noti;
	public String getNoti() {
		return noti;
	}

	public void setNoti(String noti) {
		this.noti = noti;
	}
	  
	
	
	public void read_noti() {
		   setNoti(new Server_Request().read_orders());
	
	}
	  
	
	
}
