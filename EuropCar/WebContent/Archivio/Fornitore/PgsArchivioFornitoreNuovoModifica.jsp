<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Fornitore</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="FornitoreAction">
		<p align="center">
			<font size="+2" color="ff0000#">Archivio&nbsp;Fornitori</font>
		</p>
		<table class="p">
			<tr>
				<s:textfield label="ragioneSociale" name="ragioneSociale" value="%{#session.oggettoFornitore.ragioneSociale}"/>
			</tr>
			<tr>
				<s:textfield label="indirizzo" name="indirizzo" value="%{#session.oggettoFornitore.indirizzo}"/>
			</tr>
			<tr>
				<s:textfield label="citta" name="citta" value="%{#session.oggettoFornitore.citta}"/>
			</tr>
			<tr>
				<s:textfield label="cap" name="cap" value="%{#session.oggettoFornitore.cap}"/>
			</tr>
			<tr>
				<s:textfield label="provincia" name="provincia" value="%{#session.oggettoFornitore.provincia}"/>
			</tr>
			<tr>
				<s:textfield label="partitaIva" name="partitaIva" value="%{#session.oggettoFornitore.partitaIva}"/>
			</tr>
		</table>
		<br><br>
		<table class="p">
		<s:submit align="center" method="registra" value="Conferma" />
		<s:submit align="center" method="annulla" value="Annulla" />
		<s:submit align="center" action="FornitoreAction" value="Chiudi" />
		</table>
	</s:form>
</body>
</html>