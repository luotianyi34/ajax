<%--
  Created by IntelliJ IDEA.
  User: pang6
  Date: 2023/3/15/015
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
</head>
<body>

</body>
<script>
    $(function () {
        $.ajax({
            url:"userinfo",
            method:"get",
            dataType:"json",
            success(res){
                console.log(res)
            }
        });
    })
</script>
</html>
