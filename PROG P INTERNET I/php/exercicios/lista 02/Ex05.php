<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>Exercício 05</title>
		<?php
			$v = 3;
			if($v == 1) {
				$cor = 'green';
			} elseif($v == 2) {
				$cor = 'blue';
			} elseif($v == 3) {
				$cor = 'yellow';
			} elseif($v == 4) {
				$cor = 'red';
			} else {
				$cor = 'black';
			}			
		?>
		<style type="text/css">
			p {
				color: <?php echo $cor ?>;
			}
			.verde {
				color: green;
			}
			.azul {
				color: blue;
			}
			.amarelo {
				color: yellow;
			}
			.vermelho {
				color: red;
			}
		</style>
	</head>
	<body>
		<p>Faculdades ESUCRI</p>
		<?php
			$v = 2;
			if($v == 1) {
				$classCor = 'verde';
			} elseif($v == 2) {
				$classCor = 'azul';
			} elseif($v == 3) {
				$classCor = 'amarelo';
			} elseif($v == 4) {
				$classCor = 'vermelho';
			} else {
				$classCor = '';
			}			
		?>
		<div class="<?php echo $classCor; ?>">Faculdades ESUCRI</div>
	</body>
</html>