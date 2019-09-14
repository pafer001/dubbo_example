package com.example.learn.jvm;

public class EscapeAnalysisClass {
}


class B {

    public void printClassName(G b) {
        System.out.println(getClass().getName());
    }
}


 class G {

    public static B b;

    public void globalVariablePointerEscape() {
        b = new B();
    }

    public B methodPointerEscape() {
        return new B();
    }

    public void instancePassPointerEscape() {
        methodPointerEscape().printClassName(this);
    }
}
