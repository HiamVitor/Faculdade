
</html><!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>6B</title>
	</head>
	<body>
        <?php
            $titulo = $_POST['Titulo'];
            $tipo = $_POST['Tipo'];
            $midia = $_POST['Midia'];
            $sinopse = $_POST['Sinopse'];
        ?>	
         <table>
            <tbody>
                <tr>
                    <td class="label">
                        <label for="Titulo">Titulo:</label>
                    </td>
                    <td>
                        <?php echo $titulo ?>
                    </td>
                    <br />
                </tr>
                <tr>
                    <td class="label">
                        <label for="Tipo">Tipo:</label>
                    </td>
                    <td>
                        <?php echo $tipo ?>
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="Midia">Midia:</label>
                    </td>
                    <td>
                        <?php echo $midia ?>
                    </td>
                </tr>
                <tr>
                    <td class="label">
                        <label for="Sinopse">Sinopse:</label>
                    </td>
                    <td>
                        <?php echo $sinopse ?>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <br />
                        <a href="6A.php">Voltar</a>
                    </td>
                </tr>
            </tbody>
        </table>		
	</body>
</html>