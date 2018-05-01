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
import javax.servlet.http.HttpSession;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class ChangeP
 */
@WebServlet("/ChangeP")
public class ChangeP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeP() {
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
		String p1=request.getParameter("pwd");
		String p2=request.getParameter("pwd1");
		HttpSession hs=null;
		hs=request.getSession(false);
		String uid=(String)hs.getAttribute("uinfo");
		
		if(p1.equals(p2) && p1.length()!=0)
		{
				try
		{
			String str="update login set userpass=? where userid=?";
			ps=con.prepareStatement(str);
			ps.setString(1, p1);
			ps.setString(2, uid);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Password updated!";
				response.sendRedirect("/college_erp/jsp/change_pwd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Password cannot be updated. Please try after sometime!";
				response.sendRedirect("/college_erp/jsp/change_pwd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			ps.close();
		}
				catch(Exception e)
				{
					
				}
		}
		else if(p1.length()==0)
		{
			String message = "Password cannot be left blank!";
			response.sendRedirect("/college_erp/jsp/change_pwd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
		else
		{
			String message = "Password does not match!";
			response.sendRedirect("/college_erp/jsp/change_pwd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			
		}
	}

}
