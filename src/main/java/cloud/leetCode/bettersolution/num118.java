package cloud.leetCode.bettersolution;

import java.util.ArrayList;
import java.util.List;

public class num118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows >= 1){
            list.add(new ArrayList<>());
            list.get(0).add(1);
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            List<Integer> preList = list.get( i- 2);
            innerList.add(1);
            for (int j = 1; j < i -1 ; j++) {
                innerList.add(preList.get(j) + preList.get(j - 1));
            }
            innerList.add(1);
            list.add(innerList);
        }
        return list;
    }

    public static void printList(List<List<Integer>> list){
        for (List sublist: list){
            System.out.print(list.indexOf(sublist) + ":");
            for (Object integer: sublist){
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(12);
        printList(list);
    }

}
