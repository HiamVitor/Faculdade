<?php
	include('validar.php');
	include('conexao.php');

	$nome     = $_POST['nome'];
	$endereco = $_POST['endereco'];
	$telefone = $_POST['telefone'];
	$celular  = $_POST['celular'];
	$cpf      = $_POST['cpf'];
	$foto	  = $_FILES['foto']['name'];
	$foto_tmp = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/cliente/{$foto}")) {
			$arquivo = $foto;
		} else {
			header('Location: cadastrar_clientes.php?erro=3&msg=Erro ao enviar arquivo');
		}
	}
	
	if($arquivo) {
		$sql = "INSERT INTO cliente VALUES (null, '{$nome}', '{$endereco}', '{$telefone}', '{$celular}', '{$cpf}', '{$arquivo}')";
	} else {
		$sql = "INSERT INTO cliente (nome, endereco, telefone, celular, cpf) VALUES ('{$nome}', '{$endereco}', '{$telefone}', '{$celular}', '{$cpf}')";
	}	
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_clientes.php?ok=2&msg=' . mysqli_insert_id($conexao));
	} else {
		header('Location: cadastrar_clientes.php?erro=2&msg=' . mysqli_error($conexao));
	}

	mysqli_close($conexao);
?>