<%@ page language="java" contentType="text/html;     charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
      
<title>Lemtraco  Review Payment</title>

<link rel="icon" href="Images/logos.png" sizes="40x40" type="image/png"/>

   <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
           crossorigin="anonymous"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<meta name="viewport" content="width=device-width, initial-scale=1"/>
  

<style type="text/css">

	*{
		padding: 0px;
		margin:0px;
		background-color: #EAEAEA;
		}

	form{
		border-radius: 4px; 
		border: 2px solid #fff; 
		width: 50%;
		background:#fff;
		box-shadow: 2px 2px 0px 0px rgba(0,0,0.5); 
		padding: 20px;
		}
			
			
		td{
				background:#fff;
			}
	
			b{
			 background:#fff;
			 }
		
	@media(max-width:1220px){
			
			
				form{
				border-radius: 4px; 
				border: 2px solid #fff; 
				width: 90%;
				background:#fff;
				box-shadow: 2px 2px 0px 0px rgba(0,0,0.5); 
				padding: 20px;
		    	margin-top:50px;
				}
		
			.down{
				border:none; 
				width: 100%; 
				height: 1000px;
				}
				
			
				
				}
</style>


</head>

<body>


<div  align="center">


<h1>Please Review Payment  details Carefully  before Proceeding</h1>

<form   action="execute_payment"   method="post"   >

<table >
			<tr>
				<td    colspan="2"><b>Transaction Details</b></td>
				<td>
				<input    type="hidden"  name="paymentId"  value="${param.paymentId}"/>
				<input    type="hidden"  name="PayerID"  value="${param.PayerID}"/>
				<input  type="hidden"   name="amount"   value="${transaction.amount.details.subtotal}"/>  
				<input  type="hidden"  name="emails"   value="${payer.email}"/>    
				</td>
				</tr>
				
				<tr>
				<td>Description </td>
				<td>${transaction.description}</td>
				</tr>
				
			
				
				
				<tr>
				<td>Subtotal:</td>
				<td>${transaction.amount.details.subtotal}</td>
				</tr>
				
				
				
				<tr>
				<td>Shipping: </td>
				<td>${transaction.amount.details.shipping}</td>
				</tr>
			
			
			
			
		     	<tr>
				<td>Tax: </td>
				<td>${transaction.amount.details.tax}</td>
				</tr>
				
			   <tr>
				<td>Total: </td>
				<td>${transaction.amount.total}</td>
				</tr>
				
				
				
				<tr><td><br/></td></tr>
					<tr>
					<td><b>Customer information : </b></td>
					<td></td>		
					</tr>
					
					
					
					<tr>
					<td>First Name:</td>
					<td>${payer.firstName}</td>
					</tr>
					
					
					<tr>
					<td>Last   Name: </td>
					<td>${payer.lastName}</td>
					</tr>
					
					
					<tr>
						<td>Email:</td>
						<td>${payer.email}</td>
					</tr>
					
				
				
				<tr><td><br/></td></tr>
					<tr>
					<td><b>Shipping Address: </b></td>
					<td></td>		
					</tr>
					
					
					
					<tr>
						<td>Recipient  Name:</td>
						<td>${shippingAddress.recipientName}</td>
					</tr>
					
					<tr>
						<td>Line 1:</td>
						<td>${shippingAddress.line1}</td>
					</tr>
					
					<tr>
						<td>City :</td>
						<td>${shippingAddress.city}</td>
					</tr>
					
					<tr>
						<td>State:</td>
						<td>${shippingAddress.state}</td>
					</tr>
					
					<tr>
						<td>Country Code :</td>
						<td>${shippingAddress.countryCode}</td>
					</tr>
					
					
						<tr>
						<td>Postal Code :</td>
						<td>${shippingAddress.postalCode}</td>
					</tr>
					
					
					
						<tr>
						<td>${credit}</td>
					   </tr>
					   
					    	<tr>
						<td>
			    	<br/>	<br/>
			    	<button    type="submit"   class="btn btn-info aaaButton ">Complete Payment</button>
					</td>
				</tr>		
	     </table>
	</form>
	</div>

							
</body>
</html>
