<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio SottoCategoria</title>
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
	<s:form action="SottoCategoriaAction">
		<s:submit align="left" action="Main" value="Home"/>
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;SottoCategoria</FONT><BR>
		</P>
		<br />
		<s:if test="%{#session.listaSottoCategorie.size()==0}">
		<P align="center">
			<br> Non ci sono SottoCategorie 
		</P>
		<table class="p">
		<tr>
			<td><s:submit align="center" method="nuovaSottoCategoria" value="Nuovo"/>&nbsp;</td>
			<td><s:submit name="chiudi" value="Indietro" align="center" />&nbsp;</td>
		</tr>
		</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
				<tr>
					<td></td>
					<td>Codice</td>
					<td>Sotto Categoria</td>
					<td>Budget</td>
					<td>Budget Speso</td>
					<td>Area</td>
				</tr>
			<s:iterator value="#session.listaSottoCategorie">
				<tr>
					<td><input type="radio" name="chiave"
						value="'<s:property value="chiave"/>'" />
					<td><s:property value="codice" /></td>
					<td><s:property value="sottoCategoria" /></td>
					<td><s:property value="budget" /></td>
					<td><s:property value="budgetSpeso" /></td>
					<td><s:property value="oarea.area" /></td>
			</s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovaSottoCategoria" value="Nuovo"/>&nbsp;</td>
				<td><s:submit align="center" method="modificaSottoCategoria" value="Modifica"/>&nbsp;</td>
				<td><s:submit align="center" onclick="return deleteConfirm()" method="eliminaSottoCategoria" value="Elimina"/>&nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/></td>
				<td><s:submit align="center" action="ArchivioAction" value="Chiudi"/></td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>