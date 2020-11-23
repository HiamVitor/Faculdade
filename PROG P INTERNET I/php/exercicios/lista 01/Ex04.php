<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 4</title>
	</head>
	<body>
		<?php
			$string = 'Olá alunos';
			$inteiro = 2020;
			$decimal =  33.75;
			$boleano = true;
		?>
		<ul>
			<li><?php echo $string; ?></li>
			<li><?php echo $inteiro; ?></li>
			<li><?php echo $decimal; ?></li>
			<li><?php echo $boleano; ?></li>
		</ul>
		<?php
			echo "<ul>
				<li>{$string}</li>
				<li>{$inteiro}</li>
				<li>{$decimal}</li>
				<li>{$boleano}</li>
			</ul>";
		?>
		<?php
			echo "<ul>";
			echo "<li>{$string}</li>";
			echo "<li>{$inteiro}</li>";
			echo "<li>{$decimal}</li>";
			echo "<li>{$boleano}</li>";
			echo "</ul>";
		?>
		<?php
			echo '<ul>' .
				'<li>' . $string  . '</li>' .
				'<li>' . $inteiro . '</li>' .
				'<li>' . $decimal . '</li>' .
				'<li>' . $boleano . '</li>' .
			'</ul>';
		?>
		<?php
			echo '<ul>';
			echo '<li>' . $string  . '</li>';
			echo '<li>' . $inteiro . '</li>';
			echo '<li>' . $decimal . '</li>';
			echo '<li>' . $boleano . '</li>';
			echo '</ul>';
		?>
	</body>
</html>