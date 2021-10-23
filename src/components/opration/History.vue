<template>
  <el-container>
    <el-main>
              <el-table :data="tableData" height="550">
                <el-table-column property="item_id" label="商品编号" width="100"></el-table-column>
                <el-table-column property="item_name" label="商品名称" width="100"></el-table-column>
                <el-table-column property="item_price" label="商品价格" width="100"></el-table-column>
                   <el-table-column property="item_describe" label="商品描述" width="200"></el-table-column>
                      <el-table-column property="item_picture" label="商品图片" width="150">
                        <template slot-scope="scope">
                          <span>
                            <img :src="scope.row.item_picture" style="width:120px;height:100px;">
                          </span>
                        </template>
                      </el-table-column>
                <el-table-column property="order_number" label="订单编号" width="100"></el-table-column>
                <el-table-column property="buyer_name" label="买家姓名" width="100"></el-table-column>
                <el-table-column property="buyer_tel" label="买家联系方式" width="150"></el-table-column>
                <el-table-column property="trad_address" label="交易地址" width="250"></el-table-column>
                 <el-table-column property="trad_time" label="交易时间" width="200"></el-table-column>

              </el-table>
</el-main>
<el-footer>
 <div class="block">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[10, 20, 30, 40]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="40">
    </el-pagination>
  </div>
  </el-footer>
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
        item_describe:'      双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。',
        item_picture:'https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      },
      {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        item_describe:'      双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。',
        item_picture:'https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      },
      {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        item_describe:'      双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。',
        item_picture:'https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      },
      {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        item_describe:'      双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。',
        item_picture:'https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      },
      {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        item_describe:'      双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。',
        item_picture:'https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      },
      {
        item_id: '001',
        item_name: '王小虎',
        item_price: '1299',
        item_describe:'      双AI慧眼，一体式桌面设计。前置1300万智能升降摄像头和800万交互摄像头，双摄像头各司其职，辅助孩子解决学习难题。配有18W独立音箱，支持4麦克风降噪，拾音清晰，上网课更方便。',
        item_picture:'https://iconfont.alicdn.com/t/5d5f7473-d557-4dd3-b497-7c25bca1eb13.png',
        order_number:'123',
        buyer_name:'nice_nikki',
        buyer_tel:'18375289147',
        trad_address:'浙江工商大学钱江湾生活区',
        trad_time:'2021-09-19',
      }],
       currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4,
      gridData: [{
        buyer_name: '007',
        buyer_tel: '18375289147',
        buyer_address: '浙江工商大学钱江湾生活区'
      }],
    }
  },
    methods: {
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
}
</script>
<style lang="less" scoped>
.el-main{
  width: 80%;
  // height: 80%;
  position: absolute;
}
div{
  .block{
    position: absolute;
    margin-top: 589px;
    margin-left: 600px;
  }
}
</style>

