<?php
  require_once "Connexion.php" ;

  class DialogueBD {

    public function getCodesCategorie(){

      try
      {
        $conn = Connexion::getConnexion();
        $sql = "SELECT codeCat FROM categories ORDER BY ordreCat";
        $sth = $conn->prepare($sql);
        $sth->execute();
        $tabCat = $sth->fetchAll(PDO::FETCH_ASSOC);

        return $tabCat;
      }
      catch (PDOException $e)
      {
        $erreur = $e->getMessage();
      }
    }

    public function getLibellesCategorie(){

      try
      {
        $conn = Connexion::getConnexion();
        $sql = "SELECT libelleCat FROM categories ORDER BY ordreCat";
        $sth = $conn->prepare($sql);
        $sth->execute();
        $tabLib = $sth->fetchAll(PDO::FETCH_ASSOC);

        return $tabLib;
      }
      catch (PDOException $e)
      {
        $erreur = $e->getMessage();
      }
    }

    public function getPlatsCategorie($categorie){

      try
      {
        $conn = Connexion::getConnexion();
        $sql = "SELECT * FROM plats WHERE codeCat= ? ORDER BY prix";
        $sth = $conn->prepare($sql);
        $sth->execute(array($categorie));
        $tabPlats = $sth->fetchAll(PDO::FETCH_ASSOC);

        return $tabPlats;
      }
      catch (PDOException $e)
      {
        $erreur = $e->getMessage();
      }
    }

    public function getCountCategories(){

      try
      {
        $conn = Connexion::getConnexion();
        $sql = "SELECT COUNT(p.refPlat) AS countPlat FROM plats p NATURAL JOIN Categories c GROUP BY c.codeCat ORDER BY c.ordreCat";
        $sth = $conn->prepare($sql);
        $sth->execute();
        $tabCount = $sth->fetchAll(PDO::FETCH_ASSOC);

        return $tabCount;
      }
      catch (PDOException $e)
      {
        $erreur = $e->getMessage();
      }
    }

    public function getUtilisateur($login, $mdp){

      try
      {
        $conn = Connexion::getConnexion();
        $sql = "SELECT * FROM utilisateurs";
        $sth = $conn->prepare($sql);
        $sth->execute(array($login, $mdp));
        $tabUser = $sth->fetchAll(PDO::FETCH_ASSOC);

        return $tabUser;
      }
      catch (PDOException $e)
      {
        $erreur = $e->getMessage();
      }
    }

  }

?>
