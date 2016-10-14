<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Login</title></head>
<body>
  <form:form action="userCheck" method="post">
   Enter First Name:<input type="text" name="firstName"> <br/>
   Enter Last Name :<input type="password" name="firstName"/><br/>
   <input type="submit">
  </form:form>
</body>
</html>