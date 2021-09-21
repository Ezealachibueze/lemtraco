 <%@page import="logic.*"%>
<%@page import="Serve.UserServer_Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


	<script  type="javascript"   src="folder1/jquery-1.8.3.js"></script>
				<script>
					
				function name() {
					 $('.drops').slideDown("slow");
				}
						
						
						
				function cls() {
				      $('.drops').slideUp("slow"); 
				   }
				</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    
<title>Lemtraco investement</title>
          <script   src="https://kit.fontawesome.com/yourcode.js"></script>
		<link rel="stylesheet"    href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></link>
		<link rel="icon" href="Images/logos.png" sizes="40x40" type="image/png"/>
		  <meta name="viewport" content="width=device-width, initial-scale=1"/>
      
      
      
	


<style type="text/css">
			
			*{
			  padding: 0px;
			  margin: 0px;
			   background: #88DCF2;
			  
				}	
				
	
			    	
			    	
			.drops{
			display: none;
					}
	  
		
			input{
			    border: none;
			    padding: 10px;
			    font-size: 25px;
			    font-family: serif;
				}
				
				
			.heads{
				  height: 80px;
				  width: 100%;
				  border: none;
			}
			
			
			.bots{
				  height:200px;
				  width: 100%;
				  border:none;
				  background: #001075;
			}
	
	
	
		.header_fo{
			background: #fff;
			height: 130px;
			width: 100%;
			box-shadow: 0px 0px 4px 0px  rgba(0,0,0.5);
		
		}


			.io1{
			padding-top:7px;
			float: left;
			margin-left:-120px;
			padding: 2px;
			background: #fff;
			}
			
				.io2{
				display: none;
				}
			
			.inner_banner{
			width: 70%;
			height: 100px;
			margin-top:1px;
			background: #fff;
			}
			
			
			.nav_button{
			float:right;
			width:60%;
			height:40px;
			background: #fff;
			}
			
			
			.children{
			float: right;
			margin: 10px;
			cursor:pointer;
			padding: 5px;
			border:none;
			color:	#000357;
			background:#fff;
			font-family: sans-serif;
			}
			
			
			 a{
				text-decoration: none;
				padding: 5px;
				background: #fff;
				font-size: 15px;
				}
			
				.uppers{
					height: 30px;
					width: 100%;
					background: #001075;
					}
					
				.uppers1{
					display: none;
					}
			
					
			button{
				 background:#1AFF48 ;
				 padding: 10px;
				 border:none;
				 color:#fff;
				 border-radius: 5px;
				 cursor: pointer;
				 float: right;
				}
				
				
			.packag{
					width: 80%; 
					background: #88DCF2;
					 height: 350px; 
				
				}
				
				.fa-facebook-official, .fa-whatsapp, .fa-instagram, .fa-envelope-o, .fa-phone {
						margin-top:5px;
						color:yellow;
						background: #001075;
						font-family: sans-serif;
					}
					
					
				.cus{
						margin-top:5px;
						color:#001075;
						font-family:sans-serif;
						background: #fff;
						font-family: sans-serif;
						font-size: 20px;
					}
						
				
				h3{
						font-size: 2em;
						font-family: sans-serif;
					}
					
					.e3{
						font-size: 1.5em;
						font-family: sans-serif;
					}
					
					.inner_sec{
						border-radius:4px;
						box-shadow: 3px 3px 0px 0px rgb(0,0,0);
						 background: #fff; 
						 width: 50%;
						 height: 350px;
					}
					
					tr td{
					
						background: #fff;
							}
							
			
				
			.rc{
				margin-top:108px;
				margin-left:100px;
				  float: left;
				  background: #fff;
				  color:#001075;
				}
				
			@media(max-width:1220px){
				.bots{
						  width: 100%;
						  border:none;
						width: 100%; 
						height: 200px;
						}
						
				.packag{
					width: 100%; 
					background: #88DCF2;
					 height: 500px; 
				
				}
				
			.io1{
			display: none;
		   }
	
		.rc{
				display: none;
				}
				
     	.io2{
			   display: block;
			   margin-left:-20px;
				float: left;
				padding: 2px;
				background: #fff;
		    }
				
				
		   	.drops{	
		   	position:relative;
				height: 180px;
				 width:100%;
		    	background: #001075;
			}
			
	
					
			.inner_sec{
				border-radius:4px;
				box-shadow: 3px 3px 0px 0px rgb(0,0,0);
				 background: #fff; 
				 width: 100%;
				 height: 350px;
			}
			
			
				.nav_button{
		     	display: none;
			}
				
			.uppers{
			 display: none;
			}
								
		.uppers1{
					display:block;
					height: 30px;
					width: 100%;
					background: #001075;
					}
					
			button{
			float:right;
			margin-right: 10px;
			margin-bottom: 10px;
			}
			
		.pop_child{	
			color:yellow;
			font-size:20px;
			border:none;
			background-color: #001075;
		
			}
			
	  
	}
					
	
			
		@media(max-width: 980px){
				.packag{
					width: 100%; 
					background: #88DCF2;
					 height: 500px; 
				
				}
				
					.inner_sec{
						border-radius:4px;
						box-shadow: 3px 3px 0px 0px rgb(0,0,0);
						 background: #fff; 
						 width: 100%;
						 height: 350px;
						
					}
					
			.close{
				float:right;
				margin-right:20px;
		    	background-color: #001075;
				font-size: 20px;
				color: yellow;
			
			}
			
			.uppers{
		     display: none;
				}
								
				.uppers1{
				display:block;
					height: 30px;
					width: 100%;
					background: #001075;
					}
					
		    	.io1{
					display: none;
				   }
	
		     	.io2{
					   display: block;
					   margin-left:-20px;
						float: left;
						padding: 2px;
						background: #fff;
				    }
					
				button{
					float:right;
					margin-right: 10px;
					margin-bottom: 10px;
					}
					
					
			.pop_child{
				color:yellow;
				font-size:20px;
				border:none;
				background-color: #001075;
			
				}
				
					.rc{
				display: none;
				}
				
				    #bread{
		    		margin-top:10px;
		    		float: right;
		    		margin-right:-10px;
		    		background: #fff;
		    	}
		    	
		   	.drops{	
		   	   	position:relative;
				height: 180px;
				 width:100%;
		    	background: #001075;
			}
		  
				}
			
	</style>
	

	
