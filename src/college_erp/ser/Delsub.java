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
 * Servlet implementation class Delsub
 */
@WebServlet("/Delsub")
public class Delsub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null,ps1=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delsub() {
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
		
		try
		{
			String str="select * from subjects where sub_id=?";
			ps=con.prepareStatement(str);
			ps.setString(1,sid);
			ResultSet rs=(ResultSet) ps.executeQuery();
			if(rs.next())
			{
				try
				{String st="delete from subjects where sub_id=?";
				ps1=con.prepareStatement(st);
				ps1.setString(1, sid);
				int rw=ps1.executeUpdate();
				if(rw>0)
				{String message1 = "Record deleted successfylly!";
				response.sendRedirect("/college_erp/jsp/subjectm.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			}
			else
			{
				String message1 = "Record cannot be deleted";
				response.sendRedirect("/college_erp/jsp/subjectm.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			}
				}
				catch(Exception e)
				{
					String message1 = "Record cannot be deleted";
					response.sendRedirect("/college_erp/jsp/subjectm.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
				}
		}
			else
			{
				String message1 = "Subject Id not found";
				response.sendRedirect("/college_erp/jsp/subjectm.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message1 = "Subject Id not found";
			response.sendRedirect("/college_erp/jsp/subjectm.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
	
		}
	}

}
