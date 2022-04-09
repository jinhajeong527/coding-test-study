package com.jjh.study.leet.easy.dynamic;
//Counting Bits
public class CountingBits {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i=0; i<=n; i++) {
            bits[i] = Integer.bitCount(i);
        }
        return bits;
    }
}
