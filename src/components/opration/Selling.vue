<template>

  <el-container>
    <el-header>
      <span style="font-size:18px;color:gray;font-weight:bold;">商品列表</span>

</el-header>

    <el-row>
  <el-col :span="6" v-for="(o, index) in 1" :key="o" :offset="index > 0 ? 1 : 0">

      <el-card :body-style="{ padding: '0px' }" style="text-align: center;text-decoration:none">
         <router-link to="detail">
      <img  src="https://2c.zol-img.com.cn/product/214_120x90/588/cerBdmwpBi0E.jpg" class="image">
       </router-link>
      <div style="text-align: center;">
        <span class="font-style">华为智慧屏</span>
        <div class="word"><span class="price">￥2199.00</span></div>
        <div class="bottom clearfix ">
          <!-- <time class="time">{{ currentDate }}</time> -->
          <el-button type="text" class="button"  @click="dialogFormVisible = true">编辑商品</el-button>
        </div>
      </div>
    </el-card>

  </el-col>
</el-row>
<el-dialog title="编辑商品" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    <el-form-item label="商品名称" :label-width="formLabelWidth">
      <el-input v-model="form.item_name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="商品价格" :label-width="formLabelWidth">
      <el-input v-model="form.item_price" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="商品描述" :label-width="formLabelWidth">
      <el-input v-model="form.item_describe" type="textarea" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="商品图片" :label-width="formLabelWidth">
      <!-- <el-input v-model="form.name" autocomplete="off"></el-input> -->

      <el-upload
        action="#"
        list-type="picture-card"
        :auto-upload="false"
        :file-list="form.item_img"
        :limit="1"
        :on-exceed="handleExceed"
        :before-remove="beforeRemove">
          <i slot="default" class="el-icon-plus"></i>
          <div slot="file" slot-scope="{file}">
            <img
              class="el-upload-list__item-thumbnail"
              :src="file.url"
            >
            <span class="el-upload-list__item-actions">
              <span
                class="el-upload-list__item-preview"
                @click="handlePictureCardPreview(file)"
              >
                <i class="el-icon-zoom-in"></i>
              </span>
              <span
                v-if="!disabled"
                class="el-upload-list__item-delete"
                @click="handleDownload(file)"
              >
                <i class="el-icon-download"></i>
              </span>
              <span
                v-if="!disabled"
                class="el-upload-list__item-delete"
                @click="handleRemove(file)"
              >
                <i class="el-icon-delete"></i>
              </span>
            </span>
          </div>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>

    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="warning" @click="dialogFormVisible = false">确 定</el-button>
  </div>
</el-dialog>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      currentDate: new Date(),
      dialogFormVisible: false,
       form: {
          item_name: '华为智慧屏',
          item_price: '2199.00',
          item_describe: '这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑这是电脑',
          item_img:[{
            name:'computer.jpg',
            url:"https://iconfont.alicdn.com/t/e89430ee-42ed-4d98-8ea2-6987122dc98a.png"}],

        },
        dialogImageUrl: '',
        dialogVisible: false,
        disabled: false,
        formLabelWidth: '100px'
    };

  }, methods: {
      change(){
         this.$router.push('detail');
      },
      handleRemove(file) {
        console.log(file);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handleDownload(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
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
  .el-input{
    width: 88%;
  }
  .el-textarea{
    width: 88%;
  }

  .image {
    width: 70%;
    display: block;
    margin-left: 15%;
  }
  .font-style{
    font-size: 16px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    /* text-decoration: none; */
  }
  .price{
    font-size: 16px;
    color: red;
    /* padding: 5px 0; */
    /* text-decoration: none; */
  }
  .word{
    margin: 5px 0;
    /* text-decoration: none; */
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
    /* font-w; */
}
</style>
