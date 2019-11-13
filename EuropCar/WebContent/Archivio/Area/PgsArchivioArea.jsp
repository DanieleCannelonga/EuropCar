<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Area</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
<script>
	function deleteConfirm() {
		if (confirm("Eliminare l'Area selezionata?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<s:form action="AreaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Aree</FONT><BR>
		</P>
		<s:submit align="left" action="Main" value="Torna alla Home"/>
		<s:if test="%{#session.listaAree==0}">
		<P align="center">
			Non ci sono Aree
		</P>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovaArea" value="Nuovo"/> &nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/> &nbsp;</td>
			</tr>
			</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
			    <tr>
			        <td></td>
			        <td> Codice </td>
			        <td> Area </td>
			    </tr>
			    
			    <s:iterator value="#session.listaAree">
			   		<tr>
			    		<td> <input type="radio" name="chiave" value="'<s:property value="chiave"/>'"> </td>
			    		<td> <s:property value="codice"/> </td>
			    		<td> <s:property value="area"/> </td>
			    	</tr>
			     </s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovaArea" value="Nuovo"/></td>
				<td><s:submit align="center" method="modificaArea" value="Modifica"/></td>
				<td><s:submit align="center" onclick="return deleteConfirm()" method="eliminaArea" value="Elimina"/></td>
				<td><s:submit align="center" method="annulla" value="Annulla"/></td>
				<td><s:submit align="center" action="ArchivioAction" value="Chiudi"/></td>
			</tr>
			</table>
		</s:else>
	</s:form>
</body>
</html>