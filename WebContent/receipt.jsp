<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

  <meta name="viewport" content="width=device-width, initial-scale=1"/>
      
<title>Lemtraco  Payment  Complete</title>


   <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
           crossorigin="anonymous"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<link rel="icon" href="Images/logos.png" sizes="40x40" type="image/png"/>
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
		width: 70%;
		height:300px;
		padding: 20px;
		background:#fff;
		box-shadow: 2px 2px 0px 0px rgba(0,0,0.5); 
			}
			
		a{
		height:30px;
		text-decoration:none;
		 background: #fff;
		 padding: 10px;
		 border:none;
		 border-radius: 5px;
		}
		
		td{
		background-color:#fff;
		border-color: #fff;
			}
			
		b{
		background:#fff;
			}
			
			
			
		@media(max-width:1220px){
			.down{
				border:none; 
				width: 100%; 
				height: 1000px;
				}
				
				
					form{
				border-radius: 4px; 
				border: 2px solid #fff; 
				width: 90%;
				height:300px;
				padding: 20px;
				background:#fff;
				margin-top:100px;
				box-shadow: 2px 2px 0px 0px rgba(0,0,0.5); 
					}
			
				}
				
</style>
</head>
<body>


<div  align="center">


<h1>Payment Completed  Welcome  On board.</h1>

<form >

<table  >
			<tr>
				<td><b>Company</b></td>
				<td><b>Lemtraco  international Limited</b></td>
				</tr>
				
				<tr>
				<td>Name: </td>
				<td>${payer.firstName}  ${payer.lastName}</td>
				</tr>
				
				<tr>
				<td>Description :</td>
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
				<td>
				<a href="index.xhtml"    class="btn btn-info aaaButton ">Home</a>
				</td>
			</tr>		
</table>

</form>
</div>
							
</body>
</html>
