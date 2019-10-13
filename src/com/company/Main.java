package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class Main {

    Coin[] values = {
        new Coin(200, false),
        new Coin(100, false),
        new Coin(50, false),
        new Coin(20, true),
        new Coin(10, true),
        new Coin(5, true),
        new Coin(2, true),
        new Coin(1, true)
    };

    Coin getCoin(int value){
        for (Coin coin : values) {
            if(coin.value == value){return coin;}
        }
        return null;
    }

    public static void main(String[] args) {

    }

    int[] change(int price, int[] payment){
        int remaining = price;
        ArrayList<Integer> overpaid = new ArrayList<>();
        Arrays.sort(payment);
        for (int i = (payment.length - 1); i >= 0; i--) {
            if(payment[i] <= remaining){
                remaining -= payment[i];
            } else {

            }
        }

    }

    class coinComparator implements Comparator<Coin>{
        @Override
        public int compare(Coin a, Coin b){
            return a.value - b.value;
        }
    }



    class Coin {
        public int value;
        public boolean canMakeChange;

        Coin(int value, boolean canMakeChange){
            this.value = value;
            this.canMakeChange = canMakeChange;
        }
    }
}
