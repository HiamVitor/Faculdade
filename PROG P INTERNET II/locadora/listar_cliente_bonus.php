<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Listar Cliente Bônus</title>
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
				echo "<p class=\"sucesso\">Bônus excluído com sucesso! Bônus código: {$msg}</p>";
			} else if ($ok == 2) {
				echo "<p class=\"sucesso\">Bônus cadastrado com sucesso! Bônus código: {$msg}</p>";
			} else if ($ok == 3) {
				echo "<p class=\"sucesso\">Bônus alterado com sucesso! Bônus código: {$msg}</p>";
			}
			if ($erro == 1) {
				echo "<p class=\"erro\">Bônus não excluído! MySQL erro: {$msg}</p>";
			}
		?>
		<br><br><a href="cadastrar_cliente_bonus.php">Cadastrar</a><br><br>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Código Cliente</th>
					<th>Nome Cliente</th>
					<th>Locações Grátis</th>
					<th>Desconto</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<?php
					$sql = "SELECT cb.id, cb.locacao_gratis, cb.desconto, cb.id_cliente, c.nome
							FROM cliente_bonus AS cb 
							INNER JOIN clientes AS c ON (cb.id_cliente = c.id)";
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
					<td><?php echo $item['locacao_gratis']; ?></td>
					<td><?php echo $item['desconto']; ?></td>
					<td>
						<a href="alterar_cliente_bonus.php?id=<?php echo $item['id']; ?>">Alterar</a>						
						<a href="excluir_cliente_bonus.php?id=<?php echo $item['id']; ?>">Excluir</a>						
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