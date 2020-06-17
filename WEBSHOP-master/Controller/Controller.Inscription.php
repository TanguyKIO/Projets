<?php 
	require_once(PATH_VIEWS."bar.php");
	require_once(PATH_VIEWS."Categorie.php");
	require_once(PATH_VIEWS."Insciption.php");
	
	$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop');
	mysqli_select_db($cnxDb,'isiweb4shop');
	$login = $_POST['login'];
	
	if ($login){
		$sql_customers = "INSERT INTO customers (id, forname, surname, add1, add2, add3, postcode, phone, email, registered) 
		VALUES ('NULL', '".$_POST['forname']."', '". $_POST['login']."', 'ligne adresse1', 'ligne adresse 2', '".$_POST['add3']."', '".$_POST['postcode']."', '".$_POST['phone']."', '".$_POST['email']."', 1)";
		//echo $sql_customers;
		$result = mysqli_query($cnxDb, $sql_customers) or die("erreur customer");
		
		$sql_logins = "INSERT INTO logins (id, customer_id, username, password)
		VALUES ('NULL', 'NULL', '".$_POST['login']."', '".SHA1($_POST['mdp'])."')";
		//echo $sql_logins;
		$result = mysqli_query($cnxDb, $sql_logins) or die("erreur logins");;
	
		header('Location:index.php?page=Home');
	}
	
?>