</head>
<body>
			<div  class="drops">
				<button    class="close"   onclick="cls()">X</button>
				
				
				<div   align="left" style="background-color: #001075;">
				
					   <br></br>
						
					
						<a href="Sign_in.xhtml"      class="children" >Sign in</a>
							 <br></br>			
					
					
						
						 	<a href="business_model.xhtml" class="pop_child">Shop</a>
						  <br></br>
					
					
					
						
							<a href="Contact.xhtml"   class="pop_child"   >FAQs</a>
					  <br></br>
					
					
							<a href="board.xhtml" class="pop_child" >About  Us</a>					
						  <br></br>
				</div>
				
			   	</div>

<div    class="header_fo">


		<label    class="rc">RC: 1704644</label>
							
				
			
			   	
			   	
				<div   class="uppers"    align="center">
				
							<a href=""   class="fa fa-facebook-official">  &nbsp;&nbsp;   lemtracofacebook.com</a>
									&nbsp;	&nbsp;	&nbsp;
									<a href=""   class="fa fa-whatsapp">   &nbsp;&nbsp; +2340903454323</a>
										&nbsp;	&nbsp;	&nbsp;
							     	<a href=""   class="fa fa-instagram">  &nbsp;&nbsp;   lemtracoinstagram.com</a>
							     		&nbsp;	&nbsp;	&nbsp;
								    <a href=""   class="fa fa-envelope-o"> &nbsp;&nbsp;   lemtraco@gmail.com</a>
								    	&nbsp;	&nbsp;	&nbsp;
									<a href=""   class="fa fa-phone">      &nbsp;&nbsp;  Call now  +2345889949334</a>
				
				</div>
				
				
				<div   class="uppers1"    align="center">
				
							<a href=""  class="fa fa-facebook-official">  &nbsp;&nbsp; </a>
									&nbsp;	&nbsp;	&nbsp;
									<a href="" class="fa fa-whatsapp">   &nbsp;&nbsp; </a>
										&nbsp;	&nbsp;	&nbsp;
							     	<a href=""   class="fa fa-instagram">  &nbsp;&nbsp;   </a>
							     		&nbsp;	&nbsp;	&nbsp;
								    <a href=""   class="fa fa-envelope-o"> &nbsp;&nbsp;   </a>
								    	&nbsp;	&nbsp;	&nbsp;
									<a href=""   class="fa fa-phone">      &nbsp;&nbsp; </a>
				
				</div>
						<center   style="background: #fff;">

								<div   class="inner_banner">
										
										<a href="index.xhtml">
										 <img alt="" src="Images/logo.png"    class="io1"/>
										 
										</a>
										
										<a href="index.xhtml"    class="io2"  >
										<img  src="Images/sample.png"/>
										
										</a>
										
									
															
														
										<div   class="nav_button">
										
											
										<a href="Contact.xhtml"   class="children">FAQ's</a>
										
										<a href="board.xhtml"  class="children">About  Us</a>

										<a href="business_model.xhtml"   class="children">  Shop </a>
										
										</div>
										</div>
							</center>
							
							
							
								
				</div>




