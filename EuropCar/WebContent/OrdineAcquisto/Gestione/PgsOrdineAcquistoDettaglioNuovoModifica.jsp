<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ordine d'Acquisto Dettaglio</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare la SottoCategoria selezionata?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="GestioneOrdineAcquistoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Ordine&nbsp;d'Acquisto&nbsp;Dettaglio</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:select label="Spesa d'Investimento" name="chiaveSpesaInvestimento" list="#session.listaSpeseInvestimento" value="%{#session.oggettoOrdineAcquistoDettaglio3.ospesainvestimento.chiave}" />
			</tr>
			<tr>
				<s:select label="Progetto" name="chiaveProgetto" list="#session.listaProgetti" value="%{#session.oggettoOrdineAcquistoDettaglio.oprogetto.chiave}" />
			</tr>
			<tr>
				<s:textfield label="Quantità" name="quantitaDettaglio" value="%{#session.oggettoOrdineAcquistoDettaglio.quantitaDettaglio}" />
			</tr>
			<tr>
				<s:textfield label="Importo" name="importoDettaglio" value="%{#session.oggettoOrdineAcquistoDettaglio.importoDettaglio}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="registraDettaglio" value="Conferma" />&nbsp;</td>
			<td><s:submit align="center" method="annulla" value="Annulla" />&nbsp;</td>
			<td><s:submit align="center" action="OrdineAcquistoAction" value="Chiudi" />&nbsp;</td>
		</table>
	</s:form>
</body>
</html>