<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA</title>
		<link rel="stylesheet" type="text/css" href="site.css">
	</head>
	<body>
		<?php
			$erro = isset($_GET['erro']) ? $_GET['erro'] : false;
			if($erro == 1) {
				echo "<p class=\"erro\">Usuário ou senha inválida!</p>";
			} elseif ($erro == 2) {
				echo "<p class=\"erro\">Usuário está inativo!</p>";
			}
		?>
		<form action="login_db.php" method="POST">
			<label for="login">Login</label><br>
			<input type="text" name="login" id="login" maxlength="20"><br><br>
			
			<label for="senha">Senha</label><br>
			<input type="password" name="senha" id="senha" maxlength="20"><br><br>
			
			<button type="submit">Login</button>
		</form>
	</body>
</html>