<template>
  <el-container>
    <!-- 头部内容 -->
     <!-- 添加商品页 -->
     <el-dialog title="商品添加" :visible.sync="dialogFormVisible" destroy-on-close>
              <el-form :model="submitform" :rules="rules">
                <el-form-item label="商品名称" :label-width="formLabelWidth" prop="name">
                  <el-input v-model="submitform.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="活动价格" :label-width="formLabelWidth" prop="price">
                  <el-input v-model="submitform.price" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商品详情" :label-width="formLabelWidth" prop="describe">
                  <el-input type="textarea" v-model="submitform.contain" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商品图片" :label-width="formLabelWidth">
                  <el-upload
                    class="avatar-uploader"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload"
                    v-model="imageUrl1">
                    <img v-if="imageUrl1" :src="imageUrl1" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                  </el-upload>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false" round>取 消</el-button>
              <el-button type="warning" round @click="dialogFormVisible = false">添 加</el-button>
              </div>
          </el-dialog>
    <el-header>
      <span class="font-style">商品列表</span>
      <!-- 按钮 -->
      <el-button @click="add" icon="el-icon-plus" type="warning" round class="btn-position">添加商品</el-button>

    </el-header>
  <el-row>
    <el-col :span="6" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">
      <el-card :body-style="{ padding: '0px' }">
        <img src="https://2c.zol-img.com.cn/product/214_120x90/588/cerBdmwpBi0E.jpg" class="image">
        <div style="padding: 15px;">
          <div class="font-style1">{{itemContain.item_name}}</div>
          <div class="font-style2">{{itemContain.item_price}}</div>
          <div class="bottom clearfix">
            <el-button type="warning" round @click="detail">商品详情</el-button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="warning" round @click="dialogTableVisible = false">意向买家</el-button>

          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
 <!-- 商品详情页 -->
            <el-dialog title="商品详情" :visible.sync="dialogFormVisible" append-to-body>
              <el-form :model="form" :rules="rules">
                <el-form-item label="商品名称" :label-width="formLabelWidth" prop="name">
                  <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="活动价格" :label-width="formLabelWidth" prop="price">
                  <el-input v-model="form.price" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商品详情" :label-width="formLabelWidth" prop="describe">
                  <el-input type="textarea" v-model="form.contain" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="商品图片" :label-width="formLabelWidth">
                  <el-upload
                    class="avatar-uploader"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload"
                    v-model="imageUrl">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                  </el-upload>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false" round>取 消</el-button>
              <el-button type="warning" round @click="dialogFormVisible = false">修改</el-button>
              </div>
          </el-dialog>
          <!-- 意向买家信息 -->
          <el-dialog title="意向买家信息" :visible.sync="dialogTableVisible " append-to-body>
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
  </el-container>
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
      }
    },
    data() {
      return {
        // currentPage4: 4,
        currentDate: new Date(),
        dialogFormVisible: false,
        formLabelWidth: '100px',
        imageUrl: require('./image/computer.jpg'),

        itemContain:{
          item_name:"华为双AI慧眼学习智慧屏",
          item_price:"￥2199.00"
        },
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
        gridData: [{
        buyer_name: '007',
        buyer_tel: '18375289147',
        buyer_address: '浙江工商大学钱江湾生活区'
      },
      ],

        itemDetails:[{
          item_name:"华为双AI慧眼学习智慧屏",
          item_price:"Y2199.00",
          item_describe:"华为双AI慧眼学习智慧屏华为双AI慧眼学习智慧屏华为双AI慧眼学习智慧屏",
          item_picture:require('./image/computer.jpg'),
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

