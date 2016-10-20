<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>List Page</title>
</head>
<body>
<h2>Show cases</h2>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th align="left" style="background-color: #bce8f1;">Reference Number</th>
		<th align="left" style="background-color: #bce8f1;">Call Center</th>
		<th align="left" style="background-color: #bce8f1;">First Name</th>
		<th align="left" style="background-color: #bce8f1;">Last Name</th>
		<th align="left" style="background-color: #bce8f1;">Circumstance</th>
		<th align="left" style="background-color: #bce8f1;">Registration Number</th>
	</tr>
	<c:forEach items="${foundCases}" var="cases" varStatus="status">
		<tr>
			<td>${cases.refno}</td>
			<td>${cases.callCenter}</td>
			<td>${cases.firstname}</td>
			<td>${cases.lastname}</td>
			<td>${cases.circumstance}</td>
			<td>${cases.regDate}</td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>