<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 13</title>
	</head>
	<body>
		<?php
			$nome = 'Willian';
			$sobrenome = 'Leonardo Arcenio';
	
			function retornaNomeCompleto($nome, $sobrenome){
				$nomeCompleto = $nome . " " . $sobrenome;
				//$nomeCompleto = $nome . ' ' . $sobrenome;
				//$nomeCompleto = "$nome $sobrenome";
				//$nomeCompleto = "{$nome} {$sobrenome}";
				return $nomeCompleto;
				
				//return "{$nome} {$sobrenome}";
			}
		?>

		<h1><?php echo retornaNomeCompleto($nome, $sobrenome); ?></h1>
	</body>
</html>