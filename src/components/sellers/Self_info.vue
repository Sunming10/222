<template>
  <el-container>

              <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
              <el-form-item label="卖家姓名" prop="seller_name">
                <el-input type="text" v-model="ruleForm.seller_name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="卖家联系方式" prop="seller_tel">
                <el-input type="text" v-model="ruleForm.seller_tel" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="旧密码" prop="old_passward">
                <el-input type="password" v-model="ruleForm.old_passward" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="pass">
                <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="warning" @click="submitForm('ruleForm')" round>提交</el-button>
                <el-button @click="resetForm('ruleForm')" type="warning" round>重置</el-button>
              </el-form-item>
            </el-form>

  </el-container>
</template>

<script>
export default {
     data() {


      var oldPass = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('密码错误！'));
        }
        setTimeout(() => {
          // if (!Number.isInteger(value)) {
          //   callback(new Error('请输入正确的密码！'));
          // } else {
            if (value!='123456') {
              callback(new Error('密码错误！'));
            } else {
              callback();
            }
          // }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入新密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          seller_name:'金智妮',
          seller_tel:'18375289147',
          oldpass:'1234567',
          pass: '',
          checkPass: '',
        },
        rules: {
          // seller_name: [
          //   { validator: sellerName, trigger: 'blur' }
          // ],
          oldpass: [
            { validator: oldPass, trigger: 'blur' }
          ],
           pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
        },
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('请完善内容!');
          } else {
            console.log('错误输入!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      // checkForm(){

      // }
    }
  }

</script>

<style lang="less" scoped>
.btn-position{
  text-align: center;
}
</style>
