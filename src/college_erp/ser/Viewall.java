package college_erp.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class Viewall
 */
@WebServlet("/Viewall")
public class Viewall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ResultSet rs=null;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewall() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cs=request.getParameter("cs");
		out.println("<form method='post' action='/college_erp/ToExcelall'>");
		out.println("<input type='text' name='cs' value="+cs+" style='display:none'>");
		out.println("<input type='submit' value='Export as Excel' style='background-color: white;margin-left:800px;margin-top:50px;float:left'>");
		out.println("</form>");
		out.println("<table border='15' style='border-style:inherit;width:1050px;margin-left:30px;margin-top:50px;text-align:center;float:left'>");
		if(cs.equals("courses"))
		{
			String str="select * from courses";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Courseid</th><th>Name</th><th>No of Sem</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("courseid");
				String b=rs.getString("name");
				int c=rs.getInt("noofsem");
				
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
	}
		else if(cs.equals("dept"))
		{
			String str="select * from department";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Departmentid</th><th>Name</th><th>Hod Id</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("dept_id");
				String b=rs.getString("name");
				String c=rs.getString("hod_id");
				
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("emp"))
		{
			String str="select * from employee";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Emp_id</th><th>Name</th><th>Address(per)</th><th>Address(res)</th><th>Phoneno</th><th>Email</th><th>Qualification</th><th>Experience</th><th>DOB</th><th>DOJ</th><th>Salary</th><th>Gender</th><th>Dept_id</th><th>Type</th></tr>");
		
			try
			{while(rs.next())
			{
				String a=rs.getString("emp_id");
				String b=rs.getString("name");
				String c=rs.getString("address_per");
				String d=rs.getString("address_res");
				Long e=rs.getLong("phoneno");
				String f=rs.getString("email");
				String g=rs.getString("qual");
				int h=rs.getInt("exp");
				String i=rs.getString("dob");
				String j=rs.getString("doj");
				Long k=rs.getLong("salary");
				String l=rs.getString("gender");
				String m=rs.getString("dept_id");
				String n=rs.getString("type");
				
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td><td>"+i+"</td><td>"+j+"</td><td>"+k+"</td><td>"+l+"</td><td>"+m+"</td><td>"+n+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("hostel"))
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
		else if(cs.equals("rs"))
		{
			String str="select * from resources";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Name</th><th>Total_quantity</th><th>Allotted_to</th><th>Allot_quantity</th><th>date_Allotted</th><th>Return_date</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("name");
				int b=rs.getInt("total");
				String c=rs.getString("allotted_to");
				int d=rs.getInt("allot_quantity");
				String e=rs.getString("date_allotted");
				String f=rs.getString("return_date");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("std"))
		{
			String str="select * from student";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Rollno</th><th>Name</th><th>Address</th><th>Email</th><th>Gender</th><th>DOB</th><th>DOA</th><th>Current_sem</th><th>Course_id</th><th>Phoneno</th><th>Hostel</th><th>Batch</th></tr>");
		
			try
			{while(rs.next())
			{
				String a=rs.getString("rollno");
				String b=rs.getString("name");
				String c=rs.getString("address");
				String d=rs.getString("email");
				String e=rs.getString("gender");
				String f=rs.getString("dob");
				String g=rs.getString("doa");
				int h=rs.getInt("current_sem");
				String i=rs.getString("course_id");
				Long j=rs.getLong("phoneno");
				int l=rs.getInt("hostel");
				String n=rs.getString("pass_yr");
				String m;
				if(l==0)
				m="No";
				else
					m="Yes";
				
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td><td>"+i+"</td><td>"+j+"</td><td>"+m+"</td><td>"+n+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("sub"))
		{
			String str="select * from subjects";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Subject_id</th><th>Name</th><th>Course_id</th><th>Fac_id</th><th>sem</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("sub_id");
				String b=rs.getString("name");
				String c=rs.getString("courseid");
				String d=rs.getString("fac_id");
				int e=rs.getInt("sem");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("vis"))
		{
			String str="select * from visitor";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Sno</th><th>Date</th><th>Visitor's Name</th><th>Vehicle no</th><th>Person's Name</th><th>Ptype</th><th>Time in</th><th>Time out</th><th>Phone no</th></tr>");
			try
			{while(rs.next())
			{
				int a=rs.getInt("sno");
				String b=rs.getString("date");
				String c=rs.getString("v_name");
				String d=rs.getString("vehicle_no");
				String e=rs.getString("p_name");
				String f=rs.getString("ptype");
				String g=rs.getString("time_in");
				String h=rs.getString("time_out");
				Long i=rs.getLong("phoneno");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td><td>"+i+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("marks"))
		{
			String str="select * from marks";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Subject Id</th><th>Faculty Id</th><th>Student Id</th><th>Internal Marks</th><th>External Marks</th><th>Batch</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("subject_id");
				String b=rs.getString("fac_id");
				String c=rs.getString("student_id");
				String d=rs.getString("int_marks");
				String e=rs.getString("ext_marks");
				String f=rs.getString("batch");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}	
		}
		else if(cs.equals("att"))
		{
			String str="select * from attendance";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>Date</th><th>Faculty Id</th><th>Subject Id</th><th>Student Id</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("date");
				String b=rs.getString("fac_id");
				String c=rs.getString("subject_id");
				String d=rs.getString("student_id");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else if(cs.equals("user"))
		{
			String str="select * from login";
			rs=CrudOperation.getValue(str);
			out.println("<tr style='background-color:#b1b1b1'><th>User Id</th><th>User Password</th><th>User Type</th><th>Status</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("userid");
				String b=rs.getString("userpass");
				String c=rs.getString("usertype");
				String d=rs.getString("status");
			
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
		}
		else
		{
			String message = "Please select one option!";
			response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
