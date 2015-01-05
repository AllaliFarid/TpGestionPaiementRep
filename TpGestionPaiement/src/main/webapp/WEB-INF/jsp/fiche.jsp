<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<!-- Loading Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css"
	rel="stylesheet">
<link href='<c:url value="/resources/css/vendor/bootstrap.min.css"/>'
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/flat-ui.css"
	rel="stylesheet">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<title>Home</title>
</head>
<body>
	<div style="height: 138px;"></div>
	<div class="container">
 			<div class="row">
				<div class="col-xs-6">
				<h6> Edité : ${date }</h6>
				</div>
			</div>
	    <div style="height: 10px;"></div>
		<div class="panel panel-default">

			<div class="panel-heading">fiche de paie</div>

			<table class="table">
				<tr>
					<th>Numero</th>
					<th>cin</th>
					<th>nom</th>
					<th>prenom</th>
  					<th>grade</th>
					<th>departement</th>
 					<th>heures sup</th>
					<th>salaire </th>
 				</tr>
 					<tr>
					<td>${sala.numSalarie}</td>
					<td>${sala.cin }</td>
					<td>${sala.nom }</td>
					<td>${ sala.prenom}</td>
  					<td>${sala.grade}</td>
					<td>${sala.departement }</td>
 					<td>0</td>
					<td>${salaire} DH</td>
 				</tr>
			</table>
		</div>
	</div>
</body>
</html>