<pre>
<?php
	$json = $_POST['json'];
	$obj = json_decode($json, true);
	print_r($obj);
	
	//echo $obj['ferramentas'][0]['nome'];
?>
</pre>