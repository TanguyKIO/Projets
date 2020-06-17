<?php
function show_desc($string){
	$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop');
	mysqli_select_db($cnxDb,'isiweb4shop');
	
  echo"zaioahaoighazioghazioghazoi";
}

function get_idprod($string){
  return 1;
}

$category=$_GET["category"];
$img_name='biscuitRaisin.jpg'; //faire une fonction get en fct de category
$catcontrol=array ('Boissons', 'Biscuits', 'Fruits secs');
$prix=array(4,5, 5,2);
foreach ($catcontrol as $value) {
    if($value==$category){
      $products=array ('Thé vert','Thé noir','Café',"Jus d'orange"); //mettre des id
    }
}
function getPrixNb(){
  echo "5 €";
}
$product_name=$_GET['product'];

require_once(PATH_VIEWS."bar.php");
require_once(PATH_VIEWS."Categorie.php");
require_once(PATH_VIEWS."Productslist.php");
 ?>
