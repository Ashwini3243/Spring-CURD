<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkmagenta" > Students list</h1>
<table border="2" cellspacing="0" cellpadding="8" style="border-color: darkblue" >
    <tr >
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>country</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${studentData}" var="std">
        <tr>
                <%-- <td><a href="display/${std.id}">${std.id}</a></td>--%>
            <td>${std.id}</td>
            <td>${std.name}</td>
            <td>${std.age}</td>
            <td>${std.country}</td>
            <td><a href="update1/${std.id}">update</a></td>
            <td><a href="delete/${std.id}">delete</a></td>
        </tr>
    </c:forEach>

</table><br><br>
<a href="index.jsp"><input type="button" value="home" style="color: springgreen" ></a>
<a href="student"><input type="button" value="register" style="color: red" > </a><br>
<a href="update1/${std.id}"><input type="button" value="update" style="color: blue"> </a>