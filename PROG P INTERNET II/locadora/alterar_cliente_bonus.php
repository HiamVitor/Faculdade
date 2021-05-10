<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Alterar Bônus</title>
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
				echo "<p class=\"erro\">Bônus não alterado! MySQL erro: {$msg}</p>";
			}
		?>
		<form action="alterar_cliente_bonus_db.php" method="post">
			<?php
				$id = $_GET['id'];
				
				$sql = "SELECT * FROM cliente_bonus WHERE id = {$id}";
				
				$query = mysqli_query($conexao, $sql);
				$dado = mysqli_fetch_array($query, MYSQLI_ASSOC);
			?>	
			<input type="hidden" name="id" value="<?php echo $id; ?>">
			
			<label for="codigo">Código</label><br>
			<input type="text" name="codigo" id="codigo" maxlength="11" value="<?php echo $id; ?>" disabled="true"><br><br>
			
			<label for="id_cliente">Cliente</label><br>
			<select name="id_cliente" id="id_cliente">
			<?php
				$sql = "SELECT id, nome FROM cliente";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>" <?php if($dado['id_cliente'] == $item['id']) { ?>selected="selected"<?php } ?>><?php echo $item['nome']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="data_validade_ini">Data Inicio</label><br>
			<input type="date" name="data_validade_ini" id="data_validade_ini" value="<?php echo $dado['data_validade_ini']; ?>"><br><br>
			
			<label for="data_validade_fim">Data Final</label><br>
			<input type="date" name="data_validade_fim" id="data_validade_fim" value="<?php echo $dado['data_validade_fim']; ?>"><br><br>
			
			<label for="locacao_gratis">Locação gratis</label><br>
			<input type="number" name="locacao_gratis" id="locacao_gratis" value="<?php echo $dado['locacao_gratis']; ?>"><br><br>
			
			<label for="desconto">Desconto</label><br>
			<input type="text" name="desconto" id="desconto" value="<?php echo $dado['desconto']; ?>"><br><br>
			
			<button type="submit">Alterar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>