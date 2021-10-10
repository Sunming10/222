<template>
  <el-container>
    <template>
      <div>
                      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="商品名称" prop="name">
                  <el-input v-model="ruleForm.item_name" type="text"></el-input>
                </el-form-item>
                <el-form-item label="商品描述" prop="desc">
                  <el-input type="textarea" v-model="ruleForm.item_describe"></el-input>
                </el-form-item>
                 <el-form-item label="商品价格" prop="name">
                  <el-input v-model="ruleForm.item_price" type="text"></el-input>
                </el-form-item>
                <el-form-item label="商品图片">
                    <el-upload
                    class="upload-demo"
                    drag
                    action="https://jsonplaceholder.typicode.com/posts/"
                    multiple>
                    <i class="el-icon-upload"></i>
                    <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                    <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
                  </el-upload>
          </el-form-item>
                <el-form-item class="btn-position">
                  <el-button type="warning" @click="submitForm('ruleForm')" round >上传</el-button>
                  <el-button type="warning" @click="resetForm('ruleForm')" round>重置</el-button>
                  <el-button type="warning" round>取消</el-button>
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
        ruleForm: {
          item_name: '',
          item_describe: '',
          item_price: '',
          item_img:''
        },
        rules: {
          item_name: [
            { required: true, message: '请输入商品名称', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
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
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('请完善信息！');
          } else {
            console.log('错误提交!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }

</script>

<style lang="less" scoped>
.btn-position{
  text-align: center;
}
</style>
