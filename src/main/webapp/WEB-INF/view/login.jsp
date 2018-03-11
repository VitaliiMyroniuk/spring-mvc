<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Login page</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="site-block">
    <div class="content-block" style="display: flex">
        <div class="login-container">
            <form name="user" action="/login" method="POST">
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
                        <td colspan="2">Login</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="my-input" type="text" name="login"></td>
                    </tr>
                    <tr>
                        <td colspan="2">Password</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input class="my-input" type="password" name="password"></td>
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
            </form>
        </div>
    </div>
</div>
</body>
</html>
