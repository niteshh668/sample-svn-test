<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

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
	
	$("#accommodationgrid").jqGrid({
		url:"Rooms.action?flag=ajax",
		datatype:"json",
		jsonReader:{repeatItems:true},
		colNames : ['Accommodation Id','Accommodation Name', 'View'],
		colModel : [{name:'accommodationId'},{name:'accommodationName'},{name:'accommodationId',formatter:returnHyperLink}],
		rowNum:20,
        rowList:[20,60,100],
        height:300,
        width:900,
        pager: "#accommodationdiv",
        loadOnce:true,
        viewrecords: true,
        caption: "Sample Example"
	});
	
});


function returnHyperLink(cellValue, options, rowdata, action) 
{
	alert(rowdata.accommodationName);
    return "<a href='ViewAccommodation.action?adto.accommodationId="+cellValue+"&adto.accommodationName="+rowdata.accommodationName+"' >View</a>";
} 

$(function() 
{
	$("#accommodationsearch").click(function(){
		$("#accommodationgrid").jqGrid('setGridParam',{url: "Rooms.action?flag=ajax&state="+$('#sid :selected').val()}).trigger("reloadGrid");
	});		
});


function getStates(countryId)
{
	alert(countryId);
	if(countryId != -1){
		document.stateinfo.submit();
	}
}
</script>

</head>
<body></br>

<form action="Rooms.action" name="stateinfo">
Country: <s:select 
					list="countryInfo" 
					listKey="countryId" 
					listValue="countryName" 
					name="country"
					headerKey="-1"
					headerValue="--Select--" onchange="getStates(this.value)"></s:select>
&nbsp;&nbsp;State: <s:select 
							list="stateinfo" 
							listKey="stateId" 
							listValue="stateName" 
							name="state"
							headerKey="-1"
							id="sid"
							headerValue="--Select--">
							</s:select>
					&nbsp;&nbsp;<input type="button" value="Search" id="accommodationsearch"/>
						
</form>
</br></br></br></br>
<table id="accommodationgrid">
</table>
<div id ="accommodationdiv">	</div>
</body>
</html>