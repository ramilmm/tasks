//var ladder = {
//    step : 0,
//    up : function(){
//        this.step++;
//        return this;
//    },
//    down : function(){
//        this.step--;
//        return this;
//    },
//    show : function(){
//        alert(this.step);
//        return this;
//    }
//};
//
//ladder.up().down().show();


//function Animal(){
//    var name = '';
//    var boolType = true;
//    this.getsetName = function(){
//        if(arguments.length == 0){
//            return name;
//        }else if(typeof arguments[0] == 'string'){
//            name = arguments[0];
//        }
//    }
//    this.getsetBoolType = function(){
//        if(arguments.length == 0){
//            return boolType;
//        }else if(typeof arguments[0] == 'boolean'){
//            boolType = arguments[0];
//        }
//    }
//}
//
//var animal = new Animal();
//alert(animal.getsetName('Koshka'));
//alert(animal.getsetName());
//
//alert(animal.getsetBoolType(false));
//alert(animal.getsetBoolType());






//function Calc(){
//    this.sum = function () {
//        var tmpSum = 0;
//            for(var i in arguments){
//                tmpSum += arguments[i];
//            }
//        return tmpSum;
//    };
//    this.umn = function() {
//      var tmpUmn = 1;
//        for(var i in arguments){
//            tmpUmn *= arguments[i];
//        }
//        return tmpUmn;
//    };
//}
//
//var calculator = new Calc();
//alert('sum = ' + calculator.sum(2,2,2) + '\numn = ' + calculator.umn(2,2,2));
