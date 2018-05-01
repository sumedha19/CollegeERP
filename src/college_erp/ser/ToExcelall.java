package college_erp.ser;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import college_erp.dbutil.CrudOperation;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * Servlet implementation class ToExcelall
 */
@WebServlet("/ToExcelall")
public class ToExcelall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToExcelall() {
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
		
		String cs=request.getParameter("cs");
		XSSFWorkbook workbook = new XSSFWorkbook();
		java.util.Date dt = new java.util.Date();

		if(cs.equals("courses"))
		{
			try
			{String str="select * from courses";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("courses"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Course Id");
		      cell=row.createCell(2);
		      cell.setCellValue("Name");
		      cell=row.createCell(3);
		      cell.setCellValue("No of sem");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("courseid"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getInt("noofsem"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\course"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-course"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

			
	}
	catch(Exception e)
	{
		
	}
	}
		else if(cs.equals("dept"))
		{
			try
			{
			String str="select * from department";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("dept"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Department Id");
		      cell=row.createCell(2);
		      cell.setCellValue("Name");
		      cell=row.createCell(3);
		      cell.setCellValue("HOD Id");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("dept_id"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("hod_id"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\dept"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-dept"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("emp"))
		{
			try
			{
			String str="select * from employee";
			rs=CrudOperation.getValue(str);
			
			 XSSFSheet spreadsheet = workbook.createSheet("emp"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Employee Id");
		      cell=row.createCell(2);
		      cell.setCellValue("Name");
		      cell=row.createCell(3);
		      cell.setCellValue("Address_per");
		      cell=row.createCell(4);
		      cell.setCellValue("Address_res");
		      cell=row.createCell(5);
		      cell.setCellValue("Phone No");
		      cell=row.createCell(6);
		      cell.setCellValue("Email");
		      cell=row.createCell(7);
		      cell.setCellValue("Qualification");
		      cell=row.createCell(8);
		      cell.setCellValue("Experience");
		      cell=row.createCell(9);
		      cell.setCellValue("DOB");
		      cell=row.createCell(10);
		      cell.setCellValue("DOJ");
		      cell=row.createCell(11);
		      cell.setCellValue("Salary");
		      cell=row.createCell(12);
		      cell.setCellValue("Gender");
		      cell=row.createCell(13);
		      cell.setCellValue("Dept Id");
		      cell=row.createCell(14);
		      cell.setCellValue("Type");
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("emp_id"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("address_per"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("address_res"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getLong("phoneno"));
		         cell=row.createCell(6);
		         cell.setCellValue(rs.getString("email"));
		         cell=row.createCell(7);
		         cell.setCellValue(rs.getString("qual"));
		         cell=row.createCell(8);
		         cell.setCellValue(rs.getInt("exp"));
		         cell=row.createCell(9);
		         cell.setCellValue(rs.getString("dob"));
		         cell=row.createCell(10);
		         cell.setCellValue(rs.getString("doj"));
		         cell=row.createCell(11);
		         cell.setCellValue(rs.getLong("salary"));
		         cell=row.createCell(12);
		         cell.setCellValue(rs.getString("gender"));
		         cell=row.createCell(13);
		         cell.setCellValue(rs.getString("dept_id"));
		         cell=row.createCell(14);
		         cell.setCellValue(rs.getString("type"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\emp"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-emp"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

			
	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("hostel"))
		{
			try
			{
			String str="select * from hostel";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("hostel"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Type");
		      cell=row.createCell(2);
		      cell.setCellValue("Hostel Name");
		      cell=row.createCell(3);
		      cell.setCellValue("location");
		      cell=row.createCell(4);
		      cell.setCellValue("No. of floors");
		      cell=row.createCell(5);
		      cell.setCellValue("Rooms/Floor");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("type"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("hostel_name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("location"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getInt("no_of_floors"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getInt("rooms_per_floor"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\hostel"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-hostel"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("hostl"))
		{
			try
			{
			String str="select * from hosteller";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("hosteller"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Room No");
		      cell=row.createCell(2);
		      cell.setCellValue("Hostel Name");
		      cell=row.createCell(3);
		      cell.setCellValue("Student Id");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("room_no"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("hostel_name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("student_id"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\hosteller"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-hosteller"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("rs"))
		{
			try
			{
			String str="select * from resources";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("resources"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Name");
		      cell=row.createCell(2);
		      cell.setCellValue("Total");
		      cell=row.createCell(3);
		      cell.setCellValue("Allotted To");
		      cell=row.createCell(4);
		      cell.setCellValue("Allotted Quantity");
		      cell=row.createCell(5);
		      cell.setCellValue("Allotted Date");
		      cell=row.createCell(6);
		      cell.setCellValue("Return Date");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("name"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getInt("total"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("allotted_to"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("allot_quantity"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getString("date_allotted"));
		         cell=row.createCell(6);
		         cell.setCellValue(rs.getString("return_date"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\resources"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-resources"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("std"))
		{
			try
			{
			String str="select * from student ORDER BY course_id";
			rs=CrudOperation.getValue(str);
			
			 XSSFSheet spreadsheet = workbook.createSheet("student"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Roll No");
		      cell=row.createCell(2);
		      cell.setCellValue("Name");
		      cell=row.createCell(3);
		      cell.setCellValue("Address");
		      cell=row.createCell(4);
		      cell.setCellValue("Email");
		      cell=row.createCell(5);
		      cell.setCellValue("Gender");
		      cell=row.createCell(6);
		      cell.setCellValue("DOB");
		      cell=row.createCell(7);
		      cell.setCellValue("DOA");
		      cell=row.createCell(8);
		      cell.setCellValue("Current Sem");
		      cell=row.createCell(9);
		      cell.setCellValue("Course Id");
		      cell=row.createCell(10);
		      cell.setCellValue("Phone No");
		      cell=row.createCell(11);
		      cell.setCellValue("Hostel");
		      cell=row.createCell(12);
		      cell.setCellValue("Batch");
		     
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("rollno"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("address"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("email"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getString("gender"));
		         cell=row.createCell(6);
		         cell.setCellValue(rs.getString("dob"));
		         cell=row.createCell(7);
		         cell.setCellValue(rs.getString("doa"));
		         cell=row.createCell(8);
		         cell.setCellValue(rs.getInt("current_sem"));
		         cell=row.createCell(9);
		         cell.setCellValue(rs.getString("course_id"));
		         cell=row.createCell(10);
		         cell.setCellValue(rs.getLong("phoneno"));
		         cell=row.createCell(11);
		         cell.setCellValue(rs.getString("hostel"));
		         cell=row.createCell(12);
		         cell.setCellValue(rs.getString("pass_yr"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\student"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-student"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

			
	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("sub"))
		{
			try
			{
			String str="select * from subjects ORDER BY sem";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("subject"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Subject Id");
		      cell=row.createCell(2);
		      cell.setCellValue("Name");
		      cell=row.createCell(3);
		      cell.setCellValue("Course Id");
		      cell=row.createCell(4);
		      cell.setCellValue("Faculty Id");
		      cell=row.createCell(5);
		      cell.setCellValue("Semester");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("sub_id"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("name"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("courseid"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("fac_id"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getInt("sem"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\subject"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-subject"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("vis"))
		{
			try
			{
			String str="select * from visitor ORDER BY date";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("visitor"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("SNO");
		      cell=row.createCell(2);
		      cell.setCellValue("Date");
		      cell=row.createCell(3);
		      cell.setCellValue("Visitor Name");
		      cell=row.createCell(4);
		      cell.setCellValue("Vehicle No");
		      cell=row.createCell(5);
		      cell.setCellValue("Person Name");
		      cell=row.createCell(6);
		      cell.setCellValue("Person type");
		      cell=row.createCell(7);
		      cell.setCellValue("Time In");
		      cell=row.createCell(8);
		      cell.setCellValue("Time Out");
		      cell=row.createCell(9);
		      cell.setCellValue("Phone No");
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getInt("sno"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("date"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("v_name"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("vehicle_no"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getString("p_name"));
		         cell=row.createCell(6);
		         cell.setCellValue(rs.getString("ptype"));
		         cell=row.createCell(7);
		         cell.setCellValue(rs.getString("time_in"));
		         cell=row.createCell(8);
		         cell.setCellValue(rs.getString("time_out"));
		         cell=row.createCell(9);
		         cell.setCellValue(rs.getString("phoneno"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\visitor"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-visitor"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("marks"))
		{
			try
			{
			String str="select * from marks ORDER BY batch";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("marks"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Subject Id");
		      cell=row.createCell(2);
		      cell.setCellValue("Facutly Id");
		      cell=row.createCell(3);
		      cell.setCellValue("Student Id");
		      cell=row.createCell(4);
		      cell.setCellValue("Internal Marks");
		      cell=row.createCell(5);
		      cell.setCellValue("External Marks");
		      cell=row.createCell(6);
		      cell.setCellValue("BATCH");
			
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("subject_id"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("fac_id"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("student_id"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getInt("int_marks"));
		         cell=row.createCell(5);
		         cell.setCellValue(rs.getInt("ext_marks"));
		         cell=row.createCell(6);
		         cell.setCellValue(rs.getString("batch"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\marks"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-marks"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("att"))
		{
			try
			{
			String str="select * from attendance ORDER BY date";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("attendance"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("Date");
		      cell=row.createCell(2);
		      cell.setCellValue("Facutly Id");
		      cell=row.createCell(3);
		      cell.setCellValue("Subject Id");
		      cell=row.createCell(4);
		      cell.setCellValue("Student Id");	
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("date"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("fac_id"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("subject_id"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("student_id"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\attendance"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-attendance"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}
	catch(Exception e)
	{
		
	}
		}
		else if(cs.equals("user"))
		{
			try
			{
			String str="select * from login";
			rs=CrudOperation.getValue(str);
			 XSSFSheet spreadsheet = workbook.createSheet("users"+dt.getTime());
		      XSSFRow row=spreadsheet.createRow(1);
		      XSSFCell cell;
		      cell=row.createCell(1);
		      cell.setCellValue("User Id");
		      cell=row.createCell(2);
		      cell.setCellValue("User Pass");
		      cell=row.createCell(3);
		      cell.setCellValue("User Type");
		      cell=row.createCell(4);
		      cell.setCellValue("Status");
			int i=2;
			while(rs.next())
			{
			
				row=spreadsheet.createRow(i);
		         cell=row.createCell(1);
		         cell.setCellValue(rs.getString("userid"));
		         cell=row.createCell(2);
		         cell.setCellValue(rs.getString("userpass"));
		         cell=row.createCell(3);
		         cell.setCellValue(rs.getString("usertype"));
		         cell=row.createCell(4);
		         cell.setCellValue(rs.getString("status"));
		         i++;
		      }
		      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\users"+dt.getTime()+".xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("excel file written successfully");	
		      workbook.close();
		      String message = "Excel file created successfully. filename-users"+dt.getTime();
		  		response.sendRedirect("/college_erp/jsp/viewall.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}
	}

}
