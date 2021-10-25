<template>
  <div class="container-size">
    <div class="right-container">
      <el-container>
      <el-header>
        <div class="back-size">
          <span class="seller-info">买家信息</span>
          <el-button type="warning" class="button-position" plain disabled>撤销</el-button>
        </div>
      </el-header>
        <el-main>
          <el-main>
        <el-table
              :data="tableData"
              stripe
              border
              style="width: 100%;"
               height="600">
              <!-- 买家姓名 -->
              <el-table-column
                prop="name"
                label="买家姓名"
                width="180">
              </el-table-column>
              <!-- 联系电话 -->
              <el-table-column
                prop="tel"
                label="联系电话"
                width="180">
              </el-table-column>
              <!-- 收货地址 -->
              <el-table-column
                prop="address"
                label="收货地址">
              </el-table-column>
              <!-- 操作 -->
              <el-table-column
                label="操作">
                <el-button type="warning" >同意</el-button>
              </el-table-column>
            </el-table>
      </el-main>
        </el-main>

      </el-container>
    </div>
    <div class="left-container">
      <el-container>
        <el-header>
          <div class="position">
            <span style="padding:0 0 0 32px;font-size:18px;color:gray;font-weight: bold;">商品详情</span>
          <el-button icon="el-icon-back" type="text" class="botton" @click="returnBack">返回</el-button>
          </div>
        </el-header>
        <el-main>
           <el-row style="text-align:center;margin-left:12%">
            <el-col :span="20" v-for="(item, index) in form" :key="item" :offset="index > 0 ? 1 : 0">
              <el-card :body-style="{ padding: '25px 0 20px 0' }">
                <img  :src="item.goods_img" class="image1">
                <div style="text-align: center;">
                  <span class="font-style">{{item.goods_name}}</span>
                  <div class="word"><span class="price">￥{{item.goods_price}}</span></div>
                  <div class="bottom clearfix ">
                    <!-- <time class="time">{{ currentDate }}</time> -->
                    <!-- <el-button type="text" class="button" @click="change">编辑商品</el-button> -->
                    <span style="line-height:50px">商品描述</span>
                    <div style="padding:10px;line-height:30px">
                      {{item.goods_discribe}}
                    </div>

                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
    </div>
  </div>
</template>
<style lang="less" scoped>
// *{
//   margin: 0;
//   padding: 0;
// }
.seller-info{
  // background-color: rgb(243, 200, 118);
  line-height: 50px;
  font-size: 18px;
  font-weight: bold;
  color: gray;
  padding: 0 0 0 20px;
}
.el-header{
  padding: 0;
}
.el-main{
  padding: 0 20px;
}
.back-size{
    width: 100%;
    height: 50px;
    background-color: rgb(243, 200, 118);
}
.container-size{
  height: 100%;
  // background-color: antiquewhite;
}
.button-position{
  margin-left: 75%;
}
.image1{
  width: 300px;
  height: 150px;
  // text-align: center;
  // margin-left: 20%;
}
.position{
  margin-top:10px;
}
.font-style{
  font-size: 18px;
  line-height: 40px;
}
.word{
  font-size: 16px;
  line-height: 20px;
  color: red;
  font-weight: bold;
}
.right-container{
  width: 50%;
  height: 100%;
  float: right;
  background-color: rgb(242, 242, 242);
}
.left-container{
  height: 100%;
  width: 50%;
  background-color: rgb(247, 240, 223);;
}
.botton{
  margin-left:75%;
  font-size: 18px;
  color: rgb(116, 109, 109);
}
.bottom{
  width: 400px;
  height: 200px;
  background-color:  rgb(247, 240, 223);
  margin: 0 auto;
  align-items: center;
  padding: 0px 0 10px 0px;
  border-radius: 5px;
}
.clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }

  .clearfix:after {
      clear: both
  }

</style>
<script>
export default {
  data() {
    return{
       tableData: [{
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          name: '王小虎',
          tel:'18375289147',
          address: '上海市普陀区金沙江路 1518 弄'
        },],
        form:[]

    }

  },
  created() {
        this.handleGoodList();
    },
  methods: {
    returnBack(){
        this.$router.push('selling');
    },

    handleGoodList(){

        this.$http.post('/goods/searchSellingGoods', {'page': this.currentPage 
        }).then(res=>{
          var ListData=JSON.stringify(res.data.goods);
          console.log(ListData);
          this.form=JSON.parse(ListData)
          console.log(this.form);
        })
      },
  }
}
</script>
