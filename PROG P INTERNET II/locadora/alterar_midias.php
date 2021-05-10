<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Alterar Mídia</title>
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
				echo "<p class=\"erro\">Mídia não alterada! MySQL erro: {$msg}</p>";
			} else if ($erro == 4) {
				echo "<p class=\"erro\">Mídia não alterada! Erro: {$msg}</p>";
			}
		?>
		<form action="alterar_midias_db.php" method="post" enctype="multipart/form-data">
			<?php
				$id = $_GET['id'];
				
				$sql = "SELECT * FROM midia WHERE id = {$id}";
				
				$query = mysqli_query($conexao, $sql);
				$dado = mysqli_fetch_array($query, MYSQLI_ASSOC);
			?>	
			<input type="hidden" name="id" value="<?php echo $id; ?>">
			
			<label for="codigo">Código</label><br>
			<input type="text" name="codigo" id="codigo" maxlength="11" value="<?php echo $id; ?>" disabled="true"><br><br>
			
			<label for="id_distribuidor">Distribuidor</label><br>
			<select name="id_distribuidor" id="id_distribuidor">
			<?php
				$sql = "SELECT id, razao_social FROM distribuidor";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>" <?php if($dado['id_distribuidor'] == $item['id']) { ?>selected="selected"<?php } ?>><?php echo $item['razao_social']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="titulo">Título</label><br>
			<input type="text" name="titulo" id="titulo" maxlength="150" value="<?php echo $dado['titulo']; ?>"><br><br>
			
			<label for="duracao">Duração</label><br>
			<input type="text" name="duracao" id="duracao" maxlength="8" value="<?php echo $dado['duracao']; ?>"><br><br>
			
			<label for="valor_compra">Valor Compra</label><br>
			<input type="text" name="valor_compra" id="valor_compra" maxlength="6" value="<?php echo $dado['valor_compra']; ?>"><br><br>
			
			<label for="valor_locacao">Valor Locação</label><br>
			<input type="text" name="valor_locacao" id="valor_locacao" maxlength="5" value="<?php echo $dado['valor_locacao']; ?>"><br><br>
			
			<label for="tipo_midia">Tipo Mídia</label><br>
			<select name="tipo_midia" id="tipo_midia">
				<option value="VHS" <?php if($dado['tipo_midia'] == 'VHS') { ?>selected="selected"<?php } ?>>VHS</option>
				<option value="DVD" <?php if($dado['tipo_midia'] == 'DVD') { ?>selected="selected"<?php } ?>>DVD</option>
				<option value="Blu-Ray" <?php if($dado['tipo_midia'] == 'Blu-Ray') { ?>selected="selected"<?php } ?>>Blu-Ray</option>
			</select><br><br>
			
			<label for="classificacao">Classificação</label><br>
			<select name="classificacao" id="classificacao">
				<option value="A" <?php if($dado['classificacao'] == 'A') { ?>selected="selected"<?php } ?>>A</option>
				<option value="B" <?php if($dado['classificacao'] == 'B') { ?>selected="selected"<?php } ?>>B</option>
				<option value="C" <?php if($dado['classificacao'] == 'C') { ?>selected="selected"<?php } ?>>C</option>
				<option value="D" <?php if($dado['classificacao'] == 'D') { ?>selected="selected"<?php } ?>>D</option>
			</select><br><br>
			
			<label for="quantidade">Quantidade</label><br>
			<input type="number" name="quantidade" id="quantidade" value="<?php echo $dado['quantidade']; ?>"><br><br>
			
			<label for="sinopse">Sinopse</label><br>
			<textarea name="sinopse" id="sinopse"><?php echo $dado['sinopse']; ?></textarea><br><br>
			
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