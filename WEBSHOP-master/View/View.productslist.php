      <div class="container body-content column-right">
            <?php
              echo"<table><tr>";
              foreach ($products as $value) {
                $id=get_idprod($value);
                echo"<tr>";
                echo "<td class='tdprod'><a href='Index.php?page=products&product=".$value."'>$value </td>";
                echo "<td class='tdprod'><img src='Content/productimages/$img_name' alt='$img_name'></a></td>";
                echo "<td class='tdprod'>Prix : $prix[$id] €</td>";
                echo "<td class='tdprod'> Description :<br/>";
                show_desc($value);
                echo "</tr>";
              }
              echo("</tr></table>")
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
