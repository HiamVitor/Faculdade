<?php
	$chave = "Admin";
	$encriptado = base64_encode($chave);
	echo "{$encriptado}<br>";
	
	$decriptado = base64_decode($encriptado);
	echo "{$decriptado}<br>";	
?>