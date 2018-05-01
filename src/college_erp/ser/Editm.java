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
 * Servlet implementation class Editm
 */
@WebServlet("/Editm")
public class Editm extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private Connection con=null;
      private PreparedStatement ps=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editm() {
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
		String roll[]=request.getParameterValues("roll");
		String extm[]=request.getParameterValues("intm");
		String sb=request.getParameter("sb");
		String bt=request.getParameter("bt");
		int i=0,rw=0;
		try
		{
			con=CrudOperation.createConnection();
		while(i<roll.length)
			{
		
			String str="update marks set ext_marks=? where student_id=? and subject_id=? and batch=?";
			ps=con.prepareStatement(str);
			ps.setInt(1, Integer.parseInt(extm[i]));
			ps.setString(2, roll[i]);
			ps.setString(3, sb);			
			ps.setString(4,bt);
			rw+=ps.executeUpdate();
			i++;
		}
		if(rw==roll.length)
		{
			String message = "Record successfully updated!";
			response.sendRedirect("/college_erp/jsp/editmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
			
	}
		
		
		catch(Exception e)
		{
			String message = "Invalid input or record already exists";
			response.sendRedirect("/college_erp/jsp/editmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
