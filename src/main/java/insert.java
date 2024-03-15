

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String priority = request.getParameter("priority");
		String category = request.getParameter("category");
		String taskStatus = request.getParameter("status");
		
		
		Connection connection = null;
		try {
	        DBConnectionGhafari.getDBConnection();
	        connection = DBConnectionGhafari.connection;
	        
	        String query = Query.insert;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, date);
			preparedStatement.setString(4, priority);
			preparedStatement.setString(5, category);
			preparedStatement.setString(6, taskStatus);
			
			preparedStatement.execute();
			
	 		pw.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n"
					+ "\r\n"
					+ "<!-- jQuery library -->\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js\"></script>\r\n"
					+ "\r\n"
					+ "<!-- Popper JS -->\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
					+ "\r\n"
					+ "<!-- Latest compiled JavaScript -->\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>");
			
	        
	 		pw.println("<a href=/webproject/index.html>Home</a>");
	 		
	 		pw.println("<div style='width:900px;margin:auto;margin-top:50px'>");
	 		pw.println("<h2 class='bg-primary text-center text-light card-header'>New Inserted Data</h2>");
	 		
	   		pw.println("<table class='table table-hover table-striped'>");
	   		pw.println("<tr>");
	   		pw.println("<th>id</th>");
	   		pw.println("<th>Title</th>");
	   		pw.println("<th>Date</th>");
	   		pw.println("<th>Priority</th>");
	   		pw.println("<th>Category</th>");
	   		pw.println("<th>Status</th>");
	   		pw.println("</tr>");

	    	pw.println("<tr>");
	    	pw.println("<td>" + id + "</td>");
	    	pw.println("<td>" + title + "</td>");
	    	pw.println("<td>" + date + "</td>");
	    	pw.println("<td>" + priority + "</td>");
	    	pw.println("<td>" + category + "</td>");
	    	pw.println("<td>" + taskStatus + "</td>");
	    	pw.println("</tr>");
	    
	    	pw.println("</table>");	
	    	pw.println("</div>");
		
	        connection.close();
	        
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
