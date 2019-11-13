<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Per Progetto</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="RicercaProgettoAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Ricerca&nbsp;Per&nbsp;Progetto</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="Progetto" name="chiaveProgetto" list="#session.listaProgetti" value="%{#session.oggettoOrdineAcquisto.oprogetto.chiave}" />	
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
			<s:submit name="chiudi" value="indietro" align="center" />
			<s:submit align="center" action="Main" value="Chiudi" />&nbsp;
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td>Progetto</td>
					<td>Ordine d'Acquisto</td>
					<td>Importo</td>
					<td>Data</td>
					<td>Fornitore</td>
				</tr>
			<s:iterator value="#session.listaOrdiniAcquisto">
				<tr>
					<td><s:property value="oprogetto.progetto" /></td>
					<td><s:property value="oordineacquisto.ordineAcquisto" /></td>
					<td><s:property value="oordineacquisto.importo" /></td>
					<td><s:property value="oordineacquisto.data" /></td>
					<td><s:property value="oordineacquisto.ofornitore.ragioneSociale" /></td>
				</tr>
			</s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" action="OrdineAcquistoAction" value="Annulla" />&nbsp;</td>
				<td><s:submit align="center" action="Main" value="Chiudi" />&nbsp;</td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>