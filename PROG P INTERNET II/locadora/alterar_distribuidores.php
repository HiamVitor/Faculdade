<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Alterar Distribuidores</title>
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
				echo "<p class=\"erro\">Distribuidor não alterado! MySQL erro: {$msg}</p>";
			} else if ($erro == 4) {
				echo "<p class=\"erro\">Distribuidor não alterado! Erro: {$msg}</p>";
			}
		?>
		<form action="alterar_distribuidores_db.php" method="post" enctype="multipart/form-data">
			<?php
				$id = $_GET['id'];
				
				$sql = "SELECT * FROM distribuidor WHERE id = {$id}";
				$query = mysqli_query($conexao, $sql);
				$item = mysqli_fetch_array($query, MYSQLI_ASSOC);
			?>
			<input type="hidden" name="id" value="<?php echo $id; ?>">			
			
			<label for="codigo">Código</label><br>
			<input type="text" name="codigo" id="codigo" maxlength="11" value="<?php echo $item['id']; ?>" disabled="true"><br><br>
			
			<label for="razao_social">Razão Social</label><br>
			<input type="text" name="razao_social" id="razao_social" value="<?php echo $item['razao_social']; ?>" maxlength="150"><br><br>
			
			<label for="endereco">Endereço</label><br>
			<input type="text" name="endereco" id="endereco" value="<?php echo $item['endereco']; ?>" maxlength="150"><br><br>
			
			<label for="telefone">Telefone</label><br>
			<input type="text" name="telefone" id="telefone" value="<?php echo $item['telefone']; ?>" maxlength="10"><br><br>
			
			<label for="nome_contato">Nome contato</label><br>
			<input type="text" name="nome_contato" id="nome_contato" value="<?php echo $item['nome_contato']; ?>" maxlength="150"><br><br>
			
			<label for="cnpj">CNPJ</label><br>
			<input type="text" name="cnpj" id="cnpj" value="<?php echo $item['cnpj']; ?>" maxlength="14"><br><br>
			
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