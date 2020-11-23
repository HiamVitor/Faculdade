<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 9</title>
	</head>
	<body>
		<?php
			$txt = "Brasil, oficialmente República Federativa do Brasil, é o maior país da América do Sul e o quinto maior do mundo em área territorial e população, com mais de 192 milhões de habitantes.";
		  
			//$txt = $txt . "....";
		  
			$txt .= "É o único país falante da língua portuguesa na América e o maior país lusófono do mundo, além de ser uma das nações mais multiculturais e etnicamente diversas do planeta, resultado da forte imigração vinda de muitos países.";
			
			echo '<p>' . $txt . '</p>';
			echo "<p>$txt</p>";
			echo "<p>{$txt}</p>";
		?>
		<p><?php echo $txt; ?></p>
	</body>
</html>