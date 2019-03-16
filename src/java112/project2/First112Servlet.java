package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is the servlet for project 2.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
@WebServlet(
    name = "First112Servlet",
    urlPatterns = { "/first112" }
)
public class First112Servlet extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
     //Be sure to check the content type
     public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //implicit data
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        //explicit data
        out.print("<HTML>");
        out.print("<HEAD><TITLE>My very own servlet</TITLE>");
        out.print("<link rel= 'stylesheet' type='text/css' href= './SimpleBeauty/style.css'>");
        out.print("</HEAD>");
        out.print("<img src='" + request.getContextPath() + "/images/sonic.jpg' alt='Sonic The Hedgehog'/>");
        out.print("<BODY>");
        out.print("<h1>My own servlet</h1>");
        out.print("<P>Name: Jonathan Pabon</P>");
        out.print("<P>Course: Advanced Java Programming</P>");
        out.print("<A HREF=\"index.jsp\">Take me back home</A>");
        System.out.println("Is this logging? - this is from a sout");
        log("Is this logging? <= is from the log");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}