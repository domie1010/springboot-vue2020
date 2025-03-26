<template>
	<div class="navbar">
		<div class="title" :style='{"display":"none"}'>
			<el-image v-if="true" class="title-img" :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover" />
			<span class="title-name" :style='{"padding":"0 0 0 12px","lineHeight":"44px","color":"rgba(64, 158, 255, 1)","float":"left"}'>{{this.$project.projectName}}</span>
		</div>
		<!--
		<div class="right" :style='{"position":"absolute","right":"20px","top":"8px","display":"flex"}'>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#333"}' class="nickname">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#666"}' v-if="this.$storage.get('role')!='管理员'" class="logout" @click="onIndexTap">退出到前台</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#666"}' class="logout" @click="onLogout">退出登录</div>
		</div>
		-->
		
		<el-dropdown @command="handleCommand" trigger="click" :style='{"fontSize":"14px","position":"absolute","right":"40px","color":"#666","top":"24px","display":"flex"}'>
		  <div class="el-dropdown-link" :style='{"alignItems":"center","display":"flex"}'>
		    <el-image v-if="user" :style='{"margin":"0 10px","objectFit":"cover","borderRadius":"10px","display":"inline-block","width":"32px","height":"32px","order":"1"}' :src="avatar?this.$base.url + avatar : require('@/assets/img/avator.png')" fit="cover"></el-image>
		    <span :style='{"lineHeight":"32px","fontSize":"18px","color":"#000000","fontWeight":"600","display":"none"}'>{{this.$storage.get('adminName')}}</span>
		    <span class="icon iconfont icon-xiala" :style='{"margin":"0 0 0 5px","fontSize":"14px","color":"#666","display":"none"}'></span>
		  </div>
		  <div class="top-el-dropdown-menu-2" :style='{"alignItems":"center","justifyContent":"center","display":"flex"}'>
		    <div class="item1" @click="handleCommand('')">首页</div>
		    <div class="item2" @click="handleCommand('center')">个人中心</div>
		    <div class="item3" v-if="this.$storage.get('role')!='管理员'" @click="handleCommand('front')">退出到前台</div>
		    <div class="item4" @click="handleCommand('logout')">退出登录</div>
		  </div>
		</el-dropdown>
		<el-dialog :title="remindForm.title" :append-to-body="true" :visible.sync="remindVisibie" width="60%">
			<div v-html="remindForm.content"></div>
		</el-dialog>
		
	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: null,
				remindVisibie: false,
				remindForm: {},
				timesAll: null,
				timesOnce: null,
			};
		},
		created() {
			if (this.$storage.get('sessionTable') != 'users') {
				this.getRecommendAll()
				this.getRecommendOnce()
			}
		},
		computed: {
			avatar(){
				return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
			}
		},
		destroyed() {
			if (this.$storage.get('sessionTable') != 'users') {
				clearTimeout(this.timesAll)
				clearTimeout(this.timesOnce)
			}
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					if(sessionTable == 'yonghu') {
						this.$storage.set('headportrait',data.data.touxiang)
					}
					if(sessionTable == 'users') {
						this.$storage.set('headportrait',data.data.image)
					}
					this.$storage.set('userForm',JSON.stringify(data.data))
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			compareDate(s1, s2) {
				return ((new Date(s1.replace(/-/g, "\/"))) > (new Date(s2.replace(/-/g, "\/"))));
			},
			async getRecommendAll() {
				let that = this
				this.$http({
					url: 'popupremind/list',
					method: 'get',
					params: {
						type: '全局'
					}
				}).then(async res => {
					if (res.data && res.data.code == 0) {
						for (let x in res.data.data.list) {
							if (this.compareDate(this.getCurDateTime(), res.data.data.list[x]
								.remindtime)) {
								await this.$http({
									url: 'storeup/page',
									method: 'get',
									params: {
										refid: res.data.data.list[x].id,
										tablename: 'popupremind',
										type: '61',
									}
								}).then(obj => {
									if (obj.data && obj.data.code == 0) {
										if (!obj.data.data.list.length) {
											this.$notify({
												title: res.data.data.list[x].title,
												dangerouslyUseHTMLString: true,
												message: res.data.data.list[x].brief,
												duration: 0,
												position: 'bottom-right',
												onClick() {
													that.remindForm = res.data.data.list[x]
													that.remindVisibie = true
												}
											})
											this.$http({
												url: 'storeup/add',
												method: 'post',
												data: {
													userid: this.$storage.get('userid'),
													refid: res.data.data.list[x].id,
													tablename: 'popupremind',
													name: res.data.data.list[x].title,
													type: '61',
												}
											})
										}
									}
								})
							}
						}
						this.timesAll = setTimeout(() => {
							this.getRecommendAll()
						}, 10000)
					}
				})
			},
			async getRecommendOnce() {
				let that = this
				this.$http({
					url: 'popupremind/page',
					method: 'get',
					params: {
						type: '个人'
					}
				}).then(async res => {
					if (res.data && res.data.code == 0) {
						for (let x in res.data.data.list) {
							if (this.compareDate(this.getCurDateTime(), res.data.data.list[x]
								.remindtime)) {
								await this.$http({
									url: 'storeup/page',
									method: 'get',
									params: {
										refid: res.data.data.list[x].id,
										tablename: 'popupremind',
										type: '61',
									}
								}).then(obj => {
									if (obj.data && obj.data.code == 0) {
										if (!obj.data.data.list.length) {
											this.$notify({
												title: res.data.data.list[x].title,
												dangerouslyUseHTMLString: true,
												message: res.data.data.list[x].brief,
												duration: 0,
												position: 'top-right',
												onClick() {
													that.remindForm = res.data.data.list[x]
													that.remindVisibie = true
												}
											})
											this.$http({
												url: 'storeup/add',
												method: 'post',
												data: {
													userid: this.$storage.get('userid'),
													refid: res.data.data.list[x].id,
													tablename: 'popupremind',
													name: res.data.data.list[x].title,
													type: '61',
												}
											})
										}
									}
								})
							}
						}
						this.timesOnce = setTimeout(() => {
							this.getRecommendOnce()
						}, 10000)
					}
				})
			},
			handleCommand(name) {
				if (name == 'front') {
					this.onIndexTap()
				} else if (name == 'logout') {
					this.onLogout()
				} else if (name == 'board'){
					this.toBoard()
				} else if (name == 'backUp'){
					this.backUp()
				} else {
					let router = this.$router
					name = '/'+name
					router.push(name)
				}
			},
			
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				this.$store.dispatch('tagsView/delAllViews')
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				window.location.href = `${this.$base.indexUrl}`
			},
		}
	};
</script>


<style lang="scss" scoped>
	.top-el-dropdown-menu-2 div.item1 {
				padding: 0 3px;
				color: #333333;
				font-weight: 600;
				display: none;
				font-size: 14px;
				line-height: 32px;
			}

	.top-el-dropdown-menu-2 div.item1:hover {
				color: #ffe4c7;
			}
	
	.top-el-dropdown-menu-2 div.item2 {
				padding: 0 3px;
				color: #333333;
				font-weight: 600;
				display: none;
				font-size: 14px;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item2:hover {
				color: #ffe4c7;
			}
	
	.top-el-dropdown-menu-2 div.item3 {
				padding: 0 3px;
				color: #333333;
				font-weight: 600;
				font-size: 14px;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item3:hover {
				color: #ffe4c7;
			}
	
	.top-el-dropdown-menu-2 div.item4 {
				padding: 0 3px;
				color: #333333;
				font-weight: 600;
				font-size: 14px;
				line-height: 32px;
			}
	
	.top-el-dropdown-menu-2 div.item4:hover {
				color: #ffe4c7;
			}
</style>
