<#--余号颜色设置-->
<#macro NumColor num>
<#assign num=1>
<#if num?number <= 0>
fc-grey
<#elseif num?number <= 10>
fc-red
<#else>
fc-black
</#if>
</#macro>

<#--空值颜色修改-->
<#macro EmptyColor value>
    <#if value??>fc-black <#else> fc-ccc </#if>
</#macro>

<#--默认值-->
<#macro dftVal val dfl>
    <#if !(val??) && val != "">
    ${val}
    <#else>
    ${dfl}
    </#if>
</#macro>

<#---->
<#macro weekCN date>

</#macro>


