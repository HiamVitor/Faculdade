<?php
	include('validar.php');
	include('conexao.php');

	$id = $_POST['id'];
	
	$sql = "DELETE FROM cliente_bonus WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_cliente_bonus.php?ok=1&msg=' . $id);
	} else {
		header('Location: listar_cliente_bonus.php?erro=1&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>