import Vue from 'vue'
import Router from 'vue-router'
import {
  Message,
} from 'element-ui'


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
const Detail = () => import('./components/contain/Detail.vue')


Vue.use(Router)
Vue.prototype.$message = Message

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
      path: '/detail',
      component: Detail
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
        {
          path: '/detail',
          component: Detail
        },


      ]
    }
  ]

})
// 挂载路由导航守卫

router.beforeEach((to, from, next) => {
  console.log(from.path);

  if ((to.path === '/login') || (to.path === '/welcome') || (to.path === '/shopping')) return next()

  const tokenStr = window.sessionStorage.getItem('token')
  if (!tokenStr) {
    Message({
      message: '您暂未登陆，请先登录！',
      type: 'error'
    });

    next('/login');

  } else next()


})

export default router
