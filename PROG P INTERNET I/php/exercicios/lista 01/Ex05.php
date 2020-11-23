<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 5</title>
	</head>
	<body>
		<?php $variavel = 55; ?>
		<p><?php echo "$variavel <br>"; ?></p>
		<?php $variavel = "Faculdades ESUCRI."; ?>
		<h3><?php echo "$variavel"; ?></h3>
		
		<?php
			$variavel = 55;
			echo "{$variavel} <br>";
			$variavel = "Faculdades ESUCRI.";
			echo "{$variavel} <br>";
		?>
		
		<?php
			$variavel = 55;
			echo $variavel. '<br>';
			$variavel = "Faculdades ESUCRI.";
			echo $variavel. '<br>';
		?>
	</body>
</html>