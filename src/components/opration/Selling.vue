<template>

  <el-container>
    <el-header>
      <span style="font-size:18px;color:gray;font-weight:bold;">商品列表</span>
        <el-button type="warning" style="margin-left:80%" @click="goto" :disabled="this.btnState=false">添加商品</el-button>
    </el-header>

<el-main>
    <el-row>
      <el-col :span="6">
          <el-card :body-style="{ padding: '0px' }" style="text-align: center;text-decoration:none,height:100px" >
          <img  :src="this.form.goods_img" class="image" @click="toDetail">
          <div style="text-align: center;">
            <span class="font-style">{{this.form.goods_name}}</span>
            <div class="word"><span class="price">￥{{this.form.goods_price}}</span></div>
          </div>
        </el-card>
      </el-col>
    </el-row>
</el-main>
    <el-footer style="margin-left: 57%;margin-top: 14%;">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10]"
      :page-size="pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="this.formdata.length">
    </el-pagination>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      formLabelWidth: '100px',
      currentPage: 1,
      dialogFormVisible: false,
       btnState:true,
      pagesize:10,
       form:{},
       itemId:[],
       itemName:[],
       itemImg:[],
       itemDiscribe:[],
       itemGoods:[],
       formdata:[],
       form1:{}
      //  query:''

    };

  },
   created() {
        this.handleGoodList();
    },
  methods: {
      handleSizeChange(size) {
        this.pagesize=size;
        console.log(`每页 ${size} 条`);
      },
      handleCurrentChange(currentPage) {
        this.currentPage=currentPage;
        console.log(`当前页: ${currentPage}`);
      },
      // 加载商品
      handleGoodList(){
        this.$http.post('/goods/searchSellingGoods', {'page': this.currentPage 
        }).then(res=>{
          this.formdata = res.data.goods
          if(this.formdata.length>1){
            this.form=res.data.goods[0]
          }else{
            this.form=res.data.goods[0]
          }
        })
      },
// 商品详情页
      toDetail(){
         this.$http.post('/goods/searchSellingGoods', {'page': this.currentPage 
        }).then(res=>{
          this.form1=res.data.goods
          this.$router.push({
            path: 'detail',
            query:{
             item_id:this.form1.item_id,
             itemDetail:this.form1
            }
         });
        })

      },
      // 添加商品
      goto(){
        this.$http.post('/goods/searchFreezingGoods',{'seller_username':'admin','page':this.currentPage}).then(response=>{
              this.query=response.data.list.length
        })
        // console.log(this.formdata.length);
        if(this.query==0){//this.query
          if(this.formdata.length==0){
            this.$router.push('add')
          }else{
             this.$message({
            type: 'error',
            message: '您暂时不能添加商品!'
            });
          }

        }else {
            this.$message({
            type: 'error',
            message: '您暂时不能添加商品!'
            });
        }
            this.btnState=false
      },
    }
}
</script>

<style>
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
    background-color: #999;
  }

  .button {
    width: 100%;
    text-align: center;
    font-size: 20px;
    color: rgb(255, 255, 255);
    height: 50px;
  }
  .el-input{
    width: 88%;
  }
  .el-textarea{
    width: 88%;
  }

  .image {
    width: 70%;
    display: block;
    margin-left: 14%;
    height: 200px;
    padding: 10px;
    border-radius: 4px;
  }
  .font-style{
    font-size: 16px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
  }
  .price{
    font-size: 16px;
    color: red;
  }
  .word{
    margin: 5px 0;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }

  .clearfix:after {
      clear: both
  }
  .el-button--text:focus, .el-button--text:hover {
    color: #ffffff;
    border-color: transparent;
    background-color: transparent;
}
</style>
