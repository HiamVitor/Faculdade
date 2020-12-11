<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>6</title>
        <style>
            div {
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
            }
            .label {
                text-align: right;
            }
        </style>
    </head>
    <body>
        <div>
            <form action="6B.php" method="post">
                <table>
                    <tbody>
                        <tr>
                            <td class="label">
                                <label for="Titulo">Titulo:</label>
                            </td>
                            <td>
                                <input type="text" name="Titulo" id="Titulo" maxlength="100" value="" />
                            </td>
                            <br />
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <fieldset>
                                    <legend>Tipo:</legend>

                                    <input type="radio" name="Tipo" id="Acao" value="Acao" checked="checked" />
                                    <label for="Acao">Ação</label>

                                    <input type="radio" name="Tipo" id="Aventura" value="Aventura" />
                                    <label for="Aventura">Aventura</label>

                                    <input type="radio" name="Tipo" id="Comedia" value="Comedia" />
                                    <label for="Comedia">Comédia</label>
                                </fieldset>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">
                                <label for="Midia">Midia:</label>
                            </td>
                            <td>
                                <select name="Midia">
                                    <option value="1">VHS</option>
                                    <option value="1">DVD</option>
                                    <option value="2">Blu-ray</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">
                                <label for="Sinopse">Sinopse:</label>
                            </td>
                            <td>
                                <textarea name="Sinopse" rows="5" cols="30"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <br />
                                <button type="submit">Enviar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
