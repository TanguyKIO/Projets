<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8"/>
    <link href="Content\css\bootstrap.css" rel="stylesheet" />
    <link href="Content\css\design.css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ISIWEB4SHOP</title>
  </head>
  <body>
      <div class="navbar navbar-inverse navbar-fixed-top">
          <div class="container">
              <div class="navbar-header">
                  <a class='navbar-brand'href="index.php?page=Home"> ISIWEB4Shop </a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <?php
                if($_SESSION['role'] != 'invite'){
                  echo("<li><p class='navbar-text'> <span class='glyphicon glyphicon-user'></span> ".$_SESSION['role']." </p></li>");
                  echo("<li><p class='navbar-text'> <span class='glyphicon glyphicon-log-in'> </span> <a href='index.php?page=Deconnexion'> Déconnexion </a> </p></li>");
                }
                else{
                  echo("<li><p class='navbar-text'> <span class='glyphicon glyphicon-user'> </span> <a href='index.php?page=Inscription'> S'inscrire </a> </p></li>");
                  echo("<li><p class='navbar-text'> <span class='glyphicon glyphicon-log-in'> </span> <a href='index.php?page=login'> Se connecter </a> </p></li>");
                }
                ?>
                  <li><p class="navbar-text"> <span class="glyphicon glyphicon-shopping-cart"> </span> <a href="index.php?page=Panier"> Panier </a></p></li> <!--Metttre le nombre d'article en badge pour le panier-->
              </ul>
          </div>
      </div>