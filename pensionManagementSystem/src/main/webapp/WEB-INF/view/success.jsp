<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <link
      href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    />
    <title>Pension Management</title>
    <style>
      .transparent {
        background-color: transparent; /*whichever you want*/
        opacity: 0.7; /*0.5 determines transparency value*/
        filter: (opacity=70);
      }
      .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        color: #4d0000;
        text-align: center;
        display: inline-block;
        font-weight: bold;
      }
    </style>
    <script type="text/javascript">
      window.history.forward();
      function noBack() {
        window.history.forward();
      }
    </script>
  </head>
  <body
    style="
      background-image: url(https://cdn.retirementvillages.co.uk/uploads/2018/01/home-relax-2.jpg);
      background-size: cover;
      background-repeat: no-repeat;
      background-position: cover;
    "
  >
    <header>
      <nav class="navbar bg-dark transparent">
        <h3
          class="text-center display-5 text-uppercase font-bold"
          style="margin-top: 5px; font-family: sans-serif; color: #ffffff"
        >
          <i class="fab fa-google-wallet"> </i>&nbsp; Pension Management Portal
        </h3>
        <a href="/logout" style="align: right">Logout</a>
      </nav>
    </header>
    <section>
      <div class="container" style="margin-top: 200px">
        <h1 class="font-weight-bold" style="color: #ffffff" id="errorMessage">
          ${msg}
        </h1>
        <br />
        <h3
          class="text-success font-weight-bold"
          style="color: #ffffff"
          id="errorMessage"
        >
          ${info}
        </h3>
      </div>
    </section>
  </body>
</html>
