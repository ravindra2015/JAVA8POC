<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <h2>Customer Search</h2>
       <form:form method="post" action="search">    
        <table border="1" width="0%" > 
        <thead style="background-color: #bce8f1;">   
         <tr>    
          <td><form:label path="firstName">FirstName :</form:label></td>   
          <td><form:input path="firstName"/></td>  
         </tr>    
         <tr>    
          <td><form:label path="lastName">LastName :</form:label></td>    
          <td><form:input path="lastName" /></td>  
         </tr>   
         <tr>    
          <td colspan="2" align="center"><input type="button" value="Back" onclick="javascript:history.back()"/><input type="submit" value="Search" /></td>    
         </tr>    
        </table>    
       </form:form>    