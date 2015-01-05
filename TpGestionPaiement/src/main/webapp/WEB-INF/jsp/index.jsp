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

	<div style="height: 38px;"></div>
	<div class="container">
		<div class="row">
			<f:form action="rechercher" modelAttribute="salarie" method="post">
				<div class="col-xs-3">
					<div class="form-group">
						<f:input path="numSalarie" class="form-control"
							placeholder="recherche Num salarie" />
					</div>
				</div>
				<div class="col-xs-3">
					<div class="form-group  ">
						<f:input path="departement" class="form-control"
							placeholder="recherche par departement" />
					</div>
				</div>

				<div class="col-xs-3">
					<div class="form-group  ">
						<input type="submit" value="valider"
							class="btn btn-block btn-lg btn-info" />
					</div>
				</div>


			</f:form>
			<f:form action="logout">
				<div class="col-xs-3">
					<div class="form-group  ">
						<input type="submit" value="logout"
							class="btn btn-block btn-lg btn-info" />
					</div>
				</div>
			</f:form>
		</div>


		<div class="panel panel-default">

			<div class="panel-heading">la liste des salaies</div>

			<table class="table">
				<tr>
					<th>Numero</th>
					<th>cin</th>
					<th>nom</th>
					<th>prenom</th>
					<th>date naissance</th>
					<th>date d'embauche</th>
					<th>grade</th>
					<th>departement</th>
					<th>fonction</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${liste}" var="salarie">
					<%-- <c:if test="${not empty salarie.numSalarie}"> --%>
					<tr>
						<td>${salarie.numSalarie }</td>
						<td>${salarie.cin }</td>
						<td>${salarie.nom }</td>
						<td>${salarie.prenom }</td>
						<td>${salarie.dateNaissance }</td>
						<td>${salarie.dateEmbauche }</td>
						<td>${salarie.grade }</td>
						<td>${salarie.departement }</td>
						<td><c:if test="${not empty salarie.directeur.numSalarie}">
								<c:out value="Directeur"></c:out>
							</c:if> <c:if test="${not empty salarie.ingenieur.numSalarie}">
								<c:out value="Ingenieur"></c:out>
							</c:if> <c:if test="${not empty salarie.ouvrier.numSalarie}">
								<c:out value="Ouvrier"></c:out>
							</c:if></td>
						<td><a
							href="<c:url value="/find?numSalarie=${salarie.numSalarie}"/>">
								<span class="fui-new" />
						</a> <a
							href="<c:url value="/fichePaie?numSalarie=${salarie.numSalarie}"/> ">
								<span class="fui-exit" />
						</a><a
							href="<c:url value="/remove?numSalarie=${salarie.numSalarie}"/>">
								<span class="fui-cross-circle" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<f:form action="edite" modelAttribute="sala" method="post">
			<div class="panel panel-default">
				<div class="panel-heading">ajouter ou mettre à jour un salarie</div>
				<table class="table">
					<tr>
						<th>Num</th>
						<th>cin</th>
						<th>nom</th>
						<th>prenom</th>
						<th>date naissance</th>
						<th>date d'embauche</th>
						<th>grade</th>
						<th>indice</th>
						<th>fonction</th>
						<th>departement</th>

					</tr>

					<%-- <c:if test="${not empty salarie.numSalarie}"> --%>
					<tr>
						<td><f:input path="numSalarie"
								style="width: 50px;height:37px; " class="form-control" /></td>
						<td><f:input path="cin" style="width: 100px;height:37px; "
								class="form-control" /></td>
						<td><f:input path="nom" style="width: 100px;height:37px; "
								class="form-control" /></td>
						<td><f:input path="prenom" style="width: 100px;height:37px; "
								class="form-control" /></td>
						<td>
							 <f:input path="dateNaissance"   placeholder="xxxx-xx-xx" 
								style="width: 110px; height:37px;" class="form-control" /> 
						</td>
						<td>
							 <f:input type="text"  path="dateEmbauche" placeholder="xxxx-xx-xx" 
								style="width: 110px;height:37px; " class="form-control" /> 
						</td>
						<td><f:input path="grade" style="width: 90px; height:37px;"
								class="form-control" /></td>
						<td><f:input path="indice" style="width: 90px; height:37px;"
								class="form-control" /></td>
						<td><f:select path="fonction" class="form-control"
								style="width: 120px; height: 37px;">
								<f:option label="Directeur" value="Directeur" />
								<f:option label="Ingenieur" value="Ingenieur" />
								<f:option label="Ouvrier" value="Ouvrier" />
							</f:select></td>
						<td><f:input path="departement"
								style="width: 110px; height:37px;" class="form-control" /></td>

						<td></td>
					</tr>

				</table>
			</div>
			<div class="col-xs-9 "></div>
			<div class="col-xs-3 ">
				<div class="form-group  ">
					<input type="submit" value="sauvegarder"
						class="btn btn-block btn-lg btn-info" />
				</div>
			</div>
		</f:form>
  
	</div>
 
</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
     <script
		src="${pageContext.request.contextPath}/resources/js/bootbox.min.js"></script>
</body>
</html>
