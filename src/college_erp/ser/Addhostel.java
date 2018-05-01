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
 * Servlet implementation class Addhostel
 */
@WebServlet("/Addhostel")
public class Addhostel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addhostel() {
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
		String nm=request.getParameter("name");
		String loc=request.getParameter("loc");
		String cs=request.getParameter("cs");
		int fl=Integer.parseInt(request.getParameter("floor"));
		int room=Integer.parseInt(request.getParameter("room"));
		try
		{
			String str1="insert into hostel values(?,?,?,?,?)";
			ps=con.prepareStatement(str1);
			ps.setString(1,cs);
			ps.setString(2, nm);
			ps.setString(3,loc);
			ps.setInt(4, fl);
			ps.setInt(5, room);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Record added successfylly!";
				response.sendRedirect("/college_erp/jsp/addhostel.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be added!";
				response.sendRedirect("/college_erp/jsp/addhostel.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot be added";
			response.sendRedirect("/college_erp/jsp/addhostel.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

}
