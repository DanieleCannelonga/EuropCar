<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ordine d'Acquisto</title>
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
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Ordine&nbsp;d'Acquisto</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoOrdineAcquisto.ofornitore.chiave}" />	
			</tr>
			<tr>
				<s:submit align="center" method="cerca" value="Cerca"/> 
			</tr>
			</table>
		<br />
		<s:if test="%{#session.listaOrdiniAcquisto.size()==0}">
		<P align="center">
			<br> Non ci sono Ordini d'Acquisto
		</P>
			<s:submit align="center" method="nuovoOrdineAcquisto" value="nuovo"/> &nbsp;&nbsp;&nbsp;&nbsp;
			<br>
			<s:submit name="chiudi" value="indietro" align="center" />
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Ordine d'Acquisto</td>
					<td>Importo</td>
					<td>Data</td>
					<td>Fornitore</td>
				</tr>
			<s:iterator value="#session.listaOrdiniAcquisto">
				<tr>
					<td><input type="radio" name="chiave"
						value="'<s:property value="chiave"/>'" />
					<td><s:property value="ordineAcquisto" /></td>
					<td><s:property value="importo" /></td>
					<td><s:property value="data" /></td>
					<td><s:property value="ofornitore.ragioneSociale" /></td>
				</tr>
			</s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovoOrdineAcquisto" value="Nuovo"/>&nbsp;</td>
				<td><s:submit align="center" method="modificaOrdineAcquisto" value="Modifica"/>&nbsp;</td>
				<td><s:submit align="center" onclick="return deleteConfirm()" method = "eliminaOrdineAcquisto" value = "Elimina"/>&nbsp;</td>
				<td><s:submit align="center" action="OrdineAcquistoAction" value="Annulla" />&nbsp;</td>
				<td><s:submit align="center" action="Main" value="Chiudi" />&nbsp;</td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>