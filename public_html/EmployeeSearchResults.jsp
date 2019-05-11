<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Search Results</title>
</head>
<body>

<h1>Employee Search Results</h1>

<table>
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
</body>
</html> 