package Serve;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import Payment_zone.Withdrawal_page;
import lemtraco02.Creden;
import lemtraco02.DbCon;
import logic.Nav;
import logic.Shop_views;
import logic.Sing;
import logic.Sub_total_caculate;
public class UserServer_Request {

	
	
	 AmazonS3 s3 = null;
	public void Create_BucketS3() {
		AWSCredentials   credentials =new BasicAWSCredentials(Creden.ACCESS_KEY_ID, Creden.ACCESS_SEC_KEY);
		    s3= 
			AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(Regions.US_EAST_2)
			.build();
			    
			  if(!s3.doesBucketExistV2(Creden.bucket)) {
			  try {
				    s3.createBucket(Creden.bucket);
			  }catch (Exception e) {
				    System.out.println(e);
			}
			  
			  }
		}
	
			public void List_Bucket() {
		
				 List<Bucket> bucket =s3.listBuckets();
				 
				 for(Bucket  b : bucket) {
					 
				 }
			}
	
	
				public void Upload_file(String bucket, String key_name, InputStream  file_path, ObjectMetadata bs) {
					try {
						Create_BucketS3();
						//	s3.putObject(bucket, key_name,new File(file_path));
							s3.putObject(bucket, key_name, file_path,bs );
						}catch (Exception  e) {
								System.out.println(e );
				}
				
			}




			public void delete_single_item(String bucket_name, String object_key) {
					try {		
						Create_BucketS3();
							s3.deleteObject(bucket_name, object_key);
						}catch (AmazonServiceException e) {
							System.out.println(e);
						}
			}


		public void delete_bucket(String bucket_name) {
			
			try {		
				Create_BucketS3();
					s3.deleteBucket(bucket_name);
				}catch (AmazonServiceException e) {
					System.out.println(e);
				}
		}




