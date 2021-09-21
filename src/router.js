import Vue from 'vue'
import Router from 'vue-router'



const Login = () => import('./components/Login.vue')
const Home = () => import('./components/Home.vue')
const Welcome = () => import('./components/Welcome.vue')
const Selling = () => import('./components/opration/Selling.vue')
const Icing = () => import('./components/opration/Icing.vue')
const History = () => import('./components/opration/History.vue')
const Modify = () => import('./components/sellers/Modify.vue')
const Add = () => import('./components/sellers/Add.vue')
const Self_info = () => import('./components/sellers/Self_info.vue')
const Shopping = () => import('./components/Shopping.vue')


Vue.use(Router)

const router = new Router({
  routes: [{
      path: '/',
      redirect: '/welcome'
    },
    {
      path: '/welcome',
      component: Welcome
    },
    {
      path: '/shopping',
      component: Shopping
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/home',
      component: Home,
      redirect: '/home',
      children: [{
          path: '/selling',
          component: Selling
        },
        {
          path: '/icing',
          component: Icing
        },
        {
          path: '/history',
          component: History
        },
        {
          path: '/home',
          component: Home
        },
        {
          path: '/add',
          component: Add
        },
        {
          path: '/modify',
          component: Modify
        },
        {
          path: '/self_info',
          component: Self_info
        },


      ]
    }
  ]
})

// 挂载路由导航守卫
// router.beforeEach((to, from, next) => {
// to 将要访问的路径
// from 代表从哪个路径跳转而来
// next 是一个函数，表示放行
//     next()  放行    next('/login')  强制跳转

// if (to.path === '/icing') return next()
// 获取token
//   const tokenStr = window.sessionStorage.getItem('token')
//   if (!tokenStr) return next('/icing')
//   next()
// })

export default router
