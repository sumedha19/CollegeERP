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
 * Servlet implementation class EnterA
 */
@WebServlet("/EnterA")
public class EnterA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection con=null;
       private PreparedStatement ps=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterA() {
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
		java.util.Date d=new java.util.Date();
		java.sql.Date sd=new java.sql.Date(d.getTime());
		HttpSession hs=null;
		hs=request.getSession(false);
		String uid=(String)hs.getAttribute("uinfo");
		String sb=request.getParameter("sb");
		String npc[]=request.getParameterValues("npc");
		String all=request.getParameter("all");
		int i=0,rw=0;
		
			try
		{
			con=CrudOperation.createConnection();
			if(all==null)
			{
		while(i<npc.length)
		{
			String str="insert into attendance values(?,?,?,?)";
			ps=con.prepareStatement(str);
			ps.setDate(1, sd);
			ps.setString(2,uid);
			ps.setString(3,sb);
			ps.setString(4,npc[i]);
				rw+=ps.executeUpdate();
				i++;
			}
			if(rw==npc.length)
			{
				String message = "Record successfully added!";
				response.sendRedirect("/college_erp/jsp/enterattendance.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
				
		}
			else
			{
				String st="insert into attendance values(?,?,?,?)";
				ps=con.prepareStatement(st);
				ps.setDate(1, sd);
				ps.setString(2, uid);
				ps.setString(3, sb);
				ps.setString(4, "all");
				int rr=ps.executeUpdate();
				if(rr>0)
				{
					String message = "Record successfully added!";
					response.sendRedirect("/college_erp/jsp/enterattendance.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
				}
			}
		}
			
			
			catch(Exception e)
			{
				String message = "Invalid input or record already exists";
				response.sendRedirect("/college_erp/jsp/enterattendance.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			
		}
		
	}
	