			public byte [] read_img(String bucketname, String keyname) {
				byte[]  by =null;
				Create_BucketS3();
				S3Object object = s3.getObject(bucketname, keyname);
				S3ObjectInputStream inputStream=object.getObjectContent();
			   try {
				 by=IOUtils.toByteArray(inputStream);
				//  IOUtils.copy(objectContent, new FileOutputStream("D://upload//test.jpg"));  //for downloads	
				 //by=inputStream.readAllBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
				return   by;
			}


 
	
	  Connection  cons=null;
	
//			public byte[] read_bytes(int x) {
//				byte fx [] =null;
//				   cons =  new DbCon().getConnection(); 
//				   
//				   try {
//					PreparedStatement  ps= cons.prepareStatement("select  * from uploaded_commondity_lemtraco   where id = "+x);
//					ResultSet  rs=ps.executeQuery();
//					while (rs.next()) {
//					       	fx =rs.getBytes("pictures");
//					}
//				} catch (SQLException e) {
//					System.out.println(e);
//				}
//				   finally {
//					try {
//						cons.close();
//					} catch (SQLException e) {
//							System.out.println(e);
//					}
//				}
//				return fx;
//			}




			public List<Shop_views> first_pull() {
				 Connection  cons =null;
				   List<Shop_views>  pack  = new ArrayList<Shop_views>();
				   
				   try {
					   cons =  new DbCon().getConnection(); 
						  
					PreparedStatement  ps= cons.prepareStatement("select  * from uploaded_commondity_lemtraco  order by id desc  limit 10");
					ResultSet  rs=ps.executeQuery();
					while (rs.next()) {
						
						Shop_views  views = new Shop_views();
						
						views.setId(rs.getString(1));  //id
						views.setPrice(rs.getString(2));  //price
						views.setWriteUp(rs.getString(3));  //nameing
						views.setPics_id(rs.getString(4)); //pic name
					
						pack.add(views);
						
					
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
				   finally {
						try {
							cons.close();
						} catch (SQLException e) {
								System.out.println(e);
						}
					}
				return pack;
			}



			
			
			public List<Shop_views> send_out() {
				 Connection  cons =null;
				   List<Shop_views>  pack  = new ArrayList<Shop_views>();
				   cons =  new DbCon().getConnection(); 			   
				   try {
					PreparedStatement  ps= cons.prepareStatement("select  * from uploaded_commondity_lemtraco   where  id ="+new Sing().getId());
					ResultSet  rs=ps.executeQuery();
					while (rs.next()) {
						
						Shop_views  views = new Shop_views();
						
						views.setId(rs.getString(1));  //id
						views.setPrice(rs.getString(2));  //price
						views.setWriteUp(rs.getString(3));  //nameing
						views.setPics_id(rs.getString(4)); //Quantity
						
						pack.add(views);
						
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
				   finally {
						try {
							cons.close();
						} catch (SQLException e) {
								System.out.println(e);
						}
					}
				  
				return pack;
			}


			

 
			public void item_drop_in(int x, long in, long d, String id, String string) {
			Connection  con=null;
					con=  new DbCon().getConnection();
			PreparedStatement ps;
			String create_table="create table if not exists "+createTable()+"(id serial ,quantity  int,price int, total  bigint,pic_id_lem varchar(200),userid varchar(200),ship int,tax int);";
					try {
					Statement stmt=con.createStatement();
					stmt.execute(create_table);
					System.out.println("table created");
				ps = con.prepareStatement("insert into "+createTable()+"(quantity,price,total,pic_id_lem,userid,ship,tax)   values  (?,?,?,?,?,?,?)");
			
			      ps.setInt(1, x);
			      ps.setLong(2, in);
			      ps.setLong(3, d);
			      ps.setString(4, id);
			      ps.setString(5, string);
			      ps.setInt(6, 0);    
			      ps.setInt(7, 0);
			      ps.execute();
				
			} catch (SQLException e) {
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




			public List<Shop_views> view_product(String string) {
				Connection  con=null;
				con=  new DbCon().getConnection();
				List <Shop_views>  packing = new ArrayList<Shop_views>();
						PreparedStatement ps;
						try {
							ps = con.prepareStatement("Select *  from  lemtrac_orders where userid  like '%"+string+"%'");
						ResultSet rs=ps.executeQuery();
						while(rs.next()) {
							Shop_views  view=new Shop_views();
							view.setQuantity(rs.getString(2)); //Quantity
							view.setPrice(rs.getString(3)); //Price
							view.setTotal(rs.getString(4)); //Total
							view.setPics_id(rs.getString(5)); //Quantity
							
							packing.add(view);	
						      
						}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
				
		return    packing;
			}

			public List<Shop_views> view_orders(String id) {
				Connection  con=null;
				con=  new DbCon().getConnection();
				List <Shop_views>  packing = new ArrayList<Shop_views>();
						PreparedStatement ps;
						try {
							ps = con.prepareStatement("select *  from  "+createTable()+" order by id desc ");
						ResultSet rs=ps.executeQuery();
						while(rs.next()) {
							Shop_views  view=new Shop_views();
							view.setId(rs.getString(1));//id
							view.setQuantity(rs.getString(2)); //Quantity
							view.setPrice(rs.getString(3)); //Price
							view.setTotal(rs.getString(4)); //Total
							view.setPics_id(rs.getString(5)); //Quantity
							
							packing.add(view);	
						      
						}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
				
		return    packing;
			}

//			public int push_new_members(String user, String phone, String password) {
//				int v =0;
//				Connection  con=null;
//				PreparedStatement ps=null ;
//				con=  new DbCon().getConnection();
//						try {
//								 ps=con.prepareStatement("insert into lemtrac_member_registers values  ('"+user+"','"+phone+"',crypt('"+password+"',gen_salt(md5)))");
//								 v=1;
//								 ps.execute();
//						}catch (Exception e) {
//							System.out.println(e);
//							v=2;
//						}
//						finally {
//							try {
//								con.close();
//							} catch (SQLException e) {
//								System.out.println(e);
//							}
//				
//						}
//						
//			return v;}

			
			

			public int register_user(String user, String working, String password, String bankname, String accounts, String acount_holder_name, String cout) {
			
			
			
		    	
				int x=0;
				  Connection  con=null;
					try {
								//new Mariadb().Connects();
							String string=time_save();
								con= new DbCon().getConnection();
								PreparedStatement  ps=con.prepareStatement("insert into lemtrac_member_registers(email,phone,bankname,account_character,account_holder_name,country,passwords,loggin,time_stamp_when,flags)  values (?,?,?,?,?,?,?,?,?,?)");
								ps.setString(1, user.toLowerCase());
								ps.setString(2, working);
								ps.setString(3, bankname);
								ps.setString(4, accounts);
								ps.setString(5, acount_holder_name);
								ps.setString(6, cout);
								ps.setString(7, new Auth02().encryt(password));
								ps.setString(8, "false");
								ps.setString(9, string);
								ps.setString(10, "Opened");
								x=1;       
								ps.execute();
									}catch (Exception e) {
										
										System.out.println(e);
										
										int x1=String.valueOf(e).indexOf(":");
											
											String x2=String.valueOf(e).substring(0, x1);
											
											if(x2.equals("java.sql.SQLIntegrityConstraintViolationException"))
													x=404;
										else
											x=2;
														System.out.println(x2);
									}
									finally {
										try {
											con.close();
										} catch (SQLException e) {
											e.printStackTrace();
										}
									}
								return x;
			}

			public int authenticate_User(String user, String password) {
		
							
									String string=null;
									Connection  con=null;
									PreparedStatement ps=null ;
									ResultSet rs=null;
									con=  new DbCon().getConnection();
											try {
												 ps=con.prepareStatement("select * from  lemtrac_member_registers  where email ='"+user+"'");
												   rs=ps.executeQuery();
												 while (rs.next()) {
													
													 string=rs.getString(8);
											//		 System.out.println(string);
													 
														FacesContext   context = FacesContext.getCurrentInstance();
												        HttpSession  session1= (HttpSession) context.getExternalContext() .getSession(false);
												        session1.setAttribute("keys", user);
												}
												 	
											
									
													 ps.execute();
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
											
								return  password(string,password,user);}
			

			
			
			
			 private int password(String string, String pass, String user1) {
					int v =0;
					
				   Connection  con=null;
					PreparedStatement ps=null ;
					ResultSet rs=null;
					con=  new DbCon().getConnection();	 
					String z=null;
					
					
				//	 System.out.println(string);
					 
			 try {
				 ps=con.prepareStatement("select * from  lemtrac_member_registers  where  passwords = '"+string+"'");
				   rs=ps.executeQuery();
				 while (rs.next()) {
					
					 z=rs.getString(8);
					 
					 if(new Auth02().decryt(pass, z)) {
						 
						 String vs=rs.getString("email");
						 Map<String, Object>  session=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
						 Withdrawal_page page=new Withdrawal_page();
						page.setUser(vs);
						page.setLoggin_status("Sign out");
						session.put("status1", page);
						member_status(user1);
					
				    	v=1;
					 }
					 else
						 v=3;
					 }
					 }catch (Exception e) {
					System.out.println(e);
					v=2;
					}
			 
					 finally {
						try {
							con.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
			 
			 return v;
				
			}

			 
			 
			private void member_status(String user1) {
				
					Connection  con=null;
					con= new DbCon().getConnection();
					
					try {
					PreparedStatement  ps=con.prepareStatement("update 	lemtrac_member_registers set  loggin='true' where email='"+user1+"'");
					ps.execute();
					
					
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
			
						
			}

			
			
			
			public int review_question(String names, String working, String user) {
				 int x =0;
				  Connection  con=null;
					try {
						//new Mariadb().Connects();
						con= new DbCon().getConnection();
						PreparedStatement  ps=con.prepareStatement("insert into lemtraco_question_reviews(email,phone,name)   values (?,?,?)");
						ps.setString(1, names);
						ps.setString(2, working);
						ps.setString(3, user);
						x=1;
						ps.execute();
						
					}catch (Exception e) {
					System.out.println(e);
					x=2;
					}
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				return x;
			}

			 
			 
				public String createTable() {
					String c,b;
					b= new Nav().GETID();
					c="K".concat(b.concat("M"));
					return c;
				}

				public String sum_in(String string) {
					  Connection  con=null;
					  
					  String g=null;
						try {
							con= new DbCon().getConnection();
							PreparedStatement  ps=con.prepareStatement("select sum(total) as tota  from "+createTable()+" where userId like '%"+string+"%'");
								
							ResultSet rs=ps.executeQuery();
							while (rs.next()) {
								
								g=rs.getString("tota");
							}
						}catch (Exception e) {
							System.out.println(e);
						}finally {
							try {
								con.close();
							} catch (SQLException e) {
								System.out.println(e);
								e.printStackTrace();
							}
						}
					return g;
				}
	
				
				
				public void drop_item(int s) {
					
					  Connection  con=null;
					try {
						con= new DbCon().getConnection();
						PreparedStatement  ps=con.prepareStatement("delete from  "+createTable()+" where id="+s);
						ps.executeQuery();
						new Sub_total_caculate().sums();	
						
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
				
				
				
				

			

				public void add_user_investment_selection(int integer, String price1, String eds, String string5) {
					String time= time_save();
					Connection  con=null;
					  try {
						  con= new DbCon().getConnection();
						
						  PreparedStatement ps=con.prepareStatement("select * from lemtraco_temporary_package where  userid = '"+price1+"'");
							ResultSet rs=ps.executeQuery();
							if(rs.next()) { 
								String v=rs.getString(1);
							//	System.out.println("One"+v);
							   PreparedStatement	  ps0=con.prepareStatement("update   lemtraco_temporary_package set id="+v+",userid='"+price1+"',token="+integer+",subtotal="+0+",shipping="+0+",tax="+0+",payment_method='"+string5+"'  where id= "+v);
							   ps0.execute();
								
							}
							else {
							//	System.out.println("Two");
							PreparedStatement	  ps1=con.prepareStatement("insert into lemtraco_temporary_package (token,userid,subtotal,shipping,tax,login_user,STATUS1,time_stamp,payment_method) values (?,?,?,?,?,?,?,?,?)");
							ps1.setInt(1, integer);
							ps1.setString(2, price1);
							ps1.setInt(3, 0);
							ps1.setInt(4, 0);
							ps1.setInt(5, 0);
							ps1.setString(6, eds);
							ps1.setString(7, "not Paid");
							ps1.setString(8, time);
							ps1.setString(9, string5);
							invest_table(integer,price1,eds);
							ps1.execute();
						
							}
						}catch (Exception e) {
							System.out.println("s"+e);
						}
						finally {
							try {
								con.close();
							} catch (SQLException e) {
								System.out.println("X"+e);
							}
						}
					  
					 payment_type("investment",new Nav().GETID());
					
				}

			

				public void add_in(String v, String e2) {
				//	System.out.println("XXX "+v );
					
					Connection  con=null;
					con=new DbCon().getConnection();
					try {
						PreparedStatement ps=con.prepareStatement("update "+createTable()+" set ship="+v+" where userid like '%"+e2+"%'");
						ps.execute();
						ready_orders(e2);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally {
						try {
							con.close();
						} catch (SQLException e) {
							System.out.println("X"+e);
						}
					}
					
				}

			
				
				
				private void ready_orders(String e3) {
					Connection  con=null;
					con=new DbCon().getConnection();
					try {
			
						PreparedStatement  ps=con.prepareStatement("select sum(total) as tot from "+createTable()+"");
						ResultSet rs=ps.executeQuery();
						while (rs.next()) {
							shipping_check(rs.getString("tot"),e3);
						}
						
						
					}catch (Exception e) {
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

				private void shipping_check(String string, String e4) {
					Connection  con=null;
					con=new DbCon().getConnection();
					String h=null,ids=null;
					try {
						
						PreparedStatement  ps=con.prepareStatement("select * from  "+createTable()+"");
						ResultSet rs=ps.executeQuery();
						while (rs.next()) {
							 ids=rs.getString(1);//id
							 h=rs.getString(7);//ship
							}
							inset_back(ids,h,string,e4); 
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

				private void inset_back(String id, String shipping, String sub_totals,String userid) {
					
						int x=Integer.valueOf(id); long x1=Long.valueOf(shipping); 	long x2=Long.valueOf(sub_totals); long cc=x1+x2;
						System.out.println(x);
							Connection  con=null;
						    	con=new DbCon().getConnection();
									try {
										
										  PreparedStatement ps=con.prepareStatement("select * from Preview_table where  userid = '"+userid+"'");
											ResultSet rs=ps.executeQuery();
											if(rs.next()) { 
												String v=rs.getString(1);
												System.out.println("One");
											   PreparedStatement	  ps0=con.prepareStatement("update   Preview_table set id="+v+",userid='"+userid+"',ships="+x1+",subtotal="+x2+",tax="+0+",totals="+cc+"  where id= "+v);
											   ps0.execute();
												
											}
											else
											{
												System.out.println("Two");
													PreparedStatement 	ps1 = con.prepareStatement("insert into Preview_table (ships,subtotal,userid,tax,totals)   values  (?,?,?,?,?)");
													ps1.setLong(1, x1);
													ps1.setLong(2, x2);
													ps1.setString(3, userid);
													ps1.setInt(4, 0);
													ps1.setLong(5, cc);
													ps1.execute();
											}
									} catch (SQLException e) {
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
				
				
				
				
				public void logout(String c) {
					Connection  con=null;
			    	con=new DbCon().getConnection();
						try {
							
							  PreparedStatement ps=con.prepareStatement("update  lemtrac_member_registers set  loggin='false'  where  email = '"+c+"'");
						    	ps.execute();
						    	
						    	 Map<String, Object>  session=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
						    	 Withdrawal_page page=new Withdrawal_page();
						    	 page.setUser("");	
						    	 page.setLoggin_status("Sign in");
						    	 session.put("status1", page);
						    	 new Nav().request_new_id();
						    	
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
				
				
				
				public String payment_(String e3) {
					  Connection  con=null;
					  String c=null;
					  try {
						  con= new DbCon().getConnection();
						
						  PreparedStatement ps=con.prepareStatement("select * from user_spot  where  userid = '"+e3+"'");
							ResultSet rs=ps.executeQuery();
							if(rs.next()) { 
								
								c=rs.getString(3);
							}
							
					  }catch (Exception e) {
						// TODO: handle exception
					}
					  finally {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					  return c;
				}


				public void payment_type(String string, String e3) {
					  Connection  con=null;
					  try {
						  con= new DbCon().getConnection();
						
						  PreparedStatement ps=con.prepareStatement("select * from user_spot  where  userid = '"+e3+"'");
							ResultSet rs=ps.executeQuery();
							if(rs.next()) { 
								String v=rs.getString(1);
							//	System.out.println("One"+v);
							   PreparedStatement	  ps0=con.prepareStatement("update   user_spot set id="+v+",userid='"+e3+"',waves='"+string+"'  where id= "+v);
							   ps0.execute();
								
							}
							else {
							//	System.out.println("Two");
							PreparedStatement	  ps1=con.prepareStatement("insert into user_spot (userid,waves) values (?,?)");
							ps1.setString(1, e3);
							ps1.setString(2, string);
							ps1.execute();
						
							}
						}catch (Exception e) {
							System.out.println("s"+e);
						}
						finally {
							try {
								con.close();
							} catch (SQLException e) {
								System.out.println("X"+e);
							}
						}
					
				}

				public void copy_all_orders(String x) {
					String c="K".concat(x.concat("M"));
					Connection con=null;
					try {
						
						con=new DbCon().getConnection();
						PreparedStatement pst=con.prepareStatement("select * from "+c+"");
						ResultSet rs=pst.executeQuery();
						 while (rs.next()) {
							Send_in(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), new Nav().time_save(),c);
							
						System.out.println(c);
						 }
							if(rs.getFetchSize()==0) {
								drops(c);
								System.out.println("table droped  ! ");
							}
							
					}catch (Exception e) {
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
				private void Send_in(String ed,String quantity,String price, String total,   String pic_id_lem, String userid, String ship,String  tax,String time,String h) {
					Connection con=null;
					try {
						
						con=new DbCon().getConnection();
						PreparedStatement pst=con.prepareStatement("insert into lemtraco_orders  (quantity,price,total,pics_id_lem,userid,ship,tax,times) values(?,?,?,?,?,?,?,?)");
						pst.setString(1, quantity);
						pst.setString(2, price);
						pst.setString(3, total);
						pst.setString(4, pic_id_lem);
						pst.setString(5,userid);
						pst.setString(6, ship);
						pst.setString(7, tax);
						pst.setString(8, time);
						pst.executeUpdate();
						delete(ed,h);
					}catch(Exception e) {
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

		
			
				private void delete(String id,String table) {
					Connection con1=null;
					try {
						
						con1=new DbCon().getConnection();
						PreparedStatement pst=con1.prepareStatement("delete from  "+table+" where  id="+id);
						pst.execute();
					
					}catch (Exception e) {
						System.out.println(e);
					}
					finally {
						try {
							con1.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
				
				private void drops(String table) {
					Connection con1=null;
					try {
						
						con1=new DbCon().getConnection();
						PreparedStatement pst=con1.prepareStatement("drop table   "+table+"");
						pst.execute();
					
					}catch (Exception e) {
						System.out.println(e);
					}
					finally {
						try {
							con1.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}

			
				public void notification(String type, String name_session, String content, String ed, String string1) {
					Connection  con=null;

					
					
					try {
						con= new DbCon().getConnection();
							PreparedStatement  ps=con.prepareStatement("insert into lemtraco_notification(status,user1,content,count,now,user_email,Trans_id,time_zone) values(?,?,?,?,?,?,?,?)");
							ps.setString(1, type);
							ps.setString(2, name_session);
							ps.setString(3, content);
							ps.setInt(4, 1);
							ps.setString(5,"New");
							ps.setString(6, ed);
							ps.setString(7, string1);
							ps.setString(8, time_save());
							ps.execute();
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
				
				
				
				
				public int type(String xi) { 
					   Connection  con=null; 
					   int c=0;
					   
						try {
									//new Mariadb().Connects();
									con= new DbCon().getConnection();
									PreparedStatement  ps=con.prepareStatement("select waves from user_spot  where userid= '"+xi+"'"); 
									ResultSet  rs=ps.executeQuery();
									if(rs.next()) {
										String k=rs.getString("waves");
										if(k.equals("Orders"))
											c=1;
										else
											c=2;
											
									}
										
						}catch (Exception e) {
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
					return c;
				}

				
				
				
				
				public String quick_check(String v1) {
					   Connection  con=null; 
					   String c="";
						try {
									//new Mariadb().Connects();
									con= new DbCon().getConnection();
									PreparedStatement  ps=con.prepareStatement("select  * from lemtraco_temporary_package where userid='"+v1+"'"); 
									ResultSet  rs=ps.executeQuery();
									if(rs.next()) {
										c=rs.getString(7); //login_user   email;		 
									}
										
						}catch (Exception e) {
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
					return c;
				}
				

				
			    public  String time_save(){
			        String o=null;
			     ZonedDateTime z= ZonedDateTime.now();
			     LocalTime time= LocalTime.now();
			     int g=z.toString().indexOf("[");
			     int c=z.toString().indexOf("]");
			     int d=z.toString().indexOf("T");
			     String q=z.toString().substring(g+1, c);
			     for(String h : ZoneId.getAvailableZoneIds()){ 
			       if(h.equals(q)){        
			            o=(z.toString().substring(0,d).concat("     "+time.toString().substring(0, 5)));
			             break; 
			       }  }
			 return  o;}
			    
			    
			    

				private void invest_table(int integer, String trans_id, String eds) {
					Connection  con=null;
					PreparedStatement ps1=null;
					try {
						 con= new DbCon().getConnection();
						   ps1=con.prepareStatement("select * from lemtraco_invest_package where  user_email = '"+eds+"'");
							ResultSet rs=ps1.executeQuery();
							if(rs.next()) { 
								String v=rs.getString(1);
								long x=rs.getLong(2);
								System.out.println("Executed this  ! ");
	
							}
							else {
						  
						    ps1=con.prepareStatement("insert into lemtraco_invest_package(amount,trans_id,user_email,status) values(?,?,?,?)");
							ps1.setInt(1, 0);
							ps1.setString(2, trans_id);
							ps1.setString(3, eds);
							ps1.setString(4, "Not Paid");
							ps1.execute();
						
						}
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
				
			
			
				//invest_table_update
				
				
				public void invest_table_update(String loggin) {
					Connection  con=null;
					
					try {
						   con= new DbCon().getConnection();
							PreparedStatement  ps=con.prepareStatement("update  lemtraco_invest_package   set status=?  where    user_email='"+loggin+"' ");
							ps.setString(1, " Paid");
							ps.execute();
							System.out.println("Email 2 ! "+loggin);
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
				
			    
			     
			     public void usercache(String c) {
			    	 Map<String, Object>  session=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			    	 Withdrawal_page page=new Withdrawal_page();
						page.setUser(c);	
			    	    session.put("status", page);
				}
			     
			     
			     
			 
				public void final_pay(String c, String email, String amount) {
			    	
			    	   
   		                
				   	Connection  con = null;	
				      	try {
				      		con=new DbCon().getConnection();
				      		PreparedStatement  ps1=con.prepareStatement("select * from lemtraco_invest_package where  user_email = '"+email+"'");
							ResultSet rs=ps1.executeQuery();
							if(rs.next()) { 
								String v=rs.getString(1);
								long  balance=rs.getLong(2);
								
							       long ids = Long.valueOf(v);
							       long amount_to_be_credited = Math.round(Double.valueOf(amount));
							       long z=amount_to_be_credited+balance;
								
							       PreparedStatement   ps2=con.prepareStatement("update   lemtraco_invest_package set id="+ids+", trans_id='"+c+"', amount="+z+", status='Paid' where id= "+Integer.parseInt(v));
								   ps2.execute();
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

				public void forgot_pass_email(String string1) {
					
				   	Connection  con = null;	
			      	try {
			      		con=new DbCon().getConnection();
			      		PreparedStatement  ps1=con.prepareStatement("insert into forgot_lemtraco_pass(emails,status,timeday)  values(?,?,?) ");
			      		ps1.setString(1, string1);
			      		ps1.setString(2, "New");
			      		ps1.setString(3,time_save());
			      		ps1.executeQuery();
			      	}catch (Exception e) {
						System.out.println(e);
					}
			      	finally {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
						
							
					
				}
}
