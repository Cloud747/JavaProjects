package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java112.utilities.PropertiesLoader;

import javax.servlet.annotation.*;

/**
 *  This is the servlet for project 2.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
@WebServlet(
    name = "PropertiesServlet",
    urlPatterns = { "/properties" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {
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
        // Here is where we are loading the properties and passing in the file path
        Properties properties = this.loadProperties("WEB-INF/classes/project2.properties");
        //implicit data
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        //explicit data
        // found some ideas on the w3schools website to table creations
        out.print("<HTML>");
        out.print("<HEAD><TITLE>My very own servlet</TITLE></HEAD>");
        out.print("<img src='" + request.getContextPath() + "/images/sonic.jpg' alt='Sonic The Hedgehog'/>");
        out.print("<BODY>"); 
        out.print("<h1>This is the beginning of a beautiful thing</h1>");
        out.print("<TABLE>");
        out.print("<TR>");
        out.print("<TD>Name:</TD><TD>" + properties.getProperty("author")+ " </TD>");
        out.print("</TR>");
        out.print("<TR>");
        out.print("<TD>Email:</TD><TD>" + properties.getProperty("author.email")+ " </TD>");
        out.print("</TR>");
        out.print("<TR>");
        out.print("<TD>Course Name:</TD><TD>" + properties.getProperty("course.name")+ " </TD>");
        out.print("</TR>");
        out.print("<TR>");
        out.print("<TD>Meeting times:</TD><TD>" + properties.getProperty("course.meeting.times")+ "</TD>");
        out.print("</TR>");
        out.print("<TR>");
        out.print("<TD>Instructor:</TD><TD>" + properties.getProperty("instructor.name")+ " </TD>");
        out.print("</TR>");
        out.print("<TR>");
        out.print("<TD>Course overview:</TD><TD>" + properties.getProperty("description.information")+ "</TD>");
        out.print("</TR>");
        out.print("</TABLE>");
        out.print("<A HREF=\"index.jsp\">Take me back home</A>");
        System.out.println("Is this logging? - this is from a sout");
        log("Is this logging? <= is from the log");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
    /**
    * This method follows a similar structure to the properties loader class. The idea was captured there and brought to life here.
    * Load properties method is passing in the filepath parameter 
    *@param filepath passing in the filepath for the load properties
    */
    public Properties loadProperties(String filepath) {
        ServletContext application = getServletConfig().getServletContext();
        String realPath = application.getRealPath(filepath);
        Properties properties = new Properties();
         try {
            FileInputStream fis = new FileInputStream(realPath);
            properties.load(fis);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return properties;
    }
}