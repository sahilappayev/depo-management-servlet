<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Categories</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>


<a href="<%=request.getContextPath()%>"> Back to home</a>
<br/>
<form method="post">
    <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Category name" aria-label="Enter category name"
               aria-describedby="button-addon2" name="categoryName">
        <div style="margin-right: 5px ; width: 300px">
            <input type="submit" name="create" value="Create Category" class="btn btn-primary">
        </div>
    </div>
</form>

<c:forEach items="${categories}" var="catagory">
    <ol>
        <li>
            <c:out value="Category id: ${catagory.id}  Category name: ${catagory.name}"/> <br/>
        </li>
    </ol>
</c:forEach>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
