<?php
	include('validar.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Cadastrar Distribuidores</title>
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
				echo "<p class=\"erro\">Distribuidor não cadastrado! MySQL erro: {$msg}</p>";
			} else if ($erro == 3) {
				echo "<p class=\"erro\">Distribuidor não cadastrado! Erro: {$msg}</p>";
			}
		?>
		<form action="cadastrar_distribuidores_db.php" method="post" enctype="multipart/form-data">
			<label for="razao_social">Razão Social</label><br>
			<input type="text" name="razao_social" id="razao_social" maxlength="150"><br><br>
			
			<label for="endereco">Endereço</label><br>
			<input type="text" name="endereco" id="endereco" maxlength="150"><br><br>
			
			<label for="telefone">Telefone</label><br>
			<input type="text" name="telefone" id="telefone" maxlength="10"><br><br>
			
			<label for="nome_contato">Nome contato</label><br>
			<input type="text" name="nome_contato" id="nome_contato" maxlength="150"><br><br>
			
			<label for="cnpj">CNPJ</label><br>
			<input type="text" name="cnpj" id="cnpj" maxlength="14"><br><br>
			
			<label for="foto">Foto</label><br>
			<input type="file" name="foto" id="foto"><br><br>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>