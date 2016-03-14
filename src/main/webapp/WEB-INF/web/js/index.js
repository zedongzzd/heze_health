import 'babel-polyfill'
import React from 'react'
import { render } from 'react-dom'
import { Router , hashHistory } from 'react-router'
import createRoutes from './routes'
import "./utils/setRem";
import "./utils/dateExpand";


// console.debug(Hello);
window.onload = e =>{
  // document.body.style.minHeight=document.documentElement.clientHeight+"px";
  render(
    <Router history={hashHistory} routes={createRoutes()} />,
    document.getElementById('root')
  )
}
