<?php
  require_once("./config/configuration.php");

  //Création de variables de session si on est un invité
  if(!isset($_SESSION['role'])){
    $_SESSION['role'] = 'invite';
    $_SESSION['id'] = session_id();
    $_SESSION['customerid'] = session_id();
  }

  //Affichage d'une page donnée ou de la page par défaut
  if(isset($_GET['page']))
    require_once(PATH_CONTROLLERS.$_GET['page'].".php");
  else
    require_once(PATH_CONTROLLERS."Home.php");

?>