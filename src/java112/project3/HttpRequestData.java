package java112.project3;


/**
*
* Here is where we have our getters and setters for the HTTP request
* @author jpabon 
*/

public class HttpRequestData {
    //Setting the private instance variables for the HTTP request data
    private String remoteComputerString;
    private String requestMethod;
    private String requestUri;
    private String requestUrl;
    private String requestProtocol;
    private String serverName;
    private int serverPortNumber;
    private String serverLocale;
    private String queryString;
    private String queryParameter;
    private String userAgent;


    /**
    * Gets the remote computer's string
    * @return remoteCOmputerString the remote computer string is returned
    */
    public String getRemoteComputerString(){
        return this.remoteComputerString;
    }   
    /**
    * Sets the remote computer string for the HTTPRequestData class
    * @param remoteComputerString
    */
    public void setRemoteComputerString(String remoteComputerString){
        this.remoteComputerString = remoteComputerString;
    }
    /**
    * Gets the request method
    * @return requestMethod The request method is returned
    */
    public String getRequestMethod(){
        return this.requestMethod;
    }
    /**
    * Sets the request method for the HTTPRequestData class
    * @param requestMethod
    */

    public void setRequestMethod(String requestMethod){
        this.requestMethod = requestMethod;
    }
    /**
    * Gets the requestUri
    * @return requestUri The requestUri is returned
    */

    public String getRequestUri(){
        return this.requestUri;
    }
    /**
    * Sets the requestUri for this class
    * @param requestUri
    */

    public void setRequestUri(String requestUri){
        this.requestUri = requestUri;
    }
    /**
    * Gets the reqeust URL attribute
    * @return requestUrl The requestUrl is returned
    */
    public String getRequestUrl(){
        return this.requestUrl;
    }
    /**
    * Sets the request URL for this class
    * @param requestUrl
    */
    public void setRequestUrl(String requestUrl){
        this.requestUrl = requestUrl;
    }
    /**
    * Gets the request protocol
    * @return requestProtocol request protocol is returned
    */
    public String getRequestProtocol(){
        return this.requestProtocol;
    }
    /**
    * Sets the request protocol's name attribute for this class
    * @param requestProtocol
    */
    public void setRequestProtocol(String requestProtocol){
        this.requestProtocol = requestProtocol;
    }
    /**
    * Gets the Server name attribute
    * @return Server Name The server name is returned
    */

    public String getServerName(){
        return this.serverName;
    }
    /**
    * Sets the server name attribute for this class
    * @param serverName
    */

    public void setServerName(String serverName){
        this.serverName = serverName;
    }
    /**
    * Gets the serverportnumber's name attribute
    * @return serverportnumber The stuent's name is returned
    */

    public int getServerPortNumber(){
        return this.serverPortNumber;
    }
    /**
    * Sets the server port number name
    * @param ServerPortNumber
    */
    //Gets the server port number
    public void setServerPortNumber(int serverPortNumber){
        this.serverPortNumber = serverPortNumber;
    }
    /**
    * Gets the server locales name attribute
    * @return serverLocale The server is returned.
    */

    public String getServerLocale(){
        return this.serverLocale;
    }
    /**
    * Sets the serverlocal's name attribute for the this class
    * @param serverLocale 
    */

    public void setServerLocale(String serverLocale){
        this.serverLocale = serverLocale;
    }
    /**
    * Gets the query string name attribute
    * @return queryString The query string has been removed.
    */

    public String getQueryString(){
        return this.queryString;
    }
    /**
    * Sets the queryString regarding the name attribute for the HTTPRequestData
    * @param queryString
    */

    public void setQueryString(String queryString){
        this.queryString = queryString;
    }
    /**
    * Gets the query parameter attribute
    * @return queryParameter is returned.
    */
    public String getQueryParameter(){
        return this.queryParameter;
    }
    /**
    * Sets the query parameters's name attribute for this class
    * @param queryParameter 
    */
    public void setQueryParameter(String queryParameter){
        this.queryParameter = queryParameter;
    }
    /**
    * Gets the user agent name attribute
    * @return userAgent The student's name is returned
    */
    public String getUserAgent(){
        return this.userAgent;
    }
    /**
    * Sets the user agent name attribute for this class
    * @param userAgent 
    */
    public void setUserAgent(String userAgent){
        this.userAgent = userAgent;
    }
}

