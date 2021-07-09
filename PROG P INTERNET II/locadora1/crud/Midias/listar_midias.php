<?php
	include('validar.php');
	include('conexao.php');
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>LOCADORA: Listar Mídias</title>
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
				echo "<p class=\"sucesso\">Mídia excluída com sucesso! Mídia código: {$msg}</p>";
			} else if ($ok == 2) {
				echo "<p class=\"sucesso\">Mídia cadastrada com sucesso! Mídia código: {$msg}</p>";
			} else if ($ok == 3) {
				echo "<p class=\"sucesso\">Mídia alterada com sucesso! Mídia código: {$msg}</p>";
			}
			if ($erro == 1) {
				echo "<p class=\"erro\">Mídia não excluída! MySQL erro: {$msg}</p>";
			}
		?>
		<br><br><a href="cadastrar_midias.php">Cadastrar</a><br><br>
		<table>
			<thead>
				<tr>
					<th>Código</th>
					<th>Título</th>
					<th>Tipo de mídia</th>
					<th>Classificação</th>
					<th>Código Distribuidor</th>
					<th>Nome Distribuidor</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<?php
					$sql = "SELECT m.id, m.titulo, m.tipo_midia, m.classificacao, m.id_distribuidor, d.razao_social 
							FROM midia AS m 
							INNER JOIN distribuidor AS d ON (m.id_distribuidor = d.id)";
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
					<td><?php echo $item['titulo']; ?></td>
					<td><?php echo $item['tipo_midia']; ?></td>
					<td><?php echo $item['classificacao']; ?></td>
					<td><?php echo $item['id_distribuidor']; ?></td>
					<td><?php echo $item['razao_social']; ?></td>
					<td>
						<a href="alterar_midias.php?id=<?php echo $item['id']; ?>">Alterar</a>						
						<a href="excluir_midias.php?id=<?php echo $item['id']; ?>">Excluir</a>						
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