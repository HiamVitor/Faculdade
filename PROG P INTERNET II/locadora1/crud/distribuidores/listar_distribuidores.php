<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Listar Distribuidores</title>
		<link rel="stylesheet" type="text/css" href="site.css">
	</head>
	<body>
		<?php
			include('menu.php');
		?>
		<?php
			$ok   = @$_GET['ok'];
			$erro = @$_GET['erro'];
			$msg  = @$_GET['msg'];
			if ($ok == 1) {
				echo "<p class=\"sucesso\">Distribuidor excluído com sucesso! Distribuidor código: {$msg}</p>";
			} else if ($ok == 2) {
				echo "<p class=\"sucesso\">Distribuidor cadastrado com sucesso! Distribuidor código: {$msg}</p>";
			} else if ($ok == 3) {
				echo "<p class=\"sucesso\">Distribuidor alterado com sucesso! Distribuidor código: {$msg}</p>";
			}
			if ($erro == 1) {
				echo "<p class=\"erro\">Distribuidor não excluído! MySQL erro: {$msg}</p>";
			}
		?>
		<br><br><a href="cadastrar_distribuidores.php">Cadastrar</a><br><br>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Razão Social</th>
					<th>CNPJ</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<?php
					$sql = "SELECT id, razao_social, cnpj FROM distribuidor";
					$query = mysqli_query($conexao, $sql);
					if(!$query) {
				?>
				<tr>
					<td colspan="3"><?php echo 'MySQL Erro: ' . mysqli_error($conexao); ?></td>
				</tr>
				<?php
					} else {
						while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
				?>
				<tr>
					<td><?php echo $item['id']; ?></td>
					<td><?php echo $item['razao_social']; ?></td>
					<td><?php echo $item['cnpj']; ?></td>
					<td>
						<a href="alterar_distribuidores.php?id=<?php echo $item['id']; ?>">Alterar</a>						
						<a href="excluir_distribuidores.php?id=<?php echo $item['id']; ?>">Excluir</a>						
					</td>
				</tr>
				<?php
						}
					}
				?>
			</tbody>
		</table>
		Exitem <?php echo mysqli_num_rows($query); ?> Itens
	</body>
</html>
<?php
	mysqli_close($conexao);
?>