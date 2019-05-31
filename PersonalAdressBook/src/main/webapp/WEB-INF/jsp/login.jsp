<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login page for personal address book</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.css" />" >
    <script src="<c:url value="/resources/jquery/jquery-3.4.1.min.js" />"></script>
    <script src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/resources/js/myjavascript.js" />"></script>
  </head>
  <body>

    <div id="container">
      <div id="row">
        <div class="col-sm-8">
          <h2>Login form:</h2>
    <form>

  <div class="form-group">

    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">

  </div>
  <div class="form-group">

    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>
</div>
</div>
  </body>
</html>
