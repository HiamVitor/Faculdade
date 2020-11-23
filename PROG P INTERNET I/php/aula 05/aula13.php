<?php
	//$i = 10;
	//while ($i < 10) {
	//	echo "Estamos no valor {$i} <br>";
	//	$i += 2;
	//}
	
	//$i = 20;
	//do {
	//	echo "Estamos no valor {$i} <br>";
	//	$i += 2;
	//} while ($i < 10);
	
	//for ($i = 0; $i < 10; $i += 2) {
	//	echo "Estamos no valor {$i} <br>";
	//}
	
	
	//for ($i = 1; $i <= 100; $i++) {
	//	echo "Estamos no valor {$i} <br>";
	//	if(($i % 10) == 0) {
	//		break;
	//	}
	//}
	
	//break pode ser utilizado dentro do switch, while, do..while e for
	
	//for ($i = 1; $i <= 20; $i++) {
	//	if(($i % 2) == 0) {
	//		continue;
	//	}
	//	echo "Estamos no valor {$i} <br>"; 
	//}
	
	function valorPar($vl) {
		for ($i = $vl; $i <= 20; $i++) {
			if(($i % 2) != 0) {
				continue;
			}
			echo "Estamos no valor {$i} <br>"; 
		}
	}
	valorPar(8);


?>







