<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Alterar Locação</title>
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
				echo "<p class=\"erro\">Locação não alterada! MySQL erro: {$msg}</p>";
			}
		?>
		<form action="alterar_locacoes_db.php" method="post">
			<?php
				$id = $_GET['id'];
				
				$sql = "SELECT * FROM locacao WHERE id = {$id}";
				
				$query = mysqli_query($conexao, $sql);
				$dado = mysqli_fetch_array($query, MYSQLI_ASSOC);
			?>	
			<input type="hidden" name="id" value="<?php echo $id; ?>">
			
			<label for="codigo">Código</label><br>
			<input type="text" name="codigo" id="codigo" maxlength="11" value="<?php echo $id; ?>" disabled="true"><br><br>
			
			<label for="id_cliente">Cliente</label><br>
			<select name="id_cliente" id="id_cliente">
			<?php
				$sql = "SELECT id, nome FROM s";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>" <?php if($dado['id_cliente'] == $item['id']) { ?>selected="selected"<?php } ?>><?php echo $item['nome']; ?></option>
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
				<option value="<?php echo $item['id']; ?>" <?php if($dado['id_midia'] == $item['id']) { ?>selected="selected"<?php } ?>><?php echo $item['titulo']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="data_coleta">Data Coleta</label><br>
			<?php $coleta = explode(' ', $dado['data_coleta']); ?>
			<input type="date" name="data_coleta" id="data_coleta" value="<?php echo @$coleta[0]; ?>">
			<input type="time" name="hora_coleta" id="hora_coleta" value="<?php echo @$coleta[1]; ?>"><br><br>
			
			<label for="data_prevista">Data Prevista</label><br>
			<input type="date" name="data_prevista" id="data_prevista" value="<?php echo $dado['data_prevista']; ?>"><br><br>
			
			<label for="data_entrega">Data Entrega</label><br>
			<?php $entrega = explode(' ', $dado['data_entrega']); ?>
			<input type="date" name="data_entrega" id="data_entrega" value="<?php echo @$entrega[0]; ?>">
			<input type="time" name="hora_entrega" id="hora_entrega" value="<?php echo @$entrega[1]; ?>"><br><br>
			
			<button type="submit">Alterar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>