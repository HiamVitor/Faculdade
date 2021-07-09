<?php
	include('validar.php');
	include('conexao.php');

	$id       = $_POST['id'];
	$nome     = $_POST['nome'];
	$endereco = $_POST['endereco'];
	$telefone = $_POST['telefone'];
	$celular  = $_POST['celular'];
	$cpf      = $_POST['cpf'];
	$foto	  = $_FILES['foto']['name'];
	$foto_tmp = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/cliente/{$foto}")) {
			$arquivo = ", foto = '{$foto}'";
		} else {
			header('Location: alterar_clientes.php?id=' . $id . '&erro=4&msg=Erro ao enviar arquivo');
		}
	}
	
	$sql = "UPDATE clientes SET nome = '{$nome}', endereco = '{$endereco}', telefone = '{$telefone}', celular = '{$celular}', cpf = '{$cpf}' {$arquivo} WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_clientes.php?ok=3&msg=' . $id);
	} else {
		header('Location: alterar_clientes.php?id=' . $id . '&erro=3&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>