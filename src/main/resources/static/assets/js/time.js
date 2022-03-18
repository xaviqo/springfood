$(document).ready(function () {
  
});

function parseTime(date) {

  return new Date(date).toLocaleDateString(
    [getLang(), 'en-gb'],
    {
      year: 'numeric',
      month: 'numeric',
      day: 'numeric',
      hour: "2-digit",
      minute: "2-digit"
    }
  );

}

function getLang() {
  if (navigator.languages != undefined)
    return navigator.languages[0];
  return navigator.language;
}

function currentTime() {

  let date = new Date();
  let hh = date.getHours();
  let mm = date.getMinutes();
  let ss = date.getSeconds();
  let session = "AM";

  if (hh === 0) {
    hh = 12;
  }
  if (hh > 12) {
    hh = hh - 12;
    session = "PM";
  }

  hh = (hh < 10) ? "0" + hh : hh;
  mm = (mm < 10) ? "0" + mm : mm;
  ss = (ss < 10) ? "0" + ss : ss;

  let time = hh + ":" + mm + ":" + ss + " " + session;

  return time;
  
}
