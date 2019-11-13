<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsArchivioProgettoNuovoModifica.jsp</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="ProgettoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Progetti</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="codice" name="codice" value="%{#session.oggettoProgetto.codice}" />
			</tr>
			<tr>
				<s:textfield label="progetto" name="progetto" value="%{#session.oggettoProgetto.progetto}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<s:submit align="center" method="registra" value="Conferma" />
		<s:submit align="center" method="annulla" value="Annulla" />
		<s:submit align="center" action="ProgettoAction" value="Chiudi" />
		</table>
	</s:form>
</body>
</html>