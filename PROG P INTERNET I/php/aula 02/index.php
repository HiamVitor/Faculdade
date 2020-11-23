<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Aula PHP</title>
  </head>
  <body>
	<?php
		//echo PHP_VERSION;
		
		$txt1 = 'Cristiano';
		$txt2 = 'Salomão';
		
		$resultado = $txt1 . ' ' . $txt2;
		$resultado = "$txt1 $txt2";
		$resultado = "{$txt1} {$txt2}";
		//echo $resultado;
		
		//echo "String";
		//echo 'String';
		
		//echo '$txt1';
		//echo "$txt1 Salomão";
		
		$valor = 1000;
		//echo "$valor00"; // a-z ou A-Z ou 0-9 não posso colocar depois do valor da variável
		
		//echo $valor . '00';
		//echo "{$valor}01";
		
		//echo "PHP_VERSION"; //Contante não é possivel concatenar desta forma
		//echo "{PHP_VERSION}"; //Contante não é possivel concatenar desta forma
		
		//echo "R$ $valor";
		//echo "R\$teste $valor";
		//echo "Olá \"Cristiano\", tudo bem?";
		//echo 'R$teste $valor';
		
		//echo '"Teste"';
		//echo "'Teste'";
		
		//echo "\"; //Não funciona desta forma
		//echo "\\";

		//echo 4 + 3;
		//echo 11 - 6;
		//echo 49 / 7;
		//echo 9 * 3;
		//echo 35 % 3;
		
		//echo '3' + 4;
		//echo "5" + 4;
		//echo '7b' + 3;
		//echo 'a11' + 5;
		
		//echo '2.5' + 5;
		//echo 2.5 + 5;
		
		//Toda informação na web é tratada como string
		
		//echo 4 + 3 * 5; //Errado
		//echo (4 + 3) * 5; //Correto
		//echo 5 * 4 + 3; //Errado
		//echo 5 * (4 + 3); //Correto
		
		//$vl1 = 10;
		
		//$vl1 = $vl1 + 3;
		//$vl1 += 3;
		
		//$vl1 -= 3;
		//$vl1 *= 3;
		//$vl1 /= 3;
		//$vl1 %= 3;
		//$vl1 .= 3;
		
		//echo $vl1;
		
		
		//$vl = 10;
		
		//$vl = $vl + 1;
		//$vl += 1;
		
		//echo $vl++;
		//echo $vl;
		
		//echo ++$vl;
		
		//echo $vl--;
		//echo $vl;
		
		//echo --$vl;
		
		//$vl1 = 3;
		//
		//function teste($vl1, $vl2) {
		//	echo $vl1 + $vl2;
		//}
		//
		//function teste2($vl1, $vl2) {
		//	return $vl1 + $vl2;
		//}
		//
		//function teste3($vl1, $vl2 = 4) { //Parâmetro com valor default
		//	return $vl1 + $vl2;
		//}
		//
		//function teste4($vl1, $vl2) {
		//	return $vl1 + $vl2;
		//}
		//
		//function teste5($vl1, $vl2 = 4, $vl3) { //Forma errada
		//	return $vl1 + $vl2;
		//}
		//
		//function teste5($vl1, $vl3, $vl2 = 4) { //Fomra correta
		//	return $vl1 + $vl2;
		//}
			
		//teste($vl1, 3);
		//$retorno = teste2($vl1, 3);
		//echo $retorno;
		//echo teste2($vl1, 3);
		//echo teste3($vl1);
		//echo teste4($vl1); //Obrigatório informar os dois parâmetros -> Desta forma está errado
		
		
	?>
  </body>
 </html>
 
 
 
 
 
 
 
 
 
 
 
 
 