<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="signin.css">
</head>
<body>




 <div class="container">

      <form class="form-signin" method="POST" action="resultado.ordi">
        <h2 class="form-signin-heading">Bienvenido</h2>
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input type="text" name="u" class="form-control" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Contrasena</label>
        <input type="password"  name="c" class="form-control" placeholder="Contraseña" required>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div>



</body>
</html>