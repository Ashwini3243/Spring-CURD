<%--
  Created by IntelliJ IDEA.
  User: Interview
  Date: 3/4/2020
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: blue">update registered data by id</h1>
<c:url value="/updatedata" var="formUrl1"/>
<form:form modelAttribute="update" action="${formUrl1}" method="post">

    Id: <form:input path="id" readonly="true"/><br><br>
    Name: <form:input path="name"/><br><br>

    Age: <form:input path="age"/><br><br>
    Country: <form:select path="country"><br>
    <form:options items="${countriesList}"/>
</form:select><br><br>
    <input type="submit" value="update">
</form:form>
<a href="../index.jsp"><input type="button" value="home" style="color: darkviolet"></a>
<a href="../disp"><input type="button" value=" back " style="color: blue" ></a>

