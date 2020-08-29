<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.FormDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="crud.CRUDImplementations" %>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<title>Select Update</title>
</head>
	<body>
		<%
		int id = Integer.parseInt(request.getParameter("id"));
		CRUDImplementations crud = new CRUDImplementations();
		List<FormDetails> details = crud.retrieve();
        
        for(FormDetails d: details){
        	if(d.getId() == id){
        		%>
        		<div class="container">
	        		<h1 style="font-family: Georgia, 'Times New Roman', Times, serif;">Which details would you like to change in the selected Entry</h1>
	        		<table class="table table-hover">
		                <thead>
		                    <tr>
		                      <th>Id</th>
		                      <th>Username</th>
		                      <th>Password</th>
		                      <th>Email</th>
		                      <th>Contact</th>
		                      <th>Age</th>
		                      <th>Gender</th>
		                      <th>Operations</th>
		                    </tr>
		                </thead>
		                 <tr>
		                	<form action="Update" method="post">
		                	<td><input type="text" id="id" name="id" readonly="readonly" value="<%=d.getId() %>"></td>
		                	<td><input type="text" id="uname" name="uname" value="<%=d.getUname() %>"></td>
		                	<td><input type="text" id="pword" name="pword" value="<%=d.getPword() %>"></td>
		                	<td><input type="text" id="email" name="email" value="<%=d.getEmail() %>"></td>
		                	<td><input type="text" id="num" name="num" value="<%=d.getNum() %>"></td>
		                	<td><input type="text" id="age" name="age" value="<%=d.getAge() %>"></td>
		                	<td><input type="text" id="gender" name="gender" value="<%=d.getGender() %>"></td>
		                	<td><input type="submit" value="Submit"></td>
		                	</form>
		                </tr>
	        		</table>
	        	</div>
        		<% 
        	}
        }
		
		%>
		
		
		
	</body>
</html>