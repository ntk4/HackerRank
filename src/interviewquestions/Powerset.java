package interviewquestions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem and solution from Cracking the coding interview 6th edition, page 348
 * @author ntk4
 *
 */
public class Powerset {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = getSubsets(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,0)), 0);
        System.out.println(list);
    }

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) {// Base case - add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // Empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
}
