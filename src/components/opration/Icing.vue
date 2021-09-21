<template>
  <el-container>
    <!-- <template> -->
    <el-table
    :data="gridData"
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
      <template slot-scope="scope">
        <template>
         <div>
            <el-popover
              placement="center"
              width="250"
              trigger="click"
              v-model="visible">
          <el-button type="warning" round size="medium" @click="dialogTableVisible  = true">恢复</el-button>
          <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="warning" size="medium" round>下架</el-button>
           <el-dialog title="编辑商品" :visible.sync="dialogTableVisible">
                  <el-table :data="gridData">
                    <el-table-column property="item_id" label="商品编号" width="50"></el-table-column>
                    <el-table-column property="item_name" label="商品名称" width="100"></el-table-column>
                    <el-table-column property="item_price" label="商品价格" width="50"></el-table-column>
                    <el-table-column property="item_describe" label="商品描述" width="150"></el-table-column>
                    <el-table-column property="item_img" label="商品图片">

                    </el-table-column>
                    <el-table-column property="seller_operation" label="操作">
                      <el-button type="warning" round @click="open" size="mini">保存</el-button>
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
  <el-dialog title="买家信息" :visible.sync="dialogVisible ">
              <el-table :data="tableData">
                <el-table-column property="buyer_name" label="买家姓名" width="150"></el-table-column>
                <el-table-column property="buyer_tel" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="buyer_address" label="买家地址"></el-table-column>
              </el-table>
            </el-dialog>
  <!-- </template> -->
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
      }, {
        buyer_name: 'Jennie',
        buyer_tel: '18375289147',
        buyer_address: '上海市普陀区金沙江路 1518 弄'
      }, {
        buyer_name: 'Jennie',
        buyer_tel: '18375289147',
        buyer_address: '上海市普陀区金沙江路 1518 弄'
      }, {
        buyer_name: 'Jennie',
        buyer_tel: '18375289147',
        buyer_address: '上海市普陀区金沙江路 1518 弄'
      }],
      gridData: [{
        item_id: '007',
        item_name: '小天才电话手表',
        item_price: '￥399.00',
        item_describe:'儿童电话手表智能GPS定位电信版多功能防水4g全网通咪咪兔男女孩小学生初高中生可插卡视频通话',
        item_img:'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/3100173737/O1CN015yr2J71dTakraYOWp_!!3100173737.jpg_60x60q90.jpg'
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
      this.$confirm('是否恢复该商品？', '提示', {
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
