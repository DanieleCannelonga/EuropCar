<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Riconciliazione</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<sx:head />
</head>
<body>
	<s:form action="RiconciliazioneAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Riconciliazione</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="SottoCategoria" name="chiaveSottoCategoria" list="#session.listaSottoCategorie" value="%{#session.oggettoSottoCategoria.osottocategoria.chiave}" />	
			</tr>
			<tr>
				<sx:datetimepicker name="dataInizio" label="Data"
					displayFormat="dd-MMM-yyyy" value="%{#session.oggettoOrdineAcquisto.dataInizio}" />
			</tr>
			<tr>
				<sx:datetimepicker name="dataFine" label="Data"
					displayFormat="dd-MMM-yyyy" value="%{#session.oggettoOrdineAcquisto.dataFine}" />
			</tr>
			<tr>
				<s:submit align="center" method="riconcilia" value="Riconcilia"/>
			</tr>
			</table>
			<br />
			<s:if test="%{#session.listaOrdiniAcquisto.size()==0}">
				<P align="center">
					<br> Non ci sono Riconciliazioni da Effettuare
				</P>
			</s:if>
			<s:else>
				<table class="p" border="1">
					<tr>
						<td>SottoCategoria</td>
						<td>Ordine Acquisto</td>
						<td>Data</td>
						<td>Fornitore</td>
						<td>Importo</td>
					</tr>
					<s:iterator value="#session.listaOrdiniAcquisto">
						<tr>
							<td><s:property value="ospesainvestimento.osottocategoria.sottoCategoria" />&nbsp;</td>
							<td><s:property value="oordineacquisto.ordineAcquisto" />&nbsp;</td>
							<td><s:property value="oordineacquisto.data" />&nbsp;</td>
							<td><s:property value="oordineacquisto.ofornitore.ragioneSociale" />&nbsp;</td>
							<td><s:property value="oordineacquisto.importo" />&nbsp;</td>
						</tr>
					</s:iterator>
				</table>
			</s:else>
			<br>
			<s:submit align="center" action="BudgetAction" value="Chiudi"/>
	</s:form>
</body>
</html>