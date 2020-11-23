<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<title>Exercício 04</title>
	</head>
	<body>
		<?php $nota = 8.0; ?>
		<p><?php echo 'Anderson'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 6.0; ?>
		<p><?php echo 'Roberto'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 9.0; ?>
		<p><?php echo 'Augusto'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 7.0; ?>
		<p><?php echo 'Luiz'. ' ' . $nota;?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 8.0; ?>
		<p><?php echo 'Andreia'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 6.9; ?>
		<p><?php echo 'Flavia'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 7.0; ?>
		<p><?php echo 'Marcia'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 3.8; ?>
		<p><?php echo 'Antonio'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		<?php $nota = 6.3; ?>
		<p><?php echo 'Rodrigo'. ' ' . $nota; ?>
		<strong><?php echo $nota >= 7 ? "Aprovado" : "Reprovado"; ?></strong></p>
		
		
		<p>
			<strong>
				<?php 
					$nota = 6.3;
					echo "Rodrigo {$nota} " . ($nota >= 7 ? "Aprovado" : "Reprovado");
				?>
			</strong>
		</p>
	</body>
</html>