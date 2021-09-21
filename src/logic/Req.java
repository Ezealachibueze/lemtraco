package logic;


import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Payment_zone.Withdrawal_page;

@RequestScoped
@ManagedBean
public class Req {

	
	
	public  String onload() {
	
	
		 Map<String, Object>  sessio=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();   
		 if(sessio.isEmpty()) {
		 Withdrawal_page page=new Withdrawal_page();
    	 page.setLoggin_status("Sign in");
    	 sessio.put("status1", page);
    	 System.out.println("load");
		 }
     return null;
}
	
	
	
	
	public String home() {
		 Map<String, Object>  sessio=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();   
		 if(sessio.isEmpty()) {
		 Withdrawal_page page=new Withdrawal_page();
    	 page.setLoggin_status("Sign in");
    	 sessio.put("status1", page);
    	 System.out.println("load");
		 }
		
		return  "/index.xhtml?faces-redirect=true";}
		
}
