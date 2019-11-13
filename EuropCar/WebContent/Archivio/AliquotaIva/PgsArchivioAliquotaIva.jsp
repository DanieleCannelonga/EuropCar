<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Aliquota Iva</title>
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
	<s:form action="AliquotaIvaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Aliquote Iva</FONT><BR>
		</P>
		<br><br>
		<s:submit align="left" action="Main" value="Home"/>
		<s:if test="%{#session.listaAliquoteIva.size()==0}">
		<P align="center">
			Non ci sono Aliquote Iva
		</P>
			<br><br>
			<table>
			<tr>
				<td><s:submit align="center" method="nuovaAliquotaIva" value="Nuovo"/> &nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/> &nbsp;</td>
			</tr>
			</table>
		</s:if>
		<s:else>
			<table class="p" border="1">
			    <tr>
			        <td></td>
			        <td> Aliquota </td>
			        <td> Descrizione </td>
			    </tr>
			    <s:iterator value="#session.listaAliquoteIva">
			   		<tr>
			    		<td> <input type="radio" name="chiave" value="'<s:property value="chiave"/>'"> </td>
			    		<td> <s:property value="aliquota"/> </td>
			    		<td> <s:property value="descrizione"/> </td>
			    	</tr>
			     </s:iterator>
			</table>
			<br><br>
			<table class="p">
			<tr>
				<td><s:submit align="center" method="nuovaAliquotaIva" value="Nuovo"/>&nbsp;</td>
				<td><s:submit align="center" method="modificaAliquotaIva" value="Modifica"/>&nbsp;</td>
				<td><s:submit align="center" onclick = "return deleteConfirm()" method = "eliminaAliquotaIva" value = "Elimina"/>&nbsp;</td>
				<td><s:submit align="center" method="annulla" value="Annulla"/></td>
				<td><s:submit align="center" action="ArchivioAction" value="Chiudi"/></td>
			</table>
		</s:else>
	</s:form>
</body>
</html>