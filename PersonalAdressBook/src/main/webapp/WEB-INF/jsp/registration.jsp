<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE HTML>
<head>
<meta charset="utf-8">
<title>Personal adress book</title>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.css" />" >
<script src="<c:url value="/resources/jquery/jquery-3.4.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.min.js" />"></script>

</head>
<body onload="removeForms()">
<div class="jumbotron text-center">
  <h1>Personal address book</h1>
  <p>Remembers your contacts while you alive!!!</p>
  <p>Already registered? Click <a href="<c:url value="/login" />">Login</a>  to login.</p>




</div>

<div class="container">
<div class="row">
 <div id="insertSex" class="col-sm-4">
<h2>Populate your data:</h2>
<sf:form method="post" modelAttribute="user" action="/register/registerUser/">
<div class="form-group">

  <sf:input path="firstName" class="form-control form-control-sm" placeholder="First Name:" />
  <sf:errors path="firstName" />


</div>
<div class="form-group">

  <sf:input path="lastName" class="form-control form-control-sm" placeholder="Last Name:" />
  <sf:errors path="lastName" />


</div>
<div class="form-group">

  <sf:input path="age" type="number" class="form-control form-control-sm" placeholder="Your age if you want:" />
  <sf:errors path="age" />


</div>
<div class="form-group">

  <sf:input path="email" class="form-control form-control-sm" placeholder="Email:" />
  <sf:errors path="email" />


</div>
<div class="form-group">

  <sf:password path="password" class="form-control form-control-sm" placeholder="Password:" />
  <sf:errors path="password" />


</div>
<button type="submit" class="btn btn-primary" onclick="displayErrors()">Register</button>

</sf:form>
</div>
</div>
</div>
</body>
</html>