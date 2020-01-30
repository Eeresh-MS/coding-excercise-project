
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Inventory Details From JSON File</title>
</head>
<body>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h4>List of Inventory Details From JSON File</h4></caption>
            <tr>
                <th>Name</th>
                <th>Serial Number</th>
                <th>Value</th>
            </tr>
                <tr>
                    <td><c:out value="${name}" /></td>
                    <td><c:out value="${serialNumber}" /></td>
                    <td><c:out value="${value}" /></td>
                </tr>
        </table>
    </div>
</body>
</html>




