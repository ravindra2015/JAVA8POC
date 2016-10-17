<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <h2>Customer Information </h2>
   <form:form method="post" action="#">   
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
   <input type="button" value="Back" onclick="location.href='/java8-poc/customerform'"/>
 <input type="button" value="SortAge" onclick="location.href='/java8-poc/sortByage'"/>
 <input type="button" value="SortDate" onclick="location.href='/java8-poc/sortByDate'"/>
  <input type="button" value="SortFirstName" onclick="location.href='/java8-poc/sortByFirstName'"/>
  <input type="button" value="SortLastName" onclick="location.href='/java8-poc/sortByLastName'"/>
  <input type="button" value="SortCity" onclick="location.href='/java8-poc/sortByCity'"/>
  </td>
   </tr>
<!--    <tr> -->
<!--    <td colspan="15"> -->
<!--    <a href="customerform">Back</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sort">SortAge</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sortByDate">SortDate</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sortByFirstName">SortFirstName</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sortByLastName">SortLastName</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="sortByCity">SortCity</a> -->
<!--    </td> -->
<!--    </tr> -->
   </table>  
   <br/>

   </form:form>
