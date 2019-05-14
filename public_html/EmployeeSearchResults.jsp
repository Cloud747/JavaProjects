<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Search Results</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- Templating goes below to ensure the JSP pages have some sort of customizations-->
<div id="main_content">
    <div class="content">
    <h1>Employee Search Results</h1>
    Search Term: ${searchTerm}
    <br>
    <br>
    Search Type: ${searchType}
    <br>
    <br>
    <!--Below is the created table and the JSTL for each loop to go through-->
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Social Security</th>
            <th>Department</th>
            <th>Phone Number</th>
            <th>Room Number</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.employeeID}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.socialSecurity}</td>
            <td>${employee.department}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.roomNumber}</td>
        </tr>
        </c:forEach>
    </table>
    </div>
    <c:import var = "menudata" url = "Menu.jsp"/>   
    ${menudata}
    </div> 
    <c:import var = "data" url = "Footer.jsp"/>   
    ${data}
</body>
</html> 