
		<center>
		<div class="container body-content column-right">

			<h2>Connection</h2>

			<form  method="post" action="index.php?page=login">
				<p>
					<label for="text">Identifiant</label><br/>
					<input type="text" name="login" required />
				</p>
				<p>
					<label for="password">Mot de passe</label><br/>
					<input type="password" name="mdp" required />
				</p>
				<input type="submit" name="connection" value ="Se connecter"></a>
			</form>
				<p>
					<h1> <?= $erreur ?></h1>
				</p>

		</div>
		</center>
	</body>
</html>