package com.TestRunner.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.*;

public class Ques3 {
    public static void main(String[] args) {
        String x = "bbcca";//b2a2c2
        //output a2b2c1
        int count = 0;
        Map<Character, Integer> opt = new LinkedHashMap<>();
        for (int i = 0; i < x.length(); i++) {
            if (opt.containsKey(x.charAt(i))) {
                opt.put(x.charAt(i), opt.get(x.charAt(i)) + 1);
            } else {
                opt.put(x.charAt(i), 1);
            }
        }
        System.out.println(opt);
    }
}
