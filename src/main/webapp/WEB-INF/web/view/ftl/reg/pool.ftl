<#include "../util.ftl"/>
<#if scheduals??>
  <#list scheduals as s>
  <div class="txt-ellipsis hht88 pr fc-grey bdt schedule">
    <label id="time" class="ml20 dp-inlb w150 tc txt-ellipsis fz26">${s.date}</label>
    <label class="ml20 dp-inlb w150 tc txt-ellipsis fz26">${weeks[s_index]}</label>
    <label id="day" class="dp-inlb w110 tc txt-ellipsis fz26">
      ${dayName[s_index]}
    </label>
    <label class="dp-inlb w130 tc txt-ellipsis fz26 none">剩余
      <label class="left-num <@NumColor num='${s.resNo}'/>">${s.resNo}</label>
    </label>
    <span  rBASId="${s.id!""}" class=" t15 w110 tc pa bdr-5 tc fz26 <#if (s.resNo?number > 0 || true)>bd-cyan fc-cyan<#else>fc-grey bd-grey</#if> r20 hht50">预约</span>
  </div>
  </#list>
</#if>
