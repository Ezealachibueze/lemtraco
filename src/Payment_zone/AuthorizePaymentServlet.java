package Payment_zone;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.base.rest.PayPalRESTException;

import Serve.UserServer_Request;


/**
 * Servlet implementation class AuthorizePaymentServlet
 */
@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizePaymentServlet() {
  
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  product  =  request.getParameter("product");
		String  subtotal  =  request.getParameter("subtotal");
		String  shipping  =  request.getParameter("shipping");
		String  tax  =  request.getParameter("tax");
		String total =request.getParameter("total");
		
		String ses =request.getParameter("e1");	
		Cookie cookie1=new Cookie("n1", ses);
		cookie1.setHttpOnly(true);  	
      
       
  System.out.println(product+"     "+shipping +"     "+subtotal +"     "+tax +"     "+total);
		
		OrderDetails  orderDetails=new OrderDetails(product, subtotal, shipping, tax, total);

		try {
			String   approvalLink  = new PaymentServices().authorizePayment(orderDetails);
		   response.sendRedirect(approvalLink);   
		} catch (PayPalRESTException e) {
			System.out.println(e);
			
			request.setAttribute("ErrorMessage",  "Transcation failed Pls try again later");
			request.getRequestDispatcher("Error.jsp").forward(request,  response);
		}
		
		
	
	
	}

}
