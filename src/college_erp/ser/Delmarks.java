package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;
/**
 * Servlet implementation class Delmarks
 */
@WebServlet("/Delmarks")
public class Delmarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null,ps1=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delmarks() {
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
		String sb=request.getParameter("sb");
		String bt=request.getParameter("bt");
		String roll=request.getParameter("roll");
		String str="select * from marks where subject_id=? and batch=? and student_id=?";
		con=CrudOperation.createConnection();
		try
		{
			
			ps=con.prepareStatement(str);
			ps.setString(1,sb);
			ps.setString(2,bt);
			ps.setString(3,roll);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String sq="delete from marks where subject_id=? and batch=? and student_id=?";
				ps1=con.prepareStatement(sq);
				ps1.setString(1, sb);
				ps1.setString(2, bt);
				ps1.setString(3, roll);
				int rw=ps1.executeUpdate();
				if(rw>0)
				{
					String message1 = "Record deleted successfylly!";
					response.sendRedirect("/college_erp/jsp/edmark.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
				}
				else
				{
					String message1 = "Record cannot be deleted";
					response.sendRedirect("/college_erp/jsp/edmark.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
				}
			}
			else
			{
				String message1 = "Record does not exists!";
				response.sendRedirect("/college_erp/jsp/edmark.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			}
	}

catch(Exception e)
		{
	
		}
}
}