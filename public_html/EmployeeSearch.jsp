<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Search</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>


<div id="main_content">
    <div class="content">
        <h1>Employee Search Page</h1>

        <form action="employee-search-results">
            Search Term:<br>
            <input type="text" name="searchterm"><br>
            <br>
            Search Type:<br>
            <input type="radio" name="searchtype" value="id" checked>ID<br>
            <input type="radio" name="searchtype" value="firstname"> First Name<br>
            <input type="radio" name="searchtype" value="lastname"> Last Name<br>
            <br>
            <input type="submit" value="Submit">
        </form> 
    </div>
    <c:import var = "menudata" url = "Menu.jsp"/>   
    ${menudata}
    </div> 
    <c:import var = "data" url = "Footer.jsp"/>   
      ${data}
</body>
</html> 