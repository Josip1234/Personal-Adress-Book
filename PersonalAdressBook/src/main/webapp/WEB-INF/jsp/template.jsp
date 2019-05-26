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
<table class="table table-hover  table-sm table-bordered">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${se}" var="se" >
    <tr>
      <th  scope="row"><c:out value="${se.id}"/></th>
      <td ><c:out value="${se.name}"/></td>

    </tr>
    </c:forEach>

  </tbody>
</table>

</div>

</div>
<div class="col-sm-4">
  <h2>Operations:</h2>
<button onclick="addNewSex()" type="button" class="btn btn-lg btn-block btn-outline-success">Add sex</button>
<button onclick="updateSex()" type="button" class="btn btn-lg btn-block btn-outline-primary">Update sex</button>
<button onclick="deleteSex()" type="button" class="btn btn-lg btn-block btn-outline-danger">Delete sex</button>
</div>
</div>
<div class="row">
  <div id="insertSex" class="col-sm-4">
<h2>Insert new sex:</h2>
<sf:form method="post" modelAttribute="sex" action="/template/insertSex">
<div class="form-group">

  <sf:input path="name" class="form-control form-control-sm" placeholder="Name" />
</div>
<button type="submit" class="btn btn-primary">Insert new sex</button>
<button  type="button" onclick="abort()" class="btn btn-danger">Abort inserting</button>
</sf:form>
</div>
<div id="updateSex" class="col-sm-4">
  <h2>Update sex:</h2>
  <sf:form method="post" modelAttribute="sex" action="/template/updateSex">
  <div class="form-group">
    <sf:select path="id" class="form-control form-control-sm">
    <c:forEach items="${se}" var="se" >

        <sf:option value="${se.id}">${se.name}</sf:option>


    </c:forEach>
  </sf:select>

  </div>
  <div class="form-group">
    <sf:input path="name" class="form-control form-control-sm" placeholder="New name"  />
  </div>
  <button type="submit" class="btn btn-primary">Update</button>
  <button  type="button" class="btn btn-danger" onclick="abort()">Abort update</button>
  </sf:form>
</div>
<div id="deleteSex" class="col-sm-4">
  <h2>Delete sex:</h2>
  <sf:form method="post" modelAttribute="sex" action="/template/deleteSex">
  <div class="form-group">
    <sf:select path="id" class="form-control form-control-sm">
    <c:forEach items="${se}" var="se" >

        <sf:option value="${se.id}">${se.name}</sf:option>


    </c:forEach>
  </sf:select>

  </div>
  <button type="submit" class="btn btn-danger">Delete sex</button>
  <button  type="button" class="btn btn-danger" onclick="abort()">Abort deletion</button>
  </sf:form>
</div>
</div>
<div class="row">
<div class="col-sm-4">
<div class="table-responsive-sm">
<h2>Country list:</h2>
<table class="table table-hover  table-sm table-bordered">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Alpha 2</th>
      <th scope="col">Alpha 3</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${countryList}" var="country" >
    <tr>
      <th  scope="row"><c:out value="${country.id}"/></th>
      <td ><c:out value="${country.name}"/></td>
      <td ><c:out value="${country.alpha_2}"/></td>
      <td ><c:out value="${country.alpha_3}"/></td>

    </tr>
    </c:forEach>

  </tbody>
</table>

</div>
</div>
<div class="col-sm-4">
  <h2>Operations:</h2>
<button onclick="insertCountry()" type="button" class="btn btn-lg btn-block btn-outline-success">Add country</button>
<button onclick="updateCountry()" type="button" class="btn btn-lg btn-block btn-outline-primary">Update country</button>
<button onclick="deleteCountry()" type="button" class="btn btn-lg btn-block btn-outline-danger">Delete country</button>
</div>
</div>
<div class="row">
<div id="insertCountry" class="col-sm-4">
<h2>Insert new country:</h2>
<sf:form method="post" modelAttribute="country" action="/template/insertCountry">
<div class="form-group">

  <sf:input path="name" class="form-control form-control-sm" placeholder="Country name" />


</div>
<div class="form-group">
  <sf:input path="alpha_2" class="form-control form-control-sm" placeholder="Alpha 2"/>
</div>
<div class="form-group">
  <sf:input path="alpha_3" class="form-control form-control-sm" placeholder="Alpha 3" />
</div>
<button type="submit" class="btn btn-primary">Insert new country</button>
<button  type="button" onclick="abort()" class="btn btn-danger">Abort inserting</button>
</sf:form>
</div>
<div id="updateCountry" class="col-sm-4">
  <h2>Update country:</h2>
  <sf:form method="post" modelAttribute="country" action="/template/updateCountry">
  <div class="form-group">
    <sf:select path="id" class="form-control form-control-sm">
    <c:forEach items="${countryList}" var="country" >

        <sf:option value="${country.id}">${country.name}</sf:option>


    </c:forEach>
  </sf:select>

  </div>
  <div class="form-group">
    <sf:input path="name" class="form-control form-control-sm" placeholder="New country name"  />
  </div>
  <div class="form-group">
    <sf:input path="alpha_2" class="form-control form-control-sm" placeholder="New alpha_2"  />
  </div>
  <div class="form-group">
    <sf:input path="alpha_3" class="form-control form-control-sm" placeholder="New alpha_3"  />
  </div>
  <button type="submit" class="btn btn-primary">Update country</button>
  <button  type="button" class="btn btn-danger" onclick="abort()">Abort update</button>
  </sf:form>
</div>
<div id="deleteCountry" class="col-sm-4">
  <h2>Delete country:</h2>
  <sf:form method="post" modelAttribute="country" action="/template/deleteCountry">
  <div class="form-group">
    <sf:select path="id" class="form-control form-control-sm">
    <c:forEach items="${countryList}" var="country" >

        <sf:option value="${country.id}">${country.name}</sf:option>


    </c:forEach>
  </sf:select>

  </div>
  <button type="submit" class="btn btn-danger">Delete country</button>
  <button  type="button" class="btn btn-danger" onclick="abort()">Abort deletion</button>
  </sf:form>
</div>
</div>
<div class="row">
  <div class="col-sm-4">
  <div class="table-responsive-sm">
  <h2>City list:</h2>
  <table class="table table-hover  table-sm table-bordered">
    <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Zip code</th>
        <th scope="col">Country</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${cities}" var="city" >
      <tr>
        <th  scope="row"><c:out value="${city.id}"/></th>
        <td ><c:out value="${city.name}"/></td>
        <td ><c:out value="${city.zip_code}"/></td>
        <td>
  <c:forEach items="${countryList}" var="country">
    <c:if test="${city.country_id == country.id}">
      <c:out value="${country.name}"/>

    </c:if>

</c:forEach>


      </td>

      </tr>
      </c:forEach>

    </tbody>
  </table>

  </div>
  </div>
</div>
</div>
</body>
</html>
