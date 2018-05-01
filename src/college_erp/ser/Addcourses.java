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
 * Servlet implementation class Addcourses
 */
@WebServlet("/Addcourses")
public class Addcourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcourses() {
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
		String cid=request.getParameter("cid");
		String nm=request.getParameter("nm");
		int no=Integer.parseInt(request.getParameter("sem"));
		try
		{
			String str="insert into courses values(?,?,?)";
			ps=con.prepareStatement(str);
			ps.setString(1,cid);
			ps.setString(2, nm);
			ps.setInt(3, no);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Record added successfylly!";
				response.sendRedirect("/college_erp/jsp/coursesm.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be added";
				response.sendRedirect("/college_erp/jsp/coursesm.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot be added";
			response.sendRedirect("/college_erp/jsp/coursesm.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

}
