<?php 
	//var_dump($_SESSION);
	$cnxDb = mysqli_connect('localhost', 'root', '', 'isiweb4shop'); 
?>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html"; charset="utf-8"/>
   <link href="Content\css\bootstrap.css" rel="stylesheet" />
   <link href="Content\css\design.css" rel="stylesheet" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Panier</title>
</head>
<body>
	<table>
		<Caption>Panier</Caption>
			<tr>
				<th>Nom produit </th>
				<th> Prix </th>
				<th> Quantité </th>
				<th> Sous-total </th>
			</tr>
			
			<?php 
				$id = array_keys($_SESSION['invit']);
				if(empty($id)){
					$product = array();
				}
				else{
					$product = mysqli_query($cnxDb, "SELECT id FROM orderitems WHERE id IN ('.implode(',',$id).')");					
				}
				foreach($product as $orderitems):
			?>
			<tr>
				<img src="productimages/<?= $product->id; ?>.jpg" height="53">
				<th><?php $product->name;?></th>
				<th><?php number_format($product->Prix,2,',',''); ?> € </th>
				<th> </th>
				<th> </th>
				<th><a href="panier.php?del"<?php $product->id; ?> class="del"><class="glyphicon glyphicon-trash"></th>
			</tr>
			<?php endforeach; ?>
	</table>
</body>

</html>