<#list scheduals as s>
<div class="txt-ellipsis hht88 pr fc-grey bdt">
  <label id="time" class=" ml20 dp-inlb w-20 txt-ellipsis fz26">${s.date}</label>
  <label class="ml20 dp-inlb w-15 txt-ellipsis fz26"></label>
  <label id="day" class="dp-inlb w-15 txt-ellipsis fz26">今天</label>
  <label class="dp-inlb w-1875 txt-ellipsis fz26">剩余
    <label class="left-num ">${s.resNo}</label>
  </label>
        <span class="mtb20 dp-inlb w-15 ">
          <div class="w110 fr bdr-5 bd-cyan tc fz26 fc-cyan hht50 " deptId="${s.deptId}">
            预约
          </div>
        </span>
</div>
</#list>