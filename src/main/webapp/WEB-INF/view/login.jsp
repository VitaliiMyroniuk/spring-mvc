<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login page</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="site-block">
    <div class="content-block" style="display: flex">
        <div class="login-container">
            <form:form commandName="user" action="/login" method="POST">
                <table>
                    <tr>
                        <td colspan="2" align="center">
                            <h2>Authentication</h2>
                        </td>
                    </tr>
                    <tr>
                        <td><br></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:label path="login">Login</form:label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:input cssClass="my-input" path="login"/>
                            <form:errors cssStyle="color: red" path="login"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:label path="password">Password</form:label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:password cssClass="my-input" path="password"/>
                            <form:errors cssStyle="color: red" path="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td><br></td>
                    </tr>
                    <tr>
                        <td>
                            <input class="my-button" type="submit" value="Sign in">
                        </td>
                        <td style="text-align: right">
                            <a href="/registration">Sign up</a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
