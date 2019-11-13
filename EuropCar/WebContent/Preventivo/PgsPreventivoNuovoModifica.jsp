<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Preventivo</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare il Preventivo selezionato?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="GestionePreventivoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Preventivo</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoPreventivo.ofornitore.chiave}" />
			</tr>
			<tr>
				<s:textfield label="Codice" name="codice" value="%{#session.oggettoPreventivo.codice}" />
			</tr>
			<tr>
				<s:textfield label="Preventivo" name="preventivo" value="%{#session.oggettoPreventivo.preventivo}" />
			</tr>
		</table>
		<table class="p">
			<tr>
				<td><s:submit align="center" method="registra" value="Conferma" />&nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla" />&nbsp;</td>
				<td><s:submit align="center" action="PreventivoAction" value="Chiudi" />&nbsp;</td>
			</tr>
		</table>
	</s:form>
</body>
</html>