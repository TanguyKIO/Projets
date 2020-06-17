		<div class="container body-content column-right">
			<div class="container body-content column-right">
				<h1> <?=$product_name ?> </h1> <hr />
			</div>
            <?php
              echo "<p><img class='imgprod' src='Content/productimages/$img_name' alt='$img_name'</p><hr/>";
              show_desc($product_name);
            ?>

              <hr />
              <input type="button" value="-" onclick="clic_moins()"/>
              <input type="text" name="nbprod" id="nbprod" value="0" onselect="bloque_champ(this);" onFocus="bloque_champ(this);"/>
              <input type="button" value="+" onclick="clic_plus()"/>
			  <! --aouter id-->
			  <span class="glyphicon glyphicon-shopping-cart"> </span> <a href="Ajouter.Controler.php?id=1"> ajouter</a>
            <hr />
              <?php
                getPrixNb();
               ?>
            <hr />
            <footer>
              <?php
                echo("<p>".date("Y")." - ISIWEB4Shop</p>");
              ?>
            </footer>
		</div>
	</body>
</html>
