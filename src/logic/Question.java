package logic;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Question {
	
			String answer;
			
			
		
		public String getAnswer() {
				return answer;
			}



			public void setAnswer(String answer) {
				this.answer = answer;
			}



		public void click_respones() {
			
			
			FacesContext  context=FacesContext.getCurrentInstance();
			int x=Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("a1"));
			
			
			switch (x) {
			case 1:
				setAnswer("  Yes there is"
						+ ""
						+ " ");
				break;
			case 2:
				setAnswer( "The minimum investment fund is 350,000.00 with 7 months 45% investment package.");
				
				break;
			case 3:
				setAnswer(" Federal University of Technology, PMB 1526, Owerri West Local Govt. Area, Imo State, Nigeria"
						+ ""
						+ "");
				break;
			case 4:
				setAnswer(" Yes________       "
						+ " \n\n How do I join?"
						+ "	  Joining is not a big deal,"
						+ "   Click on the register button at the top of our website to register."
						+"   Fill in your details to create your account." 
						+"   Go to the Lemtraco investment page to choose the one you wish to invest on"
						+ "   Select the number of investment units you want to invest and click on investor package"
						+"    Click your shopping cart at the top of the website to review your order"
						+ "     Click checkout"
						+ "     Supply your details including your bank account details"
						+ "     Pay for your order");
				
				
				break;
			case 5:
				setAnswer("Yes. it is registered with CAC under the COMPAINES AND ALLIED MATTERS ACT 1990"
						+ "\n as a limited by share with Registration Company  number: 1704644 and it is insured by AIICO insurance Plc.");
				
				break;
			case 6:
				setAnswer("   99.99%. Every Lemtraco unit is insured. Our insurance partner is AIICO insurance\n"
						+ " Plc. In the event of any unforeseen circumstance which we don't pray for. You will get full refund of your capital\n"
						+ " without any delay");
			
				break;
			case 7:
				setAnswer(" Yes. We would be glad to welcome you.  \n"
						+ "Meanwhile, factory and general business visit are highly organized on periodic"
						+ "\n basis to carter for all. Intending investors will have to put in their notification"
						+ "\n ahead of time at least, three (3) weeks to for a better attention and visiting packages.");
				
				break;
			case 8:
				setAnswer("Otamiri river, Umuchima Village, Ihiagwa Autonomous Community, Owerri West LGA, Imo State, Nigeria.");
				
					break;
				
				case 9:
					setAnswer(" As follow's:  "
							+ "\n  OIL and Gas Marketing,"
							+ "\n  AGRIC BUSINESS,"
							+ "\n  SAND DREDGING,"
							+ "\n  GENERAL CONTRACTOR,"
							+ "\n  GENERAL  CONTRACTS,"
							+ "\n  GENERAL MECHANDISE,"
							+ "\n  IMPORT AND EXPORT OF GENERAL GOODS.");
					break;

				case 10:
					setAnswer(" 210, Okigwe Road, Opposite Glass House Orji Flyover, Owerri, Imo State, Nigeria.");
					
						break;
					
				case 11:
					setAnswer(" Yes. Agric and capital investments with a well packed quarterly gifts for our valuable investors");
					break;
			default:
				break;
			}
			
			
			System.out.println(""+x);
		}
}
