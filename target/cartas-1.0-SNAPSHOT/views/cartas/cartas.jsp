<%--
  Created by IntelliJ IDEA.
  User: posei
  Date: 17/08/2021
  Time: 05:30 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cartas</title>
</head>
<body>
<div class="container">
    <label for="">Nombre de la carta:</label>
    <input type="text" id="name">
    <br>
    <label for="">Tipo:</label>
    <select  id="selectTipo">
        <option value="0" selected> Tipo de Carta</option>
        <option value="1">Carta de Monstruo</option>
        <option value="2">Carta Magica</option>
        <option value="3">Carta de Trampa</option>
    </select>
    <br>
    <input type="hidden" id="index">
    <button id="register" onclick="create();">Registrar</button>
    <button id="update" onclick="update();">Actualizar</button>
</div>
    <div>
        <table id="container">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Tipo</th>
            <th>Fecha de Registro</th>
            <th>Estado</th>
            <th>Acciones</th>
        </tr>
        </thead>
            <tbody></tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="${context}/assets/dist/js/main.js"></script>
</body>
</html>
