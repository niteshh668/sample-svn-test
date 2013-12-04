<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js" ></script>
<script type="text/javascript" src="js/jquery.jqGrid.src.js" ></script>
<script type="text/javascript" src="js/grid.locale-en.js" ></script>
<script type="text/javascript" src="js/jquery.form.js" ></script>
<script type="text/javascript" src="js/additional-methods.js" ></script>
<script type="text/javascript" src="js/jquery.validate.js" ></script>
<link  href="stylesheet/ui.jqgrid.css" rel="stylesheet" type="text/css" />
<link  href="stylesheet/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function(){
	
	$("#sampletable").jqGrid({
		url:"RetrieveUserDetails.action",
		datatype:"json",
		jsonReader:{repeatItems:true},
		colNames : ['First Name','Last Name','Email','Address','Phone'],
		colModel : [{name:'firstname'},{name:'lastname'},{name:'email'},{name:'address'},{name:'phonenumber'}],
		rowNum:20,
        rowList:[20,60,100],
        height:300,
        pager: "#samplediv",
        loadOnce:true,
        viewrecords: true,
        caption: "Sample Example"
		
		
	});
	
});

function onSubmit(){
	var firstName = document.getElementById("firstname").value;
	var lastName = document.getElementById("lastname").value;
	var email = document.getElementById("email").value;
	var address= document.getElementById("address").value;
	var phonenumber = document.getElementById("phonenumber").value;
	var password= document.getElementById("password").value;
	var conformpassword =  document.getElementById("cpasswod").value;
	var msg = "";
	alert(lastName);
	if(firstName == null || firstName.length == 0){
		msg="First Name is mandatory";
	}
	if(lastName == null || lastName.length == 0){
		msg="Last Name is mandatory";
	}
	if(email == null || email.length == 0){
		msg="Email  is mandatory";
	}
	if(address == null || address.length == 0){
		msg="address  is mandatory";
	}
	if(phonenumber == null || phonenumber.length == 0){
		msg="phonenumber is mandatory";
	}
	if(password == null || password.length == 0){
		msg+="\npassword  is mandatory";
	}
	if(conformpassword == null || conformpassword.length == 0){
		msg+="\nConformpassword is mandatory";
	}
	if(password!=conformpassword){
		msg+="\n password and conform password fields should match";
	}
	if(msg != ""){
		alert(msg);
		return false;
	}
	return true;
}

function onSubmit2()
{
 	var firstName = $("#firstname").val();
 	var lastName = $("#lastname").val();
	var email = $("#email").val();
	var address= $("#address").val();
	var phonenumber = $("#phonenumber").val();
	var password= $("#password").val();
	var conformpassword =  $("#cpasswod").val();
	var msg = "";
	if(firstName == null || firstName.length == 0){
		msg="First Name is mandatory";
	}
	if(lastName == null || lastName.length == 0){
		msg="Last Name is mandatory";
	}
	if(email == null || email.length == 0){
		msg="Email  is mandatory";
	}
	if(address == null || address.length == 0){
		msg="address  is mandatory";
	}
	if(phonenumber == null || phonenumber.length == 0){
		msg="phonenumber is mandatory";
	}
	if(password == null || password.length == 0){
		msg+="\npassword  is mandatory";
	}
	if(conformpassword == null || conformpassword.length == 0){
		msg+="\nConformpassword is mandatory";
	}
	if(password!=conformpassword){
		msg+="\n password and conform password fields should match";
	}
	if(msg != ""){
		alert(msg);
		return false;
	}
	return true;
	
	}
</script>
</head>
<body>
<s:actionerror/>
<form action="RegisterUser.action" method="post" id="myform">
<table align="center">
<tr><td>
First Name: </td><td><s:textfield type="text" name="rdto.firstname" id="firstname"  /></td></tr>
<tr><td>
Last Name: </td><td><s:textfield type="text" name="rdto.lastname" id="lastname"  /></td></tr>
<tr><td>
Email id: </td><td><s:textfield type="text" name="rdto.email" id="email" /></td></tr>
<tr><td>
Address: </td><td><s:textfield name="rdto.address" id="address" theme="simple"></s:textfield></td></tr>
<tr><td>
Phone Number: </td><td><s:textfield name="rdto.phonenumber" id="phonenumber" theme="simple" ></s:textfield></td></tr>
<tr><td>
Password: </td><td><s:password name="rdto.password" id="password" theme="simple" /></td></tr>
<tr><td>
Confirm Password: </td><td><s:password  id="cpasswod" theme="simple"/></td></tr>
<tr><td align="right"><s:submit value="Cancel" theme="simple"/></td><td><s:submit value="Register" theme="simple"/></td></tr>
</table>
<s:token />
</form>
<span>Existing User Details</span>
<%-- <script>
// just for the demos, avoids form submit

$( "#myform" ).validate({
	  rules: {
		 "rdto.email": 
		 	{
		      required: true,
		      email: true
		    },
		    "rdto.firstname":
		    	{
		    	required: true
		    	}
		  }
		});
</script> --%>

<%-- <s:if test="registrationList == null || registrationList.isEmpty() ">
	No Records Found.
</s:if>
<s:else>
<table border="1">
<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>Address</th><tr>
<s:iterator value="registrationList" >
<tr>
	<td><s:property value="firstname" /></td>
	<td><s:property value="lastname" /></td>
	<td><s:property value="email" /></td>
	<td><s:property value="phonenumber" /></td>
	<td><s:property value="address" /></td>
</tr>
</s:iterator>
</table>
</s:else> --%>

<table id="sampletable">

</table>
<div id ="samplediv">	</div>
</body>
</html>