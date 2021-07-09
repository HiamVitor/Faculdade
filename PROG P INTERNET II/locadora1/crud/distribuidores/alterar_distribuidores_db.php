<?php
	include('validar.php');
	include('conexao.php');
	
	$id           = $_POST['id'];
	$razao_social = $_POST['razao_social'];
	$endereco     = $_POST['endereco'];
	$telefone     = $_POST['telefone'];
	$nome_contato = $_POST['nome_contato'];
	$cnpj         = $_POST['cnpj'];
	$foto	      = $_FILES['foto']['name'];
	$foto_tmp     = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/distribuidor/{$foto}")) {
			$arquivo = ", foto = '{$foto}'";
		} else {
			header('Location: alterar_distribuidores.php?id=' . $id . '&erro=4&msg=Erro ao enviar arquivo');
		}
	}
	
	$sql = "UPDATE distribuidor SET razao_social = '{$razao_social}', endereco = '{$endereco}', telefone = '{$telefone}', nome_contato = '{$nome_contato}', cnpj = '{$cnpj}' {$arquivo} WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_distribuidores.php?ok=3&msg=' . $id);
	} else {
		header('Location: alterar_distribuidores.php?id=' . $id . '&erro=3&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>