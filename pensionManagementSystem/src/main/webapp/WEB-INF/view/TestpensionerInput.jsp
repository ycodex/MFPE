<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Pension Management Login</title>
  <script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <style type="text/css">
    body {
  font-family: "Karla", sans-serif;
  background-color: #d0d0ce;
  min-height: 100vh; }

.brand-wrapper {
  margin-bottom: 19px; }
  .brand-wrapper .logo {
    height: 37px; }

.login-card {
  border: 0;
  border-radius: 27.5px;
  box-shadow: 0 10px 30px 0 rgba(172, 168, 168, 0.43);
  overflow: hidden; }
  .login-card-img {
    border-radius: 0;
    position: absolute;
    width: 100%;
    height: 100%;
    -o-object-fit: cover;
       object-fit: cover; }
  .login-card .card-body {
    padding: 85px 60px 60px; }
    @media (max-width: 422px) {
      .login-card .card-body {
        padding: 35px 24px; } }
  .login-card-description {
    font-size: 25px;
    color: #000;
    font-weight: normal;
    margin-bottom: 23px; }
  .login-card form {
    max-width: 326px; }
  .login-card .form-control {
    border: 1px solid #d5dae2;
    padding: 15px 25px;
    margin-bottom: 20px;
    min-height: 45px;
    font-size: 13px;
    line-height: 15;
    font-weight: normal; }
    .login-card .form-control::-webkit-input-placeholder {
      color: #919aa3; }
    .login-card .form-control::-moz-placeholder {
      color: #919aa3; }
    .login-card .form-control:-ms-input-placeholder {
      color: #919aa3; }
    .login-card .form-control::-ms-input-placeholder {
      color: #919aa3; }
    .login-card .form-control::placeholder {
      color: #919aa3; }
  .login-card .login-btn {
    padding: 13px 20px 12px;
    background-color: #000;
    border-radius: 4px;
    font-size: 17px;
    font-weight: bold;
    line-height: 20px;
    color: #fff;
    margin-bottom: 24px; }
    .login-card .login-btn:hover {
      border: 1px solid #000;
      background-color: transparent;
      color: #000; }
  .login-card .forgot-password-link {
    font-size: 14px;
    color: #919aa3;
    margin-bottom: 12px; }
  .login-card-footer-text {
    font-size: 16px;
    color: #0d2366;
    margin-bottom: 60px; }
    @media (max-width: 767px) {
      .login-card-footer-text {
        margin-bottom: 24px; } }
  .login-card-footer-nav a {
    font-size: 14px;
    color: #919aa3; }

/*# sourceMappingURL=login.css.map */

  </style>
  <script type="text/javascript">
  window.history.forward();
  function noBack() {
    window.history.forward();
  }
</script>
</head>
<body style="overflow-y: hidden;">
  <header>
    <nav class="navbar bg-dark transparent">
      <h3 class=" text-center display-5 text-uppercase font-bold"
        style="margin-top: 5px; font-family: sans-serif; color: #ffffff">
        <i class="fab fa-google-wallet"> </i>&nbsp; Pension Management
        Portal
      </h3>
      <a href="/logout" style="align: right;">Logout</a>
    </nav>
  </header>
  <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    
    <div class="container">
      <div class="card login-card">
        <div class="row no-gutters">
          <div class="col-md-5">
            <img src="https://static.vecteezy.com/ti/fotos-gratis/p1/832632-homem-idoso-sentado-no-banco-e-lendo-um-romance-foto.jpg" alt="login" class="login-card-img">
          </div>
          <div class="col-md-7">
            <div class="card-body">
              
              <p class="login-card-description">Enter Details</p>
              <p class="lead text" style="color: RED; font-weight: bold;" id="errorMessage">${status}</p>
              <form:form name="form" action="getPensionerDetail" method="post"
              modelAttribute="pensionerInput">
              <div class="form-group">
                <input id="name" name="name" path="name" type="text"
                  class="form-control" placeholder="Name" required="required" />
              </div>
              <div class="form-group">
                <input name="dateOfBirth" path="dateOfBirth" type="date"
                  class="form-control" placeholder="Date of Birth"
                  required="required" />
              </div>
              <div class="form-group">
                <input name="pan" path="pan" type="text" class="form-control"
                  placeholder="PAN Number" required="required" />
              </div>
              <div class="form-group">
                <input placeholder="Aadhar" name="aadharNumber"
                  path="aadharNumber" type="text" class="form-control"
                  required="required" /> <small class="form-text text-muted">Your
                  Aadhar Number will not ever be shared</small>
              </div>
  
              <h6 class="test-dark">Pension Type:</h6>
              <div class="form-check form-check-inline">
                <form:label class="form-check-label" path="pensionType"
                  for="self">Self
  <form:radiobutton path="pensionType" name="type" id="self"
                    class="form-check-input" value="self" required="required"/>
                </form:label>
              </div>
              <div class="form-check form-check-inline">
                <form:label class="form-check-label" path="pensionType"
                  for="family">Family
  <form:radiobutton path="pensionType" name="type" id="family"
                    class="form-check-input" value="family" />
                </form:label>
              </div>
              <br>
              <br>
              <div class="form-group float-left">
                <input id="submitBtn" name="submit" class="btn btn-dark"
                  style="cursor: pointer;" type="submit" value="Fetch Details"
                  formmethod="post" />
              </div>
            </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
