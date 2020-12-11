<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <title>Exercício 14</title>
</head>

<body>
    <?php
    $n1 = 3;
    function calcula($n1)
    {
        switch ($n1) {
            case ($n1 > 0):
                $result = 'Valor Positivo';
                break;
            case ($n1 < 0):
                $result = 'Valor Negativo';
                break;
            case ($n1 == 0):
                $result = 'igual a zero';
                break;
            }
        return $result;
    }
    ?>
    <p><?php echo calcula($n1); ?></p>
</body>

</html>