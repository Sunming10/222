<template>
<div>
    <!-- 头部内容 -->
    <el-header>
      <span class="font-style">商品列表</span>
    </el-header>
  <el-row>
    <el-col :span="6" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
      <el-card :body-style="{ padding: '0px' }">
        <img src="https://2c.zol-img.com.cn/product/214_120x90/588/cerBdmwpBi0E.jpg" class="image">
        <div style="padding: 15px;">
          <div class="font-style1">{{itemContain.item_name}}</div>
          <div class="font-style2">{{itemContain.item_price}}</div>
          <div class="bottom clearfix">
            <el-button type="warning" round @click="dialogTableVisible  = true">查看历史商品</el-button>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
                              <!-- 历史商品详情页 -->
    <el-dialog title="历史商品详情" :visible.sync="dialogTableVisible "  append-to-body>
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


          </el-popover>
         </div>
        </template>

      </template>
    </el-table-column>
  </el-table>
    </el-dialog>
    <el-dialog title="交易信息" :visible.sync="dialogTableVisible " :modal=append-to-body>
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
</div>


</template>
<script>
  export default {
    methods: {
      handleAvatarSuccess(res, file) {
        this.imageUrl = URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      add(){
        this.dialogFormVisible = true;
      },
      detail(){
        this.dialogFormVisible = true;
      },
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

    },
    data() {
      return {
        // currentPage4: 4,
        currentDate: new Date(),
        dialogFormVisible: false,
        dialogTableVisible :true,
        formLabelWidth: '100px',
        imageUrl: require('./image/computer.jpg'),

        itemContain:{
          item_name:"华为双AI慧眼学习智慧屏",
          item_price:"￥2199.00"
        },
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
      visible: false,

         form: {
          name: '华为双AI慧眼学习智慧屏',
          price: '￥2199.00',
          contain: '华为双AI慧眼学习智慧屏华为双AI慧眼学习智慧屏华为双AI慧眼学习智慧屏',
          image: require('./image/computer.jpg'),
        },
        submitform: {
          name: '',
          price: '',
          contain: '',
          image: '',
        },

        itemDetails:[{
          item_name:"华为双AI慧眼学习智慧屏",
          item_price:"Y2199.00",
          item_describe:"华为双AI慧眼学习智慧屏华为双AI慧眼学习智慧屏华为双AI慧眼学习智慧屏",
          item_picture:require('./image/computer.jpg'),
        },],
        tableData: [{
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',



      },],
         rules: {
          name: [
            { required: true, message: '请输入商品名称！', trigger: 'blur' },
          ],
          price: [
            { required: true, message: '价格不能为空！'},
            { type: 'number', message: '价格必须为数字值'}
          ],
          describe: [
            { required: true, message: '请填写商品描述！', trigger: 'blur' }
          ],
        }
      };
    }

  }
</script>
<style lang="less" scoped>
 .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
    padding: 7px;
    text-align: center;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 80%;
    display: block;
    margin: auto;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }

  .clearfix:after {
      clear: both
  }
  .font-style{
    font-size: 24px;
    font-family: 'Arial Normal','Arial';
    color: #999;
    font-weight: bold;

  }
  .font-style1{
    font-family: 'Arial Normal','Arial';
    font-size: 20px;
    font-weight: bold;
    color: rgb(194, 189, 189);
    text-align: center;
  }
  .font-style2{
    font-family: 'Arial Normal','Arial';
    font-size: 18px;
    font-weight: bold;
    color: red;
    text-align: center;
    line-height: 41px;
  }
  .el-header{
     line-height: 60px;
  }
  .btn-position{
    margin-left: 80%;
  }
   .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>

