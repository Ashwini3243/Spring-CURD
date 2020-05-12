<%--
  Created by IntelliJ IDEA.
  User: Interview
  Date: 3/3/2020
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: blue">Registration Form</h1>
<c:url value="/saveData" var="formUrl"/>
<form:form modelAttribute="reg" action="${formUrl}" method="post">
    <table>
    <tr>
        <td>Id  : </td>
        <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>Name  :</td>
           <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Age  :</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>Country :</td>
            <td><form:select path="country">
                <form:options items="${countriesList}"/>
            </form:select></td>
        </tr>
        <tr>

            <td><input type="submit" value="Register" style="color: darkblue"></td>

        </tr>

    </table>
    <a href="index.jsp"><input type="button" value="home" align="centre" style="color: red"></a>
    <a href="disp"><input type="button" value=" back " style="color: blue" ></a> <br>
</form:form>
