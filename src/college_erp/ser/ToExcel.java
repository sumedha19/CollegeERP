package college_erp.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import college_erp.dbutil.CrudOperation;

/**
 * Servlet implementation class ToExcel
 */
@WebServlet("/ToExcel")
public class ToExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToExcel() {
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
		String sb=request.getParameter("sb");
		String bt=request.getParameter("bt");
		String str="select s.rollno,s.name,m.int_marks,m.ext_marks from student s,marks m where s.course_id=? and s.pass_yr=? and m.subject_id=? and s.rollno=m.student_id ORDER BY s.rollno";
try
{

		Connection con=CrudOperation.createConnection();
		PreparedStatement ps=con.prepareStatement(str);
		ps.setString(1,cs);
		ps.setString(2,bt);
		ps.setString(3,sb);
		
		ResultSet rs=ps.executeQuery();
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("mark"+cs+sb+bt);
	      XSSFRow row=spreadsheet.createRow(1);
	      XSSFCell cell;
	      cell=row.createCell(1);
	      cell.setCellValue("Roll No");
	      cell=row.createCell(2);
	      cell.setCellValue("Name");
	      cell=row.createCell(3);
	      cell.setCellValue("Course_id");
	      cell=row.createCell(4);
	      cell.setCellValue("Internal Marks");
	      cell=row.createCell(5);
	      cell.setCellValue("External Marks");
		
		int i=2;
		while(rs.next())
		{
		
			row=spreadsheet.createRow(i);
	         cell=row.createCell(1);
	         cell.setCellValue(rs.getString("rollno"));
	         cell=row.createCell(2);
	         cell.setCellValue(rs.getString("name"));
	         cell=row.createCell(3);
	         cell.setCellValue(cs);
	         cell=row.createCell(4);
	         cell.setCellValue(rs.getInt("int_marks"));
	         cell=row.createCell(5);
	         cell.setCellValue(rs.getString("ext_marks"));
	         i++;
	      }
	      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\mark"+cs+sb+bt+".xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("excel file written successfully");	
	      workbook.close();
	      String message = "Excel file created successfully. filename-mark"+cs+sb+bt;
	  		response.sendRedirect("/college_erp/jsp/viewmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

		
}
catch(Exception e)
{
	
}
}

}
