  <template>
  <el-container>

  <div>
    <h3 class="text">XX线上购物欢迎您!</h3>
    </div>
  <div >
        <img  class="img1" src="https://iconfont.alicdn.com/t/992dee67-ae7d-4812-a294-b2dcf0abb623.png" alt=""></div>
      <div >
        <img  class="img2" src="https://iconfont.alicdn.com/t/40e02adb-c782-431d-b37a-ed8997eb7b52.png" alt=""></div>
    <div >
      <div>
    <el-button class="btn_1" type="warning" round><router-link to='login' class='line'>登录</router-link></el-button>
</div>

        <img  class="img3" src="https://iconfont.alicdn.com/t/4fe848e1-4785-46ad-93c5-8296efd2484f.png" alt=""></div>
<div id="item-list">
      <div class="backpicture">
        <img  class="img4" src="https://mr.baidu.com/r/trstE61dxS?f=cp&u=ed17994c0faa15e7" alt=""></div>
  <div class="front">
    <div><h1 class="text1">商品列表</h1></div>
    <div>
        <img  class="img5" src="https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png" alt="">
         </div>
  <div><h3 class="text2">华为双AI慧眼学习智慧屏</h3></div>
    <div><h4 class="text3">价格</h4></div>
    <div><h4 class="text4">￥2199.00</h4></div>
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
    <div>
 <el-button class="btn" type="text" @click="dialogFormVisible = true" round>加入购物车</el-button>
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
    </div>
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
  .line{
        text-decoration: none;
        color: #ffff;
      }
  .el-container{
  background-color: #F7F0DF;
    height: 200%;
  }
  div{
    .btn_1{
      margin-top: 10px;
      margin-left: 200px;
    }
  }
div{
    .text{
    border-width: 10px;
    left: 462px;
    margin-top: 200px;
    margin-left: 550px;
    width: 649px;
    height: 341px;
    display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 50px;
    text-align: center;
    color:#464343;
  }
    .img1{
        border-width: 0px;
      position: absolute;
      left: 0px;
      top: 0px;
      float: left;
      margin-top: 200px;
      margin-left: 100px;
      width: 300px;
        height: 350px;
      text-align: left;

    }
      .img2{
          position: absolute;
        border-width: 0px;
        left: 0px;
        top: 0px;
        margin-top: 200px;
        margin-left: 1100px;
        float: left;
        width: 300px;
        height: 350px;
        text-align: left;
        }
        .img3{
        border-width: 0px;
      position: absolute;
      left: 0px;
      top: 0px;
      float: left;
      margin-top: 500px;
      margin-left: 600px;
      width: 250px;
        height: 300px;
      text-align: left;
        }
}
#item-list{
  .backpicture{
    z-index: -1;
    border-width: 0px;
    position: absolute;
      left: 0px;
        top: 0px;
        float: left;
      width: 50%;
      height: 100%;
      margin-top: 740px;
      margin-left:-35px;
  }
  .front{
    z-index: 1;
    position: absolute;

    }
    div{

.text1{
      margin-top: 780px;
      margin-left: -1400px;
      display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 30px;
    text-align: center;
    color:#746d6d;
    }
    .img5{
      float: left;
      margin-top: 10px;
      margin-left: -1350px;
      width: 250px;
        height: 300px;
      text-align: left;
    }
    .text2{
      margin-top: 30px;
      margin-left: -1050px;
      display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 20px;
    text-align: center;
    color:#1a1818;
    }
    .text3{
      margin-top: 30px;
      margin-left: -1050px;
      display: flex;
    font-family: 'Arial Normal','Arial';
    font-size: 18px;
    text-align: center;
    color:#585454;
    }
    .text4{
      margin-top: -47px;
      margin-left: -1000px;
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
      margin-left: -1050px;
    width: 300px;
    background-color: #eed7c0;
  }
    }
    div{
    .btn{
  margin-top:-20px;
  margin-left: -1280px;
  background-color: rgb(238, 137, 54);
  border-radius: 4px;
  border: 1px solid rgb(221, 221, 238);
  padding: 8px 9px;
  color: rgb(68, 63, 63);
  font-family: 'Arial Normal','Arial';
}

      }
    }

</style>
