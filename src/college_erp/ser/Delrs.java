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

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class Delrs
 */
@WebServlet("/Delrs")
public class Delrs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null,ps1=null;        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delrs() {
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
		String rnm=request.getParameter("rnm");
		String anm=request.getParameter("anm");
		try
		{
			String str="select * from resources where name=? and allotted_to=?";
			ps=con.prepareStatement(str);
			ps.setString(1,rnm);
			ps.setString(2,anm);
			ResultSet rs=(ResultSet) ps.executeQuery();
			if(rs.next())
			{
				try
				{
					String st="delete from resources where name=? and allotted_to=?";
				ps1=con.prepareStatement(st);
				ps1.setString(1, rnm);
				ps1.setString(2, anm);
				int rw=ps1.executeUpdate();
				if(rw>0)
				{String message = "Record deleted successfylly!";
				response.sendRedirect("/college_erp/jsp/delrs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be deleted";
				response.sendRedirect("/college_erp/jsp/delrs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
				}
				catch(Exception e)
				{
					String message = "Record cannot be deleted";
					response.sendRedirect("/college_erp/jsp/delrs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
				}
		}
			else
			{
				String message= "Record not found";
				response.sendRedirect("/college_erp/jsp/delrs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record not found";
			response.sendRedirect("/college_erp/jsp/delrs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

}
