import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import yinshijianyi from '@/views/modules/yinshijianyi/list'
    import xiaoxitongzhi from '@/views/modules/xiaoxitongzhi/list'
    import jianshenjianyi from '@/views/modules/jianshenjianyi/list'
    import jianshenjilu from '@/views/modules/jianshenjilu/list'
    import jiankangxinxi from '@/views/modules/jiankangxinxi/list'
    import yundongleixing from '@/views/modules/yundongleixing/list'
    import forum from '@/views/modules/forum/list'
    import popupremind from '@/views/modules/popupremind/list'
    import yonghu from '@/views/modules/yonghu/list'
    import jianshenjihua from '@/views/modules/jianshenjihua/list'
    import yinshijilu from '@/views/modules/yinshijilu/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '健康资讯',
        component: news
      }
      ,{
	path: '/yinshijianyi',
        name: '饮食建议',
        component: yinshijianyi
      }
      ,{
	path: '/xiaoxitongzhi',
        name: '消息通知',
        component: xiaoxitongzhi
      }
      ,{
	path: '/jianshenjianyi',
        name: '健身建议',
        component: jianshenjianyi
      }
      ,{
	path: '/jianshenjilu',
        name: '健身记录',
        component: jianshenjilu
      }
      ,{
	path: '/jiankangxinxi',
        name: '健康信息',
        component: jiankangxinxi
      }
      ,{
	path: '/yundongleixing',
        name: '运动类型',
        component: yundongleixing
      }
      ,{
	path: '/forum',
        name: '社区交流',
        component: forum
      }
      ,{
	path: '/popupremind',
        name: '弹窗提醒',
        component: popupremind
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/jianshenjihua',
        name: '健身计划',
        component: jianshenjihua
      }
      ,{
	path: '/yinshijilu',
        name: '饮食记录',
        component: yinshijilu
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '健康资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
