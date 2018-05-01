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
 * Servlet implementation class Addrecs
 */
@WebServlet("/Addrecs")
public class Addrecs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null,ps1=null;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addrecs() {
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
		String gen=request.getParameter("gen");
		long phno=Long.parseLong(request.getParameter("phno"));
		String dob=request.getParameter("dob");
		String doa=request.getParameter("doa");
		int sem=Integer.parseInt(request.getParameter("sem"));
		String h=request.getParameter("hostel");
		String op=request.getParameter("cs");
		String pyr=request.getParameter("pyr");
		try
		{
			String str="insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)";
			String str1="insert into login values(?,?,?,?)";
			ps=con.prepareStatement(str);
			ps1=con.prepareStatement(str1);
			ps.setString(1, roll);
			ps.setString(2,nm);
			ps.setString(3, add);
			ps.setString(4,email);
			ps.setString(5,gen);
			ps.setString(6, dob);
			ps.setString(7, doa);
			ps.setInt(8,sem);
			ps.setString(9,op);
			ps.setLong(10,phno);
			ps.setString(11, h);
			ps.setString(12, pyr);
			System.out.println(ps);
			ps1.setString(1,roll);
			ps1.setString(2,roll);
			ps1.setString(3, "student");
			ps1.setString(4, "true");
			System.out.println(ps1);
			int rw=ps.executeUpdate();
			int rw1=ps1.executeUpdate();
			if(rw>0 && rw1>0)
			{
				String message = "Record saved successfylly!";
				response.sendRedirect("/college_erp/jsp/addrecs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record not saved!";
				response.sendRedirect("/college_erp/jsp/addrecs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record not saved!";
			response.sendRedirect("/college_erp/jsp/addrecs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
