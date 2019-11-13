<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Ordine d'Acquisto</title>
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
<sx:head />
</head>
<body>
	<s:form action="GestioneOrdineAcquistoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Modifica&nbsp;Ordine&nbsp;d'Acquisto</FONT><BR>
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
		<br>
		<s:if test="%{#session.listaOrdiniAcquistoDettaglio.size()==0}">
			<br> 
			<P align="center">Non ci sono Dettagli di Ordini d'Acquisto</P>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Progetto</td>
					<td>SpesaInvestimento</td>
					<td>Importo</td>
					<td>Quantità</td>
					<td>Ordine d'Acquisto</td>
				</tr>
			<s:iterator value="#session.listaOrdiniAcquistoDettaglio">
				<tr>
					<td><input type="radio" name="chiaveDettaglio"
						value="'<s:property value="chiaveDettaglio"/>'" />
					<td><s:property value="oprogetto.progetto" /></td>
					<td><s:property value="ospesainvestimento.spesaInvestimento" /></td>
					<td><s:property value="importoDettaglio" /></td>
					<td><s:property value="quantitaDettaglio" /></td>
					<td><s:property value="oordineacquisto.ordineAcquisto" /></td>
			</s:iterator>
			</table>
		</s:else>
		<br><br>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="nuovoDettaglio" value="Nuovo Dettaglio" />&nbsp;</td>
			<td><s:submit align="center" method="modificaDettaglio" value="Modifica Dettaglio" />&nbsp;</td>
			<td><s:submit align="center" method="eliminaDettaglio" onclick="return deleteConfirm()" value="Elimina Dettaglio" />&nbsp;</td>
			<td><s:submit align="center" method="registra" value="Conferma" />&nbsp;</td>
			<td><s:submit align="center" method="annulla" value="Annulla" />&nbsp;</td>
			<td><s:submit align="center" action="OrdineAcquistoAction" value="Chiudi" />&nbsp;</td>
		</tr>
		</table>
	</s:form>
</body>
</html>