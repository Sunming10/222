<template>

    <div class="login_container">
    <div class="login-img">
      <span>
      <i class="iconfont">&#xe600;</i>
      <router-link to='./shopping' class="font-line">进入购买页面</router-link>
      </span>
    </div>
    <div class="login_box">
      <!-- 头像区域 -->
      <div class="avatar_box">
        <img src="https://iconfont.alicdn.com/t/2fe81ecd-b859-464c-aeca-3fa28c9c9aff.png" alt="">
      </div>
      <!-- 登录表单区域 -->
      <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="0px" class="login_form">
        <!-- 用户名 -->
        <el-form-item prop="username" >
          <el-input v-model="loginForm.username" placeholder="账  号" id='msg_login' auto-complete="off" ></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input placeholder="密  码" v-model="loginForm.password" show-password type="password" auto-complete="off"></el-input>
        </el-form-item>
        <!-- 按钮区域 -->
        <el-form-item class="btns">
          <el-button type="warning" @click="login" round size="medium" >登录</el-button>
           <el-button type="warning" @click="resetLoginForm" round size="medium">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 这是登录表单的数据绑定对象
      loginForm: {
        username: '',
        password: ''
      },

      // 这是表单的验证规则对象
      loginFormRules: {
        // 验证用户名是否合法
        username: [
          { required: true, message: '请输入登录账号', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        // 验证密码是否合法
        password: [
          { required: true, message: '请输入登录密码', trigger: 'blur' },
          { min: 7, max: 15, message: '长度在 7 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 点击重置按钮，重置登录表单
    resetLoginForm() {
      this.$refs.loginFormRef.resetFields()
    },
    // 登陆逻辑判断
       login(){
       this.$refs.loginFormRef.validate(async valid => {
        this.$http.post('/user/login', this.loginForm).then(response=>{

            if(this.loginForm.username!=''&&this.loginForm.password!=''){

              if(response.data.message=="success"){

                window.sessionStorage.setItem('token', response.data.token)
                var authorization=response.headers['authorization'];
                window.sessionStorage.setItem('authorization',authorization);
                this.$message({
                  message: '尊敬的用户欢迎你！',
                  type: 'success'
                });
                this.$router.push('home');
              }else if(response.data.message=="error"){

                this.$message.error('用户名或密码错误，请重新登录！');
              }
            }else{
               this.$message.error('用户名和密码不能为空，请重新登录！');
            }
})
      })
    }
 }
}
</script>


<style lang="less" scoped>
@import url("../assets/css/font.css");

.login_container {
  background: no-repeat;
  background-color: #F7F0DF;
  background-image: url("https://iconfont.alicdn.com/t/0544814c-76fb-46b7-bac5-b5fcd9dacf90.png") ;
  height: 100%;
    .login-img span{
      float: right;
      margin: 20px 50px 0 0px;
      font-size: 20px;
      font-family: '微軟正黑體 Bold', '微軟正黑體 Regular', '微軟正黑體';
      font-weight: 700;
      font-style: normal;
      color: #8D7D6B;
      .font-line{
        text-decoration: none;
        color: #8D7D6B;
      }

    }

}
.line{
        text-decoration: none;
        color: #ffff;
      }
.login_box {
  width: 500px;
  height: 350px;
  background-color: #ffffff;
  border-radius: 3px;
  box-shadow:0 0 10px #ddd;
  position: absolute;
  left: 70%;
  top: 50%;
  transform: translate(-50%, -50%);
  border-radius:5%;

  .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }
}

.login_form {
  position: absolute;
  bottom: 0;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}

.btns {
  display: flex;
  justify-content: flex-end;
}
</style>
