package com.own.algorithm.leetcode;


public class BracketsValid {

    public static void main(String[] args) {
        System.out.println(new BracketsValid().isValid("{[]"));
    }
    public boolean isValid(String s) {


        BracketStack bracketStack = new BracketStack(s.length());
        char[] bracketArray = s.toCharArray();

        for (char  ch : bracketArray) {
            if (ch ==  '(' || ch == '{' || ch == '[') {
                bracketStack.push(ch);
            } else {
                char popCh = bracketStack.pop();
                boolean valid = isValid(popCh, ch);
                if (!valid){
                    return false;
                }
            }

        }

        if (bracketStack.size() != 0) {
            return false;
        }

        return true;

    }

    boolean isValid(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')'){
            return true;
        }

        if (ch1 == '{' && ch2 == '}'){
            return true;
        }

        if (ch1 == '[' && ch2 == ']'){
            return true;
        }

        return false;
    }

    class BracketStack {
        public BracketStack(int size) {
            this.bracketStack = new char[size];
        }

        char[] bracketStack;
        int index = 0;
        public void push(char ch) {
            bracketStack[index ++] = ch;
        }

        public char pop(){
            if (index == 0) {
                return ' ';
            }
            return bracketStack[--index];
        }

        public int size() {
            return index;
        }
    }

}
