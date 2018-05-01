package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Searchrs
 */
@WebServlet("/Searchrs")
public class Searchrs extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con=null;
   private PreparedStatement ps=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchrs() {
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
		String rnm=request.getParameter("rnm");
		String anm=request.getParameter("anm");
		con=CrudOperation.createConnection();
		try
		{
			String str="select * from resources where name=? and allotted_to=?";
			ps=con.prepareStatement(str);
			ps.setString(1, rnm);
			ps.setString(2, anm);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				request.setAttribute("nm",rnm);
				request.setAttribute("anm", anm);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/editrs.jsp");
				rd.forward(request, response);
			}
			else
			{
				String message = "Record not found";
				response.sendRedirect("/college_erp/jsp/updaters.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

}
