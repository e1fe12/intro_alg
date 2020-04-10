package org.stepik.alg.p03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private int binarySearch(int[] a, int k){
        int l = 0;
        int r = a.length;
        while (l + 1 < r){
            int mid = l + (r - l) / 2;
            if (a[mid] <= k){
                l = mid;
            } else {
                r = mid;
            }
        }
        return a[l] == k ? l + 1 : -1;
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int k = in.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < k; i++) {
            b[i] = in.nextInt();
        }
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(a[i], i);
        }
        for (int x : b) {
            //System.out.print(binarySearch(a, x) + " ");
            int ans = pos.containsKey(x) ? pos.get(x) + 1 : -1;
            System.out.print(ans + " ");
        }
        System.out.println("\b");
    }

    public static void main(String[] args) throws FileNotFoundException {

        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " ms");
    }
}
