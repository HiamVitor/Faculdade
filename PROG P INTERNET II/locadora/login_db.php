<?php
	session_start();
	include('conexao.php');
	
	$login = $_POST['login'];
	$senha = md5($_POST['senha']);
	//$senha = $_POST['senha'];
	
	$sql = "SELECT * FROM usuario WHERE login = '{$login}' AND senha = '{$senha}'";
	//$sql = "SELECT * FROM usuario WHERE login = '{$login}' AND senha = MD5('{$senha}')";
	$query = mysqli_query($conexao, $sql);
	$usuario = mysqli_num_rows($query);
	
	if ($usuario == 1) {
		$item = mysqli_fetch_array($query, MYSQLI_ASSOC);
		if ($item['status'] == 'A') {
			$_SESSION['usuario'] = $item;
			header('Location: painel.php');
		} else {
			header('Location: index.php?erro=2');
		}
	} else {
		header('Location: index.php?erro=1');
	}
	
	mysqli_close($conexao);
?>