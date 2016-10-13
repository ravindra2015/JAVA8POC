<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Edit Case</title>
</head>
<body>

<h2>Spring MVC Multiple Row Form Submit example</h2>
<form:form method="post" action="save.html" modelAttribute="casesForm">
	<table>
	<tr>
		<th>No.</th>
		<th>Reference Number</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Circumstances</th>
		<th>Registration Date</th>
	</tr>
	<c:forEach items="${casesForm.cases}" var="cases" varStatus="status">
<%-- 			<tr>
			<td>${cases.refno}</td>
			<td>${cases.firstname}</td>
			<td>${cases.lastname}</td>
			<td>${cases.circumstance}</td>
			<td>${cases.regDate}</td>
		</tr> --%>
		<tr>
			<td align="center">${status.count}</td>
			<td><input name="cases[${status.index}].refno" value="${cases.refno}"/></td>
			<td><input name="cases[${status.index}].firstname" value="${cases.firstname}"/></td>
			<td><input name="cases[${status.index}].lastname" value="${cases.lastname}"/></td>
			<td><input name="cases[${status.index}].circumstance" value="${cases.circumstance}"/></td>
			<td><input name="cases[${status.index}].regDate" value="${cases.regDate}"/></td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="submit" value="Save" />
	
</form:form>
</body>
</html>