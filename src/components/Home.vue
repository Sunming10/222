<template>
  <el-container class="home-container">
    <!-- 头部区域 -->
    <el-header>
      <div>
        <img src="https://iconfont.alicdn.com/t/be0fa091-076f-47da-8d04-9cf81d8252ad.png" alt="网上商城">
        <!-- <span>网上商城</span> -->
      </div>
      <!-- <i class="iconfont">&#xe634;</i> -->
      <el-button type="warning" round @click="logout" icon="el-icon-user"><router-link to='welcome' class="font-line" >退出登陆</router-link></el-button>
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
                  <span slot="title"><router-link to="selling" class="line">商品操作 </router-link></span>

                </template>
                <el-menu-item-group>
                  <template slot="title"></template>
                  <el-menu-item index="1-1"><router-link to='selling'  class="line">出售商品</router-link></el-menu-item>
                  <el-menu-item index="1-2" ><router-link to="icing" class="line">冻结商品</router-link></el-menu-item>
                  <el-menu-item index="1-3" ><router-link to="history" class="line">历史商品</router-link></el-menu-item>
                  <el-menu-item index="1-4" ><router-link to="add" class="line">增加商品</router-link></el-menu-item>
                </el-menu-item-group>

              </el-submenu>
               <el-submenu index="2">
                <template slot="title">
                  <i class="iconfont">&#xe613;</i>
                  <span slot="title"><router-link to="self_info" class="line">信息修改</router-link> </span>
                </template>
                <el-menu-item-group>
                  <!-- <el-submenu index="2-1">
                    <template slot="title">
                        <span slot="title"><router-link  to="modify" class="line">商品信息修改</router-link></span>
                    </template>
                    <el-menu-item index="2-1-1"><router-link to="add" class="line">增加商品</router-link></el-menu-item>
                  <el-menu-item index="2-1-2"><router-link to="modify" class="line">修改商品信息</router-link></el-menu-item> -->

                  <!-- </el-submenu> -->
                  <el-submenu index="2-1">
                    <template slot="title">
                        <span slot="title"><router-link to="self_info" class="line">个人信息修改</router-link></span>
                    </template>
                    <el-menu-item index="2-1-1"><router-link to="self_info" class="line">修改密码</router-link></el-menu-item>

                  </el-submenu>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-col>
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
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
  created() {
    this.getMenuList()
    this.activePath = window.sessionStorage.getItem('activePath')
  },
  methods: {
    logout() {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    // 获取所有的菜单
    async getMenuList() {
      const { data: res } = await this.$http.get('menus')
      if (res.meta.status !== 200) return this.$message.error(res.meta.msg)
      this.menulist = res.data
      console.log(res)
    },
    // 点击按钮，切换菜单的折叠与展开
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
    // 保存链接的激活状态
    saveNavState(activePath) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
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

// .el-aside {
//   background-color: #FFBA33;
//   .el-menu {
//     border-right: none;
//   }
// }
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
</style>
