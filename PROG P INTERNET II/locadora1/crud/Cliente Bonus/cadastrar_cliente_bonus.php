<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Cadastrar Bônus</title>
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
				echo "<p class=\"erro\">Bonus não cadastrado! MySQL erro: {$msg}</p>";
			}
		?>
		<form action="cadastrar_cliente_bonus_db.php" method="post">
			<label for="id_cliente">Cliente</label><br>
			<select name="id_cliente" id="id_cliente">
			<?php
				$sql = "SELECT id, nome FROM cliente";
				$query = mysqli_query($conexao, $sql);
				while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
			?>
				<option value="<?php echo $item['id']; ?>"><?php echo $item['nome']; ?></option>
			<?php
				}
			?>
			</select><br><br>
			
			<label for="data_validade_ini">Data Inicio</label><br>
			<input type="date" name="data_validade_ini" id="data_validade_ini"><br><br>
			
			<label for="data_validade_fim">Data Final</label><br>
			<input type="date" name="data_validade_fim" id="data_validade_fim"><br><br>
			
			<label for="locacao_gratis">Locação gratis</label><br>
			<input type="number" name="locacao_gratis" id="locacao_gratis"><br><br>
			
			<label for="desconto">Desconto</label><br>
			<input type="text" name="desconto" id="desconto"><br><br>
			
			<button type="submit">Cadastrar</button>
		</form>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>