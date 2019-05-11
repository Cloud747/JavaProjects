<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Add Page</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<h1>Adding Employees</h1>
${errorMessage}
<div id="main_content">
    <div class="content">
        <h2>
        Have Fun Adding Employees
        </h2>
        <form method="POST" action="employee-add-results">
            First Name:<br>
            <input type="text" name="firstname"><br>
            Last Name:<br>
            <input type="text" name="lastname"><br>
            Social Security:<br>
            <input type="text" name="socialsecurity"><br>
            Department:<br>
            <input type="text" name="department"><br>
            Phone Number:<br>
            <input type="text" name="phonenumber"><br>
            Room Number:<br>
            <input type="text" name="roomnumber">
            <br>
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