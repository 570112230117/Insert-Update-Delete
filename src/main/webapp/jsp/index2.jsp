<%@page import="com.bru.model.TestBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%
	List<TestBean> list = null;
%>
<%
	list = (List<TestBean>) request.getSession().getAttribute("listUser");
%>
</head>
<body style="margin-top: 5%">
	<form name="welcome" action="" method="post">
			<input type="hidden" name=email id="email">
		<div class="container">
			<table class="table table-bordered">
				<tr>
					<th class="text-center">ลำดับ</th>
					<th class="text-center">email</th>
					<th class="text-center">password</th>
					<th class="text-center">รายละเอียด</th>
					
				</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr class="text-center">
					<td><%=i + 1%></td>
					<td><%=list.get(i).getEmail()%></td>
					<td><%=list.get(i).getPassword()%></td>
					 <td> <a onclick="gotoUpdate('<%=list.get(i).getId()%>')"><span
							class="glyphicon glyphicon-edit"> </span></a> 
							<a onclick="gotoDetele('<%=list.get(i).getId()%>')"><span
							class="glyphicon glyphicon-trash"> </span></a></td>
					 
					
					<%-- <td><a onclick="gotoUpdate(('<%=list.get(i).getEmail()%>')"
					 href="javascript: document.insertForm.submit()"><span
							class="	glyphicon glyphicon-edit"> </span></a> <a
						onclick="gotoUpdate(('<%=list.get(i).getEmail()%>')"><span
							class="glyphicon glyphicon-trash"> </span></a></td> --%>
							
		
				</tr>
				<%
					}
				%>
			</table>

		</div>
		<script type="text/javascript">
			function gotoUpdate(filter) {
				document.getElementById("email").value = filter;
				document.welcome.action="update";
				document.welcome.submit();
			}
			function gotoDetele(filter) {
				document.getElementById("email").value = filter;
				document.welcome.action="delete";
				document.welcome.submit();
			}
		</script>
</form>

</body>
</html>