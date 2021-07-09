<?php
	include('validar.php');
	include('conexao.php');

	$id         = $_POST['id'];
	$id_cliente = $_POST['id_cliente'];
	$nome       = $_POST['nome'];
	$cpf        = $_POST['cpf'];
	$foto	    = $_FILES['foto']['name'];
	$foto_tmp   = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/dependente/{$foto}")) {
			$arquivo = ", foto = '{$foto}'";
		} else {
			header('Location: alterar_cliente_dependentes.php?id=' . $id . '&erro=4&msg=Erro ao enviar arquivo');
		}
	}
	
	$sql = "UPDATE cliente_dependente SET id_cliente = '{$id_cliente}', nome = '{$nome}', cpf = '{$cpf}' {$arquivo} WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_cliente_dependentes.php?ok=3&msg=' . $id);
	} else {
		header('Location: alterar_cliente_dependentes.php?id=' . $id . '&erro=3&msg=' . mysqli_error($conexao));
	}

	mysqli_close($conexao);
?>