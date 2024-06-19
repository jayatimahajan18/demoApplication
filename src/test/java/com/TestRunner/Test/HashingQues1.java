package com.TestRunner.Test;

import com.microsoft.schemas.office.x2006.encryption.STSaltSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashingQues1{
    public static void main(String[] args){
        HashingQues1 has = new HashingQues1();
        //has.hashing();
        has.itineary();

    }
    public  void hashing(){
        int[] arr={1,2};
        //output : that number whose occurences are greater than size/3 using hashmap or hashset
        Map<Integer,Integer> map= new HashMap<>();
        int n= (arr.length)/3;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        System.out.println(map);
        for(int key: map.keySet()){
            if(map.get(key)>n){
                System.out.println(key);
            }

        }
    }
    public void unionOfArrays(){
        int[] arr1={1,1,3,0};
        int[] arr2={1,3,5};
        //output : {1,2,3,4,5}  it means common element should not repeat and rest other element occurs
        Map<Integer,Integer> map= new HashMap<>();
        for( int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],1);
            }
            else{
                map.put(arr1[i],0);
            }
        }
        for(int j=0;j<arr2.length;j++){//1,2,3
            if(map.containsKey(arr2[j])){
                continue;
            }
            else{
                map.put(arr2[j],0);
            }
        }
        System.out.println(map.keySet());
    }
    public void intersectionOfArray(){
        int[] arr1={7,3,9,6,2};
        int[] arr2={6,3,9,2,9,4};
        //output: expecting common element present in both the arrays {3,9}
        HashSet<Integer> set= new HashSet<>();
        HashSet<Integer> set1= new HashSet<>();
        for( int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for( int j=0;j<arr2.length;j++){
            if(set.contains(arr2[j])){
                set1.add(arr2[j]);
            }
            else {
                set.add(arr2[j]);
            }
        }
        System.out.println(set1);
    }

    public void itineary(){
        //Having multiple flights from 1D to 1A
        //Create itineary from them : mumbai-> delhi->goa->chennai->bangalore
        Map<String,String> map= new HashMap<>();
        map.put("Chennai","Bangalore");
        map.put("Mumbai","Delhi");
        map.put("Goa","Mumbai");
        map.put("Bangalore","Goa");
        int flag=0;
        ArrayList<String> itineary= new ArrayList<>(); // mumbai, delhi
        for (String key: map.keySet()) {
                for(int i=0;i<map.size();i++) {
                    if (map.containsValue(key)) {
                        flag=flag+1;
                        break;
                    }
                }
            if(flag<=0){
                itineary.add(key);
                itineary.add(map.get(key));
                break;
            }
            flag=0;
        }
        for(int j=0;j<map.size();j++){
            if(map.containsKey(itineary.get(itineary.size()-1))){
                itineary.add(map.get(itineary.get(itineary.size()-1)));
            }
        }
        System.out.println(itineary);

    }
}
