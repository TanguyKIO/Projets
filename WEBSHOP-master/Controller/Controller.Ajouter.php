<?php
	$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop');
	mysqli_select_db($cnxDb,'isiweb4shop');

	if(isset($_GET['id']) != NULL){
		$id = $_GET['id'];
		//$sql_product = "SELECT name,price FROM products WHERE id = ".$id.";";
		//$res = mysqli_query($cnxDb, $sql_product) or die("erreur produit");
		//$result = mysqli_fetch_assoc($res);
		//var_dump($result);

		//echo $_POST['nbprod'];
		$sql_ajout = "INSERT INTO orderitems (id, order_id, product_id, quantity) VALUES ('NULL', 1, ".$id.", 2);";
		mysqli_query($cnxDb, $sql_ajout) or die("erreur ajout");
		header("Location: products.php");
	}
	else{
		die("Vous n'avez pas sélectionner de produit");
	}
	

?>