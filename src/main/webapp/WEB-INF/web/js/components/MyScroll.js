import React, { Component, PropTypes } from "react"
import IScroll from '../helper/iscroll';

export default class MyScroll extends Component{
  componentWillMount(){
    this.preventDefault= (e) => { e.preventDefault(); }
  }

  componentWillUnmount(){
    document.removeEventListener('touchmove', this.preventDefault );
  }

  componentDidMount(){
    document.addEventListener('touchmove', this.preventDefault );

    let pullDownEl = document.getElementById('scroller-pullDown'),
        pullDownOffset = pullDownEl && pullDownEl.offsetHeight,
        pullUpEl = document.getElementById('scroller-pullUp'),
        pullUpOffset =  pullUpEl && pullUpEl.offsetHeight;

    let  myScroll = new IScroll('#wrapper', {
        probeType    : 3,
        mouseWheel   : true,
        taps:true,
        click:true
    });

    myScroll.on("scroll",e => {

      let myScroll = this.myScroll;

      let diffY=myScroll.maxScrollY-myScroll.y;

      const {  page ,pageSize , selectType , source , children :{ props : {className}} } = this.props;
      // console.debug((page -1)*pageSize == source.length,this.myScroll.scrollerHeight,document.documentElement.clientHeight,document.querySelector(`.${className.split(" ").join(".")}`).offsetHeight);
      if( (page -1)*pageSize == source.length){
        if (diffY >= pullUpOffset && !pullUpEl.className.match('flip')) {
            pullUpEl.className = 'flip';
            pullUpEl.querySelector('.pull-up-msg').innerHTML = '松手开始更新...';

        } else if (diffY <= pullUpOffset && diffY >= 0 && pullUpEl.className.match('flip')) {
            pullUpEl.className = '';
            pullUpEl.querySelector('.pull-up-msg').innerHTML = '上拉加载更多...';
        }
      }else {
        // console.debug(pullUpEl.querySelector);
        if(this.myScroll.y < this.myScroll.maxScrollY){
          pullUpEl.querySelector('.pull-up-msg').innerHTML = '没有了...';
        }else{
          pullUpEl.querySelector('.pull-up-msg').innerHTML = '';
        }
      }
    });

    myScroll.on("slideDown",function(){

    });

    myScroll.on("slideUp",e => {
      if(this.myScroll.maxScrollY - this.myScroll.y > 40){
        pullUpEl.className = 'loading';
        pullUpEl.querySelector('.pull-up-msg').innerHTML = '加载中...';
        this._pullUpAction();
  		}
    });

    this.myScroll = myScroll;
    window.m=this;
  }

  _pullUpAction(props){
    props = props || this.props;
    const { pageSize ,page , source , pullUpAction } = props;
    if((page-1)*pageSize <= source.length){
      pullUpAction();
    }else{
      document.querySelector('.pull-up-msg').innerHTML = '没有了...';
    }
  }

  componentWillReceiveProps(nextProps){
    const { page ,pageSize , source ,isFetching , pullUpAction , children :{ props : {className}}} = nextProps;
    // console.debug(this.myScroll.scrollerHeight,document.querySelector(`.${className.split(" ").join(".")}`).offsetHeight,document.documentElement.clientHeight);
    if(page == 1 || this.myScroll.scrollerHeight < document.documentElement.clientHeight && !isFetching){
      this._pullUpAction(nextProps);
    }
  }

  componentDidUpdate(){
    this.myScroll.refresh();
  }

  render(){
    const { style , children } = this.props;
    // console.debug(children);
    return (
      <div id="wrapper" style={style}>
        <div id="scroller">
          <div id="scroller-content">
            {children}
            <div id="scroller-pullUp">
              <span id="up-icon" className="icon-double-angle-up pull-up-icon"></span>
              <span id="pullUp-msg" className="pull-up-msg"></span>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