<%

String c= new   Nav().GETID();

//String driverName = "org.postgresql.Driver";
//String userId="peecodlajaqjnj", 
//password="12a7c1b091e4ab7ddf7f5aaeee12bfa9b2b85a810e43226fad3a44df427561ae",   
//connectionUrl="jdbc:postgresql://ec2-34-200-106-49.compute-1.amazonaws.com:5432/dbojugv37hsk3k?sslmode=require"; 


String driverName = "org.mariadb.jdbc.Driver";
String connectionUrl = "jdbc:mariadb://localhost/lemtrac01";
String userId = "root";
String password = "7h8g2cc";


/**String driverName = "org.mariadb.jdbc.Driver";
String connectionUrl = "jdbc:mariadb://localhost/walexfab_walex01";
String userId = "walexfab_walexuser";
String password = "7h8g2cc";**/

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;


%>
<div   align="center">
<h3   >Order's Review</h3>
</div>

<form action="authorize_payment"   method="post">

<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.prepareStatement("select * from Preview_table  where userid = '"+c+"' ");
resultSet = statement.executeQuery();
while(resultSet.next()){
%>
<center>
<div    class="packag">  
<br/>
<div   class="inner_sec">
<center  style="background: #fff">
		<table  style="background: #fff">
		<tr>
		<td  align="center">
		
		
		<b><input     style=" background: #fff; "    type="text" class="e3"  name="product"  value="Order's payment Review"   readonly="readonly" /></b>
		</td>
		</tr>
		<tr>
		<td>
		<label   class="cus">Sub total:</label> &nbsp;  &nbsp;   <input   style=" background: #fff; "   type="text"  class="e3" name="subtotal"  value="<%=resultSet.getString("subtotal") %>"    readonly="readonly" />
		
		</td>
		</tr>
		
		
		<tr>
		<td>
		 <label  class="cus">Shipping Cost:</label> <input   style=" background: #fff; "   type="text" class="e3"  name="shipping"  value=" <%=resultSet.getString("ships") %>"   readonly="readonly" />
		
		</td>
		</tr>
		
		
		<tr>
		<td>
		   <label class="cus">Tax  Payment:</label><input   style=" background: #fff; "   type="text" class="e3"  name="tax"           value=" <%=resultSet.getString("tax") %>"    readonly="readonly" />
		</td>
		</tr>
		
		<tr>
		<td>
		  <label  class="cus">Calculated Total:  </label>  <input    style=" background: #fff; "  type="text"  class="e3" name="total"         value="<%=resultSet.getString(6) %>"   readonly="readonly" />
		<input   type="hidden"   name="e1"     value="${sess}"></input>
		</td>
		</tr>
		<tr>
		<td>
		</td>
		</tr>
		<tr>
		<td>
		<button    type="submit"   >Check Out</button>
		</td>
		</tr>
		</table>
		</center>
<br/>
</div>

</div>


			

</center>
<% 
}} catch (Exception e) {e.printStackTrace();}


finally{ try{ connection.close(); }catch(Exception  e){e.printStackTrace();}} 
%>
		
</form>
<br/><br/>
<iframe  class="bots"      scrolling="no" ></iframe>

</body>
</html>