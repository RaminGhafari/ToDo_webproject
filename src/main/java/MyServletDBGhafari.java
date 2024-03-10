

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServletDBGhafari
 */
@WebServlet("/MyServletDBGhafari")
public class MyServletDBGhafari extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletDBGhafari() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection connection = null;
		try {
	        DBConnectionGhafari.getDBConnection();
	        connection = DBConnectionGhafari.connection;
	         
	        String query = "SELECT * from ToDoTable";
			Statement stm = connection.createStatement();

				
			ResultSet rs = stm.executeQuery(query);
				
			while (rs.next()) {
					
					System.out.println("  id       = " + rs.getInt(1));
					System.out.println("  Title    = " + rs.getString(2));
					System.out.println("  Date     = " + rs.getString(3));
					System.out.println("  Priority = " + rs.getString(4));
					System.out.println("  Category = " + rs.getString(5));
					System.out.println("  Status   = " + rs.getString(6));
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
