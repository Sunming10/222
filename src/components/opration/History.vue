<template>
  <el-container>
    <template>
    <el-table
    :data="tableData"
    style="width: 100%">
    <!-- 商品编号 -->
    <el-table-column
      label="订单编号"
      width="250">
      <template slot-scope="scope">

        <span style="margin-left: 10px">{{ scope.row.order_number }}</span>
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
          <el-button type="warning" round size="medium" @click="dialogTableVisible  = true">查看交易信息</el-button>
          <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="warning" size="medium" round>删除</el-button>
            <el-dialog title="交易信息" :visible.sync="dialogTableVisible ">
              <el-table :data="tableData">
                <el-table-column property="item_id" label="商品编号" width="100"></el-table-column>
                <el-table-column property="item_name" label="商品名称" width="100"></el-table-column>
                <el-table-column property="item_price" label="商品价格" width="100"></el-table-column>
                <el-table-column property="order_number" label="订单编号" width="100"></el-table-column>
                <el-table-column property="buyer_name" label="买家姓名" width="100"></el-table-column>
                <el-table-column property="buyer_tel" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="trad_address" label="交易地址" width="250"></el-table-column>
                 <el-table-column property="trad_time" label="交易时间" width="200"></el-table-column>

              </el-table>
            </el-dialog>

          </el-popover>
         </div>
        </template>

      </template>
    </el-table-column>
  </el-table>
  </template>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',



      }, {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      }, {
         item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      }, {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
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
