<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <title>Exercício 14</title>
</head>

<body>
    <?php
    $a = 0;
    $b = 0;
    $c = 0;
    $d = 0;

    function calcula($a, $b, $c, $d)
    {
        $soma = $b * $d;
        $multi = $a + $c;

        if ($soma > $multi) {
            $result =  "A + C é menor que B * D";
        } elseif ($soma < $multi) {
            $result =  "A + C é maior que B * D";
        } else {
            $result =  "A + C é igual a B * D";
        }
        return $result;
    }
    ?>
    <p><?php echo calcula($n1); ?></p>
</body>

</html>