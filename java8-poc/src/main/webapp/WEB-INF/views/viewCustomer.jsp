<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <h2>Customer Information </h2>
<table border="2" width="70%" cellpadding="2">  
<thead style="background-color: #bce8f1;">
<tr><th align="left">FirstName</th><th align="left">LastName</th><th align="left">Age</th><th align="left">City</th><th align="left">Register Date</th></tr>  
   <c:forEach var="customer" items="${foundCustomer}">   
   <tr>  
   <td>${customer.firstName}</td>  
   <td>${customer.lastName}</td>  
   <td>${customer.age}</td>
   <td>${customer.city}</td>
   <td>${customer.dateOfRegister}</td>  
   </tr>  
   </c:forEach>  
   <tr>
   <td colspan="15">
   <input type="button" value="Back" onclick="javascript:history.back()"/>
   </td>
   </tr>
   </table>  
