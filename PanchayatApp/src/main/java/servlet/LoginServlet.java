package servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        String department = request.getParameter("department");

        if("admin".equals(username) && "1234".equals(password)) {
 
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("dept", department);

   
            response.sendRedirect("adminDashboard.html");

        } else {
            response.getWriter().println("Invalid Username or Password");
        }
    }
}