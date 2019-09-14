package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 6};
        List<List<Integer>> lists = new CombinationSum().combinationSum(array, 10);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        combinationSum(resultList, tmpResult, 0, candidates, target);

        return resultList;
    }

    public void combinationSum(List<List<Integer>> resultList, List<Integer> tmpResult,
                               int curIndex, int[] candidates, Integer remain) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            resultList.add(new ArrayList<>(tmpResult));
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            tmpResult.add(candidates[i]);
            combinationSum(resultList, tmpResult, i, candidates, remain - candidates[i]);
            tmpResult.remove(tmpResult.size() - 1);
        }


    }

}
