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
 * Servlet implementation class Addsub
 */
@WebServlet("/Addsub")
public class Addsub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addsub() {
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
		String sid=request.getParameter("sid");
		String nm=request.getParameter("nm");
		String cs=request.getParameter("cs");
		String fac=request.getParameter("facid");
		int sem=Integer.parseInt(request.getParameter("sem"));
		try
		{
			String str="insert into subjects values(?,?,?,?,?)";
			ps=con.prepareStatement(str);
			ps.setString(1,sid);
			ps.setString(2, nm);
			ps.setString(3,cs);
			ps.setString(4,fac);
			ps.setInt(5, sem);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Record added successfylly!";
				response.sendRedirect("/college_erp/jsp/subjectm.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be added";
				response.sendRedirect("/college_erp/jsp/subjectm.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot be added";
			response.sendRedirect("/college_erp/jsp/subjectm.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

}
