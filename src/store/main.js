import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const store = new Vuex.Store({

  state: {
    // 存储token
    Authorization: sessionStorage.getItem('Authorization') ? sessionStorage.getItem('Authorization') : ''
  },

  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin(state, user) {
      state.Authorization = user.Authorization;
      sessionStorage.setItem('Authorization', user.Authorization);
    }
  }
});


//设置axios请求头加入token
Axios.interceptors.request.use(config => {
    if (config.push === '/') {} else {
      if (localStorage.getItem('token')) {
        //在请求头加入token，名字要和后端接收请求头的token名字一样
        config.headers.token = localStorage.getItem('token');
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
    //和后端token失效返回码约定403
    if (response.data.code == 403) {
      // 引用elementui message提示框
      ElementUI.Message({
        message: '身份已失效',
        type: 'err'
      });
      //清除token
      localStorage.removeItem('token ');
      //跳转
      router.push({
        name: 'login'
      });
    } else {
      return response
    }
  },
  error => {
    return Promise.reject(error);
  })



export default store;
