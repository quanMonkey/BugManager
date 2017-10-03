<%--
  Created by IntelliJ IDEA.
  User: liuquan
  Date: 2017/6/26
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .top{
            margin-top:100px;
        }
    </style>
</head>
<body>


<div class="top">


</div>
<div class="middle">
    <form class="form-horizontal">
        <div class="form-group">
            <label for="account_in" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="account_in" placeholder="">
            </div>
        </div>
        <div class="form-group">
            <label for="pwd_in" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-2">
                <input type="password" class="form-control" id="pwd_in" placeholder="">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
                <button type="submit" class="btn btn-default">Sign in</button>
                <button class="btn btn-default">Register</button>
            </div>
        </div>
    </form>
</div>
<div class="bottom">


</div>
</body>
</html>
