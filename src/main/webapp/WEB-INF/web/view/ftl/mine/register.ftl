<#if registers??>
    <#list registers as r>
    <div class="w bg-white pr bdtb mt15 item-registers <#if r.state?? && r.state == -1>fc-ccc</#if>" appId="${r.apptId!''}">
      <div class="hht70 fz16 	bdb-ccc pr">
        <label class="fz30 fz-b ml20">
          挂号单
        </label>
        <span class="fr r10 pa t0 p10 reg-state" end="false" state="${r.state!''}" >
          <#if r.state?? && r.state == -1>
            <div class="w110 fr tc fz26 hht50">已取消</div>
          <#elseif r.state?? && r.state == 0 && !r.isOverTime>
            <div class="w110 fr tc fz26 hht50 fc-orange state-btn" appId="${r.apptId!''}">取消挂号</div>
          <#elseif r.state?? && r.state == 0 && r.isOverTime>
            <div class="w110 fr tc fz26 hht50">已完成</div>
          </#if>
        </span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="<#if r.state?? && r.state == -1>fc-ccc<#else>fc-grey</#if>">医&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院：</label>
        <span class="fz26">${r.hospName!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="<#if r.state?? && r.state == -1>fc-ccc<#else>fc-grey</#if>">挂&nbsp;&nbsp;号&nbsp;&nbsp;人：</label>
        <span class="fz26">${r.patientName!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="<#if r.state?? && r.state == -1>fc-ccc<#else>fc-grey</#if>">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;室：</label>
        <span class="fz26">${r.deptName!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="<#if r.state?? && r.state == -1>fc-ccc<#else>fc-grey</#if>">预约时间：</label>
        <span class="fz26">${r.hDate!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="<#if r.state?? && r.state == -1>fc-ccc<#else>fc-grey</#if>">就诊位置：</label>
        <span class="fz26 ">${r.address!""}</span>
      </div>
    </div>
    </#list>
</#if>

