import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddressServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String email = req.getParameter("email");
String address = req.getParameter("address");
String city= req.getParameter("city");
String state= req.getParameter("state");
String zipcode= req.getParameter("zipcode");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","1234");
String q = "insert into pet_pay(email,address,city,state,zipcode) values(?,?,?,?,?)";
PreparedStatement stm = con.prepareStatement(q);
stm.setString(1, email);
stm.setString(2, address);
stm.setString(3, city);
stm.setString(4, state);
stm.setString(5, zipcode);
int x = stm.executeUpdate();
System.out.println("Data upadated sucessfully...." + x);
if(x > 0){
res.sendRedirect("pay.html");
}
else{
out.println("<html>Data Not updated!!!</html>");
}
con.close();}
catch(Exception e){
out.print(e);
}}}