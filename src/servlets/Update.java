package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDImplementations;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {}
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try(PrintWriter out = response.getWriter()){
    		
    		String name = request.getParameter("uname");
        	String pword = request.getParameter("pword");
        	String email = request.getParameter("email");
        	
        	String ag1 = request.getParameter("age");
        	String num1 = request.getParameter("num");
        	int age = Integer.parseInt(ag1);
        	long num = Long.parseLong(num1);
        	
        	String gender = request.getParameter("gender");
    		
    		String idstr = request.getParameter("id");
    		
    		int id = Integer.parseInt(idstr);
    		
    		CRUDImplementations crud = new CRUDImplementations();
    		crud.update(id, name, pword, email, num, age, gender);
    		out.println("<html>");
    		out.println("<body>");
    		out.println("<h1>Updated Successfully of id - "+id+"</h1>");
    		out.println("<a href=\"index.html\">Go Back to Home Page</a>");
    		out.println("</body>");
    		out.println("</html>");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
