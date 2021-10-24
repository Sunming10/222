module.exports = {
  chainWebpack: config => {
    // 发布模式
    config.when(process.env.NODE_ENV === 'production', config => {
      config
        .entry('app')
        .clear()
        .add('./src/main-prod.js')

      config.set('externals', {
        vue: 'Vue',
        'vue-router': 'VueRouter',
        axios: 'axios',
        lodash: '_',
        echarts: 'echarts',
        nprogress: 'NProgress',
        'vue-quill-editor': 'VueQuillEditor'
      })

      config.plugin('html').tap(args => {
        args[0].isProd = true
        return args
      })
    })

    // 开发模式
    config.when(process.env.NODE_ENV === 'development', config => {
      config
        .entry('app')
        .clear()
        .add('./src/main-dev.js')

      config.plugin('html').tap(args => {
        args[0].isProd = false
        return args
      })
    })
  },
  // 跨域配置
  // module.exports = {
  devServer: { //记住，别写错了devServer//设置本地默认端口  选填
    port: 8080,
    proxy: { //设置代理，必须填
      '/api': { //设拦截器  拦截器格式   斜杠+拦截器名字，名字可以自己定
        target: 'http://localhost:8082', //代理的目标地址
        changeOrigin: true, //是否设置同源，输入是的
        pathRewrite: { //路径重写
          '/api': '' //选择忽略拦截器里面的单词
        }
      }
    }
  }
  // }

}
