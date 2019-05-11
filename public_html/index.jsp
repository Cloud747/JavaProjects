<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            Welcome to this site.
          </h2>
          <p id="about-me">
            This is about me
          </p>
          <p>
            I live by the quote "knowledge is limited, but your imagination can take you anywhere." I am the architect of 
            my own destiny.
          </p>
          <p id="contact-me">
            Thinking is the beginning of philosophy. 
          </p>
          <p>
            When you put your mind into something important, you can't be afraid of failure. Only when you fail, will you 
            completely cherish the feeling of when you finally succeed. 
          </p>
          <h2>
            I am currently eating popcorn right now.
          </h2>
          <p>
            This is just some text that I am going to add here for the purposes of this project.
          </p>
        </div>
        <c:import var = "menudata" url = "Menu.jsp"/>   
      ${menudata}
      </div>
      <div id="main_content_bottom"></div>
      <c:import var = "data" url = "Footer.jsp"/>   
      ${data}

    </div>
  </body>
</html>



