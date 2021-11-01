<template>
  <el-container class="home-container">
    <!-- 头部区域 -->
    <el-header>
      <div>
        <img src="https://iconfont.alicdn.com/t/be0fa091-076f-47da-8d04-9cf81d8252ad.png" alt="网上商城">
        <!-- <span>网上商城</span> -->
      </div>
      <el-button type="warning"  @click="logout" icon="el-icon-user" class="font-line">退出登陆</el-button>
    </el-header>
    <!-- 页面主体区域 -->
    <el-container>
      <!-- 左侧内容主体 -->
              <el-col :span="4">
            <el-menu
              default-active="2"
              background-color="rgba(255, 186, 51, 1)"
              text-color="#333333"
              active-text-color="#ffffff">
              <el-submenu index="1">
                 <template slot="title">
                  <i class="iconfont">&#xe626;</i>
                  <router-link to="selling" style="text-decoration: none;color:#fff;"><span class="line" >商品操作</span> </router-link>
                </template>
                <el-menu-item-group>
                  <template slot="title"></template>
                  <router-link to='selling' style=" text-decoration: none;"><el-menu-item index="1-1"><span  class="line">出售商品</span></el-menu-item></router-link>
                  <router-link to="icing" style=" text-decoration: none;"><el-menu-item index="1-2" ><span class="line">冻结商品</span></el-menu-item></router-link>
                  <router-link to="history" style=" text-decoration: none;"><el-menu-item index="1-3" ><span class="line">历史商品</span></el-menu-item></router-link>
                </el-menu-item-group>
              </el-submenu>
               <el-submenu index="2">
                <template slot="title">
                  <i class="iconfont">&#xe613;</i>
                  <router-link to="self_info" style="text-decoration: none;color:#fff;"><span class="line" >信息修改</span> </router-link>
                </template>
                <el-menu-item-group>
                   <template slot="title"></template>
                    <router-link to="self_info"  style="text-decoration: none;color:#fff;">
                      <el-menu-item index="1-1">
                        <span  class="line">
                        修改密码
                        </span>
                      </el-menu-item>
                    </router-link>
                </el-menu-item-group>

              </el-submenu>
            </el-menu>
          </el-col>
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
          <div v-if="this.$router.currentRoute.path=='/home'">
        <div style="float:left">
          <img src="https://iconfont.alicdn.com/t/073e0d52-7f67-45b4-a64b-d03c282964d7.png" alt="" style="width:650px;height:550px">
       </div>
       <div><span class="fontStyle">尊敬的admin用户，欢迎您！</span></div>
          </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      // 左侧菜单数据
      menulist: [],
      iconsObj: {
        '125': 'iconfont icon-user',
        '103': 'iconfont icon-tijikongjian',
        '101': 'iconfont icon-shangpin',
        '102': 'iconfont icon-danju',
        '145': 'iconfont icon-baobiao'
      },
      // 是否折叠
      isCollapse: false,
      // 被激活的链接地址
      activePath: ''
    }
  },
  methods: {
    logout() {
     this.$confirm('确定要退出登录吗?', '提示', {
                   confirmButtonText: '确定',
                   cancelButtonText: '取消',
                   type: 'warning'
                  }).then(() => {
                    this.$message({
                       type: 'success',
                       message: '退出成功!'
                     });
                     //确认退出，清除token
                     window.sessionStorage.removeItem('token')
                     //跳转登录页面(编程式导航)
                     this.$router.push('login')

                }).catch(() => {
              this.$message({
               type: 'info',
               message: '已取消退出'
          });
        });
    },
    gotoAdd(){
      this.$router.push('add')
    }
  }
}
</script>

<style lang="less" scoped>
@import url('../assets/css/font.css');
.font-line{
        text-decoration: none;
        // color: #8D7D6B;
        color: #fff;
      }
.home-container {
  height: 100%;
}
.el-header {
  background-color: #EFD8AA;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;
  >i{
    margin-left: 80%;
  }
  > div {
    display: flex;
    align-items: center;
    >img{
      margin-left: 20px;
      width: 90px;
      height: 90px;
    }
    span {
      text-align: left;
      font-family: "微軟正黑體 blod";
      font-size: 16px;
    }
  }
}

.line{
  text-decoration: none;
  color: #fff;
}
.el-col-4 {
    // width: 16.66667%;
    background-color: rgb(239, 216, 170);
}

.el-main {
  background-color: #F7F0DF;
}

.iconfont {
  margin-right: 10px;
}

.toggle-button {
  background-color: #F2E4C7;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
.fontStyle{
  font-size: 30px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-weight: bolder;
  color: tomato;
  line-height: 312px;

}

</style>
