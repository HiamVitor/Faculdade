<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Cadastrar Mídia</title>
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
				echo "<p class=\"erro\">Mídia não cadastrada! MySQL erro: {$msg}</p>";
			} else if ($erro == 3) {
				echo "<p class=\"erro\">Mídia não cadastrada! Erro: {$msg}</p>";
			}
		?>
		<form action="cadastrar_midias_db.php" method="post" enctype="multipart/form-data">
			<label for="id_distribuidor">Distribuidor</label><br>
			<select name="id_distribuidor" id="id_distribuidor">
			<?php
				$sql = "SELECT id, razao_social FROM distribuidor";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>"><?php echo $item['razao_social']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="titulo">Título</label><br>
			<input type="text" name="titulo" id="titulo" maxlength="150"><br><br>
			
			<label for="duracao">Duração</label><br>
			<input type="text" name="duracao" id="duracao" maxlength="8"><br><br>
			
			<label for="valor_compra">Valor Compra</label><br>
			<input type="text" name="valor_compra" id="valor_compra" maxlength="6"><br><br>
			
			<label for="valor_locacao">Valor Locação</label><br>
			<input type="text" name="valor_locacao" id="valor_locacao" maxlength="5"><br><br>
			
			<label for="tipo_midia">Tipo Mídia</label><br>
			<select name="tipo_midia" id="tipo_midia">
				<option value="VHS">VHS</option>
				<option value="DVD">DVD</option>
				<option value="Blu-Ray">Blu-Ray</option>
			</select><br><br>
			
			<label for="classificacao">Classificação</label><br>
			<select name="classificacao" id="classificacao">
				<option value="A">A</option>
				<option value="B">B</option>
				<option value="C">C</option>
				<option value="D">D</option>
			</select><br><br>
			
			<label for="quantidade">Quantidade</label><br>
			<input type="number" name="quantidade" id="quantidade"><br><br>
			
			<label for="sinopse">Sinopse</label><br>
			<textarea name="sinopse" id="sinopse"></textarea><br><br>
			
			<label for="foto">Foto</label><br>
			<input type="file" name="foto" id="foto"><br><br>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>