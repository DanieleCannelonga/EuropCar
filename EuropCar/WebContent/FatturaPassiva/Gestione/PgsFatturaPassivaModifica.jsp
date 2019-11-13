<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Fattura Passiva</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare la Fattura Passiva selezionata?"))
			return true;
		else
			return false;
	}
</script>
<sx:head />
</head>
<body>
	<s:form action="GestioneFatturaPassivaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Modifica&nbsp;Fattura&nbsp;Passiva</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="Descrizione" name="descrizione" value="%{#session.oggettoFatturaPassiva.descrizione}" />
			</tr>
			<tr>
				<s:textfield label="Numero" name="numero" value="%{#session.oggettoFatturaPassiva.numero}" />
			</tr>
			<tr>
				<sx:datetimepicker label="Data" name="data" value="%{#session.oggettoFatturaPassiva.data}" displayFormat="dd-MMM-yyyy" />
			</tr>
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoFatturaPassiva.ofornitore.chiave}" />
			</tr>
		</table>
		<br>
		<s:if test="%{#session.listaFatturePassiveDettaglio.size()==0}">
		<P align="center">
			<br> Non ci sono Dettagli di Fatture Passive
		</P>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Preventivo</td>
					<td>Spesa Investimento</td>
					<td>Dettaglio</td>
					<td>Importo</td>
					<td>Ordine d'Acquisto</td>
				</tr>
			<s:iterator value="#session.listaFatturePassiveDettaglio">
				<tr>
					<td><input type="radio" name="chiaveDettaglio"
						value="'<s:property value="chiaveDettaglio"/>'" />
					<td><s:property value="opreventivo.preventivo" /></td>
					<td><s:property value="ospesainvestimento.spesaInvestimento" /></td>
					<td><s:property value="dettaglioFatturaDettaglio" /></td>
					<td><s:property value="importoDettaglio" /></td>
					<td><s:property value="ofatturapassiva.descrizione" /></td>
			</s:iterator>
			</table>
		</s:else>
		<br><br>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="nuovoDettaglio" value="Nuovo Dettaglio" />&nbsp;</td>
			<td><s:submit align="center" method="modificaDettaglio" value="Modifica Dettaglio" />&nbsp;</td>
			<td><s:submit align="center" method="eliminaDettaglio" value="Elimina Dettaglio" onclick="return deleteConfirm()" />&nbsp;</td>
			<td><s:submit align="center" method="registra" value="Conferma" />&nbsp;</td>
			<td><s:submit align="center" method="annulla" value="Annulla" />&nbsp;</td>
			<td><s:submit align="center" action="FatturaPassivaAction" value="Chiudi" />&nbsp;</td>
		</tr>
		</table>
	</s:form>
</body>
</html>