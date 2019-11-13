<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<P align="center">
	
		<FONT size="+2" color="ff0000#">Archivio</FONT><BR>
	</P>
		<s:form action="/ArchivioAction">
		<s:submit align="left" action="Main" value="Torna alla Home"/>
		<table class="p">
		<tr>
			<td><s:radio name="scelta" list="map"></s:radio></td>
			<td><s:submit property="metodo" value="invio" align="center"/></td>
		</tr>
		</table>
		</s:form>
</body>
</html>