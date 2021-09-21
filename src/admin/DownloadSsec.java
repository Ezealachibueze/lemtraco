package admin;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.mobile.component.page.Page;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lemtraco02.Creden;

@ManagedBean
@RequestScoped
public class DownloadSsec {

	

	
	List<DownloadSsec>  lab1,lab2,lab3,lab4,lab5,lab6,lab7;
	String id,price,writeup,img_name,type,time_stamp,
	emails,account,number,account_number,sea,number1,loggin;
	StreamedContent  contents;

	static String view;
	
	
	 
	

	
	
	
	
	public StreamedContent getContents() throws FileNotFoundException {
		byte [] file=null;
			FacesContext  context= FacesContext.getCurrentInstance();
			if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE)
				return  new DefaultStreamedContent();
			else {
				String h=context.getExternalContext().getRequestParameterMap().get("dx1");
					
					file=	new Server_Request().read_img(Creden.bucket, h);
			}
		return new DefaultStreamedContent(new ByteArrayInputStream(file));
	}
	public void setContents(StreamedContent contents) {
		this.contents = contents;
	}
	
	
	
	
	
	
						
		
		//		return server_Request.view_notifications();
		

	
	
	public List<DownloadSsec> getLab1() {
		return   new Server_Request().bastard();
	}

	public void setLab1(List<DownloadSsec>  lab1) {
		this.lab1 = lab1;
	}
		
	
	
	public List<DownloadSsec> getLab2() {
		return new Server_Request().Registrated_member();
	}
	public void setLab2(List<DownloadSsec> lab2) {
		this.lab2 = lab2;
	}
	
	
	
	public List<DownloadSsec> getLab3() {
		return new Server_Request().read_user_orders((String)instance_get().getAttribute("pagen"));
	}
	
	public void setLab3(List<DownloadSsec> lab3) {
		this.lab3 = lab3;
	}
	
	
	public String view_trans() {
		
		
		return  null;
	}
	
	
	public List<DownloadSsec> getLab4() {
		if(!new Admin_login().name().isEmpty())
		return new Server_Request().investment_section();
		
		return null;
	}
	public void setLab4(List<DownloadSsec> lab4) {
		this.lab4 = lab4;
	}
	
	
	public List<DownloadSsec> getLab5() {
		return new Server_Request().forgot_pass_list();
	}
	
	public void setLab5(List<DownloadSsec> lab5) {
		this.lab5 = lab5;
	}
	
	public List<DownloadSsec> getLab7() {
		return  new Server_Request().pulls((String)instance_get().getAttribute("pagen"),(String)instance_get().getAttribute("page1"));
	}
	public void setLab7(List<DownloadSsec> lab7) {
		this.lab7 = lab7;
	}
	
	
	
	
	public String view_bal() {
		FacesContext  context=FacesContext.getCurrentInstance();
		String	x=context.getExternalContext().getRequestParameterMap().get("usermail");
		instance_get().setAttribute("bals", x);
		return "/cp6.xhtml?faces-redirect=true";
	}
	
	
	
	
	public List<DownloadSsec> getLab6() {
		return new Server_Request().balance_check((String)instance_get().getAttribute("bals"));
	}
	public void setLab6(List<DownloadSsec> lab6) {
		this.lab6 = lab6;
	}
	
	
	
	
	
	
	public String view_sub_noti() {
	
		new Server_Request().clearNotifications();
	return  null;
	}
	

	public String go_back() {
		
		new Server_Request().view_notifications();
	return  null;
	}
	
	public String request_view() {
		FacesContext context=FacesContext.getCurrentInstance();
		
		String string=context.getExternalContext().getRequestParameterMap().get("ty");
		String string1=context.getExternalContext().getRequestParameterMap().get("trans");
		String string2=context.getExternalContext().getRequestParameterMap().get("cd");
		String string3=context.getExternalContext().getRequestParameterMap().get("ml");
		
		new Server_Request().update(string2);
		
		if(string.equals("Withdrawal Order")){	
				Category(string3,string);
				setView(string);
				return  "/cp7.xhtml?faces-redirect=true";
		 }else
			 	if(string.equals("Goods Purchase")) {
			 		Category(string1,"");
			 		setView(string);
			 		return  "/cp3.xhtml?faces-redirect=true";
		}else
			if(string.equals("Invest")) {
				Category(string3,"Investors");
				setView(string);
				return  "/cp7.xhtml?faces-redirect=true";
			}
		System.out.println(string2+string+string1);
		
	return  null;
	}
	
	

	public String totals() {
		
	FacesContext  context=FacesContext.getCurrentInstance();
     String c =String.valueOf(context.getExternalContext().getRequestParameterMap().get("ny"));
	  String h = new Server_Request().suminprices(c);
	  message("Total = "+h);
	
	return null;}
	
	
	
	public void message(String j) {
		RequestContext  context= RequestContext.getCurrentInstance();
		context.execute("swal('"+j+"')");
	
	}
	

	
	private void Category(String string, String string2) {
		if(string2.trim().length()==0)
			 instance_get().setAttribute("pagen",string);
		else {
			instance_get().setAttribute("pagen", string);
			instance_get().setAttribute("page1", string2);
		}
			 
		
	}
	

	
	private HttpSession  instance_get() {
		 FacesContext context=
				 FacesContext.getCurrentInstance();
		 HttpSession  session=(HttpSession)
		 				context.getExternalContext().getSession(false); 
         return  session;	}
	
	
	
	
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getSea() {
		return sea;
	}
	public void setSea(String sea) {
		this.sea = sea;
	}
	
	public String getLoggin() {
		return loggin;
	}
	public void setLoggin(String loggin) {
		this.loggin = loggin;
	}
	
	public String getNumber1() {
		return number1;
	}
	public void setNumber1(String number1) {
		this.number1 = number1;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWriteup() {
		return writeup;
	}
	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}
	

}
