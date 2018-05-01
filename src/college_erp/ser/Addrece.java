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
 * Servlet implementation class Addrece
 */
@WebServlet("/Addrece")
public class Addrece extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null,ps1=null;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addrece() {
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
		String ch[]=request.getParameterValues("chk");
		String radd;
		if(ch[0].equals("same"))
		radd=add;
		else
			radd=request.getParameter("radd");
		String email=request.getParameter("em");
		String gen=request.getParameter("gen");
		long phno=Long.parseLong(request.getParameter("phno"));
		String dob=request.getParameter("dob");
		String doj=request.getParameter("doj");
		String op=request.getParameter("dept");
		if(op.equals("def"))
			op="";
		String op1=request.getParameter("type");
		String q=request.getParameter("qual");
		int exp=Integer.parseInt(request.getParameter("exp"));
		long sal=Long.parseLong(request.getParameter("sal"));
		try
		{
			String str="insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String str1="insert into login values(?,?,?,?)";
			ps=con.prepareStatement(str);
			ps1=con.prepareStatement(str1);
			ps.setString(1, em);
			ps.setString(2,nm);
			ps.setString(3, add);
			ps.setString(4,radd);
			ps.setLong(5,phno);
			ps.setString(6,email);
			ps.setString(7, q);
			ps.setInt(8,exp);
			ps.setString(9,dob);
			ps.setString(10,doj);
			ps.setLong(11,sal);
			ps.setString(12, gen);
			ps.setString(13,op);
			ps.setString(14,op1);
			System.out.println(ps);
			ps1.setString(1,em);
			ps1.setString(2,em);
			ps1.setString(3,op1);
			ps1.setString(4, "true");
			System.out.println(ps1);
			int rw=ps.executeUpdate();
			int rw1=ps1.executeUpdate();
			if(rw>0 && rw1>0)
			{
				String message = "Record saved successfylly!";
				response.sendRedirect("/college_erp/jsp/addrece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record not saved!";
				response.sendRedirect("/college_erp/jsp/addrece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record not saved!";
			response.sendRedirect("/college_erp/jsp/addrece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
