<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Definizione</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="DefinizioneAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Definizione</FONT><BR>
		</P>
		<table class="p">
		<tr>
			<s:select label="Area" name="chiaveArea" list="#session.listaAree" value="%{#session.oggettoArea.oarea.chiave}" />	
		</tr>
		<tr>
		<s:submit align="center" method="cerca" value="Cerca"/>
		</tr>
		</table>
		<br />
		<s:if test="%{#session.listaAree2.size()==0}">
			<P align="center">
				<br> Non ci sono Definizioni
			</P>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Area</td>
					<td>Codice</td>
					<td>SottoCategoria</td>
					<td>Budget</td>
				</tr>
			<s:iterator value="#session.listaAree2">
				<tr>
					<td><input type="radio" name="chiave"
						value="'<s:property value="chiave"/>'" />
					<td><s:property value="oarea.area" />&nbsp;</td>
					<td><s:property value="codice" />&nbsp;</td>
					<td><s:property value="sottoCategoria" />&nbsp;</td>
					<td><s:property value="budget" />&nbsp;</td>
			</s:iterator>
			</table>
		</s:else>
		<br>
		<s:submit align="center" method="modificaDefinizione" value="Definizione"/>&nbsp;
		<s:submit align="center" action="SottoCategoriaAction" value="SottoCategoria"/>&nbsp;
		<s:submit align="center" action="BudgetAction" value="Chiudi"/>&nbsp;
	</s:form>
</body>
</html>