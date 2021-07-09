<?php
	include('validar.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Cadastrar Clientes</title>
		<link rel="stylesheet" type="text/css" href="site.css">
	</head>
	<body>
		<?php
			include('menu.php');
		?>
		<?php
			$erro = @$_GET['erro'];
			$msg  = @$_GET['msg'];
			if ($erro == 2) {
				echo "<p class=\"erro\">Cliente não cadastrado! MySQL erro: {$msg}</p>";
			} else if ($erro == 3) {
				echo "<p class=\"erro\">Cliente não cadastrado! Erro: {$msg}</p>";
			}
		?>
		<form action="cadastrar_clientes_db.php" method="post" enctype="multipart/form-data">
			<label for="nome">Nome</label><br>
			<input type="text" name="nome" id="nome" maxlength="150"><br><br>
			
			<label for="endereco">Endereço</label><br>
			<input type="text" name="endereco" id="endereco" maxlength="150"><br><br>
			
			<label for="telefone">Telefone</label><br>
			<input type="text" name="telefone" id="telefone" maxlength="10"><br><br>
			
			<label for="celular">Celular</label><br>
			<input type="text" name="celular" id="celular" maxlength="11"><br><br>
			
			<label for="cpf">CPF</label><br>
			<input type="text" name="cpf" id="cpf" maxlength="11"><br><br>
			
			<label for="foto">Foto</label><br>
			<input type="file" name="foto" id="foto"><br><br>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>