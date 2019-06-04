package LeetCode;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        int[] in = {1, 2 ,3};
        ArrayList<ArrayList<Integer>> arrayLists = permuteUnique(in);
        System.out.println(arrayLists);
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();
        returnList.add(new ArrayList<>());

        for (int i = 0; i < num.length; i++) {
            Set<ArrayList<Integer>> currentSet = new HashSet<>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> T = new ArrayList<>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            returnList = new ArrayList<>(currentSet);
        }

        return returnList;
    }
}
