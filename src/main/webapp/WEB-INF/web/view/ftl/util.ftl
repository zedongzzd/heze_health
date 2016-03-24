<#--余号颜色设置-->
<#macro NumColor num>
<#if num <= 0>
${"fc-grey"}
<#elseif num <= 10>
${"fc-red"}
<#else>
${"fc-black"}
</#if>
</#macro>



