<?php
	include('validar.php');
	include('conexao.php');

	$id_cliente = $_POST['id_cliente'];
	$nome       = $_POST['nome'];
	$cpf        = $_POST['cpf'];
	$foto	  = $_FILES['foto']['name'];
	$foto_tmp = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/dependente/{$foto}")) {
			$arquivo = $foto;
		} else {
			header('Location: cadastrar_cliente_dependentes.php?erro=3&msg=Erro ao enviar arquivo');
		}
	}
	
	if($arquivo) {
		$sql = "INSERT INTO cliente_dependente VALUES (null, '{$id_cliente}', '{$nome}', '{$cpf}', '{$arquivo}')";
	} else {
		$sql = "INSERT INTO cliente_dependente (id_cliente, nome, cpf) VALUES ('{$id_cliente}', '{$nome}', '{$cpf}')";
	}
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_cliente_dependentes.php?ok=2&msg=' . mysqli_insert_id($conexao));
	} else {
		header('Location: cadastrar_cliente_dependentes.php?erro=2&msg=' . mysqli_error($conexao));
	}

	mysqli_close($conexao);
?>