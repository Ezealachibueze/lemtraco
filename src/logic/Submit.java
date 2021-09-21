package logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Serve.UserServer_Request;


@ManagedBean
@RequestScoped
public class Submit {

	private String fullname,email,address,city,origin,zipCode,phoneNumber;


     UserServer_Request  request =	new UserServer_Request();
	
	
	
	
	public Submit() {

	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String sumitForm() {
		
		if(getFullname().trim().length()>0   && getEmail().trim().length()>0 &&   getAddress().trim().length()>0 
				 && getPhoneNumber().trim().length()>0  &&  getCity().trim().length()>0 && getOrigin().trim().length()>0) {
			
		FacesContext cont=FacesContext.getCurrentInstance();
		String a =(cont.getExternalContext().getRequestParameterMap().get("submit"));
		
		FacesContext conti=FacesContext.getCurrentInstance();
		int bb =Integer.parseInt(conti.getExternalContext().getRequestParameterMap().get("ttt"));
		System.out.println("total param"+bb);
		
	
		
		FacesContext contex=FacesContext.getCurrentInstance();
		int ite =Integer.parseInt(contex.getExternalContext().getRequestParameterMap().get("item"));
		System.out.println("total item"+ite);

		FacesContext name=FacesContext.getCurrentInstance();
		String tt =name.getExternalContext().getRequestParameterMap().get("name");
		System.out.println("total item"+tt);
		
		
		FacesContext pp=FacesContext.getCurrentInstance();
		String price =(pp.getExternalContext().getRequestParameterMap().get("price"));
		System.out.println("total param"+price);
		
		
			//request.submitAll(getFullname(),getEmail(),getAddress(),getPhoneNumber(),getCity(),getOrigin());

			new Nav().message("Order sent Successfully  ");
			setFullname(""); setEmail(""); setAddress("");  setPhoneNumber(""); setCity("");  setOrigin("");
		
	
		}else
			new Nav().message("Pls Fill Out all the fields ! ");
	 
		return null;
	}
	
		

	
}
