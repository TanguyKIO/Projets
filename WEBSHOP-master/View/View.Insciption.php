<!DOCTYPE html PUBLIC>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="style.css">
    <title>Inscription au site</title>
	

		<div class="container body-content column-right">
			<center>
				<h2>Inscription</h2>

				<form  method="post" action="index.php?page=Inscription">
					<p>
						<label for="text">Nom</label><br/>
						<input type="text" name="login" required />
					</p>
					<p>
						<label for="text">Prénom</label><br/>
						<input type="text" name="forname" required />
					</p>
					<p>
						<label for="text">Ville</label><br/>
						<input type="text" name="add3" required />
					</p>
					<p>
						<label for="text">Code Postal</label><br/>
						<input type="text" name="postcode" required />
					</p>
					<p>
						<label for="text">num tel</label><br/>
						<input type="text" name="phone" required />
					</p>
					<p>
						<label for="text">email</label><br/>
						<input type="text" name="email" required />
					</p>
					<p>
						<label for="password">Mot de passe</label><br/>
						<input type="password" name="mdp" required />
					</p>
					<input type="submit" name="Inscription" value ="S'inscrire"></a>
				</form>
			</center>
			
			<footer>
			  <?php
				echo("<p>".date("Y")." - ISIWEB4Shop</p>");
			  ?>
			</footer>
		</div>

	
	</body>
</html>