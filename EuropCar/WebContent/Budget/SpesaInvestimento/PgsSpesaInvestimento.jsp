<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Spesa d'Investimento</title>
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
	<s:form action="SpesaInvestimentoAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Spesa&nbsp;d'Investimento</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="SottoCategoria" name="chiaveSottoCategoria" list="#session.listaSottoCategorie" value="%{#session.oggettoSpesaInvestimento.osottocategoria.chiave}" />	
			</tr>
			<tr>
				<s:submit align="center" method="cerca" value="Cerca"/> 
			</tr>
			</table>
		<br />
		<s:if test="%{#session.listaSpeseInvestimento.size()==0}">
		<P align="center">
			<br> Non ci sono Spese d'Investimento
		</P>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="nuovaSpesaInvestimento" value="Nuovo"/>&nbsp;</td>
			<td><s:submit name="chiudi" value="Indietro" align="center" />&nbsp;</td>
		</tr>
		</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Spesa d'Investimento</td>
					<td>SottoCategoria</td>
				</tr>
			<s:iterator value="#session.listaSpeseInvestimento">
				<tr>
					<td><input type="radio" name="chiave"
						value="'<s:property value="chiave"/>'" />
					<td><s:property value="spesaInvestimento" /></td>
					<td><s:property value="osottocategoria.sottoCategoria" /></td>
			</s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovaSpesaInvestimento" value="Nuovo"/>&nbsp;</td>
				<td><s:submit align="center" method="modificaSpesaInvestimento" value="Modifica"/>&nbsp;</td>
				<td><s:submit align="center" onclick="return deleteConfirm()" method="eliminaSpesaInvestimento" value="Elimina"/>&nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/>&nbsp;</td>
				<td><s:submit align="center" action="BudgetAction" value="Chiudi"/>&nbsp;</td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>