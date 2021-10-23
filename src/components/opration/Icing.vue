<template>
  <el-container>
    <el-header>
      <el-button type="warning" style="margin-left:80%" @click="goto">添加商品</el-button>
    </el-header>
    <el-main class="weizhi">
      <el-table
    :data="gridData"
    style="width: 100%">
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

        <span><img :src="scope.row.item_img" alt=""></span>
      </template>
    </el-table-column>

    <!-- 商品名称 -->
    <el-table-column
      label="商品名称"
      width="200">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.item_name }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <!-- 商品价格 -->
     <el-table-column
      label="商品价格"
      width="150">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.item_price }}</p>

        </el-popover>
      </template>
    </el-table-column>

  <!-- 买家信息 -->
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
    </el-table-column>

    <el-table-column label="操作">

        <template>
         <div>
            <el-popover
              placement="center"
              width="250"
              trigger="click"
              v-model="visible">
          <el-button type="warning" size="medium" @click="recover">恢复</el-button>

          <el-button  @click="off_shelf"  size="medium">下架</el-button>

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
      :current-page="currentPage4"
      :page-sizes="[20, 40, 60, 80]"
      :page-size="20"
      layout="total, sizes, prev, pager, next, jumper"
      :total="100">
    </el-pagination>
  </div>
    </el-footer>

    <el-dialog title="买家信息" :visible.sync="dialogVisible ">
              <el-table :data="tableData">
                <el-table-column property="buyer_name" label="买家姓名" width="150"></el-table-column>
                <el-table-column property="buyer_tel" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="buyer_address" label="买家地址"></el-table-column>
              </el-table>
            </el-dialog>
  </el-container>

</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        buyer_name: 'Jennie',
        buyer_tel: '18375289147',
        buyer_address: '上海市普陀区金沙江路 1518 弄'
      },],
      gridData: [{
        item_id: '007',
        item_name: '小天才电话手表',
        item_price: '￥399.00',
        item_describe:'儿童电话手表智能GPS定位电信版多功能防水4g全网通咪咪兔男女孩小学生初高中生可插卡视频通话',
        item_img:'https://2c.zol-img.com.cn/product/214_120x90/588/cerBdmwpBi0E.jpg'
}],
      dialogTableVisible: false,
      dialogVisible: false,
      visible: false,
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
    },
    // 获取信息
    // data:$http.post('/goods/searchOffGoods').then(response=>{
    //     console.log(response);
    // })
    // ,
    fetchData(){
        $http.post('/goods/searchOffGoods',this.gridData).then(response=>{
              console.log(response);
              this.gridData=response.data
        })
    },
    async getGoodList(){
      const{data:res}=await this.$http.post('/goodssearchOffGoods')
      console.log(res);
    },
    // 恢复
   recover() {
        this.$confirm('是否将商品恢复上架？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '上架成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          });
        });
      },
    // 下架
    off_shelf() {
        this.$confirm('是否下架？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '下架成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          });
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
     handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
      goto(){
        this.$router.push('add')
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
