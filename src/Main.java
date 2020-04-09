public class Main {

    private void run() {
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " ms");
    }
}
