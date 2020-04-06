package org.stepik.alg.p01.Fibonacci;

import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final int MOD = (int)(1e+7);

    Map<Integer, BigInteger> cache = new HashMap<>();
    List<BigInteger> mem = new ArrayList<>();

    private void run(int n)
    {
        System.out.println("F" + n + " = " + Fibonacci(n));
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        new Main().run(11);
        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " ms");
    }


    // implementations

    private BigInteger Fibonacci(int n){
        BigInteger prev = BigInteger.ZERO;
        BigInteger next = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            BigInteger tmp = next;
            next = next.add(prev);
            prev = tmp;
        }
        return prev;
    }

    private BigInteger rFibonacci(int n){
        // recursive fibonacci
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        return rFibonacci(n - 1).add(rFibonacci(n - 2));
    }

    private BigInteger TDFibonacci(int n){
        // top-down recursive fibonacci
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        if (cache.containsKey(n)){
            return cache.get(n);
        } else {
            BigInteger res = TDFibonacci(n - 1).add(TDFibonacci(n - 2));
            cache.put(n, res);
            return res;
        }
    }

    private BigInteger BUFibonacci(int n){
        // bottom-up recursive fibonacci
        mem.add(BigInteger.ZERO);
        mem.add(BigInteger.ONE);

        for (int i = 2; i <= n; i++) {
            BigInteger res = mem.get(i-1).add(mem.get(i-2));
            mem.add(res);
        }
        return mem.get(n);
    }

    private int modFibonacci(int n){
        // Fibonacci(n) % MOD
        int prev = 0;
        int next = 1;

        for (int i = 0; i < n; i++) {
            int tmp = (next + prev) % MOD;
            prev = next;
            next = tmp;
        }
        return prev;
    }
}