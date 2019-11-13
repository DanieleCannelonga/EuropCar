<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuova Fattura Passiva</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<sx:head />
</head>
<body>
	<s:form action="GestioneFatturaPassivaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Nuova&nbsp;Fattura&nbsp;Passiva</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="Descrizione" name="descrizione" value="%{#session.oggettoFatturaPassiva.descrizione}" />
			</tr>
			<tr>
				<s:textfield label="Numero" name="numero" value="%{#session.oggettoFatturaPassiva.numero}" />
			</tr>
			<tr>
				<sx:datetimepicker name="data" label="Data"
					displayFormat="dd-MMM-yyyy" value="%{#session.oggettoFatturaPassiva.data}" />
			</tr>
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoFatturaPassiva.ofornitore.chiave}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="registra" value="Conferma" />&nbsp;</td>
			<td><s:submit align="center" method="annulla" value="Annulla" />&nbsp;</td>
			<td><s:submit align="center" action="FatturaPassivaAction" value="Chiudi" />&nbsp;</td>
		</tr>
		</table>
	</s:form>
</body>
</html>