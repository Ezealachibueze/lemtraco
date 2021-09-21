package Payment_zone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Serve.UserServer_Request;
import lemtraco02.DbCon;
import logic.Nav;

public class Auth_payment {

	
	
	@SuppressWarnings("finally")
	protected String member_status(String user1) {
		
		Connection  con=null;
		con= new DbCon().getConnection();
		String cv=null;
		try {
		PreparedStatement  ps=con.prepareStatement("select * from lemtrac_member_registers where email= '"+user1+"' ");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			cv=rs.getString(9);
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			return cv;
		}
			
		}
	

	
	protected long member_balance_check(String user1) {
		long cv=0; 
		Connection  con=null;
		con= new DbCon().getConnection();
		
		try {
		PreparedStatement  ps=con.prepareStatement("select  amount  from lemtraco_invest_package where user_email= '"+user1+"' and  status='Paid' ");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Integer integer=Integer.valueOf((rs.getString("amount")));
			if(integer==null)
				cv=0;
			else
				cv=Long.valueOf(integer);
			
			}
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return  cv;
		
}



	public int  process_order(long amount, String name, String ed) {
		String string=String.valueOf(UUID.randomUUID()).replaceAll("-", "").toUpperCase();
		
	
		new UserServer_Request().notification("Withdrawal Order",name,String.valueOf(amount),ed, string);
	
		int c=	Insert_request(amount,string , name, ed,"Withdrawal", new UserServer_Request().time_save());
	
	caculate_bal(ed,amount);
	
		return c;
	}  
	
	
	
	
	private void caculate_bal(String ed, long amout_to_be_debited) {
		Connection  con=null;
		try {
			con=new DbCon().getConnection();
			PreparedStatement ps=con.prepareStatement("select amount   from lemtraco_invest_package where  user_email='"+ed+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				long jk=rs.getLong("amount"); //amount
				long x=jk-amout_to_be_debited; 
			    ps=con.prepareStatement("update  lemtraco_invest_package   set   amount ="+x+" where  user_email = '"+ed+"'");
			   ps.execute();
			 
			}
			
	    	} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	private int Insert_request(long amounts,String userids,String name1, String email, String type, String time) {
		
		Connection  con=null;
		int x=0;
		try {
			 con=new DbCon().getConnection();
			
			PreparedStatement	  ps1=con.prepareStatement("insert into lemtraco_temporary_package (token,userid,subtotal,shipping,tax,login_user,STATUS1,time_stamp,payment_method) values (?,?,?,?,?,?,?,?,?)");
			ps1.setLong(1, amounts);
     		ps1.setString(2, userids);
			ps1.setInt(3, 0);
     		ps1.setInt(4, 0);
    		ps1.setInt(5, 0);
	    	ps1.setString(6, email);
	    	ps1.setString(7, type);
     		ps1.setString(8, time);
			ps1.setString(9, "PayPal");
			x=200;
			ps1.execute();		
				}catch (Exception e) {
						System.out.println(e);
						x=404;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return x;
	}



	public void update_column(String string, String v1) {
		Connection  con=null;
		con= new DbCon().getConnection();
		try {
				PreparedStatement  ps=con.prepareStatement("update lemtraco_temporary_package set STATUS1=?  where login_user = '"+string+"'  and userid='"+v1+"'");
				ps.setString(1, "paid");
				ps.execute();
				System.out.println("Email ! "+string);
			
				//invest_table_update
		    
		   }catch (Exception e) {
			
		    	System.out.println(e);
		   }
		
		finally {
			try {
				
				con.close();
			
				} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		
	}



	
//	public String confirm(String ed) {
//		Connection  con=null;
//		ResultSet rs=null;
//		con= new DbCon().getConnection();
//		String cv=""; 
//		try {
//			PreparedStatement  ps0=con.prepareStatement(" select sum(token)  as eh  from lemtraco_temporary_package where login_user='"+ed+"'  and  STATUS1='Paid'");
//			   rs=ps0.executeQuery();
//			 while (rs.next()) {
//			    cv=rs.getString("eh");
//				 
//			 }
//			 
//			 if(Integer.getInteger(cv)==null) {
//				 cv="not invested";
//				System.out.println("tried"); 
//			 }
//				 
//			 }catch (Exception e1) {
//					System.out.println(e1);
//				}
//	
//	
//		return cv;
//}



	
	public String confirm_again(String ed) {
		Connection  con=null;
		ResultSet rs=null;
		
		String cv="not invested"; 
		try {
			con= new DbCon().getConnection();
	      	PreparedStatement  ps=con.prepareStatement("select status   from lemtraco_invest_package where user_email= '"+ed+"'");
	    	 rs=ps.executeQuery();
				while (rs.next()) {
					cv=rs.getString("status");//status
						}	
				
			 }catch (Exception e1) {
					System.out.println(e1);
				}
	
				finally {
					try {
						con.close();
					} catch (SQLException e) {
							System.out.println(e);
					}
				}
	
		return cv;
}



	public List<Withdrawal_page> pull_user_balance(String xz) { 
		List <Withdrawal_page>  packing=new ArrayList<>();
		Connection  con=null;
		String x="";
		con= new DbCon().getConnection();
		try { 
		
		PreparedStatement  ps=con.prepareStatement("select  sum(amount) as xx  from  lemtraco_invest_package  where  user_email='"+xz+"' and  status='Paid' ");
		ResultSet  rs=ps.executeQuery();
			while (rs.next()) {
				Withdrawal_page page=new Withdrawal_page(); 
				Integer integer=Integer.valueOf((rs.getString("xx")));
				if(integer==null)
					System.out.println("none");
				else
			     x=	bastard(String.valueOf(integer));
				
				page.setBalance(x);
				packing.add(page);
			//	System.out.println(xz+"  CCC");
		}	
	
				
		}
		 catch (Exception e1) {
				System.out.println(e1);
			}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		return packing;
	}
	
	
 	private   String bastard(String string) {
		long number=Long.valueOf(string);
		NumberFormat nf= NumberFormat.getNumberInstance();
	nf.setMaximumFractionDigits(2);
	
	return  nf.format(number);
}



	public List<Withdrawal_page> pull_user_transcaition_history(String xz) {
		List <Withdrawal_page>  packing=new ArrayList<>();
		Connection  con=null; 
		
		try { 
			con= new DbCon().getConnection();
		PreparedStatement  ps=con.prepareStatement("select  * from  lemtraco_temporary_package  where  login_user='"+xz+"'  order by id desc");
		ResultSet  rs=ps.executeQuery();
			while (rs.next()) {
				Withdrawal_page page=new Withdrawal_page(); 
						
						page.setTransciation_ID(rs.getString(2));
						page.setAmount1(rs.getString(3));
						page.setDate_(rs.getString(9));
						page.setPayment_method(rs.getString(10));
						page.setPaid_To(rs.getString(7));
						page.setStatus(rs.getString(8).toUpperCase());
						packing.add(page);
						
					
			}
			
			if(rs.isLast())
				System.out.println("Ended ! ");
			
		}catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
			
			return packing;
	}



	public int check_account_status(String ed) {
		  Connection  cons=null;
		  int w=0;
		try {
				cons=new DbCon().getConnection();
			PreparedStatement  ps=cons.prepareStatement("select * from  lemtrac_member_registers where user_email='"+ed+"' ");
			ResultSet  rs=ps.executeQuery();
			
			 while (rs.next()) {
				 
				 String db=rs.getString(6);
				 if(db.equals("blocked"))
					 w=400;
				 else
					 w=200;
					 
			 }
		}
			 catch (Exception e) {
				System.out.println(e);
			}
				finally {
					try {
						cons.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
				return w;
	}
}