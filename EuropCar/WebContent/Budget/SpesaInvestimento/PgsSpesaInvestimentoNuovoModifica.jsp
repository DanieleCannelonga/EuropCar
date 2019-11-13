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
		if (confirm("Eliminare la Spesa d'Investimento selezionata?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="SpesaInvestimentoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Spesa&nbsp;d'Investimento</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="Spesa d'Investimento" name="spesaInvestimento" value="%{#session.oggettoSpesaInvestimento.spesaInvestimento}" />
			</tr>
			<tr>
				<s:select label="SottoCategoria" name="chiaveSottoCategoria" list="#session.listaSottoCategorie" value="%{#session.oggettoSpesaInvestimento.osottocategoria.chiave}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<s:submit align="center" method="registra" value="Conferma" />
		<s:submit align="center" method="annulla" value="Annulla" />
		<s:submit align="center" action="BudgetAction" value="Chiudi" />
		</table>
	</s:form>
</body>
</html>