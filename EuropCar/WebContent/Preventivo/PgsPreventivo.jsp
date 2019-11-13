<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Preventivo</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="GestionePreventivoAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Gestione&nbsp;Preventivo</FONT><BR>
		</P>
			<table class="p">
			<tr>
				<s:select label="Fornitore" name="chiaveFornitore" list="#session.listaFornitori" value="%{#session.oggettoPreventivo.ofornitore.chiave}" />	
			</tr>
			<tr>
				<s:submit align="center" method="cerca" value="Cerca"/> 
			</tr>
			</table>
		<br />
		<s:if test="%{#session.listaPreventivi.size()==0}">
		<table class="p">
			<tr>
				<td>Non ci sono Preventivi&nbsp;</td>
				<td><s:submit align="center" method="nuovoPreventivo" value="nuovo"/>&nbsp;</td>
				<td><s:submit name="chiudi" value="indietro" align="center" />&nbsp;</td>
			</tr>
		</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Codice</td>
					<td>Preventivo</td>
					<td>Fornitore</td>
				</tr>
			<s:iterator value="#session.listaPreventivi">
				<tr>
					<td><input type="radio" name="chiave"
						value="'<s:property value="chiave"/>'" />
					<td><s:property value="codice" /></td>
					<td><s:property value="preventivo" /></td>
					<td><s:property value="ofornitore.ragioneSociale" /></td>
			</s:iterator>
			</table>
			<table class="p">
				<tr>
					<td><s:submit align="center" method="nuovoPreventivo" value="Nuovo"/> &nbsp;</td>
					<td><s:submit align="center" method="modificaPreventivo" value="Modifica"/> &nbsp;</td>
					<td><s:submit align="center" onclick = "return deleteConfirm()" method = "eliminaPreventivo" value = "Elimina"/> &nbsp;</td>
					<td><s:submit align="center" method="annulla" value="Indietro" />&nbsp;</td>
					<td><s:submit align="center" action="PreventivoAction" value="Chiudi" />&nbsp;</td>
				</tr>
			</table>
		</s:else>
	</s:form>
	<script>
		function deleteConfirm() {
			if (confirm("Eliminare il Preventivo selezionato?"))
				return true;
			else
				return false;
		}
	</script>
</body>
</html>