<template>

  <el-container>
    <el-header>
      商品列表
</el-header>
    <el-row>
  <el-col :span="6" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
    <el-card :body-style="{ padding: '0px' }">
      <img  src="https://2c.zol-img.com.cn/product/214_120x90/588/cerBdmwpBi0E.jpg" class="image">
      <div style="text-align: center;">
        <span class="font-style">华为智慧屏</span>
        <div class="word"><span class="price">￥2199.00</span></div>
        <div class="bottom clearfix ">
          <!-- <time class="time">{{ currentDate }}</time> -->
          <el-button type="text" class="button" @click="change">编辑商品</el-button>
        </div>
      </div>
    </el-card>
  </el-col>
</el-row>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      currentDate: new Date()
    };

  }, methods: {
      change(){
         this.$router.push('detail');
      }
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
    /* padding: 0; */
    /* float: right; */
    text-align: center;
    font-size: 20px;
    color: rgb(255, 255, 255);
    height: 50px;
    /* border-radius: 4px; */



  }

  .image {
    width: 70%;
    display: block;
    margin-left: 15%;
  }
  .font-style{
    font-size: 16px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
  }
  .price{
    font-size: 16px;
    color: red;
    /* padding: 5px 0; */
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
