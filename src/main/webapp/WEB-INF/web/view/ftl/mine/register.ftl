<#if registers??>
    <#list registers as r>
    <div class="w bg-white pr bdtb mt15">
      <div class="hht70 fz16 	bdb-ccc pr">
        <label class="fz30 fz-b ml20">
          挂号单
        </label>
        <span class="fr r10 pa t0 p10"><div class="w110 fr tc fz26 hht50 fc-orange">取消挂号</div></span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="fc-grey">医&emsp;&emsp;院：</label>
        <span class="fz26">${r.hospName!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="fc-grey">挂&ensp;号&ensp;人：</label>
        <span class="fz26">${r.patientName!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="fc-grey">科&emsp;&emsp;室：</label>
        <span class="fz26">${r.deptName!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="fc-grey">预约时间：</label>
        <span class="fz26">${r.createDate!""}</span>
      </div>
      <div class="txt-ellipsis ml20 fz28 hht50">
        <label class="fc-grey">就诊位置：</label>
        <span class="fz26 ">${r.address!""}</span>
      </div>
    </div>
    </#list>
</#if>

