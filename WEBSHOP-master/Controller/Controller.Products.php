<?php
	$product_name = $_GET['product'];
	$img_name='biscuitRaisin.jpg'; //faire une fonction get en fct de category
	
	function show_desc($string){
		$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop');
		mysqli_select_db($cnxDb,'isiweb4shop');
		
		echo"zaioahaoighazioghazioghazoi";
	}
	
	function getPrixNb(){
		echo "5 €";
	}
	    
	echo '<script type="text/javascript" src="product.js"></script>';

	require_once(PATH_VIEWS."bar.php");
	require_once(PATH_VIEWS."Categorie.php");
	require_once(PATH_VIEWS."products.php");
?>