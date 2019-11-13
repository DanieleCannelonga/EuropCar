<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Definizione</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="DefinizioneAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Definizione</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="Area" name="chiaveArea" list="#session.listaAree" value="%{#session.oggettoArea.oarea.chiave}" />	
			</tr>
			<tr>
				<s:submit align="center" method="cerca" value="Cerca"/> 
			</tr>
			</table>
		<br />
	</s:form>
</body>
</html>