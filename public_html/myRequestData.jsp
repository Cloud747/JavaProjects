<!DOCTYPE html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Website short description." />
    <meta name="keywords" content="website main keywords" />
    <title>
      Welcome to my home page!
    </title>
    <link href="style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div id="container">
      <div id="header">
        <h1>
          This is my homepage!
        </h1>
      </div>
      <div id="sub_header">
        ... come with me and you'll be in a world of pure imagination
      </div>
      <div id="main_content_top"></div>
      <div id="main_content">
        <div class="content">
          <h2>
            HTTP Details:
          </h2>
          <ul>
            <li>Remote Computer String: ${httpRequestData.remoteComputerString}</li>
            <li>Request Method: ${httpRequestData.requestMethod}</li>
            <li>Request URI: ${httpRequestData.requestUri}</li>
            <li>Request URL: ${httpRequestData.requestUrl}</li>
            <li>Request Protocol: ${httpRequestData.requestProtocol}</li>
            <li>Server Name: ${httpRequestData.serverName}</li>
            <li>Server Port Number: ${httpRequestData.serverPortNumber}</li>
            <li>Server Locale: ${httpRequestData.serverLocale}</li>
            <li>Query String: ${httpRequestData.queryString}</li>
            <li>Query Parameter: ${httpRequestData.queryParameter}</li>
            <li>User Agent: ${httpRequestData.userAgent}</li>
          </ul>
          
          
        </div>
        <div class="menu">
          <div class="menu_title">
            Main menu
          </div>
          <ul>
            <li>
              <a href="#about-me" class="menu_link">About me</a>
            </li>
            <li>
              <a href="#contact-me" class="menu_link">Contact me</a>
            </li>
          </ul>
          <div class="menu_title">
            Check out the link below:
          </div>
          <ul>
            <li>
                <a href ="linkingDemo.html" class="menu_link">Linking Demo page</a>
            </li>
          </ul>
          <div class="menu_title">
            More links:
          </div>
          <ul>
            <li>
                <a href ="first112" class="menu_link">To my servlet</a>
            </li>
            <li>
                <a href ="project3-properties" class="menu_link">Properties Page</a>
            </li>
            <li>
              <a href ="request-servlet?queryParameter=WinterSucks" class="menu_link">Request-Servlet</a>
            </li>
          
          </ul>
        </div>
        <div id="clear"></div>
      </div>
      <div id="main_content_bottom"></div>
      <div id="footer">
        <strong>Copyright © 2007</strong> | <a href="#">Your Site</a> | <b>Design by</b> <a href=
        "http://www.pikanai.com">Pikanai.com</a>
      </div>
    </div>
  </body>
</html>



