<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 7</title>
		<style type="text/css">
			table {
				border-collapse: collapse;
			}
			td, th {
				border: 1px solid;
			}
		</style>
	</head>
	<body>
		<?php 
		  define('NOME', 'Cristiano');
		  define('IDADE', '29');
		  define('ALTURA', '1,95m');
		  define('PESO', '99kg');		
		?>
		<table>
		  <tbody>
			<tr>
			  <td>Nome</td>
			  <td><?php echo NOME; ?></td>
			</tr>
			<tr>
			  <td>Idade</td>
			  <td><?php echo IDADE; ?></td>
			</tr>
			<tr>
			  <td>Altura</td>
			  <td><?php echo ALTURA; ?></td>
			</tr>
			<tr>
			  <td>Peso</td>
			  <td><?php echo PESO; ?></td>
			</tr>
		  </tbody>
		</table>
	</body>
</html>