<?php
	include("conexao.php");
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>JSON</title>
	</head>
	<body>
		<?php
			$json = $_POST['json'];
			if($json) {
				$obj = json_decode($json, true);
				
				if(count($obj) > 0) {
					$sql = "DELETE FROM distribuidor";
					$query = mysqli_query($conexao, $sql);
					
					foreach($obj as $valor) {
						$sql = "INSERT INTO distribuidor VALUES ('{$valor['id']}', '{$valor['razao_social']}', '{$valor['endereco']}', '{$valor['telefone']}',
			  '{$valor['nome_contato']}', '{$valor['cnpj']}', '{$valor['foto']}')";
						$query = mysqli_query($conexao, $sql);
					}
				}
			}
		?>
		<a href="json_distribuidor_form.php">Voltar</a>
	</body>
</html>
<?php
	mysqli_close($conexao);
?>