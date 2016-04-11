var query,loadbox, loginSuccFun ;
$(function(){
    query   = parseQueryString(location.href);
    loadbox = {
        el   : $("#preloader"),
        show : function(){
            this.el.removeClass("none");
        },hide:function(){
            this.el.addClass("none");
        }
    };
    $("body").height(document.documentElement.clientHeight);

    //$(window).bind('beforeunload',function(){
    //    loadbox.show();
    //});

    //try{
    //    _alert(window.web2ciciClient.getAppUinfo());
    //}catch(e){console.error(e);}

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

//window.web2ciciClient = {
//    getAppUinfo : function(){
//        return "{}";
//    },login2js  : function(funcName){
//        return window[funcName]("{uid:1}");
//    }
//}

var loading = {
    self   : null,
    status : false,
    keys   : {},
    show   : function(key){
        this.keys[key] = true;
        loadbox.show();
    },hide : function(key){
        delete this.keys[key];

        if(Object.keys(this.keys).length == 0){
            loadbox.hide();
        }
    }
}

/**
 * @param data
 */
function doAjax(data){
    var loadingKey = data.url + JSON.stringify(data.data||"");
    $.ajax($.extend({},data,{
        beforeSend : function(){
            //alert(loadingKey+"|"+loading.show.toString());
          loading.show(loadingKey);
      },complete : function () {
          loading.hide(loadingKey);
      }
    }));
}

/**
 * 检查登录
 * @param func
 */
function checkLogin(func){
    doAjax({
        url     : "/mine/getUser",
        type    : "get",
        async   : false,
        success : function(resp){
            //alert(JSON.stringify(resp));
            func && typeof func == "function" && func(resp);
        }
    });
}

/**
 * 登录
 * @param func
 */
function requestLogin(func){

    window.loginSuccFun = func;

    _confirm({
        content : "系统检测到您尚未登录,是否登录?",
        onSure  : function(){
            window.web2ciciClient.login2js("doLogin");
        }
    });
}

/**
 * 登录
 * @param data
 */
function doLogin(data){
    var _data = eval("("+data+")")

    doAjax({
        url     : "/mine/loginSuccess",
        data    : _data,
        async   : false,
        type    : "post",
        success : function (obj) {

            if(obj.resultCode == 0) {
                if (typeof loginSuccFun == "function") {
                    loginSuccFun(obj.obj || {});
                    loginSuccFun = null;
                }
            }
        }
    });
}

/**
 * 替换/添加url中参数
 * @param obj
 * @returns {string}
 */
function replaceQueryString(obj){
    //alert(query);
    //alert(serialize($.extend({},query,obj)));
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

/**
 * alert 弹框
 * @param alert
 * @private
 */
function _alert(alert){
    if(typeof  alert == "string"){
        alert = { content : alert};
    }
    alert = $.extend({
        title   : "提示",
        content : "",
        onSureText : "确定"
    },alert);

    var $dialog = $(".weui_dialog_alert");

    if(!$dialog.length){
        var html = '<div class="weui_dialog_alert">\
                    <div class="weui_mask"></div>\
                    <div class="weui_dialog">\
                        <div class="weui_dialog_hd">\
                            <strong class="weui_dialog_title">{0}</strong>\
                        </div>\
                        <div class="weui_dialog_bd">{1}</div>\
                        <div class="weui_dialog_ft">\
                            <a href="javascript:;" class="weui_btn_dialog primary">{2}</a>\
                        </div>\
                    </div>\
                </div>';
        $dialog = $(html);
    }

    $dialog.find(".weui_dialog_title").html(alert.title).end()
           .find(".weui_dialog_bd").html(alert.content).end()
           .find(".weui_btn_dialog.primary").html(alert.onSureText).click(function(){
                if(alert.onSure && typeof alert.onSure == "function"){
                    try{
                        alert.onSure();
                    }catch (e){console.error(e);}

                }
                $dialog.remove();
            });

    $("body").append($dialog);
}

function _confirm(confirm){
    confirm = $.extend({
        title        : "提示",
        content      : "",
        onSureText   : "确定",
        onCancelText : "取消"
    },confirm);

    var $confirm = $('.weui_dialog_confirm');

    if(!$confirm.length){
        var html = '<div class="weui_dialog_confirm">\
                        <div class="weui_mask"></div>\
                        <div class="weui_dialog">\
                        <div class="weui_dialog_hd">\
                            <strong class="weui_dialog_title"></strong>\
                        </div>\
                        <div class="weui_dialog_bd">自定义弹窗内容<br>...</div>\
                            <div class="weui_dialog_ft">\
                                <a href="javascript:;" class="weui_btn_dialog default">取消</a>\
                                <a href="javascript:;" class="weui_btn_dialog primary">确定</a>\
                            </div>\
                        </div>\
                    </div>';

        $confirm = $(html);
    }

    $confirm.find(".weui_dialog_title").html(confirm.title).end()
            .find(".weui_dialog_bd").html(confirm.content).end()
            .find(".weui_btn_dialog.default").html(confirm.onCancelText).click(function(){
                if(confirm.onCancel && typeof confirm.onCancel == "function"){
                    try {
                        confirm.onCancel();
                    }catch(e){console.error(e);}
                }
                $confirm.remove();
            }).end().find(".weui_btn_dialog.primary").html(confirm.onSureText).click(function(){
                if(confirm.onSure && typeof confirm.onSure == "function"){
                    try {
                        confirm.onSure();
                    }catch(e){
                        console.error(e);
                    }
                }
                $confirm.remove();
            });

    $("body").append($confirm);
}

/**
 * @author accountwcx@qq.com
 * http://git.oschina.net/accountwcx/rhui
 *
 * swipe事件，包括swipeLeft、swipeRight、swipeUp、swipeDown。
 * 调用方法
 * Rhui.mobile.swipeLeft(el, callback, options)
 * Rhui.mobile.swipeRight(el, callback, options)
 * Rhui.mobile.swipeUp(el, callback, options)
 * Rhui.mobile.swipeDown(el, callback, options)
 * 如果使用jQuery，调用方法
 * $(el).rhuiSwipe('swipeLeft', callback, options);
 * $(el).rhuiSwipe('swipeRight', callback, options);
 * $(el).rhuiSwipe('swipeUp', callback, options);
 * $(el).rhuiSwipe('swipeDown', callback, options);
 */
(function(window, $){
    var Rhui = window.Rhui || {};
    window.Rhui = Rhui;
    Rhui.mobile = (function(){
        var touch = {
            distance: 30,  //滑动距离，超过该距离触发swipe事件，单位像素。
            duration: 1000 //滑动时长，超过该时间不触发swipe，单位毫秒。
        };

        /**
         * 绑定事件
         * @param  el        触发事件的元素
         * @param  swipe     事件名称，可选值为swipeLeft,swipeRight,swipeUp,swipeDown
         * @param  callback  事件回调函数
         * @param  isStopPropagation   是否停止冒泡，true为停止冒泡
         * @param  isPreventDefault    是否阻止默认事件，true为阻止默认事件
         * @param  triggerOnMove       swipe事件有两种触发方式，一种是在touchmove过程中，只要满足滑动距离条件即触发。
         *                             一种是在touchend中，进入滑动距离判断，如果满足滑动距离触发。
         *                             默认是在touchend中触发。
         */
        function bindSwipe(el, swipe, callback, triggerOnMove, isStopPropagation, isPreventDefault){
            var startPoint, endPoint, timer;

            /**
             * 计算滑动方向
             * 首先根据x方向和y方向滑动的长度决定触发x方向还是y方向的事件。
             * 然后再判断具体的滑动方向。
             * 如果滑动距离不够长，不判断方向。
             */
            function swipeDirection(x1, y1, x2, y2){
                var diffX = x1 - x2,
                    diffY = y1 - y2,
                    absX = Math.abs(diffX),
                    absY = Math.abs(diffY),
                    swipe;

                if(absX >= absY){
                    if(absX >= touch.distance){
                        swipe = diffX > 0 ? 'swipeLeft' : 'swipeRight';
                    }
                }else{
                    if(absY >= touch.distance){
                        swipe = diffY > 0 ? 'swipeUp' : 'swipeDown';
                    }
                }

                return swipe;
            }

            // 清除本次滑动数据
            function clearSwipe(){
                startPoint = undefined;
                endPoint = undefined;

                if(timer !== undefined){
                    clearTimeout(timer);
                    timer = undefined;
                }
            }

            /**
             * 判断是否符合条件，如果符合条件就执行swipe事件
             * @param  el     {HTMLElement}  元素
             * @param  event  {Event}        Touch原始事件
             * @param  return 如果执行了事件，就返回true。
             */
            function execSwipe(el, event){
                if(startPoint && endPoint && swipeDirection(startPoint.x, startPoint.y, endPoint.x, endPoint.y) === swipe){
                    callback.call(el, event);
                    return true;
                }
            }

            el.addEventListener('touchstart', function(event){
                var self = this, touchPoint = event.touches[0];

                if(isStopPropagation){
                    event.stopPropagation();
                }

                if(isPreventDefault){
                    event.preventDefault();
                }

                startPoint = {
                    x: Math.floor(touchPoint.clientX),
                    y: Math.floor(touchPoint.clientY)
                };

                timer = setTimeout(function(){
                    //如果超时，清空本次touch数据
                    clearSwipe();
                }, touch.duration);
            });

            el.addEventListener('touchmove', function(event){
                var self = this, touchPoint = event.touches[0];

                if(isStopPropagation){
                    event.stopPropagation();
                }

                if(isPreventDefault){
                    event.preventDefault();
                }

                if(startPoint){
                    endPoint = {
                        x: Math.floor(touchPoint.clientX),
                        y: Math.floor(touchPoint.clientY)
                    };

                    //执行swipe事件判断，是否符合触发事件
                    if(triggerOnMove){
                        if(execSwipe(self, event)){
                            clearSwipe();
                        }
                    }
                }
            });

            el.addEventListener('touchend', function(event){
                if(isStopPropagation){
                    event.stopPropagation();
                }

                if(isPreventDefault){
                    event.preventDefault();
                }

                execSwipe(self, event);
                //清除本次touch数据
                clearSwipe();
            });
        }

        /**
         * @param  el        {HTMLElement}  HTML元素
         * @param  callback  {Function}     事件回调函数
         * @param  options   {Object}       可选参数
         *                   isStopPropagation  {Boolean}  是否停止冒泡，true为停止冒泡
         *                   isPreventDefault   {Boolean}  是否阻止默认事件，true为阻止默认事件
         *                   triggerOnMove      {Boolean}
         *                                       swipe事件有两种触发方式，一种是在touchmove过程中，只要满足滑动距离条件即触发。
         *                                       一种是在touchend中，进入滑动距离判断，如果满足滑动距离触发。
         *                                       默认值为false，在touchend中触发。
         */
        touch.swipeLeft = function(el, callback, options){
            if(options){
                bindSwipe(el, 'swipeLeft', callback, options.triggerOnMove, options.isStopPropagation, options.isPreventDefault);
            }else{
                bindSwipe(el, 'swipeLeft', callback);
            }

        };

        touch.swipeRight = function(el, callback, options){
            if(options){
                bindSwipe(el, 'swipeRight', callback, options.triggerOnMove, options.isStopPropagation, options.isPreventDefault);
            }else{
                bindSwipe(el, 'swipeRight', callback);
            }
        };

        touch.swipeUp = function(el, callback, options){
            if(options){
                bindSwipe(el, 'swipeUp', callback, options.triggerOnMove, options.isStopPropagation, options.isPreventDefault);
            }else{
                bindSwipe(el, 'swipeUp', callback);
            }
        };

        touch.swipeDown = function(el, callback, options){
            if(options){
                bindSwipe(el, 'swipeDown', callback, options.triggerOnMove, options.isStopPropagation, options.isPreventDefault);
            }else{
                bindSwipe(el, 'swipeDown', callback);
            }
        };

        return touch;
    })();

    // 注册jquery方法
    if($ && $.fn){
        $.fn.extend({
            /**
             * 模拟touch swipe事件，支持链式调用。
             * @param   name      {String}    swipe事件名称，值有swipLeft、swipeRight、swipeUp、swipeDown。
             * @param   callback  {Function}  swipe事件回调函数
             * @param   opts      {Object}    可选参数
             *                                isStopPropagation  {Boolean}  是否停止冒泡，true为停止冒泡
             *                                isPreventDefault   {Boolean}  是否阻止默认事件，true为阻止默认事件
             *                                triggerOnMove      {Boolean}  swipe事件有两种触发方式，一种是在touchmove过程中，只要满足滑动距离条件即触发。
             *                                                              一种是在touchend中，进入滑动距离判断，如果满足滑动距离触发。
             *                                                              默认值为false，在touchend中触发。
             */
            rhuiSwipe: function(name, callback, opts){
                var fnSwipe = Rhui.mobile[name];

                if(this.length > 0 && fnSwipe){
                    this.each(function(){
                        fnSwipe(this, callback, opts);
                    });
                }

                return this;
            }
        });
    }
})(window, $);