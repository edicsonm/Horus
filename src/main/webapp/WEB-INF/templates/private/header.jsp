<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <!-- <a href="$!app_context" class="navbar-brand">
 	  	<img alt="Brand" src="#springUrl('/resources/img/horusIcon3.png')">
      </a> -->
    </div>
    <div class="navbar-collapse collapse" id="navbar">
      <ul class="nav navbar-nav">
        <li><a href="<c:url value="/" />"><fmt:message key="label.home" /></a></li>
        <li><a href="<c:url value="/dashBoard" />"> <fmt:message key="label.transactionalReports"/></a></li>
        <li><a href="#"><fmt:message key="label.onlineMonitor"/></a></li>
        <li><a href="#"><fmt:message key="label.businessesIntelligence"/></a></li>
        <li><a href="#"><fmt:message key="label.iseriesMonitor"/></a></li>
        <!-- <li class="active"><a href="<c:url value="/" />"><fmt:message key="label.home" /></a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
        <li class="dropdown">
          <a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="#">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider" role="separator"></li>
            <li class="dropdown-header">Nav header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <%-- <li><a href="../navbar/"> <fmt:message key="label.transactionalReports"/></a></li>
        <li><a href="../navbar-static-top/"><fmt:message key="label.onlineMonitor"/></a></li>
        <li><a href="../navbar-static-top/"><fmt:message key="label.businessesIntelligence"/></a></li>
        <li><a href="../navbar-static-top/"><fmt:message key="label.iseriesMonitor"/></a></li> --%>
        <%-- <li class="active"><a href="./"><fmt:message key="label.iseriesMonitor"/><span class="sr-only">(current)</span></a></li>
         --%><li class="dropdown">
        	<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="#"><fmt:message key="label.language" /><span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><span><img alt="Brand" src="<c:url value='/resources/img/colombia32.png' />"><a href="?lang=es"><fmt:message key="label.language.espaniol" /></a></span></li>
	            <li><span><img alt="Brand" src="<c:url value='/resources/img/australia32.png' />"><a href="?lang=en"><fmt:message key="label.language.english" /></a></span></li>
	          </ul>
        </li>
        <li><a href="<c:url value="/logout" />"><fmt:message key="label.logout"/></a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

    