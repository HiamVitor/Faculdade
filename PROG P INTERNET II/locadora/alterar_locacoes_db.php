<?php
	include('validar.php');
	include('conexao.php');

	$id            = $_POST['id'];
	$id_cliente    = $_POST['id_cliente'];
	$id_midia      = $_POST['id_midia'];
	$data_coleta   = $_POST['data_coleta'];
	if($data_coleta) {
		$data_coleta .= " {$_POST['hora_coleta']}";
	}
	$data_prevista = $_POST['data_prevista'];
	$data_entrega  = $_POST['data_entrega'];
	if($data_entrega) {
		$data_entrega .= " {$_POST['hora_entrega']}";
	}
	
	$sql = "UPDATE locacao SET id_cliente = '{$id_cliente}', id_midia = '{$id_midia}', data_coleta = '{$data_coleta}', data_prevista = '{$data_prevista}', data_entrega = '{$data_entrega}' WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_locacoes.php?ok=3&msg=' . $id);
	} else {
		header('Location: alterar_locacoes.php?id=' . $id . '&erro=3&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>