<div class="columnleft">
	<nav class="vertical-menu">
		<a class="accueil active" href="index.php?page=Home">Accueil</a></li>
		  <?php
			$cat=array ('Boissons', 'Biscuits','Fruits secs');
			  foreach ($cat as $value) {
				echo "<a href='Index.php?page=productslist&category=".$value."'>Nos $value</a>";
			}
		 ?>
	</nav>
</div>