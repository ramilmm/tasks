//var a = 5;
//alert(typeof(a) )

//alert(null || 2 && 3 || 1); ->3

//alert(alert(1) && alert(2)); ->1,undefined

//alert(1 && null && 2); ->null

//alert(alert(1) || 2 || alert(2)); ->1,2

//alert(null || 2 || undefined);

//alert(null > 0);
//alert(null >= 0);
//alert(null == 0);
//var b;
//alert(b);
//alert(b++);
//alert(++b);

//var x = 2 + '1';
//alert(x);
//x = '2' - 1;
//alert(x);
//function f(a,b){
// b = b + 3;
// }

//f(1;) - ��� ����� �������� ������� -> b - undefined

//var age = prompt("How old are you? ",defaultStatus);
//alert("0-10 : kid\n" +
//    "11-20 : teenage\n" +
//    "21-100 : oldpeople\n");
//if(age <= 10){
//    alert("you are kid");
//}else if(age <=20 && age > 10){
//    alert("you are teenage");
//}else if(age <=100 && age > 20){
//    alert("you are oldpeople");
//}
//var agree = confirm("Are you agree with this test?");
//alert(agree);

//var a;
//function func(){
//    if(a==a){
//        var k = 0;
//    }
//    alert(k);
//    return 5;
//}
//alert(func());
//
//var f = function(){
//  alert("FUNCTION IS LIVE!!!");
//    return true;
//};
//alert(f());

//var a = 1,f;
//if(a == 1){
//   f = function() {alert(1)}
//}else{
//   f = function() {alert(2)}
//}
//f();

//var a = 5,b = 0;
//function aa(){
//    return a;
//}
//alert("Function a - " + aa());
//function f(aa){
//    return b + aa();
//}
//alert("Function b was worked!");
//alert("Function b - " + f(aa));

//var n = 1;
//var f = function(n) {
//    return n ? n * f(n - 1) : 1;
//};
//var g = f;
//f = null;
//alert(g(5)); //�� ��������

//var f1 = function f2(n){
//    return n ? n*f2(n-1) : 1;
//};
//alert(f1(5)); // ��������
//alert(f2(2)); //�� ��������
//var g = f1;
//f1 = null;  //��������
//alert(g(3));

//function g(){ alert(1)}
//alert(g);

//DZ -Fibbonachi row - realization with cycle and recursive;          FIBBONACHI
//function fib(n){
//    if(n == 1){
//        return 1;
//    }
//    if(n == 2){
//        return 1;
//    }
//    return fib(n-1)+ fib(n-2);
//}
//alert(fib(20));
//
//function fibCycle(n){
//    var a = 1,b = 1,tmp = 0,counter = 2;
//    if(n == 1) return 1;
//    if(n == 2) return 1;
//    while(counter < n){
//        tmp = a + b;
//        a = b;
//        b = tmp;
//        counter++;
//    }
//    return tmp;
//}
//
//alert(fibCycle(6));

//function pascalTriangle(n){                           PASCAL TRIANGLE
//    var str;
//    var formula = 1;
//    str = formula + " ";
//    alert(str);
//    for(var k = 0;k < n;k++){
//
//        for(var i = 1;i <= k;i++){
//            formula *=(n - k + 1);
//            formula /=k;
//            str += formula;
//        }
//        str += "\n";
//    }
//    alert(str);
//}
//
//alert(pascalTriangle(5));



//var obj = {
//    1:'7',
//    2:'8',
//    3:'9',
//    4:{1:5}
//};
//var f = function copy(obj){
//    var obj2 = {};
//    for(var i in obj) {
//        if(typeof(obj[i]) == 'object'){
//            obj2[i] = copy(obj[i]);
//        }else {
//            obj2[i] = obj[i];
//        }
//        return obj2;
//    }
//
//};
//f(obj);
//for (var i in obj2){
//    alert(obj2[i]);
//}



////                                                                      Решето Эратосфера
//function f(){
//    var array = [];
//    var res = '';
//    for(var i = 2; i <= 100; i++){
//        array[i] = true;
//    }
//    var count = 2;
//    while (true){
//        for(var i = 2; i < array.length; i++){
//            if(i != count && i % count == 0) array[i] = false;
//        }
//        count++;
//        if(count == array.length - 1) break;
//    }
//
//    for(var i = 2; i < array.length; i++){
//        if(array[i]) res+=i;
//    }
//    alert(res);
//}
//
//alert(f());
//
//                                                                     //'first-name' -> 'firstName';
//var array = {};
//var g = function f(str){
//    var array = str.split('');
//    var result = '';
//    for(var i = 0; i < array.length; i++){
//        if(array[i] == '-'){
//            result += array[i + 1].toUpperCase();
//            i += 1;
//        }else
//            result += array[i];
//    }
//    return result;
//};
//
//alert(g('first-name-privet'));


//function sum(){
//    var result = 0;
//    for (var i = 0; i < arguments.length; i++){
//        if(typeof(arguments[i]) == 'number'){
//            result = result + arguments[i];
//        }else {
//            return 'It is not a number : ' + arguments[i];
//        }
//    }
//    return result;
//}
//alert(sum(5,2,2,2,11,15));

