package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDImplementations;

@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Create() {}
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try(PrintWriter out = response.getWriter()){
    		
    		String name = request.getParameter("uname");
        	String pw = request.getParameter("pword");
        	String mail = request.getParameter("email");
        	
        	String ag1 = request.getParameter("age");
        	String num1 = request.getParameter("num");
        	int ag = Integer.parseInt(ag1);
        	long num = Long.parseLong(num1);
        	
        	String gen = request.getParameter("gender");
        	
        	HttpSession session = request.getSession();
        	
        	try {
        		
        		CRUDImplementations crud = new CRUDImplementations();		
        		crud.create(name, pw, mail, num, ag, gen);
        		out.println("<html>");
        		out.println("<body>");
        		out.println("<h1>Data Added Successfully</h1>");
        		response.sendRedirect("index.html");
//        		out.println("<a href=\"index.html\">Go back to Homepage</a>");
        		out.println("</body>");
        		out.println("</html>");

        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	
    	}
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
