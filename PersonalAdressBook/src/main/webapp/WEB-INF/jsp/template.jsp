<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<head>
<title>Personal adress book</title>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.css" />" >
<script src="<c:url value="/resources/jquery/jquery-3.4.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap-4.3.1/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="jumbotron text-center">
  <h1>Personal address book</h1>
  <p>Remember your contacts while you alive!!!</p> 
</div>
<div class="container">
<div class="row">
<div class="col-sm-4">
<div class="table-responsive-sm">
<h2>List of sex avaiable in data source:</h2>
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
    <tr>
      <th scope="row">1</th>
      <td>Male</td>
      <td><button type="button" class="btn btn-sm btn-outline-success">Add</button></td>
      <td><button type="button" class="btn btn-sm btn-outline-primary">Update</button></td>
      <td><button type="button" class="btn btn-sm btn-outline-danger">Delete</button></td>
    </tr>
    
   
  </tbody>
</table>

</div>
</div>
</div>
</div>
</body>
</html>