<template>
  <el-container>
   <el-main>
      <div style="width:700px">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" enctype="multipart/form-data" >
          <el-form-item label="商品名称" prop="goods_name">
            <el-input v-model="ruleForm.goods_name"></el-input>
          </el-form-item>
          <el-form-item label="商品价格" prop="goods_price">
            <el-input v-model="ruleForm.goods_price"></el-input>
          </el-form-item>
          <el-form-item label="商品描述" prop="goods_discribe">
            <el-input v-model="ruleForm.goods_discribe" type="textarea"></el-input>
          </el-form-item>
          <el-form-item label="商品图片" prop="goods_img">
            <el-upload class="avatar-uploader showUploader"
                accept=".gif,.jpg,.jpeg,.png,.GIF,.JPG,.PNG"
                ref="businessLicense"
                :action='imgUrl'
                :on-success="handleSuccess"
                :before-upload="beforeAvatarUpload"
                :limit="1">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
      </el-form>
      </div>
      <el-header class="btnPosition">
         <el-button @click="submit" type=warning>提交</el-button>
         <el-button @click="reset">重置</el-button>
      </el-header>
   </el-main>
  </el-container>
</template>

<script>
export default {
  data(){
    return{
        files: {},
        photo: '',
        photoObj: '',
        imgUrl:'http://souldays.top:8082/qiniu/image',
        imageUrl:'',
        loge:'',
        dialogVisible:false,
        myHeaders: {

        },
        ruleForm:{
          goods_name:'',
          goods_price:'',
          goods_discribe:'',
          goods_img:''
        },
        rules:{
            goods_name: [
            { required: true, message: '请输入商品名称', trigger: 'blur' },
            { min:2, max:20, message: '商品名称长度在2~20个字之间', trigger: 'blur' }
          ],
          goods_price: [
            { required: true,message: '请输入正确商品价格', trigger: 'blur'  },
            { pattern:/^(([1-9]{1}\d*)|(0{1}))(\.\d{2})$/,required: true,message: '请正确输入价格(保留两位小数)'}
          ],
          goods_discribe: [
            { required: true, message: '请输入商品描述', trigger: 'blur' },
            { min:2, max:100, message: '字数控制在100字以内', trigger: 'blur' }
          ],
          goods_img: [
            { required: true, message: '请上传图片', trigger: 'blur' },
          ],
        }
    }
},
methods: {
  handleSuccess(res) {
    console.log("这是图片链接："+res);
    this.imageUrl=res
    console.log("图片链接在哪里？");
    console.log(this.imageUrl);
  },
  reset(){
      this.$refs.ruleForm.resetFields()
  },
       handlePreview(res) {
        console.log(res);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      beforeAvatarUpload(file) {
      const isLt50M = file.size / 1024 / 1024 < 0.5;
      if (!isLt50M) {
        this.$message({
          message: "上传文件大小不能超过500KB!",
          type: "error"
        });
      }
      return isLt50M;
    },
      submit(){
        this.ruleForm.goods_img=this.imageUrl
        // console.log(this.ruleForm.goods_img);
        // console.log("start");
        if(this.ruleForm.goods_name!=''&&this.ruleForm.goods_price!=''&&this.ruleForm.goods_discribe!=''&&this.ruleForm.goods_img!=''){
          this.$http.post('/goods/addGoods',{'goods_name':this.ruleForm.goods_name,'goods_price':this.ruleForm.goods_price,
              'goods_discribe':this.ruleForm.goods_discribe,'goods_img':this.ruleForm.goods_img})
        .then(res=>{
          // console.log(res);
          // console.log(res.data);
          if(res.data.message=='success'){
             this.$message({
                    type: 'success',
                    message: '商品添加成功!'});
                    this.$router.push('selling')

          }else if(res.data.message=='error'){
             this.$message({
                    type: 'error',
                    message: '商品添加失败!'});
          }
        })
        }else{
           this.$message({
                    type: 'error',
                    message: '请完善信息!'});
          }
          console.log("end");
        }

      },

}

</script>
<style lang="less" scoped>
.avatar-uploader /deep/ .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    background-color: #fff;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    width: 180px;
    height: 180px;
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
  .showUploader /deep/ .el-upload-list{
    display: none;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .btnPosition{
    margin-left: 20%;
  }
</style>
