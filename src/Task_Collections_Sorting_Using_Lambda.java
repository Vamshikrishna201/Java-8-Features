import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task_Collections_Sorting_Using_Lambda {
    // Task: WAJP to store numbers in ArrayList and sort numbers in descending order
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(6);
        al.add(2);
        al.add(7);
        al.add(5);
        al.add(4);
        System.out.println("Before Sort: " + al);

//        Collections.sort(al, new NumberComparator());

        // using collections.sort with lambda is easy
        Collections.sort(al, ( Integer i, Integer j) -> (i> j) ? -1 :1);
        System.out.println("After sort: " + al);
    }
}

class NumberComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i, Integer j) {
        if (i < j) return 1;
        else if (i > j) return -1;
        return 0;
    }
}
