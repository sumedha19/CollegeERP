package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Compose
 */
@WebServlet("/Compose")
public class Compose extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compose() {
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
		HttpSession hs=request.getSession();
		String mg="";
		hs.setAttribute("msg", mg);
		String sid=request.getParameter("sid");
		String rid=request.getParameter("rid");
		String st=request.getParameter("subject");
		String msg=request.getParameter("msg");
		java.util.Date d=new java.util.Date();
		java.sql.Date sd=new java.sql.Date(d.getTime());
		con=CrudOperation.createConnection();
		try
		{
			String strsql="insert into message(sender_id,receiver_id,subject,mtext,date,rstatus,sstatus) values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(strsql);
			ps.setString(1, sid);
			ps.setString(2,rid);
			ps.setString(3, st);
			ps.setString(4,msg);
			ps.setDate(5, sd);
			ps.setString(6, "false");
			ps.setString(7, "false");
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Message sent successfully!";
				response.sendRedirect("/college_erp/jsp/compose.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Message could not be sent";
				response.sendRedirect("/college_erp/jsp/compose.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
			String message = "Message could not be sent";
			response.sendRedirect("/college_erp/jsp/compose.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
