function checkInput(e){
    if(e.value.slice(-1) == '+' ){
        e.value += String.fromCharCode(e.keyCode);
    }else {
        var c = e.value.replace(/(\D+)/, '');
        if (c != e.value) {
            e.value = c;
        }
    }
}
function checkFormat(e){
    if(/^(\+7|8)(\(\d{3}\)|\d{3})\d{7}$/.test(e.value)){
        alert('alright!');
    }else alert('wrong number');
}