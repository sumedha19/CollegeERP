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
 * Servlet implementation class Delrecc
 */
@WebServlet("/Delrecc")
public class Delrecc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private PreparedStatement ps=null,ps1=null; 
     private Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delrecc() {
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
		String r=request.getParameter("r");
		String str="delete from employee where emp_id=?";
		String strsql="delete from login where userid=?";
		try
		{
			con=CrudOperation.createConnection();
			ps=con.prepareStatement(str);
			ps1=con.prepareStatement(strsql);
			ps.setString(1,r);
			ps1.setString(1, r);
			int rw=ps.executeUpdate();
			int rw1=ps1.executeUpdate();
			if(rw>0 && rw1>0)
			{
				String message = "Record deleted!";
				response.sendRedirect("/college_erp/jsp/deleterece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be deleted.";
				response.sendRedirect("/college_erp/jsp/deleterece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot be deleted.";
			response.sendRedirect("/college_erp/jsp/deleterece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
