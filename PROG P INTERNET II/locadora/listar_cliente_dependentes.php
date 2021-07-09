<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Listar Cliente Dependente</title>
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
				echo "<p class=\"sucesso\">Dependente excluído com sucesso! Dependente código: {$msg}</p>";
			} else if ($ok == 2) {
				echo "<p class=\"sucesso\">Dependente cadastrado com sucesso! Dependente código: {$msg}</p>";
			} else if ($ok == 3) {
				echo "<p class=\"sucesso\">Dependente alterado com sucesso! Dependente código: {$msg}</p>";
			}
			if ($erro == 1) {
				echo "<p class=\"erro\">Dependente não excluído! MySQL erro: {$msg}</p>";
			}
		?>
		<br><br><a href="cadastrar_cliente_dependentes.php">Cadastrar</a><br><br>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Código Cliente</th>
					<th>Nome Cliente</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<?php
					$sql = "SELECT cd.id, cd.nome, cd.cpf, cd.id_cliente, c.nome AS nome_cliente
							FROM cliente_dependente AS cd 
							INNER JOIN clientes AS c ON (cd.id_cliente = c.id)";
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
					<td><?php echo $item['id_cliente']; ?></td>
					<td><?php echo $item['nome_cliente']; ?></td>
					<td>
						<a href="alterar_cliente_dependentes.php?id=<?php echo $item['id']; ?>">Alterar</a>						
						<a href="excluir_cliente_dependentes.php?id=<?php echo $item['id']; ?>">Excluir</a>						
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