<?php
	include('validar.php');
	include('conexao.php');

	$id              = $_POST['id'];
	$id_distribuidor = $_POST['id_distribuidor'];
	$titulo          = $_POST['titulo'];
	$duracao         = $_POST['duracao'];
	$valor_compra    = $_POST['valor_compra'];
	$valor_locacao   = $_POST['valor_locacao'];
	$tipo_midia      = $_POST['tipo_midia'];
	$classificacao   = $_POST['classificacao'];
	$quantidade      = $_POST['quantidade'];
	$sinopse         = $_POST['sinopse'];
	$foto	         = $_FILES['foto']['name'];
	$foto_tmp        = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/midia/{$foto}")) {
			$arquivo = ", foto = '{$foto}'";
		} else {
			header('Location: alterar_midias.php?id=' . $id . '&erro=4&msg=Erro ao enviar arquivo');
		}
	}
	
	$sql = "UPDATE midia SET id_distribuidor = '{$id_distribuidor}', titulo = '{$titulo}', duracao = '{$duracao}', valor_compra = '{$valor_compra}', valor_locacao = '{$valor_locacao}', tipo_midia = '{$tipo_midia}', classificacao = '{$classificacao}', quantidade = '{$quantidade}', sinopse = '{$sinopse}' {$arquivo} WHERE id = {$id}";
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_midias.php?ok=3&msg=' . $id);
	} else {
		header('Location: alterar_midias.php?id=' . $id . '&erro=3&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>