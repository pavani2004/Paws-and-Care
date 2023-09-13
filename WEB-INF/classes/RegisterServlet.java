import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisterServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String username = req.getParameter("username");
String password = req.getParameter("password");
String email= req.getParameter("email");
String phone= req.getParameter("phone");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","1234");
String q = "insert into pet_user(username, password, email, phone) values(?,?,?,?)";
PreparedStatement stm = con.prepareStatement(q);
stm.setString(1, username);
stm.setString(2, password);
stm.setString(3, email);
stm.setString(4, phone);
int x = stm.executeUpdate();
System.out.println("Data upadated sucessfully...." + x);
if(x > 0){
res.sendRedirect("main.html");
}
else{
out.println("<html>Register Not successful</html>");
}
con.close();}
catch(Exception e){
out.print(e);
}}}