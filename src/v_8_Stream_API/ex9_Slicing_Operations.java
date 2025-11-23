package v_8_Stream_API;

import java.util.Arrays;
import java.util.List;

public class ex9_Slicing_Operations {
    public static void main(String[] args) {
        //Slicing Operations using,  limit(), skip(), .destntion()

        List<String> nums = Arrays.asList("one", "two", "three", "four", "five");

        //limit() -> returns a stream with the first nelements.
        nums.stream().limit(3).forEach(c -> System.out.println(c+""));// one two three

        //skip() -> Skips first n elements in a stream
        nums.stream().skip(4).forEach(c -> System.out.println(c)); // five

        //distinct() -> Removes duplicate elements from the stream
        List<Integer> n = Arrays.asList(1, 2, 3, 1, 2, 4, 5, 6, 4, 7);

        n.stream().distinct().forEach(i-> System.out.print(i+" ")); //1 2 3 4 5 6 7

//        ------------------------------------------

        // mixed example
        List<Integer> list = List.of(1,2,2,3,3,4,5,6,7,8);

        list.stream()
                .distinct()   // remove dupes → 1,2,3,4,5,6,7,8
                .skip(2)      // skip first 2 → 3,4,5,6,7,8
                .limit(3)     // take first 3 → 3,4,5
                .forEach(System.out::println);
    }
}
