<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title> Update Info </title>

</head>
<body>


<h2>Update Info</h2>
<form action="/admin/update" method="post">

<h4>New data</br></h4>
   <p>ID: </p> <input type="text" name="id" value = "${id}" readonly/>
   <p>Name: </p> <input type="text" name="newName" value = "${newName}"/>
   <p>Password:</p> <p><input type="text" name="newPassword" value = "${newPassword}" />
   <p>Role:</p>
   <p><select name="role">
       <option selected> ${role}</option>
       <option>user</option>
       <option>admin</option>
      </select></p>
    <input type="submit" value="update">
</form>

</body>
</html>