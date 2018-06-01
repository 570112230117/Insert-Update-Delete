<%@page import="com.bru.model.TestBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%
	TestBean bean = null;
%>
<%
	bean = (TestBean) request.getSession().getAttribute("top");
%>
</head>
<body style="margin-top: 5%">
	<form name="updateForm" action="gotoupdate" method="post">
		<div class="container">
	
		<input type="hidden" value="<%=bean.getId()%>" name="id"> 
		
		
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> <input type="text"
					class="form-control" name="email"	
					value="<%=bean.getEmail()%>">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">password</label> <input type="text"
					class="form-control" name="password"
					value="<%=bean.getPassword()%>">
					
			</div>
			
			<button type="submit" class="btn btn-success">Submit</button>
			

		</div>
	</form>
	

	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>