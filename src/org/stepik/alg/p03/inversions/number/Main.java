package org.stepik.alg.p03.inversions.number;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private int[] a;
    private int[] temp;
    private static long cnt = 0;
    private void merge(int l, int m, int r){
        int i = l, j = m;

        for (int k = l; k < r; k++) {
            if (j == r || (i < m && a[i] <= a[j])){
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
                cnt += m - i;
            }
        }
        System.arraycopy(temp, l, a, l, r - l);
    }

    private void mergeSort(int l, int r){
        if (r - l == 1) return;
        int m = l + (r - l) / 2;

        mergeSort(l, m);
        mergeSort(m, r);
        merge(l, m, r);
    }
    private void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        temp = new int[n];
        a = new int[n];
        String[] tokens  = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        mergeSort(0, a.length);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " ms");
    }
}
