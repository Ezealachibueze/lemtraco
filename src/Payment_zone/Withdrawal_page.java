package Payment_zone;


import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import logic.UserLogin_Register;

@ManagedBean
@ApplicationScoped
public class Withdrawal_page {
	
	
		private String name="",reason="",user="",amount="",balance;
		private List<Withdrawal_page>  lis,lis2;
		private String  
		Date_,
		Transciation_ID,
		Payment_method,
		amount1,Paid_To
		,status,loggin_status="Sign in",kalid;
		public  String onload() {
			FacesContext   context = FacesContext.getCurrentInstance();
	        HttpSession  session1= (HttpSession) context.getExternalContext() .getSession(false);
	        setKalid((String)session1.getAttribute("keys"));
	        System.out.println(getKalid()+"   boob");
	       
		return null;
		}
		


		public String getKalid() {
			return kalid;
		}



		public void setKalid(String kalid) {
			this.kalid = kalid;
		}



		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDate_() {
			return Date_;
		}

		public void setDate_(String date_) {
			Date_ = date_;
		}

		public String getTransciation_ID() {
			return Transciation_ID;
		}

		public void setTransciation_ID(String transciation_ID) {
			Transciation_ID = transciation_ID;
		}

		public String getPayment_method() {
			return Payment_method;
		}

		public void setPayment_method(String payment_method) {
			Payment_method = payment_method;
		}

		public String getPaid_To() {
			return Paid_To;
		}

		public void setPaid_To(String paid_To) {
			Paid_To = paid_To;
		}

		public String getBalance() {
			return balance;
		}

		public void setBalance(String balance) {
			this.balance = balance;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getName() {
			return name;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAmount1() {
			return amount1;
		}

		public void setAmount1(String amount1) {
			this.amount1 = amount1;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}
			
		
		public  void spill() {
			System.out.println(amount);
		}
		
		public  void spill2() {
			System.out.println(name);
		}
		
		public  void spill3() {
			System.out.println(reason);
		}
		
		boolean check;
		public  String issue_request() {
			
			String x,es;
			if(amount.trim().length()==0) 
				new UserLogin_Register().message("Pls Enter an amount ");
			else 
				if(name.trim().length()==0)
					new UserLogin_Register().message("Pls Enter Your Name ");
				
			else {
			long sw=0;
				FacesContext  context=FacesContext.getCurrentInstance();
				String ed=context.getExternalContext().getRequestParameterMap().get("eds");
				//System.out.println(ed+"gg");
				
				if(ed.trim().length()==0)
					new UserLogin_Register().message("Pls Sign in");
				else
				if(ed.trim().length()>0) {
					 x=   new Auth_payment().member_status(ed);
				
				if(x.equalsIgnoreCase("true")) {
						es=new Auth_payment().confirm_again(ed);		
							if(es.equalsIgnoreCase("paid")) { 
									sw=new  Auth_payment().member_balance_check(ed);
									check = (sw<=0)  ? false: true; 	 
									if(check) {
										long v=Long.valueOf(amount);
											if(v>sw)
												new UserLogin_Register().message("Insufficent Funds");
											
											int xz=	new Auth_payment().check_account_status(ed);
										
											if(xz==400) 
														new UserLogin_Register().message("Your Account Has been Disabled Contact Support ! ");
										else 
											if(v<=sw && xz!=400){
												int xd=	new Auth_payment().process_order(v,name,ed);
												if(xd==200) {
													name=""; amount=""; reason="";
													  new UserLogin_Register().message("Order Sent");
												}else
													new UserLogin_Register().message("Unknow Error Occured Pls try again ");
													}
												}
										} 
							else
									new UserLogin_Register().message("You are yet too invest ");	
								}
						}
				
			}
		return null;
		
		}

		public List<Withdrawal_page> getLis() {
			    return new Auth_payment().pull_user_balance(getKalid());
	 		
	 	
		}

		public void setLis(List<Withdrawal_page> lis) {
			this.lis = lis;
		}
		
		
		
		
		
		
	 	public List<Withdrawal_page> getLis2() {
	 	//	Integer intg=  Integer.getInteger(getKalid());
	 		
	 				return new Auth_payment().pull_user_transcaition_history(getKalid());
	 		
		}

		public void setLis2(List<Withdrawal_page> lis2) {
			this.lis2 = lis2;
		}
		
		
		
		
		
		public String getLoggin_status() {
			return loggin_status;
		}

		public void setLoggin_status(String loggin_status) {
			this.loggin_status = loggin_status;
		}

	 	
	 	
		
	

		
		
}





