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
	<thead style="background-color: #bce8f1;">
		<tr>
			<th align="left">First Name</th>
			<th align="left">Last Name</th>
			<th align="left">Age</th>
			<th align="left">City</th>
			<th align="left">Registration Date</th>
		</tr>
		<c:forEach items="${customerShow}" var="customer">
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