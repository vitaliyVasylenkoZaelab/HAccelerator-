<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Products with scale</title>
<body>
<h1>Products with scale</h1>
<a href="/myprojectstorefront/en">Go to home page</a>
<ul>

    <c:forEach var="product" items="${products}">
        <li>${product.name} | <a href="./bands/${product.url}">${product.code}</a></li>
    </c:forEach>
</ul>z
</body>
</html>