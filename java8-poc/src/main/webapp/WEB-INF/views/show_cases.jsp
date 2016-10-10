<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>List Page</title>
</head>
<body>
<h2>Show cases</h2>
<table width="50%">
	<tr>
		<th>Reference Number</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Circumstance</th>
		<th>Registration Number</th> 
	</tr>
	<c:forEach items="${casesForm.cases}" var="cases" varStatus="status">
		<tr>
			<td>${cases.refno}</td>
			<td>${cases.firstname}</td>
			<td>${cases.lastname}</td>
			<td>${cases.circumstance}</td>
			<td>${cases.regDate}</td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="button" value="Back" onclick="javascript:history.back()"/>
 <input type="button" value="Edit" onclick="location.href='/java8-poc/getlist'"/>
</body>
</html>