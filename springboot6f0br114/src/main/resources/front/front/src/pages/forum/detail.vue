<template>
  <div :style='{"width":"100%","padding":"0px 7%","margin":"20px auto 40px","position":"relative","background":"rgb(255, 255, 255)"}'>
    <div :style='{"width":"100%","lineHeight":"54px","textAlign":"center","background":"#333","height":"54px"}'>
		<div :style='{"padding":"0 20px","color":"#fff","textAlign":"center","background":"none","display":"inline-block","width":"auto","fontSize":"20px"}'>社区交流</div>
	</div>
	<div :style='{"padding":"20px 7%","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 1px","width":"100%","borderStyle":"solid"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
    <div class="section-content" :style='{"width":"100%","margin":"20px auto","position":"relative","background":"none"}'>
      <div class="content-title" :style='{"padding":"0 10px","margin":"0 0 10px","color":"#333","textAlign":"center","width":"100%","lineHeight":"32px","fontSize":"18px","height":"32px"}'>{{detail.title}}</div>
	  <div :style='{"width":"100%","alignItems":"center","justifyContent":"center","display":"flex"}'>
	    <div :style='{"color":"#999","textAlign":"right","fontSize":"14px"}'>发布人：{{detail.username}}</div>
	    <div :style='{"color":"#999","textAlign":"left","fontSize":"14px"}'>发布时间：{{detail.addtime}}</div>
	  </div>
	  <div class="operate" :style='{"padding":"0px","alignItems":"center","textAlign":"right","background":"none","display":"flex","width":"100%","justifyContent":"flex-end"}'>
	    <div @click="zanClick" :style='{"padding":"0 15px","alignItems":"center","justifyContent":"center","display":"flex"}'>
	      <span class="icon iconfont icon-guanzhu-zhihui" :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}'></span>
	      <span :style='{"color":"#333","lineHeight":"40px","fontSize":"14px"}'>{{zanType?'取消赞':'点赞'}}({{allZan}})</span>
	    </div>
	  </div>
      <div :style='{"border":"1px solid #ddd","padding":"20px"}' class="content-detail" v-html="detail.content"></div>
      
	  
		<div :style='{"border":"1px solid #eee","width":"100%","padding":"20px","margin":"20px auto","background":"#fcfcfc"}'>
			<div :style='{"padding":"0 0 20px 0","borderColor":"#efefef","alignItems":"center","borderWidth":"0 0 1px 0","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between"}'>
				<div :style='{"color":"#333","fontSize":"16px"}'>评论列表</div>
				<el-button class="pub" type="primary" :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#F5BB00","width":"auto","fontSize":"14px","lineHeight":"32px","height":"32px"}' @click="addComment">
					<span class="icon iconfont icon-xiugai10" :style='{"color":"#fff","margin":"0 4px 0 0","fontSize":"14px"}'></span>
					点击评论
				</el-button>
			</div>
			<div class="comment" :style='{"width":"100%","padding":"0px","background":"none"}'>
				<template v-if="commentList && commentList.length">
				<div class="item" :style='{"border":"1px solid #eee","padding":"10px","margin":"20px 0","alignItems":"center","color":"#666","background":"#fff","width":"100%","height":"auto"}' v-for="item in commentList" :key="item.id" @mouseenter="commentEnter(item.id)" @mouseleave="commentLeave">
					<div class="user" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
						<img v-if="item.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :src="baseUrl + item.avatarurl">
						<img v-if="!item.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :src="require('@/assets/touxiang.png')">
						<div :style='{"color":"#666","fontSize":"16px"}' class="name">用户：{{item.username}}</div>
					</div>
					<div :style='{"border":"1px solid #eee","padding":"10px","margin":"10px 0px 0px","color":"#666","borderRadius":"4px","background":"none","lineHeight":"24px","fontSize":"14px"}' v-html="item.content"></div>
					<div class="btn" :style='{"width":"100%","margin":"12px 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"auto"}'>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#F5BB00","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}' v-if="showIndex==item.id&&showIndex1 == -1" @click="replyClick(item.id)">回复</el-button>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#333","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}' v-if="showIndex==item.id&&userid==item.userid&&showIndex1 == -1" @click="commentDel(item.id)">删除</el-button>
					</div>
					
					<template v-if="item.childs && item.childs.length">
					<div class="comment"  :style='{"width":"100%","padding":"0 20px"}'>
						<div class="item" :style='{"padding":"8px 0","margin":"20px 0 0 0","borderColor":"#efefef","alignItems":"center","color":"#666","background":"#fff","borderWidth":"1px 0 0 0","width":"100%","borderStyle":"solid","height":"auto"}' v-for="items in item.childs" :key="items.id" @mouseenter="commentEnter1(items.id)" @mouseleave="commentLeave1">
							<div class="user" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
								<img v-if="items.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :src="baseUrl + items.avatarurl">
								<img v-if="!items.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :src="require('@/assets/touxiang.png')">
								<div :style='{"color":"#333","fontSize":"16px"}' class="name">用户：{{items.username}}</div>
							</div>
							<div :style='{"padding":"0px","margin":"4px 0 0","color":"#666","borderRadius":"4px","background":"none","lineHeight":"30px","fontSize":"14px"}' v-html="items.content"></div>
							<div class="btn" :style='{"width":"100%","margin":"0px 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"auto"}'>
								<el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#333","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}' v-if="showIndex==item.id&&userid==items.userid&&showIndex1==items.id" @click="commentDel(items.id)">删除</el-button>
							</div>
						</div>
					</div>
					</template>
				</div>
				</template>
			</div>
		</div>
    </div>
	
    <el-dialog title="添加评论" :visible.sync="dialogFormVisible">
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item label="评论" label-width="60px" prop="content">
			<editor
			    :style='{"minHeight":"200px","border":"0","outline":"none","color":"#333","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
			    v-model="form.content" 
			    class="editor" 
			    action="file/upload">
			</editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addForum('form')">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
		id: '',
        detail: {},
        commentList: [],
        dialogFormVisible: false,
        form: {
          content: '',
          parentid: '',
          userid: localStorage.getItem('frontUserid'),
          username: localStorage.getItem('username'),
          avatarurl: '',
        },
		userid: localStorage.getItem('frontUserid'),
		editorOption: {
		  modules: {
		    toolbar: [
		      ["bold", "italic", "underline", "strike"],
		      ["blockquote", "code-block"],
		      [{ header: 1 }, { header: 2 }],
		      [{ list: "ordered" }, { list: "bullet" }],
		      [{ script: "sub" }, { script: "super" }],
		      [{ indent: "-1" }, { indent: "+1" }],
		      [{ direction: "rtl" }],
		      [{ size: ["small", false, "large", "huge"] }],
		      [{ header: [1, 2, 3, 4, 5, 6, false] }],
		      [{ color: [] }, { background: [] }],
		      [{ font: [] }],
		      [{ align: [] }],
		      ["clean"],
		      ["image", "video"]
		    ]
		  }
		},
        rules: {
          content: [
            { required: true, message: '请输入评论', trigger: 'blur' }
          ]
        },
		zanType:false,
		zanForm:{},
		showIndex: -1,
		showIndex1: -1,
		allZan: 0
      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.id = this.$route.query.id
		this.getDetail()
    },
    //方法集合
    methods: {
		// 返回按钮
		backClick(){
			history.back()
		},
		onEditorReady(editor) {
			editor.root.setAttribute('data-placeholder', "请输入内容...");
		},
		getDetail() {
			this.$http.get(`forum/list/${this.id}`).then(res => {
				if (res.data.code == 0) {
					this.detail = res.data.data
					this.commentList = res.data.data.childs;
					this.getZan()
					this.getAllZan()
				}
			});
		},
		getZan() {
			this.$http.get('storeup/list', {
				params: {
					page: 1,
					limit: 1,
					type: 21,
					userid: localStorage.getItem('frontUserid'),
					tablename: 'forum',
					refid: this.id
				}
			}).then(res=>{
				if(res.data&&res.data.code==0){
					if(res.data.data.list.length){
						this.zanType = true
						this.zanForm = res.data.data.list[0]
					}else{
						this.zanType = false
					}
				}
			})
		},
		getAllZan() {
			this.$http.get('storeup/list', {
				params: {
					page: 1,
					type: 21,
					tablename: 'forum',
					refid: this.id
				}
			}).then(res => {
				if (res.data && res.data.code == 0) {
					this.allZan = Number(res.data.data.total)
				}
			})
		},
		zanClick() {
			if(this.zanType){
				this.$http.post('storeup/delete', [this.zanForm.id]).then(res => {
					if (res.data && res.data.code == 0) {
						this.$message.success('取消成功')
						this.getZan()
						this.getAllZan()
					}
				})
			}else{
				let data = {
					name: this.detail.title,
					picture: '1',
					refid: this.detail.id,
					type: 21,
					tablename: 'forum',
					userid: localStorage.getItem('frontUserid')
				}
				this.$http.post('storeup/add', data).then(res => {
					if (res.data && res.data.code == 0) {
						this.$message.success('点赞成功')
						this.getZan()
						this.getAllZan()
					}
				})
			}
		},
		// 新增评论
		addComment(){
			this.form.parentid = this.detail.id
			this.dialogFormVisible = true
		},
		// 鼠标移入
		commentEnter(index){
			this.showIndex = index
		},
		// 鼠标移出
		commentLeave(){
			this.showIndex = -1
		},
		// 二级评论鼠标移入
		commentEnter1(index){
			this.showIndex1 = index
		},
		// 二级评论鼠标移出
		commentLeave1(){
			this.showIndex1 = -1
		},
		// 删除评论
		commentDel(id){
			this.$confirm('是否删除此评论？')
			  .then(_ => {
			    this.$http.post('forum/delete',[id]).then(res=>{
				  if(res.data&&res.data.code==0){
					  this.$message({
						type: 'success',
						message: '删除成功!',
						duration: 1500,
						onClose: () => {
							this.getDetail();
						}
					  });
				  }
			  })
		  }).catch(_ => {});
		},
		// 回复评论
		replyClick(id){
			this.form.parentid = id
			this.dialogFormVisible = true
		},
      addForum(formName) {
        let sensitiveWords = "";
        let sensitiveWordsArr = [];
        if(sensitiveWords) {
            sensitiveWordsArr = sensitiveWords.split(",");
        }
        for(var i=0; i<sensitiveWordsArr.length; i++){
            //全局替换
            var reg = new RegExp(sensitiveWordsArr[i],"g");
            //判断内容中是否包括敏感词
            if (this.form.content.indexOf(sensitiveWordsArr[i]) > -1) {
                // 将敏感词替换为 **
                this.form.content = this.form.content.replace(reg,"**");
            }
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.form.avatarurl = localStorage.getItem('frontHeadportrait')?localStorage.getItem('frontHeadportrait'):'';
            this.$http.post('forum/add', this.form).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  type: 'success',
                  message: '评论成功!',
                  duration: 1500,
                  onClose: () => {
                    this.form.content = '';
                    this.getDetail();
                    this.dialogFormVisible = false;
                  }
                });
              }
            });
          } else {
            return false;
          }
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
		width: 900px;
		margin: 0 auto;
	}

	.section-content {
		margin-top: 30px;
	}
	.content-title {
		text-align: center;
		font-size: 22px;
		font-weight: bold;
	}
	.content-sub-title {
		text-align: center;
		margin-top: 20px;
		color: #888888;
		font-size: 14px;
	}
	.clearfix:before,
	.clearfix:after {
		display: table;
		content: "";
	}
	.clearfix:after {
		clear: both
	}
	.header-block {
		height: 50px;
		line-height: 50px;
		display: flex;
	}
	.userinfo {
		align-self: center;
		margin-left: 15px;
	}
	.content-block-ask {
		margin: 15px 0 20px 65px;
	}
	.content-detail img {
		max-width: 900px;
		height: auto;
	}
	.operate{
		display: flex;
		align-items: center;
		justify-content: flex-start;
		padding: 0 40px;
	}
</style>
