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
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class Topdfstdm
 */
@WebServlet("/Topdfstdm")
public class Topdfstdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Topdfstdm() {
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
		String cs=request.getParameter("cs");
		int sem=Integer.parseInt(request.getParameter("sem"));
		int i=0,x=0,n=0;
		try
		{
			FileOutputStream file = new FileOutputStream(new File("marks"+roll+sem+".pdf"));
			 Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			 PdfWriter.getInstance(document, file);
				document.open();
				
			     document.add(new Paragraph("Student Marks Details"));
			     document.add(new Paragraph("Roll No :"+roll));
			     document.add(new Paragraph(Chunk.NEWLINE));
			     String strsql="select * from subjects s,marks m where s.courseid=? and s.sem=? and m.student_id=? and s.sub_id=m.subject_id";
			     Connection con=CrudOperation.createConnection();
			     PreparedStatement ps=con.prepareStatement(strsql);
			     ps.setString(1,cs);
			     ps.setInt(2,sem);
			     ps.setString(3,roll);
			     ResultSet rs1=ps.executeQuery();
			     
			     PdfPTable table=new PdfPTable(4);
			    PdfPCell cell = new PdfPCell (new Paragraph ("Semester "+sem+" Marks"));
			     cell.setColspan(4);
			      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
			   
			     table.addCell(cell);	
			     
			     table.addCell("Subject Id");
			      table.addCell("Subject Name");
			      table.addCell("Internal Marks");
                table.addCell("External Marks");
			     while(rs1.next())
			     {
			     
			     	i+=rs1.getInt("int_marks");
			     	x+=rs1.getInt("ext_marks");
			     	n++;
			     	 table.addCell(rs1.getString("sub_id"));
				      table.addCell(rs1.getString("name"));
				      table.addCell(rs1.getString("int_marks"));
				      table.addCell(rs1.getString("ext_marks"));
			     }
			     document.add(new Paragraph(Chunk.NEWLINE));
			    	if(n!=0)
			    		i=i/n;
			    	else
			    		i=0;
			    String ix="Percentage (Internal) :"+i+"%";
			    if(n!=0)
			    	x=x/n;
			    else
			    	x=0;
			    String ex="Percentage (External) :"+x+"%";
			    if(n!=0)
			    n=(i+x)/2;	
			    String ox="Overall Percentage :"+n+"%";
			     
			    document.add(table);
			    document.add(new Paragraph(ix));
			    document.add(new Paragraph(ex));
			    document.add(new Paragraph(ox));
			      
			      System.out.println("Pdf created successfully..");
		            document.close();
				     file.close();
				     String message = "Pdf file saved successfully.";
				  		response.sendRedirect("/college_erp/jsp/viewmarkk.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			     
		}
		catch(Exception e)
		{
			
		}
	}

}
