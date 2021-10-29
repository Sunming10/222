<template>
  <el-container>
    <el-header>
      <el-button type="warning" class="position"> <router-link to="login" class="line">登&nbsp;录</router-link></el-button>
    </el-header>
    <el-main>
      <el-row>
  <el-col  v-for="(item, index) in itemLists" :key="item" :offset="index > 0 ? 1 : 0">
       <el-card class="box-card">
        <div class="text item">
          <div>
            <span class="item_title">
              {{itemList.title}}
            </span>
          </div>
          <div class="item_size">
            <div>
            <img :src="item.goods_img" class="img_size">
            </div>
            <div>
            <el-button type="warning" @click="item.item_id;dialogFormVisible = true" icon="el-icon-shopping-cart-1">提交购买信息</el-button>
            </div>
          </div>
          <div class="item_list">
              <div>
                <span class="title1">
                  {{item.goods_name}}
              </span>
              </div>
             <div>
                <span class="price">
                  {{itemList.priceTitle}}{{item.goods_price}}
              </span>
             </div>
              <div>
                <span class="describe">
              </span>
              </div>
              <div class="contain">
                  {{item.goods_discribe}}
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
        itemLists:[],
        ListData:[],
      form: {
          buyer_name:'',
          buyer_tel:'',
          buyer_address:'',
        },
      rules: {
              buyer_name: [
              { required: true, message: '请输入姓名', trigger: 'blur' },
              { min: 0,max:5,message: '姓名在不能超过5个字', trigger: 'blur' }
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
            var ListData=JSON.stringify(res.data.goods);
            console.log(ListData);
            this.itemLists=JSON.parse(ListData);
            console.log(this.itemLists);
             for(var i=0; i< this.itemLists.length;i++){
              this.item_id = this.itemLists[i].item_id;
            }
          })
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
               if(this.form.buyer_name.length>5||this.form.buyer_tel.length!=11||this.form.buyer_address.length>50){
                this.$message({
                    type: 'error',
                    message: '请正确填写信息!'});
              }
              else{
              this.$http.post('/order/addToOrderWanted',{'item_id':this.item_id,'buyer_realname':this.form.buyer_name,
            'buyer_phonenumber': this.form.buyer_tel,'buyer_address':this.form.buyer_address}).then(response=>{
              console.log(this.form.buyer_name);
              console.log(response);
               if(response.data.message=="success"){
                    this.$message({
                    type: 'success',
                    message: '个人信息保存成功!'});
                    // dialogFormVisible=false

               }

            })
              }
                this.dialogFormVisible=false
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
    margin-top: 50px;
  }
  .el-card{
    box-shadow: 0 -1px 8px rgb(0 0 0 37%) !important;
    height: 600px;
    // float: right;
    // -webkit-box-shadow: 0 -1px 8px rgb(0 0 0 / 40%) !important;
  }
  .item_title{
    position: absolute;
    line-height: 50px;
    font-size: 25px;
    font-weight: bold;
    color: gray;
    margin-top: -100px;
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
