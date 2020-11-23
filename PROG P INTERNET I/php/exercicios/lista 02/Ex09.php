<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>Exercício 09</title>
		<style type="text/css">
			table{
				border-collapse: collapse;
			}
			td {
				border: 1px solid;
			}
		</style>
	</head>
	<body>
		<?php
			$i = 1;
		?>
		<table>
			<tbody>
				<?php 
					while ($i <= 10) { 
						if (($i % 2) == 0) {
				?>
						<tr>
							<td style="background-color: #BEE5C2;"><?php echo $i; ?></td>
						</tr>
				<?php 
							$i++; 
						} else {
				?>
						<tr>
							<td style="background-color: white;"><?php echo $i; ?></td>
						</tr>
				<?php 
							$i++; 
						}
				?>
				<?php
					}
				?>
			</tbody>
		</table>
		
		<?php
			$i = 1;
		?>
		<table>
			<tbody>
				<?php 
					while ($i <= 10) { 
				?>
					<tr>
						<td style="background-color: <?php if (($i % 2) == 0) { ?>#BEE5C2<?php } else { ?>#FFFFFF<?php } ?>;"><?php echo $i; ?></td>
					</tr>
				<?php
						$i++;
					}
				?>
			</tbody>
		</table>
		
		<?php
			$i = 1;
		?>
		<table>
			<tbody>
				<?php 
					while ($i <= 10) {
						$cor = '#FFFFFF';
						if (($i % 2) == 0) { 
							$cor = '#BEE5C2';
						}
				?>
					<tr>
						<td style="background-color: <?php echo $cor; ?>;"><?php echo $i; ?></td>
					</tr>
				<?php
						$i++;
					}
				?>
			</tbody>
		</table>
	</body>
</html>