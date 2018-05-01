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
 * Servlet implementation class Addvisitor
 */
@WebServlet("/Addvisitor")
public class Addvisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addvisitor() {
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
		String dv=request.getParameter("dv");
		String vnm=request.getParameter("vnm");
		String vno=request.getParameter("vno");
		String pnm=request.getParameter("pnm");
		String cs=request.getParameter("cs");
		String tin=request.getParameter("tin");
		String tout=request.getParameter("tout");
		Long phno=Long.parseLong(request.getParameter("phno"));
		try
		{
			String str1="insert into visitor(date,v_name,vehicle_no,p_name,ptype,time_in,time_out,phoneno) values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(str1);
			ps.setString(1,dv);
			ps.setString(2, vnm);
			ps.setString(3,vno);
			ps.setString(4,pnm);
			ps.setString(5,cs);
			ps.setString(6, tin);
			ps.setString(7, tout);
			ps.setLong(8,phno);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Record added successfylly!";
				response.sendRedirect("/college_erp/jsp/addvisitor.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be added!";
				response.sendRedirect("/college_erp/jsp/addvisitor.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot be added";
			response.sendRedirect("/college_erp/jsp/addvisitor.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

}
