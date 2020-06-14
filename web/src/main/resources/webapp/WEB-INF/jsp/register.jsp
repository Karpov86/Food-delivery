<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <style>
        .form-save {
            margin-left: 10%;
            padding: 10px;
        }

        .button1 {
            width: 80px;
            background-color: white;
            color: black;
            border: 2px solid #e7e7e7;
        }

        .button1:hover {
            background-color: #e7e7e7;
        }
    </style>
</head>
<body>
<c:import url="header.jsp"></c:import>
<form class="form-save" action="${pageContext.request.contextPath}register" method="post">
    <p><label>
        <input autofocus name="name" type="text" placeholder="Enter name" size="20"/>
    </label></p>
    <p><label>
        <input autofocus name="surname" type="text" placeholder="Enter surname" size="20"/>
    </label></p>
    <p><label>
        <input autofocus name="city" type="text" placeholder="Enter city" size="20"/>
    </label></p>
    <p><label>
        <input autofocus name="street" type="text" placeholder="Enter street" size="20"/>
    </label></p>
    <p><label>
        <input autofocus name="email" type="email" pattern="^[A-Za-z]\w*@\w+\.(com|org|ru|by)$"
                  placeholder="Enter @email" size="20"/>
    </label></p>
    <p><label>
        <input autofocus name="phone number" type="tel" list="phone" placeholder="+375 xx xxx-xx-xx" size="20"/>
    </label></p>
    <p><label>
        <input autofocus name="password" type="password" placeholder="Enter password" size="20"/>
    </label></p>
    <datalist id="phone">
        <option value="+375 44 "></option>
        <option value="+375 33 "></option>
        <option value="+375 29 "></option>
        <option value="+375 25 "></option>
    </datalist>
    <p>
        <button class="button1" type="submit" value="register">Submit</button>
        <button class="button1" style="margin-left: 10px" type="reset">Reset</button>
    </p>
</form>
<c:import url="footer.jsp"></c:import>
</body>
</html>
