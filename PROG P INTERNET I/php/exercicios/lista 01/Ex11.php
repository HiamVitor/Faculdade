<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 11</title>
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
			$var1 = 8;
			$var2 = 9;
			$var3 = 23;
			$var4 = 11;
			$var5 = 10;
			$var6 = 30;
			$var7 = 3;
		?>
		<table>
			<tbody>
				<tr>
					<td><?php echo $var1 + $var2; ?></td>
				</tr>
				<tr>
					<td><?php echo $var3 - $var4; ?></td>
				</tr>
				<tr>
					<td><?php echo $var5 * $var5; ?></td>
				</tr>
				<tr>
					<td><?php echo $var6 / $var7; ?></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<tbody>
				<tr>
					<td><?php echo "{$var1} + {$var2} = " . ($var1 + $var2); ?></td>
				</tr>
				<tr>
					<td><?php echo "{$var3} - {$var4} = " . ($var3 - $var4); ?></td>
				</tr>
				<tr>
					<td><?php echo "{$var5} * {$var5} = " . ($var5 * $var5); ?></td>
				</tr>
				<tr>
					<td><?php echo "{$var6} / {$var7} = " . ($var6 / $var7); ?></td>
				</tr>
			</tbody>
		</table>
		
		<?php 
			$soma = 8+9;
			$sub = 23-11;
			$mult = 10*10;
			$div = 30/3;
		?>
		<table>
			<tbody>
				<tr>
					<td>8 + 9 = <?php echo $soma; ?></td>
				</tr>
				<tr>
					<td>23 - 11 = <?php echo $sub; ?></td>
				</tr>
				<tr>
					<td>10 * 10 = <?php echo $mult; ?></td>
				</tr>
				<tr>
					<td>30 / 3 = <?php echo $div; ?></td>
				</tr>
			</tbody>	
		</table>
	</body>
</html>