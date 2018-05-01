package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Delrece
 */
@WebServlet("/Delrece")
public class Delrece extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delrece() {
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
		ResultSet rs=null;  
		String emp=request.getParameter("emp");
		String str="select * from employee where emp_id=?";
		try
		{rs=CrudOperation.getData(str, emp);
		if(rs.next())
		{
			request.setAttribute("empv",emp);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/delrecorde.jsp");
			rd.forward(request, response);
		}
		else
		{
			String message = "Employee Id not found";
			response.sendRedirect("/college_erp/jsp/deleterece.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
		}
		catch(Exception e)
		{
			
		}
		
	}

}
