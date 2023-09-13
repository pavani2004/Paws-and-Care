import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
public class LoginServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String uname = req.getParameter("username");
String upassword = req.getParameter("password");
try{
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","1234");
Statement stm = con.createStatement();
ResultSet rs = stm.executeQuery("select * from pet_user where username='"+uname+"'and password='"+upassword+"'");
if(rs.next()){
res.sendRedirect("Home.html");
}
else{
res.sendRedirect("main.html");
}
con.close();
}catch(Exception e){
System.out.println(e.getMessage());
}
}
}