<?php
	//print_r($_FILES);
	
	//echo $_FILES['arquivo']['name'].'<br>';
	//echo $_FILES['arquivo']['tmp_name'];
	
	$nome = $_FILES['arquivo']['name'];
	$caminho = $_FILES['arquivo']['tmp_name'];
	$tmp = explode('.', $nome);
	//$novo_nome = $tmp[0] . date('YmdHis') . '.' . $tmp[1];
	
	//$data = date('YmdHis');
	//$novo_nome = "{$tmp[0]}{$data}.{$tmp[1]}";
	
	//move_uploaded_file($caminho, $nome); //Mesma pasta do arquivo PHP
	//move_uploaded_file($caminho, "img/{$nome}"); //Pasta img 
	//move_uploaded_file($caminho, "../{$nome}"); //Voltar para pasta locadora
	move_uploaded_file($caminho, "../explode/{$nome}"); //Voltar para pasta locadora e enviar para pasta explode
	
	//Sempre informar o local de armazenamento, o nome do arquivo e extensão para gravar o arquivo
?>