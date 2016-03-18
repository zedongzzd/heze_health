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

function validatePhone(phone){
  return /^1[3,5,8]\d{9}$/.test(phone);
}

function validateCN(name){
  return /^[\u4e00-\u9fa5]+$/.test(name);
}

function getPageName() {
    var u = location.pathname;
    var a = u.split(/\//);
    var m = a.pop().match(/(?:^|\/)($|[^\.]+)/);

    return m[1] ? m[1] : 'index';
}

function getQuery(pathname,name) {
  // console.debug(pathname,name);
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
   var r = pathname.match(reg);
   if (r!=null) return (r[2]); return null;
}

function getHash(name) {
    var u = location.hash.slice(1);
    var re = new RegExp(name + '=([^&\\s+]+)');
    var m = u.match(re);
    var v = m ? m[1] : '';

    return (v === '' || isNaN(v)) ? v : v - 0;
}

function parseUrl(url) {
    var a = document.createElement('a');

    a.href = (url || 'x.html');

    return {
        host: a.host,
        protocol: a.protocol
    };
}

function serialize(obj) {
    var s = [];

    $.each(obj, function(k, v) {
        s.push(k + '=' + encodeURIComponent(v));
    });

    return s.join('&');
}

function gethashFiled(name){
  let fileds=location.hash.split("/");
  let index=fileds.findIndex((value)=>{
    return name == value;
  });

  return fileds.length >index && fileds[index+1] || "";
}

function parsePostBody(obj){
  var body=[];
  Object.keys(obj).forEach((key)=>{
    body.push(`${key}=${obj[key]}`);
  });

  return body.join("&");
}

function getType(o){
    var _t;
    return ((_t = typeof(o)) == "object" ? o==null && "null" || Object.prototype.toString.call(o).slice(8,-1):_t).toLowerCase();
}

function extend(destination,source){
    for(var p in source)
    {
        if(getType(source[p])=="array"||getType(source[p])=="object")
        {
            destination[p]=getType(source[p])=="array"?[]:{};
            arguments.callee(destination[p],source[p]);
        }
        else
        {
            destination[p]=source[p];
        }
    }
}

var store={
  setObjItem:function(key,item){
    localStorage && localStorage.setItem && localStorage.setItem(key,JSON.stringify(item));
  },getObjItem:function(key){
    var item = localStorage.getItem(key);
    if(item){
      try{
          var eval_item = eval("("+ item +")");
          return eval_item;
      }catch(e){

      }
    }
    return item;
  }
};


function isArray(v){
    return toString.apply(v) === '[object Array]';
}

export {
  parsePostBody,
  validateCN,
  validatePhone,
  validateIdCard,
  getPageName,
  getQuery,
  getHash,
  parseUrl,
  serialize,
  gethashFiled,
  extend,
  store,
  isArray
}
