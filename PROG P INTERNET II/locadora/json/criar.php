<?php
	//$item['nome'] = 'Cristiano';
	//$item['idade'] = '38';
	//$item['cidade'] = 'Criciúma';
	//$item['uf'] = 'SC';
	
	//$item = array('nome' => 'Cristiano', 'idade' => '38', 'cidade' => 'Criciúma', 'uf' => 'SC');
	
	//$item['materia'] = 'Programação para Internet';
	//$item['professor'] = 'Cristiano';
	//$item['ferramentas'][]['nome'] = 'Xampp';
	//$item['ferramentas'][]['nome'] = 'Notepad++';
	//$item['ferramentas'][]['nome'] = 'MySQL Workbench';
	
	//$item[] = array('nome' => 'Cristiano', 'idade' => '38', 'cidade' => 'Criciúma', 'uf' => 'SC');
	//$item[] = array('nome' => 'Andreia', 'idade' => '18', 'cidade' => 'Içara', 'uf' => 'SC');
	//$item[] = array('nome' => 'Arildo', 'idade' => '40', 'cidade' => 'Tubarão', 'uf' => 'SC');
	
	$conexao = mysqli_connect('localhost', 'root', '', 'locadora');
	mysqli_set_charset($conexao, 'utf8');
	
	//$sql = "SELECT * FROM clientes LIMIT 1";
	//$query = mysqli_query($conexao, $sql);
	//$item = mysqli_fetch_array($query, MYSQLI_ASSOC);
	
	$sql = "SELECT * FROM clientes LIMIT 3";
	$query = mysqli_query($conexao, $sql);
	while($dado = mysqli_fetch_array($query, MYSQLI_ASSOC)) {
		$item[] = $dado;
	}
	
	mysqli_close($conexao);
	
	echo json_encode($item);
?>








