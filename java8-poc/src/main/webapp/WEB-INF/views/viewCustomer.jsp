<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <h2>Customer Information </h2>
   <form:form method="post" action="#">   
<table border="2" width="70%" cellpadding="2">  
<thead>
<tr>
<th align="left" style="background-color: #bce8f1;">FirstName</th>
<th align="left" style="background-color: #bce8f1;">LastName</th>
<th align="left" style="background-color: #bce8f1;">Age</th>
<th align="left" style="background-color: #bce8f1;">City</th>
<th align="left" style="background-color: #bce8f1;">Register Date</th>
</tr>  
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
   <input type="button" value="Back" onclick="location.href='/java8-poc/customerform'"/>
  </td>
   </tr>
   </table>  
   <br/>

   </form:form>
