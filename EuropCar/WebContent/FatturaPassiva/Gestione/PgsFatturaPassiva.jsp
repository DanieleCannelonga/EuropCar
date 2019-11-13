<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Fattura Passiva</title>
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
</head>
<body>
	<s:form action="GestioneFatturaPassivaAction">
		<s:submit align="left" action="Main" value="Torna alla Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Fattura&nbsp;Passiva</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoFatturaPassiva.ofornitore.chiave}" />	
			</tr>
			<tr>
				<s:submit align="center" method="cerca" value="Cerca"/> 
			</tr>
			</table>
		<br>
		<s:if test="%{#session.listaFatturePassive.size()==0}">
			<table class="p">
			<tr><td>
			<br>
			<br> Non ci sono Fatture Passive <br>
			<br>
			</td></tr>
			</table>
			<s:submit align="center" method="nuovaFatturaPassiva" value="nuovo"/> &nbsp;&nbsp;&nbsp;&nbsp;
			<br>
			<s:submit name="chiudi" value="indietro" align="center" />
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Descrizione</td>
					<td>Numero</td>
					<td>Data</td>
					<td>Fornitore</td>
				</tr>
			<s:iterator value="#session.listaFatturePassive">
				<tr>
					<td><input type="radio" name="chiave"
						value="'<s:property value="chiave"/>'" />
					<td><s:property value="descrizione" /></td>
					<td><s:property value="numero" /></td>
					<td><s:property value="data" /></td>
					<td><s:property value="ofornitore.ragioneSociale" /></td>
			</s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovaFatturaPassiva" value="Nuovo" />&nbsp;</td>
				<td><s:submit align="center" method="modificaFatturaPassiva" value="Modifica" />&nbsp;</td>
				<td><s:submit align="center" method="eliminaFatturaPassiva" value="Elimina" onclick="return deleteConfirm()" />&nbsp;</td>
				<td><s:submit align="center" action="FatturaPassivaAction" value="Annulla" />&nbsp;</td>
				<td><s:submit align="center" action="Main" value="Chiudi" />&nbsp;</td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>