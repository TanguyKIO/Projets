<?php 	

	$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop'); 
	$erreur="";
	if (isset($_POST['login']) && isset($_POST['mdp'])){
		$login=$_POST['login'];
		$mdp=SHA1($_POST['mdp']);
		$query = "SELECT customer_id,username,password FROM logins WHERE username = '".$login."' AND password= '".$mdp."'";
		$result = mysqli_query($cnxDb, $query);
		$id= mysqli_fetch_assoc($result);
		//Sauvegarde du login, du mot de passe, du nom et du prénom de l'utilisateur si il appartient à la base de données
		if(mysqli_num_rows($result)!=0){
			$_SESSION['role'] = $login;	
			$_SESSION['login'] = $login; 
			$_SESSION['mdp'] = $mdp;
			$_SESSION['customer_id']=$id['customer_id'];
			session_id($id['customer_id']);
			$erreur="";
			$_SESSION['role'] = $login;
			header('Location:index.php?page=Home');
		}
		else {
			session_id();
			$erreur= "L'utilisateur n'est pas reconnu !";
		}
	}
	
	require_once(PATH_VIEWS."bar.php");
	require_once(PATH_VIEWS."Categorie.php");
	require_once(PATH_VIEWS."login.php");
?>