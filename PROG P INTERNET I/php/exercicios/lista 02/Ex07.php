<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>Exercício 07</title>
	</head>
	<body>
		<?php
			function retornaFruta($fruta) {
				switch ($fruta) {
					case 1:
						echo "Pêra.";
						break;
					case 2:
						echo "Maçã.";
						break;
					case 3:
						echo "Uva.";
						break;
					case 4:
						echo "Laranja.";
						break;
					default:
						echo "Não sei.";
				}
			}

			retornaFruta(5);
		?>
	</body>
</html>