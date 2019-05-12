<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Add Results</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="main_content">
    <div class="content">
        <h1>Employee Add Results</h1>
        ${resultsMessage}
        <br>
        <br>
        <a href="employee-add">Back to Employee Add Page</a>
    </div>
    <c:import var = "menudata" url = "Menu.jsp"/>   
    ${menudata}
    </div> 
    <c:import var = "data" url = "Footer.jsp"/>   
      ${data}
</body>
</html> 