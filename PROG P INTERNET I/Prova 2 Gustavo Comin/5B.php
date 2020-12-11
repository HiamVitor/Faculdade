</html><!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>5B</title>
	</head>
	<body>
		<?php
			$area = $_GET['area'];    
            $base = $_GET['base'];
			$calc = ($area * $base)/2;
            echo "(" . $area . " * " . $base . ") " . " / 2" . " = " . $calc;           
		?>			
	</body>
</html>