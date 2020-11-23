<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <title>Exercício 14</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
        }

        td,
        th {
            border: 1px solid;
        }
    </style>
</head>

<body>
    <?php
    $salario = 0;
    function calcula($salario)
    {
        if ($salario <= 2000) {
            $salario * 1.5;
        } else {
            $salario * 1.3;
        }
        return $salario;
    }

    ?>
    <table>
        <thead>
            <tr>
                <th>Salário</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><?php echo calcula($salario); ?></td>
            </tr>
        </tbody>
    </table>
</body>

</html>