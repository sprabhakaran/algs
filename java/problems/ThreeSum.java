import java.util.*;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

    private static void sum(int[] arr) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                for(int k=2; k<arr.length; k++){
                    if((i == j) && (j == k)){
                        continue;
                    }
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> l = new ArrayList<>();
                        addToList(l, arr[i]);
                        addToList(l, arr[j]);
                        addToList(l, arr[k]);

                        if(alreadyExists(list, l)){
                            continue;
                        }
                        list.add(l);
                    }
                }
            }
        }
        System.out.println(list);
    }

    private static void addToList(List<Integer> l, int el){
        if(l.contains(el)){
            return;
        }
        l.add(el);
    }

    private static boolean alreadyExists(List<List<Integer>> list, List<Integer> l) {
        for(List<Integer> el : list){
            Set set = new TreeSet(el);
            System.out.println(" el : " + el + "  l : " + l);
            if(set.equals(new TreeSet(l))){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        sum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
