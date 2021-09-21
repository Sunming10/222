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
        <el-form-item prop="username">
          <!-- <i class="iconfont">&#xe633;</i> -->
          <el-input v-model="loginForm.username" placeholder="账  号" ></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input placeholder="密  码" v-model="loginForm.password" show-password type="password"></el-input>
        </el-form-item>
        <!-- 按钮区域 -->
        <el-form-item class="btns">
          <el-button type="warning" @click="login" round size="medium" ><router-link to='selling' class='line'>登录</router-link></el-button>
          <!-- <el-button type="primary" @click="login">登录</el-button> -->
          <!-- <el-button type="info" @click="resetLoginForm">重置</el-button> -->
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
        username: 'admin',
        password: '1234567'
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
      // console.log(this);
      this.$refs.loginFormRef.resetFields()
    },
    //提交登陆
    //  submitLogin() {
    //             this.$refs.loginForm.validate((valid) => {
    //                 if (valid) {
    //                     this.loading = true;
    //                     this.postRequest('/doLogin', this.loginForm).then(resp => {
    //                         this.loading = false;

    //                             this.$store.commit('INIT_CURRENTHR', resp.obj);
    //                             window.sessionStorage.setItem("user", JSON.stringify(resp.obj));
    //                             let path = this.$route.query.redirect;
    //                             this.$router.replace((path == '/' || path == undefined) ? '/selling' : path);

    //                     })
    //                 } else {
    //                     return false;
    //                 }
    //             });
    //         }
    // login(){
    //   this.$refs.loginForm.validate(valid =>{
    //     if(!valid) return
    //     this.$router.push({
    //       path:'/home'
    //     })
    //   })

    // }
    // login() {
    //   this.$refs.loginFormRef.validate(async valid => {
    //     if (!valid) return
    //     const { data: res } = await this.$http.post('login', this.loginForm)
    //     if (res.meta.status !== 200) return this.$message.error('登录失败！')
    //     this.$message.success('登录成功')
    //     // 1. 将登录成功之后的 token，保存到客户端的 sessionStorage 中
    //     //   1.1 项目中出了登录之外的其他API接口，必须在登录之后才能访问
    //     //   1.2 token 只应在当前网站打开期间生效，所以将 token 保存在 sessionStorage 中
    //     window.sessionStorage.setItem('token', res.data.token)
    //     // 2. 通过编程式导航跳转到后台主页，路由地址是 /home
    //     this.$router.push('/welcome')
    //   })
    // }

    // login(){
    //   this.$http.post('login',{username:this.username,password:this.password},{emulateJSON:true}).then(function(res){
    //     console.log(res.data);
    //     window.location.router.push('selling')

    //   },
    //   function(res){
    //     console.log(res.status)
    //   });
    // }
//    login:function () {

// this.$http.post('login',{username:this.username,password:this.password},{emulateJSON:true}).then(function(res){

// console.log(res.data);

// window.location.router.push('selling')

// },
// function(res){

// console.log(res.status)
// });
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
