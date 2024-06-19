package com.TestRunner.Test;

import java.util.HashMap;
import java.util.Map;

public class Que3 {
    public static void main(String[] args) {
        String x = "Selenium";
        int count = 0;
        int res[] = new int[x.length()];
        for (int i = 0; i < x.length(); i++) {
            for (int j = 0; j < x.length(); j++) {
                if ((x.charAt(i) == (x.charAt(j)))) {
                    count++;
                }
            }
            res[i]=count;
            count = 0;
        }

        for (int i = 0; i < x.length(); i++) {
                System.out.println(x.charAt(i) + ": " + res[i]);
        }

    }
}