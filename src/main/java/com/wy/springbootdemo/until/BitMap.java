package com.wy.springbootdemo.until;



public class BitMap {

    private final long[] bitmap;

    public BitMap() {
        bitmap = new long[1024];
    }

    public  BitMap(int max){
        bitmap = new long[ ( max + 64 ) >> 6];

    }

    public void add(int num){
        bitmap[num >> 6] |= (1L << (num & 63));
    }

    public void delete(int num){
        bitmap[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num){
        return  ( bitmap[num >>  6] & (1 << num & 63)) != 0 ;
    }

}
