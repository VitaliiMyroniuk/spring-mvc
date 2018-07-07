<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Home page</title>
</head>
<body>
    ${message} <br>
    Hello, ${user.login}! <br>
    Your password: ${user.password} <br>
    <h4>
        <a href="/download_pdf">Download pdf document</a>
    </h4>

    <form:form modelAttribute="file" enctype="multipart/form-data" action="/upload_file" method="POST">
        <table>
            <tr>
                <td>Choose File:</td>
                <td><input type="file" name="file"/></td>
                <td style="color: red"><form:errors path="file"/></td>
            </tr>
            <tr>
                <td>Upload File:</td>
                <td><input type="submit" name="Upload"/></td>
                <td></td>
            </tr>
        </table>
    </form:form>

</body>
</html>
