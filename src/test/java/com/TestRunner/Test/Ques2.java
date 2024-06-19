package com.TestRunner.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ques2 {
        public  static  void main(String[] args){
            /*
            Find the maximum number of possible combination among the given list
            using bell number concept
             */
            int n=9;
            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
                if(n>1) {
                    arr1.add(1);
                    int i=1;
                        for (int j = 1; j <n; j++) {
                            arr2.add(arr1.get(arr1.size() - 1));// expecting last element off array
                            arr2.add(arr2.get(arr2.size()-1) + arr1.get(arr2.size()-1));
                            while(arr2.size()<=arr1.size()){
                                arr2.add(arr2.get(arr2.size()-1) + arr1.get(arr2.size()-1));
                            }
                            arr1.clear();
                            arr1.addAll(arr2);
                            arr2.clear();
                        }
                    System.out.println("Combinations will be : "+(arr1.get(arr1.size()-1)));
                }
                else if (n==1){
                    System.out.println("Combinations will be :"+ n);
                }
                else if(n==0){
                    System.out.println("Combinations will be :"+ n);
                }
                else {
                    System.out.println("Invalid number");
                }
        }


}
