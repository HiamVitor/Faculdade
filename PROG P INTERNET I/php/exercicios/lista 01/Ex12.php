<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 12</title>
		<style type="text/css">
			table {
				border-collapse: collapse;
			}
			th, td {
				border: 1px solid;
			}
		</style>
	</head>
	<body>
		<?php 
			$base1 = 13;
			$altura1 = 19;
			$base2 = 2;
			$altura2 = 7;
			$base3 = 67;
			$altura3 = 33;
			$base4 = 34;
			$altura4 = 41;
		?>
		<table>
			<tbody>
				<tr>
					<td>Base</td>
					<td>Altura</td>
					<td>Área</td>
				</tr>
				<tr>
					<td><?php echo $base1; ?></td>
					<td><?php echo $altura1; ?></td>
					<td><?php echo ($base1 * $altura1) / 2; ?></td>
				</tr>
				<tr>
					<td><?php echo $base2; ?></td>
					<td><?php echo $altura2; ?></td>
					<td><?php echo ($base2 * $altura2) / 2; ?></td>
				</tr>
				<tr>
					<td><?php echo $base3; ?></td>
					<td><?php echo $altura3; ?></td>
					<td><?php echo ($base3 * $altura3) / 2; ?></td>
				</tr>
				<tr>
					<td><?php echo $base4; ?></td>
					<td><?php echo $altura4; ?></td>
					<td><?php echo ($base4 * $altura4) / 2; ?></td>
				</tr>
			</tbody>	
		</table>
		
		<?php
			$area1 = (13 * 19)  / 2;
			$area2 = (2  * 7)   / 2;
			$area3 = (67 * 33)  / 2;
			$area4 = (34 * 41)  / 2;
			
			echo "{$area1} <br>";
			echo "{$area2} <br>";
			echo "{$area3} <br>";
			echo "{$area4} <br>";
		?>
	</body>
</html>