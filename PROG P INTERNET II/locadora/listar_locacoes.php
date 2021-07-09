<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Listar Cliente Locações</title>
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
				echo "<p class=\"sucesso\">Locação excluída com sucesso! Locação código: {$msg}</p>";
			} else if ($ok == 2) {
				echo "<p class=\"sucesso\">Locação cadastrada com sucesso! Locação código: {$msg}</p>";
			} else if ($ok == 3) {
				echo "<p class=\"sucesso\">Locação alterada com sucesso! Locação código: {$msg}</p>";
			}
			if ($erro == 1) {
				echo "<p class=\"erro\">Locação não excluída! MySQL erro: {$msg}</p>";
			}
		?>
		<br><br><a href="cadastrar_locacoes.php">Cadastrar</a><br><br>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Código Cliente</th>
					<th>Nome Cliente</th>
					<th>Código Mídia</th>
					<th>Nome Mídia</th>
					<th>Data da Coleta</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<?php
					$sql = "SELECT l.id, l.id_cliente, l.id_midia, l.data_coleta, c.nome, m.titulo
							FROM locacao AS l 
							INNER JOIN clientes AS c ON (l.id_cliente = c.id) 
							INNER JOIN midia AS m ON (l.id_midia = m.id)";
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
					<td><?php echo $item['id_cliente']; ?></td>
					<td><?php echo $item['nome']; ?></td>
					<td><?php echo $item['id_midia']; ?></td>
					<td><?php echo $item['titulo']; ?></td>
					<td><?php echo $item['data_coleta']; ?></td>
					<td>
						<a href="alterar_locacoes.php?id=<?php echo $item['id']; ?>">Alterar</a>						
						<a href="excluir_locacoes.php?id=<?php echo $item['id']; ?>">Excluir</a>						
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