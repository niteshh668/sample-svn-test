<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js" ></script>
<script type="text/javascript" src="js/grid.locale-en.js" ></script>
<script type="text/javascript" src="js/jquery.form.js" ></script>
<script type="text/javascript" src="js/additional-methods.js" ></script>
<script type="text/javascript" src="js/jquery.validate.js" ></script>
<link  href="stylesheet/ui.jqgrid.css" rel="stylesheet" type="text/css" />
<link  href="stylesheet/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function(){
    $( "#chekinpicker" ).datepicker({
      showOn: "button",
      buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
      buttonImageOnly: true
    });
    $( "#checkoutpicker" ).datepicker({
        showOn: "button",
        buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
        buttonImageOnly: true
      });
});
</script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Infomation Page</title>
</head>
<body >

<s:form action="bookAccommodationAction"  method="POST" >
 <table align="center">
<tr><td>Check-In Date:</td>
 <td><input name="bdto.checkInDate" type="text" id="chekinpicker"></td>
</tr>
<tr><td>Check-Out Date:</td>
 <td><input name="bdto.checkOutDate" type="text" id="checkoutpicker"></td>
</tr>
<tr><td colspan="2" align="center"><s:submit value="submit" name="submit" /></td></tr>
 </table>

 
</s:form>

</body>
</html>