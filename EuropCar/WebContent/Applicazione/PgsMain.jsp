<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsMain.jsp</title>
</head>
<body>
	<P align="center">
	
		<FONT size="+2" color="ff0000#">Menu</FONT><BR>
	</P>
	<s:div align="center" >
		<s:form action="/Main">
			<s:radio name="scelta" list="map"></s:radio>
			<br/> <br/>
			<s:submit property="metodo" value="invio" align="center"/>
		</s:form>
	</s:div>
</body>
</html>