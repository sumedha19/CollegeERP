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
 * Servlet implementation class Updaterece
 */
@WebServlet("/Updaterece")
public class Updaterece extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updaterece() {
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
		String em=request.getParameter("emid");
		String nm=request.getParameter("nm");
		String add=request.getParameter("add");
	
		String radd;
		
			radd=request.getParameter("radd");
		
		String email=request.getParameter("em");
		
		long phno=Long.parseLong(request.getParameter("phno"));
		String dob=request.getParameter("dob");
		String doj=request.getParameter("doj");
		String op=request.getParameter("dept");
		String op1=request.getParameter("type");
		String q=request.getParameter("qual");
		int exp=Integer.parseInt(request.getParameter("exp"));
		long sal=Long.parseLong(request.getParameter("sal"));
		try
		{
			String str="update employee set name=?,address_per=?,address_res=?,phoneno=?,email=?,qual=?,exp=?,dob=?,doj=?,salary=?,type=?,dept_id=? where emp_id=?";
			ps=con.prepareStatement(str);
			ps.setString(1, nm);
			ps.setString(2, add);
			ps.setString(3, radd);
			ps.setLong(4, phno);
			ps.setString(5,email);
			ps.setString(6, q);
			ps.setInt(7,exp);
			ps.setString(8,dob);
			ps.setString(9,doj);
			ps.setLong(10, sal);
			ps.setString(11, op1);
			ps.setString(12, op);
			ps.setString(13,em);
			System.out.println(ps);
			
			int rw=ps.executeUpdate();
			
			if(rw>0)
			{
				String message = "Record updated successfylly!";
				response.sendRedirect("/college_erp/jsp/addrece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record not updated!";
				response.sendRedirect("/college_erp/jsp/editrece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record not updated!";
			response.sendRedirect("/college_erp/jsp/editrece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
		}
	
		

}
