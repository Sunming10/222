<template>
  <el-container>
    <el-header>
    </el-header>
    <el-main class="weizhi">
      <el-table
    :data="gridData"
    height="600"
    style="width: 100%;"
    stripe >
    <!-- 商品编号 -->
    <el-table-column
      label="商品编号"
      width="150"
      prop="item_id">
    </el-table-column>

    <!-- 商品图片 -->
    <el-table-column
      label="商品图片"
      width="250"
      prop="goods_img">
    <template   slot-scope="scope">
      <img :src="scope.row.goods_img"  min-width="200" height="100" />
    </template>
    </el-table-column>

    <!-- 商品名称 -->
    <el-table-column
      label="商品名称"
      width="200"
       prop="goods_name">
    </el-table-column>
    <!-- 商品价格 -->
     <el-table-column
      label="商品价格"
      width="100"
       prop="goods_price">
    </el-table-column>
    <!-- 买家姓名 -->
     <el-table-column
      label="买家姓名"
      width="150"
      prop="buyer_realname">
    </el-table-column>
    <!-- 买家联系方式 -->
     <el-table-column
      label="买家联系方式"
       width="200"
       prop="buyer_phonenumber">
    </el-table-column>
    <!-- 买家地址 -->
     <el-table-column
      label="买家地址"
       width="200"
       prop="buyer_address">
    </el-table-column>
<!-- 操作 -->
    <el-table-column label="操作"
    width="250">
        <template slot-scope="scope">
          <el-button type="warning" size="medium" @click="recover(scope.row)">恢复</el-button>

          <el-button  @click="offShelf(scope.row)"  size="medium">完成交易</el-button>
        </template>
    </el-table-column>
  </el-table>
    </el-main>
    <el-footer>
      <div class="block">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10]"
      :page-size="pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="this.gridData.length">
    </el-pagination>
  </div>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      gridData: [],
      dialogTableVisible: false,
      dialogVisible: false,
      visible: false,
      currentPage:1,
      pagesize:10,
      itemId:'',
      btnState:true,
    }
  },
  created () {
    this.fetchData()
    this.tableData= this.$route.query.itemIcing.order
    console.log(this.$route.query.itemIcing.order);
    console.log(this.tableData);
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

    // 加载冻结商品
      fetchData(){
        this.$http.post('/goods/searchFreezingGoods',{'seller_username':'admin','page':this.currentPage}).then(response=>{
              console.log(response);
              this.gridData=response.data.list
        })
    },
    // 恢复
   recover(row) {

         console.log(row);
          this.itemId=row.item_id
          this.$http.post('/order/cancelOrder',{'seller_username':'admin','item_id': this.itemId
          }).then(res=>{
          this.$router.push('selling');
        })
          this.$message({
            type: 'success',
            message: '恢复商品成功!'
          });
      },
    // 下架
    offShelf(row) {
          this.itemId=row.item_id
          this.$http.post('/order/finishOrder',{'seller_username':'admin','item_id': this.itemId
          }).then(res=>{
          this.$router.push('history');

        })
          this.$message({
            type: 'success',
            message: '恭喜你成功完成交易!'
          });
      },
    // 取消
    close() {
      this.$confirm('是否取消?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'warning',
          message: '操作成功！'
        })
      }).catch(() => {
        this.$message({
          type: 'warning',
          message: '已取消'
        })
      })
    },
    },
  }


</script>

<style lang="less" scoped>
.weizhi{
  padding: 8px;
  margin-top: -27px;
}
</style>
