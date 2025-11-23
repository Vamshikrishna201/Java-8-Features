package v_8_Stream_API;

import java.util.List;
import java.util.stream.Stream;

//flatMap - example 2
public class ex7_Stream {
    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

//      nums.stream().forEach(i -> System.out.println(i));

        Stream<Integer> flatMap = nums.stream().flatMap( i -> i.stream());

        flatMap.forEach(i -> System.out.println(i));

    }
}
