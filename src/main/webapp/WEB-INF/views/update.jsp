<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title> Update Info </title>

</head>
<body>


<h2>Update Info</h2>
<h4>New data</br></h4>
<form:form action="/admin/update" method="post">
   <p>ID:      <input type="text" name="id" value = "${user.id}" readonly> </p>
   <p>Name:    <input type="text" name="name" value = "${user.name}"> </p>
   <p>Password:<input type="text" name="password" value = "${user.password}" /> </p>
   <p>Role:</p>
   <p><select name="role">
       <option selected> ${user.role}</option>
       <option>user</option>
       <option>admin</option>
      </select></p>
    <input type="submit" value="update">
</form:form>
</body>
</html>