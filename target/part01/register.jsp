<%--
  Created by IntelliJ IDEA.
  User: liuquan
  Date: 2017/7/11
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/part01/RegisterController/registerAccount.spring">
    <div><label for="">账号</label><input type="text" id="account" name="account"></div>
    <div><label for="">密码</label><input type="text" id="pwd" name="pwd"></div>
    <div><label for="">昵称</label><input type="text" id="userInfoByUserId.nickName" name="userInfoByUserId.nickName"></div>
    <div><label for="">用户姓名</label><input type="text" id="userInfoByUserId.userName" name="userInfoByUserId.userName"></div>
    <div>
        <Button type="submit">确认</Button>
        <Button type="reset">重置</Button>
    </div>
</form>
</body>
</html>