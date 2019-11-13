<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Statistica</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<sx:head />
</head>
<body>
	<s:form action="StatisticaAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Statistica</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="SottoCategoria" name="chiaveSottoCategoria" list="#session.listaSottoCategorie" value="%{#session.oggettoSottoCategoria.osottocategoria.chiave}" />	
			</tr>
			<tr>
				<s:select label="SpesaInvestimento" name="chiaveSpesaInvestimento" list="#session.listaSpeseInvestimento" value="%{#session.oggettoSottoCategoria.ospesainvestimento.chiave}" />	
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
				<s:submit align="center" method="cerca" value="Cerca"/> 
			</tr>
			</table>
		<br />
	</s:form>
</body>
</html>