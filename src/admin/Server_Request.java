package admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import Serve.Auth02;
import lemtraco02.*;

public class Server_Request {

	
	
				 AmazonS3 s3 = null;
				public void Create_BucketS3() {
					
					AWSCredentials   credentials =new BasicAWSCredentials(Creden.ACCESS_KEY_ID, Creden.ACCESS_SEC_KEY);
					    s3= 
						AmazonS3ClientBuilder
						.standard()
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
					Create_BucketS3();
					 List<Bucket> bucket =s3.listBuckets();
					 
					 for(Bucket  b : bucket) {
						 
					 }
				}
				
	
	
			
			public void Upload_file(String bucket, String key_name,InputStream inputs,  ObjectMetadata meta ) {
					try {
							Create_BucketS3();
							s3.putObject(bucket, key_name,inputs, meta);
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
					Create_BucketS3();
					byte []  by =null;
					S3Object object =  s3.getObject(bucketname, keyname);
					S3ObjectInputStream inputStream=object.getObjectContent();
				     try {
				    	 by=IOUtils.toByteArray(inputStream);
							
						 //by 	=inputStream.readAllBytes();
					} catch (IOException  es) {
						System.out.println(es);
					}
					return   by;
				}
	
	
	 

	
	public int  put_in(String w1, int w2, String n1) {
		
		//   Connection  con=new Mariadb().Connects();
		 Connection   con=null;
				 int a=0;
				try {
					con=new DbCon().getConnection();
					PreparedStatement  ps=con.prepareStatement("insert into uploaded_commondity_lemtraco (price,nameing,pictures)  values(?,?,?)");
					ps.setInt(1, w2);
					ps.setString(2, w1);
					ps.setString(3, n1);
					a=200;
					ps.execute();
					} 
			     catch (SQLException e) {
					System.out.println(e);
					a=404;
					}
						finally {
							try {
								con.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				
				
				return a;
			}


			public String  read_orders() {
				String jk=null;
				   Connection  con=null;
					try {
								//new Mariadb().Connects();
								con= new DbCon().getConnection();
								PreparedStatement  ps=con.prepareStatement("select sum(count)  as jk  from lemtraco_notification  where   now ='New'");
								ResultSet  rs=ps.executeQuery();
								while (rs.next()) {
									jk="+  "+rs.getString("jk");		
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
			  return    jk;
			}



	
			public List<DownloadSsec> view_notifications() {
				Connection  cons=null;
				List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
				
				try {
					
					 //new Mariadb().Connects();
					  cons = new DbCon().getConnection();
							
					PreparedStatement  ps=cons.prepareStatement("select * from  uploaded_commondity_lemtraco  order by id desc");
					ResultSet  rs=ps.executeQuery();
					
					 while (rs.next()) {
						DownloadSsec  sc=new DownloadSsec();
						sc.setId(rs.getString(1));  //id
						sc.setType(rs.getString(2));  //typeb
						packing.add(sc);
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
				return packing;
			 }
	
			
				public List <DownloadSsec>   bastard() {
							
					List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
					
					try {
						Connection	 cons = new DbCon().getConnection();
					
							PreparedStatement  ps=cons.prepareStatement("select * from  lemtraco_notification  order by id desc");
							ResultSet  rs=ps.executeQuery();
							 while (rs.next()) {
								 DownloadSsec  sc=new DownloadSsec();
									sc.setId(rs.getString(1));  //id
									sc.setImg_name(rs.getString(2)); //status
									sc.setPrice(rs.getString(3)); //user_payment_id_pal
									sc.setType(rs.getString(4)); // content aka session
									sc.setWriteup(rs.getString(7)); //email_mail
									sc.setAccount(rs.getString(8));//Transaction ID
									sc.setAccount_number(rs.getString(6)); //now
									packing.add(sc);
							 }
						} catch (SQLException e) {
						System.out.println(e);
					}
					
					return  packing;	
				}
					
			



	
	
	
				public List<DownloadSsec> view_suborders() {
					Connection   cons=null;
					List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
					  //new Mariadb().Connects();
					try {
						cons=new DbCon().getConnection();
						PreparedStatement  ps=cons.prepareStatement("select * from  uploaded_commondity_lemtraco  order by id desc");
						ResultSet  rs=ps.executeQuery();
						
						 while (rs.next()) {
							 
							 DownloadSsec  sc=new DownloadSsec();
								sc.setId(rs.getString(1));  //id
								sc.setPrice(rs.getString(2));  //typeb
								sc.setWriteup(rs.getString(3));  //typeb
								sc.setImg_name(rs.getString(4)); //img paths
								
								packing.add(sc);
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
					return  packing;
				}



					public void clearNotifications() {
						   Connection con=null;
									try {
										  //new Mariadb().Connects();
										 con= new  DbCon().getConnection();
										 PreparedStatement  ps=con.prepareStatement("update  lemtraco_notification set status= ? where status like '%brought%' ");
										 ps.setString(1, "Seen");
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



				public String suminprices(String c) {
										//System.out.println(c);
										
										String jk=null;
										   Connection  con=null;
											try {
														//new Mariadb().Connects();
														con= new DbCon().getConnection();
														PreparedStatement  ps=con.prepareStatement("select sum(total)  as jk  from lemtraco_orders  where userid='"+c+"'");  // where   status   like  '%"+c+"%' 
														ResultSet  rs=ps.executeQuery();
												while (rs.next()) {
													jk=rs.getString("jk");		
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
									return jk;
							}



				public List<DownloadSsec> forgot_pass_list() {
				
						Connection   cons=null;
						List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
						  //new Mariadb().Connects();
						try {
							cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("select * from  forgot_lemtraco_pass where status like '%New%'  order by id desc");
							ResultSet  rs=ps.executeQuery();
							
							 while (rs.next()) {
								 
								 DownloadSsec  sc=new DownloadSsec();
									sc.setId(rs.getString("id"));  //id
									sc.setPrice(rs.getString("emails"));  //typeb
									sc.setWriteup(rs.getString("status"));  //typeb
									sc.setType(rs.getString("timeday"));
									packing.add(sc);
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
						return  packing;
					}



				public List<DownloadSsec> investment_section() {
					Connection   cons=null;
					List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
					  //new Mariadb().Connects();
					try {
						cons=new DbCon().getConnection();
						PreparedStatement  ps=cons.prepareStatement("select * from  lemtraco_temporary_package where STATUS1 = 'paid'  order by id desc");
						ResultSet  rs=ps.executeQuery();
						
						 while (rs.next()) {
							 
							 DownloadSsec  sc=new DownloadSsec();
								sc.setId(rs.getString(1));  //id
								sc.setPrice(rs.getString(2));  //userid
								sc.setWriteup(rs.getString(3));  //token
								sc.setType(rs.getString(7)); //login_user
								sc.setImg_name(rs.getString(8));//status1
								sc.setTime_stamp(rs.getString(9)); //time_stamp
								packing.add(sc);
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
					return  packing;
				
				}



				public List<DownloadSsec> balance_check(String x) {
					Connection   cons=null;
					List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
					  //new Mariadb().Connects();
					try {
							cons=new DbCon().getConnection();
						PreparedStatement  ps=cons.prepareStatement("select * from  lemtraco_invest_package where user_email='"+x+"'  order by id desc");
						ResultSet  rs=ps.executeQuery();
						
						 while (rs.next()) {
							 
							 DownloadSsec  sc=new DownloadSsec();
								sc.setId(rs.getString(1));  //id
								sc.setPrice(rs.getString(2));  //amount
								sc.setWriteup(rs.getString(4));  //email
								sc.setAccount(rs.getString(6));  //account status
								packing.add(sc);
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
					return  packing;
				
				}



				  List<DownloadSsec> Registrated_member() {
					  Connection   cons=null;
						List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
						  //new Mariadb().Connects();
						try {
								cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("select * from  lemtrac_member_registers  order by id desc");
							ResultSet  rs=ps.executeQuery();
							
							 while (rs.next()) {
								 
								 DownloadSsec  sc=new DownloadSsec();
									sc.setId(rs.getString(1));  //id
									sc.setPrice(rs.getString(2));  //email
									sc.setWriteup(rs.getString(3));  //phone
									sc.setTime_stamp(rs.getString(4));  //bankname
									sc.setImg_name(rs.getString(5));  //account_number
									sc.setEmails(rs.getString(6));  //account_name
									sc.setAccount(rs.getString(7));  //Country
									sc.setNumber(rs.getString(9));//loggin
									sc.setAccount_number(rs.getString(10));//time_stamp
									sc.setNumber1(rs.getString(11));//account  blocked
									packing.add(sc);
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
						return  packing;
				}



				public List<DownloadSsec> pulls(Object object, String string) {
					List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
				//	System.out.println(object+" |||   "+string);
					Connection  cons=null;
					try {
							cons=new DbCon().getConnection();
						PreparedStatement  ps=cons.prepareStatement("select * from  lemtraco_notification  where user_email='"+object+"' and status='"+string+"'  order by id desc");
						ResultSet  rs=ps.executeQuery();
						 while (rs.next()) {
							 
							 DownloadSsec  sc=new DownloadSsec();
								sc.setId(rs.getString(1));  //id
								sc.setPrice(rs.getString(2));  //quantity
								sc.setWriteup(rs.getString(3));  //price
								sc.setTime_stamp(rs.getString(7));  //total
								sc.setAccount(rs.getString(9));  //total
								packing.add(sc);
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
					return  packing;
	
				}



				public List<DownloadSsec> read_user_orders(String string) {
				//	System.out.println("  last   "+string);
						  Connection   cons=null;
							List<DownloadSsec>  packing=new ArrayList<DownloadSsec>();
							  //new Mariadb().Connects();
							try {
									cons=new DbCon().getConnection();
								PreparedStatement  ps=cons.prepareStatement("select * from  lemtraco_orders where userid='"+string+"'  order by id desc");
								ResultSet  rs=ps.executeQuery();
								
								 while (rs.next()) {
									 
									 DownloadSsec  sc=new DownloadSsec();
										sc.setId(rs.getString(1));  //id
										sc.setPrice(rs.getString(2));  //quantity
										sc.setWriteup(rs.getString(3));  //price
										sc.setTime_stamp(rs.getString(4));  //total
										sc.setImg_name(rs.getString(5));  //pic_id_lem
										sc.setEmails(rs.getString(6));  //user_id
										sc.setAccount(rs.getString(7));  //ship
										sc.setNumber(rs.getString(8));//tax
										sc.setAccount_number(rs.getString(9));//time_stamp
										packing.add(sc);
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
							return  packing;
			
				}



				public void update(String string2) {
					  Connection   cons=null;
						try {
								cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("update  lemtraco_notification set now='seen'  where id="+Integer.parseInt(string2));
								ps.execute();
						}catch (Exception e) {
							System.out.println(e);
						}
						finally {
							try {
								cons.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
					
				}



				public int disables_user_account(String xc) {
					int z=0;
					  Connection   cons=null;
						try {
								cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("update  lemtrac_member_registers  set flags='blocked'  where email='"+xc+"'");
							z=200;	
							ps.execute();
						}catch (Exception e) {
							System.out.println(e);
							z=404;
						}
						finally {
							try {
								cons.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
					
					 return  z;
				}



				public int enables_user_account(String xc) {
					int z=0;
					  Connection   cons=null;
						try {
								cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("update  lemtrac_member_registers  set flags='Opened'  where email='"+xc+"'");
							z=200;	
							ps.execute();
						}catch (Exception e) {
							System.out.println(e);
							z=404;
						}
						finally {
							try {
								cons.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
					
					 return  z;
				}



				public int authenticate(String user_admin, String passwords_admin) {
				int n=0;
				
				  Connection   cons=null;
					try {
						cons=new DbCon().getConnection();
						PreparedStatement  ps=cons.prepareStatement("select * from lemtraco_admin where user_n='"+user_admin+"'");
						ResultSet  rs=ps.executeQuery();
						if (rs.next()) 
							n=201;
						else
							n=401;
						
					       }catch (Exception e) {
					     	System.out.println(e);
					     	n=402;
				     	}
					finally {
						try {
							cons.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
				
				return  pass_auth(user_admin,passwords_admin,n);
					
				}



				private int pass_auth(String x,String passwords_admin, int a) {
					  Connection   cons=null;
					  int n=0;
					  if(a==201) {
						try {
							cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("select * from lemtraco_admin where  user_n='"+x+"'");
							ResultSet  rs=ps.executeQuery();
							while (rs.next()) {
							
									String xa=rs.getString(3);
									if(new Auth02().decryt(passwords_admin, xa)) {
										DownloadSsec  sec=new DownloadSsec();
										sec.setLoggin(xa);
								     	new Admin_login().name().put("xi", sec);
								    	n=202;
								
								          	}
									else
										n=403;
						    	      }
							
							    }catch (Exception e) {
							     	System.out.println(e);
							     	n=404;
							    		}
										finally {
											try {
												cons.close();
											} catch (SQLException e) {
												System.out.println(e);
											}
										}
					  }
					  else
						  n=405;
					  
					  
					  return  n;
	
				
}



				public int update_admin_credentails(String user_admin, String passwords_admin) {
					  Connection   cons=null;
					  int n=0;
						try {
							cons=new DbCon().getConnection();
							PreparedStatement  ps=cons.prepareStatement("select * from lemtraco_admin where user_n='"+user_admin+"'");
							ResultSet  rs=ps.executeQuery();
							if (rs.next()) 
								n=401;
							else {
								  ps=cons.prepareStatement("insert into lemtraco_admin(user_n,pass_n) values (?,?)");
								  ps.setString(1, user_admin);
								  ps.setString(2, new Auth02().encryt(passwords_admin));
								  n=205;
								  ps.execute();
								
							}
							
						       }catch (Exception e) {
						     	System.out.println(e);
						     	n=402;
					     	}
						finally {
							try {
								cons.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
						return n;
				}



	



			


	

}
