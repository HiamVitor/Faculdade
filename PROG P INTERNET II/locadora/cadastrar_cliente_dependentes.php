<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Cadastrar Dependentes</title>
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
				echo "<p class=\"erro\">Dependente não cadastrado! MySQL erro: {$msg}</p>";
			} else if ($erro == 3) {
				echo "<p class=\"erro\">Dependente não cadastrado! Erro: {$msg}</p>";
			}
		?>
		<form action="cadastrar_cliente_dependentes_db.php" method="post" enctype="multipart/form-data">
			<label for="id_cliente">Cliente</label><br>
			<select name="id_cliente" id="id_cliente">
			<?php
				$sql = "SELECT id, nome FROM clientes";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>"><?php echo $item['nome']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="nome">Nome</label><br>
			<input type="text" name="nome" id="nome" maxlength="150"><br><br>
			
			<label for="cpf">CPF</label><br>
			<input type="text" name="cpf" id="cpf" maxlength="11"><br><br>
			
			<label for="foto">Foto</label><br>
			<input type="file" name="foto" id="foto"><br><br>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>