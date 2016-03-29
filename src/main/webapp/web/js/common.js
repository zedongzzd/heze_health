var query,loadbox, loginSuccFun ;
$(function(){
    query   = parseQueryString(location.href);
    loadbox = {
        el   : $(".preloader-indicator-modal"),
        show : function(){
            this.el.removeClass("none");
        },hide:function(){
            this.el.addClass("none");
        }
    };
    $("body").height(document.documentElement.clientHeight);
});

function showNoMore(container){
    var $noMore = $(".noMore");
    if($noMore.length == 0){
        $(container).append('<div class="noMore tc p20">没有更多了...</div>')
        var timer = setTimeout(function(){
            clearTimeout(timer);
            $(".noMore").remove();
        },2000);
    }

}

window.web2ciciClient = {
    getAppUinfo : function(){
        return "{}";
    },login2js  : function(funcName){
        return window[funcName]("{uid:1}");
    }
}

/**
 * 登录
 * @param func
 */
function requestLogin(func){
    //z f4fna96cdnf27i8W9Jgdg4s8asd56a6sdV6T152fgh56df9z5ZcL15hy0W6ob88v0Q6Vf126
    window.loginSuccFun = func;
    eval("user="+window.web2ciciClient.getAppUinfo());

    //用户信息存在直接登录
    if(user.uid != null && user.uid != undefined && user.uid != 0){
        doLogin(user);
    }else{//不存在则打开登录窗口
        window.web2ciciClient.login2js("doLogin");
    }

}

/**
 * 登录
 * @param data
 */
function doLogin(data){
    var _data = eval("("+data+")")
    $.ajax({
        url     : "/mine/loginSuccess",
        data    : _data,
        type    : "post",
        success : function (obj) {
            if(obj.resultCode == 0) {
                if (typeof loginSuccFun == "function") {
                    loginSuccFun(user);
                    loginSuccFun = null;
                }
            }
        }
    })
}

/**
 * 替换/添加url中参数
 * @param obj
 * @returns {string}
 */
function replaceQueryString(obj){
    return serialize($.extend({},query,obj));
}

/**
 * 参数转obj
 * @param ustring
 * @returns {Object}
 */
function parseQueryString(ustring){
    ustring=ustring.slice(ustring.indexOf("?")+1);
    var arr=ustring.split("&");
    var result=new Object();
    for(var i=0;i<arr.length;i++){
        var kv=arr[i];
        kvarray=kv.split("=");
        result[kvarray[0]]=kvarray[1];
    }
    return result
}

/**
 *
 * @param obj
 * @returns {string}
 */
function serialize(obj) {
    var s = [];

    $.each(obj, function(k, v) {
        s.push(k + '=' + encodeURIComponent2(v));
    });

    return s.join('&');
}

/**
 * 参数截取
 * @param search
 * @param name
 * @returns {*}
 */
function getQuery(search,name) {

    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = search.match(reg);
    if (r!=null) return (r[2]); return null;
}

/**
 * 验证身份证
 * @param idCard
 * @returns {boolean}
 */
function validateIdCard (idCard){
    //15位和18位身份证号码的正则表达式
    var regIdCard=/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;

    //如果通过该验证，说明身份证格式正确，但准确性还需计算
    if(regIdCard.test(idCard)){
        if(idCard.length==18){
            var idCardWi=new Array( 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ); //将前17位加权因子保存在数组里
            var idCardY=new Array( 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
            var idCardWiSum=0; //用来保存前17位各自乖以加权因子后的总和
            for(var i=0;i<17;i++){
                idCardWiSum+=idCard.substring(i,i+1)*idCardWi[i];
            }

            var idCardMod=idCardWiSum%11;//计算出校验码所在数组的位置
            var idCardLast=idCard.substring(17);//得到最后一位身份证号码

            //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
            if(idCardMod==2){
                if(idCardLast=="X"||idCardLast=="x"){
                    return true;
                }else{
                    return false;
                }
            }else{
                //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                if(idCardLast==idCardY[idCardMod]){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }else{
        return false;
    }
}

/**
 * 验证手机
 * @param phone
 * @returns {boolean}
 */
function validatePhone(phone){
    return /^1[3,5,8]\d{9}$/.test(phone);
}

/**
 * 验证中文
 * @param name
 * @returns {boolean}
 */
function validateCN(name){
    return /^[\u4e00-\u9fa5]+$/.test(name);
}



function encodeURIComponent2(v){
    return encodeURIComponent(encodeURIComponent(v));
}