<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Fornitore</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare il Fornitore selezionato?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="FornitoreAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Fornitori</FONT><BR>
		</P>
		<s:submit align="left" action="Main" value="Torna alla Home"/>
		<s:if test="%{#session.listaFornitori==0}">
		<P align="center">
			Non ci sono Fornitori
		</P>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovoFornitore" value="Nuovo"/> &nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/> &nbsp;</td>
			</tr>
			</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
			    <tr>
			        <td></td>
			        <td> Ragione Sociale </td>
			        <td> Indirizzo </td>
			        <td> Città </td>
			        <td> Cap </td>
			        <td> Provincia </td>
			        <td> Partita Iva </td>
			    </tr>
			    
			    <s:iterator value="#session.listaFornitori">
			   		<tr>
			    		<td> <input type="radio" name="chiave" value="'<s:property value="chiave"/>'"> </td>
			    		<td> <s:property value="ragioneSociale"/> </td>
			    		<td> <s:property value="indirizzo"/> </td>
			    		<td> <s:property value="citta"/> </td>
			    		<td> <s:property value="cap"/> </td>
			    		<td> <s:property value="provincia"/> </td>
			    		<td> <s:property value="partitaIva"/> </td>
			    	</tr>
			     </s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovoFornitore" value="Nuovo"/></td>
				<td><s:submit align="center" method="modificaFornitore" value="Modifica"/></td>
				<td><s:submit align="center" onclick="return deleteConfirm()" method="eliminaFornitore" value="Elimina"/></td>
				<td><s:submit align="center" method="annulla" value="Annulla"/></td>
				<td><s:submit align="center" action="ArchivioAction" value="Chiudi"/></td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>