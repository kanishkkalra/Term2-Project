package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDImplementations;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {}
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	
    	try(PrintWriter out = response.getWriter()){
    		
    		String idstr = request.getParameter("id");
    		
    		int id = Integer.parseInt(idstr);
    		
    		CRUDImplementations crud = new CRUDImplementations();
    		crud.delete(id);
    		out.println("<html>");
    		out.println("<body>");
    		out.println("<h1>Data Deleted Successfully </h1>");
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
