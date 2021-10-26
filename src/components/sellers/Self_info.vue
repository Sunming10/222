<template>

        <div class="mystyle">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>卖家修改密码</span>
            </div>
            <!-- <el-row>
  <el-col  v-for="(item, index) in itemLists" :key="item" :offset="index > 0 ? 1 : 0"> -->
            <div>
              <el-form :model="sellerData"
                status-icon :rules="rules" ref="sellerData" label-width="100px" class="demo-ruleForm" >
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
                    <el-button  @click="resetForm('sellerData')">重置</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <el-button type="warning" @click="onSubmit">修改</el-button>
                </el-form-item>
              </el-form>
            </div>
  <!-- </el-col>
            </el-row> -->
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
           this.$http.post('/user/getUserInfo', {'username' :'admin'}).then(res=>{
            var ListData = JSON.stringify(res.data.user)
            this.user = JSON.parse(ListData)
            // console.log(this.user);
              if (this.sellerData.password !== this.user.password) {
            callback(new Error('密码输入错误！'));
          }
          callback();

          // sessionStorage.getItem('token')
          // console.log("Token:"+'token');
          //    if (this.sellerData.password !== this.password) {
          //   callback(new Error('密码输入错误！'));
          // }
          // callback();
           })
          // if (this.sellerData.password !== 'root1234') {
          //   callback(new Error('密码输入错误！'));
          // }
          // callback();
        }
      };
     var validatePass1 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入新密码'));
        } else {
           this.$http.post('/user/getUserInfo', {'username' :'admin'}).then(res=>{
            var ListData1 = JSON.stringify(res.data.user)
            this.user1 = JSON.parse(ListData1)
            console.log(this.user1);
        if(this.sellerData.password1 !== ''){
          if((value.length<7)||(value.length>15)){
            callback(new Error('密码长度应在7~15位之间！'));
          }
          else if(this.sellerData.password1===this.user1.password){
                callback(new Error('新密码与旧密码一致！'));
        }
          else{
             callback();
            }
        }

        else {
          callback();
        }
      })
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
           user:[],
           ListData:[],
           user1:[],
           ListData1:[],
          //  password : '',
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
    // getPwd(){
    //       this.$http.post('/user/getUserInfo', {'username' :'admin'}).then(res=>{
    //         var ListData = JSON.stringify(res.data.user)
    //         this.user = JSON.parse(ListData)
    //         console.log(this.user);
    //         for(var i=0;i<this.user.length;i++){
    //           this.password = this.user[i].password;
    //           console.log(this.password);
    //        }
    //       })
    // },
      onSubmit(){
        if(this.sellerData.password==''||this.sellerData.password1==''||this.sellerData.password2==''){
           this.$message({
                    type: 'error',
                    message: '密码不能为空!'});
        }
        else{
           this.$http.post('/user/updatePassword',{'username':'admin','oldPassword':this.sellerData.password,
           'newPassword':this.sellerData.password2}).then(res=>{
              //  console.log(this.sellerData.password);
              //  console.log(this.sellerData.password2);
               if(res.data.message=="success"){
                    this.$message({
                    type: 'success',
                    message: '密码修改成功!'});
               }
               else if(res.data.message=="error"){
                  this.$message({
                    type: 'error',
                    message: '密码修改失败!'});
               }
           })
        }
      },
     resetForm(sellerData){
        this.$refs[sellerData].resetFields();
      },

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
