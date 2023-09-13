import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class BookServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String username = req.getParameter("username");
String pet_type = req.getParameter("pet_type");
String phone= req.getParameter("phone");
String date= req.getParameter("date");
String treatment= req.getParameter("treatment");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","1234");
String q = "insert into book_doc(username,pet_type,phone,date,treatment) values(?,?,?,?,?)";
PreparedStatement stm = con.prepareStatement(q);
stm.setString(1, username);
stm.setString(2, pet_type);
stm.setString(3, phone);
stm.setString(4, date);
stm.setString(5, treatment);
int x = stm.executeUpdate();
System.out.println("Data upadated sucessfully...." + x);
if(x > 0){
res.sendRedirect("index.html");
}
else{
out.println("<html>Data Not updated!!!</html>");
}
con.close();}
catch(Exception e){
out.print(e);
}}}