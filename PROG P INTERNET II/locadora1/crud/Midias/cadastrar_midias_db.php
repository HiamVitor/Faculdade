<?php
	include('validar.php');
	include('conexao.php');

	$id_distribuidor = $_POST['id_distribuidor'];
	$titulo          = $_POST['titulo'];
	$duracao         = $_POST['duracao'];
	$valor_compra    = $_POST['valor_compra'];
	$valor_locacao   = $_POST['valor_locacao'];
	$tipo_midia      = $_POST['tipo_midia'];
	$classificacao   = $_POST['classificacao'];
	$quantidade      = $_POST['quantidade'];
	$sinopse         = $_POST['sinopse'];
	$foto	  = $_FILES['foto']['name'];
	$foto_tmp = $_FILES['foto']['tmp_name'];
	
	if($foto) {
		if(move_uploaded_file($foto_tmp, "img/midia/{$foto}")) {
			$arquivo = $foto;
		} else {
			header('Location: cadastrar_midias.php?erro=3&msg=Erro ao enviar arquivo');
		}
	}
	
	if($arquivo) {
		$sql = "INSERT INTO distribuidor VALUES (null, '{$id_distribuidor}', '{$titulo}', '{$duracao}', '{$valor_compra}', '{$valor_locacao}', '{$tipo_midia}', '{$classificacao}', '{$quantidade}', '{$sinopse}', '{$arquivo}')";
	} else {
		$sql = "INSERT INTO cliente_dependente (id_distribuidor, titulo, duracao, valor_compra, valor_locacao, tipo_midia, classificacao, quantidade, sinopse) VALUES ('{$id_distribuidor}', '{$titulo}', '{$duracao}', '{$valor_compra}', '{$valor_locacao}', '{$tipo_midia}', '{$classificacao}', '{$quantidade}', '{$sinopse}')";
	}
	
	$query = mysqli_query($conexao, $sql);
	if($query) {
		header('Location: listar_midias.php?ok=2&msg=' . mysqli_insert_id($conexao));
	} else {
		header('Location: cadastrar_midias.php?erro=2&msg=' . mysqli_error($conexao));
	}
			
	mysqli_close($conexao);
?>