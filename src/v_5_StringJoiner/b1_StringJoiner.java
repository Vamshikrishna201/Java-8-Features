package v_5_StringJoiner;

import java.util.StringJoiner;

public class b1_StringJoiner {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("-");
        sj.add("Started");
        sj.add("Learning");
        sj.add("Java-8");

        System.out.println(sj);

        StringJoiner sj2 = new StringJoiner("-", "(",")");
        sj2.add("Be");
        sj2.add("Self");
        sj2.add("Learner");
        System.out.println(sj2);
    }
}
