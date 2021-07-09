<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Alterar Dependentes</title>
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
				echo "<p class=\"erro\">Dependente não alterado! MySQL erro: {$msg}</p>";
			} else if ($erro == 4) {
				echo "<p class=\"erro\">Dependente não alterado! Erro: {$msg}</p>";
			}
		?>
		<form action="alterar_cliente_dependentes_db.php" method="post" enctype="multipart/form-data">
			<?php
				$id = $_GET['id'];
				
				$sql = "SELECT * FROM cliente_dependente WHERE id = {$id}";
				
				$query = mysqli_query($conexao, $sql);
				$dado = mysqli_fetch_array($query, MYSQLI_ASSOC);
			?>	
			<input type="hidden" name="id" value="<?php echo $id; ?>">
			
			<label for="codigo">Código</label><br>
			<input type="text" name="codigo" id="codigo" maxlength="11" value="<?php echo $id; ?>" disabled="true"><br><br>
			
			<label for="id_cliente">Cliente</label><br>
			<select name="id_cliente" id="id_cliente">
			<?php
				$sql = "SELECT id, nome FROM clientes";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>" <?php if($dado['id_cliente'] == $item['id']) { ?>selected="selected"<?php } ?>><?php echo $item['nome']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="nome">Nome</label><br>
			<input type="text" name="nome" id="nome" maxlength="150" value="<?php echo $dado['nome']; ?>"><br><br>
			
			<label for="cpf">CPF</label><br>
			<input type="text" name="cpf" id="cpf" maxlength="11" value="<?php echo $dado['cpf']; ?>"><br><br>
			
			<label for="foto">Foto</label><br>
			<input type="file" name="foto" id="foto"><br><br>
			
			<?php
				if ($dado['foto']) {
			?>
			<img src="img/cliente/<?php echo $dado['foto']; ?>"><br><br>
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