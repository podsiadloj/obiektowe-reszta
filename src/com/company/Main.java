package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class Main {

    private static class Coin {
        int value;
        boolean canMakeChange;

        Coin(int value, boolean canMakeChange){
            this.value = value;
            this.canMakeChange = canMakeChange;
        }
    }

    private static Coin[] values = {
        new Coin(200, false),
        new Coin(100, false),
        new Coin(50, false),
        new Coin(20, true),
        new Coin(10, true),
        new Coin(5, true),
        new Coin(2, true),
        new Coin(1, true)
    };

    private static ArrayList<Integer> processPayment(int price, int[] payment){
        int remaining = price;
        ArrayList<Integer> overpaid = new ArrayList<>();
        Arrays.sort(payment);
        for (int i = (payment.length - 1); i >= 0; i--) {
            if(payment[i] <= remaining){
                remaining -= payment[i];
            } else {
                overpaid.add(payment[i]);
            }
        }
        for (Integer o : overpaid) {
            if(getCoin(o).canMakeChange){
                overpaid.remove(o);
                overpaid.addAll(change(o, remaining));
                break;
            }
        }
        return overpaid;
    }

    private static Coin getCoin(int value){
        for (Coin coin : values) {
            if(coin.value == value){return coin;}
        }
        return null;
    }

    private static  ArrayList<Integer> change(Integer i, int remainder){
        int remaining = i - remainder;
        ArrayList<Integer> result = new ArrayList<>();
        for (Coin coin : values) {
            while(coin.value <= remaining){
                result.add(coin.value);
                remaining -= coin.value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] payment = {50, 50, 20, 20, 1};
        int price = 124;
        System.out.println(processPayment(price, payment));
    }
}
