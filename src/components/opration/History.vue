<template>
  <el-container>
    <el-header style="height:0px">
    </el-header>
    <el-main>
              <el-table :data="List.slice((currentPage-1)*pagesize,currentPage*pagesize)"   height="600" >
                <el-table-column property="item_id" label="商品编号" width="100"></el-table-column>
                <el-table-column property="goods_name" label="商品名称" width="100"></el-table-column>
                <el-table-column property="goods_price" label="商品价格" width="100"></el-table-column>
                   <el-table-column property="goods_discribe" label="商品描述" width="200"></el-table-column>
                      <el-table-column property="goods_img" label="商品图片" width="150">
                        <template slot-scope="scope">
                          <span>
                            <img :src="scope.row.goods_img" style="width:120px;height:100px;">
                          </span>
                        </template>
                      </el-table-column>
                <el-table-column property="order_id" label="订单编号" width="100"></el-table-column>
                <el-table-column property="buyer_realname" label="买家姓名" width="100"></el-table-column>
                <el-table-column property="buyer_phonenumber" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="buyer_address" label="交易地址" width="250"></el-table-column>
                 <el-table-column property="finish_time" label="交易时间" width="200"></el-table-column>

              </el-table>
</el-main>
<el-footer>
 <!-- <div class="block"> -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10]"
      :page-size="pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="this.List.length">
    </el-pagination>
  <!-- </div> -->
  </el-footer>
  </el-container>
</template>
<script>
export default {
  data() {
    return {
        currentPage:1,
        pagesize:10,
        List:[],
    }
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
      handleGoodList(){

        this.$http.post('/goods/searchHistoryGoods', {'seller_username':'admin','page': this.currentPage 
        }).then(res=>{
            console.log(res);
          var ListData=JSON.stringify(res.data.list);
          console.log(ListData);
          this.List=JSON.parse(ListData)
          console.log(this.List);
          // console.log(res);
          // this.List=res.data.List
          // console.log(this.List);
        })
      }
    },
}
</script>
<style lang="less" scoped>


</style>

