<!-- Sing in  Form -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng nhập</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="../signup/fonts/material-icon/css/material-design-iconic-font.min.css">
<style><%@include file="../signup/css/style.css"%></style>
    <!-- Main css -->
    <link rel="stylesheet" href="../signup/css/style.css">
</head>
<body>
<div class="main">
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure><img src="\Project_1/signup/images/signin-image.jpg" alt="sing up image"></figure>
                    <a href="../signup" class="signup-image-link">Tạo tài khoản</a>
                </div>
  
                <div class="signin-form">
                    <h2 class="form-title" style="font-family: sans-serif; font-weight: normal" >Đăng nhập</h2>
                    <form action="\Project_1/LoginServlet" method="POST" class="register-form" id="login-form">
                        <div class="form-group">
                            <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="your_name" placeholder="User Name" />
                        </div>
                        <div class="form-group">
                            <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="your_pass" placeholder="Password" />
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Đăng nhập" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
</body>