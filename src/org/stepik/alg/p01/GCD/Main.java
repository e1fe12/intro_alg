package org.stepik.alg.p01.GCD;

public class Main {

    private void run() {
        System.out.println(euclidGCD(1121*112135, 1121*31232));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " ms");
    }

    // implementations

    private int euclidGCD(int a, int b) {
        // euclidean algorithm
        if (b == 0) return a;
        if (a == 0) return b;

        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int binaryGCD(int p, int q) {
        // euclidean binary algorithm
        if (q == 0) return p;
        if (p == 0) return q;

        if ((p & 1) == 0 && (q & 1) == 0) return binaryGCD(p >> 1, q >> 1) << 1;
        else if ((p & 1) == 0) return binaryGCD(p >> 1, q);
        else if ((q & 1) == 0) return binaryGCD(p, q >> 1);
        else if (p >= q) return binaryGCD((p-q) >> 1, q);
        else return binaryGCD(p, (q-p) >> 1);
    }

    private int naiveGCD(int a, int b) {
        // naive GCD implementation
        assert a > 0 && b > 0;
        int result = 1;
        for (int d = 1; d <= Math.max(a, b); d++){
            if (a % d == 0 && b % d == 0){
                result = d;
            }
        }
        return result;
    }
}