<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Ordine d'Acquisto</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<sx:head />
</head>
<body>
	<s:form action="GestioneOrdineAcquistoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Nuovo&nbsp;Ordine&nbsp;d'Acquisto</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="Ordine d'Acquisto" name="ordineAcquisto" value="%{#session.oggettoOrdineAcquisto.ordineAcquisto}" />
			</tr>
			<tr>
				<s:textfield label="Importo" name="importo" value="%{#session.oggettoOrdineAcquisto.importo}" />
			</tr>
			<tr>
				<sx:datetimepicker name="data" label="Data"
					displayFormat="dd-MMM-yyyy" value="%{#session.oggettoOrdineAcquisto.data}" />
			</tr>
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoOrdineAcquisto.ofornitore.chiave}" />
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