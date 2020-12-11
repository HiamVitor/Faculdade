<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>3</title>
	</head>
	<body>    
		<?php
            $generos = array('a'=> 'Ação', 'b'=> 'Aventura', 'c'=> 'Terror', 'd'=> 'Drama', 'e'=> 'Romance');
            foreach($generos as $indice => $valor){
                echo '<input type="checkbox" id=\"$indice\" name=\"$valor\">';
                echo "<label for=\"$indice\">$valor</label> <br>";
            }
		?>
	</body>
</html>