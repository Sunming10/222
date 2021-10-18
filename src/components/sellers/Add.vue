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
                      action="#"
                      list-type="picture-card"
                      :auto-upload="false">
                        <i slot="default" class="el-icon-plus"></i>
                        <div slot="file" slot-scope="{file}">
                          <img
                            class="el-upload-list__item-thumbnail"
                            :src="file.url" alt=""
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
                <el-form-item class="btn-position">
                  <el-button type="warning" @click="submitForm('ruleForm')" >保存</el-button>
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
      }
    }
  }

</script>

<style lang="less" scoped>
.btn-position{
  text-align: center;
}
</style>
