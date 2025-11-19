let $b = {
    // 根据选择器返回dom元素
    selecter(selecter){
        return document.querySelector(selecter)
    },
    // get请求
    get(url,obj,callback){
        let xhr = new XMLHttpRequest();
        // GET请求参数，直接拼接在URL地址上，使用?拼接URL参数，多个参数使用&拼接
        let str = Object.keys(obj).map(k=>{
            return k+"="+obj[k]
        }).join("&")
        xhr.open('GET',url+(str ? ("?"+str) : ""));
        xhr.send()
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    callback(JSON.parse(xhr.response))
                }
            }
        }
    },
    // post请求
    post(url,obj,callback){
        let xhr = new XMLHttpRequest();
        xhr.open('POST',url);
        // 设置post请求的参数为url格式
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        let str = Object.keys(obj).map(k=>{
            return k+"="+obj[k]
        }).join("&")
        xhr.send(str);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    callback(JSON.parse(xhr.response))
                }
            }
        }
    }
}