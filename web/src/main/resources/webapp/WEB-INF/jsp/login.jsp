<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty param.language}">
    <c:set var="language" value="${param.language}" scope="session"/>
</c:if>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }
    </style>
</head>
<body class="text-center">

<c:import url="header.jsp"/>

<a href="http://localhost:8080/login?language=en">eng</a>
<a href="http://localhost:8080/login?language=ru">rus</a>

<form class="form-signin" action="${pageContext.request.contextPath}login" method="post">
    <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="login.please.sign.in"/></h1>

    <label for="name" class="sr-only">Name</label>
    <input type="text" id="name" name="name" class="form-control"
           placeholder="<fmt:message key="login.placeholder.name"/>" required="" autofocus="">

    <label for="password" class="sr-only">Surname</label>
    <input style="margin-top: 20px" type="password" id="password" name="password" class="form-control"
           placeholder="<fmt:message key="login.placeholder.password"/>" required="">

    <button style="margin-top: 60px" class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message
            key="sign.in"/></button>
</form>

<c:import url="footer.jsp"/>

</body>
</html>