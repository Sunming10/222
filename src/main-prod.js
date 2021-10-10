import Vue from 'vue'
import App from './App.vue'
import router from './router'
// 导入字体图标
import './assets/fonts/iconfont.css'
// 导入全局样式表
import './assets/css/global.css'

import axios from 'axios'
import qs from 'qs'
// axios配置
axios.defaults.timeout = 5000 // 响应时间
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8' // 配置post请求头
axios.defaults.headers.get['Content-Type'] = 'application/json;charset=UTF-8' // 配置get请求头
axios.defaults.baseURL = 'http://127.0.0.1:8082/' // 配置接口地址
// POST传参序列化(添加请求拦截器)
axios.interceptors.request.use((config) => {
  // 在发送请求之前做某件事
  if (config.method === 'post') {
    // 这里使用qs对数据进行处理，防止后台$_POST接收不到
    config.data = qs.stringify(config.data)
  }
  return config
}, (error) => {
  console.log('错误的传参', 'fail')
  return Promise.reject(error)
})

Vue.prototype.$http = axios

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
