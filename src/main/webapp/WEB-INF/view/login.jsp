<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Login page</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/check_password_strength.js"></script>
</head>
<body>
<div class="site-block">
    <div class="header">
        <jsp:include page="/WEB-INF/view/header.jsp"/>
    </div>

    <div class="content-block" style="display: flex">
        <div class="login-container">
            <form:form modelAttribute="user" action="/login" method="POST">
                <table>
                    <tr>
                        <td colspan="2" align="center">
                            <h2><spring:message code="authentication"/></h2>
                        </td>
                    </tr>
                    <tr>
                        <td><br></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:label path="login"><spring:message code="login"/></form:label>
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
                            <form:label path="password"><spring:message code="password"/></form:label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form:password cssClass="my-input" path="password" onkeyup="checkPasswordStrength()"/>
                            <form:errors cssStyle="color: red" path="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <span id="strength-value" style="float: right">
                                <br>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="my-button" type="submit" value="<spring:message code="sign.in"/>">
                        </td>
                        <td style="text-align: right">
                            <a href="/registration"><spring:message code="sign.up"/></a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
