package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.net.*;

/**
 *  This is the servlet for project 3.
 *
 *@author    jpabon
 */
 //annotation - hints to the server of what needs to be done
 @WebServlet(
    name = "httpRequestServlet", 
    urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {
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
        HttpRequestData httpRequestData = new HttpRequestData();
        /**
         *  private int remoteComputerString; - done
            private String requestMethod; - done
            private String requestUri; - done
            private String requestUrl; - done 
            private String requestProtocol; - done
            private String serverName; - done 
            private int serverPortNumber; - done
            private String serverLocale; - done
            private String queryString; - done
            private String queryParameter; 
            private String userAgent;
         */
        httpRequestData.setRequestUri(request.getRequestURI());
        httpRequestData.setQueryString(request.getQueryString());
        httpRequestData.setServerName(request.getServerName());
        httpRequestData.setServerPortNumber(request.getServerPort());
        httpRequestData.setRequestUrl(request.getRequestURL().toString());
        httpRequestData.setRequestMethod(request.getMethod());
        httpRequestData.setRemoteComputerString(getComputerName(request));
        httpRequestData.setRequestProtocol(request.getProtocol());
        httpRequestData.setServerLocale(request.getLocale().toString());
        httpRequestData.setQueryParameter(request.getParameter("queryParameter"));
        httpRequestData.setUserAgent(request.getHeader("User-Agent"));
        
        request.setAttribute("httpRequestData", httpRequestData);
       
        //Create the url
        String url = "/myRequestData.jsp";

        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }
    //Found this code on https://coderanch.com/t/207250/java/Client-machine for the remote computer string
    private String getComputerName(HttpServletRequest request) {
        String hostName = request.getRemoteHost();
        try {
                if (hostName.equals(request.getRemoteAddr())) {
                        InetAddress addr = InetAddress.getByName(request.getRemoteAddr());
                        hostName = addr.getHostName();
                }

                if (InetAddress.getLocalHost().getHostAddress().equals(request.getRemoteAddr())) {
                        hostName = "Local Host";
                }

        }
        catch (UnknownHostException e) {
                e.printStackTrace();
        }
        return hostName;
    }
}