

<header class="fixed-top">
  <a href="${titleBar.backUrl!''}" id="header-left" class="back"></a>
  <div class="title">${titleBar.title!""}</div>
<#if (titleBar.mineUrl?? && titleBar.mineUrl!="")>
    <#if (titleBar.mineText?? && titleBar.mineText !="")>
      <a  href="${titleBar.mineUrl!""}" class="font" id="header-right">${titleBar.mineText}</a>
    <#else>
      <a  href="${titleBar.mineUrl!""}" class="touxiang" id="header-right"></a>
    </#if>

</#if>

</header>

<div id="preloader" class="preloader-indicator-overlay none" style="z-index: 99999999999;">
  <div class="preloader-indicator-modal">
    <span class="preloader preloader-white"></span>
  </div>
</div>