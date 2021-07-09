<select>
<?php
	$cursos = 'SI|ADM|MKT|EF|ENF';
	$lista = explode('|', $cursos);
//	print_r($lista);
	foreach($lista as $valor) {
?>
	<option value="<?php echo $valor; ?>"><?php echo $valor; ?></option>
<?php
	}
?>
</select><br><br>

<?php
	$data = '2021-05-03 18:50:00';
	$d = explode(' ', $data);
?>
<input type="date" value="<?php echo $d[0]; ?>">
<input type="time" value="<?php echo $d[1]; ?>"><br><br>

<?php
	$dia = explode('-', $d[0]); //2021-05-03
	$hora = explode(':', $d[1]); //18:50:00
	$hoje = mktime($hora[0], $hora[1], $hora[2], $dia[1], $dia[2], $dia[0]);
	echo date('d/m/Y H:i:s', $hoje);
?>





