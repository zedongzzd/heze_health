import $ from "jquery";

export function getHospitals(callBack){
  $.getJSON("/data/hospitals.json",{},data => {
    if(callBack && typeof callBack == "function"){
      callBack(data);
    }
  });
}
