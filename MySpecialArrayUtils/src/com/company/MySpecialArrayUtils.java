package com.company;
import java.math.BigInteger;

public class MySpecialArrayUtils {
    public static void reverse(int[] arr)
    {
        for(int i = 0;i < arr.length/2;i++)
        {
            int tmp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }
        return;
    }
    public static int[] sumEvenOdd(int[] arr)
    {
        int ans[] = new int[2];
        for(int i = 0;i < arr.length;i++)
        {
            if(arr[i] % 2 == 1)
                ans[1] += arr[i];
            else
                ans[0] += arr[i];
        }
        return ans;
    }
    public static double average(int[] arr)
    {
        double ans = 0;
        for(int i = 0;i < arr.length;i++)
            ans += ((double)arr[i] / arr.length);
        return ans;
    }
    public static void moveValue(int[] arr,int val)
    {
        for(int i = 0;i < arr.length;i++)
        {
            if(arr[i] == val)
                continue;
            int j = i-1;
            while(j >= 0 && arr[j] == val)
            {
                arr[j] = arr[j+1];
                arr[j+1] = val;
                j--;
            }
        }
        return;
    }
    public static void transpose(int[][] arr)
    {
        if(arr.length == 0)
            return;
        if(arr[0].length == 0)
            return;
        int[][] Tmatrix = new int[arr.length][arr[0].length];
        for(int i = 0;i < arr.length;i++)
        {
            for(int j = 0;j < arr[0].length;j++)
                Tmatrix[j][i] = arr[i][j];
        }
        return;
    }
    public static BigInteger Fibonacci(int n)
    {
        BigInteger[] fib = new BigInteger[n];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        n--;
        if(n <= 1)
            return fib[n];
        for(int i = 2;i <= n;i++)
            fib[i] = fib[i-1].add(fib[i-2]);
        return fib[n];
    }
    public static void main(String[] args) {
    }
}
