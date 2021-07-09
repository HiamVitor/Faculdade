<?php
	include('validar.php');
	include('conexao.php');

	$razao_social = $_POST['razao_social'];
	$endereco     = $_POST['endereco'];
	$telefone     = $_POST['telefone'];
	$nome_contato = $_POST['nome_contato'];
	$cnpj         = $_POST['cnpj'];
	$foto	  = $_FILES['foto']['name'];
	$foto_tmp = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/distribuidor/{$foto}")) {
			$arquivo = $foto;
		} else {
			header('Location: cadastrar_distribuidores.php?erro=3&msg=Erro ao enviar arquivo');
		}
	}
	
	if($arquivo) {
		$sql = "INSERT INTO distribuidor VALUES (null, '{$razao_social}', '{$endereco}', '{$telefone}', '{$nome_contato}', '{$cnpj}', '{$arquivo}')";
	} else {
		$sql = "INSERT INTO cliente_dependente (razao_social, endereco, telefone, nome_contato, cnpj) VALUES ('{$razao_social}', '{$endereco}', '{$telefone}', '{$nome_contato}', '{$cnpj}')";
	}
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_distribuidores.php?ok=2&msg=' . mysqli_insert_id($conexao));
	} else {
		header('Location: cadastrar_distribuidores.php?erro=2&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>