<template>
  <el-container>
    <el-header>
      <el-button type="warning"  icon="el-icon-user" class="position"> <router-link to="login" class="line">登&nbsp;录</router-link></el-button>
    </el-header>
    <el-main>
      <el-row :gutter="30">
          <el-col :span="6">
            <div class="grid-content bg-purple">
            <img src="https://iconfont.alicdn.com/t/992dee67-ae7d-4812-a294-b2dcf0abb623.png" class="img_size">
            </div>
            </el-col>
          <el-col :span="10">
            <div class="grid-content bg-purple">
              <span class="title">欢迎来到网上购物平台!</span>
            </div>
            </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
                <img src="https://iconfont.alicdn.com/t/40e02adb-c782-431d-b37a-ed8997eb7b52.png" class="img_size">
            </div>
              </el-col>
          <!-- <el-col :span="6"><div class="grid-content bg-purple"></div></el-col> -->
      </el-row>
      <el-row>
          <el-col :span="8">
            <div class="grid-content bg-purple img_position">
              <img src="https://iconfont.alicdn.com/t/4fe848e1-4785-46ad-93c5-8296efd2484f.png" class="img_size">
            </div>
            </el-col>
          <el-col :span="8">
            <div class="grid-content bg-purple-light img_position">
              <img src="https://iconfont.alicdn.com/t/93d0a257-e045-4e98-90e0-cea8e01deac9.png" class="img_size">
            </div>
              </el-col>
      </el-row>

       <el-row>
  <el-col>
      <el-card class="box-card" >
        <div     class="text item">
          <div>
            <span class="item_title">
              {{itemList.title}}
            </span>
          </div>
          <div class="item_size">
            <div>
            <img :src="this.itemLists1.goods_img" class="img_size">
            </div>
            <div>
            <el-button type="warning" @click="submit" icon="el-icon-shopping-cart-1">提交购买信息</el-button>
            </div>
          </div>
          <div  class="item_list">
              <div>
                <span class="title1">
               {{this.itemLists1.goods_name}}
              </span>
              </div>
             <div>
                <span class="price">
                  {{itemList.priceTitle}}{{this.itemLists1.goods_price}}
              </span>
             </div>
              <div>
                <span class="describe">
              </span>
              </div>
              <div class="contain">
                  {{this.itemLists1.goods_discribe}}
              </div>
        </div>


        </div>

      </el-card>
      </el-col>
      </el-row>

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
          <el-button type="warning" @click="submitForm">确定</el-button>
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
      itemLists:[],
      itemLists1:{},
      ListData:[],
      buyerData:[],
      form: {
          buyer_name:'',
          buyer_tel:'',
          buyer_address:'',
        },
      goodId:'',

      rules: {
              buyer_name: [
              { required: true, message: '请输入姓名', trigger: 'blur' },
              { min: 0,max:10,message: '姓名不能超过10个字', trigger: 'blur' }
                ],
              buyer_tel: [
              { required: true, message: '请输入联系电话', trigger: 'blur' },
              { min: 11,max:11,message: '请输入正确的联系电话', trigger: 'blur' }

                ],
                buyer_address: [
              { required: true, message: '请输入收货地址', trigger: 'blur' },
              { min: 0,max:50,message: '收货地址不能超过50个字', trigger: 'blur' }
                ],
      },
        dialogFormVisible: false,
        formLabelWidth: '100px',
         describe:{
          title:"商品描述",
             },
         itemList:{
         title:"商品列表",
         name:"商品名字:",
           priceTitle:"￥",

        }
      };
    },
    created(){
      this.getGoods();
    },
      methods: {
        getGoods(){
          this.$http.post('/goods/searchWelcomeGoods',this.itemLists).then(res=>{
            this.itemLists=res.data.goods
            this.itemLists1=res.data.goods[0]
            this.goodId=res.data.goods[0].item_id
          })
        },
        submit(){
          console.log(this.itemLists.length);
             if(this.itemLists.length==0){
                   this.$message({
                            type: 'error',
                            message: '暂无商品!'});

                }else{
                  this.dialogFormVisible=true
                }
        },
      submitForm(){
            if(this.form.buyer_name==''|| this.form.buyer_tel==''||this.form.buyer_address==''){
               if(this.form.buyer_name==''&& this.form.buyer_tel==''&&this.form.buyer_address==''){
                    this.$message({
                    type: 'error',
                    message: '个人信息不能为空!'});
               }
              else if(this.form.buyer_name==''){
                this.$message({
                    type: 'error',
                    message: '真实姓名不能为空!'});
              }
               else if(this.form.buyer_tel==''){
                this.$message({
                    type: 'error',
                    message: '联系电话不能为空!'});
              }
              else if(this.form.buyer_address==''){
                this.$message({
                    type: 'error',
                    message: '收货地址不能为空!'});
              }
            }
            else{
              let reg = /^1[0-9]{10}$/
              if(this.form.buyer_name.length>10||this.form.buyer_tel.length!=11|| !reg.test(this.form.buyer_tel)||this.form.buyer_address.length>50){
                this.$message({
                    type: 'error',
                    message: '请正确填写信息!'});
              }
              else{
          this.$http.post('/order/addToOrderWanted',{'item_id':this.goodId,'buyer_realname':this.form.buyer_name,
            'buyer_phonenumber': this.form.buyer_tel,'buyer_address':this.form.buyer_address}).then(response=>{
              console.log(this.form.buyer_name);
              console.log(response);
                    if(response.data.message=="success"){

                            this.$message({
                            type: 'success',
                            message: '个人信息保存成功!'});
                              this.dialogFormVisible=false;

                      }else if(response.data.message=="error"){
                             this.$message({
                            type: 'error',
                            message: '个人信息保存失败!'});
                      }
            })
              }


            }
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
.el-row {
    margin-bottom: 20px;
    // margin-left: 9%;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 300px;
    text-align: center;
  }
  .row-bg {
    padding: 10px 0;
    // background-color: #f9fafc;
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
  }
  .item_title{
    line-height: 50px;
    font-size: 25px;
    font-weight: bold;
    color: gray;

  }
  .item_size{
    width: 400px;
    height:400px;
    text-align: center;
    float: left;

  }
  .img_size{
    width: 300px;
    height: 300px;
  }
  .item_list{
    width: 400px;
    height: 400px;
    float: left;
    text-align: left;
    margin-top: -50px;
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
    margin-top: 20px;
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
