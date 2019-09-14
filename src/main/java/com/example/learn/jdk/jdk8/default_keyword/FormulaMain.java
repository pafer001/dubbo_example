package com.example.learn.jdk.jdk8.default_keyword;

/**
 * Created by pafer on 17-4-28.
 */
public class FormulaMain {

    public static void main(String[] args) {

        Formula formula = new Formula() {

            @Override
            public double calculate(int a) {
                return sqrt(a* 100);
            }
        };

        System.out.println(formula.sqrt(100));

        System.out.println(formula.sqrt(10));

    }


}
