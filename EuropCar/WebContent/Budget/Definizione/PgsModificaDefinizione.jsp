<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Definizione Budget Sottocategoria</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="DefinizioneAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Definizione&nbsp;Budget&nbsp;Sottocategoria</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:select label="Area" name="chiaveArea" list="#session.listaAree" value="%{#session.oggettoSottoCategoria.oarea.chiave}" />
			</tr>
			<tr>
				<s:textfield label="codice" name="codice" value="%{#session.oggettoSottoCategoria.codice}" />
			</tr>
			<tr>
				<s:textfield label="sottoCategoria" name="sottoCategoria" value="%{#session.oggettoSottoCategoria.sottoCategoria}" />
			</tr>
			<tr>
				<s:textfield label="budget" name="budget" value="%{#session.oggettoSottoCategoria.budget}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<s:submit align="center" method="registra" value="Conferma" />
		<s:submit align="center" method="annulla" value="Annulla" />
		<s:submit align="center" action="DefinizioneAction" value="Chiudi" />
		</table>
	</s:form>
</body>
</html>