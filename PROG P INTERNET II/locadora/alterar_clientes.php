<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Alterar Clientes</title>
		<link rel="stylesheet" type="text/css" href="site.css">
	</head>
	<body>
		<?php
			include('menu.php');
		?>
		<?php
			$erro = @$_GET['erro'];
			$msg  = @$_GET['msg'];
			if ($erro == 3) {
				echo "<p class=\"erro\">Cliente não alterado! MySQL erro: {$msg}</p>";
			} else if ($erro == 4) {
				echo "<p class=\"erro\">Cliente não alterado! Erro: {$msg}</p>";
			}
		?>
		<form action="alterar_clientes_db.php" method="post" enctype="multipart/form-data">
			<?php
				$id = $_GET['id'];
				
				$sql = "SELECT * FROM clientes WHERE id = {$id}";
				$query = mysqli_query($conexao, $sql);
				$item = mysqli_fetch_array($query, MYSQLI_ASSOC);
			?>
			<input type="hidden" name="id" value="<?php echo $id; ?>">			
			
			<label for="codigo">Código</label><br>
			<input type="text" name="codigo" id="codigo" maxlength="11" value="<?php echo $item['id']; ?>" disabled="true"><br><br>
			
			<label for="nome">Nome</label><br>
			<input type="text" name="nome" id="nome" maxlength="150" value="<?php echo $item['nome']; ?>"><br><br>
			
			<label for="endereco">Endereço</label><br>
			<input type="text" name="endereco" id="endereco" maxlength="150" value="<?php echo $item['endereco']; ?>"><br><br>
			
			<label for="telefone">Telefone</label><br>
			<input type="text" name="telefone" id="telefone" maxlength="10" value="<?php echo $item['telefone']; ?>"><br><br>
			
			<label for="celular">Celular</label><br>
			<input type="text" name="celular" id="celular" maxlength="11" value="<?php echo $item['celular']; ?>"><br><br>
			
			<label for="cpf">CPF</label><br>
			<input type="text" name="cpf" id="cpf" maxlength="11" value="<?php echo $item['cpf']; ?>"><br><br>
			
			<label for="foto">Foto</label><br>
			<input type="file" name="foto" id="foto"><br><br>
			
			<?php
				if ($item['foto']) {
			?>
			<img src="img/cliente/<?php echo $item['foto']; ?>"><br><br>
			<?php
				}
			?>
			
			<button type="submit">Alterar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>