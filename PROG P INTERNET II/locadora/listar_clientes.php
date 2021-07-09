<?php
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Listar Clientes</title>
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
				echo "<p class=\"sucesso\">Cliente excluído com sucesso! Cliente código: {$msg}</p>";
			} else if ($ok == 2) {
				echo "<p class=\"sucesso\">Cliente cadastrado com sucesso! Cliente código: {$msg}</p>";
			} else if ($ok == 3) {
				echo "<p class=\"sucesso\">Cliente alterado com sucesso! Cliente código: {$msg}</p>";
			}
			if ($erro == 1) {
				echo "<p class=\"erro\">Cliente não excluído! MySQL erro: {$msg}</p>";
			}
		?>
		<br><br><a href="cadastrar_clientes.php">Cadastrar</a><br><br>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<?php
					$sql = "SELECT id, nome, cpf FROM clientes";
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
					<td><?php echo $item['nome']; ?></td>
					<td><?php echo $item['cpf']; ?></td>
					<td>
						<a href="alterar_clientes.php?id=<?php echo $item['id']; ?>">Alterar</a>
						<a href="excluir_clientes.php?id=<?php echo $item['id']; ?>">Excluir</a>
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