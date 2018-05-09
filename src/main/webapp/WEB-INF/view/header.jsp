<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="locale" var="rb"/>

<table width="100%">
    <tr>
        <td width="90%" align="left">
            <spring:message code="header.site.logo"/>
        </td>
        <td width="5%" align="right">
            <a href="?lang=en_GB">Eng</a>
            <a href="?lang=uk_UA">Укр</a>
        </td>
        <td width="5%" align="right">
            <spring:message code="header.logout"/>
        </td>
    </tr>
</table>