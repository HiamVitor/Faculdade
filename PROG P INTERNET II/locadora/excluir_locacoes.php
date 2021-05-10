<?php
	include('validar.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Excluir Locação</title>
	</head>
	<body>
		<?php
			include('menu.php');
		?>
		<form action="excluir_locacoes_db.php" method="post">
			<?php
				$id = $_GET['id'];
			?>
			<input type="hidden" name="id" value="<?php echo $id; ?>">
			<p>Deseja excluir o regitro número <?php echo $id; ?>?</p>
			
			<button type="submit">Sim</button>
			<a href="listar_locacoes.php"><button type="button">Não</button></a>
		</form>
	</body>
</html>