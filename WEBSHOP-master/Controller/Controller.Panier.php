<?php 
	$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop');
	mysqli_select_db($cnxDb,'isiweb4shop');
	
	$sql_panier = "SELECT id_ FROM orderitems WHERE id = ".$id.";";
	
	if(isset($GET['id'])){
		$sql_panier = "SELECT product_id,quantity FROM products WEHRE id = '".$GET['id']."'";
		//echo $sql_panier;
		$res = mysqli_query($cnxDb, $sql_product) or die("erreur produit");
		$result = mysqli_fetch_assoc($res);
		
	}
	require_once(PATH_VIEWS.'bar.php');
	require_once(PATH_VIEWS.'Categorie.php');
	require_once(PATH_VIEWS.'cart.php');

?>