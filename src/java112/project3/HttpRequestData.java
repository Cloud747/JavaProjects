package java112.project3;


/**
*
*
* @author jpabon 
*/

public class HttpRequestData {

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



    public String getRemoteComputerString(){
        return this.remoteComputerString;
    }

    public void setRemoteComputerString(String remoteComputerString){
        this.remoteComputerString = remoteComputerString;
    }

    public String getRequestMethod(){
        return this.requestMethod;
    }

    public void setRequestMethod(String requestMethod){
        this.requestMethod = requestMethod;
    }

    public String getRequestUri(){
        return this.requestUri;
    }

    public void setRequestUri(String requestUri){
        this.requestUri = requestUri;
    }

    public String getRequestUrl(){
        return this.requestUrl;
    }

    public void setRequestUrl(String requestUrl){
        this.requestUrl = requestUrl;
    }

    public String getRequestProtocol(){
        return this.requestProtocol;
    }

    public void setRequestProtocol(String requestProtocol){
        this.requestProtocol = requestProtocol;
    }

    public String getServerName(){
        return this.serverName;
    }

    public void setServerName(String serverName){
        this.serverName = serverName;
    }

    public int getServerPortNumber(){
        return this.serverPortNumber;
    }

    public void setServerPortNumber(int serverPortNumber){
        this.serverPortNumber = serverPortNumber;
    }

    public String getServerLocale(){
        return this.serverLocale;
    }

    public void setServerLocale(String serverLocale){
        this.serverLocale = serverLocale;
    }

    public String getQueryString(){
        return this.queryString;
    }

    public void setQueryString(String queryString){
        this.queryString = queryString;
    }

    public String getQueryParameter(){
        return this.queryParameter;
    }

    public void setQueryParameter(String queryParameter){
        this.queryParameter = queryParameter;
    }

    public String getUserAgent(){
        return this.userAgent;
    }

    public void setUserAgent(String userAgent){
        this.userAgent = userAgent;
    }
}

