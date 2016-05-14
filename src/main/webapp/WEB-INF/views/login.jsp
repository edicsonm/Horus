<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url var="loginUrl" value="/login" />
<div class="row">
	<div class="col-xs-1 col-md-3"></div>
	<div class="col-xs-10 col-md-6">
		<form  action="${loginUrl}" method="post" class="form-signin">
			<div class="jumbotron">
				<c:url var="loginUrl" value="/login" />
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>
								<fmt:message key="message.error.userName" />
							</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>
								<fmt:message key="message.info.logged" />
							</p>
						</div>
					</c:if>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"> <i
							class="fa fa-user"></i>
						</label> <input type="text" class="form-control" id="username" name="ssoId"
						 value="edicson" placeholder="<fmt:message key="placeholder.userName" />" required>
					</div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i
							class="fa fa-lock"></i></label> <input type="password" class="form-control"
							id="password" name="password" value="col88031"
							placeholder="<fmt:message key="placeholder.password" />" required>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="form-actions">
						<input type="submit" class="btn btn-block btn-primary btn-default"
							value="<fmt:message key="label.login" />">
					</div>
			</div>
		</form>
	</div>
	<div class="col-xs-1 col-md-3"></div>
</div>

