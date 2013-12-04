<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="${pageContext.request.contextPath}/css/lstyle.css" rel="stylesheet" type="text/css" /> --%>
</head>
<body>
<div class="body_pattern">
<s:property value="accommodationId"/>
<span>${param.unitId}</span>
<form action="LoginAction.action">
	
    
 <div class="inset" align="center">
  <p>
    <b><label for="Username">Username</label></b>
    <input type="text" name="ldto.username" id="Username" maxlength="35"/>
  </p>
  <p>
   <b> <label for="password">Password</label></b>
    <input type="password" name="ldto.password" id="password" maxlength="35"  />
  </p>
  
  </div>
  <p class="p-container" align="center">
    <span><s:a href="ForgotPasswordAction">Forgot password ?</s:a></span>
    <span>&nbsp;&nbsp;<s:a href="RegistrationAction">Register</s:a></span>
    <input type="submit" name="go" id="go" value="Log in"/>
  </p>
  
	
</form>
</div>
</body>
</html>