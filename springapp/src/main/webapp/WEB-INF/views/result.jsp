<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
    <title>Resultado</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    
</head>
<body>

<div style="text-align:center">
<h2>Information de La cuenta</h2>
</div>
<br>
<br>
<br>
<br>
<div class="col-md-12">
 <table class="table table-bordered" border="2" style="width:100%">
 
<c:forEach items="${cuentas}" var="cuenta">
    <tr  class="success">
        <td><strong>ID</strong></td>
        <td><c:out value="${cuenta.id}"/> </td>
        <td><strong>usuario</strong></td>
        <td><c:out value="${cuenta.usuario}"/> </td>
        <td><strong>Nombre</strong></td>
        <td><c:out value="${cuenta.persona.nombre}"/> </td>
        <td><strong>Descripcion</strong></td>
        <td><c:out value="${cuenta.perfil.descripcion}"/> </td>
        <td><strong>Sexo</strong></td>
        <td><c:out value="${cuenta.persona.sexo}"/> </td>
        <td><strong>Fecha</strong></td>
        <td><c:out value="${cuenta.persona.fechaNacimiento}"/> </td>
    	<td><strong>Activo</strong></td>
        <td><c:out value="${cuenta.usuarioActivo}"/> </td>
    	
    </tr>
</c:forEach>


</table> 
</div> 
<div class="col-md-12" style="text-align:center">
	<form type="GET" action="resultado.ordi">
		
		<input type="submit" class="btn btn-danger" value="Cerrar secion">
		
	</form>
</div>
</body>
</html>