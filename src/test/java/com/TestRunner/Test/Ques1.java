package com.TestRunner.Test;

import java.util.*;

public class Ques1
{
    public  static  void main(String[] args){
         int bag=4;
         int[] p={1050,2800,4000};
         int[] w={1,3,4};
         /*
         output :
         what max prize can be accomodate into bag of size 4
          */
        Map<Integer,Integer> pw=new LinkedHashMap<>();
        for(int i=0;i<p.length;i++) {
            pw.put(w[i],p[i]);
        }
        //System.out.println("Hashmap : "+pw);
            //[1,1050     3,2000     4,3000]
        int x=0;
        ArrayList<Integer> sum= new ArrayList<>();
        ArrayList<Map.Entry<Integer,Integer>> entryList= new ArrayList<>(pw.entrySet()) ;
        //System.out.println("Main: "+entryList);
        while(x<entryList.size()) { //x=0,1,2  <3
            for (int j = 0; j < entryList.size(); j++) { //j=0,1,2
                if (x == j) {
                    if(bag==w[j]){
                        sum.add(pw.get(bag));
                    }
                    continue;
                } else if (bag == w[x] + w[j]) {
                    Map.Entry<Integer, Integer> entry = entryList.get(x);//1
                    Integer key = entry.getKey();
                    Map.Entry<Integer, Integer> entry1 = entryList.get(j);
                    Integer key1 = entry1.getKey();
                    sum.add(pw.get(key) + pw.get(key1));
                }
            }
            x++;
        }
        // Remove duplicate
        for(int k=0;k<sum.size();k++){
            if(sum.get(k) == sum.get(sum.size()-1)){
                sum.remove(k);
            }
        }
        System.out.println("Sum is :"+sum);
        //Check for greater number
        int x1=sum.get(0);
        for(int z=0;z<sum.size();z++){
            if (x1<sum.get(z)) {
                x1=sum.get(z);
            }
        }
        System.out.println("Thief can accomodate :"+ x1);
    }
}
