function doubler(e) {
    var c = e.value;
    var q = c[c.length - 1];
    q.slice(0, -1);
    e.value += q;
}
function hide(e) {
    e.setAttribute('style', 'opacity: 0');
}
function display(e) {
    e.setAttribute('style', 'opacity: 1');
}
function check(e){
    var input = document.getElementsByTagName('input');
    for (var i = 0; i < input.length; i++) {
        if (e == input[i]){
            input[i-1].checked = !input[i-1].checked;
            input[i+1].checked = !input[i+1].checked;
        }
    }
}
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}
$("#btn").hover(function () {
    $(this).css({
        top: getRandomInt(200, 600)+"px",
        left: getRandomInt(0, 1200)+"px"
    });
}, function () { });


$('#span').click(function(){
    var text = '';
    if(window.getSelection){
        text = window.getSelection();
    }else if(document.getSelection){
        text = document.getSelection();
    }
    console.log(text);
    console.log($(this).anchorOffset);
    console.log($(this).focusOffset);
});

$("[title='/url']").replaceWith(function(){
    var url=$(this).prop('title');
    var href="href="+"\""+url+"\"";
    var id="id="+"\""+$(this).prop('id')+"\"";
    var clas="class="+"\"";
    var content=$(this).text();
    $(this).removeClass("must_be_href");
    return "<a "+href+id+clas+$(this).prop('class')+"\""+">"+content+"</a>";
});



function url(e){

}

