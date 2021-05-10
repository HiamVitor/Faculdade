<?php
	include('validar.php');
	include('conexao.php');
	
	$id                = $_POST['id'];
	$id_cliente        = $_POST['id_cliente'];
	$data_validade_ini = $_POST['data_validade_ini'];
	$data_validade_fim = $_POST['data_validade_fim'];
	$locacao_gratis    = $_POST['locacao_gratis'] ? "'{$_POST['locacao_gratis']}'" : 'NULL';
	$desconto          = $_POST['desconto'] ? "'{$_POST['desconto']}'" : 'NULL';
	
	$sql = "UPDATE cliente_bonus SET id_cliente = '{$id_cliente}', data_validade_ini = '{$data_validade_ini}', data_validade_fim = '{$data_validade_fim}', locacao_gratis = {$locacao_gratis}, desconto = {$desconto} WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_cliente_bonus.php?ok=3&msg=' . $id);
	} else {
		header('Location: alterar_cliente_bonus.php?id=' . $id . '&erro=3&msg=' . mysqli_error($conexao));
	}
	
	mysqli_close($conexao);
?>