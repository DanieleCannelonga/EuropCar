<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Dettaglio Fattura Passiva</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare il Dettaglio della Fattura Passiva selezionata?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="GestioneFatturaPassivaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Nuovo&nbsp;Dettaglio&nbsp;Fattura&nbsp;Passiva</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="Dettaglio Fattura" name="dettaglioFattura" value="%{#session.oggettoFatturaPassivaDettaglio.dettaglioFatturaDettaglio}" />
			</tr>
			<tr>
				<s:textfield label="Importo" name="importo" value="%{#session.oggettoFatturaPassivaDettaglio.importoDettaglio}" />
			</tr>
			<tr>
				<s:select label="Preventivo" name="chiavePreventivo" list="#session.listaPreventivi" value="%{#session.oggettoFatturaPassivaDettaglio.opreventivo.chiave}" />
			</tr>
			<tr>
				<s:select label="Spesa d'Investimento" name="chiaveSpesaInvestimento" list="#session.listaSpeseInvestimento" value="%{#session.oggettoFatturaPassivaDettaglio.ospesainvestimento.chiave}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="registraDettaglio" value="Conferma" />&nbsp;</td>
			<td><s:submit align="center" method="annulla" value="Annulla" />&nbsp;</td>
			<td><s:submit align="center" action="FatturaPassivaAction" value="Chiudi" />&nbsp;</td>
		</tr>
		</table>
	</s:form>
</body>
</html>