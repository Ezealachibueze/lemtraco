package Payment_zone;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;

import Serve.UserServer_Request;
import logic.Nav;
import logic.UserLogin_Register;


/**
 * Servlet implementation class ExecutePaymentServlet
 */
@WebServlet("/execute_payment")
public class ExecutePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	String  v1 = null;

	
    public ExecutePaymentServlet() {
      
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id  =request.getParameter("paymentId");
		String payerID  =request.getParameter("PayerID");
		String amount  =request.getParameter("amount");
		String email  =request.getParameter("emails");
		
		
			try {
		PaymentServices  paymentServices  = new PaymentServices();
		 Payment payment = paymentServices.executePayment(id, payerID);
		  
		 
		 
		 PayerInfo payerInfo =payment.getPayer().getPayerInfo();
		 Transaction transaction =payment.getTransactions().get(0);
		 
		 String  url ="receipt.jsp";
		 
		 request.setAttribute("payer", payerInfo);
		 request.setAttribute("transaction", transaction);
		 
		 request.getRequestDispatcher(url).forward(request, response);
		 	
		 
			Cookie[]   cookies=request.getCookies();		
			for(Cookie ncCookie  : cookies) {
			    	 v1 =ncCookie.getValue();
			    
			}
			
			
			int y=	return_session_id_form_managed_bean(request);
			 String loggin=new UserServer_Request().quick_check(v1);
			// System.out.println(amount+" amout");
			 if(y==2) {
				 new Auth_payment().update_column(loggin,v1);
				 new UserServer_Request().invest_table_update(loggin);
				 new UserServer_Request().final_pay(v1,loggin,amount);
				 
			 }
			 else 
					 new UserServer_Request().copy_all_orders(v1);	 //copy all 
			 
			 
			 
			 request.changeSessionId();
			
			 System.out.println(v1+" Execute type ="+y+"   loggin   "+loggin+"    email ="+email);
			 		
			 
			// invalidateSession(request, response);		
			// request_new_id(request);
		}catch (Exception e) {
			request.setAttribute("ErrorMessage",  "Transcation failed  Could not Execute Payment  ! ");
			request.getRequestDispatcher("Error.jsp").forward(request,  response);
			System.out.println(e);
		}
		
	
		
	}

	
	private int return_session_id_form_managed_bean(HttpServletRequest request) {
		  session=request.getSession();
	     String xi=String.valueOf(v1);	   
		 int x= new UserServer_Request().type(xi);
		 System.out.println(" SessionID = "+xi);
		return x;
	}

	
    public void request_new_id(HttpServletRequest request) {
				        HttpSession  session= request.getSession(false);
				        session.invalidate(); 
				        System.out.println("Cleaner");
					
				}
	
    
    public void invalidateSession(HttpServletRequest request,HttpServletResponse  response) {
    	 
    
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
     
        // Delete all the cookies
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
     
                Cookie cookie = cookies[i];
                cookies[i].setValue(null);
                cookies[i].setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
    
	
}
