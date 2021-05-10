<?php
	include("conexao.php");
	
	$sql = "SELECT * FROM cliente";
	$query = mysqli_query($conexao, $sql);
	
	$i = 0;
	while($item = mysqli_fetch_array($query, MYSQLI_ASSOC)){
		$json[$i] = $item;
		
		$sql1 = "SELECT id, nome, cpf, foto FROM cliente_dependente WHERE id_cliente = {$item['id']}";
		$query1 = mysqli_query($conexao, $sql1);
		if(mysqli_num_rows($query1) > 0) {
			while($item1 = mysqli_fetch_array($query1, MYSQLI_ASSOC)) {
				$json[$i]['dependente'][] = $item1;
			}
		}
		$i++;
	}
	
	echo json_encode($json);
	
	mysqli_close($conexao);
?>