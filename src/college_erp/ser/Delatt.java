package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Delatt
 */
@WebServlet("/Delatt")
public class Delatt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delatt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dt=request.getParameter("dt");
		String sb=request.getParameter("sb");
		String roll=request.getParameter("roll");
		con=CrudOperation.createConnection();
		String str="delete from attendance where date=? and subject_id=? and student_id=?";
		try {
			ps=con.prepareStatement(str);
			ps.setString(1, dt);
			ps.setString(2, sb);
			ps.setString(3, roll);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message1 = "Record deleted successfylly!";
				response.sendRedirect("/college_erp/jsp/delatt.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			}
			else
			{
				String message1 = "Record does not exists!";
				response.sendRedirect("/college_erp/jsp/delatt.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
				String message1 = "Record cannot be deleted";
				response.sendRedirect("/college_erp/jsp/delatt.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			
			e.printStackTrace();
		}
		
	}

}
