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
 * Servlet implementation class Viewrecs
 */
@WebServlet("/Viewrecs")
public class Viewrecs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewrecs() {
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
		String roll=request.getParameter("roll");
		String str="select * from student where rollno=?";
		try
		{rs=CrudOperation.getData(str, roll);
		if(rs.next())
		{
			request.setAttribute("rollv",roll);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/viewrecords.jsp");
			rd.forward(request, response);
		}
		else
		{
			String message = "Rollno not found";
			response.sendRedirect("/college_erp/jsp/viewdetails.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
		}
		catch(Exception e)
		{
			
		}
		
	
	}

}
