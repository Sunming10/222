<template>
  <el-container>
    <el-header>
      <el-button type="warning" style="margin-left:80%" @click="goto" :disabled="this.btnState=false">添加商品</el-button>
    </el-header>
    <el-main class="weizhi">
      <el-table
    :data="gridData"
    height="600"
    style="width: 100%;"
    stripe
    border>
    <!-- 商品编号 -->
    <el-table-column
      label="商品编号"
      width="150">
      <template slot-scope="scope">

        <span style="margin-left: 20px">{{ scope.row.item_id }}</span>
      </template>
    </el-table-column>

    <!-- 商品图片 -->
    <el-table-column
      label="商品图片"
      width="200">
      <template slot-scope="scope">

        <span><img :src="scope.row.goods_img" alt="" style="width:200px;height:100px"></span>
      </template>
    </el-table-column>

    <!-- 商品名称 -->
    <el-table-column
      label="商品名称"
      width="200">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.goods_discribe }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <!-- 商品价格 -->
     <el-table-column
      label="商品价格"
      width="100">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.goods_price }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <!-- 买家姓名 -->
     <el-table-column
      label="买家姓名"
      width="150">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.buyer_realname }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <!-- 买家联系方式 -->
     <el-table-column
      label="买家联系方式"
      >
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.buyer_phonenumber }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <!-- 买家地址 -->
     <el-table-column
      label="买家地址"
      >
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.buyer_address }}</p>

        </el-popover>
      </template>
    </el-table-column>

  <!-- 买家信息
    <el-table-column label="买家信息">
      <template>
        <template>
         <div>
            <el-popover
              placement="center"
              width="250"
              trigger="click"
              v-model="visible">
          <el-button type="text" @click="dialogVisible  = true">查看买家信息</el-button>


          </el-popover>
         </div>
        </template>

      </template>
    </el-table-column> -->

    <el-table-column label="操作"
    width="250">

        <template slot-scope="scope">
         <div>
            <el-popover
              placement="center"

              trigger="click"
              v-model="visible"
              >
          <el-button type="warning" size="medium" @click="recover(scope.row)">恢复</el-button>

          <el-button  @click="offShelf(scope.row)"  size="medium">完成交易</el-button>

          </el-popover>
         </div>
        </template>


    </el-table-column>
  </el-table>
    </el-main>
    <el-footer>
      <div class="block">
    <!-- <span class="demonstration">完整功能</span> -->
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

    <!-- <el-dialog title="买家信息" :visible.sync="dialogVisible ">
              <el-table :data="gridData">
                <el-table-column property="buyer_realname" label="买家姓名" width="150"></el-table-column>
                <el-table-column property="buyer_phonenumber" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="buyer_address" label="买家地址"></el-table-column>
              </el-table>
            </el-dialog> -->
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
      // List:[],
    }
  },
  created () {
    // this.handleGoodList()
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
            //   for(var i=0; i< this.itemLists.length;i++){
            //   this.item_id = this.itemLists[i].item_id;
            // }
              console.log(response.data.list[0]);
              console.log('123456');
              console.log(this.gridData[0].item_id);
        })
    },
    // 恢复
   recover(row) {

         console.log(row);
          this.itemId=row.item_id
          console.log("这是商品编号！");
          console.log( this.itemId);
          this.$http.post('/order/cancelOrder',{'seller_username':'admin','item_id': this.itemId
          }).then(res=>{
          // var ListData=JSON.stringify(res.data.goods);
          // console.log(ListData);
          //this.form=JSON.parse(ListData)
          // console.log(this.form);
          // this.form = res.data.goods
          console.log("这是恢复信息！");
          // console.log(this.itemId);
          console.log(res);
          this.$router.push('selling');
        })
          this.$message({
            type: 'success',
            message: '恢复成功!'
          });
        // }).catch(() => {
        //   this.$message({
        //     type: 'warning',
        //     message: '已取消'
        //   });
        // });
      },
    // 下架
    offShelf(row) {

        // this.$confirm('是否下架？', '提示', {
        //   confirmButtonText: '确定',
        //   cancelButtonText: '取消',
        //   type: 'warning'
        // }).then(() => {
          console.log(row);
          this.itemId=row.item_id
          console.log("这是商品编号！");
          console.log( this.itemId);
          this.$http.post('/order/finishOrder',{'seller_username':'admin','item_id': this.itemId
          }).then(res=>{
          // var ListData=JSON.stringify(res.data.goods);
          // console.log(ListData);
          //this.form=JSON.parse(ListData)
          // console.log(this.form);
          // this.form = res.data.goods
          console.log("这是下架信息！");
          // console.log(this.itemId);
          console.log(res);
          this.$router.push('history');

        })
          this.$message({
            type: 'success',
            message: '下架成功!'
          });
        // }).catch(() => {
        //   this.$message({
        //     type: 'warning',
        //     message: '已取消'
        //   });
        // });
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
     handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
      goto(){
        if(this.gridData.length==0){
          this.$router.push('add')

        }else{
            btnState=false
            this.$message({
            type: 'error',
            message: '您暂时不能添加商品!'
          });
        }

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
