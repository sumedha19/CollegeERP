package college_erp.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Viewallh
 */
@WebServlet("/Viewallh")
public class Viewallh extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private  ResultSet rs=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewallh() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cs=request.getParameter("cs");
		out.println("<form method='post' action='/college_erp/ToExcelallh'>");
		out.println("<input type='text' name='cs' value="+cs+" style='display:none'>");
		out.println("<input type='submit' value='Export as Excel' style='background-color: white;margin-left:800px;margin-top:50px;float:left'>");
		out.println("</form>");
		out.println("<table border='15' style='border-style:inherit;width:1050px;margin-left:30px;margin-top:50px;text-align:center;float:left'>");
		if(cs.equals("hostel"))
		{
			String str="select * from hostel";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Type</th><th>Hostel_Name</th><th>Location</th><th>No_of_floors</th><th>Rooms_per_floor</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("type");
				String b=rs.getString("hostel_name");
				String c=rs.getString("location");
				int d=rs.getInt("no_of_floors");
				int e=rs.getInt("rooms_per_floor");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("hostl"))
		{
			String str="select * from hosteller";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Room_no</th><th>Hostel_Name</th><th>Student/Employee Id</th></tr>");
			try
			{while(rs.next())
			{
				int a=rs.getInt("room_no");
				String b=rs.getString("hostel_name");
				String c=rs.getString("student_id");
				
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
	}

}
