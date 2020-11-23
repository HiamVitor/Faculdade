<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Exercício 01</title>
		<style type="text/css">
			table{
				border-collapse: collapse;
			}
			th, td{
				border: 1px solid;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<?php 
			$numero = 10;
		?>
		<table>
			<thead>
				<tr>
					<th>Anterior</th>
					<th>Atual</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><?php echo $numero; ?></td>
					<td><?php echo ++$numero; ?></td>
				</tr>
				<tr>
					<td><?php echo $numero; ?></td>
					<td><?php echo ++$numero; ?></td>
				</tr>
				<tr>
					<td><?php echo $numero++; ?></td>
					<td><?php echo $numero; ?></td>
				</tr>
			</tbody>
		</table>
	</body>
</html>