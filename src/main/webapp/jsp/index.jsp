<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style type="text/css">
div.frame4_1 {
  border:3px solid #ff0000;
  padding:10px;
  background-color:yellow;
}
</style>
</head>
<body>

<div style="margin-top: 5%;margin-left: 100mm;margin-right: 100mm" class="form-box">
<div class="frame4_1">
<form action="/index">
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <!-- <input type="email" class="form-control"  name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"> -->
 <input type="email" class="form-control"  name="email" id="exampleInputEmail1" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div> 


</body>
</html>