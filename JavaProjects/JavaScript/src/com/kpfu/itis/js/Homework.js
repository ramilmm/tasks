//                                                  FIBBONACHI(recursive)
function fib(n){
    if(n == 1){
        return 1;
    }
    if(n == 2){
        return 1;
    }
    return fib(n-1)+ fib(n-2);
}
alert(fib(7));

//                                                   FIBBONACHI(cycle)
function fibCycle(n){
    var a = 1,b = 1,tmp = 0,counter = 2;
    if(n == 1) return 1;
    if(n == 2) return 1;
    while(counter < n){
        tmp = a + b;
        a = b;
        b = tmp;
        counter++;
    }
    return tmp;
}

alert(fibCycle(6));

//                                                                      PASCAL TRIANGLE
function pascalTriangle(count){
    var formula = 1;
    var str = '';
    for(var n = 0;n < 10;n++){

        str += 1 + " ";
        for(var k = 1;k <= n;k++){
            formula *= (n - k + 1);
            formula /= k;
            str += formula + ' ';
        }
        str +="\n";
        alert(str);
    }
}

alert(pascalTriangle(5));



//                                                                      Решето Эратосфера
function f(){
    var array = [];
    var res = '';
    for(var i = 2; i <= 100; i++){
        array[i] = true;
    }
    var count = 2;
    while (count < array.length){
        for(var i = 2; i < array.length; i++){
            if(i != count && i % count == 0) array[i] = false;
        }
        count++;
    }

    for(var i = 2; i < array.length; i++){
        if(array[i]) res+=i;
    }
    alert(res);
}

alert(f());

//                                                          'first-name' -> 'firstName';
var array = {};
var g = function f(str){
    var array = str.split('');
    var result = '';
    for(var i = 0; i < array.length; i++){
        if(array[i] == '-'){
            result += array[i + 1].toUpperCase();
            i += 1;
        }else
            result += array[i];
    }
    return result;
};

alert(g('first-name-privet'));
