<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <!DOCTYPE html>
<html>
<head>
	<title>Audit Management System</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style type="text/css">
		*{
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		
		body{
		    font-family: 'Poppins', sans-serif;
		    overflow: hidden;
		    background-color:orange;
		}
		
		.heading{
			text-align: center;
			margin-top: 2%;
		}
		
		.wave{
			position: fixed;
			bottom: 0;
			left: 0;
			height: 100%;
			z-index: -1;
		}
		
		.container{
		    width: 100vw;
		    height: 100vh;
		    display: grid;
		    grid-template-columns: repeat(2, 1fr);
		    grid-gap :7rem;
		    padding: 0 2rem;
		}
		
		.img{
			display: flex;
			justify-content: flex-end;
			align-items: center;
		}
		
		.login-content{
			display: flex;
			justify-content: flex-start;
			align-items: center;
			text-align: center;
			margin-right:480px;
			margin-left:480px;
			margin-bottom:100px;
		}
		
		.img img{
			width: 500px;
		}
		
		form{
			width: 360px;
		}
		
		.login-content img{
		    height: 100px;
		}
		
		.login-content h2{
			margin: 15px 0;
			color: #333;
			text-transform: uppercase;
			font-size: 2.9rem;
		}
		
		.login-content .input-div{
			position: relative;
		    display: grid;
		    grid-template-columns: 7% 93%;
		    margin: 25px 0;
		    padding: 5px 0;
		    border-bottom: 2px solid #d9d9d9;
		}
		
		.login-content .input-div.one{
			margin-top: 0;
		}
		
		.i{
			color: black;
			display: flex;
			justify-content: center;
			align-items: center;
		}
		
		.i i{
			transition: .3s;
			color: black;
			
		}
		
		.input-div > div{
		    position: relative;
			height: 45px;
		}
		
		.input-div > div > h5{
			position: absolute;
			left: 10px;
			top: 50%;
			transform: translateY(-50%);
			color: #999;
			font-size: 18px;
			transition: .3s;
		}
		
		.input-div:before, .input-div:after{
			content: '';
			position: absolute;
			bottom: -2px;
			width: 0%;
			height: 2px;
			background-color: #38d39f;
			transition: .4s;
		}
		
		.input-div:before{
			right: 50%;
		}
		
		.input-div:after{
			left: 50%;
		}
		
		.input-div.focus:before, .input-div.focus:after{
			width: 50%;
		}
		
		.input-div.focus > div > h5{
			top: -5px;
			font-size: 15px;
			color: white;
		}
		
		.input-div.focus > .i > i{
			color: red;
		}
		
		.input-div > div > input{
			position: absolute;
			left: 0;
			top: 0;
			width: 100%;
			height: 100%;
			border: none;
			outline: none;
			background: none;
			padding: 0.5rem 0.7rem;
			font-size: 1.2rem;
			color: #555;
			font-family: 'poppins', sans-serif;
		}
		
		.input-div.pass{
			margin-bottom: 4px;
		}
		
		a{
			display: block;
			text-align: right;
			text-decoration: none;
			color: #999;
			font-size: 0.9rem;
			transition: .3s;
		}
		
		a:hover{
			color: #38d39f;
		}
		
		.btn{
			display: block;
			width: 100%;
			height: 50px;
			border-radius: 1px;
			outline: none;
			border: none;
			background-image: linear-gradient(to bottom, white 0%, orange 100%);
			background-size: 200%;
			font-size: 1.2rem;
			color: 	black;
			font-family: 'Poppins', sans-serif;
			text-transform: uppercase;
			margin: 1rem 0;
			cursor: pointer;
			transition: .5s;
		}
		.btn:hover{
			background-position: right;
			color:green;
		}

		
		
	
	</style>
</head>
<body>
<div class="heading">
	<h1> Audit Management System</h1>
	</div>
	<div class="container">

		<div class="login-content">

			<form:form action="/home" modelAttribute="user" method="post">
				<br><br>
				<!-- <h2 class="title">Welcome</h2> -->
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Username</h5>
           		   		<form:input path="userId" class="input"/>
           		   </div>
           		</div>
           		<div class="input-div pass">
           		
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<form:input type="password" path="password" class="input"/>
            	   </div>
            	   </div>
            	<input type="submit" class="btn" value="Login">
            </form:form>
        </div>
    </div>
   
</body>
 <script type="text/javascript">
	    const inputs = document.querySelectorAll(".input");
	
	
	    function addcl(){
	    	let parent = this.parentNode.parentNode;
	    	parent.classList.add("focus");
	    }
	
	    function remcl(){
	    	let parent = this.parentNode.parentNode;
	    	if(this.value == ""){
	    		parent.classList.remove("focus");
	    	}
	    }
	
	
	    inputs.forEach(input => {
	    	input.addEventListener("focus", addcl);
	    	input.addEventListener("blur", remcl);
	    });

    </script>y
</html>