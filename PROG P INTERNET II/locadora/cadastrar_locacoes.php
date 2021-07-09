<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Cadastrar Locação</title>
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
				echo "<p class=\"erro\">Locação não cadastrada! MySQL erro: {$msg}</p>";
			}
		?>
		<form action="cadastrar_locacoes_db.php" method="post">
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
			
			<label for="id_midia">Mídia</label><br>
			<select name="id_midia" id="id_midia">
			<?php
				$sql = "SELECT id, titulo FROM midia";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>"><?php echo $item['titulo']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="data_coleta">Data Coleta</label><br>
			<input type="date" name="data_coleta" id="data_coleta">
			<input type="time" name="hora_coleta" id="hora_coleta"><br><br>
			
			<label for="data_prevista">Data Prevista</label><br>
			<input type="date" name="data_prevista" id="data_prevista"><br><br>
			
			<label for="data_entrega">Data Entrega</label><br>
			<input type="date" name="data_entrega" id="data_entrega">
			<input type="time" name="hora_entrega" id="hora_entrega"><br><br>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>