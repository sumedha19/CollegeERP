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
 * Servlet implementation class Enterm
 */
@WebServlet("/Enterm")
public class Enterm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection con=null;
       private PreparedStatement ps=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enterm() {
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
		String sb=request.getParameter("sb");
		HttpSession hs=null;
		hs=request.getSession(false);
		String uid=(String)hs.getAttribute("uinfo");
		String roll[]=request.getParameterValues("roll");
		String intm[]=request.getParameterValues("intm");
		String extm[]=request.getParameterValues("extm");
		String bt=request.getParameter("bt");
		int i=0,rw=0;
		try
		{
			con=CrudOperation.createConnection();
		while(i<roll.length)
			{
		
			String str="insert into marks(subject_id,fac_id,student_id,int_marks,ext_marks,batch) values(?,?,?,?,?,?)";
			ps=con.prepareStatement(str);
			ps.setString(1, sb);
			ps.setString(2, uid);
			ps.setString(3, roll[i]);
			ps.setInt(4, Integer.parseInt(intm[i]));
			ps.setInt(5, Integer.parseInt(extm[i]));
			ps.setString(6,bt);
			rw+=ps.executeUpdate();
			i++;
		}
		if(rw==roll.length)
		{
			String message = "Record successfully added!";
			response.sendRedirect("/college_erp/jsp/entermarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
			
	}
		
		
		catch(Exception e)
		{
			String message = "Invalid input or record already exists";
			response.sendRedirect("/college_erp/jsp/entermarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
