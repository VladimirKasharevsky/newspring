<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

<title> My servlet </title>

</head>
<body>

<h2>LOGIN</h2>
<form:form  action="admin/create" method="post">
 <p> Name:      <input type="text" name="name"> </p>
 <p> Password:  <input type="text" name="password"> </p>
</form:form>

</body>
</html>