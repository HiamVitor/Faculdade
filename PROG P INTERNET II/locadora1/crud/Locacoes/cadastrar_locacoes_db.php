<?php
	include('validar.php');
	include('conexao.php');

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
	
	$sql = "INSERT INTO locacao VALUES (null, '{$id_cliente}', '{$id_midia}', '{$data_coleta}', '{$data_prevista}', '{$data_entrega}')";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_locacoes.php?ok=2&msg=' . mysqli_insert_id($conexao));
	} else {
		header('Location: cadastrar_locacoes.php?erro=2&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>