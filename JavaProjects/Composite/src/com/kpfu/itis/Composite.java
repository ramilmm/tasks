package com.kpfu.itis;

import java.util.ArrayList;
import java.util.List;

abstract class SubExpression {

    int value() {
        return 0;
    }

    void plus(SubExpression expr) {

    }

    void minus(SubExpression expr) {

    }

    SubExpression getSubExpression(int index) {
        return null;
    }
}

// Component
class IntegerValue extends SubExpression {

    private int value;

    public IntegerValue(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }
}



// Composite
class Expression extends SubExpression {

    private List<SubExpression> exprs;

    public Expression(SubExpression ... exprs) {
        this.exprs = new ArrayList<SubExpression>();
        for (SubExpression expr : exprs) {
            this.exprs.add(expr);
        }
    }

    @Override
    public void plus(SubExpression expr) {

        exprs.add(expr);
    }

    @Override
    public void minus(SubExpression expr) {

        exprs.add(new IntegerValue(-1*expr.value()));
    }

    @Override
    public SubExpression getSubExpression(int index) {
        return exprs.get(index);
    }

    @Override
    public int value() {
        int result = 0;

        for (SubExpression expr: exprs) {
            result += expr.value();
        }

        return result;
    }
}


//Использование
public class Composite {
    public static void main(String[] args) {
        // Вычислим выражение : 30 - (2 + (10 - 5) ) + (15 - 5))
        // Приведем к виду :  30 - (a - c) - b
        SubExpression expr = new Expression();

        expr.plus(new IntegerValue(30));

        SubExpression c = new Expression(new IntegerValue(10),new IntegerValue(-5));

        SubExpression a = new Expression(new IntegerValue(2), c);
        SubExpression b = new Expression(new IntegerValue(15), new IntegerValue(-5));

        expr.minus(a);
        expr.plus(b);

        System.out.println(expr.value());
    }
}
