
</html><!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>6B</title>
	</head>
	<body>
        <?php
        
#!/bin/bash

#id do usuario
$USUARIO="gustavocomin";

# pega json que contem todos os repositorios e extrai as URLs
$LISTA_URL_CLONES=`curl --silent https://api.github.com/users/${USUARIO}/repos -q | grep "\"clone_url\"" | awk -F': "' '{print $2}' | sed -e 's/",//g'`

#para cada url faz um 'git clone'
for $URL in $LISTA_URL_CLONES; do
    echo "====>> clonando: " ${URL}
    git clone ${URL}
done
        ?>
	</body>
</html>