<?php
	include('validar.php');
	include('conexao.php');

	$id = $_POST['id'];
	
	$sql = "DELETE FROM cliente_dependente WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_cliente_dependentes.php?ok=1&msg=' . $id);
	} else {
		header('Location: listar_cliente_dependentes.php?erro=1&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>