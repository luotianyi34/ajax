<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style>
    *{
      margin: 0;
      padding: 0;
    }
    body{
      height: 100vh;
      width: 100vw;
      overflow: hidden;
    }
    .main{
      height: 100%;
      width: 100%;
      background:url("./images/zl2.jpg") no-repeat center/cover;
      /*内部元素居中*/
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .login-group{
      height: 40%;
      width: 30%;
      background-color: rgba(255,255,255,0.3);
      border-radius: 10px;
    }
    h3{
      height: 50px;
      /*background-color: dodgerblue;*/
      line-height: 50px;
      text-align: center;
      color: antiquewhite;
    }
    .input-group{
      height: 48px;
      /*background-color: aliceblue;*/
      margin: 5px;
      display: flex;
      align-items: center;
    }
    .input-label{
      height: 100%;
      width: 20%;
      display: flex;
      align-items: center;
      justify-content: right;
      color: white;
    }
    .input-content{
      height: 100%;
      width: 80%;
      display: flex;
      align-items: center;
      padding:0 20px;
    }
    input{
      width: 100%;
      height: 100%;
      border:none;
      outline: none;
      background-color: rgba(0,0,0,0);
      border-bottom: 1px solid whitesmoke;
      color: whitesmoke;
    }
    .input-code{
      width: 60%;
      height: 100%;
    }
    .input-images{
      width: 40%;
      height: 100%;
    }
    .input-images img{
      display: block;
      width: 100%;
      height: 100%;
    }
    button{
      height: 40px;
      width: 80px;
      display: flex;
      align-items: center;
      justify-content:center;
    }
  </style>
  <div class="main">
    <div class="login-group">
      <h3>后台登陆</h3>
      <form id="loginForm">
        <div class="input-group">
          <div class="input-label">
            <label for="username">用户名</label>
          </div>
          <div class="input-content">
            <input type="text" id="username" name="username" placeholder="用户名" required>
          </div>
        </div>
        <div class="input-group">
          <div class="input-label">
            <label for="password">密码</label>
          </div>
          <div class="input-content">
            <input type="password" id="password" name="password" placeholder="密码" required>
          </div>
        </div>
        <div class="input-group">
          <div class="input-label">
            <label for="code">验证码</label>
          </div>
          <div class="input-content">
            <div class="input-code">
              <input type="text" id="code" name="code" placeholder="验证码" required>
            </div>
            <div class="input-images">
              <img src="https://dummyimage.com/200x100/FF6600" alt="wmwm">
            </div>
          </div>
        </div>
        <div class="input-group">
          <div class="input-label"> </div>
          <div class="input-content">
            <button type="button" id="loginBtn" >
              登录
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
  </body>
  <script>
    $(function (){
      $("#loginBtn").click(function (){
        let username = $("#username").val();
        if (!username){
          alert("请输入用户名")
          return;
        }
        let password = $("#password").val();
        if (!password){
          alert("请输入密码")
          return;
        }

        $.ajax({
          url:"login2",
          data:{
            username,
            password
          },
          method:"post",
          dataType:"json",
          success:function (res){
            console.log(res)
          },
          error(e){console.log(e);}
        })
      })
    })
  </script>
</html>