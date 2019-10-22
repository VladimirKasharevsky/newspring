<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

<title> My servlet </title>

</head>
<body>
<table border="1">
   <tr>
       <th>ID</th><th>Name</th><th>Pass</th><th>Role</th><th>DELL</th><th>UPDATE</th>
   </tr>
   <tr>

    <c:forEach items="${list}" var="list">
        <tr>
            <td><c:out value="${list.id}" /></td>
            <td><c:out value="${list.name}" /></td>
            <td><c:out value="${list.password}" /></td>
            <td><c:out value="${list.role}" /></td>
            <td>
               <form action="admin/delete?id=${list.id}" method="post">
               <input type="submit" value="delete"></form></td>

             <td>
               <form action="admin/update" method="get">
               <input type="hidden" name="id" value="${list.id}">
               <input type="submit" value="update"></form></td>
        </tr>
    </c:forEach>
</table>

<h2>Add Info</h2>
<form:form  action="admin/create" method="post" modelAttribute="User">
 <p> Name:      <input type="text" name="name"> </p>
 <p> Password:  <input type="text" name="password"> </p>
 <p>Role:</p>
 <p><select name="role" value="${role}">
        <option disabled>role</option>
        <option>user</option>
        <option>admin</option>
       </select></p>
    <input type="submit" value="submit"/>
</form:form>

</body>
</html>