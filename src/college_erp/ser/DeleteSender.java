package college_erp.ser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class DeleteSender
 */
@WebServlet("/DeleteSender")
public class DeleteSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSender() {
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
		String arr[]=request.getParameterValues("chk");
		con=CrudOperation.createConnection();
		
		try
		{
			for(String ch:arr)
			{
				String strsql="update message set rstatus=? where message_id=?";
				ps=con.prepareStatement(strsql);
				ps.setString(1, "true");
				ps.setString(2,ch);
				ps.executeUpdate();
			}
			
				response.sendRedirect("/college_erp/jsp/inbox.jsp");
			
	}
		
		catch(Exception e)
		{
			
		}
	}

}
