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
 * Servlet implementation class ToExcela
 */
@WebServlet("/ToExcela")
public class ToExcela extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToExcela() {
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
		String dt=request.getParameter("date");
		String str="select s.rollno,s.name,a.subject_id from student s,attendance a where s.course_id=? and s.pass_yr=? and a.subject_id=? and a.date=? and s.rollno=a.student_id ORDER BY s.rollno";
		
try
{

		Connection con=CrudOperation.createConnection();
		PreparedStatement ps=con.prepareStatement(str);
		ps.setString(1,cs);
		ps.setString(2,bt);
		ps.setString(3,sb);
		ps.setString(4, dt);
		
		ResultSet rs=ps.executeQuery();
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	      XSSFSheet spreadsheet = workbook.createSheet("attendance"+cs+sb+bt);
	      XSSFRow row=spreadsheet.createRow(1);
	      XSSFCell cell;
	      cell=row.createCell(1);
	      cell.setCellValue("Roll No");
	      cell=row.createCell(2);
	      cell.setCellValue("Name");
	      cell=row.createCell(3);
	      cell.setCellValue("Course_id");
	     
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
	         i++;
	      }
	      FileOutputStream out = new FileOutputStream(new File("c:\\excel\\attendance"+cs+sb+bt+dt+".xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("excel file written successfully");	
	      workbook.close();
	      String message = "Excel file created successfully. filename-attendance"+cs+sb+bt+dt;
	  		response.sendRedirect("/college_erp/jsp/viewattendance.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

		
}
catch(Exception e)
{
	
}
	}

}
