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
 * Servlet implementation class Topdfstd
 */
@WebServlet("/Topdfstd")
public class Topdfstd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Topdfstd() {
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
		String roll=request.getParameter("roll");
		
		try {
			String strsql="select * from student where rollno=?";
			Connection con=CrudOperation.createConnection();
			PreparedStatement ps=con.prepareStatement(strsql);
			ps.setString(1,roll);
			ResultSet rs1=ps.executeQuery();
			if(rs1.next())
			{
			String r="Roll No :"+roll;
			String nm="Name :"+rs1.getString("name");
			String add="Address :"+rs1.getString("address");
			String em="Email Id :"+rs1.getString("email");
			String gen="Gender :"+rs1.getString("gender");
			String dob="DOB :"+rs1.getString("dob");
			String doa="DOA :"+rs1.getString("doa");
			String sem="Current Sem :";
			int s=rs1.getInt("current_sem");
			String cid="Course Id :"+rs1.getString("course_id");
			String ph="Phone No :";
			Long pp=rs1.getLong("phoneno");
			String py="Batch :"+rs1.getString("pass_yr");
			
			 FileOutputStream file = new FileOutputStream(new File("c:\\pdf\\"+roll+".pdf"));
			 Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("c:\\pdf\\"+roll+".pdf"));
			 PdfWriter.getInstance(document, file);
			document.open();
			
		     document.add(new Paragraph("Student Details"));
		     document.add(new Paragraph(Chunk.NEWLINE));
		     document.add(new Paragraph(r));
		     document.add(new Paragraph(nm));
		     document.add(new Paragraph(add));
		     document.add(new Paragraph(em));
		     document.add(new Paragraph(gen));
		     document.add(new Paragraph(dob));
		     document.add(new Paragraph(doa));
		     document.add(new Paragraph(sem+s));
		     document.add(new Paragraph(cid));
		     document.add(new Paragraph(ph+pp));
		     document.add(new Paragraph(py));
	            System.out.println("Pdf created successfully..");
	            document.close();
			     file.close();
			     String message = "Pdf file created successfully. filename-"+roll;
			  		response.sendRedirect("/college_erp/jsp/viewdetails.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
				
	}

}
