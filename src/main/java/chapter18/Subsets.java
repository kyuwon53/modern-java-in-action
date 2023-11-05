package chapter18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    private static <TYPE> List<List<TYPE>> concat(List<List<TYPE>> sub1, List<List<TYPE>> sub2) {
        List<List<TYPE>> result = new ArrayList<>(sub1);
        result.addAll(sub2);
        return result;
    }

    private static <TYPE> List<List<TYPE>> insertAll(TYPE first, List<List<TYPE>> lists) {
        List<List<TYPE>> result = new ArrayList<>();
        for (List<TYPE> list : lists) {
            List<TYPE> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }
}
