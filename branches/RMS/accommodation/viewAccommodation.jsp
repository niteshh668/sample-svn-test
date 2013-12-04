<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th colspan="2">
			<s:property value="adto.accommodationName"/>
			
			</th>
			
		</tr>
		<tr>
		<td>Units Info</td>
		<td>Facilities Information</td>
		</tr>
		<tr>
			<td><table>
					
					<tr>
						<td>Unit Type</td>
						<td>Available Units</td>
					</tr>
					<s:iterator value="adto.lunits">
						<tr>
							<td><s:property value="unitType" /></td>
							<td align="center"><s:property value="availableUnits" /></td>
							<td><a href='BookingAction.action?accommodationId=<s:property value="%{adto.accommodationId}"/>&unitId=<s:property value="unitId"/>' >Book</a>
						</tr>
					</s:iterator>
				</table></td>
			<td><table>
					
					<s:iterator value="adto.lfacilities">
						<tr>
						<td>
						<s:property/> 
						</td>
						</tr>
					</s:iterator>
				</table></td>
		</tr>

	</table>


</body>
</html>