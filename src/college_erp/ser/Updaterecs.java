package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Updaterecs
 */
@WebServlet("/Updaterecs")
public class Updaterecs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updaterecs() {
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
		con=CrudOperation.createConnection();
		String roll=request.getParameter("roll");
		String nm=request.getParameter("nm");
		String add=request.getParameter("add");
		String email=request.getParameter("email");
		
		long phno=Long.parseLong(request.getParameter("phno"));
		String dob=request.getParameter("dob");
		String doa=request.getParameter("doa");
		int sem=Integer.parseInt(request.getParameter("sem"));
		String h=request.getParameter("hostel");
		String op=request.getParameter("cs");
		String pyr=request.getParameter("pyr");
		try
		{
			String str="update student set name=?,address=?,email=?,dob=?,doa=?,current_sem=?,course_id=?,phoneno=?,hostel=?,pass_yr=? where rollno=?";
			
			ps=con.prepareStatement(str);
		
			
			ps.setString(1,nm);
			ps.setString(2, add);
			ps.setString(3,email);
			ps.setString(4, dob);
			ps.setString(5, doa);
			ps.setInt(6,sem);
			ps.setString(7,op);
			ps.setLong(8,phno);
			ps.setString(9,h);
			ps.setString(10,pyr);
			ps.setString(11, roll);
			
			System.out.println(ps);
			
			int rw=ps.executeUpdate();
			
			if(rw>0)
			{
				String message = "Record updated successfylly!";
				response.sendRedirect("/college_erp/jsp/addrecs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record not updated!";
				response.sendRedirect("/college_erp/jsp/addrecs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record not updated!";
			response.sendRedirect("/college_erp/jsp/addrecs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

	

}
