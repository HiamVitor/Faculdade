<?php
	include('validar.php');
	include('conexao.php');

	$id_cliente        = $_POST['id_cliente'];
	$data_validade_ini = $_POST['data_validade_ini'];
	$data_validade_fim = $_POST['data_validade_fim'];
	$locacao_gratis    = $_POST['locacao_gratis'] ? "'{$_POST['locacao_gratis']}'" : 'NULL';
	$desconto          = $_POST['desconto'] ? "'{$_POST['desconto']}'" : 'NULL';
	
	$sql = "INSERT INTO cliente_bonus VALUES (null, '{$id_cliente}', '{$data_validade_ini}', '{$data_validade_fim}', {$locacao_gratis}, {$desconto})";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_cliente_bonus.php?ok=2&msg=' . mysqli_insert_id($conexao));
	} else {
		header('Location: cadastrar_cliente_bonus.php?erro=2&msg=' . mysqli_error($conexao));
	}

	mysqli_close($conexao);
?>