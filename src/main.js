import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
0
import {
  Message,
} from 'element-ui'


import './plugins/element.js'
import 'element-ui/lib/theme-chalk/index.css'
// 导入字体图标
import './assets/fonts/iconfont.css'
// 导入全局样式表
import './assets/css/global.css'
import qs from 'qs'
Vue.use(VueAxios, axios)
// axios配置
axios.defaults.timeout = 5000 // 响应时间
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8' // 配置post请求头
axios.defaults.headers.get['Content-Type'] = 'application/json;charset=UTF-8' // 配置get请求头
axios.defaults.baseURL = 'http://localhost:8082' // 配置接口地址
//设置axios请求头加入token
Axios.interceptors.request.use(config => {
    if (config.push === '/') {} else {
      if (window.sessionStorage.getItem('token')) {
        //在请求头加入token，名字要和后端接收请求头的token名字一样
        config.headers.token = window.sessionStorage.getItem('token');
      }
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  });

//=============================
//响应回来token是否过期
Axios.interceptors.response.use(response => {
    console.log('响应回来：' + response.data.code)
    //和后端token失效返回码约定666
    if (response.data.code == 661) {
      Message({
        message: '身份已失效',
        type: 'error'
      });
      //清除token
      window.sessionStorage.removeItem('token ');
      //跳转
      router.push({
        name: 'login'
      });
    } else if (response.data.code === 660) {

      Message({
        message: '信息不存在',
        type: 'error'
      });
      // return response
    } else if (response.data.code === 666) {
      return response
    }
  },
  error => {
    return Promise.reject(error);
  })

Vue.prototype.$http = axios


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
