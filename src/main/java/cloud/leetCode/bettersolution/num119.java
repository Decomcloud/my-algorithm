package cloud.leetCode.bettersolution;

import java.util.ArrayList;
import java.util.List;

public class num119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        rowIndex++;
        list.add(0);
        while (rowIndex > 1){
            List<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            for (int j = 1; j < list.size() ; j++) {
                innerList.add(list.get(j) + list.get(j - 1));
            }
            innerList.add(1);
            list = innerList;
            rowIndex --;
        }
        return list;
    }


    public static void main(String[] args) {
        List<Integer> list = getRow(3);
        for (int i: list){
            System.out.print(i);
        }
    }

}
