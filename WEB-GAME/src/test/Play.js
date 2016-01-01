$(document).ready(function () {
    alert('Welcome to Christmas version of the game Reaction.\n'+
        'Rules of the game:\n'+
        '-The Game starts with pressing the space bar\n'+
        '-As Soon as the corresponding image, the player must press a button\n'+
        '-Winning the one who has less time\n');
    $('#start').on('keydown', function (e) {

        $("#imgD").replaceWith(function(){
            return "<img src=\"" + "../img/santa_claus1.jpg\"" + " class=\"img-circle img\"" + ">";
        });
        $("#imgK").replaceWith(function(){
            return "<img src=\"" + "../img/santa_claus1.jpg\"" + " class=\"img-circle img\"" + ">";
        });

        if (e.keyCode == 32) {
            $('#D').css('display', 'none');
            $('#K').css('display', 'none');

            game();

            isStarted = true;

        }
        if (e.keyCode == keyCode && isStarted) {
            unshow(idOfShown);
            dehighlight(idOfShown);
            endTime = Date.now();
            if (keyCode == 68) {
                timeD += endTime - startTime;
            } else if (keyCode == 75) {
                timeK += endTime - startTime;
            }

            if (i < 10) {
                setTimeout(game, RandomInt(500, MAXTIME));
            } else {
                finish();
            }
        }
    });

    var timeD = 0, timeK = 0;
    var startTime = 0, endTime = 0;
    var MAXTIME = 4000;
    var isStarted = false;
    var keyCode = 0;
    var idOfShown = '';
    var i = 0;


    function game() {
        i++;
        if (step) {
            show('#D');
            highlight('#keyD');
            idOfShown = '#D';
            keyCode = 68;
            startTime = Date.now();
            step = !step;
        } else {
            show('#K');
            highlight('#keyK');
            idOfShown = '#K';
            keyCode = 75;
            startTime = Date.now();
            step = !step;
        }


    }
    if(RandomInt(0,1) == 0){
        var step = false;
    }else var step = true;

    function highlight(id) {
        if (id == '#keyD') {
            $(id).css('background-color', '#ffb533');
        } else {
            $(id).css('background-color', '#00f3b5');
        }
    }

    function dehighlight() {
        $('#keyD').css('background-color', '#FFA200');
        $('#keyK').css('background-color', '#00A67C');

    }

    function show(id) {
        $(id).css('display', 'block');
    }

    function unshow(id) {
        $(id).css('display', 'none');
    }

    function RandomInt(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }


    function finish() {
        $("#GameArea").replaceWith(function(){
            return "<img style=\""+"width: 100%"+"\""+" src=\""+"../img/end.jpg"+"\""+">";
        });
        if (timeD > timeK) {
            alert('The Player \'K\' WIN!!!' +
                '\nfinal time Player \'K\' : ' + timeK +
                '\nfinal time Player \'D\' : ' + timeD);
        } else if (timeK > timeD) {
            alert('The Player \'D\' WIN!!!' +
                '\nfinal time Player \'K\' : ' + timeK +
                '\nfinal time Player \'D\' : ' + timeD);
        } else {
            alert('Ничья!' +
                '\nfinal time Player \'K\' : ' + timeK +
                '\nfinal time Player \'D\' : ' + timeD);
        }



    }

});