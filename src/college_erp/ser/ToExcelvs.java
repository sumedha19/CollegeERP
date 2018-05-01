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
 * Servlet implementation class ToExcelvs
 */
@WebServlet("/ToExcelvs")
public class ToExcelvs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToExcelvs() {
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
	  		response.sendRedirect("/college_erp/jsp/viewvs.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

}
catch(Exception e)
{
	
}
	}

}
