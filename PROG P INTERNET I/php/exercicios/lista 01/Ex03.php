<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Exercício 3</title>
</head>
<body>
	<?php 
		$mensagemPHP = "A linguagem surgiu por volta de 1994, como um pacote de programas CGI criados por Rasmus Lerdorf, com o nome Personal Home Page Tools, para substituir um conjunto de scripts Perl que ele usava no desenvolvimento de sua página pessoal.";
	?>
	<p><?php echo "$mensagemPHP"; ?></p>
	<p><?php echo $mensagemPHP; ?></p>
	<?php echo "<p>{$mensagemPHP}</p>"; ?>
</body>
</html>