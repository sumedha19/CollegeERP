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

import college_erp.dbutil.CrudOperation;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class Topdfemp
 */
@WebServlet("/Topdfemp")
public class Topdfemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Topdfemp() {
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
String emp=request.getParameter("emp");
		
		try {
			String strsql="select * from employee where emp_id=?";
			Connection con=CrudOperation.createConnection();
			PreparedStatement ps=con.prepareStatement(strsql);
			ps.setString(1,emp);
			ResultSet rs1=ps.executeQuery();
			if(rs1.next())
			{
			String r="Employee Id :"+emp;
			String nm="Name :"+rs1.getString("name");
			String add="Address :"+rs1.getString("address_per");
			String em="Email Id :"+rs1.getString("email");
			String gen="Gender :"+rs1.getString("gender");
			String dob="DOB :"+rs1.getString("dob");
			String doj="DOJ :"+rs1.getString("doj");
			String ph="Phone No :"+rs1.getLong("phoneno");
			String qual="Qualification :"+rs1.getString("qual");
			String exp="Experience :"+rs1.getInt("exp");
			String sal="Salary :"+rs1.getLong("salary");
			String did="Department Id :"+rs1.getString("dept_id");
			String type="Type :"+rs1.getString("type");
			 FileOutputStream file = new FileOutputStream(new File("c:\\pdf\\"+emp+".pdf"));
			 Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("c:\\pdf\\"+roll+".pdf"));
			 PdfWriter.getInstance(document, file);
			document.open();
			
		     document.add(new Paragraph("Employee Details"));
		     document.add(new Paragraph(Chunk.NEWLINE));
		     document.add(new Paragraph(r));
		     document.add(new Paragraph(nm));
		     document.add(new Paragraph(add));
		     document.add(new Paragraph(em));
		     document.add(new Paragraph(gen));
		     document.add(new Paragraph(dob));
		     document.add(new Paragraph(doj));
		     document.add(new Paragraph(ph));
		     document.add(new Paragraph(qual));
		     document.add(new Paragraph(exp));
		     document.add(new Paragraph(sal));
		     document.add(new Paragraph(did));
		     document.add(new Paragraph(type));
		   
		     
	            System.out.println("Pdf created successfully.");
	            document.close();
			     file.close();
			     String message = "Pdf file created successfully. filename-"+emp;
			  		response.sendRedirect("/college_erp/jsp/viewdetaile.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
	
	}

}
