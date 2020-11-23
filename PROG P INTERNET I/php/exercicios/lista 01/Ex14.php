<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 14</title>
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
			$n1 = 3;
			$n2 = 4;
			$n3 = 5;
			$n4 = 11;
			$n5 = 9;
			$n6 = 20;
			
			function calculaSoma($n1, $n2) {
				return $n1 + $n2;
			}
	
			function calculaMult($n3, $n2) {
				return $n3 * $n2;
			}
	
			function calculaSubtracao($n4, $n5) {
				return $n4 - $n5;
			}
	
			function calculaDiv($n6, $n2) {
				echo $n6 / $n2;
			}
		?>
		<table>
		  <thead>
			<tr>
			  <th>Cálculos</th>
			  <th>Resultados</th>
			</tr>
		  </thead>
		  <tbody>
			<tr>
			  <td><?php echo "$n1 + $n2"; ?></td>
			  <td><?php echo calculaSoma($n1, $n2); ?></td>
			</tr>
			<tr>
			  <td><?php echo "$n3 * $n2"; ?></td>
			  <td><?php echo calculaMult($n3, $n2); ?></td>
			</tr>
			<tr>
			  <td><?php echo "$n4 - $n5"; ?></td>
			  <td><?php echo calculaSubtracao($n4, $n5); ?></td>
			</tr>
			<tr>
			  <td><?php echo "$n6 / $n2"; ?></td>
			  <td><?php calculaDiv($n6, $n2); ?></td>
			</tr>
		  </tbody>
		</table>
	</body>
</html>