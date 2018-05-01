package college_erp.ser;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;
	ResultSet rs=null;
    HttpSession hs=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String ui=request.getParameter("userid");
		String up=request.getParameter("userpass");
		con=CrudOperation.createConnection();
		
		
		try
		{
			String strsql="select * from login where userid=? and userpass=?";
			ps=con.prepareStatement(strsql);
			ps.setString(1,ui);
			ps.setString(2,up);
			rs=ps.executeQuery();
			if(rs.next())
			{
				hs=request.getSession();
				hs.setAttribute("uinfo", ui);
				String utype=rs.getString("usertype");
				if(utype.equals("student"))
				{
					request.setAttribute("roll",ui);
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/student.jsp");
					rd.forward(request, response);
					
					
				}
				else if(utype.equals("faculty"))
				{
					request.setAttribute("facid",ui);
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/faculty.jsp");
					rd.forward(request, response);
				}
				else if(utype.equals("admin"))
				{
					response.sendRedirect("/college_erp/jsp/admin.jsp");
				}
				else if(utype.equals("director"))
				{
					request.setAttribute("did",ui);
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/director.jsp");
					rd.forward(request, response);				
					}
				else if(utype.equals("employee"))
				{
					try
					{
						String str="select d.name from employee e,department d where e.emp_id=? and e.dept_id=d.dept_id";
						PreparedStatement pp=con.prepareStatement(str);
						pp.setString(1, ui);
						ResultSet rr=pp.executeQuery();
						String nm="";
						if(rr.next())
							nm=rr.getString("name");
						request.setAttribute("empid",ui);
						RequestDispatcher rd=null;
						if(nm.equals("hostel"))
						{
							
							rd=request.getRequestDispatcher("/jsp/emp_hostel.jsp");
							
						}
						else if(nm.equals("resources"))
						{
						rd=request.getRequestDispatcher("/jsp/emp_resource.jsp");
						}
						else if(nm.equals("visitors"))
						{
						rd=request.getRequestDispatcher("/jsp/emp_visitor.jsp");
						}
						rd.forward(request, response);
						
					
				}
					catch(Exception e)
					{
						
					}
				}
				
				
			}
			else
			{
				
				String message = "Invalid UserId or Password!";
				response.sendRedirect("/college_erp/jsp/home.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
				
			}
			
		}
		  catch(SQLException cse)
		  {
			  System.out.println(cse);
		  }
		
	}

}
