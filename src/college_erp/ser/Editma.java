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
 * Servlet implementation class Editma
 */
@WebServlet("/Editma")
public class Editma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con=null;
	private PreparedStatement ps=null;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editma() {
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
		int intm=Integer.parseInt(request.getParameter("intm"));
		int extm=Integer.parseInt(request.getParameter("extm"));
		String sb=request.getParameter("sb");
		String bt=request.getParameter("bt");
		String roll=request.getParameter("roll");
		con=CrudOperation.createConnection();
		try
		{
			String str="update marks set int_marks=?,ext_marks=? where subject_id=? and batch=? and student_id=?";
			ps=con.prepareStatement(str);
			ps.setInt(1, intm);
			ps.setInt(2, extm);
			ps.setString(3, sb);
			ps.setString(4, bt);
			ps.setString(5, roll);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				String message = "Record updated successfylly!";
				response.sendRedirect("/college_erp/jsp/edmark.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else
			{
				String message = "Record not updated!";
				response.sendRedirect("/college_erp/jsp/edmark.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
		catch(Exception e)
		{
			String message = "Record cannot not updated!";
			response.sendRedirect("/college_erp/jsp/edmark.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

}
