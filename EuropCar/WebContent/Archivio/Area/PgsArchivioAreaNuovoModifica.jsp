<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Area</title>
</head>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<body>
	<s:form action="AreaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Aree</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="codice" name="codice" value="%{#session.oggettoArea.codice}" />
			</tr>
			<tr>
				<s:textfield label="area" name="area" value="%{#session.oggettoArea.area}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<s:submit align="center" method="registra" value="Conferma" />
		<s:submit align="center" method="annulla" value="Annulla" />
		<s:submit align="center" action="AreaAction" value="Chiudi" />
		</table>
	</s:form>
</body>
</html>