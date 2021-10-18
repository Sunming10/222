<template>
        <div class="mystyle">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>卖家修改密码</span>
            </div>
            <div>
              <el-form label-width="100px">
                <el-form-item label="原密码">
                    <el-input type="password" v-model="sellerdata.password"></el-input>
                </el-form-item>
                <el-form-item label="新密码">
                    <el-input type="password" v-model="sellerdata.password1"></el-input>
                </el-form-item>
                <el-form-item label="确认密码">
                    <el-input type="password" v-model="sellerdata.password2"></el-input>
                </el-form-item>
                    <el-form-item>
                    <el-button>取消</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <el-button type="warning" @click="onSubmit">立即修改</el-button>
                </el-form-item>
              </el-form>
            </div>
            <div>{{info}}</div>
            <div>{{returnObject}}</div>

          </el-card>

        </div>
</template>

<script>
// import {updatePassword} from './user/updatePassword'
// export default {
//     data() {
//     var validatePass = (rule, value, callback) => {
//       if (!value) {
//         callback(new Error("请输入新密码"));
//       } else if (value.toString().length <7 || value.toString().length > 15) {
//         callback(new Error("密码长度为7-15位"));
//       } else {
//         callback();
//       }
//     };
//     var validatePass2 = (rule, value, callback) => {
//       if (value === "") {
//         callback(new Error("请再次输入密码"));
//       } else if (value !== this.resetForm.newpassword) {
//         callback(new Error("两次输入密码不一致!"));
//       } else {
//         callback();
//       }
//     };
//     return {
//       resetForm: {
//       //传给后台所需要的参数
//         username: "",
//         oldpassword: "",
//         newpassword: "",//此处只是后台需要的字段而已，如果前期有公用cookie里面有获取并且保存过，现在需要另外调用进来，具体的获取方法就看个人了
//         newpassword1:""
//       },
//       resetFormRules: {
//          oldpassword: [
//             { required: true, message: "请输入旧密码", trigger: 'blur' }
//         ],
//         newpassword: [
//             { required: true, validator: validatePass, trigger: 'blur' }
//         ],
//         newpassword1: [
//           { required: true, validator: validatePass2, trigger: "blur" }
//         ]
//       }
//     };
//   },
//   methods: {
//     // submitinfo() {
//     //   this.$refs.resetForm.validate(valid => {
//     //     if (valid) {
//     //     //这里的api.materialQuery.toAmend是调用前期我们统一的api接口url路径，不作参考 ，只要把后台需要的字段正常传进去即可
//     //       api.materialQuery.toAmend(this.resetForm)
//     //         .then(res => {
//     //           if(res.code === 2){
//     //             this.$message({
//     //                 message: res.msg,
//     //                 type: "error",
//     //                 duration: "2000"
//     //               });
//     //             return false;
//     //           }
//     //           if (res.code === 0) {
//     //             this.$message.success("修改成功,3秒后跳转到登录页！");
//     //             setTimeout(() => {
//     //                this.logout();//调用跳转到登陆页的方法
//     //             }, 3000);
//     //           }
//     //           ic
//     //         })
//     //         .catch(() => {});
//     //     }
//     //   });
//     // },
//     submitinfo(){
//       // var param={
//       //   username:getUserInfo(),
//       //   newpassword:this.resetForm.newpassword,
//       //   oldpassword:this.resetForm.oldpassword
//       // }
//       // this.$refs['resetForm'].validate(valid=>{
//       //   if(valid){

//       //   }
//       // })
//       // console.log('1234');
//       // const username=this.$refs.
//       // this.$http.post('user/getUserInfo').then(response=>{
//       //   this.resetForm.username=response.data.username
//       //   console.log(response);
//       //   console.log(response.data);
//       //   // const username=response.data.username;
//       // });
//       // console.log(this.getUserInfo.username);
//        this.$refs.resetForm.validate(async valid => {
//         this.$http.post('/user/updatePassword',{ 
//             oldpassword:this.resetForm.oldpassword,

