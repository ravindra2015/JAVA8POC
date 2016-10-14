<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
 
<table border="2" width="70%" cellpadding="2">  
<tr><th>FirstName</th><th>LastName</th></tr>  
   <c:forEach var="cust" items="${foundObjs}">   
   <tr>  
   <td>${cust.firstName}</td>  
   <td>${cust.lastName}</td>   
   </tr>  
   </c:forEach>  
   </table>  