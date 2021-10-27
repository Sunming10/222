<template>
  <el-container>
    <template>
      <div class="position">
                      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="商品名称" prop="item_name">
                  <el-input v-model="ruleForm.item_name" type="text"></el-input>
                </el-form-item>
                <el-form-item label="商品描述" prop="item_describe">
                  <el-input type="textarea" v-model="ruleForm.item_describe"></el-input>
                </el-form-item>
                 <el-form-item label="商品价格" prop="item_price">
                  <el-input v-model="ruleForm.item_price" type="text"></el-input>
                </el-form-item>

                <el-form-item prop="goods_img" label="商品图片">
          <el-upload
            ref="uploadImage"
            :action="imgUrl"
            :beforeUpload="beforeUploadPicture"
            :on-change="imageChange"
            list-type="picture-card"
            name="files"
            :limit="1"
            multiple
            :auto-upload="false"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemovePicture">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>


                <el-form-item class="btn-position">
                  <el-button type="warning" @click="submitForm()" >保存</el-button>
                  <el-button type="warning" @click="resetForm('ruleForm')" >重置</el-button>
                  <!-- <el-button type="warning" round>取消</el-button> -->
                </el-form-item>
              </el-form>
      </div>
    </template>

  </el-container>
</template>

<script>
export default {
     data() {
      return {
       dialogImageUrl: '',
        dialogVisible: false,
        disabled: false,
        itemLists:[],
        ListData:[],
        ruleForm:[ {
          item_name: '',
          item_describe: '',
          item_price: '',
        }],
        rules: {
          item_name: [
            { required: true, message: '请输入商品名称', trigger: 'blur' },
            { min:2, max: 20, message: '长度在 2 到 20个字符', trigger: 'blur' }
          ],
          item_describe: [
            { required: true, message: '请输入商品描述', trigger: 'blur' }
          ],
          item_price: [
            { required: true, message: '请输入商品价格', trigger: 'blur' }
          ],
           item_img: [
            { required: true, message: '请上传图片', trigger: 'blur' }
          ]
        },
      images: {},
      files: [],
      imgUrl:'http://localhost:8082'+'/qiniu/image',
      dialogImageUrl: '',
      dialogVisible: false
      };
    },
    created () {
      // this.getGoods();
    },
    methods: {
      beforeUploadPicture(file){
     const isImage = file.type == 'image/png' || file.type == 'image/jpg' ||  file.type == 'image/jpeg' || file.type == 'image/bmp' || file.type == 'image/gif' || file.type == 'image/webp';
      const isLt2M = file.size <  1024 * 1024 * 2;
      if (!isImage) {
        this.$message.error('上传只能是png,jpg,jpeg,bmp,gif,webp格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB!');
      }
      return isImage && isLt2M;
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleRemovePicture(file, fileList) {
      console.log(file, fileList);
    },
    imageChange(file, fileList, name) {
      console.log(file, fileList);
      this.imageList = fileList;
      this.images['images'] = fileList;
    },

    handleRemoveFile(file, fileList) {
      console.log(file, fileList);
    },
    handlePreviewFile(file) {
      console.log(file);
    },
    handleExceedFile(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemoveFile(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
    },
    fileChange(file,fileList) {
      console.log(file, fileList);
      this.fileList = fileList;
      this.files['files'] = fileList;
 },
    submitForm(){
          let wfForm = new FormData();
          let config = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                };
          wfForm.append( 'goods_name',this.ruleForm.item_name)
          wfForm.append( 'goods_price',this.ruleForm.item_price)
          wfForm.append( 'goods_dicsribe',this.ruleForm.item_describe)
          Object.entries(this.images).forEach(file => {
            file.forEach(item => {
              // 下面的“images”，对应后端需要接收的name，这样对图片和文件做一个区分，name为images为图片
              wfForm.append('goods_img', item.raw)
              // wfForm.append(item.name, file[0])
            })
          })
          console.log(wfForm);
          this.$http.post('/goods/addGoods',wfForm,config).then( res => {
            console.log(res, 'res')
            if(res.message === "success"){
              this.$message.success( '添加商品成功！' );
              this.handleClose()
            }else{
                  this.$message.error( '添加商品失败！' );
            }
          })
    }

    }
  }

</script>

<style lang="less" scoped>
.btn-position{
  text-align: center;
}
.position{
  // text-align: center;
  margin-left: 18%;
  margin-top: 20px;
  width: 700px;

}
</style>
