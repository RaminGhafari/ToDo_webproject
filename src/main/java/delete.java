

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
		
		int status = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection connection = null;
		try {
	        DBConnectionGhafari.getDBConnection();
	        connection = DBConnectionGhafari.connection;
	        
	        String queryShow = Query.searchID;
	        PreparedStatement preparedStatement = connection.prepareStatement(queryShow);

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
					
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
			 pw.println("<h2 class='bg-primary text-center text-light card-header'>Deleted Data</h2>");
			 pw.println("<table class='table table-hover table-striped'>");
			 pw.println("<tr>");
			 pw.println("<th>id</th>");
			 pw.println("<th>Title</th>");
			 pw.println("<th>Date</th>");
			 pw.println("<th>Priority</th>");
			 pw.println("<th>Category</th>");
			 pw.println("<th>Status</th>");
			 pw.println("</tr>");
			   		
			 while(rs.next()) {
			    	pw.println("<tr>");
			    	pw.println("<td>" + rs.getInt(1) + "</td>");
			    	pw.println("<td>" + rs.getString(2) + "</td>");
			    	pw.println("<td>" + rs.getString(3) + "</td>");
			    	pw.println("<td>" + rs.getString(4) + "</td>");
			    	pw.println("<td>" + rs.getString(5) + "</td>");
			    	pw.println("<td>" + rs.getString(6) + "</td>");
			    	pw.println("</tr>");
			   		}
			    
			 pw.println("</table>");	
			 pw.println("</div>");
	        
	        
	        
	        String query = Query.delete;
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			status = preparedStatement.executeUpdate();
			
			if(status > 0) {

		        String querySearch = Query.deleteShow;
				PreparedStatement ps = connection.prepareStatement(querySearch);
				ps.setInt(1, id);
				
				rs = ps.executeQuery();
				
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
				
		       
		 		
		 		pw.println("<div style='width:900px;margin:auto;margin-top:50px'>");
		 		pw.println("<h2 class='bg-primary text-center text-light card-header'>Database Data</h2>");
		   		pw.println("<table class='table table-hover table-striped'>");
		   		pw.println("<tr>");
		   		pw.println("<th>id</th>");
		   		pw.println("<th>Title</th>");
		   		pw.println("<th>Date</th>");
		   		pw.println("<th>Priority</th>");
		   		pw.println("<th>Category</th>");
		   		pw.println("<th>Status</th>");
		   		pw.println("</tr>");
		   		
		   		while(rs.next()) {
		    	pw.println("<tr>");
		    	pw.println("<td>" + rs.getInt(1) + "</td>");
		    	pw.println("<td>" + rs.getString(2) + "</td>");
		    	pw.println("<td>" + rs.getString(3) + "</td>");
		    	pw.println("<td>" + rs.getString(4) + "</td>");
		    	pw.println("<td>" + rs.getString(5) + "</td>");
		    	pw.println("<td>" + rs.getString(6) + "</td>");
		    	pw.println("</tr>");
		   		}
		    	pw.println("</table>");	
		    	pw.println("</div>");
				

				
			} else {
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
				
				pw.println("<div style='width:600px;margin:auto;margin-top:50px'>");
				pw.println("<h5 class=\"bg-light text-left text-danger card-header\">ERROR: Invalid Task 'ID'</h5>");
				pw.println("</div>");
		 		request.getRequestDispatcher("delete.html").include(request, response);

			}
			
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
