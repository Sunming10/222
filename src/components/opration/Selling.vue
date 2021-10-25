<template>

  <el-container>
    <el-header>
      <span style="font-size:18px;color:gray;font-weight:bold;">商品列表</span>

</el-header>

    <el-main>
      <el-row>
  <el-col :span="6" v-for="(item,index) in form" :key="item" :offset="index > 0 ? 1 : 0">

      <el-card :body-style="{ padding: '0px' }" style="text-align: center;text-decoration:none" >

      <img  :src="item.goods_img" class="image" @click="toDetail">

      <div style="text-align: center;">
        <span class="font-style">{{item.goods_name}}</span>
        <div class="word"><span class="price">￥{{item.goods_price}}</span></div>
        <div class="bottom clearfix ">
          <!-- <time class="time">{{ currentDate }}</time> -->
          <el-button type="text" class="button"  @click="dialogFormVisible = true">编辑商品</el-button>
        </div>
      </div>
    </el-card>

  </el-col>
</el-row>
    </el-main>
    <el-footer style="margin-left: 57%;margin-top: 14%;">
      <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10]"
       :page-size="pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="this.form.length">
    </el-pagination>
    </el-footer>
<el-dialog title="编辑商品" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    <el-form-item label="商品名称" :label-width="formLabelWidth">
      <el-input v-model="form.goods_name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="商品价格" :label-width="formLabelWidth">
      <el-input v-model="form.goods_price" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="商品描述" :label-width="formLabelWidth">
      <el-input v-model="form.goods_discribe" type="textarea" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="商品图片" :label-width="formLabelWidth">
      <!-- <el-input v-model="form.name" autocomplete="off"></el-input> -->

      <el-upload
        action="#"
        list-type="picture-card"
        :auto-upload="false"
        :file-list="form.goods_img"
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
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      formLabelWidth: '100px',
      currentPage: 1,
      currentDate: new Date(),
      dialogFormVisible: false,
      pagesize:5,
       form:[],

    };

  },
   created() {
        this.handleGoodList();
        console.log(this.$route)
        this.form=this.$route.query.form,
        this.form.item_id=this.$route.query.form.item_id
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

        this.$http.post('/goods/searchSellingGoods', {'page': this.currentPage 
        }).then(res=>{
          var ListData=JSON.stringify(res.data.goods);
          // console.log(ListData);
          this.form=JSON.parse(ListData)
          // console.log(this.form);
        })
      },
      toDetail(){
         this.$http.post('/goods/searchSellingGoods', {'page': this.currentPage 
        }).then(res=>{
          var ListData=JSON.stringify(res.data.goods);
          // console.log(ListData);
          this.form=JSON.parse(ListData)
          // console.log(this.form);
          this.$router.push({

            path: 'detail',
            query:{
              item_id:this.form.item_id,
             itemDetail:this.form
            }
         });
        })

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
