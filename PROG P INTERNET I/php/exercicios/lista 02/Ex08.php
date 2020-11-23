<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>Exercício 08</title>
	</head>
	<body>
		<?php
			$cont = 0;
			while ($cont < 30) {
				$cont++;
				echo "Estamos no número > {$cont} <br>";
			}
			
			$cont = 0;
			do {
				$cont++;
				echo "Estamos no número > {$cont} <br>";
			} while ($cont < 30);
						
			for ($cont = 0; $cont < 30; $cont++) {
				echo "Estamos no número > {$cont} <br>";
			}
		?>
	</body>
</html>