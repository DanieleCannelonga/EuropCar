<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PgsArchivioAliquotaIvaNuovoModifica.jsp</title>
<style>
.p {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<s:form action="AliquotaIvaAction">
		<P align="center">
			<FONT size="+2" color="ff0000#">Archivio&nbsp;Aliquote Iva</FONT><BR>
		</P>
		<table class="p">
			<tr>
				<s:textfield label="aliquotaIva" name="aliquota" value="%{#session.oggettoAliquotaIva.aliquota}" />
			</tr>
			<tr>
				<s:textfield label="descrizione" name="descrizione" value="%{#session.oggettoAliquotaIva.descrizione}" />
			</tr>
		</table>
		<br><br>
		<table class="p">
		<s:submit align="center" method="registra" value="Conferma" />
		<s:submit align="center" method="annulla" value="Annulla" />
		<s:submit align="center" action="AliquotaIvaAction" value="Chiudi" />
		</table>
	</s:form>
</body>
</html>