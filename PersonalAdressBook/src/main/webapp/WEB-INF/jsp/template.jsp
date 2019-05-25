<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE HTML>
<head>
<title>Personal adress book</title>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.css" />" >
<script src="<c:url value="/resources/jquery/jquery-3.4.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/myjavascript.js" />"></script>
</head>
<body onload="removeForms()">
<div class="jumbotron text-center">
  <h1>Personal address book</h1>
  <p>Remembers your contacts while you alive!!!</p>
</div>
<div class="container">
<div class="row">
<div class="col-sm-4">
<div class="table-responsive-sm">
<h2>List of sex:</h2>
<table class="table table-hover  table-sm">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${se}" var="se" >
    <tr>
      <th scope="row"><c:out value="${se.id}"/></th>
      <td><c:out value="${se.name}"/></td>
      <td><button onclick="addNewSex()" type="button" class="btn btn-sm btn-outline-success">Add</button></td>
      <td><button onclick="updateSex()" type="button" class="btn btn-sm btn-outline-primary">Update</button></td>
      <td><button  type="button" class="btn btn-sm btn-outline-danger">Delete</button></td>
    </tr>
    </c:forEach>

  </tbody>
</table>

</div>
</div>

</div>
<div class="row">
  <div id="insertSex" class="col-sm-4">
<h2>Insert new sex:</h2>
<sf:form method="post" modelAttribute="sex" action="/template/insertSex">
<div class="form-group">

  <sf:input path="name" class="form-control form-control-sm" />
</div>
<button type="submit" class="btn btn-primary">Insert new sex</button>
<button  type="button" onclick="abort()" class="btn btn-danger">Abort inserting</button>
</sf:form>
</div>
<div id="updateSex" class="col-sm-4">
  <h2>Update sex:</h2>
  <sf:form method="post" modelAttribute="sex" action="/template/updateSex">
  <div class="form-group">
    <sf:input path="id" class="form-control form-control-sm" />
    <sf:input path="name" class="form-control form-control-sm" />
  </div>
  <button type="submit" class="btn btn-primary">Update</button>
  <button  type="button" class="btn btn-danger" onclick="abort()">Abort update</button>
  </sf:form>
</div>
</div>
</div>
</body>
</html>
