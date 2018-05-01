package college_erp.ser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class employee
 */
@WebServlet("/employee")
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee() {
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
		String r=(String)request.getAttribute("uinfo");
		String str="select dept_id from employee where emp_id=?";
		try
		{
			ResultSet rs=CrudOperation.getData(str,r);
			String dpt=rs.getString("dept_id");
			String strsql="select name from department where dept_id=?";
			ResultSet rs1=CrudOperation.getData(strsql,dpt);
			String nm=rs1.getString("name");
			if(nm.equals("hostel"))
			{
				request.setAttribute("empid",r);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/emp_hostel.jsp");
				rd.forward(request, response);
			}
			if(nm.equals("resource"))
			{
				response.sendRedirect("/college_erp/jsp/emp_resource.jsp");
			}
			if(nm.equals("visitor"))
			{
				response.sendRedirect("/college_erp/jsp/emp_visitor.jsp");
			}
			
		}
		catch(Exception e)
		{
			
		}
	}

}
