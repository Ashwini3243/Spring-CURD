<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" cellspacing="0">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
        <tr>
            <td>${studentinform.id}</td>
            <td>${studentinform.name}</td>
            <td>${studentinform.age}</td>
        </tr>

</table>
<a href="../index.jsp"><input type="button" value="home" align="centre" style="color: brown"></a>