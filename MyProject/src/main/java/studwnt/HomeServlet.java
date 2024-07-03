package studwnt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	public HomeServlet() {
	
	}
	
	
		public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException  {

			res.getWriter().print("<h1>Your name is Shima Nsanza Guevalla and id is 26015</h1>");
				    
				}

				public void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {

				    String enteredid = req.getParameter("id");
				    Integer id= Integer.parseInt(enteredid);
				    try {
				    	String db_url="jdbc:postgresql://localhost:5432/bestprogr_db";
				    	String username="postgres";
				    	String password="Kgrace1212";
				    	Class.forName("org.postgresql.Driver");
				    	Connection con=DriverManager.getConnection(db_url,username,password);
				    	PreparedStatement pst= con.prepareStatement("select * from students where id=?");
				    	pst.setInt(1, id);
				    	ResultSet rs=pst.executeQuery();
				    	if (rs.next()) {
				    		String name=rs.getString("name");
				    		res.getWriter().print("<h1>Your name is "+name+" and id is "+id+"</h1>");
				    		
				    	}
				    	con.close();
				    	return;
				    } catch (SQLException e){
				    	 
				    } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				    res.getWriter().print("<h2>Id does not exist</h2>");
				}
	}


