package v_8_Stream_API;


import java.util.stream.Stream;

// Parallel Streams -> Generally Stream will execute in sequence order
// - To improve execution process od the stream we can use parallel streams
// - Parallel Streams introduced to improve performance of the program.
public class ex16_Parallel_Stream {
    public static void main(String[] args) {
        //Example - 1
        System.out.println("======== Serial Stream ========");
        Stream<Integer> ss = Stream.of(1, 2, 3, 4, 5,6);
        ss.forEach(n -> System.out.println(n + " :: "+ Thread.currentThread()));

        System.out.println("======== Parallel Strem ========");
        Stream<Integer> ps = Stream.of(1, 2, 3, 4,5,6);
        ps.parallel()
                .forEach(n -> System.out.println(n+ " ::" + Thread.currentThread()));

    }

}
