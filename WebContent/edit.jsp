<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.FormDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="crud.CRUDImplementations" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<style>
		
		form{
            	display: inline;
            }
		
		</style>
		
	</head>
	<body>
	
	<div class="container">
            <h1 style="font-family: Georgia, 'Times New Roman', Times, serif;">Current Entries in the Database</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                      <th>Id</th>
                      <th>Username</th>
                  <!--<th>Password</th> -->
                      <th>Email</th>
                      <th>Contact</th>
                      <th>Age</th>
                      <th>Gender</th>
                      <th>Operations</th>
                    </tr>
                </thead>
                <%
                CRUDImplementations crud = new CRUDImplementations(); 
                List<FormDetails> details = crud.retrieve();
                
                for(FormDetails d: details){
                %>
                <tr>
                	<td><%=d.getId() %></td>
                	<td><%=d.getUname() %></td>
                <!--<td><%=d.getPword() %></td> -->
                	<td><%=d.getEmail() %></td>
                	<td><%=d.getNum() %></td>
                	<td><%=d.getAge() %></td>
                	<td><%=d.getGender() %></td>
                	
                	<td>
                		<form method="post" action="Delete">
                			<input type="hidden" name="id" value="<%=d.getId() %>">
                			<input type="hidden" name="action" value="Delete">
                			<button type="submit" class="btn btn-danger">Delete</button>
                		</form>
                		<form method="post" action="change.jsp">
                			<input type="hidden" name="id" value="<%=d.getId() %>">
                			<input type="hidden" name="action" value="Update">
                			<button type="submit" class="btn btn-warning">Update</button>
                		</form>
                	</td>
                <%} %>
      
            </table>
        </div>
	
	</body>
</html>