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
 * Servlet implementation class ToExcelallh
 */
@WebServlet("/ToExcelallh")
public class ToExcelallh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToExcelallh() {
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
		if(cs.equals("hostel"))
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
		  		response.sendRedirect("/college_erp/jsp/viewhrec.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

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
		  		response.sendRedirect("/college_erp/jsp/viewhrec.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	catch(Exception e)
	{
		
	}
		}

	}

}
