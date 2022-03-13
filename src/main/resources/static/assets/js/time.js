// https://dockyard.com/blog/2020/02/14/you-probably-don-t-need-moment-js-anymore

function parseTime(date) {

    return new Date(date).toLocaleDateString(
        [getLang(),'en-gb'],
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