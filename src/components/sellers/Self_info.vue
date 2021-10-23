<template>
        <div class="mystyle">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>卖家修改密码</span>
            </div>
            <div>
              <el-form :model="sellerData" status-icon :rules="rules" ref="sellerData" label-width="100px" class="demo-ruleForm" >
                <el-form-item label="原密码" prop="password">
                    <el-input type="password" v-model="sellerData.password" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="新密码" prop="password1">
                    <el-input type="password" v-model="sellerData.password1" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="password2">
                    <el-input type="password" v-model="sellerData.password2" autocomplete="off"></el-input>
                </el-form-item>
                    <el-form-item>
                    <el-button>取消</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <el-button type="warning" @click="onSubmit">修改</el-button>
                </el-form-item>
              </el-form>
            </div>
            <div>{{info}}</div>
            <div>{{returnObject}}</div>

          </el-card>

        </div>
</template>

<script>

export default {
  data() {
    var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入原密码'));
        } else {
          if (this.sellerData.password !== '1234567') {
            callback(new Error('密码输入错误！'));
          }
          callback();
        }
      };
     var validatePass1 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入新密码'));
        } else {
        if(this.sellerData.password1 !== ''){
          if((value.length<7)||(value.length>15)){
            callback(new Error('密码长度应在7~15位之间！'));
          }else{
             callback();
            }
        }else{
          callback();
        }
      }
   };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.sellerData.password1) {
          callback(new Error('两次输入密码不一致!'));
        }
        else {
          callback();
        }
      };
        return{
            sellerData:{
              password:'',
              password1:'',
              password2:''
            },
            rules:{
              password:[
                { validator: validatePass, trigger: 'blur' }
              ],
              password1:[
                { validator: validatePass1, trigger: 'blur' }
              ],
              password2:[
                { validator: validatePass2, trigger: 'blur' }
              ]
            }
        }
  },
  methods:{
    // goback(){
    //   this.$router.push({path:'history'})
    // },
    // onSubmit(){
    // }
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
