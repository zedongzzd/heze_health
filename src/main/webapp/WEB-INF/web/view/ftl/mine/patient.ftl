<#if patients??>
<#list patients as p>


<li patientId="${p.patientId}" class="pr w hht140 mt15 ovh list-li  item-choice" >
  <div  class="pat_item con bg-white pr icon-enter pull-right" style="z-index: 10;">
    <div class="ml20 fz30 hht70">
      <label class="fc-grey">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
      <span class="fz28" name="name">${p.name}</span>
    </div>
    <div class="txt-ellipsis ml20 fz30 hht70">
      <label class="fc-grey">身份证：</label>
      <span class="fz28">${p.idCard}</span>
    </div>
  </div>
  <div class="del">删 除</div>
</li>
</#list>
</#if>

