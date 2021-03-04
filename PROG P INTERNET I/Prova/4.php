<!DOCTYPE html>
<html>
    <head>
        <title>4</title>
        <style type="text/css">
		table {
			border-collapse: collapse;
		}
	    th, td {
		    border: 3px solid black;
	    }
    </style>
    </head>
    <body>
        <?php
            $eb = array (
                    array("Gustavo","Capitão",18000),
                    array("Matheus","Tenente",8000),
                    array("Marcos","Sargento",4000),
                    array("Mendes","Cabo",3000),
                    array("Victor","Solado",1000));
         ?>
         <table style="width:20%">
            <tr>
                <th>Nome</th>
                <th>Patente</th>
                <th>Salário</th>
            </tr>
            <?php
                for ($row = 0; $row < 5; $row++) {
                echo "<tr>";
                    for ($col = 0; $col < 4; $col++) {
                        echo "<td>".$eb[$row][$col]."</td>";
                    }
                echo "</tr>";
                }
            ?>
        </table>
    </body>
</html>