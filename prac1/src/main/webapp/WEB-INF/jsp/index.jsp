<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String name = (String) session.getAttribute("name");
    System.out.println(name);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h2><% if(name!=null){ %>
        <%=name%>
        님 안녕하세요<br>
    <% }else{ %>
        s<br>
        <%}%>
    </h2>
    <h2>홈 페이지</h2>
    <a href="./user/register">회원가입</a><br>
    <a href="./user/login">로그인</a><br>
</body>
</html>