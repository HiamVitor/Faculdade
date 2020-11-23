<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>Exercício 03</title>
	</head>
	<body>
		<?php
			$valor = 5;
			$valor += 10;
		?>
		<p><strong>5 + 10 = <?php echo $valor; ?></strong></p>

		<?php $valor = 10; ?>
		<?php $valor /= 2; ?>
		<p><strong>10 / 2 = <?php echo $valor; ?></strong></p>

		<?php $valor = 8; ?>
		<?php $valor *=3; ?>
		<p><strong>8 * 3 = <?php echo $valor; ?></strong></p>

		<?php $valor = 12; ?>
		<?php $valor -= 9; ?>
		<p><strong>12 - 9 = <?php echo $valor; ?></strong></p>

		<?php $valor = 11; ?>
		<?php $valor += 10; ?>
		<p><strong>11 + 10 = <?php echo $valor; ?></strong></p>

		<?php $valor = 50; ?>
		<?php $valor /= 8; ?>
		<p><strong>50 / 8 = <?php echo $valor; ?></strong></p>

		<?php $valor = 14; ?>
		<?php $valor *= 15; ?>
		<p><strong>14 * 15 = <?php echo $valor; ?></strong></p>

		<?php $valor = 17; ?>
		<?php $valor -= 50; ?>
		<p><strong>17 - 50 = <?php echo $valor; ?></strong></p>
		
		<?php
			$vl1 = '5';
			$vl2 = '10';
			echo $vl1.' + '.$vl2.' = ';
			$vl1 += $vl2;
			echo $vl1;
		?>
	</body>
</html>