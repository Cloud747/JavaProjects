package java112.project3;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java112.utilities.PropertiesLoader;

import javax.servlet.annotation.*;

/**
 *  This is the servlet for project 3.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
@WebServlet(
    name = "propertiesServlet",
    urlPatterns = { "/project3-properties" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {

    //Creating the instance variables
    private Properties properties;
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
        //Set the attribute
        request.setAttribute("properties", properties);

        String author = properties.getProperty("author.name");
        request.setAttribute("author", author);

        String email = properties.getProperty("author.email");
        request.setAttribute("email", email);

        String course = properties.getProperty("course.name");
        request.setAttribute("course", course);

        String meeting = properties.getProperty("course.meeting.times");
        request.setAttribute("meeting", meeting);

        String instructor = properties.getProperty("instructor.name");
        request.setAttribute("instructor", instructor);

        String description = properties.getProperty("description.information");
        request.setAttribute("description", description);
    

        //Create the url
        String url = "/myPropertiesPage.jsp";

        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
    //overriding the parent class 
    @Override
    public void init() {
        String propertiesFilePath = "/project3.properties";
        properties = loadProperties(propertiesFilePath);
    }
}