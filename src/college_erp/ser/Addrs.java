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
 * Servlet implementation class Addrs
 */
@WebServlet("/Addrs")
public class Addrs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addrs() {
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
		int tot=Integer.parseInt(request.getParameter("total"));
		String ato=request.getParameter("ato");
		int aq=Integer.parseInt(request.getParameter("aq"));
		String da=request.getParameter("da");
		String dr=request.getParameter("dr");
		
		try
		{
			if(dr.equals(""))
			{
			String str1="insert into resources(name,total,allotted_to,allot_quantity,date_allotted) values(?,?,?,?,?)";
			ps=con.prepareStatement(str1);
			ps.setString(1,rnm);
			ps.setInt(2, tot);
			ps.setString(3,ato);
			ps.setInt(4,aq);
			ps.setString(5,da);
		
			}
			else
				{
				String str1="insert into resources values(?,?,?,?,?,?)";
				ps=con.prepareStatement(str1);
				ps.setString(1,rnm);
				ps.setInt(2, tot);
				ps.setString(3,ato);
				ps.setInt(4,aq);
				ps.setString(5,da);
				ps.setString(6, dr);
			
				}
			int rw=ps.executeUpdate();
			System.out.println(ps);
			if(rw>0)
			{
				String message = "Record added successfylly!";
				response.sendRedirect("/college_erp/jsp/addresources.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record cannot be added!";
				response.sendRedirect("/college_erp/jsp/addresources.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot be added";
			response.sendRedirect("/college_erp/jsp/addresources.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

}