//               }).then(response=>{
//               console.log(response.data);
//             if(this.resetForm.oldpassword!=''){
//               if((this.resetForm.oldpassword==response.data.oldpassword)&&(this.resetForm.username==response.data.username)){
//                 console.log(response.data);
//                 // this.$message('尊敬的'+response.data.userName+'用户，恭喜你登录成功！');
//                 // this.$router.push('home');
//                 console.log('成功！');
//               }else{
//                 console.log();
//                      this.$message.error('旧密码错误，请检查密码！');
//               }
//             }else{
//                this.$message.error('密码不能为空请填写密码！');
//             }
// })
//       })
//     },
//     //这是修改成功后重新返回登陆页的方法，看个人需要自行调整
//     // async logout() {
//     //   await this.$store.dispatch("user/logout");
//     //   this.$router.push(`/login`);
//     // }
//   },
// }

// import api from "http://localhost:8082/user";//这是我个人全局定义单独用来接收url接口的文件，不作参考
export default {
  data() {
  //   var validatePass = (rule, value, callback) => {
  //     if (!value) {
  //       callback(new Error("请输入新密码"));
  //     } else if (value.toString().length < 6 || value.toString().length > 18) {
  //       callback(new Error("密码长度为6-18位"));
  //     } else {
  //       callback();
  //     }
  //   };
  //   var validatePass2 = (rule, value, callback) => {
  //     if (value === "") {
  //       callback(new Error("请再次输入密码"));
  //     } else if (value !== this.resetForm.newpwd) {
  //       callback(new Error("两次输入密码不一致!"));
  //     } else {
  //       callback();
  //     }
  //   };
  //   return {
  //     resetForm: {
  //     //传给后台所需要的参数
  //       newpassword1: "",
  //       password: "root1234",
  //       username: "12345678"//此处只是后台需要的字段而已，如果前期有公用cookie里面有获取并且保存过，现在需要另外调用进来，具体的获取方法就看个人了
  //     },
  //     resetFormRules: {
  //        password: [
  //           { required: true, message: "请输入旧密码", trigger: 'blur' }
  //       ],
  //       newpwd: [
  //           { required: true, validator: validatePass, trigger: 'blur' }
  //       ],
  //       newpassword1: [
  //         { required: true, validator: validatePass2, trigger: "blur" }
  //       ]
  //     }
  //   };
  // },
  // methods: {
  //   onSubmit (formName) {
  //           this.$refs[formName].validate(valid => {
  //               if (valid) {
  //                   let { username,oldPassword, newPassword} = this.resetForm
  //                   updatePassword({ username, oldPassword,newPassword }).then(() => {
  //                       this.$message.success('密码已修改')
  //                   })
  //               } else {
  //                   this.$message.error('请正确填写表单')
  //                   return false
  //               }
  //           })
  //       }
  //   //这是修改成功后重新返回登陆页的方法，看个人需要自行调整
  //   // async logout() {
  //   //   await this.$store.dispatch("user/logout");
  //   //   this.$router.push(`/login`);
  //   // }
        return{
          info:null,
          returnObject:null,
          sellerdata:{
            "password":"",
            "password1":"",
            "password2":"",
            username:"this.$router.username"
            // username:""

          },
          key:null,

        }
  },
  methods:{
    goback(){
      this.$router.push({path:'history'})
    },
    onSubmit(){

      let that=this
      this.$http.post(
       'user/updatePassword',
        that.sellerdata,
      ).then(
        async function(response) {
          console.log(response);
          console.log(response.data);
          that.info=response.data;
          this.returnObject=that.info.returnObject;
          if((that.info.password==this.sellerdata.password)&&(that.info.username==this.sellerdata.username)){
            console.log("修改密码成功");
          }
        }
      );
    }
  }

};

</script>

<style lang="less" scoped>
.btn-position{
  text-align: center;
}
.font-style{
    font-size: 24px;
    font-family: 'Arial Normal','Arial';
    color: #999;
    font-weight: bold;

  }
  .el-form {
  width: 50%;
  margin: 50px auto 0;
  text-align: center;
  button {
    margin: 20px 0 0;
  }
}
.mystyle{
  width: 800px;
  height: 100%;
  margin: 0 auto;
  align-items: center;
}
</style>
