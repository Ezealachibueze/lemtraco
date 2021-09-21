package logic;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Serve.UserServer_Request;

@ManagedBean
@RequestScoped
public class Sub_total_caculate {
	
		
	static   String subtotal;

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	public String sums() {
		setSubtotal(new UserServer_Request().sum_in(new Nav().GETID()));
	return null;}
	
	
	
	
	public String remove() {
		
		FacesContext cont=FacesContext.getCurrentInstance();
		int a=Integer.parseInt(cont.getExternalContext().getRequestParameterMap().get("yuo"));
		
			new UserServer_Request().drop_item(a);
			return null;
			}
	
	
	
	
	
	
	
}
