<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <h2>Customer Sort By Age</h2>
       <form:form method="post" action="sort">    
        <table border="1" width="0%" > 
        <thead style="background-color: #bce8f1;">   
         <tr>    
          <td><form:label path="age">Age :</form:label></td>   
          <td><form:input path="age"/></td>  
         </tr>      
         <tr>    
          <td colspan="2" align="center"><input type="button" value="Back" onclick="javascript:history.back()"/><input type="submit" value="Sort"></td>    
         </tr>    
        </table>    
       </form:form>    