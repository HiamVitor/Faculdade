<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Exercício 10</title>
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
			$n1 = 1;
			$n2 = 4;
			$txt1 = "Olá";
			$txt2 = "mundo";
			$txt3 = 24;
			$txt4 = "horas";
		?>
		<table>
		  <tbody>
			<tr>
			  <td><?php echo "$n1"; ?></td>
			  <td><?php echo "$n2"; ?></td>
			  <td><?php echo "$n1" . "$n2"; ?></td>
			</tr>
			<tr>
			  <td><?php echo "$txt1"; ?></td>
			  <td><?php echo "$txt2"; ?></td>
			  <td><?php echo "$txt1" . " " . "$txt2"; ?></td>
			</tr>
			<tr>
			  <td><?php echo "$txt3"; ?></td>
			  <td><?php echo "$txt4"; ?></td>
			  <td><?php echo "$txt3" . " " . "$txt4"; ?></td>
			</tr>
		  </tbody>
		</table>
		
		<table>
		  <tbody>
			<tr>
			  <td><?php echo $n1; ?></td>
			  <td><?php echo $n2; ?></td>
			  <td><?php echo "{$n1}{$n2}"; ?></td>
			</tr>
			<tr>
			  <td><?php echo $txt1; ?></td>
			  <td><?php echo $txt2; ?></td>
			  <td><?php echo "{$txt1} {$txt2}"; ?></td>
			</tr>
			<tr>
			  <td><?php echo $txt3; ?></td>
			  <td><?php echo $txt4; ?></td>
			  <td><?php echo "{$txt3} {$txt4}"; ?></td>
			</tr>
		  </tbody>
		</table>
		
		<table>
		  <tbody>
			<tr>
			  <td><?php echo $n1; ?></td>
			  <td><?php echo $n2; ?></td>
			  <td><?php echo $n1.$n2; ?></td>
			</tr>
			<tr>
			  <td><?php echo $txt1; ?></td>
			  <td><?php echo $txt2; ?></td>
			  <td><?php echo $txt1 . ' ' . $txt2; ?></td>
			</tr>
			<tr>
			  <td><?php echo $txt3; ?></td>
			  <td><?php echo $txt4; ?></td>
			  <td><?php echo $txt3 . ' ' . $txt4; ?></td>
			</tr>
		  </tbody>
		</table>
	</body>
</html>