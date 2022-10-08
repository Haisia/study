<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="./register" name="registerForm" method="post">
        <label>아이디 : <input type="text" name="id"></label><br>
        <label>비밀번호 : <input type="text" name="pwd"></label><br>
        <label>이름 : <input type="text" name="name"></label><br>
        <button>회원가입</button>
    </form>
</body>
</html>