import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jiankangxinxiList from '../pages/jiankangxinxi/list'
import jiankangxinxiDetail from '../pages/jiankangxinxi/detail'
import jiankangxinxiAdd from '../pages/jiankangxinxi/add'
import jianshenjihuaList from '../pages/jianshenjihua/list'
import jianshenjihuaDetail from '../pages/jianshenjihua/detail'
import jianshenjihuaAdd from '../pages/jianshenjihua/add'
import yundongleixingList from '../pages/yundongleixing/list'
import yundongleixingDetail from '../pages/yundongleixing/detail'
import yundongleixingAdd from '../pages/yundongleixing/add'
import jianshenjiluList from '../pages/jianshenjilu/list'
import jianshenjiluDetail from '../pages/jianshenjilu/detail'
import jianshenjiluAdd from '../pages/jianshenjilu/add'
import jianshenjianyiList from '../pages/jianshenjianyi/list'
import jianshenjianyiDetail from '../pages/jianshenjianyi/detail'
import jianshenjianyiAdd from '../pages/jianshenjianyi/add'
import yinshijiluList from '../pages/yinshijilu/list'
import yinshijiluDetail from '../pages/yinshijilu/detail'
import yinshijiluAdd from '../pages/yinshijilu/add'
import yinshijianyiList from '../pages/yinshijianyi/list'
import yinshijianyiDetail from '../pages/yinshijianyi/detail'
import yinshijianyiAdd from '../pages/yinshijianyi/add'
import xiaoxitongzhiList from '../pages/xiaoxitongzhi/list'
import xiaoxitongzhiDetail from '../pages/xiaoxitongzhi/detail'
import xiaoxitongzhiAdd from '../pages/xiaoxitongzhi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import popupremindList from '../pages/popupremind/list'
import popupremindDetail from '../pages/popupremind/detail'
import popupremindAdd from '../pages/popupremind/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jiankangxinxi',
					component: jiankangxinxiList
				},
				{
					path: 'jiankangxinxiDetail',
					component: jiankangxinxiDetail
				},
				{
					path: 'jiankangxinxiAdd',
					component: jiankangxinxiAdd
				},
				{
					path: 'jianshenjihua',
					component: jianshenjihuaList
				},
				{
					path: 'jianshenjihuaDetail',
					component: jianshenjihuaDetail
				},
				{
					path: 'jianshenjihuaAdd',
					component: jianshenjihuaAdd
				},
				{
					path: 'yundongleixing',
					component: yundongleixingList
				},
				{
					path: 'yundongleixingDetail',
					component: yundongleixingDetail
				},
				{
					path: 'yundongleixingAdd',
					component: yundongleixingAdd
				},
				{
					path: 'jianshenjilu',
					component: jianshenjiluList
				},
				{
					path: 'jianshenjiluDetail',
					component: jianshenjiluDetail
				},
				{
					path: 'jianshenjiluAdd',
					component: jianshenjiluAdd
				},
				{
					path: 'jianshenjianyi',
					component: jianshenjianyiList
				},
				{
					path: 'jianshenjianyiDetail',
					component: jianshenjianyiDetail
				},
				{
					path: 'jianshenjianyiAdd',
					component: jianshenjianyiAdd
				},
				{
					path: 'yinshijilu',
					component: yinshijiluList
				},
				{
					path: 'yinshijiluDetail',
					component: yinshijiluDetail
				},
				{
					path: 'yinshijiluAdd',
					component: yinshijiluAdd
				},
				{
					path: 'yinshijianyi',
					component: yinshijianyiList
				},
				{
					path: 'yinshijianyiDetail',
					component: yinshijianyiDetail
				},
				{
					path: 'yinshijianyiAdd',
					component: yinshijianyiAdd
				},
				{
					path: 'xiaoxitongzhi',
					component: xiaoxitongzhiList
				},
				{
					path: 'xiaoxitongzhiDetail',
					component: xiaoxitongzhiDetail
				},
				{
					path: 'xiaoxitongzhiAdd',
					component: xiaoxitongzhiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'popupremind',
					component: popupremindList
				},
				{
					path: 'popupremindDetail',
					component: popupremindDetail
				},
				{
					path: 'popupremindAdd',
					component: popupremindAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
