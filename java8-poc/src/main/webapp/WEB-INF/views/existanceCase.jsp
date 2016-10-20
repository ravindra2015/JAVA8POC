<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<c:if test="${!ajaxRequest}">
<html>
<head>
	<title>Existance Case</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>
</c:if>
	<div id="formsContent">
		<h2>Case Details</h2>
		<form:form id="form" method="post" action="displayList.html" name="ExistanceCase" modelAttribute="existanceCaseBean" cssClass="cleanform">
			<div class="header">
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>Existance Case</legend>
		  		<form:label path="refno">
		  			Reference Number <form:errors path="refno" cssClass="error" />
		 		</form:label>
		  		<form:input path="refno" />
		  		
		  		<form:label path="callCenter">
					Call Center
				</form:label>
				<form:select path="callCenter">	
				    <form:option value="">SELECT CALL CENTER</form:option>
					<form:option value="AWL">AWL</form:option>
					<form:option value="EXTERNAL">EXTERNAL</form:option>
					<form:option value="OTHERS">OTHERS</form:option>
				</form:select>
	
		  	</fieldset>
	
			<p>
			<button type="submit">Submit</button> </p>
		</form:form>
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>