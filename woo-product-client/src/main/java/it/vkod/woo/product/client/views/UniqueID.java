package it.vkod.woo.product.client.views;

public class UniqueID {
    static long current= System.currentTimeMillis();
    static public synchronized long get(){
        return current++;
    }
}