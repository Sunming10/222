<template>
  <el-container>
    <!-- <template> -->
    <el-table
    :data="tableData"
    style="width: 100%">
    <!-- 商品编号 -->
    <el-table-column
      label="商品编号"
      width="250">
      <template slot-scope="scope">

        <span style="margin-left: 10px">{{ scope.row.item_id }}</span>
      </template>
    </el-table-column>
    <!-- 商品名称 -->
    <el-table-column
      label="商品名称"
      width="250">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.item_name }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <!-- 商品价格 -->
     <el-table-column
      label="商品价格"
      width="250">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p> {{ scope.row.item_price }}</p>

        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <template>
         <div>
            <el-popover
              placement="center"
              width="250"
              trigger="click"
              v-model="visible">
          <el-button type="warning" round size="medium" @click="dialogTableVisible  = true">查看意向卖家信息</el-button>
          <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="warning" size="medium" round>删除</el-button>
            <el-dialog title="意向买家信息" :visible.sync="dialogTableVisible ">
              <el-table :data="gridData">
                <el-table-column property="buyer_name" label="买家姓名" width="150"></el-table-column>
                <el-table-column property="buyer_tel" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="buyer_address" label="买家地址"></el-table-column>
                <el-table-column property="seller_operation" label="操作">
                  <el-button type="warning" round @click="open" size="mini">同意</el-button>
                   <el-button @click="close" type="warning" size="mini" round>取 消</el-button>
                </el-table-column>
              </el-table>
            </el-dialog>

          </el-popover>
         </div>
        </template>

      </template>
    </el-table-column>
  </el-table>
  <!-- </template> -->
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        item_id: '001',
        item_name: '王小虎',
        item_price: '上海市普陀区金沙江路 1518 弄'
      }, {
        item_id: '001',
        item_name: '王小虎',
        item_price: '上海市普陀区金沙江路 1518 弄'
      }, {
        item_id: '001',
        item_name: '王小虎',
        item_price: '上海市普陀区金沙江路 1518 弄'
      }, {
        item_id: '001',
        item_name: '王小虎',
        item_price: '上海市普陀区金沙江路 1518 弄'
      }],
      gridData: [{
        buyer_name: '007',
        buyer_tel: '18375289147',
        buyer_address: '浙江工商大学钱江湾生活区'
      }, {
        buyer_name: '007',
        buyer_tel: '18375289147',
        buyer_address: '浙江工商大学钱江湾生活区'
      }, {
        buyer_name: '007',
        buyer_tel: '18375289147',
        buyer_address: '浙江工商大学钱江湾生活区'
      }, {
        buyer_name: '007',
        buyer_tel: '18375289147',
        buyer_address: '浙江工商大学钱江湾生活区'
      }],
      dialogTableVisible: false,
      dialogVisible: false,
      visible: false
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
    },
    // 同意
    open() {
      this.$confirm('是否同意该用户？', '提示', {
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
    // 删除
    deleteRow(index, rows) {
      rows.splice(index, 1)
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
    }
  }
}

</script>

<style lang="less" scoped>
</style>
