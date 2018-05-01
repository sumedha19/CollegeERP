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
 * Servlet implementation class ToExcelrs
 */
@WebServlet("/ToExcelrs")
public class ToExcelrs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  ResultSet rs=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToExcelrs() {
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
		XSSFWorkbook workbook = new XSSFWorkbook();
		java.util.Date dt = new java.util.Date();
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
	  		response.sendRedirect("/college_erp/jsp/viewrs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

}
catch(Exception e)
{
	
}
	}

}
