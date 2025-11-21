public class Task_ThreadCreationUsingLambda {

    // WAJP to print number from 1 to 5 using Thread with the help of Runnable interface
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}