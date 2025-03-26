const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot6f0br114/",
            name: "springboot6f0br114",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot6f0br114/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "健康健身追踪系统"
        } 
    }
}
export default base
