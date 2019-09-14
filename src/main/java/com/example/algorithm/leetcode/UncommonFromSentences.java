package com.example.algorithm.leetcode;

import java.util.*;

public class UncommonFromSentences {

    public static void main(String[] args) {

        String[] strings = new UncommonFromSentences().uncommonFromSentences("apple apple",
                "banana");
        System.out.println(strings);
    }

    public String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> wodMap = new HashMap<>();
        wordMap(A, wodMap);
        wordMap(B, wodMap);



        List<String> returnList = new ArrayList<>();

        String[] aWordArray = A.split(" ");
        for (String aWord : aWordArray) {
            if (wodMap.getOrDefault(aWord, 1) == 1) {
                returnList.add(aWord);
            }
        }

        String[] bWordArray = B.split(" ");
        for (String bWord : bWordArray) {
            if (wodMap.getOrDefault(bWord, 1) == 1) {
                returnList.add(bWord);
            }
        }

        return returnList.toArray(new String[returnList.size()]);

    }

    private void wordMap(String A, Map<String, Integer> wodMap) {
        String[] wordArray = A.split(" ");
        for (String word : wordArray) {
            Integer orDefault = wodMap.getOrDefault(word, 0);
            wodMap.put(word, orDefault+1);
        }
    }

}
