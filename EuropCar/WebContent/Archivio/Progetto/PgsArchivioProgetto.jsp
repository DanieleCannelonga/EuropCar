<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Progetto</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare il Progetto selezionato?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="ProgettoAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Progetto</FONT><BR>
		</P>
		<br />
		<s:submit align="left" action="Main" value="Torna alla Home"/>
		<s:if test="%{#session.listaProgetti.size()==0}">
		<P align="center">
			<br> Non ci sono Progetti
		</P>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="nuovoProgetto" value="Nuovo"/>&nbsp;</td>
			<td><s:submit name="chiudi" value="Indietro" align="center" />&nbsp;</td>
		</tr>
		</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Codice</td>
					<td>Progetto</td>
				</tr>
				<s:iterator value="#session.listaProgetti">
					<tr>
						<td><input type="radio" name="chiave"
							value="'<s:property value="chiave"/>'" />
						<td><s:property value="codice" /></td>
						<td><s:property value="progetto" /></td>
					</tr>
				</s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovoProgetto" value="Nuovo"/>&nbsp;</td>
				<td><s:submit align="center" method="modificaProgetto" value="Modifica"/>&nbsp;</td>
				<td><s:submit align="center" onclick="return deleteConfirm()" method="eliminaProgetto" value="Elimina"/>&nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/></td>
				<td><s:submit align="center" action="ArchivioAction" value="Chiudi"/></td>
			</table>
		</s:else>
	</s:form>
</body>
</html>