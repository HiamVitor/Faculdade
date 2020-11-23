<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Aula PHP</title>
  </head>
  <body>
	<?php
		// Comentário em linha
		/*
			teste
			teste
			teste
		*/
		echo "Teste<br>";
		echo 'Teste<br>';
		echo 1;
		echo 1.7;
		echo true;
		
		echo "<ul><li>Item 1</li></ul>";
		"<h1>teste</h1>";
		
		$nome = 'Cristiano';
		
		echo $nome;
		
		$altura = 1.95;
		$ano = 2020;
		$trabalhando = true;
		
		$nome = 30;
		
		echo $nome;
		
		define('email', 'contato@esucri.com.br');
		echo email;
		
		// $email_admin
		// $emailAdmin
	?>
	<h1>teste</h1>
	<ul>
		<li>Item 1</li>
		<li><?php echo 'Item 2'; ?></li>
	</ul>
  </body>
 </html>