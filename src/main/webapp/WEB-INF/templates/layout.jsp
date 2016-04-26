<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title><fmt:message key="site.title" /></title>
		
		<link href="<c:url value='/resources/css/bootstrap.css' />"  rel="stylesheet" type="text/css"></link>
		<link href="<c:url value='/resources/css/springmvc.css' />"  rel="stylesheet" type="text/css"></link>
	</head>
	<body>
		<fmt:message key="site.title" />
		<tiles:insertAttribute name="header" />
		<div id="mainContent" class="container">
			<tiles:insertAttribute name="body" />
		</div>	
		<tiles:insertAttribute name="footer" />
	</body>
</html>
