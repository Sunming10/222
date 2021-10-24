<template>
  <el-container>
    <el-header>
      <el-button type="warning" class="position"> <router-link to="login" class="line">登&nbsp;录</router-link></el-button>
    </el-header>
    <el-main>
       <el-card class="box-card">
        <div class="text item">
          <div>
            <span class="item_title">
              {{itemList.title}}
            </span>
          </div>
          <div class="item_size">
            <div>
            <img :src="itemList.image" class="img_size">
            </div>
            <div>
            <el-button type="warning" @click="dialogFormVisible = true" icon="el-icon-shopping-cart-1">加入购物车</el-button>
            </div>
          </div>
          <div class="item_list">
              <div>
                <span class="title1">
                  {{itemList.name}}
              </span>
              </div>
             <div>
                <span class="price">
                  {{itemList.priceTitle}}{{itemList.price}}
              </span>
             </div>
              <div>
                <span class="describe">
                    {{describe.title}}
              </span>
              </div>
              <div class="contain">
                  {{describe.contain}}
              </div>
        </div>


        </div>

      </el-card>
    </el-main>
    <el-dialog title="个人信息填写" :visible.sync="dialogFormVisible">
        <el-form :model="form"  :rules="rules" ref="form" label-width="100px" class="demo-ruleForm">
        <el-form-item label="真实姓名" :label-width="formLabelWidth" prop="buyer_name">
          <el-input v-model="form.buyer_name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" :label-width="formLabelWidth" prop="buyer_tel">
          <el-input v-model="form.buyer_tel" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收货地址" :label-width="formLabelWidth"  prop="buyer_address">
          <el-input v-model="form.buyer_address" autocomplete="off" type="textarea"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="warning" @click="submitForm('form')">确定</el-button>
                      <el-button @click="resetForm('form')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
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
              { min: 2,max:10,message: '姓名在1~10个字符之间', trigger: 'blur' }
                ],
              buyer_tel: [
              { required: true, message: '请输入联系电话', trigger: 'blur' },
              { min: 11,message: '请输入正确的电话号码', trigger: 'blur' }
                ],
                buyer_address: [
              { required: true, message: '请输入收货地址', trigger: 'blur' },
              { min: 2,max:50,message: '收货地址长度在2~50个字符之间', trigger: 'blur' }
                ],
      },
        dialogFormVisible: false,
        formLabelWidth: '100px',
        describe:{
          title:"商品描述",
          contain:"双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。"

        },
        itemList:{
          title:"商品列表",
          name:"华为双AI慧眼学习智慧屏",
          priceTitle:"价格：￥",
          price:"2199.00",
          image:'https://iconfont.alicdn.com/t/e89430ee-42ed-4d98-8ea2-6987122dc98a.png'
        }
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
.el-container{
  background-color: rgb(247, 240, 223);
}
.el-header{
  height: 60px;
  background-color: rgb(239, 216, 170);
  line-height: 60px;
  // float: right;
}
.line{
  text-decoration: none;
  color: white;
  // float: left;

}
.position{
  float: right;
  // margin-top: 9px;
  margin: 9px 50px 0 0;
}
 .title{
    line-height: 400px;
    color: #99a9bf;
    font-size: 48px;
    font-weight: bold;
    margin-left: 100px;
  }
  .img_position{
    margin-left: 45%;
  }
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
    // float: left;

  }

  .box-card {
    width: 100%;
    background-color: rgb(247, 240, 223);
  }
  .el-card{
    box-shadow: 0 -1px 8px rgb(0 0 0 37%) !important;
    height: 600px;
    // float: right;
    // -webkit-box-shadow: 0 -1px 8px rgb(0 0 0 / 40%) !important;
  }
  .item_title{
    line-height: 50px;
    font-size: 20px;
    font-weight: bold;
    color: gray;

  }
  .item_size{
    width: 400px;
    height:400px;
    text-align: center;
    // background-color: aqua;
    float: left;

  }
  .img_size{
    width: 300px;
    height: 300px;
  }
  .item_list{
    // background-color: aliceblue;
    width: 400px;
    height: 400px;
    float: left;
    text-align: left;
  }
  .title1{
    // font-family: ;
    font-size: 25px;
    font-weight: bold;
    color: gray;
    line-height: 100px;

  }
  .price{
    font-size: 20px;
    font-weight: bold;
    color: red;
    // line-height: 100px;
  }
  .describe{
     font-size: 20px;
    font-weight: bold;
    color: gray;
    line-height: 60px;
  }
  .contain{
    width: 300px;
    height: 200px;
    border-radius: 4px;
    background-color: rgb(239, 216, 170);
    font-size: 16px;
    color: #99a9bf;
    text-align: left;
    padding: 20px 10px;
  }
</style>
