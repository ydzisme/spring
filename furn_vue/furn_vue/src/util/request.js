// 引入axios包
import axios from "axios";
// 通过axios创建request对象,用于发送前端用户的信息
const request=axios.create({
    timeout: 5000
})
// request拦截器的处理
request.interceptors.request.use(config=>{
    config.headers['Content-Type'] = 'application/json;charset=utf-8'
    return config
},error => {
    return Promise.reject(error)
})

// response拦截器
request.interceptors.response.use(
    response=> {
        let res = response.data
        if(response.config.responseType === 'blob'){
            return res
        }
        if(typeof res === 'string'){
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error =>{
        console.log("err",error)
        return Promise.reject(error);
    }
)

//导出request请求
export default request
