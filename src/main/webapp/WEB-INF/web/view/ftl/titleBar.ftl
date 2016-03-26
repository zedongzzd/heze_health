
<header class="hht88 bdb-ccc bg-white">
    <a  href="${titleBar.backUrl!''}" class="dp-inlb pa h icon-back"></a>
    <div class="fz30 tc fc-cyan">${titleBar.title!""}</div>
    <#if (titleBar.mineUrl?? && titleBar.mineUrl!="")>
        <#if (titleBar.mineText?? && titleBar.mineText !="")>
          <a  href="${titleBar.mineUrl!""}" class="dp-inlb pa h r20 t0" id="header-right">常用人</a>
        <#else>
          <a  href="${titleBar.mineUrl!""}" class="dp-inlb pa icon-icontouxiang h r20 t0" id="header-right"></a>
        </#if>

    </#if>
</header>

