<#if patients??>
<#list patients as p>
  <div  patientId="${p.patientId}" class="pat_item txt-ellipsis pr item-choice w hht140 bg-white pr mt15">
      <div class="ml20 fz30 hht70 w500">
        <label class="fc-grey">姓&emsp;名：</label>
        <span class="fz28">${p.name}</span>
      </div>
      <div class="txt-ellipsis ml20 fz30 hht70">
        <label class="fc-grey">身份证：</label>
        <span class="fz28">${p.idCard}</span>
      </div>
      <span class="pa r20 dp-inlb h icon-enter t0"></span>
  </div>
</#list>
</#if>