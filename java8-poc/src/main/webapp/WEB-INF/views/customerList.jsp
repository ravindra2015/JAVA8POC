<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List Customer</title>
</head>
<body>
	<h2>Show Customers</h2>
	<table width="50%" border="1">
	<thead style="background-color: #D3D3D3;">
		<tr>
			<th align="left" style="background-color: #bce8f1;"><a href="sortByFirstName">First Name</a></th>
			<th align="left" style="background-color: #bce8f1;"><a href="sortByLastName">Last Name</a></th>
			<th align="left" style="background-color: #bce8f1;"><a href="sortByAge">Age</a></th>
			<th align="left" style="background-color: #bce8f1;"><a href="sortByCity">City</a></th>
			<th align="left" style="background-color: #bce8f1;"><a href="sortByDate">Registration Date</a></th>
		</tr>
		<c:forEach items="${getCustomerList}" var="customer">
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
  <input type="button" value="Back" onclick="location.href='/java8-poc/#customer'"/>
   </td>
   </tr>
	</table>