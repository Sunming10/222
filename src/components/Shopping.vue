  <template>
  <el-container>
    <el-header>
      <div>
            <i class="iconfont">&#xe607;</i>
            <el-button class="btn" type="warning"  round><router-link to='login' class='line'>登录</router-link></el-button>
      </div>
    </el-header>
    <el-main>
      <div>
        <h3 class="text">商品列表</h3>
      </div>
      <div>
          <img  class="img1" src="https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png" alt="">
          <el-button class="btn-1" type="text" @click="dialogFormVisible = true" round>加入购物车</el-button>
      </div>
      <div>
          <h3 class="text1">华为双AI慧眼学习智慧屏</h3>
          <h4 class="text2">价格</h4>
          <h4 class="text3">￥2199.00</h4>
          <div>
      <el-card class="box-card">
  <div class="text-dis item-dis">
    <span>
      <p>商品描述</p>
      <p> 双AI慧眼，一体式桌面设计。
        前置1300万智能升降摄像头和800万交互摄像头
        ，双摄像头各司其职，辅助孩子解决学习难题。
        配有18W独立音箱，
        支持4麦克风降噪，拾音清晰，
        上网课更方便。</p>
    </span>
  </div>
</el-card>
    </div>
      </div>
       <div>
    <div>

<el-dialog title="个人信息填写" :visible.sync="dialogFormVisible">
  <el-form :model="form"  :rules="rules" ref="form" label-width="100px" class="demo-ruleForm">
    <el-form-item label="真实姓名" :label-width="formLabelWidth" prop="buyer_name">
      <el-input v-model="form.buyer_name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" :label-width="formLabelWidth" prop="buyer_tel">
      <el-input v-model="form.buyer_tel" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="收货地址" :label-width="formLabelWidth"  prop="buyer_address">
      <el-input v-model="form.buyer_address" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('form')">确定</el-button>
                  <el-button @click="resetForm('form')">重置</el-button>
    </el-form-item>
  </el-form>
</el-dialog>
    </div>
  </div>
    </el-main>
  </el-container>
  </template>
<script>
  export default {
    data() {
      return {
      form: {
          buyer_name:'',
          buyer_tel:'',
          buyer_address:'',
        },
      rules: {
              buyer_name: [
              { required: true, message: '请输入姓名', trigger: 'blur' },
              { min: 1,message: '最小长度为1', trigger: 'blur' }
                ],
              buyer_tel: [
              { required: true, message: '请输入联系电话', trigger: 'blur' },
              { min: 11,message: '请输入正确的电话号码', trigger: 'blur' }
                ],
                buyer_address: [
              { required: true, message: '请输入收货地址', trigger: 'blur' },
              { min: 1,message: '请输入正确的收货地址', trigger: 'blur' }
                ],
      },
        dialogFormVisible: false,
        formLabelWidth: '120px',
      };
    },
      methods: {
      submitForm(form){
        this.$refs[form].validate((valid) => {
          if (valid) {
            this.$confirm('请确认个人信息是否填写正确', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.$message({
            type: 'success',
            message: '个人信息保存成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消保存'
          });
        });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
    resetForm(form){
        this.$refs[form].resetFields();
      },
      }
    }
</script>

<style lang="less" scoped>
  @import url('../assets/css/font.css');
  .line{
        text-decoration: none;
        color: #ffff;
      }

.el-container {
  background-color: #F7F0DF;
  height: 100%;
}
.el-header {
  background-color: #EFD8AA;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;
  i{
    margin-left: 80%;
  }
  div {
    display: flex;
    align-items: center;
}
}
.btn{
    margin-left: 0%;
  }
div{
  .iconfont{
  margin-left: 1370px;
}
}
div{
.text{
    border-width: 10px;
    left: 0px;
    margin-top: -10px;
    width: 649px;
    height: 341px;
    display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 25px;
    text-align: center;
    color:#464343;
}
.img1{
      border-width: 0px;
      left: 0px;
      top: 0px;
      float: left;
      margin-top: -300px;
      margin-left: 50px;
      width: 300px;
      height: 350px;
      text-align: left;
    }
    .btn-1{
  margin-top: 80px;
  margin-left: -210px;
  background-color: rgb(238, 137, 54);
  border-radius: 4px;
  border: 1px solid rgb(221, 221, 238);
  padding: 8px 9px;
  color: rgb(68, 63, 63);
  font-family: 'Arial Normal','Arial';
    }
}
div{
  .text1{
     margin-top: -420px;
      margin-left:420px;
      display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 18px;
    text-align: center;
    color:#1a1818;
  }
  .text2{
      margin-top: 50px;
      margin-left: 420px;
      display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 18px;
    text-align: center;
    color:#2c2929;
    }
    .text3{
      margin-top: -47px;
      margin-left: 490px;
      display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 18px;
    text-align: center;
    color:#f51a1a;
    }
}
div{

    .text-dis {
    font-size: 14px;
  }

  .item-dis {
    padding: 18px 0;
  }

  .box-card {
      margin-left: 400px;
    margin-top: 70px;
    width: 300px;
    background-color: #eed7c0;
  }
    }
</style>
